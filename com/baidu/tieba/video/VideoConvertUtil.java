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
    private IVideoConvertService haI;
    private String haJ;
    private String haK;
    private File haL;
    private File haM;
    private c haN;
    private Context mContext;
    public static final String hav = b.haq;
    private static final String TAG = VideoConvertUtil.class.getSimpleName();
    private int haP = -3;
    private boolean haQ = false;
    private boolean haR = false;
    private int haS = 1;
    private ServiceConnection haT = new ServiceConnection() { // from class: com.baidu.tieba.video.VideoConvertUtil.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            VideoConvertUtil.this.haI = IVideoConvertService.Stub.asInterface(iBinder);
            if (VideoConvertUtil.this.haR) {
                VideoConvertUtil.this.bBz();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            if (VideoConvertUtil.this.haR) {
                if (!VideoConvertUtil.this.haQ && VideoConvertUtil.this.haP == -3 && VideoConvertUtil.this.haN != null) {
                    VideoConvertUtil.this.haN.onConvertFailed();
                }
                VideoConvertUtil.this.haR = false;
            }
            VideoConvertUtil.this.haI = null;
        }
    };
    private IntenalConvertListener haO = new IntenalConvertListener();

    public VideoConvertUtil(Context context) {
        this.mContext = context;
    }

    public void setConvertType(int i) {
        this.haS = i;
    }

    public void destroy() {
        this.haQ = true;
        abortConvert();
        bBy();
    }

    private void startService() {
        if (this.mContext != null) {
            Intent intent = new Intent("com.baidu.tieba.video.convert.VideoConvertService");
            intent.setPackage("com.baidu.tieba");
            this.mContext.startService(intent);
        }
    }

    private void Pw() {
        if (this.mContext != null) {
            Intent intent = new Intent("com.baidu.tieba.video.convert.VideoConvertService");
            intent.setPackage("com.baidu.tieba");
            this.mContext.bindService(intent, this.haT, 1);
        }
    }

    private void bBy() {
        if (this.haI != null && this.mContext != null) {
            this.mContext.unbindService(this.haT);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBz() {
        int i = -1;
        try {
            this.haI.setIVideoConvertListener(this.haO);
            this.haI.setConvertType(this.haS);
            i = this.haI.doConvert(this.haJ, this.haK);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        if (this.haN != null) {
            if (i == 0) {
                this.haN.bBw();
            } else {
                this.haN.uz(i);
            }
        }
    }

    public void ct(String str, String str2) {
        this.haR = true;
        this.haQ = false;
        this.haP = -3;
        this.haJ = str;
        this.haK = str2;
        this.haL = new File(this.haJ);
        this.haM = new File(this.haK);
        if (this.haI == null) {
            startService();
            Pw();
            return;
        }
        bBz();
    }

    public boolean isConvertRunning() {
        try {
            if (this.haI != null) {
                if (this.haI.isConvertRunning()) {
                    return true;
                }
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void abortConvert() {
        if (this.haI != null) {
            try {
                this.haI.abortConvert();
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
            VideoConvertUtil.this.haP = 1;
            if (VideoConvertUtil.this.haN != null) {
                VideoConvertUtil.this.haN.onConvertSuccess();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertFailed() throws RemoteException {
            if (VideoConvertUtil.this.haN != null) {
                VideoConvertUtil.this.haN.onConvertFailed();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertProgress(int i) throws RemoteException {
            if (VideoConvertUtil.this.haN != null) {
                VideoConvertUtil.this.haN.onConvertProgress(i);
            }
            if ((VideoConvertUtil.this.haL != null && !VideoConvertUtil.this.haL.exists()) || (VideoConvertUtil.this.haM != null && !VideoConvertUtil.this.haM.exists())) {
                VideoConvertUtil.this.abortConvert();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertAborted() throws RemoteException {
            if (VideoConvertUtil.this.haN != null) {
                VideoConvertUtil.this.haN.onConvertAborted();
            }
        }
    }

    public void a(c cVar) {
        this.haN = cVar;
    }

    public static String uC(String str) {
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
    public static int uD(String str) {
        int i = 0;
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            try {
                mediaMetadataRetriever.setDataSource(str);
                i = com.baidu.adp.lib.g.b.g(mediaMetadataRetriever.extractMetadata(20), 0);
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

    public static boolean bBA() {
        File file = new File(hav);
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
