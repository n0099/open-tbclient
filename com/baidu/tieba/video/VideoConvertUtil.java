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
    private IVideoConvertService lhi;
    private String lhj;
    private String lhk;
    private File lhl;
    private File lhm;
    private d lhn;
    private Context mContext;
    public static final String lgZ = c.lgU;
    private static final String TAG = VideoConvertUtil.class.getSimpleName();
    private int lhp = -3;
    private boolean lhq = false;
    private boolean lhr = false;
    private int lhs = 1;
    private ServiceConnection lht = new ServiceConnection() { // from class: com.baidu.tieba.video.VideoConvertUtil.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            VideoConvertUtil.this.lhi = IVideoConvertService.Stub.asInterface(iBinder);
            if (VideoConvertUtil.this.lhr) {
                VideoConvertUtil.this.dat();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            if (VideoConvertUtil.this.lhr) {
                if (!VideoConvertUtil.this.lhq && VideoConvertUtil.this.lhp == -3 && VideoConvertUtil.this.lhn != null) {
                    VideoConvertUtil.this.lhn.onConvertFailed();
                }
                VideoConvertUtil.this.lhr = false;
            }
            VideoConvertUtil.this.lhi = null;
        }
    };
    private IntenalConvertListener lho = new IntenalConvertListener();

    public VideoConvertUtil(Context context) {
        this.mContext = context;
    }

    public void setConvertType(int i) {
        this.lhs = i;
    }

    public void destroy() {
        this.lhq = true;
        abortConvert();
        das();
    }

    private void startService() {
        if (this.mContext != null) {
            Intent intent = new Intent("com.baidu.tieba.video.convert.VideoConvertService");
            intent.setPackage("com.baidu.tieba");
            this.mContext.startService(intent);
        }
    }

    private void beI() {
        if (this.mContext != null) {
            Intent intent = new Intent("com.baidu.tieba.video.convert.VideoConvertService");
            intent.setPackage("com.baidu.tieba");
            this.mContext.bindService(intent, this.lht, 1);
        }
    }

    private void das() {
        if (this.lhi != null && this.mContext != null) {
            this.mContext.unbindService(this.lht);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dat() {
        int i = -1;
        try {
            this.lhi.setIVideoConvertListener(this.lho);
            this.lhi.setConvertType(this.lhs);
            i = this.lhi.doConvert(this.lhj, this.lhk);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        if (this.lhn != null) {
            if (i == 0) {
                this.lhn.daq();
            } else {
                this.lhn.Ec(i);
            }
        }
    }

    public void eV(String str, String str2) {
        this.lhr = true;
        this.lhq = false;
        this.lhp = -3;
        this.lhj = str;
        this.lhk = str2;
        this.lhl = new File(this.lhj);
        this.lhm = new File(this.lhk);
        if (this.lhi == null) {
            startService();
            beI();
            return;
        }
        dat();
    }

    public boolean isConvertRunning() {
        try {
            if (this.lhi != null) {
                if (this.lhi.isConvertRunning()) {
                    return true;
                }
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void abortConvert() {
        if (this.lhi != null) {
            try {
                this.lhi.abortConvert();
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
            VideoConvertUtil.this.lhp = 1;
            if (VideoConvertUtil.this.lhn != null) {
                VideoConvertUtil.this.lhn.onConvertSuccess();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertFailed() throws RemoteException {
            if (VideoConvertUtil.this.lhn != null) {
                VideoConvertUtil.this.lhn.onConvertFailed();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertProgress(int i) throws RemoteException {
            if (VideoConvertUtil.this.lhn != null) {
                VideoConvertUtil.this.lhn.onConvertProgress(i);
            }
            if ((VideoConvertUtil.this.lhl != null && !VideoConvertUtil.this.lhl.exists()) || (VideoConvertUtil.this.lhm != null && !VideoConvertUtil.this.lhm.exists())) {
                VideoConvertUtil.this.abortConvert();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertAborted() throws RemoteException {
            if (VideoConvertUtil.this.lhn != null) {
                VideoConvertUtil.this.lhn.onConvertAborted();
            }
        }
    }

    public void a(d dVar) {
        this.lhn = dVar;
    }

    public static String LE(String str) {
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
    public static int LF(String str) {
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

    public static boolean dau() {
        File file = new File(lgZ);
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
