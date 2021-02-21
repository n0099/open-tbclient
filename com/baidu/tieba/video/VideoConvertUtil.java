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
    private IVideoConvertService nKZ;
    private String nLa;
    private String nLb;
    private File nLc;
    private File nLd;
    private d nLe;
    public static final String nKY = c.nKM;
    private static final String TAG = VideoConvertUtil.class.getSimpleName();
    private int nLg = -3;
    private boolean nLh = false;
    private boolean nLi = false;
    private int nLj = 1;
    private ServiceConnection nLk = new ServiceConnection() { // from class: com.baidu.tieba.video.VideoConvertUtil.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            VideoConvertUtil.this.nKZ = IVideoConvertService.Stub.asInterface(iBinder);
            if (VideoConvertUtil.this.nLi) {
                VideoConvertUtil.this.dSd();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            if (VideoConvertUtil.this.nLi) {
                if (!VideoConvertUtil.this.nLh && VideoConvertUtil.this.nLg == -3 && VideoConvertUtil.this.nLe != null) {
                    VideoConvertUtil.this.nLe.onConvertFailed();
                }
                VideoConvertUtil.this.nLi = false;
            }
            VideoConvertUtil.this.nKZ = null;
        }
    };
    private IntenalConvertListener nLf = new IntenalConvertListener();

    public VideoConvertUtil(Context context) {
        this.mContext = context;
    }

    public void setConvertType(int i) {
        this.nLj = i;
    }

    public void destroy() {
        this.nLh = true;
        abortConvert();
        dSc();
    }

    private void startService() {
        if (this.mContext != null) {
            Intent intent = new Intent("com.baidu.tieba.video.convert.VideoConvertService");
            intent.setPackage("com.baidu.tieba");
            this.mContext.startService(intent);
        }
    }

    private void dSb() {
        if (this.mContext != null) {
            Intent intent = new Intent("com.baidu.tieba.video.convert.VideoConvertService");
            intent.setPackage("com.baidu.tieba");
            this.mContext.bindService(intent, this.nLk, 1);
        }
    }

    private void dSc() {
        if (this.nKZ != null && this.mContext != null) {
            this.mContext.unbindService(this.nLk);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dSd() {
        int i = -1;
        try {
            this.nKZ.setIVideoConvertListener(this.nLf);
            this.nKZ.setConvertType(this.nLj);
            i = this.nKZ.doConvert(this.nLa, this.nLb);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        if (this.nLe != null) {
            if (i == 0) {
                this.nLe.dRZ();
            } else {
                this.nLe.Ku(i);
            }
        }
    }

    public void gE(String str, String str2) {
        this.nLi = true;
        this.nLh = false;
        this.nLg = -3;
        this.nLa = str;
        this.nLb = str2;
        this.nLc = new File(this.nLa);
        this.nLd = new File(this.nLb);
        if (this.nKZ == null) {
            startService();
            dSb();
            return;
        }
        dSd();
    }

    public boolean isConvertRunning() {
        try {
            if (this.nKZ != null) {
                if (this.nKZ.isConvertRunning()) {
                    return true;
                }
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void abortConvert() {
        if (this.nKZ != null) {
            try {
                this.nKZ.abortConvert();
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
            VideoConvertUtil.this.nLg = 1;
            if (VideoConvertUtil.this.nLe != null) {
                VideoConvertUtil.this.nLe.onConvertSuccess();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertFailed() throws RemoteException {
            if (VideoConvertUtil.this.nLe != null) {
                VideoConvertUtil.this.nLe.onConvertFailed();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertProgress(int i) throws RemoteException {
            if (VideoConvertUtil.this.nLe != null) {
                VideoConvertUtil.this.nLe.onConvertProgress(i);
            }
            if ((VideoConvertUtil.this.nLc != null && !VideoConvertUtil.this.nLc.exists()) || (VideoConvertUtil.this.nLd != null && !VideoConvertUtil.this.nLd.exists())) {
                VideoConvertUtil.this.abortConvert();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertAborted() throws RemoteException {
            if (VideoConvertUtil.this.nLe != null) {
                VideoConvertUtil.this.nLe.onConvertAborted();
            }
        }
    }

    public void a(d dVar) {
        this.nLe = dVar;
    }

    public static String Um(String str) {
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
    public static int Un(String str) {
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

    public static boolean dSe() {
        File file = new File(nKY);
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
