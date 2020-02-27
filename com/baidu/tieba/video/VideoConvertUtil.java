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
    private IVideoConvertService kuZ;
    private String kva;
    private File kvb;
    private d kvc;
    private Context mContext;
    private File mOutputFile;
    private String mOutputPath;
    public static final String kuQ = c.kuL;
    private static final String TAG = VideoConvertUtil.class.getSimpleName();
    private int kve = -3;
    private boolean kvf = false;
    private boolean kvg = false;
    private int kvh = 1;
    private ServiceConnection kvi = new ServiceConnection() { // from class: com.baidu.tieba.video.VideoConvertUtil.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            VideoConvertUtil.this.kuZ = IVideoConvertService.Stub.asInterface(iBinder);
            if (VideoConvertUtil.this.kvg) {
                VideoConvertUtil.this.cPd();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            if (VideoConvertUtil.this.kvg) {
                if (!VideoConvertUtil.this.kvf && VideoConvertUtil.this.kve == -3 && VideoConvertUtil.this.kvc != null) {
                    VideoConvertUtil.this.kvc.onConvertFailed();
                }
                VideoConvertUtil.this.kvg = false;
            }
            VideoConvertUtil.this.kuZ = null;
        }
    };
    private IntenalConvertListener kvd = new IntenalConvertListener();

    public VideoConvertUtil(Context context) {
        this.mContext = context;
    }

    public void setConvertType(int i) {
        this.kvh = i;
    }

    public void destroy() {
        this.kvf = true;
        abortConvert();
        cPc();
    }

    private void startService() {
        if (this.mContext != null) {
            Intent intent = new Intent("com.baidu.tieba.video.convert.VideoConvertService");
            intent.setPackage("com.baidu.tieba");
            this.mContext.startService(intent);
        }
    }

    private void aWx() {
        if (this.mContext != null) {
            Intent intent = new Intent("com.baidu.tieba.video.convert.VideoConvertService");
            intent.setPackage("com.baidu.tieba");
            this.mContext.bindService(intent, this.kvi, 1);
        }
    }

    private void cPc() {
        if (this.kuZ != null && this.mContext != null) {
            this.mContext.unbindService(this.kvi);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cPd() {
        int i = -1;
        try {
            this.kuZ.setIVideoConvertListener(this.kvd);
            this.kuZ.setConvertType(this.kvh);
            i = this.kuZ.doConvert(this.kva, this.mOutputPath);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        if (this.kvc != null) {
            if (i == 0) {
                this.kvc.cPa();
            } else {
                this.kvc.Dq(i);
            }
        }
    }

    public void eI(String str, String str2) {
        this.kvg = true;
        this.kvf = false;
        this.kve = -3;
        this.kva = str;
        this.mOutputPath = str2;
        this.kvb = new File(this.kva);
        this.mOutputFile = new File(this.mOutputPath);
        if (this.kuZ == null) {
            startService();
            aWx();
            return;
        }
        cPd();
    }

    public boolean isConvertRunning() {
        try {
            if (this.kuZ != null) {
                if (this.kuZ.isConvertRunning()) {
                    return true;
                }
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void abortConvert() {
        if (this.kuZ != null) {
            try {
                this.kuZ.abortConvert();
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
            VideoConvertUtil.this.kve = 1;
            if (VideoConvertUtil.this.kvc != null) {
                VideoConvertUtil.this.kvc.onConvertSuccess();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertFailed() throws RemoteException {
            if (VideoConvertUtil.this.kvc != null) {
                VideoConvertUtil.this.kvc.onConvertFailed();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertProgress(int i) throws RemoteException {
            if (VideoConvertUtil.this.kvc != null) {
                VideoConvertUtil.this.kvc.onConvertProgress(i);
            }
            if ((VideoConvertUtil.this.kvb != null && !VideoConvertUtil.this.kvb.exists()) || (VideoConvertUtil.this.mOutputFile != null && !VideoConvertUtil.this.mOutputFile.exists())) {
                VideoConvertUtil.this.abortConvert();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertAborted() throws RemoteException {
            if (VideoConvertUtil.this.kvc != null) {
                VideoConvertUtil.this.kvc.onConvertAborted();
            }
        }
    }

    public void a(d dVar) {
        this.kvc = dVar;
    }

    public static String JR(String str) {
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
    public static int JS(String str) {
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

    public static boolean cPe() {
        File file = new File(kuQ);
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
