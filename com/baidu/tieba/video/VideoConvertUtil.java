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
    private IVideoConvertService mDR;
    private String mDS;
    private String mDT;
    private File mDU;
    private File mDV;
    private d mDW;
    public static final String mDI = c.mDD;
    private static final String TAG = VideoConvertUtil.class.getSimpleName();
    private int mDY = -3;
    private boolean mDZ = false;
    private boolean mEa = false;
    private int mEb = 1;
    private ServiceConnection mEc = new ServiceConnection() { // from class: com.baidu.tieba.video.VideoConvertUtil.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            VideoConvertUtil.this.mDR = IVideoConvertService.Stub.asInterface(iBinder);
            if (VideoConvertUtil.this.mEa) {
                VideoConvertUtil.this.dEW();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            if (VideoConvertUtil.this.mEa) {
                if (!VideoConvertUtil.this.mDZ && VideoConvertUtil.this.mDY == -3 && VideoConvertUtil.this.mDW != null) {
                    VideoConvertUtil.this.mDW.onConvertFailed();
                }
                VideoConvertUtil.this.mEa = false;
            }
            VideoConvertUtil.this.mDR = null;
        }
    };
    private IntenalConvertListener mDX = new IntenalConvertListener();

    public VideoConvertUtil(Context context) {
        this.mContext = context;
    }

    public void setConvertType(int i) {
        this.mEb = i;
    }

    public void destroy() {
        this.mDZ = true;
        abortConvert();
        dEV();
    }

    private void startService() {
        if (this.mContext != null) {
            Intent intent = new Intent("com.baidu.tieba.video.convert.VideoConvertService");
            intent.setPackage("com.baidu.tieba");
            this.mContext.startService(intent);
        }
    }

    private void dEU() {
        if (this.mContext != null) {
            Intent intent = new Intent("com.baidu.tieba.video.convert.VideoConvertService");
            intent.setPackage("com.baidu.tieba");
            this.mContext.bindService(intent, this.mEc, 1);
        }
    }

    private void dEV() {
        if (this.mDR != null && this.mContext != null) {
            this.mContext.unbindService(this.mEc);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dEW() {
        int i = -1;
        try {
            this.mDR.setIVideoConvertListener(this.mDX);
            this.mDR.setConvertType(this.mEb);
            i = this.mDR.doConvert(this.mDS, this.mDT);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        if (this.mDW != null) {
            if (i == 0) {
                this.mDW.dES();
            } else {
                this.mDW.Jn(i);
            }
        }
    }

    public void gj(String str, String str2) {
        this.mEa = true;
        this.mDZ = false;
        this.mDY = -3;
        this.mDS = str;
        this.mDT = str2;
        this.mDU = new File(this.mDS);
        this.mDV = new File(this.mDT);
        if (this.mDR == null) {
            startService();
            dEU();
            return;
        }
        dEW();
    }

    public boolean isConvertRunning() {
        try {
            if (this.mDR != null) {
                if (this.mDR.isConvertRunning()) {
                    return true;
                }
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void abortConvert() {
        if (this.mDR != null) {
            try {
                this.mDR.abortConvert();
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
            VideoConvertUtil.this.mDY = 1;
            if (VideoConvertUtil.this.mDW != null) {
                VideoConvertUtil.this.mDW.onConvertSuccess();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertFailed() throws RemoteException {
            if (VideoConvertUtil.this.mDW != null) {
                VideoConvertUtil.this.mDW.onConvertFailed();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertProgress(int i) throws RemoteException {
            if (VideoConvertUtil.this.mDW != null) {
                VideoConvertUtil.this.mDW.onConvertProgress(i);
            }
            if ((VideoConvertUtil.this.mDU != null && !VideoConvertUtil.this.mDU.exists()) || (VideoConvertUtil.this.mDV != null && !VideoConvertUtil.this.mDV.exists())) {
                VideoConvertUtil.this.abortConvert();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertAborted() throws RemoteException {
            if (VideoConvertUtil.this.mDW != null) {
                VideoConvertUtil.this.mDW.onConvertAborted();
            }
        }
    }

    public void a(d dVar) {
        this.mDW = dVar;
    }

    public static String Sa(String str) {
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
    public static int Sb(String str) {
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

    public static boolean dEX() {
        File file = new File(mDI);
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
