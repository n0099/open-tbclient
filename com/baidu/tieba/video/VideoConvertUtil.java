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
    private IVideoConvertService lUL;
    private String lUM;
    private String lUN;
    private File lUO;
    private File lUP;
    private e lUQ;
    private Context mContext;
    public static final String lUC = d.lUx;
    private static final String TAG = VideoConvertUtil.class.getSimpleName();
    private int lUS = -3;
    private boolean lUT = false;
    private boolean lUU = false;
    private int lUV = 1;
    private ServiceConnection lUW = new ServiceConnection() { // from class: com.baidu.tieba.video.VideoConvertUtil.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            VideoConvertUtil.this.lUL = IVideoConvertService.Stub.asInterface(iBinder);
            if (VideoConvertUtil.this.lUU) {
                VideoConvertUtil.this.dmm();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            if (VideoConvertUtil.this.lUU) {
                if (!VideoConvertUtil.this.lUT && VideoConvertUtil.this.lUS == -3 && VideoConvertUtil.this.lUQ != null) {
                    VideoConvertUtil.this.lUQ.onConvertFailed();
                }
                VideoConvertUtil.this.lUU = false;
            }
            VideoConvertUtil.this.lUL = null;
        }
    };
    private IntenalConvertListener lUR = new IntenalConvertListener();

    public VideoConvertUtil(Context context) {
        this.mContext = context;
    }

    public void setConvertType(int i) {
        this.lUV = i;
    }

    public void destroy() {
        this.lUT = true;
        abortConvert();
        dml();
    }

    private void startService() {
        if (this.mContext != null) {
            Intent intent = new Intent("com.baidu.tieba.video.convert.VideoConvertService");
            intent.setPackage("com.baidu.tieba");
            this.mContext.startService(intent);
        }
    }

    private void bnx() {
        if (this.mContext != null) {
            Intent intent = new Intent("com.baidu.tieba.video.convert.VideoConvertService");
            intent.setPackage("com.baidu.tieba");
            this.mContext.bindService(intent, this.lUW, 1);
        }
    }

    private void dml() {
        if (this.lUL != null && this.mContext != null) {
            this.mContext.unbindService(this.lUW);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dmm() {
        int i = -1;
        try {
            this.lUL.setIVideoConvertListener(this.lUR);
            this.lUL.setConvertType(this.lUV);
            i = this.lUL.doConvert(this.lUM, this.lUN);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        if (this.lUQ != null) {
            if (i == 0) {
                this.lUQ.dmj();
            } else {
                this.lUQ.FR(i);
            }
        }
    }

    public void fD(String str, String str2) {
        this.lUU = true;
        this.lUT = false;
        this.lUS = -3;
        this.lUM = str;
        this.lUN = str2;
        this.lUO = new File(this.lUM);
        this.lUP = new File(this.lUN);
        if (this.lUL == null) {
            startService();
            bnx();
            return;
        }
        dmm();
    }

    public boolean isConvertRunning() {
        try {
            if (this.lUL != null) {
                if (this.lUL.isConvertRunning()) {
                    return true;
                }
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void abortConvert() {
        if (this.lUL != null) {
            try {
                this.lUL.abortConvert();
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
            VideoConvertUtil.this.lUS = 1;
            if (VideoConvertUtil.this.lUQ != null) {
                VideoConvertUtil.this.lUQ.onConvertSuccess();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertFailed() throws RemoteException {
            if (VideoConvertUtil.this.lUQ != null) {
                VideoConvertUtil.this.lUQ.onConvertFailed();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertProgress(int i) throws RemoteException {
            if (VideoConvertUtil.this.lUQ != null) {
                VideoConvertUtil.this.lUQ.onConvertProgress(i);
            }
            if ((VideoConvertUtil.this.lUO != null && !VideoConvertUtil.this.lUO.exists()) || (VideoConvertUtil.this.lUP != null && !VideoConvertUtil.this.lUP.exists())) {
                VideoConvertUtil.this.abortConvert();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertAborted() throws RemoteException {
            if (VideoConvertUtil.this.lUQ != null) {
                VideoConvertUtil.this.lUQ.onConvertAborted();
            }
        }
    }

    public void a(e eVar) {
        this.lUQ = eVar;
    }

    public static String NU(String str) {
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
    public static int NV(String str) {
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

    public static boolean dmn() {
        File file = new File(lUC);
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
