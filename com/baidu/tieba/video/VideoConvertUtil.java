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
    private IVideoConvertService kuc;
    private String kud;
    private File kue;
    private d kuf;
    private Context mContext;
    private File mOutputFile;
    private String mOutputPath;
    public static final String ktT = c.ktO;
    private static final String TAG = VideoConvertUtil.class.getSimpleName();
    private int kuh = -3;
    private boolean kui = false;
    private boolean kuj = false;
    private int kuk = 1;
    private ServiceConnection kul = new ServiceConnection() { // from class: com.baidu.tieba.video.VideoConvertUtil.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            VideoConvertUtil.this.kuc = IVideoConvertService.Stub.asInterface(iBinder);
            if (VideoConvertUtil.this.kuj) {
                VideoConvertUtil.this.cNI();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            if (VideoConvertUtil.this.kuj) {
                if (!VideoConvertUtil.this.kui && VideoConvertUtil.this.kuh == -3 && VideoConvertUtil.this.kuf != null) {
                    VideoConvertUtil.this.kuf.onConvertFailed();
                }
                VideoConvertUtil.this.kuj = false;
            }
            VideoConvertUtil.this.kuc = null;
        }
    };
    private IntenalConvertListener kug = new IntenalConvertListener();

    public VideoConvertUtil(Context context) {
        this.mContext = context;
    }

    public void setConvertType(int i) {
        this.kuk = i;
    }

    public void destroy() {
        this.kui = true;
        abortConvert();
        cNH();
    }

    private void startService() {
        if (this.mContext != null) {
            Intent intent = new Intent("com.baidu.tieba.video.convert.VideoConvertService");
            intent.setPackage("com.baidu.tieba");
            this.mContext.startService(intent);
        }
    }

    private void aUh() {
        if (this.mContext != null) {
            Intent intent = new Intent("com.baidu.tieba.video.convert.VideoConvertService");
            intent.setPackage("com.baidu.tieba");
            this.mContext.bindService(intent, this.kul, 1);
        }
    }

    private void cNH() {
        if (this.kuc != null && this.mContext != null) {
            this.mContext.unbindService(this.kul);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cNI() {
        int i = -1;
        try {
            this.kuc.setIVideoConvertListener(this.kug);
            this.kuc.setConvertType(this.kuk);
            i = this.kuc.doConvert(this.kud, this.mOutputPath);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        if (this.kuf != null) {
            if (i == 0) {
                this.kuf.cNF();
            } else {
                this.kuf.Dk(i);
            }
        }
    }

    public void ez(String str, String str2) {
        this.kuj = true;
        this.kui = false;
        this.kuh = -3;
        this.kud = str;
        this.mOutputPath = str2;
        this.kue = new File(this.kud);
        this.mOutputFile = new File(this.mOutputPath);
        if (this.kuc == null) {
            startService();
            aUh();
            return;
        }
        cNI();
    }

    public boolean isConvertRunning() {
        try {
            if (this.kuc != null) {
                if (this.kuc.isConvertRunning()) {
                    return true;
                }
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void abortConvert() {
        if (this.kuc != null) {
            try {
                this.kuc.abortConvert();
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
            VideoConvertUtil.this.kuh = 1;
            if (VideoConvertUtil.this.kuf != null) {
                VideoConvertUtil.this.kuf.onConvertSuccess();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertFailed() throws RemoteException {
            if (VideoConvertUtil.this.kuf != null) {
                VideoConvertUtil.this.kuf.onConvertFailed();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertProgress(int i) throws RemoteException {
            if (VideoConvertUtil.this.kuf != null) {
                VideoConvertUtil.this.kuf.onConvertProgress(i);
            }
            if ((VideoConvertUtil.this.kue != null && !VideoConvertUtil.this.kue.exists()) || (VideoConvertUtil.this.mOutputFile != null && !VideoConvertUtil.this.mOutputFile.exists())) {
                VideoConvertUtil.this.abortConvert();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertAborted() throws RemoteException {
            if (VideoConvertUtil.this.kuf != null) {
                VideoConvertUtil.this.kuf.onConvertAborted();
            }
        }
    }

    public void a(d dVar) {
        this.kuf = dVar;
    }

    public static String JE(String str) {
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
    public static int JF(String str) {
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

    public static boolean cNJ() {
        File file = new File(ktT);
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
