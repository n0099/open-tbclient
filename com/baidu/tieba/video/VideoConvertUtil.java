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
    private IVideoConvertService kqu;
    private String kqv;
    private File kqw;
    private d kqx;
    private Context mContext;
    private File mOutputFile;
    private String mOutputPath;
    public static final String kql = c.kqg;
    private static final String TAG = VideoConvertUtil.class.getSimpleName();
    private int kqz = -3;
    private boolean kqA = false;
    private boolean kqB = false;
    private int kqC = 1;
    private ServiceConnection kqD = new ServiceConnection() { // from class: com.baidu.tieba.video.VideoConvertUtil.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            VideoConvertUtil.this.kqu = IVideoConvertService.Stub.asInterface(iBinder);
            if (VideoConvertUtil.this.kqB) {
                VideoConvertUtil.this.cMB();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            if (VideoConvertUtil.this.kqB) {
                if (!VideoConvertUtil.this.kqA && VideoConvertUtil.this.kqz == -3 && VideoConvertUtil.this.kqx != null) {
                    VideoConvertUtil.this.kqx.onConvertFailed();
                }
                VideoConvertUtil.this.kqB = false;
            }
            VideoConvertUtil.this.kqu = null;
        }
    };
    private IntenalConvertListener kqy = new IntenalConvertListener();

    public VideoConvertUtil(Context context) {
        this.mContext = context;
    }

    public void setConvertType(int i) {
        this.kqC = i;
    }

    public void destroy() {
        this.kqA = true;
        abortConvert();
        cMA();
    }

    private void startService() {
        if (this.mContext != null) {
            Intent intent = new Intent("com.baidu.tieba.video.convert.VideoConvertService");
            intent.setPackage("com.baidu.tieba");
            this.mContext.startService(intent);
        }
    }

    private void aTN() {
        if (this.mContext != null) {
            Intent intent = new Intent("com.baidu.tieba.video.convert.VideoConvertService");
            intent.setPackage("com.baidu.tieba");
            this.mContext.bindService(intent, this.kqD, 1);
        }
    }

    private void cMA() {
        if (this.kqu != null && this.mContext != null) {
            this.mContext.unbindService(this.kqD);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cMB() {
        int i = -1;
        try {
            this.kqu.setIVideoConvertListener(this.kqy);
            this.kqu.setConvertType(this.kqC);
            i = this.kqu.doConvert(this.kqv, this.mOutputPath);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        if (this.kqx != null) {
            if (i == 0) {
                this.kqx.cMy();
            } else {
                this.kqx.De(i);
            }
        }
    }

    public void ex(String str, String str2) {
        this.kqB = true;
        this.kqA = false;
        this.kqz = -3;
        this.kqv = str;
        this.mOutputPath = str2;
        this.kqw = new File(this.kqv);
        this.mOutputFile = new File(this.mOutputPath);
        if (this.kqu == null) {
            startService();
            aTN();
            return;
        }
        cMB();
    }

    public boolean isConvertRunning() {
        try {
            if (this.kqu != null) {
                if (this.kqu.isConvertRunning()) {
                    return true;
                }
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void abortConvert() {
        if (this.kqu != null) {
            try {
                this.kqu.abortConvert();
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
            VideoConvertUtil.this.kqz = 1;
            if (VideoConvertUtil.this.kqx != null) {
                VideoConvertUtil.this.kqx.onConvertSuccess();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertFailed() throws RemoteException {
            if (VideoConvertUtil.this.kqx != null) {
                VideoConvertUtil.this.kqx.onConvertFailed();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertProgress(int i) throws RemoteException {
            if (VideoConvertUtil.this.kqx != null) {
                VideoConvertUtil.this.kqx.onConvertProgress(i);
            }
            if ((VideoConvertUtil.this.kqw != null && !VideoConvertUtil.this.kqw.exists()) || (VideoConvertUtil.this.mOutputFile != null && !VideoConvertUtil.this.mOutputFile.exists())) {
                VideoConvertUtil.this.abortConvert();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertAborted() throws RemoteException {
            if (VideoConvertUtil.this.kqx != null) {
                VideoConvertUtil.this.kqx.onConvertAborted();
            }
        }
    }

    public void a(d dVar) {
        this.kqx = dVar;
    }

    public static String Ju(String str) {
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
    public static int Jv(String str) {
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

    public static boolean cMC() {
        File file = new File(kql);
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
