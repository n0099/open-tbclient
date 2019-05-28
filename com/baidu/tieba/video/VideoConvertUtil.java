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
import org.apache.http.protocol.HTTP;
/* loaded from: classes.dex */
public class VideoConvertUtil {
    private IVideoConvertService jnG;
    private String jnH;
    private String jnI;
    private File jnJ;
    private File jnK;
    private d jnL;
    private Context mContext;
    public static final String jnt = c.jno;
    private static final String TAG = VideoConvertUtil.class.getSimpleName();
    private int jnN = -3;
    private boolean jnO = false;
    private boolean jnP = false;
    private int jnQ = 1;
    private ServiceConnection jnR = new ServiceConnection() { // from class: com.baidu.tieba.video.VideoConvertUtil.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            VideoConvertUtil.this.jnG = IVideoConvertService.Stub.asInterface(iBinder);
            if (VideoConvertUtil.this.jnP) {
                VideoConvertUtil.this.cqQ();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            if (VideoConvertUtil.this.jnP) {
                if (!VideoConvertUtil.this.jnO && VideoConvertUtil.this.jnN == -3 && VideoConvertUtil.this.jnL != null) {
                    VideoConvertUtil.this.jnL.onConvertFailed();
                }
                VideoConvertUtil.this.jnP = false;
            }
            VideoConvertUtil.this.jnG = null;
        }
    };
    private IntenalConvertListener jnM = new IntenalConvertListener();

    public VideoConvertUtil(Context context) {
        this.mContext = context;
    }

    public void setConvertType(int i) {
        this.jnQ = i;
    }

    public void destroy() {
        this.jnO = true;
        abortConvert();
        cqP();
    }

    private void startService() {
        if (this.mContext != null) {
            Intent intent = new Intent("com.baidu.tieba.video.convert.VideoConvertService");
            intent.setPackage("com.baidu.tieba");
            this.mContext.startService(intent);
        }
    }

    private void aAi() {
        if (this.mContext != null) {
            Intent intent = new Intent("com.baidu.tieba.video.convert.VideoConvertService");
            intent.setPackage("com.baidu.tieba");
            this.mContext.bindService(intent, this.jnR, 1);
        }
    }

    private void cqP() {
        if (this.jnG != null && this.mContext != null) {
            this.mContext.unbindService(this.jnR);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cqQ() {
        int i = -1;
        try {
            this.jnG.setIVideoConvertListener(this.jnM);
            this.jnG.setConvertType(this.jnQ);
            i = this.jnG.doConvert(this.jnH, this.jnI);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        if (this.jnL != null) {
            if (i == 0) {
                this.jnL.cqN();
            } else {
                this.jnL.Br(i);
            }
        }
    }

    public void eq(String str, String str2) {
        this.jnP = true;
        this.jnO = false;
        this.jnN = -3;
        this.jnH = str;
        this.jnI = str2;
        this.jnJ = new File(this.jnH);
        this.jnK = new File(this.jnI);
        if (this.jnG == null) {
            startService();
            aAi();
            return;
        }
        cqQ();
    }

    public boolean isConvertRunning() {
        try {
            if (this.jnG != null) {
                if (this.jnG.isConvertRunning()) {
                    return true;
                }
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void abortConvert() {
        if (this.jnG != null) {
            try {
                this.jnG.abortConvert();
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
            VideoConvertUtil.this.jnN = 1;
            if (VideoConvertUtil.this.jnL != null) {
                VideoConvertUtil.this.jnL.onConvertSuccess();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertFailed() throws RemoteException {
            if (VideoConvertUtil.this.jnL != null) {
                VideoConvertUtil.this.jnL.onConvertFailed();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertProgress(int i) throws RemoteException {
            if (VideoConvertUtil.this.jnL != null) {
                VideoConvertUtil.this.jnL.onConvertProgress(i);
            }
            if ((VideoConvertUtil.this.jnJ != null && !VideoConvertUtil.this.jnJ.exists()) || (VideoConvertUtil.this.jnK != null && !VideoConvertUtil.this.jnK.exists())) {
                VideoConvertUtil.this.abortConvert();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertAborted() throws RemoteException {
            if (VideoConvertUtil.this.jnL != null) {
                VideoConvertUtil.this.jnL.onConvertAborted();
            }
        }
    }

    public void a(d dVar) {
        this.jnL = dVar;
    }

    public static String EM(String str) {
        if (str == null || str.isEmpty()) {
            return "";
        }
        try {
            byte[] digest = MessageDigest.getInstance("MD5").digest(str.getBytes(HTTP.UTF_8));
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
    public static int EN(String str) {
        int i = 0;
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            try {
                mediaMetadataRetriever.setDataSource(str);
                i = com.baidu.adp.lib.g.b.f(mediaMetadataRetriever.extractMetadata(20), 0);
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

    public static boolean cqR() {
        File file = new File(jnt);
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
