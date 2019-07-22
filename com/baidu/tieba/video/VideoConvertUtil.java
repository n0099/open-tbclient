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
    private IVideoConvertService jtR;
    private String jtS;
    private String jtT;
    private File jtU;
    private File jtV;
    private d jtW;
    private Context mContext;
    public static final String jtE = c.jtz;
    private static final String TAG = VideoConvertUtil.class.getSimpleName();
    private int jtY = -3;
    private boolean jtZ = false;
    private boolean jua = false;
    private int jub = 1;
    private ServiceConnection juc = new ServiceConnection() { // from class: com.baidu.tieba.video.VideoConvertUtil.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            VideoConvertUtil.this.jtR = IVideoConvertService.Stub.asInterface(iBinder);
            if (VideoConvertUtil.this.jua) {
                VideoConvertUtil.this.ctC();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            if (VideoConvertUtil.this.jua) {
                if (!VideoConvertUtil.this.jtZ && VideoConvertUtil.this.jtY == -3 && VideoConvertUtil.this.jtW != null) {
                    VideoConvertUtil.this.jtW.onConvertFailed();
                }
                VideoConvertUtil.this.jua = false;
            }
            VideoConvertUtil.this.jtR = null;
        }
    };
    private IntenalConvertListener jtX = new IntenalConvertListener();

    public VideoConvertUtil(Context context) {
        this.mContext = context;
    }

    public void setConvertType(int i) {
        this.jub = i;
    }

    public void destroy() {
        this.jtZ = true;
        abortConvert();
        ctB();
    }

    private void startService() {
        if (this.mContext != null) {
            Intent intent = new Intent("com.baidu.tieba.video.convert.VideoConvertService");
            intent.setPackage("com.baidu.tieba");
            this.mContext.startService(intent);
        }
    }

    private void aBx() {
        if (this.mContext != null) {
            Intent intent = new Intent("com.baidu.tieba.video.convert.VideoConvertService");
            intent.setPackage("com.baidu.tieba");
            this.mContext.bindService(intent, this.juc, 1);
        }
    }

    private void ctB() {
        if (this.jtR != null && this.mContext != null) {
            this.mContext.unbindService(this.juc);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ctC() {
        int i = -1;
        try {
            this.jtR.setIVideoConvertListener(this.jtX);
            this.jtR.setConvertType(this.jub);
            i = this.jtR.doConvert(this.jtS, this.jtT);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        if (this.jtW != null) {
            if (i == 0) {
                this.jtW.ctz();
            } else {
                this.jtW.BY(i);
            }
        }
    }

    public void er(String str, String str2) {
        this.jua = true;
        this.jtZ = false;
        this.jtY = -3;
        this.jtS = str;
        this.jtT = str2;
        this.jtU = new File(this.jtS);
        this.jtV = new File(this.jtT);
        if (this.jtR == null) {
            startService();
            aBx();
            return;
        }
        ctC();
    }

    public boolean isConvertRunning() {
        try {
            if (this.jtR != null) {
                if (this.jtR.isConvertRunning()) {
                    return true;
                }
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void abortConvert() {
        if (this.jtR != null) {
            try {
                this.jtR.abortConvert();
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
            VideoConvertUtil.this.jtY = 1;
            if (VideoConvertUtil.this.jtW != null) {
                VideoConvertUtil.this.jtW.onConvertSuccess();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertFailed() throws RemoteException {
            if (VideoConvertUtil.this.jtW != null) {
                VideoConvertUtil.this.jtW.onConvertFailed();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertProgress(int i) throws RemoteException {
            if (VideoConvertUtil.this.jtW != null) {
                VideoConvertUtil.this.jtW.onConvertProgress(i);
            }
            if ((VideoConvertUtil.this.jtU != null && !VideoConvertUtil.this.jtU.exists()) || (VideoConvertUtil.this.jtV != null && !VideoConvertUtil.this.jtV.exists())) {
                VideoConvertUtil.this.abortConvert();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertAborted() throws RemoteException {
            if (VideoConvertUtil.this.jtW != null) {
                VideoConvertUtil.this.jtW.onConvertAborted();
            }
        }
    }

    public void a(d dVar) {
        this.jtW = dVar;
    }

    public static String FC(String str) {
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
    public static int FD(String str) {
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

    public static boolean ctD() {
        File file = new File(jtE);
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
