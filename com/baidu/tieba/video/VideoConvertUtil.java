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
    private IVideoConvertService nAP;
    private String nAQ;
    private String nAR;
    private File nAS;
    private File nAT;
    private d nAU;
    public static final String nAO = c.nAC;
    private static final String TAG = VideoConvertUtil.class.getSimpleName();
    private int nAW = -3;
    private boolean nAX = false;
    private boolean nAY = false;
    private int nAZ = 1;
    private ServiceConnection nBa = new ServiceConnection() { // from class: com.baidu.tieba.video.VideoConvertUtil.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            VideoConvertUtil.this.nAP = IVideoConvertService.Stub.asInterface(iBinder);
            if (VideoConvertUtil.this.nAY) {
                VideoConvertUtil.this.dPK();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            if (VideoConvertUtil.this.nAY) {
                if (!VideoConvertUtil.this.nAX && VideoConvertUtil.this.nAW == -3 && VideoConvertUtil.this.nAU != null) {
                    VideoConvertUtil.this.nAU.onConvertFailed();
                }
                VideoConvertUtil.this.nAY = false;
            }
            VideoConvertUtil.this.nAP = null;
        }
    };
    private IntenalConvertListener nAV = new IntenalConvertListener();

    public VideoConvertUtil(Context context) {
        this.mContext = context;
    }

    public void setConvertType(int i) {
        this.nAZ = i;
    }

    public void destroy() {
        this.nAX = true;
        abortConvert();
        dPJ();
    }

    private void startService() {
        if (this.mContext != null) {
            Intent intent = new Intent("com.baidu.tieba.video.convert.VideoConvertService");
            intent.setPackage("com.baidu.tieba");
            this.mContext.startService(intent);
        }
    }

    private void dPI() {
        if (this.mContext != null) {
            Intent intent = new Intent("com.baidu.tieba.video.convert.VideoConvertService");
            intent.setPackage("com.baidu.tieba");
            this.mContext.bindService(intent, this.nBa, 1);
        }
    }

    private void dPJ() {
        if (this.nAP != null && this.mContext != null) {
            this.mContext.unbindService(this.nBa);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dPK() {
        int i = -1;
        try {
            this.nAP.setIVideoConvertListener(this.nAV);
            this.nAP.setConvertType(this.nAZ);
            i = this.nAP.doConvert(this.nAQ, this.nAR);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        if (this.nAU != null) {
            if (i == 0) {
                this.nAU.dPG();
            } else {
                this.nAU.Ka(i);
            }
        }
    }

    public void gw(String str, String str2) {
        this.nAY = true;
        this.nAX = false;
        this.nAW = -3;
        this.nAQ = str;
        this.nAR = str2;
        this.nAS = new File(this.nAQ);
        this.nAT = new File(this.nAR);
        if (this.nAP == null) {
            startService();
            dPI();
            return;
        }
        dPK();
    }

    public boolean isConvertRunning() {
        try {
            if (this.nAP != null) {
                if (this.nAP.isConvertRunning()) {
                    return true;
                }
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void abortConvert() {
        if (this.nAP != null) {
            try {
                this.nAP.abortConvert();
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
            VideoConvertUtil.this.nAW = 1;
            if (VideoConvertUtil.this.nAU != null) {
                VideoConvertUtil.this.nAU.onConvertSuccess();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertFailed() throws RemoteException {
            if (VideoConvertUtil.this.nAU != null) {
                VideoConvertUtil.this.nAU.onConvertFailed();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertProgress(int i) throws RemoteException {
            if (VideoConvertUtil.this.nAU != null) {
                VideoConvertUtil.this.nAU.onConvertProgress(i);
            }
            if ((VideoConvertUtil.this.nAS != null && !VideoConvertUtil.this.nAS.exists()) || (VideoConvertUtil.this.nAT != null && !VideoConvertUtil.this.nAT.exists())) {
                VideoConvertUtil.this.abortConvert();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertAborted() throws RemoteException {
            if (VideoConvertUtil.this.nAU != null) {
                VideoConvertUtil.this.nAU.onConvertAborted();
            }
        }
    }

    public void a(d dVar) {
        this.nAU = dVar;
    }

    public static String Td(String str) {
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
    public static int Te(String str) {
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

    public static boolean dPL() {
        File file = new File(nAO);
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
