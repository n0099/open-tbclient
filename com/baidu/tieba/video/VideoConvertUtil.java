package com.baidu.tieba.video;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.media.MediaMetadataRetriever;
import android.os.IBinder;
import android.os.RemoteException;
import com.baidu.minivideo.plugin.capture.utils.EncryptUtils;
import com.baidu.tieba.video.convert.IVideoConvertListener;
import com.baidu.tieba.video.convert.IVideoConvertService;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes.dex */
public class VideoConvertUtil {
    private Context mContext;
    private String nKA;
    private String nKB;
    private File nKC;
    private File nKD;
    private d nKE;
    private IVideoConvertService nKz;
    public static final String nKy = c.nKm;
    private static final String TAG = VideoConvertUtil.class.getSimpleName();
    private int nKG = -3;
    private boolean nKH = false;
    private boolean nKI = false;
    private int nKJ = 1;
    private ServiceConnection nKK = new ServiceConnection() { // from class: com.baidu.tieba.video.VideoConvertUtil.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            VideoConvertUtil.this.nKz = IVideoConvertService.Stub.asInterface(iBinder);
            if (VideoConvertUtil.this.nKI) {
                VideoConvertUtil.this.dRV();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            if (VideoConvertUtil.this.nKI) {
                if (!VideoConvertUtil.this.nKH && VideoConvertUtil.this.nKG == -3 && VideoConvertUtil.this.nKE != null) {
                    VideoConvertUtil.this.nKE.onConvertFailed();
                }
                VideoConvertUtil.this.nKI = false;
            }
            VideoConvertUtil.this.nKz = null;
        }
    };
    private IntenalConvertListener nKF = new IntenalConvertListener();

    public VideoConvertUtil(Context context) {
        this.mContext = context;
    }

    public void setConvertType(int i) {
        this.nKJ = i;
    }

    public void destroy() {
        this.nKH = true;
        abortConvert();
        dRU();
    }

    private void startService() {
        if (this.mContext != null) {
            Intent intent = new Intent("com.baidu.tieba.video.convert.VideoConvertService");
            intent.setPackage("com.baidu.tieba");
            this.mContext.startService(intent);
        }
    }

    private void dRT() {
        if (this.mContext != null) {
            Intent intent = new Intent("com.baidu.tieba.video.convert.VideoConvertService");
            intent.setPackage("com.baidu.tieba");
            this.mContext.bindService(intent, this.nKK, 1);
        }
    }

    private void dRU() {
        if (this.nKz != null && this.mContext != null) {
            this.mContext.unbindService(this.nKK);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dRV() {
        int i = -1;
        try {
            this.nKz.setIVideoConvertListener(this.nKF);
            this.nKz.setConvertType(this.nKJ);
            i = this.nKz.doConvert(this.nKA, this.nKB);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        if (this.nKE != null) {
            if (i == 0) {
                this.nKE.dRR();
            } else {
                this.nKE.Ku(i);
            }
        }
    }

    public void gC(String str, String str2) {
        this.nKI = true;
        this.nKH = false;
        this.nKG = -3;
        this.nKA = str;
        this.nKB = str2;
        this.nKC = new File(this.nKA);
        this.nKD = new File(this.nKB);
        if (this.nKz == null) {
            startService();
            dRT();
            return;
        }
        dRV();
    }

    public boolean isConvertRunning() {
        try {
            if (this.nKz != null) {
                if (this.nKz.isConvertRunning()) {
                    return true;
                }
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void abortConvert() {
        if (this.nKz != null) {
            try {
                this.nKz.abortConvert();
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
            VideoConvertUtil.this.nKG = 1;
            if (VideoConvertUtil.this.nKE != null) {
                VideoConvertUtil.this.nKE.onConvertSuccess();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertFailed() throws RemoteException {
            if (VideoConvertUtil.this.nKE != null) {
                VideoConvertUtil.this.nKE.onConvertFailed();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertProgress(int i) throws RemoteException {
            if (VideoConvertUtil.this.nKE != null) {
                VideoConvertUtil.this.nKE.onConvertProgress(i);
            }
            if ((VideoConvertUtil.this.nKC != null && !VideoConvertUtil.this.nKC.exists()) || (VideoConvertUtil.this.nKD != null && !VideoConvertUtil.this.nKD.exists())) {
                VideoConvertUtil.this.abortConvert();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertAborted() throws RemoteException {
            if (VideoConvertUtil.this.nKE != null) {
                VideoConvertUtil.this.nKE.onConvertAborted();
            }
        }
    }

    public void a(d dVar) {
        this.nKE = dVar;
    }

    public static String Ua(String str) {
        if (str == null || str.isEmpty()) {
            return "";
        }
        try {
            byte[] digest = MessageDigest.getInstance(EncryptUtils.ENCRYPT_MD5).digest(str.getBytes("UTF-8"));
            StringBuilder sb = new StringBuilder(digest.length * 2);
            for (byte b2 : digest) {
                if ((b2 & 255) < 16) {
                    sb.append("0");
                }
                sb.append(Integer.toHexString(b2 & 255));
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
    public static int Ub(String str) {
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

    public static boolean dRW() {
        File file = new File(nKy);
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
