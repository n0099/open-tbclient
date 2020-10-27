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
    private IVideoConvertService ngf;
    private String ngg;
    private String ngh;
    private File ngi;
    private File ngj;
    private d ngk;
    public static final String nfW = c.nfR;
    private static final String TAG = VideoConvertUtil.class.getSimpleName();
    private int ngm = -3;
    private boolean ngn = false;
    private boolean ngo = false;
    private int ngp = 1;
    private ServiceConnection ngq = new ServiceConnection() { // from class: com.baidu.tieba.video.VideoConvertUtil.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            VideoConvertUtil.this.ngf = IVideoConvertService.Stub.asInterface(iBinder);
            if (VideoConvertUtil.this.ngo) {
                VideoConvertUtil.this.dLQ();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            if (VideoConvertUtil.this.ngo) {
                if (!VideoConvertUtil.this.ngn && VideoConvertUtil.this.ngm == -3 && VideoConvertUtil.this.ngk != null) {
                    VideoConvertUtil.this.ngk.onConvertFailed();
                }
                VideoConvertUtil.this.ngo = false;
            }
            VideoConvertUtil.this.ngf = null;
        }
    };
    private IntenalConvertListener ngl = new IntenalConvertListener();

    public VideoConvertUtil(Context context) {
        this.mContext = context;
    }

    public void setConvertType(int i) {
        this.ngp = i;
    }

    public void destroy() {
        this.ngn = true;
        abortConvert();
        dLP();
    }

    private void startService() {
        if (this.mContext != null) {
            Intent intent = new Intent("com.baidu.tieba.video.convert.VideoConvertService");
            intent.setPackage("com.baidu.tieba");
            this.mContext.startService(intent);
        }
    }

    private void dLO() {
        if (this.mContext != null) {
            Intent intent = new Intent("com.baidu.tieba.video.convert.VideoConvertService");
            intent.setPackage("com.baidu.tieba");
            this.mContext.bindService(intent, this.ngq, 1);
        }
    }

    private void dLP() {
        if (this.ngf != null && this.mContext != null) {
            this.mContext.unbindService(this.ngq);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dLQ() {
        int i = -1;
        try {
            this.ngf.setIVideoConvertListener(this.ngl);
            this.ngf.setConvertType(this.ngp);
            i = this.ngf.doConvert(this.ngg, this.ngh);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        if (this.ngk != null) {
            if (i == 0) {
                this.ngk.dLM();
            } else {
                this.ngk.Kl(i);
            }
        }
    }

    public void gv(String str, String str2) {
        this.ngo = true;
        this.ngn = false;
        this.ngm = -3;
        this.ngg = str;
        this.ngh = str2;
        this.ngi = new File(this.ngg);
        this.ngj = new File(this.ngh);
        if (this.ngf == null) {
            startService();
            dLO();
            return;
        }
        dLQ();
    }

    public boolean isConvertRunning() {
        try {
            if (this.ngf != null) {
                if (this.ngf.isConvertRunning()) {
                    return true;
                }
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void abortConvert() {
        if (this.ngf != null) {
            try {
                this.ngf.abortConvert();
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
            VideoConvertUtil.this.ngm = 1;
            if (VideoConvertUtil.this.ngk != null) {
                VideoConvertUtil.this.ngk.onConvertSuccess();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertFailed() throws RemoteException {
            if (VideoConvertUtil.this.ngk != null) {
                VideoConvertUtil.this.ngk.onConvertFailed();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertProgress(int i) throws RemoteException {
            if (VideoConvertUtil.this.ngk != null) {
                VideoConvertUtil.this.ngk.onConvertProgress(i);
            }
            if ((VideoConvertUtil.this.ngi != null && !VideoConvertUtil.this.ngi.exists()) || (VideoConvertUtil.this.ngj != null && !VideoConvertUtil.this.ngj.exists())) {
                VideoConvertUtil.this.abortConvert();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertAborted() throws RemoteException {
            if (VideoConvertUtil.this.ngk != null) {
                VideoConvertUtil.this.ngk.onConvertAborted();
            }
        }
    }

    public void a(d dVar) {
        this.ngk = dVar;
    }

    public static String Tn(String str) {
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
    public static int To(String str) {
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

    public static boolean dLR() {
        File file = new File(nfW);
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
