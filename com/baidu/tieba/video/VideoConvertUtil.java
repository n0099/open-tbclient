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
import org.apache.http.protocol.HTTP;
/* loaded from: classes.dex */
public class VideoConvertUtil {
    private IVideoConvertService iVb;
    private String iVc;
    private String iVd;
    private File iVe;
    private File iVf;
    private d iVg;
    private Context mContext;
    public static final String iUO = c.iUJ;
    private static final String TAG = VideoConvertUtil.class.getSimpleName();
    private int iVi = -3;
    private boolean iVj = false;
    private boolean iVk = false;
    private int iVl = 1;
    private ServiceConnection iVm = new ServiceConnection() { // from class: com.baidu.tieba.video.VideoConvertUtil.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            VideoConvertUtil.this.iVb = IVideoConvertService.Stub.asInterface(iBinder);
            if (VideoConvertUtil.this.iVk) {
                VideoConvertUtil.this.ciK();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            if (VideoConvertUtil.this.iVk) {
                if (!VideoConvertUtil.this.iVj && VideoConvertUtil.this.iVi == -3 && VideoConvertUtil.this.iVg != null) {
                    VideoConvertUtil.this.iVg.onConvertFailed();
                }
                VideoConvertUtil.this.iVk = false;
            }
            VideoConvertUtil.this.iVb = null;
        }
    };
    private IntenalConvertListener iVh = new IntenalConvertListener();

    public VideoConvertUtil(Context context) {
        this.mContext = context;
    }

    public void setConvertType(int i) {
        this.iVl = i;
    }

    public void destroy() {
        this.iVj = true;
        abortConvert();
        ciJ();
    }

    private void startService() {
        if (this.mContext != null) {
            Intent intent = new Intent("com.baidu.tieba.video.convert.VideoConvertService");
            intent.setPackage("com.baidu.tieba");
            this.mContext.startService(intent);
        }
    }

    private void ave() {
        if (this.mContext != null) {
            Intent intent = new Intent("com.baidu.tieba.video.convert.VideoConvertService");
            intent.setPackage("com.baidu.tieba");
            this.mContext.bindService(intent, this.iVm, 1);
        }
    }

    private void ciJ() {
        if (this.iVb != null && this.mContext != null) {
            this.mContext.unbindService(this.iVm);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ciK() {
        int i = -1;
        try {
            this.iVb.setIVideoConvertListener(this.iVh);
            this.iVb.setConvertType(this.iVl);
            i = this.iVb.doConvert(this.iVc, this.iVd);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        if (this.iVg != null) {
            if (i == 0) {
                this.iVg.ciH();
            } else {
                this.iVg.An(i);
            }
        }
    }

    public void ec(String str, String str2) {
        this.iVk = true;
        this.iVj = false;
        this.iVi = -3;
        this.iVc = str;
        this.iVd = str2;
        this.iVe = new File(this.iVc);
        this.iVf = new File(this.iVd);
        if (this.iVb == null) {
            startService();
            ave();
            return;
        }
        ciK();
    }

    public boolean isConvertRunning() {
        try {
            if (this.iVb != null) {
                if (this.iVb.isConvertRunning()) {
                    return true;
                }
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void abortConvert() {
        if (this.iVb != null) {
            try {
                this.iVb.abortConvert();
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
            VideoConvertUtil.this.iVi = 1;
            if (VideoConvertUtil.this.iVg != null) {
                VideoConvertUtil.this.iVg.onConvertSuccess();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertFailed() throws RemoteException {
            if (VideoConvertUtil.this.iVg != null) {
                VideoConvertUtil.this.iVg.onConvertFailed();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertProgress(int i) throws RemoteException {
            if (VideoConvertUtil.this.iVg != null) {
                VideoConvertUtil.this.iVg.onConvertProgress(i);
            }
            if ((VideoConvertUtil.this.iVe != null && !VideoConvertUtil.this.iVe.exists()) || (VideoConvertUtil.this.iVf != null && !VideoConvertUtil.this.iVf.exists())) {
                VideoConvertUtil.this.abortConvert();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertAborted() throws RemoteException {
            if (VideoConvertUtil.this.iVg != null) {
                VideoConvertUtil.this.iVg.onConvertAborted();
            }
        }
    }

    public void a(d dVar) {
        this.iVg = dVar;
    }

    public static String Dt(String str) {
        if (str == null || str.isEmpty()) {
            return "";
        }
        try {
            byte[] digest = MessageDigest.getInstance("MD5").digest(str.getBytes(HTTP.UTF_8));
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
    public static int Du(String str) {
        int i = 0;
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            try {
                mediaMetadataRetriever.setDataSource(str);
                i = com.baidu.adp.lib.g.b.l(mediaMetadataRetriever.extractMetadata(20), 0);
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

    public static boolean ciL() {
        File file = new File(iUO);
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
