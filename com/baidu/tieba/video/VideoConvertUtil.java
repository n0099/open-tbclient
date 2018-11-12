package com.baidu.tieba.video;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.media.MediaMetadataRetriever;
import android.os.IBinder;
import android.os.RemoteException;
import com.baidu.searchbox.ng.ai.apps.util.AiAppEncryptUtils;
import com.baidu.tieba.video.convert.IVideoConvertListener;
import com.baidu.tieba.video.convert.IVideoConvertService;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes.dex */
public class VideoConvertUtil {
    private IVideoConvertService hsO;
    private String hsP;
    private String hsQ;
    private File hsR;
    private File hsS;
    private d hsT;
    private Context mContext;
    public static final String hsB = c.hsw;
    private static final String TAG = VideoConvertUtil.class.getSimpleName();
    private int hsV = -3;
    private boolean hsW = false;
    private boolean hsX = false;
    private int hsY = 1;
    private ServiceConnection hsZ = new ServiceConnection() { // from class: com.baidu.tieba.video.VideoConvertUtil.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            VideoConvertUtil.this.hsO = IVideoConvertService.Stub.asInterface(iBinder);
            if (VideoConvertUtil.this.hsX) {
                VideoConvertUtil.this.bFK();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            if (VideoConvertUtil.this.hsX) {
                if (!VideoConvertUtil.this.hsW && VideoConvertUtil.this.hsV == -3 && VideoConvertUtil.this.hsT != null) {
                    VideoConvertUtil.this.hsT.onConvertFailed();
                }
                VideoConvertUtil.this.hsX = false;
            }
            VideoConvertUtil.this.hsO = null;
        }
    };
    private IntenalConvertListener hsU = new IntenalConvertListener();

    public VideoConvertUtil(Context context) {
        this.mContext = context;
    }

    public void setConvertType(int i) {
        this.hsY = i;
    }

    public void destroy() {
        this.hsW = true;
        abortConvert();
        bFJ();
    }

    private void startService() {
        if (this.mContext != null) {
            Intent intent = new Intent("com.baidu.tieba.video.convert.VideoConvertService");
            intent.setPackage("com.baidu.tieba");
            this.mContext.startService(intent);
        }
    }

    private void TA() {
        if (this.mContext != null) {
            Intent intent = new Intent("com.baidu.tieba.video.convert.VideoConvertService");
            intent.setPackage("com.baidu.tieba");
            this.mContext.bindService(intent, this.hsZ, 1);
        }
    }

    private void bFJ() {
        if (this.hsO != null && this.mContext != null) {
            this.mContext.unbindService(this.hsZ);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bFK() {
        int i = -1;
        try {
            this.hsO.setIVideoConvertListener(this.hsU);
            this.hsO.setConvertType(this.hsY);
            i = this.hsO.doConvert(this.hsP, this.hsQ);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        if (this.hsT != null) {
            if (i == 0) {
                this.hsT.bFH();
            } else {
                this.hsT.vO(i);
            }
        }
    }

    public void cL(String str, String str2) {
        this.hsX = true;
        this.hsW = false;
        this.hsV = -3;
        this.hsP = str;
        this.hsQ = str2;
        this.hsR = new File(this.hsP);
        this.hsS = new File(this.hsQ);
        if (this.hsO == null) {
            startService();
            TA();
            return;
        }
        bFK();
    }

    public boolean isConvertRunning() {
        try {
            if (this.hsO != null) {
                if (this.hsO.isConvertRunning()) {
                    return true;
                }
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void abortConvert() {
        if (this.hsO != null) {
            try {
                this.hsO.abortConvert();
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
            VideoConvertUtil.this.hsV = 1;
            if (VideoConvertUtil.this.hsT != null) {
                VideoConvertUtil.this.hsT.onConvertSuccess();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertFailed() throws RemoteException {
            if (VideoConvertUtil.this.hsT != null) {
                VideoConvertUtil.this.hsT.onConvertFailed();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertProgress(int i) throws RemoteException {
            if (VideoConvertUtil.this.hsT != null) {
                VideoConvertUtil.this.hsT.onConvertProgress(i);
            }
            if ((VideoConvertUtil.this.hsR != null && !VideoConvertUtil.this.hsR.exists()) || (VideoConvertUtil.this.hsS != null && !VideoConvertUtil.this.hsS.exists())) {
                VideoConvertUtil.this.abortConvert();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertAborted() throws RemoteException {
            if (VideoConvertUtil.this.hsT != null) {
                VideoConvertUtil.this.hsT.onConvertAborted();
            }
        }
    }

    public void a(d dVar) {
        this.hsT = dVar;
    }

    public static String vU(String str) {
        if (str == null || str.isEmpty()) {
            return "";
        }
        try {
            byte[] digest = MessageDigest.getInstance(AiAppEncryptUtils.ENCRYPT_MD5).digest(str.getBytes("UTF-8"));
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
    public static int vV(String str) {
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

    public static boolean bFL() {
        File file = new File(hsB);
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
