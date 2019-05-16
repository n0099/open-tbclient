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
    private IVideoConvertService jnF;
    private String jnG;
    private String jnH;
    private File jnI;
    private File jnJ;
    private d jnK;
    private Context mContext;
    public static final String jns = c.jnn;
    private static final String TAG = VideoConvertUtil.class.getSimpleName();
    private int jnM = -3;
    private boolean jnN = false;
    private boolean jnO = false;
    private int jnP = 1;
    private ServiceConnection jnQ = new ServiceConnection() { // from class: com.baidu.tieba.video.VideoConvertUtil.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            VideoConvertUtil.this.jnF = IVideoConvertService.Stub.asInterface(iBinder);
            if (VideoConvertUtil.this.jnO) {
                VideoConvertUtil.this.cqO();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            if (VideoConvertUtil.this.jnO) {
                if (!VideoConvertUtil.this.jnN && VideoConvertUtil.this.jnM == -3 && VideoConvertUtil.this.jnK != null) {
                    VideoConvertUtil.this.jnK.onConvertFailed();
                }
                VideoConvertUtil.this.jnO = false;
            }
            VideoConvertUtil.this.jnF = null;
        }
    };
    private IntenalConvertListener jnL = new IntenalConvertListener();

    public VideoConvertUtil(Context context) {
        this.mContext = context;
    }

    public void setConvertType(int i) {
        this.jnP = i;
    }

    public void destroy() {
        this.jnN = true;
        abortConvert();
        cqN();
    }

    private void startService() {
        if (this.mContext != null) {
            Intent intent = new Intent("com.baidu.tieba.video.convert.VideoConvertService");
            intent.setPackage("com.baidu.tieba");
            this.mContext.startService(intent);
        }
    }

    private void aAf() {
        if (this.mContext != null) {
            Intent intent = new Intent("com.baidu.tieba.video.convert.VideoConvertService");
            intent.setPackage("com.baidu.tieba");
            this.mContext.bindService(intent, this.jnQ, 1);
        }
    }

    private void cqN() {
        if (this.jnF != null && this.mContext != null) {
            this.mContext.unbindService(this.jnQ);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cqO() {
        int i = -1;
        try {
            this.jnF.setIVideoConvertListener(this.jnL);
            this.jnF.setConvertType(this.jnP);
            i = this.jnF.doConvert(this.jnG, this.jnH);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        if (this.jnK != null) {
            if (i == 0) {
                this.jnK.cqL();
            } else {
                this.jnK.Br(i);
            }
        }
    }

    public void eq(String str, String str2) {
        this.jnO = true;
        this.jnN = false;
        this.jnM = -3;
        this.jnG = str;
        this.jnH = str2;
        this.jnI = new File(this.jnG);
        this.jnJ = new File(this.jnH);
        if (this.jnF == null) {
            startService();
            aAf();
            return;
        }
        cqO();
    }

    public boolean isConvertRunning() {
        try {
            if (this.jnF != null) {
                if (this.jnF.isConvertRunning()) {
                    return true;
                }
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void abortConvert() {
        if (this.jnF != null) {
            try {
                this.jnF.abortConvert();
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
            VideoConvertUtil.this.jnM = 1;
            if (VideoConvertUtil.this.jnK != null) {
                VideoConvertUtil.this.jnK.onConvertSuccess();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertFailed() throws RemoteException {
            if (VideoConvertUtil.this.jnK != null) {
                VideoConvertUtil.this.jnK.onConvertFailed();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertProgress(int i) throws RemoteException {
            if (VideoConvertUtil.this.jnK != null) {
                VideoConvertUtil.this.jnK.onConvertProgress(i);
            }
            if ((VideoConvertUtil.this.jnI != null && !VideoConvertUtil.this.jnI.exists()) || (VideoConvertUtil.this.jnJ != null && !VideoConvertUtil.this.jnJ.exists())) {
                VideoConvertUtil.this.abortConvert();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertAborted() throws RemoteException {
            if (VideoConvertUtil.this.jnK != null) {
                VideoConvertUtil.this.jnK.onConvertAborted();
            }
        }
    }

    public void a(d dVar) {
        this.jnK = dVar;
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

    public static boolean cqP() {
        File file = new File(jns);
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
