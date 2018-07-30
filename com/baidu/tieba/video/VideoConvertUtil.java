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
    private IVideoConvertService hbV;
    private String hbW;
    private String hbX;
    private File hbY;
    private File hbZ;
    private d hca;
    private Context mContext;
    public static final String hbI = c.hbD;
    private static final String TAG = VideoConvertUtil.class.getSimpleName();
    private int hcc = -3;
    private boolean hcd = false;
    private boolean hce = false;
    private int hcf = 1;
    private ServiceConnection hcg = new ServiceConnection() { // from class: com.baidu.tieba.video.VideoConvertUtil.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            VideoConvertUtil.this.hbV = IVideoConvertService.Stub.asInterface(iBinder);
            if (VideoConvertUtil.this.hce) {
                VideoConvertUtil.this.bAg();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            if (VideoConvertUtil.this.hce) {
                if (!VideoConvertUtil.this.hcd && VideoConvertUtil.this.hcc == -3 && VideoConvertUtil.this.hca != null) {
                    VideoConvertUtil.this.hca.onConvertFailed();
                }
                VideoConvertUtil.this.hce = false;
            }
            VideoConvertUtil.this.hbV = null;
        }
    };
    private IntenalConvertListener hcb = new IntenalConvertListener();

    public VideoConvertUtil(Context context) {
        this.mContext = context;
    }

    public void setConvertType(int i) {
        this.hcf = i;
    }

    public void destroy() {
        this.hcd = true;
        abortConvert();
        bAf();
    }

    private void startService() {
        if (this.mContext != null) {
            Intent intent = new Intent("com.baidu.tieba.video.convert.VideoConvertService");
            intent.setPackage("com.baidu.tieba");
            this.mContext.startService(intent);
        }
    }

    private void PC() {
        if (this.mContext != null) {
            Intent intent = new Intent("com.baidu.tieba.video.convert.VideoConvertService");
            intent.setPackage("com.baidu.tieba");
            this.mContext.bindService(intent, this.hcg, 1);
        }
    }

    private void bAf() {
        if (this.hbV != null && this.mContext != null) {
            this.mContext.unbindService(this.hcg);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bAg() {
        int i = -1;
        try {
            this.hbV.setIVideoConvertListener(this.hcb);
            this.hbV.setConvertType(this.hcf);
            i = this.hbV.doConvert(this.hbW, this.hbX);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        if (this.hca != null) {
            if (i == 0) {
                this.hca.bAd();
            } else {
                this.hca.uy(i);
            }
        }
    }

    public void cq(String str, String str2) {
        this.hce = true;
        this.hcd = false;
        this.hcc = -3;
        this.hbW = str;
        this.hbX = str2;
        this.hbY = new File(this.hbW);
        this.hbZ = new File(this.hbX);
        if (this.hbV == null) {
            startService();
            PC();
            return;
        }
        bAg();
    }

    public boolean isConvertRunning() {
        try {
            if (this.hbV != null) {
                if (this.hbV.isConvertRunning()) {
                    return true;
                }
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void abortConvert() {
        if (this.hbV != null) {
            try {
                this.hbV.abortConvert();
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
            VideoConvertUtil.this.hcc = 1;
            if (VideoConvertUtil.this.hca != null) {
                VideoConvertUtil.this.hca.onConvertSuccess();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertFailed() throws RemoteException {
            if (VideoConvertUtil.this.hca != null) {
                VideoConvertUtil.this.hca.onConvertFailed();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertProgress(int i) throws RemoteException {
            if (VideoConvertUtil.this.hca != null) {
                VideoConvertUtil.this.hca.onConvertProgress(i);
            }
            if ((VideoConvertUtil.this.hbY != null && !VideoConvertUtil.this.hbY.exists()) || (VideoConvertUtil.this.hbZ != null && !VideoConvertUtil.this.hbZ.exists())) {
                VideoConvertUtil.this.abortConvert();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertAborted() throws RemoteException {
            if (VideoConvertUtil.this.hca != null) {
                VideoConvertUtil.this.hca.onConvertAborted();
            }
        }
    }

    public void a(d dVar) {
        this.hca = dVar;
    }

    public static String uA(String str) {
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
    public static int uB(String str) {
        int i = 0;
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            try {
                mediaMetadataRetriever.setDataSource(str);
                i = com.baidu.adp.lib.g.b.g(mediaMetadataRetriever.extractMetadata(20), 0);
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

    public static boolean bAh() {
        File file = new File(hbI);
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
