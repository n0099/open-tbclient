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
    private IVideoConvertService nAO;
    private String nAP;
    private String nAQ;
    private File nAR;
    private File nAS;
    private d nAT;
    public static final String nAN = c.nAB;
    private static final String TAG = VideoConvertUtil.class.getSimpleName();
    private int nAV = -3;
    private boolean nAW = false;
    private boolean nAX = false;
    private int nAY = 1;
    private ServiceConnection nAZ = new ServiceConnection() { // from class: com.baidu.tieba.video.VideoConvertUtil.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            VideoConvertUtil.this.nAO = IVideoConvertService.Stub.asInterface(iBinder);
            if (VideoConvertUtil.this.nAX) {
                VideoConvertUtil.this.dPK();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            if (VideoConvertUtil.this.nAX) {
                if (!VideoConvertUtil.this.nAW && VideoConvertUtil.this.nAV == -3 && VideoConvertUtil.this.nAT != null) {
                    VideoConvertUtil.this.nAT.onConvertFailed();
                }
                VideoConvertUtil.this.nAX = false;
            }
            VideoConvertUtil.this.nAO = null;
        }
    };
    private IntenalConvertListener nAU = new IntenalConvertListener();

    public VideoConvertUtil(Context context) {
        this.mContext = context;
    }

    public void setConvertType(int i) {
        this.nAY = i;
    }

    public void destroy() {
        this.nAW = true;
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
            this.mContext.bindService(intent, this.nAZ, 1);
        }
    }

    private void dPJ() {
        if (this.nAO != null && this.mContext != null) {
            this.mContext.unbindService(this.nAZ);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dPK() {
        int i = -1;
        try {
            this.nAO.setIVideoConvertListener(this.nAU);
            this.nAO.setConvertType(this.nAY);
            i = this.nAO.doConvert(this.nAP, this.nAQ);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        if (this.nAT != null) {
            if (i == 0) {
                this.nAT.dPG();
            } else {
                this.nAT.Ka(i);
            }
        }
    }

    public void gw(String str, String str2) {
        this.nAX = true;
        this.nAW = false;
        this.nAV = -3;
        this.nAP = str;
        this.nAQ = str2;
        this.nAR = new File(this.nAP);
        this.nAS = new File(this.nAQ);
        if (this.nAO == null) {
            startService();
            dPI();
            return;
        }
        dPK();
    }

    public boolean isConvertRunning() {
        try {
            if (this.nAO != null) {
                if (this.nAO.isConvertRunning()) {
                    return true;
                }
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void abortConvert() {
        if (this.nAO != null) {
            try {
                this.nAO.abortConvert();
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
            VideoConvertUtil.this.nAV = 1;
            if (VideoConvertUtil.this.nAT != null) {
                VideoConvertUtil.this.nAT.onConvertSuccess();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertFailed() throws RemoteException {
            if (VideoConvertUtil.this.nAT != null) {
                VideoConvertUtil.this.nAT.onConvertFailed();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertProgress(int i) throws RemoteException {
            if (VideoConvertUtil.this.nAT != null) {
                VideoConvertUtil.this.nAT.onConvertProgress(i);
            }
            if ((VideoConvertUtil.this.nAR != null && !VideoConvertUtil.this.nAR.exists()) || (VideoConvertUtil.this.nAS != null && !VideoConvertUtil.this.nAS.exists())) {
                VideoConvertUtil.this.abortConvert();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertAborted() throws RemoteException {
            if (VideoConvertUtil.this.nAT != null) {
                VideoConvertUtil.this.nAT.onConvertAborted();
            }
        }
    }

    public void a(d dVar) {
        this.nAT = dVar;
    }

    public static String Tc(String str) {
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
    public static int Td(String str) {
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
        File file = new File(nAN);
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
