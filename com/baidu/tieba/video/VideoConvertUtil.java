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
    private IVideoConvertService gKb;
    private String gKc;
    private String gKd;
    private File gKe;
    private File gKf;
    private c gKg;
    private Context mContext;
    public static final String gJO = b.gJJ;
    private static final String TAG = VideoConvertUtil.class.getSimpleName();
    private int gKi = -3;
    private boolean gKj = false;
    private boolean gKk = false;
    private int gKl = 1;
    private ServiceConnection gKm = new ServiceConnection() { // from class: com.baidu.tieba.video.VideoConvertUtil.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            VideoConvertUtil.this.gKb = IVideoConvertService.Stub.asInterface(iBinder);
            if (VideoConvertUtil.this.gKk) {
                VideoConvertUtil.this.bvU();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            if (VideoConvertUtil.this.gKk) {
                if (!VideoConvertUtil.this.gKj && VideoConvertUtil.this.gKi == -3 && VideoConvertUtil.this.gKg != null) {
                    VideoConvertUtil.this.gKg.onConvertFailed();
                }
                VideoConvertUtil.this.gKk = false;
            }
            VideoConvertUtil.this.gKb = null;
        }
    };
    private IntenalConvertListener gKh = new IntenalConvertListener();

    public VideoConvertUtil(Context context) {
        this.mContext = context;
    }

    public void setConvertType(int i) {
        this.gKl = i;
    }

    public void destroy() {
        this.gKj = true;
        abortConvert();
        bvT();
    }

    private void startService() {
        if (this.mContext != null) {
            Intent intent = new Intent("com.baidu.tieba.video.convert.VideoConvertService");
            intent.setPackage("com.baidu.tieba");
            this.mContext.startService(intent);
        }
    }

    private void LC() {
        if (this.mContext != null) {
            Intent intent = new Intent("com.baidu.tieba.video.convert.VideoConvertService");
            intent.setPackage("com.baidu.tieba");
            this.mContext.bindService(intent, this.gKm, 1);
        }
    }

    private void bvT() {
        if (this.gKb != null && this.mContext != null) {
            this.mContext.unbindService(this.gKm);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bvU() {
        int i = -1;
        try {
            this.gKb.setIVideoConvertListener(this.gKh);
            this.gKb.setConvertType(this.gKl);
            i = this.gKb.doConvert(this.gKc, this.gKd);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        if (this.gKg != null) {
            if (i == 0) {
                this.gKg.bvR();
            } else {
                this.gKg.uf(i);
            }
        }
    }

    public void ch(String str, String str2) {
        this.gKk = true;
        this.gKj = false;
        this.gKi = -3;
        this.gKc = str;
        this.gKd = str2;
        this.gKe = new File(this.gKc);
        this.gKf = new File(this.gKd);
        if (this.gKb == null) {
            startService();
            LC();
            return;
        }
        bvU();
    }

    public boolean isConvertRunning() {
        try {
            if (this.gKb != null) {
                if (this.gKb.isConvertRunning()) {
                    return true;
                }
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void abortConvert() {
        if (this.gKb != null) {
            try {
                this.gKb.abortConvert();
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
            VideoConvertUtil.this.gKi = 1;
            if (VideoConvertUtil.this.gKg != null) {
                VideoConvertUtil.this.gKg.onConvertSuccess();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertFailed() throws RemoteException {
            if (VideoConvertUtil.this.gKg != null) {
                VideoConvertUtil.this.gKg.onConvertFailed();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertProgress(int i) throws RemoteException {
            if (VideoConvertUtil.this.gKg != null) {
                VideoConvertUtil.this.gKg.onConvertProgress(i);
            }
            if ((VideoConvertUtil.this.gKe != null && !VideoConvertUtil.this.gKe.exists()) || (VideoConvertUtil.this.gKf != null && !VideoConvertUtil.this.gKf.exists())) {
                VideoConvertUtil.this.abortConvert();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertAborted() throws RemoteException {
            if (VideoConvertUtil.this.gKg != null) {
                VideoConvertUtil.this.gKg.onConvertAborted();
            }
        }
    }

    public void a(c cVar) {
        this.gKg = cVar;
    }

    public static String tJ(String str) {
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
    public static int tK(String str) {
        int i = 0;
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            try {
                mediaMetadataRetriever.setDataSource(str);
                i = com.baidu.adp.lib.g.b.g(mediaMetadataRetriever.extractMetadata(20), 0);
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

    public static boolean bvV() {
        File file = new File(gJO);
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
