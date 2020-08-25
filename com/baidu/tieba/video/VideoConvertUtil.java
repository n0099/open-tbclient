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
/* loaded from: classes2.dex */
public class VideoConvertUtil {
    private Context mContext;
    private IVideoConvertService mtO;
    private String mtP;
    private String mtQ;
    private File mtR;
    private File mtS;
    private d mtT;
    public static final String mtF = c.mtA;
    private static final String TAG = VideoConvertUtil.class.getSimpleName();
    private int mtV = -3;
    private boolean mtW = false;
    private boolean mtX = false;
    private int mtY = 1;
    private ServiceConnection mtZ = new ServiceConnection() { // from class: com.baidu.tieba.video.VideoConvertUtil.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            VideoConvertUtil.this.mtO = IVideoConvertService.Stub.asInterface(iBinder);
            if (VideoConvertUtil.this.mtX) {
                VideoConvertUtil.this.dAT();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            if (VideoConvertUtil.this.mtX) {
                if (!VideoConvertUtil.this.mtW && VideoConvertUtil.this.mtV == -3 && VideoConvertUtil.this.mtT != null) {
                    VideoConvertUtil.this.mtT.onConvertFailed();
                }
                VideoConvertUtil.this.mtX = false;
            }
            VideoConvertUtil.this.mtO = null;
        }
    };
    private IntenalConvertListener mtU = new IntenalConvertListener();

    public VideoConvertUtil(Context context) {
        this.mContext = context;
    }

    public void setConvertType(int i) {
        this.mtY = i;
    }

    public void destroy() {
        this.mtW = true;
        abortConvert();
        dAS();
    }

    private void startService() {
        if (this.mContext != null) {
            Intent intent = new Intent("com.baidu.tieba.video.convert.VideoConvertService");
            intent.setPackage("com.baidu.tieba");
            this.mContext.startService(intent);
        }
    }

    private void dAR() {
        if (this.mContext != null) {
            Intent intent = new Intent("com.baidu.tieba.video.convert.VideoConvertService");
            intent.setPackage("com.baidu.tieba");
            this.mContext.bindService(intent, this.mtZ, 1);
        }
    }

    private void dAS() {
        if (this.mtO != null && this.mContext != null) {
            this.mContext.unbindService(this.mtZ);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dAT() {
        int i = -1;
        try {
            this.mtO.setIVideoConvertListener(this.mtU);
            this.mtO.setConvertType(this.mtY);
            i = this.mtO.doConvert(this.mtP, this.mtQ);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        if (this.mtT != null) {
            if (i == 0) {
                this.mtT.dAP();
            } else {
                this.mtT.IJ(i);
            }
        }
    }

    public void fW(String str, String str2) {
        this.mtX = true;
        this.mtW = false;
        this.mtV = -3;
        this.mtP = str;
        this.mtQ = str2;
        this.mtR = new File(this.mtP);
        this.mtS = new File(this.mtQ);
        if (this.mtO == null) {
            startService();
            dAR();
            return;
        }
        dAT();
    }

    public boolean isConvertRunning() {
        try {
            if (this.mtO != null) {
                if (this.mtO.isConvertRunning()) {
                    return true;
                }
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void abortConvert() {
        if (this.mtO != null) {
            try {
                this.mtO.abortConvert();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class IntenalConvertListener extends IVideoConvertListener.Stub {
        private IntenalConvertListener() {
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertSuccess() throws RemoteException {
            VideoConvertUtil.this.mtV = 1;
            if (VideoConvertUtil.this.mtT != null) {
                VideoConvertUtil.this.mtT.onConvertSuccess();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertFailed() throws RemoteException {
            if (VideoConvertUtil.this.mtT != null) {
                VideoConvertUtil.this.mtT.onConvertFailed();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertProgress(int i) throws RemoteException {
            if (VideoConvertUtil.this.mtT != null) {
                VideoConvertUtil.this.mtT.onConvertProgress(i);
            }
            if ((VideoConvertUtil.this.mtR != null && !VideoConvertUtil.this.mtR.exists()) || (VideoConvertUtil.this.mtS != null && !VideoConvertUtil.this.mtS.exists())) {
                VideoConvertUtil.this.abortConvert();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertAborted() throws RemoteException {
            if (VideoConvertUtil.this.mtT != null) {
                VideoConvertUtil.this.mtT.onConvertAborted();
            }
        }
    }

    public void a(d dVar) {
        this.mtT = dVar;
    }

    public static String RA(String str) {
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
    public static int RB(String str) {
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

    public static boolean dAU() {
        File file = new File(mtF);
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
