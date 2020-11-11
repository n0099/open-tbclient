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
    private IVideoConvertService nmb;
    private String nmc;
    private String nmd;
    private File nme;
    private File nmf;
    private d nmg;
    public static final String nlS = c.nlN;
    private static final String TAG = VideoConvertUtil.class.getSimpleName();
    private int nmi = -3;
    private boolean nmj = false;
    private boolean nmk = false;
    private int nml = 1;
    private ServiceConnection nmm = new ServiceConnection() { // from class: com.baidu.tieba.video.VideoConvertUtil.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            VideoConvertUtil.this.nmb = IVideoConvertService.Stub.asInterface(iBinder);
            if (VideoConvertUtil.this.nmk) {
                VideoConvertUtil.this.dOs();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            if (VideoConvertUtil.this.nmk) {
                if (!VideoConvertUtil.this.nmj && VideoConvertUtil.this.nmi == -3 && VideoConvertUtil.this.nmg != null) {
                    VideoConvertUtil.this.nmg.onConvertFailed();
                }
                VideoConvertUtil.this.nmk = false;
            }
            VideoConvertUtil.this.nmb = null;
        }
    };
    private IntenalConvertListener nmh = new IntenalConvertListener();

    public VideoConvertUtil(Context context) {
        this.mContext = context;
    }

    public void setConvertType(int i) {
        this.nml = i;
    }

    public void destroy() {
        this.nmj = true;
        abortConvert();
        dOr();
    }

    private void startService() {
        if (this.mContext != null) {
            Intent intent = new Intent("com.baidu.tieba.video.convert.VideoConvertService");
            intent.setPackage("com.baidu.tieba");
            this.mContext.startService(intent);
        }
    }

    private void dOq() {
        if (this.mContext != null) {
            Intent intent = new Intent("com.baidu.tieba.video.convert.VideoConvertService");
            intent.setPackage("com.baidu.tieba");
            this.mContext.bindService(intent, this.nmm, 1);
        }
    }

    private void dOr() {
        if (this.nmb != null && this.mContext != null) {
            this.mContext.unbindService(this.nmm);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dOs() {
        int i = -1;
        try {
            this.nmb.setIVideoConvertListener(this.nmh);
            this.nmb.setConvertType(this.nml);
            i = this.nmb.doConvert(this.nmc, this.nmd);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        if (this.nmg != null) {
            if (i == 0) {
                this.nmg.dOo();
            } else {
                this.nmg.Ky(i);
            }
        }
    }

    public void gv(String str, String str2) {
        this.nmk = true;
        this.nmj = false;
        this.nmi = -3;
        this.nmc = str;
        this.nmd = str2;
        this.nme = new File(this.nmc);
        this.nmf = new File(this.nmd);
        if (this.nmb == null) {
            startService();
            dOq();
            return;
        }
        dOs();
    }

    public boolean isConvertRunning() {
        try {
            if (this.nmb != null) {
                if (this.nmb.isConvertRunning()) {
                    return true;
                }
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void abortConvert() {
        if (this.nmb != null) {
            try {
                this.nmb.abortConvert();
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
            VideoConvertUtil.this.nmi = 1;
            if (VideoConvertUtil.this.nmg != null) {
                VideoConvertUtil.this.nmg.onConvertSuccess();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertFailed() throws RemoteException {
            if (VideoConvertUtil.this.nmg != null) {
                VideoConvertUtil.this.nmg.onConvertFailed();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertProgress(int i) throws RemoteException {
            if (VideoConvertUtil.this.nmg != null) {
                VideoConvertUtil.this.nmg.onConvertProgress(i);
            }
            if ((VideoConvertUtil.this.nme != null && !VideoConvertUtil.this.nme.exists()) || (VideoConvertUtil.this.nmf != null && !VideoConvertUtil.this.nmf.exists())) {
                VideoConvertUtil.this.abortConvert();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertAborted() throws RemoteException {
            if (VideoConvertUtil.this.nmg != null) {
                VideoConvertUtil.this.nmg.onConvertAborted();
            }
        }
    }

    public void a(d dVar) {
        this.nmg = dVar;
    }

    public static String TE(String str) {
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
    public static int TF(String str) {
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

    public static boolean dOt() {
        File file = new File(nlS);
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
