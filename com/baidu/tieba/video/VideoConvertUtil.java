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
import org.apache.http.protocol.HTTP;
/* loaded from: classes.dex */
public class VideoConvertUtil {
    private IVideoConvertService iUH;
    private String iUI;
    private String iUJ;
    private File iUK;
    private File iUL;
    private d iUM;
    private Context mContext;
    public static final String iUu = c.iUp;
    private static final String TAG = VideoConvertUtil.class.getSimpleName();
    private int iUO = -3;
    private boolean iUP = false;
    private boolean iUQ = false;
    private int iUR = 1;
    private ServiceConnection iUS = new ServiceConnection() { // from class: com.baidu.tieba.video.VideoConvertUtil.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            VideoConvertUtil.this.iUH = IVideoConvertService.Stub.asInterface(iBinder);
            if (VideoConvertUtil.this.iUQ) {
                VideoConvertUtil.this.ciL();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            if (VideoConvertUtil.this.iUQ) {
                if (!VideoConvertUtil.this.iUP && VideoConvertUtil.this.iUO == -3 && VideoConvertUtil.this.iUM != null) {
                    VideoConvertUtil.this.iUM.onConvertFailed();
                }
                VideoConvertUtil.this.iUQ = false;
            }
            VideoConvertUtil.this.iUH = null;
        }
    };
    private IntenalConvertListener iUN = new IntenalConvertListener();

    public VideoConvertUtil(Context context) {
        this.mContext = context;
    }

    public void setConvertType(int i) {
        this.iUR = i;
    }

    public void destroy() {
        this.iUP = true;
        abortConvert();
        ciK();
    }

    private void startService() {
        if (this.mContext != null) {
            Intent intent = new Intent("com.baidu.tieba.video.convert.VideoConvertService");
            intent.setPackage("com.baidu.tieba");
            this.mContext.startService(intent);
        }
    }

    private void ava() {
        if (this.mContext != null) {
            Intent intent = new Intent("com.baidu.tieba.video.convert.VideoConvertService");
            intent.setPackage("com.baidu.tieba");
            this.mContext.bindService(intent, this.iUS, 1);
        }
    }

    private void ciK() {
        if (this.iUH != null && this.mContext != null) {
            this.mContext.unbindService(this.iUS);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ciL() {
        int i = -1;
        try {
            this.iUH.setIVideoConvertListener(this.iUN);
            this.iUH.setConvertType(this.iUR);
            i = this.iUH.doConvert(this.iUI, this.iUJ);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        if (this.iUM != null) {
            if (i == 0) {
                this.iUM.ciI();
            } else {
                this.iUM.Aj(i);
            }
        }
    }

    public void ec(String str, String str2) {
        this.iUQ = true;
        this.iUP = false;
        this.iUO = -3;
        this.iUI = str;
        this.iUJ = str2;
        this.iUK = new File(this.iUI);
        this.iUL = new File(this.iUJ);
        if (this.iUH == null) {
            startService();
            ava();
            return;
        }
        ciL();
    }

    public boolean isConvertRunning() {
        try {
            if (this.iUH != null) {
                if (this.iUH.isConvertRunning()) {
                    return true;
                }
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void abortConvert() {
        if (this.iUH != null) {
            try {
                this.iUH.abortConvert();
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
            VideoConvertUtil.this.iUO = 1;
            if (VideoConvertUtil.this.iUM != null) {
                VideoConvertUtil.this.iUM.onConvertSuccess();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertFailed() throws RemoteException {
            if (VideoConvertUtil.this.iUM != null) {
                VideoConvertUtil.this.iUM.onConvertFailed();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertProgress(int i) throws RemoteException {
            if (VideoConvertUtil.this.iUM != null) {
                VideoConvertUtil.this.iUM.onConvertProgress(i);
            }
            if ((VideoConvertUtil.this.iUK != null && !VideoConvertUtil.this.iUK.exists()) || (VideoConvertUtil.this.iUL != null && !VideoConvertUtil.this.iUL.exists())) {
                VideoConvertUtil.this.abortConvert();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertAborted() throws RemoteException {
            if (VideoConvertUtil.this.iUM != null) {
                VideoConvertUtil.this.iUM.onConvertAborted();
            }
        }
    }

    public void a(d dVar) {
        this.iUM = dVar;
    }

    public static String Dq(String str) {
        if (str == null || str.isEmpty()) {
            return "";
        }
        try {
            byte[] digest = MessageDigest.getInstance("MD5").digest(str.getBytes(HTTP.UTF_8));
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
    public static int Dr(String str) {
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

    public static boolean ciM() {
        File file = new File(iUu);
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
