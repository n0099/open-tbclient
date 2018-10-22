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
    private IVideoConvertService hrf;
    private String hrg;
    private String hrh;
    private File hri;
    private File hrj;
    private d hrk;
    private Context mContext;
    public static final String hqS = c.hqN;
    private static final String TAG = VideoConvertUtil.class.getSimpleName();
    private int hrm = -3;
    private boolean hrn = false;
    private boolean hro = false;
    private int hrp = 1;
    private ServiceConnection hrq = new ServiceConnection() { // from class: com.baidu.tieba.video.VideoConvertUtil.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            VideoConvertUtil.this.hrf = IVideoConvertService.Stub.asInterface(iBinder);
            if (VideoConvertUtil.this.hro) {
                VideoConvertUtil.this.bGl();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            if (VideoConvertUtil.this.hro) {
                if (!VideoConvertUtil.this.hrn && VideoConvertUtil.this.hrm == -3 && VideoConvertUtil.this.hrk != null) {
                    VideoConvertUtil.this.hrk.onConvertFailed();
                }
                VideoConvertUtil.this.hro = false;
            }
            VideoConvertUtil.this.hrf = null;
        }
    };
    private IntenalConvertListener hrl = new IntenalConvertListener();

    public VideoConvertUtil(Context context) {
        this.mContext = context;
    }

    public void setConvertType(int i) {
        this.hrp = i;
    }

    public void destroy() {
        this.hrn = true;
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
            this.mContext.bindService(intent, this.hrq, 1);
        }
    }

    private void bGk() {
        if (this.hrf != null && this.mContext != null) {
            this.mContext.unbindService(this.hrq);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGl() {
        int i = -1;
        try {
            this.hrf.setIVideoConvertListener(this.hrl);
            this.hrf.setConvertType(this.hrp);
            i = this.hrf.doConvert(this.hrg, this.hrh);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        if (this.hrk != null) {
            if (i == 0) {
                this.hrk.bGi();
            } else {
                this.hrk.vv(i);
            }
        }
    }

    public void cL(String str, String str2) {
        this.hro = true;
        this.hrn = false;
        this.hrm = -3;
        this.hrg = str;
        this.hrh = str2;
        this.hri = new File(this.hrg);
        this.hrj = new File(this.hrh);
        if (this.hrf == null) {
            startService();
            Tr();
            return;
        }
        bGl();
    }

    public boolean isConvertRunning() {
        try {
            if (this.hrf != null) {
                if (this.hrf.isConvertRunning()) {
                    return true;
                }
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void abortConvert() {
        if (this.hrf != null) {
            try {
                this.hrf.abortConvert();
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
            VideoConvertUtil.this.hrm = 1;
            if (VideoConvertUtil.this.hrk != null) {
                VideoConvertUtil.this.hrk.onConvertSuccess();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertFailed() throws RemoteException {
            if (VideoConvertUtil.this.hrk != null) {
                VideoConvertUtil.this.hrk.onConvertFailed();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertProgress(int i) throws RemoteException {
            if (VideoConvertUtil.this.hrk != null) {
                VideoConvertUtil.this.hrk.onConvertProgress(i);
            }
            if ((VideoConvertUtil.this.hri != null && !VideoConvertUtil.this.hri.exists()) || (VideoConvertUtil.this.hrj != null && !VideoConvertUtil.this.hrj.exists())) {
                VideoConvertUtil.this.abortConvert();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertAborted() throws RemoteException {
            if (VideoConvertUtil.this.hrk != null) {
                VideoConvertUtil.this.hrk.onConvertAborted();
            }
        }
    }

    public void a(d dVar) {
        this.hrk = dVar;
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
        File file = new File(hqS);
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
