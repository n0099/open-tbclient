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
    private IVideoConvertService lzT;
    private String lzU;
    private String lzV;
    private File lzW;
    private File lzX;
    private d lzY;
    private Context mContext;
    public static final String lzK = c.lzF;
    private static final String TAG = VideoConvertUtil.class.getSimpleName();
    private int lAa = -3;
    private boolean lAb = false;
    private boolean lAc = false;
    private int lAd = 1;
    private ServiceConnection lAe = new ServiceConnection() { // from class: com.baidu.tieba.video.VideoConvertUtil.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            VideoConvertUtil.this.lzT = IVideoConvertService.Stub.asInterface(iBinder);
            if (VideoConvertUtil.this.lAc) {
                VideoConvertUtil.this.dhI();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            if (VideoConvertUtil.this.lAc) {
                if (!VideoConvertUtil.this.lAb && VideoConvertUtil.this.lAa == -3 && VideoConvertUtil.this.lzY != null) {
                    VideoConvertUtil.this.lzY.onConvertFailed();
                }
                VideoConvertUtil.this.lAc = false;
            }
            VideoConvertUtil.this.lzT = null;
        }
    };
    private IntenalConvertListener lzZ = new IntenalConvertListener();

    public VideoConvertUtil(Context context) {
        this.mContext = context;
    }

    public void setConvertType(int i) {
        this.lAd = i;
    }

    public void destroy() {
        this.lAb = true;
        abortConvert();
        dhH();
    }

    private void startService() {
        if (this.mContext != null) {
            Intent intent = new Intent("com.baidu.tieba.video.convert.VideoConvertService");
            intent.setPackage("com.baidu.tieba");
            this.mContext.startService(intent);
        }
    }

    private void bkV() {
        if (this.mContext != null) {
            Intent intent = new Intent("com.baidu.tieba.video.convert.VideoConvertService");
            intent.setPackage("com.baidu.tieba");
            this.mContext.bindService(intent, this.lAe, 1);
        }
    }

    private void dhH() {
        if (this.lzT != null && this.mContext != null) {
            this.mContext.unbindService(this.lAe);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dhI() {
        int i = -1;
        try {
            this.lzT.setIVideoConvertListener(this.lzZ);
            this.lzT.setConvertType(this.lAd);
            i = this.lzT.doConvert(this.lzU, this.lzV);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        if (this.lzY != null) {
            if (i == 0) {
                this.lzY.dhF();
            } else {
                this.lzY.EN(i);
            }
        }
    }

    public void fw(String str, String str2) {
        this.lAc = true;
        this.lAb = false;
        this.lAa = -3;
        this.lzU = str;
        this.lzV = str2;
        this.lzW = new File(this.lzU);
        this.lzX = new File(this.lzV);
        if (this.lzT == null) {
            startService();
            bkV();
            return;
        }
        dhI();
    }

    public boolean isConvertRunning() {
        try {
            if (this.lzT != null) {
                if (this.lzT.isConvertRunning()) {
                    return true;
                }
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void abortConvert() {
        if (this.lzT != null) {
            try {
                this.lzT.abortConvert();
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
            VideoConvertUtil.this.lAa = 1;
            if (VideoConvertUtil.this.lzY != null) {
                VideoConvertUtil.this.lzY.onConvertSuccess();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertFailed() throws RemoteException {
            if (VideoConvertUtil.this.lzY != null) {
                VideoConvertUtil.this.lzY.onConvertFailed();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertProgress(int i) throws RemoteException {
            if (VideoConvertUtil.this.lzY != null) {
                VideoConvertUtil.this.lzY.onConvertProgress(i);
            }
            if ((VideoConvertUtil.this.lzW != null && !VideoConvertUtil.this.lzW.exists()) || (VideoConvertUtil.this.lzX != null && !VideoConvertUtil.this.lzX.exists())) {
                VideoConvertUtil.this.abortConvert();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertAborted() throws RemoteException {
            if (VideoConvertUtil.this.lzY != null) {
                VideoConvertUtil.this.lzY.onConvertAborted();
            }
        }
    }

    public void a(d dVar) {
        this.lzY = dVar;
    }

    public static String Nr(String str) {
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
    public static int Ns(String str) {
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

    public static boolean dhJ() {
        File file = new File(lzK);
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
