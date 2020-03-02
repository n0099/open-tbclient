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
    private IVideoConvertService kvb;
    private String kvc;
    private File kvd;
    private d kve;
    private Context mContext;
    private File mOutputFile;
    private String mOutputPath;
    public static final String kuS = c.kuN;
    private static final String TAG = VideoConvertUtil.class.getSimpleName();
    private int kvg = -3;
    private boolean kvh = false;
    private boolean kvi = false;
    private int kvj = 1;
    private ServiceConnection kvk = new ServiceConnection() { // from class: com.baidu.tieba.video.VideoConvertUtil.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            VideoConvertUtil.this.kvb = IVideoConvertService.Stub.asInterface(iBinder);
            if (VideoConvertUtil.this.kvi) {
                VideoConvertUtil.this.cPf();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            if (VideoConvertUtil.this.kvi) {
                if (!VideoConvertUtil.this.kvh && VideoConvertUtil.this.kvg == -3 && VideoConvertUtil.this.kve != null) {
                    VideoConvertUtil.this.kve.onConvertFailed();
                }
                VideoConvertUtil.this.kvi = false;
            }
            VideoConvertUtil.this.kvb = null;
        }
    };
    private IntenalConvertListener kvf = new IntenalConvertListener();

    public VideoConvertUtil(Context context) {
        this.mContext = context;
    }

    public void setConvertType(int i) {
        this.kvj = i;
    }

    public void destroy() {
        this.kvh = true;
        abortConvert();
        cPe();
    }

    private void startService() {
        if (this.mContext != null) {
            Intent intent = new Intent("com.baidu.tieba.video.convert.VideoConvertService");
            intent.setPackage("com.baidu.tieba");
            this.mContext.startService(intent);
        }
    }

    private void aWz() {
        if (this.mContext != null) {
            Intent intent = new Intent("com.baidu.tieba.video.convert.VideoConvertService");
            intent.setPackage("com.baidu.tieba");
            this.mContext.bindService(intent, this.kvk, 1);
        }
    }

    private void cPe() {
        if (this.kvb != null && this.mContext != null) {
            this.mContext.unbindService(this.kvk);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cPf() {
        int i = -1;
        try {
            this.kvb.setIVideoConvertListener(this.kvf);
            this.kvb.setConvertType(this.kvj);
            i = this.kvb.doConvert(this.kvc, this.mOutputPath);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        if (this.kve != null) {
            if (i == 0) {
                this.kve.cPc();
            } else {
                this.kve.Dq(i);
            }
        }
    }

    public void eI(String str, String str2) {
        this.kvi = true;
        this.kvh = false;
        this.kvg = -3;
        this.kvc = str;
        this.mOutputPath = str2;
        this.kvd = new File(this.kvc);
        this.mOutputFile = new File(this.mOutputPath);
        if (this.kvb == null) {
            startService();
            aWz();
            return;
        }
        cPf();
    }

    public boolean isConvertRunning() {
        try {
            if (this.kvb != null) {
                if (this.kvb.isConvertRunning()) {
                    return true;
                }
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void abortConvert() {
        if (this.kvb != null) {
            try {
                this.kvb.abortConvert();
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
            VideoConvertUtil.this.kvg = 1;
            if (VideoConvertUtil.this.kve != null) {
                VideoConvertUtil.this.kve.onConvertSuccess();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertFailed() throws RemoteException {
            if (VideoConvertUtil.this.kve != null) {
                VideoConvertUtil.this.kve.onConvertFailed();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertProgress(int i) throws RemoteException {
            if (VideoConvertUtil.this.kve != null) {
                VideoConvertUtil.this.kve.onConvertProgress(i);
            }
            if ((VideoConvertUtil.this.kvd != null && !VideoConvertUtil.this.kvd.exists()) || (VideoConvertUtil.this.mOutputFile != null && !VideoConvertUtil.this.mOutputFile.exists())) {
                VideoConvertUtil.this.abortConvert();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertAborted() throws RemoteException {
            if (VideoConvertUtil.this.kve != null) {
                VideoConvertUtil.this.kve.onConvertAborted();
            }
        }
    }

    public void a(d dVar) {
        this.kve = dVar;
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

    public static boolean cPg() {
        File file = new File(kuS);
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
