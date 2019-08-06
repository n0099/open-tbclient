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
    private IVideoConvertService juY;
    private String juZ;
    private String jva;
    private File jvb;
    private File jvc;
    private d jvd;
    private Context mContext;
    public static final String juL = c.juG;
    private static final String TAG = VideoConvertUtil.class.getSimpleName();
    private int jvf = -3;
    private boolean jvg = false;
    private boolean jvh = false;
    private int jvi = 1;
    private ServiceConnection jvj = new ServiceConnection() { // from class: com.baidu.tieba.video.VideoConvertUtil.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            VideoConvertUtil.this.juY = IVideoConvertService.Stub.asInterface(iBinder);
            if (VideoConvertUtil.this.jvh) {
                VideoConvertUtil.this.ctY();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            if (VideoConvertUtil.this.jvh) {
                if (!VideoConvertUtil.this.jvg && VideoConvertUtil.this.jvf == -3 && VideoConvertUtil.this.jvd != null) {
                    VideoConvertUtil.this.jvd.onConvertFailed();
                }
                VideoConvertUtil.this.jvh = false;
            }
            VideoConvertUtil.this.juY = null;
        }
    };
    private IntenalConvertListener jve = new IntenalConvertListener();

    public VideoConvertUtil(Context context) {
        this.mContext = context;
    }

    public void setConvertType(int i) {
        this.jvi = i;
    }

    public void destroy() {
        this.jvg = true;
        abortConvert();
        ctX();
    }

    private void startService() {
        if (this.mContext != null) {
            Intent intent = new Intent("com.baidu.tieba.video.convert.VideoConvertService");
            intent.setPackage("com.baidu.tieba");
            this.mContext.startService(intent);
        }
    }

    private void aBz() {
        if (this.mContext != null) {
            Intent intent = new Intent("com.baidu.tieba.video.convert.VideoConvertService");
            intent.setPackage("com.baidu.tieba");
            this.mContext.bindService(intent, this.jvj, 1);
        }
    }

    private void ctX() {
        if (this.juY != null && this.mContext != null) {
            this.mContext.unbindService(this.jvj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ctY() {
        int i = -1;
        try {
            this.juY.setIVideoConvertListener(this.jve);
            this.juY.setConvertType(this.jvi);
            i = this.juY.doConvert(this.juZ, this.jva);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        if (this.jvd != null) {
            if (i == 0) {
                this.jvd.ctV();
            } else {
                this.jvd.Ca(i);
            }
        }
    }

    public void er(String str, String str2) {
        this.jvh = true;
        this.jvg = false;
        this.jvf = -3;
        this.juZ = str;
        this.jva = str2;
        this.jvb = new File(this.juZ);
        this.jvc = new File(this.jva);
        if (this.juY == null) {
            startService();
            aBz();
            return;
        }
        ctY();
    }

    public boolean isConvertRunning() {
        try {
            if (this.juY != null) {
                if (this.juY.isConvertRunning()) {
                    return true;
                }
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void abortConvert() {
        if (this.juY != null) {
            try {
                this.juY.abortConvert();
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
            VideoConvertUtil.this.jvf = 1;
            if (VideoConvertUtil.this.jvd != null) {
                VideoConvertUtil.this.jvd.onConvertSuccess();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertFailed() throws RemoteException {
            if (VideoConvertUtil.this.jvd != null) {
                VideoConvertUtil.this.jvd.onConvertFailed();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertProgress(int i) throws RemoteException {
            if (VideoConvertUtil.this.jvd != null) {
                VideoConvertUtil.this.jvd.onConvertProgress(i);
            }
            if ((VideoConvertUtil.this.jvb != null && !VideoConvertUtil.this.jvb.exists()) || (VideoConvertUtil.this.jvc != null && !VideoConvertUtil.this.jvc.exists())) {
                VideoConvertUtil.this.abortConvert();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertAborted() throws RemoteException {
            if (VideoConvertUtil.this.jvd != null) {
                VideoConvertUtil.this.jvd.onConvertAborted();
            }
        }
    }

    public void a(d dVar) {
        this.jvd = dVar;
    }

    public static String FD(String str) {
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
    public static int FE(String str) {
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

    public static boolean ctZ() {
        File file = new File(juL);
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
