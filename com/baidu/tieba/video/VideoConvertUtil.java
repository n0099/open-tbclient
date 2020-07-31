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
    private Context mContext;
    private IVideoConvertService mcb;
    private String mcc;
    private String mcd;
    private File mce;
    private File mcf;
    private d mcg;
    public static final String mbS = c.mbN;
    private static final String TAG = VideoConvertUtil.class.getSimpleName();
    private int mci = -3;
    private boolean mcj = false;
    private boolean mck = false;
    private int mcl = 1;
    private ServiceConnection mcm = new ServiceConnection() { // from class: com.baidu.tieba.video.VideoConvertUtil.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            VideoConvertUtil.this.mcb = IVideoConvertService.Stub.asInterface(iBinder);
            if (VideoConvertUtil.this.mck) {
                VideoConvertUtil.this.dpx();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            if (VideoConvertUtil.this.mck) {
                if (!VideoConvertUtil.this.mcj && VideoConvertUtil.this.mci == -3 && VideoConvertUtil.this.mcg != null) {
                    VideoConvertUtil.this.mcg.onConvertFailed();
                }
                VideoConvertUtil.this.mck = false;
            }
            VideoConvertUtil.this.mcb = null;
        }
    };
    private IntenalConvertListener mch = new IntenalConvertListener();

    public VideoConvertUtil(Context context) {
        this.mContext = context;
    }

    public void setConvertType(int i) {
        this.mcl = i;
    }

    public void destroy() {
        this.mcj = true;
        abortConvert();
        dpw();
    }

    private void startService() {
        if (this.mContext != null) {
            Intent intent = new Intent("com.baidu.tieba.video.convert.VideoConvertService");
            intent.setPackage("com.baidu.tieba");
            this.mContext.startService(intent);
        }
    }

    private void dpv() {
        if (this.mContext != null) {
            Intent intent = new Intent("com.baidu.tieba.video.convert.VideoConvertService");
            intent.setPackage("com.baidu.tieba");
            this.mContext.bindService(intent, this.mcm, 1);
        }
    }

    private void dpw() {
        if (this.mcb != null && this.mContext != null) {
            this.mContext.unbindService(this.mcm);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dpx() {
        int i = -1;
        try {
            this.mcb.setIVideoConvertListener(this.mch);
            this.mcb.setConvertType(this.mcl);
            i = this.mcb.doConvert(this.mcc, this.mcd);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        if (this.mcg != null) {
            if (i == 0) {
                this.mcg.dpt();
            } else {
                this.mcg.Gn(i);
            }
        }
    }

    public void fF(String str, String str2) {
        this.mck = true;
        this.mcj = false;
        this.mci = -3;
        this.mcc = str;
        this.mcd = str2;
        this.mce = new File(this.mcc);
        this.mcf = new File(this.mcd);
        if (this.mcb == null) {
            startService();
            dpv();
            return;
        }
        dpx();
    }

    public boolean isConvertRunning() {
        try {
            if (this.mcb != null) {
                if (this.mcb.isConvertRunning()) {
                    return true;
                }
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void abortConvert() {
        if (this.mcb != null) {
            try {
                this.mcb.abortConvert();
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
            VideoConvertUtil.this.mci = 1;
            if (VideoConvertUtil.this.mcg != null) {
                VideoConvertUtil.this.mcg.onConvertSuccess();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertFailed() throws RemoteException {
            if (VideoConvertUtil.this.mcg != null) {
                VideoConvertUtil.this.mcg.onConvertFailed();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertProgress(int i) throws RemoteException {
            if (VideoConvertUtil.this.mcg != null) {
                VideoConvertUtil.this.mcg.onConvertProgress(i);
            }
            if ((VideoConvertUtil.this.mce != null && !VideoConvertUtil.this.mce.exists()) || (VideoConvertUtil.this.mcf != null && !VideoConvertUtil.this.mcf.exists())) {
                VideoConvertUtil.this.abortConvert();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertAborted() throws RemoteException {
            if (VideoConvertUtil.this.mcg != null) {
                VideoConvertUtil.this.mcg.onConvertAborted();
            }
        }
    }

    public void a(d dVar) {
        this.mcg = dVar;
    }

    public static String OC(String str) {
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
    public static int OD(String str) {
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

    public static boolean dpy() {
        File file = new File(mbS);
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
