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
    private IVideoConvertService jxu;
    private String jxv;
    private String jxw;
    private File jxx;
    private File jxy;
    private d jxz;
    private Context mContext;
    public static final String jxh = c.jxc;
    private static final String TAG = VideoConvertUtil.class.getSimpleName();
    private int jxB = -3;
    private boolean jxC = false;
    private boolean jxD = false;
    private int jxE = 1;
    private ServiceConnection jxF = new ServiceConnection() { // from class: com.baidu.tieba.video.VideoConvertUtil.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            VideoConvertUtil.this.jxu = IVideoConvertService.Stub.asInterface(iBinder);
            if (VideoConvertUtil.this.jxD) {
                VideoConvertUtil.this.cuM();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            if (VideoConvertUtil.this.jxD) {
                if (!VideoConvertUtil.this.jxC && VideoConvertUtil.this.jxB == -3 && VideoConvertUtil.this.jxz != null) {
                    VideoConvertUtil.this.jxz.onConvertFailed();
                }
                VideoConvertUtil.this.jxD = false;
            }
            VideoConvertUtil.this.jxu = null;
        }
    };
    private IntenalConvertListener jxA = new IntenalConvertListener();

    public VideoConvertUtil(Context context) {
        this.mContext = context;
    }

    public void setConvertType(int i) {
        this.jxE = i;
    }

    public void destroy() {
        this.jxC = true;
        abortConvert();
        cuL();
    }

    private void startService() {
        if (this.mContext != null) {
            Intent intent = new Intent("com.baidu.tieba.video.convert.VideoConvertService");
            intent.setPackage("com.baidu.tieba");
            this.mContext.startService(intent);
        }
    }

    private void aBN() {
        if (this.mContext != null) {
            Intent intent = new Intent("com.baidu.tieba.video.convert.VideoConvertService");
            intent.setPackage("com.baidu.tieba");
            this.mContext.bindService(intent, this.jxF, 1);
        }
    }

    private void cuL() {
        if (this.jxu != null && this.mContext != null) {
            this.mContext.unbindService(this.jxF);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cuM() {
        int i = -1;
        try {
            this.jxu.setIVideoConvertListener(this.jxA);
            this.jxu.setConvertType(this.jxE);
            i = this.jxu.doConvert(this.jxv, this.jxw);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        if (this.jxz != null) {
            if (i == 0) {
                this.jxz.cuJ();
            } else {
                this.jxz.Ce(i);
            }
        }
    }

    public void es(String str, String str2) {
        this.jxD = true;
        this.jxC = false;
        this.jxB = -3;
        this.jxv = str;
        this.jxw = str2;
        this.jxx = new File(this.jxv);
        this.jxy = new File(this.jxw);
        if (this.jxu == null) {
            startService();
            aBN();
            return;
        }
        cuM();
    }

    public boolean isConvertRunning() {
        try {
            if (this.jxu != null) {
                if (this.jxu.isConvertRunning()) {
                    return true;
                }
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void abortConvert() {
        if (this.jxu != null) {
            try {
                this.jxu.abortConvert();
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
            VideoConvertUtil.this.jxB = 1;
            if (VideoConvertUtil.this.jxz != null) {
                VideoConvertUtil.this.jxz.onConvertSuccess();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertFailed() throws RemoteException {
            if (VideoConvertUtil.this.jxz != null) {
                VideoConvertUtil.this.jxz.onConvertFailed();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertProgress(int i) throws RemoteException {
            if (VideoConvertUtil.this.jxz != null) {
                VideoConvertUtil.this.jxz.onConvertProgress(i);
            }
            if ((VideoConvertUtil.this.jxx != null && !VideoConvertUtil.this.jxx.exists()) || (VideoConvertUtil.this.jxy != null && !VideoConvertUtil.this.jxy.exists())) {
                VideoConvertUtil.this.abortConvert();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertAborted() throws RemoteException {
            if (VideoConvertUtil.this.jxz != null) {
                VideoConvertUtil.this.jxz.onConvertAborted();
            }
        }
    }

    public void a(d dVar) {
        this.jxz = dVar;
    }

    public static String Gd(String str) {
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
    public static int Ge(String str) {
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

    public static boolean cuN() {
        File file = new File(jxh);
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
