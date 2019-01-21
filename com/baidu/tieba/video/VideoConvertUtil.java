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
    private IVideoConvertService hEt;
    private String hEu;
    private String hEv;
    private File hEw;
    private File hEx;
    private d hEy;
    private Context mContext;
    public static final String hEg = c.hEb;
    private static final String TAG = VideoConvertUtil.class.getSimpleName();
    private int hEA = -3;
    private boolean hEB = false;
    private boolean hEC = false;
    private int hED = 1;
    private ServiceConnection hEE = new ServiceConnection() { // from class: com.baidu.tieba.video.VideoConvertUtil.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            VideoConvertUtil.this.hEt = IVideoConvertService.Stub.asInterface(iBinder);
            if (VideoConvertUtil.this.hEC) {
                VideoConvertUtil.this.bJn();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            if (VideoConvertUtil.this.hEC) {
                if (!VideoConvertUtil.this.hEB && VideoConvertUtil.this.hEA == -3 && VideoConvertUtil.this.hEy != null) {
                    VideoConvertUtil.this.hEy.onConvertFailed();
                }
                VideoConvertUtil.this.hEC = false;
            }
            VideoConvertUtil.this.hEt = null;
        }
    };
    private IntenalConvertListener hEz = new IntenalConvertListener();

    public VideoConvertUtil(Context context) {
        this.mContext = context;
    }

    public void setConvertType(int i) {
        this.hED = i;
    }

    public void destroy() {
        this.hEB = true;
        abortConvert();
        bJm();
    }

    private void startService() {
        if (this.mContext != null) {
            Intent intent = new Intent("com.baidu.tieba.video.convert.VideoConvertService");
            intent.setPackage("com.baidu.tieba");
            this.mContext.startService(intent);
        }
    }

    private void Ve() {
        if (this.mContext != null) {
            Intent intent = new Intent("com.baidu.tieba.video.convert.VideoConvertService");
            intent.setPackage("com.baidu.tieba");
            this.mContext.bindService(intent, this.hEE, 1);
        }
    }

    private void bJm() {
        if (this.hEt != null && this.mContext != null) {
            this.mContext.unbindService(this.hEE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJn() {
        int i = -1;
        try {
            this.hEt.setIVideoConvertListener(this.hEz);
            this.hEt.setConvertType(this.hED);
            i = this.hEt.doConvert(this.hEu, this.hEv);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        if (this.hEy != null) {
            if (i == 0) {
                this.hEy.bJk();
            } else {
                this.hEy.wB(i);
            }
        }
    }

    public void cS(String str, String str2) {
        this.hEC = true;
        this.hEB = false;
        this.hEA = -3;
        this.hEu = str;
        this.hEv = str2;
        this.hEw = new File(this.hEu);
        this.hEx = new File(this.hEv);
        if (this.hEt == null) {
            startService();
            Ve();
            return;
        }
        bJn();
    }

    public boolean isConvertRunning() {
        try {
            if (this.hEt != null) {
                if (this.hEt.isConvertRunning()) {
                    return true;
                }
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void abortConvert() {
        if (this.hEt != null) {
            try {
                this.hEt.abortConvert();
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
            VideoConvertUtil.this.hEA = 1;
            if (VideoConvertUtil.this.hEy != null) {
                VideoConvertUtil.this.hEy.onConvertSuccess();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertFailed() throws RemoteException {
            if (VideoConvertUtil.this.hEy != null) {
                VideoConvertUtil.this.hEy.onConvertFailed();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertProgress(int i) throws RemoteException {
            if (VideoConvertUtil.this.hEy != null) {
                VideoConvertUtil.this.hEy.onConvertProgress(i);
            }
            if ((VideoConvertUtil.this.hEw != null && !VideoConvertUtil.this.hEw.exists()) || (VideoConvertUtil.this.hEx != null && !VideoConvertUtil.this.hEx.exists())) {
                VideoConvertUtil.this.abortConvert();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertAborted() throws RemoteException {
            if (VideoConvertUtil.this.hEy != null) {
                VideoConvertUtil.this.hEy.onConvertAborted();
            }
        }
    }

    public void a(d dVar) {
        this.hEy = dVar;
    }

    public static String wQ(String str) {
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
    public static int wR(String str) {
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

    public static boolean bJo() {
        File file = new File(hEg);
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
