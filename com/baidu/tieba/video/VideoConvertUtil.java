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
    private IVideoConvertService nNe;
    private String nNf;
    private String nNg;
    private File nNh;
    private File nNi;
    private d nNj;
    public static final String nNd = c.nMR;
    private static final String TAG = VideoConvertUtil.class.getSimpleName();
    private int nNl = -3;
    private boolean nNm = false;
    private boolean nNn = false;
    private int nNo = 1;
    private ServiceConnection nNp = new ServiceConnection() { // from class: com.baidu.tieba.video.VideoConvertUtil.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            VideoConvertUtil.this.nNe = IVideoConvertService.Stub.asInterface(iBinder);
            if (VideoConvertUtil.this.nNn) {
                VideoConvertUtil.this.dSl();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            if (VideoConvertUtil.this.nNn) {
                if (!VideoConvertUtil.this.nNm && VideoConvertUtil.this.nNl == -3 && VideoConvertUtil.this.nNj != null) {
                    VideoConvertUtil.this.nNj.onConvertFailed();
                }
                VideoConvertUtil.this.nNn = false;
            }
            VideoConvertUtil.this.nNe = null;
        }
    };
    private IntenalConvertListener nNk = new IntenalConvertListener();

    public VideoConvertUtil(Context context) {
        this.mContext = context;
    }

    public void setConvertType(int i) {
        this.nNo = i;
    }

    public void destroy() {
        this.nNm = true;
        abortConvert();
        dSk();
    }

    private void startService() {
        if (this.mContext != null) {
            Intent intent = new Intent("com.baidu.tieba.video.convert.VideoConvertService");
            intent.setPackage("com.baidu.tieba");
            this.mContext.startService(intent);
        }
    }

    private void dSj() {
        if (this.mContext != null) {
            Intent intent = new Intent("com.baidu.tieba.video.convert.VideoConvertService");
            intent.setPackage("com.baidu.tieba");
            this.mContext.bindService(intent, this.nNp, 1);
        }
    }

    private void dSk() {
        if (this.nNe != null && this.mContext != null) {
            this.mContext.unbindService(this.nNp);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dSl() {
        int i = -1;
        try {
            this.nNe.setIVideoConvertListener(this.nNk);
            this.nNe.setConvertType(this.nNo);
            i = this.nNe.doConvert(this.nNf, this.nNg);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        if (this.nNj != null) {
            if (i == 0) {
                this.nNj.dSh();
            } else {
                this.nNj.Kz(i);
            }
        }
    }

    public void gE(String str, String str2) {
        this.nNn = true;
        this.nNm = false;
        this.nNl = -3;
        this.nNf = str;
        this.nNg = str2;
        this.nNh = new File(this.nNf);
        this.nNi = new File(this.nNg);
        if (this.nNe == null) {
            startService();
            dSj();
            return;
        }
        dSl();
    }

    public boolean isConvertRunning() {
        try {
            if (this.nNe != null) {
                if (this.nNe.isConvertRunning()) {
                    return true;
                }
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void abortConvert() {
        if (this.nNe != null) {
            try {
                this.nNe.abortConvert();
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
            VideoConvertUtil.this.nNl = 1;
            if (VideoConvertUtil.this.nNj != null) {
                VideoConvertUtil.this.nNj.onConvertSuccess();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertFailed() throws RemoteException {
            if (VideoConvertUtil.this.nNj != null) {
                VideoConvertUtil.this.nNj.onConvertFailed();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertProgress(int i) throws RemoteException {
            if (VideoConvertUtil.this.nNj != null) {
                VideoConvertUtil.this.nNj.onConvertProgress(i);
            }
            if ((VideoConvertUtil.this.nNh != null && !VideoConvertUtil.this.nNh.exists()) || (VideoConvertUtil.this.nNi != null && !VideoConvertUtil.this.nNi.exists())) {
                VideoConvertUtil.this.abortConvert();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertAborted() throws RemoteException {
            if (VideoConvertUtil.this.nNj != null) {
                VideoConvertUtil.this.nNj.onConvertAborted();
            }
        }
    }

    public void a(d dVar) {
        this.nNj = dVar;
    }

    public static String Ut(String str) {
        if (str == null || str.isEmpty()) {
            return "";
        }
        try {
            byte[] digest = MessageDigest.getInstance(EncryptUtils.ENCRYPT_MD5).digest(str.getBytes("UTF-8"));
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
    public static int Uu(String str) {
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

    public static boolean dSm() {
        File file = new File(nNd);
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
