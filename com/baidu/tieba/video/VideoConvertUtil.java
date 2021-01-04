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
    private IVideoConvertService nFu;
    private String nFv;
    private String nFw;
    private File nFx;
    private File nFy;
    private d nFz;
    public static final String nFt = c.nFh;
    private static final String TAG = VideoConvertUtil.class.getSimpleName();
    private int nFB = -3;
    private boolean nFC = false;
    private boolean nFD = false;
    private int nFE = 1;
    private ServiceConnection nFF = new ServiceConnection() { // from class: com.baidu.tieba.video.VideoConvertUtil.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            VideoConvertUtil.this.nFu = IVideoConvertService.Stub.asInterface(iBinder);
            if (VideoConvertUtil.this.nFD) {
                VideoConvertUtil.this.dTB();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            if (VideoConvertUtil.this.nFD) {
                if (!VideoConvertUtil.this.nFC && VideoConvertUtil.this.nFB == -3 && VideoConvertUtil.this.nFz != null) {
                    VideoConvertUtil.this.nFz.onConvertFailed();
                }
                VideoConvertUtil.this.nFD = false;
            }
            VideoConvertUtil.this.nFu = null;
        }
    };
    private IntenalConvertListener nFA = new IntenalConvertListener();

    public VideoConvertUtil(Context context) {
        this.mContext = context;
    }

    public void setConvertType(int i) {
        this.nFE = i;
    }

    public void destroy() {
        this.nFC = true;
        abortConvert();
        dTA();
    }

    private void startService() {
        if (this.mContext != null) {
            Intent intent = new Intent("com.baidu.tieba.video.convert.VideoConvertService");
            intent.setPackage("com.baidu.tieba");
            this.mContext.startService(intent);
        }
    }

    private void dTz() {
        if (this.mContext != null) {
            Intent intent = new Intent("com.baidu.tieba.video.convert.VideoConvertService");
            intent.setPackage("com.baidu.tieba");
            this.mContext.bindService(intent, this.nFF, 1);
        }
    }

    private void dTA() {
        if (this.nFu != null && this.mContext != null) {
            this.mContext.unbindService(this.nFF);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dTB() {
        int i = -1;
        try {
            this.nFu.setIVideoConvertListener(this.nFA);
            this.nFu.setConvertType(this.nFE);
            i = this.nFu.doConvert(this.nFv, this.nFw);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        if (this.nFz != null) {
            if (i == 0) {
                this.nFz.dTx();
            } else {
                this.nFz.LH(i);
            }
        }
    }

    public void gx(String str, String str2) {
        this.nFD = true;
        this.nFC = false;
        this.nFB = -3;
        this.nFv = str;
        this.nFw = str2;
        this.nFx = new File(this.nFv);
        this.nFy = new File(this.nFw);
        if (this.nFu == null) {
            startService();
            dTz();
            return;
        }
        dTB();
    }

    public boolean isConvertRunning() {
        try {
            if (this.nFu != null) {
                if (this.nFu.isConvertRunning()) {
                    return true;
                }
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void abortConvert() {
        if (this.nFu != null) {
            try {
                this.nFu.abortConvert();
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
            VideoConvertUtil.this.nFB = 1;
            if (VideoConvertUtil.this.nFz != null) {
                VideoConvertUtil.this.nFz.onConvertSuccess();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertFailed() throws RemoteException {
            if (VideoConvertUtil.this.nFz != null) {
                VideoConvertUtil.this.nFz.onConvertFailed();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertProgress(int i) throws RemoteException {
            if (VideoConvertUtil.this.nFz != null) {
                VideoConvertUtil.this.nFz.onConvertProgress(i);
            }
            if ((VideoConvertUtil.this.nFx != null && !VideoConvertUtil.this.nFx.exists()) || (VideoConvertUtil.this.nFy != null && !VideoConvertUtil.this.nFy.exists())) {
                VideoConvertUtil.this.abortConvert();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertAborted() throws RemoteException {
            if (VideoConvertUtil.this.nFz != null) {
                VideoConvertUtil.this.nFz.onConvertAborted();
            }
        }
    }

    public void a(d dVar) {
        this.nFz = dVar;
    }

    public static String Ul(String str) {
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
    public static int Um(String str) {
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

    public static boolean dTC() {
        File file = new File(nFt);
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
