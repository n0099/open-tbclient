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
    private IVideoConvertService kvn;
    private String kvo;
    private File kvp;
    private d kvq;
    private Context mContext;
    private File mOutputFile;
    private String mOutputPath;
    public static final String kve = c.kuZ;
    private static final String TAG = VideoConvertUtil.class.getSimpleName();
    private int kvs = -3;
    private boolean kvt = false;
    private boolean kvu = false;
    private int kvv = 1;
    private ServiceConnection kvw = new ServiceConnection() { // from class: com.baidu.tieba.video.VideoConvertUtil.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            VideoConvertUtil.this.kvn = IVideoConvertService.Stub.asInterface(iBinder);
            if (VideoConvertUtil.this.kvu) {
                VideoConvertUtil.this.cPg();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            if (VideoConvertUtil.this.kvu) {
                if (!VideoConvertUtil.this.kvt && VideoConvertUtil.this.kvs == -3 && VideoConvertUtil.this.kvq != null) {
                    VideoConvertUtil.this.kvq.onConvertFailed();
                }
                VideoConvertUtil.this.kvu = false;
            }
            VideoConvertUtil.this.kvn = null;
        }
    };
    private IntenalConvertListener kvr = new IntenalConvertListener();

    public VideoConvertUtil(Context context) {
        this.mContext = context;
    }

    public void setConvertType(int i) {
        this.kvv = i;
    }

    public void destroy() {
        this.kvt = true;
        abortConvert();
        cPf();
    }

    private void startService() {
        if (this.mContext != null) {
            Intent intent = new Intent("com.baidu.tieba.video.convert.VideoConvertService");
            intent.setPackage("com.baidu.tieba");
            this.mContext.startService(intent);
        }
    }

    private void aWA() {
        if (this.mContext != null) {
            Intent intent = new Intent("com.baidu.tieba.video.convert.VideoConvertService");
            intent.setPackage("com.baidu.tieba");
            this.mContext.bindService(intent, this.kvw, 1);
        }
    }

    private void cPf() {
        if (this.kvn != null && this.mContext != null) {
            this.mContext.unbindService(this.kvw);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cPg() {
        int i = -1;
        try {
            this.kvn.setIVideoConvertListener(this.kvr);
            this.kvn.setConvertType(this.kvv);
            i = this.kvn.doConvert(this.kvo, this.mOutputPath);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        if (this.kvq != null) {
            if (i == 0) {
                this.kvq.cPd();
            } else {
                this.kvq.Dq(i);
            }
        }
    }

    public void eI(String str, String str2) {
        this.kvu = true;
        this.kvt = false;
        this.kvs = -3;
        this.kvo = str;
        this.mOutputPath = str2;
        this.kvp = new File(this.kvo);
        this.mOutputFile = new File(this.mOutputPath);
        if (this.kvn == null) {
            startService();
            aWA();
            return;
        }
        cPg();
    }

    public boolean isConvertRunning() {
        try {
            if (this.kvn != null) {
                if (this.kvn.isConvertRunning()) {
                    return true;
                }
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void abortConvert() {
        if (this.kvn != null) {
            try {
                this.kvn.abortConvert();
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
            VideoConvertUtil.this.kvs = 1;
            if (VideoConvertUtil.this.kvq != null) {
                VideoConvertUtil.this.kvq.onConvertSuccess();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertFailed() throws RemoteException {
            if (VideoConvertUtil.this.kvq != null) {
                VideoConvertUtil.this.kvq.onConvertFailed();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertProgress(int i) throws RemoteException {
            if (VideoConvertUtil.this.kvq != null) {
                VideoConvertUtil.this.kvq.onConvertProgress(i);
            }
            if ((VideoConvertUtil.this.kvp != null && !VideoConvertUtil.this.kvp.exists()) || (VideoConvertUtil.this.mOutputFile != null && !VideoConvertUtil.this.mOutputFile.exists())) {
                VideoConvertUtil.this.abortConvert();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertAborted() throws RemoteException {
            if (VideoConvertUtil.this.kvq != null) {
                VideoConvertUtil.this.kvq.onConvertAborted();
            }
        }
    }

    public void a(d dVar) {
        this.kvq = dVar;
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

    public static boolean cPh() {
        File file = new File(kve);
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
