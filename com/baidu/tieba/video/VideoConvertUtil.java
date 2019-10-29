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
    private IVideoConvertService jxm;
    private String jxn;
    private String jxo;
    private File jxp;
    private File jxq;
    private d jxr;
    private Context mContext;
    public static final String jwZ = c.jwU;
    private static final String TAG = VideoConvertUtil.class.getSimpleName();
    private int jxt = -3;
    private boolean jxu = false;
    private boolean jxv = false;
    private int jxw = 1;
    private ServiceConnection jxx = new ServiceConnection() { // from class: com.baidu.tieba.video.VideoConvertUtil.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            VideoConvertUtil.this.jxm = IVideoConvertService.Stub.asInterface(iBinder);
            if (VideoConvertUtil.this.jxv) {
                VideoConvertUtil.this.csB();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            if (VideoConvertUtil.this.jxv) {
                if (!VideoConvertUtil.this.jxu && VideoConvertUtil.this.jxt == -3 && VideoConvertUtil.this.jxr != null) {
                    VideoConvertUtil.this.jxr.onConvertFailed();
                }
                VideoConvertUtil.this.jxv = false;
            }
            VideoConvertUtil.this.jxm = null;
        }
    };
    private IntenalConvertListener jxs = new IntenalConvertListener();

    public VideoConvertUtil(Context context) {
        this.mContext = context;
    }

    public void setConvertType(int i) {
        this.jxw = i;
    }

    public void destroy() {
        this.jxu = true;
        abortConvert();
        csA();
    }

    private void startService() {
        if (this.mContext != null) {
            Intent intent = new Intent("com.baidu.tieba.video.convert.VideoConvertService");
            intent.setPackage("com.baidu.tieba");
            this.mContext.startService(intent);
        }
    }

    private void aBX() {
        if (this.mContext != null) {
            Intent intent = new Intent("com.baidu.tieba.video.convert.VideoConvertService");
            intent.setPackage("com.baidu.tieba");
            this.mContext.bindService(intent, this.jxx, 1);
        }
    }

    private void csA() {
        if (this.jxm != null && this.mContext != null) {
            this.mContext.unbindService(this.jxx);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void csB() {
        int i = -1;
        try {
            this.jxm.setIVideoConvertListener(this.jxs);
            this.jxm.setConvertType(this.jxw);
            i = this.jxm.doConvert(this.jxn, this.jxo);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        if (this.jxr != null) {
            if (i == 0) {
                this.jxr.csy();
            } else {
                this.jxr.AK(i);
            }
        }
    }

    public void ee(String str, String str2) {
        this.jxv = true;
        this.jxu = false;
        this.jxt = -3;
        this.jxn = str;
        this.jxo = str2;
        this.jxp = new File(this.jxn);
        this.jxq = new File(this.jxo);
        if (this.jxm == null) {
            startService();
            aBX();
            return;
        }
        csB();
    }

    public boolean isConvertRunning() {
        try {
            if (this.jxm != null) {
                if (this.jxm.isConvertRunning()) {
                    return true;
                }
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void abortConvert() {
        if (this.jxm != null) {
            try {
                this.jxm.abortConvert();
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
            VideoConvertUtil.this.jxt = 1;
            if (VideoConvertUtil.this.jxr != null) {
                VideoConvertUtil.this.jxr.onConvertSuccess();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertFailed() throws RemoteException {
            if (VideoConvertUtil.this.jxr != null) {
                VideoConvertUtil.this.jxr.onConvertFailed();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertProgress(int i) throws RemoteException {
            if (VideoConvertUtil.this.jxr != null) {
                VideoConvertUtil.this.jxr.onConvertProgress(i);
            }
            if ((VideoConvertUtil.this.jxp != null && !VideoConvertUtil.this.jxp.exists()) || (VideoConvertUtil.this.jxq != null && !VideoConvertUtil.this.jxq.exists())) {
                VideoConvertUtil.this.abortConvert();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertAborted() throws RemoteException {
            if (VideoConvertUtil.this.jxr != null) {
                VideoConvertUtil.this.jxr.onConvertAborted();
            }
        }
    }

    public void a(d dVar) {
        this.jxr = dVar;
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

    public static boolean csC() {
        File file = new File(jwZ);
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
