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
    private IVideoConvertService nFt;
    private String nFu;
    private String nFv;
    private File nFw;
    private File nFx;
    private d nFy;
    public static final String nFs = c.nFg;
    private static final String TAG = VideoConvertUtil.class.getSimpleName();
    private int nFA = -3;
    private boolean nFB = false;
    private boolean nFC = false;
    private int nFD = 1;
    private ServiceConnection nFE = new ServiceConnection() { // from class: com.baidu.tieba.video.VideoConvertUtil.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            VideoConvertUtil.this.nFt = IVideoConvertService.Stub.asInterface(iBinder);
            if (VideoConvertUtil.this.nFC) {
                VideoConvertUtil.this.dTC();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            if (VideoConvertUtil.this.nFC) {
                if (!VideoConvertUtil.this.nFB && VideoConvertUtil.this.nFA == -3 && VideoConvertUtil.this.nFy != null) {
                    VideoConvertUtil.this.nFy.onConvertFailed();
                }
                VideoConvertUtil.this.nFC = false;
            }
            VideoConvertUtil.this.nFt = null;
        }
    };
    private IntenalConvertListener nFz = new IntenalConvertListener();

    public VideoConvertUtil(Context context) {
        this.mContext = context;
    }

    public void setConvertType(int i) {
        this.nFD = i;
    }

    public void destroy() {
        this.nFB = true;
        abortConvert();
        dTB();
    }

    private void startService() {
        if (this.mContext != null) {
            Intent intent = new Intent("com.baidu.tieba.video.convert.VideoConvertService");
            intent.setPackage("com.baidu.tieba");
            this.mContext.startService(intent);
        }
    }

    private void dTA() {
        if (this.mContext != null) {
            Intent intent = new Intent("com.baidu.tieba.video.convert.VideoConvertService");
            intent.setPackage("com.baidu.tieba");
            this.mContext.bindService(intent, this.nFE, 1);
        }
    }

    private void dTB() {
        if (this.nFt != null && this.mContext != null) {
            this.mContext.unbindService(this.nFE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dTC() {
        int i = -1;
        try {
            this.nFt.setIVideoConvertListener(this.nFz);
            this.nFt.setConvertType(this.nFD);
            i = this.nFt.doConvert(this.nFu, this.nFv);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        if (this.nFy != null) {
            if (i == 0) {
                this.nFy.dTy();
            } else {
                this.nFy.LH(i);
            }
        }
    }

    public void gx(String str, String str2) {
        this.nFC = true;
        this.nFB = false;
        this.nFA = -3;
        this.nFu = str;
        this.nFv = str2;
        this.nFw = new File(this.nFu);
        this.nFx = new File(this.nFv);
        if (this.nFt == null) {
            startService();
            dTA();
            return;
        }
        dTC();
    }

    public boolean isConvertRunning() {
        try {
            if (this.nFt != null) {
                if (this.nFt.isConvertRunning()) {
                    return true;
                }
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void abortConvert() {
        if (this.nFt != null) {
            try {
                this.nFt.abortConvert();
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
            VideoConvertUtil.this.nFA = 1;
            if (VideoConvertUtil.this.nFy != null) {
                VideoConvertUtil.this.nFy.onConvertSuccess();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertFailed() throws RemoteException {
            if (VideoConvertUtil.this.nFy != null) {
                VideoConvertUtil.this.nFy.onConvertFailed();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertProgress(int i) throws RemoteException {
            if (VideoConvertUtil.this.nFy != null) {
                VideoConvertUtil.this.nFy.onConvertProgress(i);
            }
            if ((VideoConvertUtil.this.nFw != null && !VideoConvertUtil.this.nFw.exists()) || (VideoConvertUtil.this.nFx != null && !VideoConvertUtil.this.nFx.exists())) {
                VideoConvertUtil.this.abortConvert();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertAborted() throws RemoteException {
            if (VideoConvertUtil.this.nFy != null) {
                VideoConvertUtil.this.nFy.onConvertAborted();
            }
        }
    }

    public void a(d dVar) {
        this.nFy = dVar;
    }

    public static String Uk(String str) {
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
    public static int Ul(String str) {
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

    public static boolean dTD() {
        File file = new File(nFs);
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
