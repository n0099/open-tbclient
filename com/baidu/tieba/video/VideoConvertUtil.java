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
    private d jwA;
    private IVideoConvertService jwv;
    private String jww;
    private String jwx;
    private File jwy;
    private File jwz;
    private Context mContext;
    public static final String jwi = c.jwd;
    private static final String TAG = VideoConvertUtil.class.getSimpleName();
    private int jwC = -3;
    private boolean jwD = false;
    private boolean jwE = false;
    private int jwF = 1;
    private ServiceConnection jwG = new ServiceConnection() { // from class: com.baidu.tieba.video.VideoConvertUtil.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            VideoConvertUtil.this.jwv = IVideoConvertService.Stub.asInterface(iBinder);
            if (VideoConvertUtil.this.jwE) {
                VideoConvertUtil.this.csz();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            if (VideoConvertUtil.this.jwE) {
                if (!VideoConvertUtil.this.jwD && VideoConvertUtil.this.jwC == -3 && VideoConvertUtil.this.jwA != null) {
                    VideoConvertUtil.this.jwA.onConvertFailed();
                }
                VideoConvertUtil.this.jwE = false;
            }
            VideoConvertUtil.this.jwv = null;
        }
    };
    private IntenalConvertListener jwB = new IntenalConvertListener();

    public VideoConvertUtil(Context context) {
        this.mContext = context;
    }

    public void setConvertType(int i) {
        this.jwF = i;
    }

    public void destroy() {
        this.jwD = true;
        abortConvert();
        csy();
    }

    private void startService() {
        if (this.mContext != null) {
            Intent intent = new Intent("com.baidu.tieba.video.convert.VideoConvertService");
            intent.setPackage("com.baidu.tieba");
            this.mContext.startService(intent);
        }
    }

    private void aBV() {
        if (this.mContext != null) {
            Intent intent = new Intent("com.baidu.tieba.video.convert.VideoConvertService");
            intent.setPackage("com.baidu.tieba");
            this.mContext.bindService(intent, this.jwG, 1);
        }
    }

    private void csy() {
        if (this.jwv != null && this.mContext != null) {
            this.mContext.unbindService(this.jwG);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void csz() {
        int i = -1;
        try {
            this.jwv.setIVideoConvertListener(this.jwB);
            this.jwv.setConvertType(this.jwF);
            i = this.jwv.doConvert(this.jww, this.jwx);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        if (this.jwA != null) {
            if (i == 0) {
                this.jwA.csw();
            } else {
                this.jwA.AJ(i);
            }
        }
    }

    public void ee(String str, String str2) {
        this.jwE = true;
        this.jwD = false;
        this.jwC = -3;
        this.jww = str;
        this.jwx = str2;
        this.jwy = new File(this.jww);
        this.jwz = new File(this.jwx);
        if (this.jwv == null) {
            startService();
            aBV();
            return;
        }
        csz();
    }

    public boolean isConvertRunning() {
        try {
            if (this.jwv != null) {
                if (this.jwv.isConvertRunning()) {
                    return true;
                }
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void abortConvert() {
        if (this.jwv != null) {
            try {
                this.jwv.abortConvert();
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
            VideoConvertUtil.this.jwC = 1;
            if (VideoConvertUtil.this.jwA != null) {
                VideoConvertUtil.this.jwA.onConvertSuccess();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertFailed() throws RemoteException {
            if (VideoConvertUtil.this.jwA != null) {
                VideoConvertUtil.this.jwA.onConvertFailed();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertProgress(int i) throws RemoteException {
            if (VideoConvertUtil.this.jwA != null) {
                VideoConvertUtil.this.jwA.onConvertProgress(i);
            }
            if ((VideoConvertUtil.this.jwy != null && !VideoConvertUtil.this.jwy.exists()) || (VideoConvertUtil.this.jwz != null && !VideoConvertUtil.this.jwz.exists())) {
                VideoConvertUtil.this.abortConvert();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertAborted() throws RemoteException {
            if (VideoConvertUtil.this.jwA != null) {
                VideoConvertUtil.this.jwA.onConvertAborted();
            }
        }
    }

    public void a(d dVar) {
        this.jwA = dVar;
    }

    public static String EF(String str) {
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
    public static int EG(String str) {
        int i = 0;
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            try {
                mediaMetadataRetriever.setDataSource(str);
                i = com.baidu.adp.lib.g.b.toInt(mediaMetadataRetriever.extractMetadata(20), 0);
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

    public static boolean csA() {
        File file = new File(jwi);
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
