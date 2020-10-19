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
    private Context mContext;
    private IVideoConvertService mTE;
    private String mTF;
    private String mTG;
    private File mTH;
    private File mTI;
    private d mTJ;
    public static final String mTv = c.mTq;
    private static final String TAG = VideoConvertUtil.class.getSimpleName();
    private int mTL = -3;
    private boolean mTM = false;
    private boolean mTN = false;
    private int mTO = 1;
    private ServiceConnection mTP = new ServiceConnection() { // from class: com.baidu.tieba.video.VideoConvertUtil.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            VideoConvertUtil.this.mTE = IVideoConvertService.Stub.asInterface(iBinder);
            if (VideoConvertUtil.this.mTN) {
                VideoConvertUtil.this.dII();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            if (VideoConvertUtil.this.mTN) {
                if (!VideoConvertUtil.this.mTM && VideoConvertUtil.this.mTL == -3 && VideoConvertUtil.this.mTJ != null) {
                    VideoConvertUtil.this.mTJ.onConvertFailed();
                }
                VideoConvertUtil.this.mTN = false;
            }
            VideoConvertUtil.this.mTE = null;
        }
    };
    private IntenalConvertListener mTK = new IntenalConvertListener();

    public VideoConvertUtil(Context context) {
        this.mContext = context;
    }

    public void setConvertType(int i) {
        this.mTO = i;
    }

    public void destroy() {
        this.mTM = true;
        abortConvert();
        dIH();
    }

    private void startService() {
        if (this.mContext != null) {
            Intent intent = new Intent("com.baidu.tieba.video.convert.VideoConvertService");
            intent.setPackage("com.baidu.tieba");
            this.mContext.startService(intent);
        }
    }

    private void dIG() {
        if (this.mContext != null) {
            Intent intent = new Intent("com.baidu.tieba.video.convert.VideoConvertService");
            intent.setPackage("com.baidu.tieba");
            this.mContext.bindService(intent, this.mTP, 1);
        }
    }

    private void dIH() {
        if (this.mTE != null && this.mContext != null) {
            this.mContext.unbindService(this.mTP);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dII() {
        int i = -1;
        try {
            this.mTE.setIVideoConvertListener(this.mTK);
            this.mTE.setConvertType(this.mTO);
            i = this.mTE.doConvert(this.mTF, this.mTG);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        if (this.mTJ != null) {
            if (i == 0) {
                this.mTJ.dIE();
            } else {
                this.mTJ.JT(i);
            }
        }
    }

    public void gq(String str, String str2) {
        this.mTN = true;
        this.mTM = false;
        this.mTL = -3;
        this.mTF = str;
        this.mTG = str2;
        this.mTH = new File(this.mTF);
        this.mTI = new File(this.mTG);
        if (this.mTE == null) {
            startService();
            dIG();
            return;
        }
        dII();
    }

    public boolean isConvertRunning() {
        try {
            if (this.mTE != null) {
                if (this.mTE.isConvertRunning()) {
                    return true;
                }
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void abortConvert() {
        if (this.mTE != null) {
            try {
                this.mTE.abortConvert();
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
            VideoConvertUtil.this.mTL = 1;
            if (VideoConvertUtil.this.mTJ != null) {
                VideoConvertUtil.this.mTJ.onConvertSuccess();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertFailed() throws RemoteException {
            if (VideoConvertUtil.this.mTJ != null) {
                VideoConvertUtil.this.mTJ.onConvertFailed();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertProgress(int i) throws RemoteException {
            if (VideoConvertUtil.this.mTJ != null) {
                VideoConvertUtil.this.mTJ.onConvertProgress(i);
            }
            if ((VideoConvertUtil.this.mTH != null && !VideoConvertUtil.this.mTH.exists()) || (VideoConvertUtil.this.mTI != null && !VideoConvertUtil.this.mTI.exists())) {
                VideoConvertUtil.this.abortConvert();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertAborted() throws RemoteException {
            if (VideoConvertUtil.this.mTJ != null) {
                VideoConvertUtil.this.mTJ.onConvertAborted();
            }
        }
    }

    public void a(d dVar) {
        this.mTJ = dVar;
    }

    public static String SO(String str) {
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
    public static int SP(String str) {
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

    public static boolean dIJ() {
        File file = new File(mTv);
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
