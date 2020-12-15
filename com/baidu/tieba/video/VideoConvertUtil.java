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
    private IVideoConvertService nBn;
    private String nBo;
    private String nBp;
    private File nBq;
    private File nBr;
    private d nBs;
    public static final String nBe = c.nAZ;
    private static final String TAG = VideoConvertUtil.class.getSimpleName();
    private int nBu = -3;
    private boolean nBv = false;
    private boolean nBw = false;
    private int nBx = 1;
    private ServiceConnection nBy = new ServiceConnection() { // from class: com.baidu.tieba.video.VideoConvertUtil.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            VideoConvertUtil.this.nBn = IVideoConvertService.Stub.asInterface(iBinder);
            if (VideoConvertUtil.this.nBw) {
                VideoConvertUtil.this.dTK();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            if (VideoConvertUtil.this.nBw) {
                if (!VideoConvertUtil.this.nBv && VideoConvertUtil.this.nBu == -3 && VideoConvertUtil.this.nBs != null) {
                    VideoConvertUtil.this.nBs.onConvertFailed();
                }
                VideoConvertUtil.this.nBw = false;
            }
            VideoConvertUtil.this.nBn = null;
        }
    };
    private IntenalConvertListener nBt = new IntenalConvertListener();

    public VideoConvertUtil(Context context) {
        this.mContext = context;
    }

    public void setConvertType(int i) {
        this.nBx = i;
    }

    public void destroy() {
        this.nBv = true;
        abortConvert();
        dTJ();
    }

    private void startService() {
        if (this.mContext != null) {
            Intent intent = new Intent("com.baidu.tieba.video.convert.VideoConvertService");
            intent.setPackage("com.baidu.tieba");
            this.mContext.startService(intent);
        }
    }

    private void dTI() {
        if (this.mContext != null) {
            Intent intent = new Intent("com.baidu.tieba.video.convert.VideoConvertService");
            intent.setPackage("com.baidu.tieba");
            this.mContext.bindService(intent, this.nBy, 1);
        }
    }

    private void dTJ() {
        if (this.nBn != null && this.mContext != null) {
            this.mContext.unbindService(this.nBy);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dTK() {
        int i = -1;
        try {
            this.nBn.setIVideoConvertListener(this.nBt);
            this.nBn.setConvertType(this.nBx);
            i = this.nBn.doConvert(this.nBo, this.nBp);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        if (this.nBs != null) {
            if (i == 0) {
                this.nBs.dTG();
            } else {
                this.nBs.LT(i);
            }
        }
    }

    public void gA(String str, String str2) {
        this.nBw = true;
        this.nBv = false;
        this.nBu = -3;
        this.nBo = str;
        this.nBp = str2;
        this.nBq = new File(this.nBo);
        this.nBr = new File(this.nBp);
        if (this.nBn == null) {
            startService();
            dTI();
            return;
        }
        dTK();
    }

    public boolean isConvertRunning() {
        try {
            if (this.nBn != null) {
                if (this.nBn.isConvertRunning()) {
                    return true;
                }
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void abortConvert() {
        if (this.nBn != null) {
            try {
                this.nBn.abortConvert();
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
            VideoConvertUtil.this.nBu = 1;
            if (VideoConvertUtil.this.nBs != null) {
                VideoConvertUtil.this.nBs.onConvertSuccess();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertFailed() throws RemoteException {
            if (VideoConvertUtil.this.nBs != null) {
                VideoConvertUtil.this.nBs.onConvertFailed();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertProgress(int i) throws RemoteException {
            if (VideoConvertUtil.this.nBs != null) {
                VideoConvertUtil.this.nBs.onConvertProgress(i);
            }
            if ((VideoConvertUtil.this.nBq != null && !VideoConvertUtil.this.nBq.exists()) || (VideoConvertUtil.this.nBr != null && !VideoConvertUtil.this.nBr.exists())) {
                VideoConvertUtil.this.abortConvert();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertAborted() throws RemoteException {
            if (VideoConvertUtil.this.nBs != null) {
                VideoConvertUtil.this.nBs.onConvertAborted();
            }
        }
    }

    public void a(d dVar) {
        this.nBs = dVar;
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

    public static boolean dTL() {
        File file = new File(nBe);
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
