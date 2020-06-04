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
    private IVideoConvertService lBc;
    private String lBd;
    private String lBe;
    private File lBf;
    private File lBg;
    private d lBh;
    private Context mContext;
    public static final String lAT = c.lAO;
    private static final String TAG = VideoConvertUtil.class.getSimpleName();
    private int lBj = -3;
    private boolean lBk = false;
    private boolean lBl = false;
    private int lBm = 1;
    private ServiceConnection lBn = new ServiceConnection() { // from class: com.baidu.tieba.video.VideoConvertUtil.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            VideoConvertUtil.this.lBc = IVideoConvertService.Stub.asInterface(iBinder);
            if (VideoConvertUtil.this.lBl) {
                VideoConvertUtil.this.dhX();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            if (VideoConvertUtil.this.lBl) {
                if (!VideoConvertUtil.this.lBk && VideoConvertUtil.this.lBj == -3 && VideoConvertUtil.this.lBh != null) {
                    VideoConvertUtil.this.lBh.onConvertFailed();
                }
                VideoConvertUtil.this.lBl = false;
            }
            VideoConvertUtil.this.lBc = null;
        }
    };
    private IntenalConvertListener lBi = new IntenalConvertListener();

    public VideoConvertUtil(Context context) {
        this.mContext = context;
    }

    public void setConvertType(int i) {
        this.lBm = i;
    }

    public void destroy() {
        this.lBk = true;
        abortConvert();
        dhW();
    }

    private void startService() {
        if (this.mContext != null) {
            Intent intent = new Intent("com.baidu.tieba.video.convert.VideoConvertService");
            intent.setPackage("com.baidu.tieba");
            this.mContext.startService(intent);
        }
    }

    private void bkX() {
        if (this.mContext != null) {
            Intent intent = new Intent("com.baidu.tieba.video.convert.VideoConvertService");
            intent.setPackage("com.baidu.tieba");
            this.mContext.bindService(intent, this.lBn, 1);
        }
    }

    private void dhW() {
        if (this.lBc != null && this.mContext != null) {
            this.mContext.unbindService(this.lBn);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dhX() {
        int i = -1;
        try {
            this.lBc.setIVideoConvertListener(this.lBi);
            this.lBc.setConvertType(this.lBm);
            i = this.lBc.doConvert(this.lBd, this.lBe);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        if (this.lBh != null) {
            if (i == 0) {
                this.lBh.dhU();
            } else {
                this.lBh.EP(i);
            }
        }
    }

    public void fw(String str, String str2) {
        this.lBl = true;
        this.lBk = false;
        this.lBj = -3;
        this.lBd = str;
        this.lBe = str2;
        this.lBf = new File(this.lBd);
        this.lBg = new File(this.lBe);
        if (this.lBc == null) {
            startService();
            bkX();
            return;
        }
        dhX();
    }

    public boolean isConvertRunning() {
        try {
            if (this.lBc != null) {
                if (this.lBc.isConvertRunning()) {
                    return true;
                }
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void abortConvert() {
        if (this.lBc != null) {
            try {
                this.lBc.abortConvert();
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
            VideoConvertUtil.this.lBj = 1;
            if (VideoConvertUtil.this.lBh != null) {
                VideoConvertUtil.this.lBh.onConvertSuccess();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertFailed() throws RemoteException {
            if (VideoConvertUtil.this.lBh != null) {
                VideoConvertUtil.this.lBh.onConvertFailed();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertProgress(int i) throws RemoteException {
            if (VideoConvertUtil.this.lBh != null) {
                VideoConvertUtil.this.lBh.onConvertProgress(i);
            }
            if ((VideoConvertUtil.this.lBf != null && !VideoConvertUtil.this.lBf.exists()) || (VideoConvertUtil.this.lBg != null && !VideoConvertUtil.this.lBg.exists())) {
                VideoConvertUtil.this.abortConvert();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertAborted() throws RemoteException {
            if (VideoConvertUtil.this.lBh != null) {
                VideoConvertUtil.this.lBh.onConvertAborted();
            }
        }
    }

    public void a(d dVar) {
        this.lBh = dVar;
    }

    public static String Ns(String str) {
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
    public static int Nt(String str) {
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

    public static boolean dhY() {
        File file = new File(lAT);
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
