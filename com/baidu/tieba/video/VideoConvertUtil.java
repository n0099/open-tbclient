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
    private IVideoConvertService jnK;
    private String jnL;
    private String jnM;
    private File jnN;
    private File jnO;
    private d jnP;
    private Context mContext;
    public static final String jnx = c.jns;
    private static final String TAG = VideoConvertUtil.class.getSimpleName();
    private int jnR = -3;
    private boolean jnS = false;
    private boolean jnT = false;
    private int jnU = 1;
    private ServiceConnection jnV = new ServiceConnection() { // from class: com.baidu.tieba.video.VideoConvertUtil.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            VideoConvertUtil.this.jnK = IVideoConvertService.Stub.asInterface(iBinder);
            if (VideoConvertUtil.this.jnT) {
                VideoConvertUtil.this.cqR();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            if (VideoConvertUtil.this.jnT) {
                if (!VideoConvertUtil.this.jnS && VideoConvertUtil.this.jnR == -3 && VideoConvertUtil.this.jnP != null) {
                    VideoConvertUtil.this.jnP.onConvertFailed();
                }
                VideoConvertUtil.this.jnT = false;
            }
            VideoConvertUtil.this.jnK = null;
        }
    };
    private IntenalConvertListener jnQ = new IntenalConvertListener();

    public VideoConvertUtil(Context context) {
        this.mContext = context;
    }

    public void setConvertType(int i) {
        this.jnU = i;
    }

    public void destroy() {
        this.jnS = true;
        abortConvert();
        cqQ();
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
            this.mContext.bindService(intent, this.jnV, 1);
        }
    }

    private void cqQ() {
        if (this.jnK != null && this.mContext != null) {
            this.mContext.unbindService(this.jnV);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cqR() {
        int i = -1;
        try {
            this.jnK.setIVideoConvertListener(this.jnQ);
            this.jnK.setConvertType(this.jnU);
            i = this.jnK.doConvert(this.jnL, this.jnM);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        if (this.jnP != null) {
            if (i == 0) {
                this.jnP.cqO();
            } else {
                this.jnP.Br(i);
            }
        }
    }

    public void eq(String str, String str2) {
        this.jnT = true;
        this.jnS = false;
        this.jnR = -3;
        this.jnL = str;
        this.jnM = str2;
        this.jnN = new File(this.jnL);
        this.jnO = new File(this.jnM);
        if (this.jnK == null) {
            startService();
            aAi();
            return;
        }
        cqR();
    }

    public boolean isConvertRunning() {
        try {
            if (this.jnK != null) {
                if (this.jnK.isConvertRunning()) {
                    return true;
                }
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void abortConvert() {
        if (this.jnK != null) {
            try {
                this.jnK.abortConvert();
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
            VideoConvertUtil.this.jnR = 1;
            if (VideoConvertUtil.this.jnP != null) {
                VideoConvertUtil.this.jnP.onConvertSuccess();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertFailed() throws RemoteException {
            if (VideoConvertUtil.this.jnP != null) {
                VideoConvertUtil.this.jnP.onConvertFailed();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertProgress(int i) throws RemoteException {
            if (VideoConvertUtil.this.jnP != null) {
                VideoConvertUtil.this.jnP.onConvertProgress(i);
            }
            if ((VideoConvertUtil.this.jnN != null && !VideoConvertUtil.this.jnN.exists()) || (VideoConvertUtil.this.jnO != null && !VideoConvertUtil.this.jnO.exists())) {
                VideoConvertUtil.this.abortConvert();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertAborted() throws RemoteException {
            if (VideoConvertUtil.this.jnP != null) {
                VideoConvertUtil.this.jnP.onConvertAborted();
            }
        }
    }

    public void a(d dVar) {
        this.jnP = dVar;
    }

    public static String EO(String str) {
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
    public static int EP(String str) {
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

    public static boolean cqS() {
        File file = new File(jnx);
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
