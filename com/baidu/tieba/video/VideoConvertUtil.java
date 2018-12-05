package com.baidu.tieba.video;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.media.MediaMetadataRetriever;
import android.os.IBinder;
import android.os.RemoteException;
import com.baidu.searchbox.ng.ai.apps.util.AiAppEncryptUtils;
import com.baidu.tieba.video.convert.IVideoConvertListener;
import com.baidu.tieba.video.convert.IVideoConvertService;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes.dex */
public class VideoConvertUtil {
    private IVideoConvertService hAa;
    private String hAb;
    private String hAc;
    private File hAd;
    private File hAe;
    private d hAf;
    private Context mContext;
    public static final String hzN = c.hzI;
    private static final String TAG = VideoConvertUtil.class.getSimpleName();
    private int hAh = -3;
    private boolean hAi = false;
    private boolean hAj = false;
    private int hAk = 1;
    private ServiceConnection hAl = new ServiceConnection() { // from class: com.baidu.tieba.video.VideoConvertUtil.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            VideoConvertUtil.this.hAa = IVideoConvertService.Stub.asInterface(iBinder);
            if (VideoConvertUtil.this.hAj) {
                VideoConvertUtil.this.bHP();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            if (VideoConvertUtil.this.hAj) {
                if (!VideoConvertUtil.this.hAi && VideoConvertUtil.this.hAh == -3 && VideoConvertUtil.this.hAf != null) {
                    VideoConvertUtil.this.hAf.onConvertFailed();
                }
                VideoConvertUtil.this.hAj = false;
            }
            VideoConvertUtil.this.hAa = null;
        }
    };
    private IntenalConvertListener hAg = new IntenalConvertListener();

    public VideoConvertUtil(Context context) {
        this.mContext = context;
    }

    public void setConvertType(int i) {
        this.hAk = i;
    }

    public void destroy() {
        this.hAi = true;
        abortConvert();
        bHO();
    }

    private void startService() {
        if (this.mContext != null) {
            Intent intent = new Intent("com.baidu.tieba.video.convert.VideoConvertService");
            intent.setPackage("com.baidu.tieba");
            this.mContext.startService(intent);
        }
    }

    private void UG() {
        if (this.mContext != null) {
            Intent intent = new Intent("com.baidu.tieba.video.convert.VideoConvertService");
            intent.setPackage("com.baidu.tieba");
            this.mContext.bindService(intent, this.hAl, 1);
        }
    }

    private void bHO() {
        if (this.hAa != null && this.mContext != null) {
            this.mContext.unbindService(this.hAl);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHP() {
        int i = -1;
        try {
            this.hAa.setIVideoConvertListener(this.hAg);
            this.hAa.setConvertType(this.hAk);
            i = this.hAa.doConvert(this.hAb, this.hAc);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        if (this.hAf != null) {
            if (i == 0) {
                this.hAf.bHM();
            } else {
                this.hAf.wl(i);
            }
        }
    }

    public void cQ(String str, String str2) {
        this.hAj = true;
        this.hAi = false;
        this.hAh = -3;
        this.hAb = str;
        this.hAc = str2;
        this.hAd = new File(this.hAb);
        this.hAe = new File(this.hAc);
        if (this.hAa == null) {
            startService();
            UG();
            return;
        }
        bHP();
    }

    public boolean isConvertRunning() {
        try {
            if (this.hAa != null) {
                if (this.hAa.isConvertRunning()) {
                    return true;
                }
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void abortConvert() {
        if (this.hAa != null) {
            try {
                this.hAa.abortConvert();
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
            VideoConvertUtil.this.hAh = 1;
            if (VideoConvertUtil.this.hAf != null) {
                VideoConvertUtil.this.hAf.onConvertSuccess();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertFailed() throws RemoteException {
            if (VideoConvertUtil.this.hAf != null) {
                VideoConvertUtil.this.hAf.onConvertFailed();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertProgress(int i) throws RemoteException {
            if (VideoConvertUtil.this.hAf != null) {
                VideoConvertUtil.this.hAf.onConvertProgress(i);
            }
            if ((VideoConvertUtil.this.hAd != null && !VideoConvertUtil.this.hAd.exists()) || (VideoConvertUtil.this.hAe != null && !VideoConvertUtil.this.hAe.exists())) {
                VideoConvertUtil.this.abortConvert();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertAborted() throws RemoteException {
            if (VideoConvertUtil.this.hAf != null) {
                VideoConvertUtil.this.hAf.onConvertAborted();
            }
        }
    }

    public void a(d dVar) {
        this.hAf = dVar;
    }

    public static String wx(String str) {
        if (str == null || str.isEmpty()) {
            return "";
        }
        try {
            byte[] digest = MessageDigest.getInstance(AiAppEncryptUtils.ENCRYPT_MD5).digest(str.getBytes("UTF-8"));
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
    public static int wy(String str) {
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

    public static boolean bHQ() {
        File file = new File(hzN);
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
