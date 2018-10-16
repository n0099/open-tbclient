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
    private IVideoConvertService hre;
    private String hrf;
    private String hrg;
    private File hrh;
    private File hri;
    private d hrj;
    private Context mContext;
    public static final String hqR = c.hqM;
    private static final String TAG = VideoConvertUtil.class.getSimpleName();
    private int hrl = -3;
    private boolean hrm = false;
    private boolean hrn = false;
    private int hro = 1;
    private ServiceConnection hrp = new ServiceConnection() { // from class: com.baidu.tieba.video.VideoConvertUtil.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            VideoConvertUtil.this.hre = IVideoConvertService.Stub.asInterface(iBinder);
            if (VideoConvertUtil.this.hrn) {
                VideoConvertUtil.this.bGl();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            if (VideoConvertUtil.this.hrn) {
                if (!VideoConvertUtil.this.hrm && VideoConvertUtil.this.hrl == -3 && VideoConvertUtil.this.hrj != null) {
                    VideoConvertUtil.this.hrj.onConvertFailed();
                }
                VideoConvertUtil.this.hrn = false;
            }
            VideoConvertUtil.this.hre = null;
        }
    };
    private IntenalConvertListener hrk = new IntenalConvertListener();

    public VideoConvertUtil(Context context) {
        this.mContext = context;
    }

    public void setConvertType(int i) {
        this.hro = i;
    }

    public void destroy() {
        this.hrm = true;
        abortConvert();
        bGk();
    }

    private void startService() {
        if (this.mContext != null) {
            Intent intent = new Intent("com.baidu.tieba.video.convert.VideoConvertService");
            intent.setPackage("com.baidu.tieba");
            this.mContext.startService(intent);
        }
    }

    private void Tr() {
        if (this.mContext != null) {
            Intent intent = new Intent("com.baidu.tieba.video.convert.VideoConvertService");
            intent.setPackage("com.baidu.tieba");
            this.mContext.bindService(intent, this.hrp, 1);
        }
    }

    private void bGk() {
        if (this.hre != null && this.mContext != null) {
            this.mContext.unbindService(this.hrp);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGl() {
        int i = -1;
        try {
            this.hre.setIVideoConvertListener(this.hrk);
            this.hre.setConvertType(this.hro);
            i = this.hre.doConvert(this.hrf, this.hrg);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        if (this.hrj != null) {
            if (i == 0) {
                this.hrj.bGi();
            } else {
                this.hrj.vv(i);
            }
        }
    }

    public void cL(String str, String str2) {
        this.hrn = true;
        this.hrm = false;
        this.hrl = -3;
        this.hrf = str;
        this.hrg = str2;
        this.hrh = new File(this.hrf);
        this.hri = new File(this.hrg);
        if (this.hre == null) {
            startService();
            Tr();
            return;
        }
        bGl();
    }

    public boolean isConvertRunning() {
        try {
            if (this.hre != null) {
                if (this.hre.isConvertRunning()) {
                    return true;
                }
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void abortConvert() {
        if (this.hre != null) {
            try {
                this.hre.abortConvert();
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
            VideoConvertUtil.this.hrl = 1;
            if (VideoConvertUtil.this.hrj != null) {
                VideoConvertUtil.this.hrj.onConvertSuccess();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertFailed() throws RemoteException {
            if (VideoConvertUtil.this.hrj != null) {
                VideoConvertUtil.this.hrj.onConvertFailed();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertProgress(int i) throws RemoteException {
            if (VideoConvertUtil.this.hrj != null) {
                VideoConvertUtil.this.hrj.onConvertProgress(i);
            }
            if ((VideoConvertUtil.this.hrh != null && !VideoConvertUtil.this.hrh.exists()) || (VideoConvertUtil.this.hri != null && !VideoConvertUtil.this.hri.exists())) {
                VideoConvertUtil.this.abortConvert();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertAborted() throws RemoteException {
            if (VideoConvertUtil.this.hrj != null) {
                VideoConvertUtil.this.hrj.onConvertAborted();
            }
        }
    }

    public void a(d dVar) {
        this.hrj = dVar;
    }

    public static String vP(String str) {
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
    public static int vQ(String str) {
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

    public static boolean bGm() {
        File file = new File(hqR);
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
