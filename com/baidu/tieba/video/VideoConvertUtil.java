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
    private IVideoConvertService mug;
    private String muh;
    private String mui;
    private File muj;
    private File muk;
    private d mul;
    public static final String mtX = c.mtS;
    private static final String TAG = VideoConvertUtil.class.getSimpleName();
    private int mun = -3;
    private boolean muo = false;
    private boolean mup = false;
    private int muq = 1;
    private ServiceConnection mur = new ServiceConnection() { // from class: com.baidu.tieba.video.VideoConvertUtil.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            VideoConvertUtil.this.mug = IVideoConvertService.Stub.asInterface(iBinder);
            if (VideoConvertUtil.this.mup) {
                VideoConvertUtil.this.dBc();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            if (VideoConvertUtil.this.mup) {
                if (!VideoConvertUtil.this.muo && VideoConvertUtil.this.mun == -3 && VideoConvertUtil.this.mul != null) {
                    VideoConvertUtil.this.mul.onConvertFailed();
                }
                VideoConvertUtil.this.mup = false;
            }
            VideoConvertUtil.this.mug = null;
        }
    };
    private IntenalConvertListener mum = new IntenalConvertListener();

    public VideoConvertUtil(Context context) {
        this.mContext = context;
    }

    public void setConvertType(int i) {
        this.muq = i;
    }

    public void destroy() {
        this.muo = true;
        abortConvert();
        dBb();
    }

    private void startService() {
        if (this.mContext != null) {
            Intent intent = new Intent("com.baidu.tieba.video.convert.VideoConvertService");
            intent.setPackage("com.baidu.tieba");
            this.mContext.startService(intent);
        }
    }

    private void dBa() {
        if (this.mContext != null) {
            Intent intent = new Intent("com.baidu.tieba.video.convert.VideoConvertService");
            intent.setPackage("com.baidu.tieba");
            this.mContext.bindService(intent, this.mur, 1);
        }
    }

    private void dBb() {
        if (this.mug != null && this.mContext != null) {
            this.mContext.unbindService(this.mur);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dBc() {
        int i = -1;
        try {
            this.mug.setIVideoConvertListener(this.mum);
            this.mug.setConvertType(this.muq);
            i = this.mug.doConvert(this.muh, this.mui);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        if (this.mul != null) {
            if (i == 0) {
                this.mul.dAY();
            } else {
                this.mul.IJ(i);
            }
        }
    }

    public void fX(String str, String str2) {
        this.mup = true;
        this.muo = false;
        this.mun = -3;
        this.muh = str;
        this.mui = str2;
        this.muj = new File(this.muh);
        this.muk = new File(this.mui);
        if (this.mug == null) {
            startService();
            dBa();
            return;
        }
        dBc();
    }

    public boolean isConvertRunning() {
        try {
            if (this.mug != null) {
                if (this.mug.isConvertRunning()) {
                    return true;
                }
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void abortConvert() {
        if (this.mug != null) {
            try {
                this.mug.abortConvert();
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
            VideoConvertUtil.this.mun = 1;
            if (VideoConvertUtil.this.mul != null) {
                VideoConvertUtil.this.mul.onConvertSuccess();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertFailed() throws RemoteException {
            if (VideoConvertUtil.this.mul != null) {
                VideoConvertUtil.this.mul.onConvertFailed();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertProgress(int i) throws RemoteException {
            if (VideoConvertUtil.this.mul != null) {
                VideoConvertUtil.this.mul.onConvertProgress(i);
            }
            if ((VideoConvertUtil.this.muj != null && !VideoConvertUtil.this.muj.exists()) || (VideoConvertUtil.this.muk != null && !VideoConvertUtil.this.muk.exists())) {
                VideoConvertUtil.this.abortConvert();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertAborted() throws RemoteException {
            if (VideoConvertUtil.this.mul != null) {
                VideoConvertUtil.this.mul.onConvertAborted();
            }
        }
    }

    public void a(d dVar) {
        this.mul = dVar;
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

    public static boolean dBd() {
        File file = new File(mtX);
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
