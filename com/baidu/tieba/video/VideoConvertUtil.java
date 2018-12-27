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
    private IVideoConvertService hDl;
    private String hDm;
    private String hDn;
    private File hDo;
    private File hDp;
    private d hDq;
    private Context mContext;
    public static final String hCY = c.hCT;
    private static final String TAG = VideoConvertUtil.class.getSimpleName();
    private int hDs = -3;
    private boolean hDt = false;
    private boolean hDu = false;
    private int hDv = 1;
    private ServiceConnection hDw = new ServiceConnection() { // from class: com.baidu.tieba.video.VideoConvertUtil.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            VideoConvertUtil.this.hDl = IVideoConvertService.Stub.asInterface(iBinder);
            if (VideoConvertUtil.this.hDu) {
                VideoConvertUtil.this.bIE();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            if (VideoConvertUtil.this.hDu) {
                if (!VideoConvertUtil.this.hDt && VideoConvertUtil.this.hDs == -3 && VideoConvertUtil.this.hDq != null) {
                    VideoConvertUtil.this.hDq.onConvertFailed();
                }
                VideoConvertUtil.this.hDu = false;
            }
            VideoConvertUtil.this.hDl = null;
        }
    };
    private IntenalConvertListener hDr = new IntenalConvertListener();

    public VideoConvertUtil(Context context) {
        this.mContext = context;
    }

    public void setConvertType(int i) {
        this.hDv = i;
    }

    public void destroy() {
        this.hDt = true;
        abortConvert();
        bID();
    }

    private void startService() {
        if (this.mContext != null) {
            Intent intent = new Intent("com.baidu.tieba.video.convert.VideoConvertService");
            intent.setPackage("com.baidu.tieba");
            this.mContext.startService(intent);
        }
    }

    private void UI() {
        if (this.mContext != null) {
            Intent intent = new Intent("com.baidu.tieba.video.convert.VideoConvertService");
            intent.setPackage("com.baidu.tieba");
            this.mContext.bindService(intent, this.hDw, 1);
        }
    }

    private void bID() {
        if (this.hDl != null && this.mContext != null) {
            this.mContext.unbindService(this.hDw);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIE() {
        int i = -1;
        try {
            this.hDl.setIVideoConvertListener(this.hDr);
            this.hDl.setConvertType(this.hDv);
            i = this.hDl.doConvert(this.hDm, this.hDn);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        if (this.hDq != null) {
            if (i == 0) {
                this.hDq.bIB();
            } else {
                this.hDq.wy(i);
            }
        }
    }

    public void cQ(String str, String str2) {
        this.hDu = true;
        this.hDt = false;
        this.hDs = -3;
        this.hDm = str;
        this.hDn = str2;
        this.hDo = new File(this.hDm);
        this.hDp = new File(this.hDn);
        if (this.hDl == null) {
            startService();
            UI();
            return;
        }
        bIE();
    }

    public boolean isConvertRunning() {
        try {
            if (this.hDl != null) {
                if (this.hDl.isConvertRunning()) {
                    return true;
                }
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void abortConvert() {
        if (this.hDl != null) {
            try {
                this.hDl.abortConvert();
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
            VideoConvertUtil.this.hDs = 1;
            if (VideoConvertUtil.this.hDq != null) {
                VideoConvertUtil.this.hDq.onConvertSuccess();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertFailed() throws RemoteException {
            if (VideoConvertUtil.this.hDq != null) {
                VideoConvertUtil.this.hDq.onConvertFailed();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertProgress(int i) throws RemoteException {
            if (VideoConvertUtil.this.hDq != null) {
                VideoConvertUtil.this.hDq.onConvertProgress(i);
            }
            if ((VideoConvertUtil.this.hDo != null && !VideoConvertUtil.this.hDo.exists()) || (VideoConvertUtil.this.hDp != null && !VideoConvertUtil.this.hDp.exists())) {
                VideoConvertUtil.this.abortConvert();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertAborted() throws RemoteException {
            if (VideoConvertUtil.this.hDq != null) {
                VideoConvertUtil.this.hDq.onConvertAborted();
            }
        }
    }

    public void a(d dVar) {
        this.hDq = dVar;
    }

    public static String wA(String str) {
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
    public static int wB(String str) {
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

    public static boolean bIF() {
        File file = new File(hCY);
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
