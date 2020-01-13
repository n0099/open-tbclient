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
    private IVideoConvertService ktX;
    private String ktY;
    private File ktZ;
    private d kua;
    private Context mContext;
    private File mOutputFile;
    private String mOutputPath;
    public static final String ktO = c.ktJ;
    private static final String TAG = VideoConvertUtil.class.getSimpleName();
    private int kuc = -3;
    private boolean kud = false;
    private boolean kue = false;
    private int kuf = 1;
    private ServiceConnection kug = new ServiceConnection() { // from class: com.baidu.tieba.video.VideoConvertUtil.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            VideoConvertUtil.this.ktX = IVideoConvertService.Stub.asInterface(iBinder);
            if (VideoConvertUtil.this.kue) {
                VideoConvertUtil.this.cNG();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            if (VideoConvertUtil.this.kue) {
                if (!VideoConvertUtil.this.kud && VideoConvertUtil.this.kuc == -3 && VideoConvertUtil.this.kua != null) {
                    VideoConvertUtil.this.kua.onConvertFailed();
                }
                VideoConvertUtil.this.kue = false;
            }
            VideoConvertUtil.this.ktX = null;
        }
    };
    private IntenalConvertListener kub = new IntenalConvertListener();

    public VideoConvertUtil(Context context) {
        this.mContext = context;
    }

    public void setConvertType(int i) {
        this.kuf = i;
    }

    public void destroy() {
        this.kud = true;
        abortConvert();
        cNF();
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
            this.mContext.bindService(intent, this.kug, 1);
        }
    }

    private void cNF() {
        if (this.ktX != null && this.mContext != null) {
            this.mContext.unbindService(this.kug);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cNG() {
        int i = -1;
        try {
            this.ktX.setIVideoConvertListener(this.kub);
            this.ktX.setConvertType(this.kuf);
            i = this.ktX.doConvert(this.ktY, this.mOutputPath);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        if (this.kua != null) {
            if (i == 0) {
                this.kua.cND();
            } else {
                this.kua.Dk(i);
            }
        }
    }

    public void ez(String str, String str2) {
        this.kue = true;
        this.kud = false;
        this.kuc = -3;
        this.ktY = str;
        this.mOutputPath = str2;
        this.ktZ = new File(this.ktY);
        this.mOutputFile = new File(this.mOutputPath);
        if (this.ktX == null) {
            startService();
            aUh();
            return;
        }
        cNG();
    }

    public boolean isConvertRunning() {
        try {
            if (this.ktX != null) {
                if (this.ktX.isConvertRunning()) {
                    return true;
                }
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void abortConvert() {
        if (this.ktX != null) {
            try {
                this.ktX.abortConvert();
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
            VideoConvertUtil.this.kuc = 1;
            if (VideoConvertUtil.this.kua != null) {
                VideoConvertUtil.this.kua.onConvertSuccess();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertFailed() throws RemoteException {
            if (VideoConvertUtil.this.kua != null) {
                VideoConvertUtil.this.kua.onConvertFailed();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertProgress(int i) throws RemoteException {
            if (VideoConvertUtil.this.kua != null) {
                VideoConvertUtil.this.kua.onConvertProgress(i);
            }
            if ((VideoConvertUtil.this.ktZ != null && !VideoConvertUtil.this.ktZ.exists()) || (VideoConvertUtil.this.mOutputFile != null && !VideoConvertUtil.this.mOutputFile.exists())) {
                VideoConvertUtil.this.abortConvert();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertAborted() throws RemoteException {
            if (VideoConvertUtil.this.kua != null) {
                VideoConvertUtil.this.kua.onConvertAborted();
            }
        }
    }

    public void a(d dVar) {
        this.kua = dVar;
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

    public static boolean cNH() {
        File file = new File(ktO);
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
