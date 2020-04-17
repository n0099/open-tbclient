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
    private IVideoConvertService lhe;
    private String lhf;
    private String lhg;
    private File lhh;
    private File lhi;
    private d lhj;
    private Context mContext;
    public static final String lgV = c.lgQ;
    private static final String TAG = VideoConvertUtil.class.getSimpleName();
    private int lhl = -3;
    private boolean lhm = false;
    private boolean lhn = false;
    private int lho = 1;
    private ServiceConnection lhp = new ServiceConnection() { // from class: com.baidu.tieba.video.VideoConvertUtil.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            VideoConvertUtil.this.lhe = IVideoConvertService.Stub.asInterface(iBinder);
            if (VideoConvertUtil.this.lhn) {
                VideoConvertUtil.this.daw();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            if (VideoConvertUtil.this.lhn) {
                if (!VideoConvertUtil.this.lhm && VideoConvertUtil.this.lhl == -3 && VideoConvertUtil.this.lhj != null) {
                    VideoConvertUtil.this.lhj.onConvertFailed();
                }
                VideoConvertUtil.this.lhn = false;
            }
            VideoConvertUtil.this.lhe = null;
        }
    };
    private IntenalConvertListener lhk = new IntenalConvertListener();

    public VideoConvertUtil(Context context) {
        this.mContext = context;
    }

    public void setConvertType(int i) {
        this.lho = i;
    }

    public void destroy() {
        this.lhm = true;
        abortConvert();
        dav();
    }

    private void startService() {
        if (this.mContext != null) {
            Intent intent = new Intent("com.baidu.tieba.video.convert.VideoConvertService");
            intent.setPackage("com.baidu.tieba");
            this.mContext.startService(intent);
        }
    }

    private void beK() {
        if (this.mContext != null) {
            Intent intent = new Intent("com.baidu.tieba.video.convert.VideoConvertService");
            intent.setPackage("com.baidu.tieba");
            this.mContext.bindService(intent, this.lhp, 1);
        }
    }

    private void dav() {
        if (this.lhe != null && this.mContext != null) {
            this.mContext.unbindService(this.lhp);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void daw() {
        int i = -1;
        try {
            this.lhe.setIVideoConvertListener(this.lhk);
            this.lhe.setConvertType(this.lho);
            i = this.lhe.doConvert(this.lhf, this.lhg);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        if (this.lhj != null) {
            if (i == 0) {
                this.lhj.dat();
            } else {
                this.lhj.Ec(i);
            }
        }
    }

    public void eV(String str, String str2) {
        this.lhn = true;
        this.lhm = false;
        this.lhl = -3;
        this.lhf = str;
        this.lhg = str2;
        this.lhh = new File(this.lhf);
        this.lhi = new File(this.lhg);
        if (this.lhe == null) {
            startService();
            beK();
            return;
        }
        daw();
    }

    public boolean isConvertRunning() {
        try {
            if (this.lhe != null) {
                if (this.lhe.isConvertRunning()) {
                    return true;
                }
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void abortConvert() {
        if (this.lhe != null) {
            try {
                this.lhe.abortConvert();
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
            VideoConvertUtil.this.lhl = 1;
            if (VideoConvertUtil.this.lhj != null) {
                VideoConvertUtil.this.lhj.onConvertSuccess();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertFailed() throws RemoteException {
            if (VideoConvertUtil.this.lhj != null) {
                VideoConvertUtil.this.lhj.onConvertFailed();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertProgress(int i) throws RemoteException {
            if (VideoConvertUtil.this.lhj != null) {
                VideoConvertUtil.this.lhj.onConvertProgress(i);
            }
            if ((VideoConvertUtil.this.lhh != null && !VideoConvertUtil.this.lhh.exists()) || (VideoConvertUtil.this.lhi != null && !VideoConvertUtil.this.lhi.exists())) {
                VideoConvertUtil.this.abortConvert();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertAborted() throws RemoteException {
            if (VideoConvertUtil.this.lhj != null) {
                VideoConvertUtil.this.lhj.onConvertAborted();
            }
        }
    }

    public void a(d dVar) {
        this.lhj = dVar;
    }

    public static String LB(String str) {
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
    public static int LC(String str) {
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

    public static boolean dax() {
        File file = new File(lgV);
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
