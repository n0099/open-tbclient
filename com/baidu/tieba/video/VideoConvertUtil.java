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
    private IVideoConvertService hjO;
    private String hjP;
    private String hjQ;
    private File hjR;
    private File hjS;
    private d hjT;
    private Context mContext;
    public static final String hjB = c.hjw;
    private static final String TAG = VideoConvertUtil.class.getSimpleName();
    private int hjV = -3;
    private boolean hjW = false;
    private boolean hjX = false;
    private int hjY = 1;
    private ServiceConnection hjZ = new ServiceConnection() { // from class: com.baidu.tieba.video.VideoConvertUtil.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            VideoConvertUtil.this.hjO = IVideoConvertService.Stub.asInterface(iBinder);
            if (VideoConvertUtil.this.hjX) {
                VideoConvertUtil.this.bCX();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            if (VideoConvertUtil.this.hjX) {
                if (!VideoConvertUtil.this.hjW && VideoConvertUtil.this.hjV == -3 && VideoConvertUtil.this.hjT != null) {
                    VideoConvertUtil.this.hjT.onConvertFailed();
                }
                VideoConvertUtil.this.hjX = false;
            }
            VideoConvertUtil.this.hjO = null;
        }
    };
    private IntenalConvertListener hjU = new IntenalConvertListener();

    public VideoConvertUtil(Context context) {
        this.mContext = context;
    }

    public void setConvertType(int i) {
        this.hjY = i;
    }

    public void destroy() {
        this.hjW = true;
        abortConvert();
        bCW();
    }

    private void startService() {
        if (this.mContext != null) {
            Intent intent = new Intent("com.baidu.tieba.video.convert.VideoConvertService");
            intent.setPackage("com.baidu.tieba");
            this.mContext.startService(intent);
        }
    }

    private void Rv() {
        if (this.mContext != null) {
            Intent intent = new Intent("com.baidu.tieba.video.convert.VideoConvertService");
            intent.setPackage("com.baidu.tieba");
            this.mContext.bindService(intent, this.hjZ, 1);
        }
    }

    private void bCW() {
        if (this.hjO != null && this.mContext != null) {
            this.mContext.unbindService(this.hjZ);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bCX() {
        int i = -1;
        try {
            this.hjO.setIVideoConvertListener(this.hjU);
            this.hjO.setConvertType(this.hjY);
            i = this.hjO.doConvert(this.hjP, this.hjQ);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        if (this.hjT != null) {
            if (i == 0) {
                this.hjT.bCU();
            } else {
                this.hjT.uY(i);
            }
        }
    }

    public void cA(String str, String str2) {
        this.hjX = true;
        this.hjW = false;
        this.hjV = -3;
        this.hjP = str;
        this.hjQ = str2;
        this.hjR = new File(this.hjP);
        this.hjS = new File(this.hjQ);
        if (this.hjO == null) {
            startService();
            Rv();
            return;
        }
        bCX();
    }

    public boolean isConvertRunning() {
        try {
            if (this.hjO != null) {
                if (this.hjO.isConvertRunning()) {
                    return true;
                }
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void abortConvert() {
        if (this.hjO != null) {
            try {
                this.hjO.abortConvert();
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
            VideoConvertUtil.this.hjV = 1;
            if (VideoConvertUtil.this.hjT != null) {
                VideoConvertUtil.this.hjT.onConvertSuccess();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertFailed() throws RemoteException {
            if (VideoConvertUtil.this.hjT != null) {
                VideoConvertUtil.this.hjT.onConvertFailed();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertProgress(int i) throws RemoteException {
            if (VideoConvertUtil.this.hjT != null) {
                VideoConvertUtil.this.hjT.onConvertProgress(i);
            }
            if ((VideoConvertUtil.this.hjR != null && !VideoConvertUtil.this.hjR.exists()) || (VideoConvertUtil.this.hjS != null && !VideoConvertUtil.this.hjS.exists())) {
                VideoConvertUtil.this.abortConvert();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertAborted() throws RemoteException {
            if (VideoConvertUtil.this.hjT != null) {
                VideoConvertUtil.this.hjT.onConvertAborted();
            }
        }
    }

    public void a(d dVar) {
        this.hjT = dVar;
    }

    public static String vn(String str) {
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
    public static int vo(String str) {
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

    public static boolean bCY() {
        File file = new File(hjB);
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
