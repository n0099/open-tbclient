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
    private IVideoConvertService mcd;
    private String mce;
    private String mcf;
    private File mcg;
    private File mch;
    private d mci;
    public static final String mbU = c.mbP;
    private static final String TAG = VideoConvertUtil.class.getSimpleName();
    private int mck = -3;
    private boolean mcl = false;
    private boolean mcm = false;
    private int mcn = 1;
    private ServiceConnection mco = new ServiceConnection() { // from class: com.baidu.tieba.video.VideoConvertUtil.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            VideoConvertUtil.this.mcd = IVideoConvertService.Stub.asInterface(iBinder);
            if (VideoConvertUtil.this.mcm) {
                VideoConvertUtil.this.dpy();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            if (VideoConvertUtil.this.mcm) {
                if (!VideoConvertUtil.this.mcl && VideoConvertUtil.this.mck == -3 && VideoConvertUtil.this.mci != null) {
                    VideoConvertUtil.this.mci.onConvertFailed();
                }
                VideoConvertUtil.this.mcm = false;
            }
            VideoConvertUtil.this.mcd = null;
        }
    };
    private IntenalConvertListener mcj = new IntenalConvertListener();

    public VideoConvertUtil(Context context) {
        this.mContext = context;
    }

    public void setConvertType(int i) {
        this.mcn = i;
    }

    public void destroy() {
        this.mcl = true;
        abortConvert();
        dpx();
    }

    private void startService() {
        if (this.mContext != null) {
            Intent intent = new Intent("com.baidu.tieba.video.convert.VideoConvertService");
            intent.setPackage("com.baidu.tieba");
            this.mContext.startService(intent);
        }
    }

    private void dpw() {
        if (this.mContext != null) {
            Intent intent = new Intent("com.baidu.tieba.video.convert.VideoConvertService");
            intent.setPackage("com.baidu.tieba");
            this.mContext.bindService(intent, this.mco, 1);
        }
    }

    private void dpx() {
        if (this.mcd != null && this.mContext != null) {
            this.mContext.unbindService(this.mco);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dpy() {
        int i = -1;
        try {
            this.mcd.setIVideoConvertListener(this.mcj);
            this.mcd.setConvertType(this.mcn);
            i = this.mcd.doConvert(this.mce, this.mcf);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        if (this.mci != null) {
            if (i == 0) {
                this.mci.dpu();
            } else {
                this.mci.Gn(i);
            }
        }
    }

    public void fF(String str, String str2) {
        this.mcm = true;
        this.mcl = false;
        this.mck = -3;
        this.mce = str;
        this.mcf = str2;
        this.mcg = new File(this.mce);
        this.mch = new File(this.mcf);
        if (this.mcd == null) {
            startService();
            dpw();
            return;
        }
        dpy();
    }

    public boolean isConvertRunning() {
        try {
            if (this.mcd != null) {
                if (this.mcd.isConvertRunning()) {
                    return true;
                }
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void abortConvert() {
        if (this.mcd != null) {
            try {
                this.mcd.abortConvert();
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
            VideoConvertUtil.this.mck = 1;
            if (VideoConvertUtil.this.mci != null) {
                VideoConvertUtil.this.mci.onConvertSuccess();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertFailed() throws RemoteException {
            if (VideoConvertUtil.this.mci != null) {
                VideoConvertUtil.this.mci.onConvertFailed();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertProgress(int i) throws RemoteException {
            if (VideoConvertUtil.this.mci != null) {
                VideoConvertUtil.this.mci.onConvertProgress(i);
            }
            if ((VideoConvertUtil.this.mcg != null && !VideoConvertUtil.this.mcg.exists()) || (VideoConvertUtil.this.mch != null && !VideoConvertUtil.this.mch.exists())) {
                VideoConvertUtil.this.abortConvert();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertAborted() throws RemoteException {
            if (VideoConvertUtil.this.mci != null) {
                VideoConvertUtil.this.mci.onConvertAborted();
            }
        }
    }

    public void a(d dVar) {
        this.mci = dVar;
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

    public static boolean dpz() {
        File file = new File(mbU);
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
