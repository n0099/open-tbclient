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
    private IVideoConvertService iUT;
    private String iUU;
    private String iUV;
    private File iUW;
    private File iUX;
    private d iUY;
    private Context mContext;
    public static final String iUG = c.iUB;
    private static final String TAG = VideoConvertUtil.class.getSimpleName();
    private int iVa = -3;
    private boolean iVb = false;
    private boolean iVc = false;
    private int iVd = 1;
    private ServiceConnection iVe = new ServiceConnection() { // from class: com.baidu.tieba.video.VideoConvertUtil.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            VideoConvertUtil.this.iUT = IVideoConvertService.Stub.asInterface(iBinder);
            if (VideoConvertUtil.this.iVc) {
                VideoConvertUtil.this.ciN();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            if (VideoConvertUtil.this.iVc) {
                if (!VideoConvertUtil.this.iVb && VideoConvertUtil.this.iVa == -3 && VideoConvertUtil.this.iUY != null) {
                    VideoConvertUtil.this.iUY.onConvertFailed();
                }
                VideoConvertUtil.this.iVc = false;
            }
            VideoConvertUtil.this.iUT = null;
        }
    };
    private IntenalConvertListener iUZ = new IntenalConvertListener();

    public VideoConvertUtil(Context context) {
        this.mContext = context;
    }

    public void setConvertType(int i) {
        this.iVd = i;
    }

    public void destroy() {
        this.iVb = true;
        abortConvert();
        ciM();
    }

    private void startService() {
        if (this.mContext != null) {
            Intent intent = new Intent("com.baidu.tieba.video.convert.VideoConvertService");
            intent.setPackage("com.baidu.tieba");
            this.mContext.startService(intent);
        }
    }

    private void avd() {
        if (this.mContext != null) {
            Intent intent = new Intent("com.baidu.tieba.video.convert.VideoConvertService");
            intent.setPackage("com.baidu.tieba");
            this.mContext.bindService(intent, this.iVe, 1);
        }
    }

    private void ciM() {
        if (this.iUT != null && this.mContext != null) {
            this.mContext.unbindService(this.iVe);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ciN() {
        int i = -1;
        try {
            this.iUT.setIVideoConvertListener(this.iUZ);
            this.iUT.setConvertType(this.iVd);
            i = this.iUT.doConvert(this.iUU, this.iUV);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        if (this.iUY != null) {
            if (i == 0) {
                this.iUY.ciK();
            } else {
                this.iUY.An(i);
            }
        }
    }

    public void eb(String str, String str2) {
        this.iVc = true;
        this.iVb = false;
        this.iVa = -3;
        this.iUU = str;
        this.iUV = str2;
        this.iUW = new File(this.iUU);
        this.iUX = new File(this.iUV);
        if (this.iUT == null) {
            startService();
            avd();
            return;
        }
        ciN();
    }

    public boolean isConvertRunning() {
        try {
            if (this.iUT != null) {
                if (this.iUT.isConvertRunning()) {
                    return true;
                }
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void abortConvert() {
        if (this.iUT != null) {
            try {
                this.iUT.abortConvert();
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
            VideoConvertUtil.this.iVa = 1;
            if (VideoConvertUtil.this.iUY != null) {
                VideoConvertUtil.this.iUY.onConvertSuccess();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertFailed() throws RemoteException {
            if (VideoConvertUtil.this.iUY != null) {
                VideoConvertUtil.this.iUY.onConvertFailed();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertProgress(int i) throws RemoteException {
            if (VideoConvertUtil.this.iUY != null) {
                VideoConvertUtil.this.iUY.onConvertProgress(i);
            }
            if ((VideoConvertUtil.this.iUW != null && !VideoConvertUtil.this.iUW.exists()) || (VideoConvertUtil.this.iUX != null && !VideoConvertUtil.this.iUX.exists())) {
                VideoConvertUtil.this.abortConvert();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertAborted() throws RemoteException {
            if (VideoConvertUtil.this.iUY != null) {
                VideoConvertUtil.this.iUY.onConvertAborted();
            }
        }
    }

    public void a(d dVar) {
        this.iUY = dVar;
    }

    public static String Dr(String str) {
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
    public static int Ds(String str) {
        int i = 0;
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            try {
                mediaMetadataRetriever.setDataSource(str);
                i = com.baidu.adp.lib.g.b.l(mediaMetadataRetriever.extractMetadata(20), 0);
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

    public static boolean ciO() {
        File file = new File(iUG);
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
