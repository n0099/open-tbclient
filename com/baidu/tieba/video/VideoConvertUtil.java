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
    private IVideoConvertService hbW;
    private String hbX;
    private String hbY;
    private File hbZ;
    private File hca;
    private d hcb;
    private Context mContext;
    public static final String hbJ = c.hbE;
    private static final String TAG = VideoConvertUtil.class.getSimpleName();
    private int hcd = -3;
    private boolean hce = false;
    private boolean hcf = false;
    private int hcg = 1;
    private ServiceConnection hch = new ServiceConnection() { // from class: com.baidu.tieba.video.VideoConvertUtil.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            VideoConvertUtil.this.hbW = IVideoConvertService.Stub.asInterface(iBinder);
            if (VideoConvertUtil.this.hcf) {
                VideoConvertUtil.this.bAi();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            if (VideoConvertUtil.this.hcf) {
                if (!VideoConvertUtil.this.hce && VideoConvertUtil.this.hcd == -3 && VideoConvertUtil.this.hcb != null) {
                    VideoConvertUtil.this.hcb.onConvertFailed();
                }
                VideoConvertUtil.this.hcf = false;
            }
            VideoConvertUtil.this.hbW = null;
        }
    };
    private IntenalConvertListener hcc = new IntenalConvertListener();

    public VideoConvertUtil(Context context) {
        this.mContext = context;
    }

    public void setConvertType(int i) {
        this.hcg = i;
    }

    public void destroy() {
        this.hce = true;
        abortConvert();
        bAh();
    }

    private void startService() {
        if (this.mContext != null) {
            Intent intent = new Intent("com.baidu.tieba.video.convert.VideoConvertService");
            intent.setPackage("com.baidu.tieba");
            this.mContext.startService(intent);
        }
    }

    private void PI() {
        if (this.mContext != null) {
            Intent intent = new Intent("com.baidu.tieba.video.convert.VideoConvertService");
            intent.setPackage("com.baidu.tieba");
            this.mContext.bindService(intent, this.hch, 1);
        }
    }

    private void bAh() {
        if (this.hbW != null && this.mContext != null) {
            this.mContext.unbindService(this.hch);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bAi() {
        int i = -1;
        try {
            this.hbW.setIVideoConvertListener(this.hcc);
            this.hbW.setConvertType(this.hcg);
            i = this.hbW.doConvert(this.hbX, this.hbY);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        if (this.hcb != null) {
            if (i == 0) {
                this.hcb.bAf();
            } else {
                this.hcb.uy(i);
            }
        }
    }

    public void cq(String str, String str2) {
        this.hcf = true;
        this.hce = false;
        this.hcd = -3;
        this.hbX = str;
        this.hbY = str2;
        this.hbZ = new File(this.hbX);
        this.hca = new File(this.hbY);
        if (this.hbW == null) {
            startService();
            PI();
            return;
        }
        bAi();
    }

    public boolean isConvertRunning() {
        try {
            if (this.hbW != null) {
                if (this.hbW.isConvertRunning()) {
                    return true;
                }
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void abortConvert() {
        if (this.hbW != null) {
            try {
                this.hbW.abortConvert();
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
            VideoConvertUtil.this.hcd = 1;
            if (VideoConvertUtil.this.hcb != null) {
                VideoConvertUtil.this.hcb.onConvertSuccess();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertFailed() throws RemoteException {
            if (VideoConvertUtil.this.hcb != null) {
                VideoConvertUtil.this.hcb.onConvertFailed();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertProgress(int i) throws RemoteException {
            if (VideoConvertUtil.this.hcb != null) {
                VideoConvertUtil.this.hcb.onConvertProgress(i);
            }
            if ((VideoConvertUtil.this.hbZ != null && !VideoConvertUtil.this.hbZ.exists()) || (VideoConvertUtil.this.hca != null && !VideoConvertUtil.this.hca.exists())) {
                VideoConvertUtil.this.abortConvert();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertAborted() throws RemoteException {
            if (VideoConvertUtil.this.hcb != null) {
                VideoConvertUtil.this.hcb.onConvertAborted();
            }
        }
    }

    public void a(d dVar) {
        this.hcb = dVar;
    }

    public static String uE(String str) {
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
    public static int uF(String str) {
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

    public static boolean bAj() {
        File file = new File(hbJ);
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
