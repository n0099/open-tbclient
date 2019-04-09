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
import org.apache.http.protocol.HTTP;
/* loaded from: classes.dex */
public class VideoConvertUtil {
    private IVideoConvertService iUI;
    private String iUJ;
    private String iUK;
    private File iUL;
    private File iUM;
    private d iUN;
    private Context mContext;
    public static final String iUv = c.iUq;
    private static final String TAG = VideoConvertUtil.class.getSimpleName();
    private int iUP = -3;
    private boolean iUQ = false;
    private boolean iUR = false;
    private int iUS = 1;
    private ServiceConnection iUT = new ServiceConnection() { // from class: com.baidu.tieba.video.VideoConvertUtil.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            VideoConvertUtil.this.iUI = IVideoConvertService.Stub.asInterface(iBinder);
            if (VideoConvertUtil.this.iUR) {
                VideoConvertUtil.this.ciL();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            if (VideoConvertUtil.this.iUR) {
                if (!VideoConvertUtil.this.iUQ && VideoConvertUtil.this.iUP == -3 && VideoConvertUtil.this.iUN != null) {
                    VideoConvertUtil.this.iUN.onConvertFailed();
                }
                VideoConvertUtil.this.iUR = false;
            }
            VideoConvertUtil.this.iUI = null;
        }
    };
    private IntenalConvertListener iUO = new IntenalConvertListener();

    public VideoConvertUtil(Context context) {
        this.mContext = context;
    }

    public void setConvertType(int i) {
        this.iUS = i;
    }

    public void destroy() {
        this.iUQ = true;
        abortConvert();
        ciK();
    }

    private void startService() {
        if (this.mContext != null) {
            Intent intent = new Intent("com.baidu.tieba.video.convert.VideoConvertService");
            intent.setPackage("com.baidu.tieba");
            this.mContext.startService(intent);
        }
    }

    private void ava() {
        if (this.mContext != null) {
            Intent intent = new Intent("com.baidu.tieba.video.convert.VideoConvertService");
            intent.setPackage("com.baidu.tieba");
            this.mContext.bindService(intent, this.iUT, 1);
        }
    }

    private void ciK() {
        if (this.iUI != null && this.mContext != null) {
            this.mContext.unbindService(this.iUT);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ciL() {
        int i = -1;
        try {
            this.iUI.setIVideoConvertListener(this.iUO);
            this.iUI.setConvertType(this.iUS);
            i = this.iUI.doConvert(this.iUJ, this.iUK);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        if (this.iUN != null) {
            if (i == 0) {
                this.iUN.ciI();
            } else {
                this.iUN.Aj(i);
            }
        }
    }

    public void ec(String str, String str2) {
        this.iUR = true;
        this.iUQ = false;
        this.iUP = -3;
        this.iUJ = str;
        this.iUK = str2;
        this.iUL = new File(this.iUJ);
        this.iUM = new File(this.iUK);
        if (this.iUI == null) {
            startService();
            ava();
            return;
        }
        ciL();
    }

    public boolean isConvertRunning() {
        try {
            if (this.iUI != null) {
                if (this.iUI.isConvertRunning()) {
                    return true;
                }
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void abortConvert() {
        if (this.iUI != null) {
            try {
                this.iUI.abortConvert();
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
            VideoConvertUtil.this.iUP = 1;
            if (VideoConvertUtil.this.iUN != null) {
                VideoConvertUtil.this.iUN.onConvertSuccess();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertFailed() throws RemoteException {
            if (VideoConvertUtil.this.iUN != null) {
                VideoConvertUtil.this.iUN.onConvertFailed();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertProgress(int i) throws RemoteException {
            if (VideoConvertUtil.this.iUN != null) {
                VideoConvertUtil.this.iUN.onConvertProgress(i);
            }
            if ((VideoConvertUtil.this.iUL != null && !VideoConvertUtil.this.iUL.exists()) || (VideoConvertUtil.this.iUM != null && !VideoConvertUtil.this.iUM.exists())) {
                VideoConvertUtil.this.abortConvert();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertAborted() throws RemoteException {
            if (VideoConvertUtil.this.iUN != null) {
                VideoConvertUtil.this.iUN.onConvertAborted();
            }
        }
    }

    public void a(d dVar) {
        this.iUN = dVar;
    }

    public static String Dq(String str) {
        if (str == null || str.isEmpty()) {
            return "";
        }
        try {
            byte[] digest = MessageDigest.getInstance("MD5").digest(str.getBytes(HTTP.UTF_8));
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
    public static int Dr(String str) {
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

    public static boolean ciM() {
        File file = new File(iUv);
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
