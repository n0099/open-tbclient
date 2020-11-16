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
    private IVideoConvertService nni;
    private String nnj;
    private String nnk;
    private File nnl;
    private File nnm;
    private d nnn;
    public static final String nmZ = c.nmU;
    private static final String TAG = VideoConvertUtil.class.getSimpleName();
    private int nnp = -3;
    private boolean nnq = false;
    private boolean nnr = false;
    private int nns = 1;
    private ServiceConnection nnt = new ServiceConnection() { // from class: com.baidu.tieba.video.VideoConvertUtil.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            VideoConvertUtil.this.nni = IVideoConvertService.Stub.asInterface(iBinder);
            if (VideoConvertUtil.this.nnr) {
                VideoConvertUtil.this.dOr();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            if (VideoConvertUtil.this.nnr) {
                if (!VideoConvertUtil.this.nnq && VideoConvertUtil.this.nnp == -3 && VideoConvertUtil.this.nnn != null) {
                    VideoConvertUtil.this.nnn.onConvertFailed();
                }
                VideoConvertUtil.this.nnr = false;
            }
            VideoConvertUtil.this.nni = null;
        }
    };
    private IntenalConvertListener nno = new IntenalConvertListener();

    public VideoConvertUtil(Context context) {
        this.mContext = context;
    }

    public void setConvertType(int i) {
        this.nns = i;
    }

    public void destroy() {
        this.nnq = true;
        abortConvert();
        dOq();
    }

    private void startService() {
        if (this.mContext != null) {
            Intent intent = new Intent("com.baidu.tieba.video.convert.VideoConvertService");
            intent.setPackage("com.baidu.tieba");
            this.mContext.startService(intent);
        }
    }

    private void dOp() {
        if (this.mContext != null) {
            Intent intent = new Intent("com.baidu.tieba.video.convert.VideoConvertService");
            intent.setPackage("com.baidu.tieba");
            this.mContext.bindService(intent, this.nnt, 1);
        }
    }

    private void dOq() {
        if (this.nni != null && this.mContext != null) {
            this.mContext.unbindService(this.nnt);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dOr() {
        int i = -1;
        try {
            this.nni.setIVideoConvertListener(this.nno);
            this.nni.setConvertType(this.nns);
            i = this.nni.doConvert(this.nnj, this.nnk);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        if (this.nnn != null) {
            if (i == 0) {
                this.nnn.dOn();
            } else {
                this.nnn.Lb(i);
            }
        }
    }

    public void gv(String str, String str2) {
        this.nnr = true;
        this.nnq = false;
        this.nnp = -3;
        this.nnj = str;
        this.nnk = str2;
        this.nnl = new File(this.nnj);
        this.nnm = new File(this.nnk);
        if (this.nni == null) {
            startService();
            dOp();
            return;
        }
        dOr();
    }

    public boolean isConvertRunning() {
        try {
            if (this.nni != null) {
                if (this.nni.isConvertRunning()) {
                    return true;
                }
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void abortConvert() {
        if (this.nni != null) {
            try {
                this.nni.abortConvert();
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
            VideoConvertUtil.this.nnp = 1;
            if (VideoConvertUtil.this.nnn != null) {
                VideoConvertUtil.this.nnn.onConvertSuccess();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertFailed() throws RemoteException {
            if (VideoConvertUtil.this.nnn != null) {
                VideoConvertUtil.this.nnn.onConvertFailed();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertProgress(int i) throws RemoteException {
            if (VideoConvertUtil.this.nnn != null) {
                VideoConvertUtil.this.nnn.onConvertProgress(i);
            }
            if ((VideoConvertUtil.this.nnl != null && !VideoConvertUtil.this.nnl.exists()) || (VideoConvertUtil.this.nnm != null && !VideoConvertUtil.this.nnm.exists())) {
                VideoConvertUtil.this.abortConvert();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertAborted() throws RemoteException {
            if (VideoConvertUtil.this.nnn != null) {
                VideoConvertUtil.this.nnn.onConvertAborted();
            }
        }
    }

    public void a(d dVar) {
        this.nnn = dVar;
    }

    public static String Tp(String str) {
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
    public static int Tq(String str) {
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

    public static boolean dOs() {
        File file = new File(nmZ);
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
