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
    private IVideoConvertService gLb;
    private String gLc;
    private String gLd;
    private File gLe;
    private File gLf;
    private c gLg;
    private Context mContext;
    public static final String gKO = b.gKJ;
    private static final String TAG = VideoConvertUtil.class.getSimpleName();
    private int gLi = -3;
    private boolean gLj = false;
    private boolean gLk = false;
    private int gLl = 1;
    private ServiceConnection gLm = new ServiceConnection() { // from class: com.baidu.tieba.video.VideoConvertUtil.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            VideoConvertUtil.this.gLb = IVideoConvertService.Stub.asInterface(iBinder);
            if (VideoConvertUtil.this.gLk) {
                VideoConvertUtil.this.bvS();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            if (VideoConvertUtil.this.gLk) {
                if (!VideoConvertUtil.this.gLj && VideoConvertUtil.this.gLi == -3 && VideoConvertUtil.this.gLg != null) {
                    VideoConvertUtil.this.gLg.onConvertFailed();
                }
                VideoConvertUtil.this.gLk = false;
            }
            VideoConvertUtil.this.gLb = null;
        }
    };
    private IntenalConvertListener gLh = new IntenalConvertListener();

    public VideoConvertUtil(Context context) {
        this.mContext = context;
    }

    public void setConvertType(int i) {
        this.gLl = i;
    }

    public void destroy() {
        this.gLj = true;
        abortConvert();
        bvR();
    }

    private void startService() {
        if (this.mContext != null) {
            Intent intent = new Intent("com.baidu.tieba.video.convert.VideoConvertService");
            intent.setPackage("com.baidu.tieba");
            this.mContext.startService(intent);
        }
    }

    private void LA() {
        if (this.mContext != null) {
            Intent intent = new Intent("com.baidu.tieba.video.convert.VideoConvertService");
            intent.setPackage("com.baidu.tieba");
            this.mContext.bindService(intent, this.gLm, 1);
        }
    }

    private void bvR() {
        if (this.gLb != null && this.mContext != null) {
            this.mContext.unbindService(this.gLm);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bvS() {
        int i = -1;
        try {
            this.gLb.setIVideoConvertListener(this.gLh);
            this.gLb.setConvertType(this.gLl);
            i = this.gLb.doConvert(this.gLc, this.gLd);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        if (this.gLg != null) {
            if (i == 0) {
                this.gLg.bvP();
            } else {
                this.gLg.ue(i);
            }
        }
    }

    public void ch(String str, String str2) {
        this.gLk = true;
        this.gLj = false;
        this.gLi = -3;
        this.gLc = str;
        this.gLd = str2;
        this.gLe = new File(this.gLc);
        this.gLf = new File(this.gLd);
        if (this.gLb == null) {
            startService();
            LA();
            return;
        }
        bvS();
    }

    public boolean isConvertRunning() {
        try {
            if (this.gLb != null) {
                if (this.gLb.isConvertRunning()) {
                    return true;
                }
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void abortConvert() {
        if (this.gLb != null) {
            try {
                this.gLb.abortConvert();
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
            VideoConvertUtil.this.gLi = 1;
            if (VideoConvertUtil.this.gLg != null) {
                VideoConvertUtil.this.gLg.onConvertSuccess();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertFailed() throws RemoteException {
            if (VideoConvertUtil.this.gLg != null) {
                VideoConvertUtil.this.gLg.onConvertFailed();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertProgress(int i) throws RemoteException {
            if (VideoConvertUtil.this.gLg != null) {
                VideoConvertUtil.this.gLg.onConvertProgress(i);
            }
            if ((VideoConvertUtil.this.gLe != null && !VideoConvertUtil.this.gLe.exists()) || (VideoConvertUtil.this.gLf != null && !VideoConvertUtil.this.gLf.exists())) {
                VideoConvertUtil.this.abortConvert();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertAborted() throws RemoteException {
            if (VideoConvertUtil.this.gLg != null) {
                VideoConvertUtil.this.gLg.onConvertAborted();
            }
        }
    }

    public void a(c cVar) {
        this.gLg = cVar;
    }

    public static String tM(String str) {
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
    public static int tN(String str) {
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

    public static boolean bvT() {
        File file = new File(gKO);
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
