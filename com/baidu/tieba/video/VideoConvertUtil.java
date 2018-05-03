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
    private IVideoConvertService gJY;
    private String gJZ;
    private String gKa;
    private File gKb;
    private File gKc;
    private c gKd;
    private Context mContext;
    public static final String gJL = b.gJG;
    private static final String TAG = VideoConvertUtil.class.getSimpleName();
    private int gKf = -3;
    private boolean gKg = false;
    private boolean gKh = false;
    private int gKi = 1;
    private ServiceConnection gKj = new ServiceConnection() { // from class: com.baidu.tieba.video.VideoConvertUtil.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            VideoConvertUtil.this.gJY = IVideoConvertService.Stub.asInterface(iBinder);
            if (VideoConvertUtil.this.gKh) {
                VideoConvertUtil.this.bvU();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            if (VideoConvertUtil.this.gKh) {
                if (!VideoConvertUtil.this.gKg && VideoConvertUtil.this.gKf == -3 && VideoConvertUtil.this.gKd != null) {
                    VideoConvertUtil.this.gKd.onConvertFailed();
                }
                VideoConvertUtil.this.gKh = false;
            }
            VideoConvertUtil.this.gJY = null;
        }
    };
    private IntenalConvertListener gKe = new IntenalConvertListener();

    public VideoConvertUtil(Context context) {
        this.mContext = context;
    }

    public void setConvertType(int i) {
        this.gKi = i;
    }

    public void destroy() {
        this.gKg = true;
        abortConvert();
        bvT();
    }

    private void startService() {
        if (this.mContext != null) {
            Intent intent = new Intent("com.baidu.tieba.video.convert.VideoConvertService");
            intent.setPackage("com.baidu.tieba");
            this.mContext.startService(intent);
        }
    }

    private void LC() {
        if (this.mContext != null) {
            Intent intent = new Intent("com.baidu.tieba.video.convert.VideoConvertService");
            intent.setPackage("com.baidu.tieba");
            this.mContext.bindService(intent, this.gKj, 1);
        }
    }

    private void bvT() {
        if (this.gJY != null && this.mContext != null) {
            this.mContext.unbindService(this.gKj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bvU() {
        int i = -1;
        try {
            this.gJY.setIVideoConvertListener(this.gKe);
            this.gJY.setConvertType(this.gKi);
            i = this.gJY.doConvert(this.gJZ, this.gKa);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        if (this.gKd != null) {
            if (i == 0) {
                this.gKd.bvR();
            } else {
                this.gKd.uf(i);
            }
        }
    }

    public void ch(String str, String str2) {
        this.gKh = true;
        this.gKg = false;
        this.gKf = -3;
        this.gJZ = str;
        this.gKa = str2;
        this.gKb = new File(this.gJZ);
        this.gKc = new File(this.gKa);
        if (this.gJY == null) {
            startService();
            LC();
            return;
        }
        bvU();
    }

    public boolean isConvertRunning() {
        try {
            if (this.gJY != null) {
                if (this.gJY.isConvertRunning()) {
                    return true;
                }
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void abortConvert() {
        if (this.gJY != null) {
            try {
                this.gJY.abortConvert();
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
            VideoConvertUtil.this.gKf = 1;
            if (VideoConvertUtil.this.gKd != null) {
                VideoConvertUtil.this.gKd.onConvertSuccess();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertFailed() throws RemoteException {
            if (VideoConvertUtil.this.gKd != null) {
                VideoConvertUtil.this.gKd.onConvertFailed();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertProgress(int i) throws RemoteException {
            if (VideoConvertUtil.this.gKd != null) {
                VideoConvertUtil.this.gKd.onConvertProgress(i);
            }
            if ((VideoConvertUtil.this.gKb != null && !VideoConvertUtil.this.gKb.exists()) || (VideoConvertUtil.this.gKc != null && !VideoConvertUtil.this.gKc.exists())) {
                VideoConvertUtil.this.abortConvert();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertAborted() throws RemoteException {
            if (VideoConvertUtil.this.gKd != null) {
                VideoConvertUtil.this.gKd.onConvertAborted();
            }
        }
    }

    public void a(c cVar) {
        this.gKd = cVar;
    }

    public static String tJ(String str) {
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
    public static int tK(String str) {
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

    public static boolean bvV() {
        File file = new File(gJL);
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
