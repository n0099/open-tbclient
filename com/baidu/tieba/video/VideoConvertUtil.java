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
    private IVideoConvertService hEs;
    private String hEt;
    private String hEu;
    private File hEv;
    private File hEw;
    private d hEx;
    private Context mContext;
    public static final String hEf = c.hEa;
    private static final String TAG = VideoConvertUtil.class.getSimpleName();
    private int hEz = -3;
    private boolean hEA = false;
    private boolean hEB = false;
    private int hEC = 1;
    private ServiceConnection hED = new ServiceConnection() { // from class: com.baidu.tieba.video.VideoConvertUtil.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            VideoConvertUtil.this.hEs = IVideoConvertService.Stub.asInterface(iBinder);
            if (VideoConvertUtil.this.hEB) {
                VideoConvertUtil.this.bJn();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            if (VideoConvertUtil.this.hEB) {
                if (!VideoConvertUtil.this.hEA && VideoConvertUtil.this.hEz == -3 && VideoConvertUtil.this.hEx != null) {
                    VideoConvertUtil.this.hEx.onConvertFailed();
                }
                VideoConvertUtil.this.hEB = false;
            }
            VideoConvertUtil.this.hEs = null;
        }
    };
    private IntenalConvertListener hEy = new IntenalConvertListener();

    public VideoConvertUtil(Context context) {
        this.mContext = context;
    }

    public void setConvertType(int i) {
        this.hEC = i;
    }

    public void destroy() {
        this.hEA = true;
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
            this.mContext.bindService(intent, this.hED, 1);
        }
    }

    private void bJm() {
        if (this.hEs != null && this.mContext != null) {
            this.mContext.unbindService(this.hED);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJn() {
        int i = -1;
        try {
            this.hEs.setIVideoConvertListener(this.hEy);
            this.hEs.setConvertType(this.hEC);
            i = this.hEs.doConvert(this.hEt, this.hEu);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        if (this.hEx != null) {
            if (i == 0) {
                this.hEx.bJk();
            } else {
                this.hEx.wB(i);
            }
        }
    }

    public void cS(String str, String str2) {
        this.hEB = true;
        this.hEA = false;
        this.hEz = -3;
        this.hEt = str;
        this.hEu = str2;
        this.hEv = new File(this.hEt);
        this.hEw = new File(this.hEu);
        if (this.hEs == null) {
            startService();
            Ve();
            return;
        }
        bJn();
    }

    public boolean isConvertRunning() {
        try {
            if (this.hEs != null) {
                if (this.hEs.isConvertRunning()) {
                    return true;
                }
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void abortConvert() {
        if (this.hEs != null) {
            try {
                this.hEs.abortConvert();
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
            VideoConvertUtil.this.hEz = 1;
            if (VideoConvertUtil.this.hEx != null) {
                VideoConvertUtil.this.hEx.onConvertSuccess();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertFailed() throws RemoteException {
            if (VideoConvertUtil.this.hEx != null) {
                VideoConvertUtil.this.hEx.onConvertFailed();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertProgress(int i) throws RemoteException {
            if (VideoConvertUtil.this.hEx != null) {
                VideoConvertUtil.this.hEx.onConvertProgress(i);
            }
            if ((VideoConvertUtil.this.hEv != null && !VideoConvertUtil.this.hEv.exists()) || (VideoConvertUtil.this.hEw != null && !VideoConvertUtil.this.hEw.exists())) {
                VideoConvertUtil.this.abortConvert();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertAborted() throws RemoteException {
            if (VideoConvertUtil.this.hEx != null) {
                VideoConvertUtil.this.hEx.onConvertAborted();
            }
        }
    }

    public void a(d dVar) {
        this.hEx = dVar;
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
        File file = new File(hEf);
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
