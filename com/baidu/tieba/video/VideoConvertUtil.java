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
    private IVideoConvertService gWD;
    private String gWE;
    private String gWF;
    private File gWG;
    private File gWH;
    private c gWI;
    private Context mContext;
    public static final String gWq = b.gWl;
    private static final String TAG = VideoConvertUtil.class.getSimpleName();
    private int gWK = -3;
    private boolean gWL = false;
    private boolean gWM = false;
    private int gWN = 1;
    private ServiceConnection gWO = new ServiceConnection() { // from class: com.baidu.tieba.video.VideoConvertUtil.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            VideoConvertUtil.this.gWD = IVideoConvertService.Stub.asInterface(iBinder);
            if (VideoConvertUtil.this.gWM) {
                VideoConvertUtil.this.bAZ();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            if (VideoConvertUtil.this.gWM) {
                if (!VideoConvertUtil.this.gWL && VideoConvertUtil.this.gWK == -3 && VideoConvertUtil.this.gWI != null) {
                    VideoConvertUtil.this.gWI.onConvertFailed();
                }
                VideoConvertUtil.this.gWM = false;
            }
            VideoConvertUtil.this.gWD = null;
        }
    };
    private IntenalConvertListener gWJ = new IntenalConvertListener();

    public VideoConvertUtil(Context context) {
        this.mContext = context;
    }

    public void setConvertType(int i) {
        this.gWN = i;
    }

    public void destroy() {
        this.gWL = true;
        abortConvert();
        bAY();
    }

    private void startService() {
        if (this.mContext != null) {
            Intent intent = new Intent("com.baidu.tieba.video.convert.VideoConvertService");
            intent.setPackage("com.baidu.tieba");
            this.mContext.startService(intent);
        }
    }

    private void OZ() {
        if (this.mContext != null) {
            Intent intent = new Intent("com.baidu.tieba.video.convert.VideoConvertService");
            intent.setPackage("com.baidu.tieba");
            this.mContext.bindService(intent, this.gWO, 1);
        }
    }

    private void bAY() {
        if (this.gWD != null && this.mContext != null) {
            this.mContext.unbindService(this.gWO);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bAZ() {
        int i = -1;
        try {
            this.gWD.setIVideoConvertListener(this.gWJ);
            this.gWD.setConvertType(this.gWN);
            i = this.gWD.doConvert(this.gWE, this.gWF);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        if (this.gWI != null) {
            if (i == 0) {
                this.gWI.bAW();
            } else {
                this.gWI.ur(i);
            }
        }
    }

    public void cp(String str, String str2) {
        this.gWM = true;
        this.gWL = false;
        this.gWK = -3;
        this.gWE = str;
        this.gWF = str2;
        this.gWG = new File(this.gWE);
        this.gWH = new File(this.gWF);
        if (this.gWD == null) {
            startService();
            OZ();
            return;
        }
        bAZ();
    }

    public boolean isConvertRunning() {
        try {
            if (this.gWD != null) {
                if (this.gWD.isConvertRunning()) {
                    return true;
                }
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void abortConvert() {
        if (this.gWD != null) {
            try {
                this.gWD.abortConvert();
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
            VideoConvertUtil.this.gWK = 1;
            if (VideoConvertUtil.this.gWI != null) {
                VideoConvertUtil.this.gWI.onConvertSuccess();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertFailed() throws RemoteException {
            if (VideoConvertUtil.this.gWI != null) {
                VideoConvertUtil.this.gWI.onConvertFailed();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertProgress(int i) throws RemoteException {
            if (VideoConvertUtil.this.gWI != null) {
                VideoConvertUtil.this.gWI.onConvertProgress(i);
            }
            if ((VideoConvertUtil.this.gWG != null && !VideoConvertUtil.this.gWG.exists()) || (VideoConvertUtil.this.gWH != null && !VideoConvertUtil.this.gWH.exists())) {
                VideoConvertUtil.this.abortConvert();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertAborted() throws RemoteException {
            if (VideoConvertUtil.this.gWI != null) {
                VideoConvertUtil.this.gWI.onConvertAborted();
            }
        }
    }

    public void a(c cVar) {
        this.gWI = cVar;
    }

    public static String uG(String str) {
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
    public static int uH(String str) {
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

    public static boolean bBa() {
        File file = new File(gWq);
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
