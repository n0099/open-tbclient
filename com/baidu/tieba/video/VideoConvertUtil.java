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
    private IVideoConvertService lUI;
    private String lUJ;
    private String lUK;
    private File lUL;
    private File lUM;
    private e lUN;
    private Context mContext;
    public static final String lUz = d.lUu;
    private static final String TAG = VideoConvertUtil.class.getSimpleName();
    private int lUP = -3;
    private boolean lUQ = false;
    private boolean lUR = false;
    private int lUS = 1;
    private ServiceConnection lUT = new ServiceConnection() { // from class: com.baidu.tieba.video.VideoConvertUtil.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            VideoConvertUtil.this.lUI = IVideoConvertService.Stub.asInterface(iBinder);
            if (VideoConvertUtil.this.lUR) {
                VideoConvertUtil.this.dmi();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            if (VideoConvertUtil.this.lUR) {
                if (!VideoConvertUtil.this.lUQ && VideoConvertUtil.this.lUP == -3 && VideoConvertUtil.this.lUN != null) {
                    VideoConvertUtil.this.lUN.onConvertFailed();
                }
                VideoConvertUtil.this.lUR = false;
            }
            VideoConvertUtil.this.lUI = null;
        }
    };
    private IntenalConvertListener lUO = new IntenalConvertListener();

    public VideoConvertUtil(Context context) {
        this.mContext = context;
    }

    public void setConvertType(int i) {
        this.lUS = i;
    }

    public void destroy() {
        this.lUQ = true;
        abortConvert();
        dmh();
    }

    private void startService() {
        if (this.mContext != null) {
            Intent intent = new Intent("com.baidu.tieba.video.convert.VideoConvertService");
            intent.setPackage("com.baidu.tieba");
            this.mContext.startService(intent);
        }
    }

    private void bnw() {
        if (this.mContext != null) {
            Intent intent = new Intent("com.baidu.tieba.video.convert.VideoConvertService");
            intent.setPackage("com.baidu.tieba");
            this.mContext.bindService(intent, this.lUT, 1);
        }
    }

    private void dmh() {
        if (this.lUI != null && this.mContext != null) {
            this.mContext.unbindService(this.lUT);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dmi() {
        int i = -1;
        try {
            this.lUI.setIVideoConvertListener(this.lUO);
            this.lUI.setConvertType(this.lUS);
            i = this.lUI.doConvert(this.lUJ, this.lUK);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        if (this.lUN != null) {
            if (i == 0) {
                this.lUN.dmf();
            } else {
                this.lUN.FR(i);
            }
        }
    }

    public void fD(String str, String str2) {
        this.lUR = true;
        this.lUQ = false;
        this.lUP = -3;
        this.lUJ = str;
        this.lUK = str2;
        this.lUL = new File(this.lUJ);
        this.lUM = new File(this.lUK);
        if (this.lUI == null) {
            startService();
            bnw();
            return;
        }
        dmi();
    }

    public boolean isConvertRunning() {
        try {
            if (this.lUI != null) {
                if (this.lUI.isConvertRunning()) {
                    return true;
                }
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void abortConvert() {
        if (this.lUI != null) {
            try {
                this.lUI.abortConvert();
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
            VideoConvertUtil.this.lUP = 1;
            if (VideoConvertUtil.this.lUN != null) {
                VideoConvertUtil.this.lUN.onConvertSuccess();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertFailed() throws RemoteException {
            if (VideoConvertUtil.this.lUN != null) {
                VideoConvertUtil.this.lUN.onConvertFailed();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertProgress(int i) throws RemoteException {
            if (VideoConvertUtil.this.lUN != null) {
                VideoConvertUtil.this.lUN.onConvertProgress(i);
            }
            if ((VideoConvertUtil.this.lUL != null && !VideoConvertUtil.this.lUL.exists()) || (VideoConvertUtil.this.lUM != null && !VideoConvertUtil.this.lUM.exists())) {
                VideoConvertUtil.this.abortConvert();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertAborted() throws RemoteException {
            if (VideoConvertUtil.this.lUN != null) {
                VideoConvertUtil.this.lUN.onConvertAborted();
            }
        }
    }

    public void a(e eVar) {
        this.lUN = eVar;
    }

    public static String NT(String str) {
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
    public static int NU(String str) {
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

    public static boolean dmj() {
        File file = new File(lUz);
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
