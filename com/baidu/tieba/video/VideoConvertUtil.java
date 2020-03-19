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
    private IVideoConvertService kwR;
    private String kwS;
    private File kwT;
    private d kwU;
    private Context mContext;
    private File mOutputFile;
    private String mOutputPath;
    public static final String kwI = c.kwD;
    private static final String TAG = VideoConvertUtil.class.getSimpleName();
    private int kwW = -3;
    private boolean kwX = false;
    private boolean kwY = false;
    private int kwZ = 1;
    private ServiceConnection kxa = new ServiceConnection() { // from class: com.baidu.tieba.video.VideoConvertUtil.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            VideoConvertUtil.this.kwR = IVideoConvertService.Stub.asInterface(iBinder);
            if (VideoConvertUtil.this.kwY) {
                VideoConvertUtil.this.cPA();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            if (VideoConvertUtil.this.kwY) {
                if (!VideoConvertUtil.this.kwX && VideoConvertUtil.this.kwW == -3 && VideoConvertUtil.this.kwU != null) {
                    VideoConvertUtil.this.kwU.onConvertFailed();
                }
                VideoConvertUtil.this.kwY = false;
            }
            VideoConvertUtil.this.kwR = null;
        }
    };
    private IntenalConvertListener kwV = new IntenalConvertListener();

    public VideoConvertUtil(Context context) {
        this.mContext = context;
    }

    public void setConvertType(int i) {
        this.kwZ = i;
    }

    public void destroy() {
        this.kwX = true;
        abortConvert();
        cPz();
    }

    private void startService() {
        if (this.mContext != null) {
            Intent intent = new Intent("com.baidu.tieba.video.convert.VideoConvertService");
            intent.setPackage("com.baidu.tieba");
            this.mContext.startService(intent);
        }
    }

    private void aWE() {
        if (this.mContext != null) {
            Intent intent = new Intent("com.baidu.tieba.video.convert.VideoConvertService");
            intent.setPackage("com.baidu.tieba");
            this.mContext.bindService(intent, this.kxa, 1);
        }
    }

    private void cPz() {
        if (this.kwR != null && this.mContext != null) {
            this.mContext.unbindService(this.kxa);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cPA() {
        int i = -1;
        try {
            this.kwR.setIVideoConvertListener(this.kwV);
            this.kwR.setConvertType(this.kwZ);
            i = this.kwR.doConvert(this.kwS, this.mOutputPath);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        if (this.kwU != null) {
            if (i == 0) {
                this.kwU.cPx();
            } else {
                this.kwU.Dy(i);
            }
        }
    }

    public void eG(String str, String str2) {
        this.kwY = true;
        this.kwX = false;
        this.kwW = -3;
        this.kwS = str;
        this.mOutputPath = str2;
        this.kwT = new File(this.kwS);
        this.mOutputFile = new File(this.mOutputPath);
        if (this.kwR == null) {
            startService();
            aWE();
            return;
        }
        cPA();
    }

    public boolean isConvertRunning() {
        try {
            if (this.kwR != null) {
                if (this.kwR.isConvertRunning()) {
                    return true;
                }
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void abortConvert() {
        if (this.kwR != null) {
            try {
                this.kwR.abortConvert();
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
            VideoConvertUtil.this.kwW = 1;
            if (VideoConvertUtil.this.kwU != null) {
                VideoConvertUtil.this.kwU.onConvertSuccess();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertFailed() throws RemoteException {
            if (VideoConvertUtil.this.kwU != null) {
                VideoConvertUtil.this.kwU.onConvertFailed();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertProgress(int i) throws RemoteException {
            if (VideoConvertUtil.this.kwU != null) {
                VideoConvertUtil.this.kwU.onConvertProgress(i);
            }
            if ((VideoConvertUtil.this.kwT != null && !VideoConvertUtil.this.kwT.exists()) || (VideoConvertUtil.this.mOutputFile != null && !VideoConvertUtil.this.mOutputFile.exists())) {
                VideoConvertUtil.this.abortConvert();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertAborted() throws RemoteException {
            if (VideoConvertUtil.this.kwU != null) {
                VideoConvertUtil.this.kwU.onConvertAborted();
            }
        }
    }

    public void a(d dVar) {
        this.kwU = dVar;
    }

    public static String JS(String str) {
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
    public static int JT(String str) {
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

    public static boolean cPB() {
        File file = new File(kwI);
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
