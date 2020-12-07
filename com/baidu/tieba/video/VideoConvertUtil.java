package com.baidu.tieba.video;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.media.MediaMetadataRetriever;
import android.os.IBinder;
import android.os.RemoteException;
import com.baidu.tieba.video.convert.IVideoConvertListener;
import com.baidu.tieba.video.convert.IVideoConvertService;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes.dex */
public class VideoConvertUtil {
    private Context mContext;
    private IVideoConvertService nBl;
    private String nBm;
    private String nBn;
    private File nBo;
    private File nBp;
    private d nBq;
    public static final String nBc = c.nAX;
    private static final String TAG = VideoConvertUtil.class.getSimpleName();
    private int nBs = -3;
    private boolean nBt = false;
    private boolean nBu = false;
    private int nBv = 1;
    private ServiceConnection nBw = new ServiceConnection() { // from class: com.baidu.tieba.video.VideoConvertUtil.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            VideoConvertUtil.this.nBl = IVideoConvertService.Stub.asInterface(iBinder);
            if (VideoConvertUtil.this.nBu) {
                VideoConvertUtil.this.dTJ();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            if (VideoConvertUtil.this.nBu) {
                if (!VideoConvertUtil.this.nBt && VideoConvertUtil.this.nBs == -3 && VideoConvertUtil.this.nBq != null) {
                    VideoConvertUtil.this.nBq.onConvertFailed();
                }
                VideoConvertUtil.this.nBu = false;
            }
            VideoConvertUtil.this.nBl = null;
        }
    };
    private IntenalConvertListener nBr = new IntenalConvertListener();

    public VideoConvertUtil(Context context) {
        this.mContext = context;
    }

    public void setConvertType(int i) {
        this.nBv = i;
    }

    public void destroy() {
        this.nBt = true;
        abortConvert();
        dTI();
    }

    private void startService() {
        if (this.mContext != null) {
            Intent intent = new Intent("com.baidu.tieba.video.convert.VideoConvertService");
            intent.setPackage("com.baidu.tieba");
            this.mContext.startService(intent);
        }
    }

    private void dTH() {
        if (this.mContext != null) {
            Intent intent = new Intent("com.baidu.tieba.video.convert.VideoConvertService");
            intent.setPackage("com.baidu.tieba");
            this.mContext.bindService(intent, this.nBw, 1);
        }
    }

    private void dTI() {
        if (this.nBl != null && this.mContext != null) {
            this.mContext.unbindService(this.nBw);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dTJ() {
        int i = -1;
        try {
            this.nBl.setIVideoConvertListener(this.nBr);
            this.nBl.setConvertType(this.nBv);
            i = this.nBl.doConvert(this.nBm, this.nBn);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        if (this.nBq != null) {
            if (i == 0) {
                this.nBq.dTF();
            } else {
                this.nBq.LT(i);
            }
        }
    }

    public void gA(String str, String str2) {
        this.nBu = true;
        this.nBt = false;
        this.nBs = -3;
        this.nBm = str;
        this.nBn = str2;
        this.nBo = new File(this.nBm);
        this.nBp = new File(this.nBn);
        if (this.nBl == null) {
            startService();
            dTH();
            return;
        }
        dTJ();
    }

    public boolean isConvertRunning() {
        try {
            if (this.nBl != null) {
                if (this.nBl.isConvertRunning()) {
                    return true;
                }
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void abortConvert() {
        if (this.nBl != null) {
            try {
                this.nBl.abortConvert();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class IntenalConvertListener extends IVideoConvertListener.Stub {
        private IntenalConvertListener() {
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertSuccess() throws RemoteException {
            VideoConvertUtil.this.nBs = 1;
            if (VideoConvertUtil.this.nBq != null) {
                VideoConvertUtil.this.nBq.onConvertSuccess();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertFailed() throws RemoteException {
            if (VideoConvertUtil.this.nBq != null) {
                VideoConvertUtil.this.nBq.onConvertFailed();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertProgress(int i) throws RemoteException {
            if (VideoConvertUtil.this.nBq != null) {
                VideoConvertUtil.this.nBq.onConvertProgress(i);
            }
            if ((VideoConvertUtil.this.nBo != null && !VideoConvertUtil.this.nBo.exists()) || (VideoConvertUtil.this.nBp != null && !VideoConvertUtil.this.nBp.exists())) {
                VideoConvertUtil.this.abortConvert();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertAborted() throws RemoteException {
            if (VideoConvertUtil.this.nBq != null) {
                VideoConvertUtil.this.nBq.onConvertAborted();
            }
        }
    }

    public void a(d dVar) {
        this.nBq = dVar;
    }

    public static String UE(String str) {
        if (str == null || str.isEmpty()) {
            return "";
        }
        try {
            byte[] digest = MessageDigest.getInstance("MD5").digest(str.getBytes("UTF-8"));
            StringBuilder sb = new StringBuilder(digest.length * 2);
            for (byte b : digest) {
                if ((b & 255) < 16) {
                    sb.append("0");
                }
                sb.append(Integer.toHexString(b & 255));
            }
            return sb.toString();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return "";
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[INVOKE, MOVE_EXCEPTION, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
    public static int UF(String str) {
        int i = 0;
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            try {
                mediaMetadataRetriever.setDataSource(str);
                i = com.baidu.adp.lib.f.b.toInt(mediaMetadataRetriever.extractMetadata(20), 0);
            } catch (Exception e) {
                e.printStackTrace();
                try {
                    mediaMetadataRetriever.release();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            return i;
        } finally {
            try {
                mediaMetadataRetriever.release();
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
    }

    public static boolean dTK() {
        File file = new File(nBc);
        if (file != null) {
            if (file.exists() && !file.isDirectory()) {
                file.delete();
            }
            if (!file.exists()) {
                file.mkdirs();
            }
            if (file.exists() && file.isDirectory()) {
                return true;
            }
        }
        return false;
    }
}
