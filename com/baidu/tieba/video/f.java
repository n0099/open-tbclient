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
public class f {
    private IVideoConvertService hnV;
    private String hnW;
    private String hnX;
    private File hnY;
    private File hnZ;
    private c hoa;
    private Context mContext;
    public static final String hnI = b.hnD;
    private static final String TAG = f.class.getSimpleName();
    private int hoc = -3;
    private boolean hod = false;
    private boolean hoe = false;
    private int hof = 1;
    private ServiceConnection hog = new ServiceConnection() { // from class: com.baidu.tieba.video.f.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            f.this.hnV = IVideoConvertService.Stub.asInterface(iBinder);
            if (f.this.hoe) {
                f.this.bAO();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            if (f.this.hoe) {
                if (!f.this.hod && f.this.hoc == -3 && f.this.hoa != null) {
                    f.this.hoa.onConvertFailed();
                }
                f.this.hoe = false;
            }
            f.this.hnV = null;
        }
    };
    private a hob = new a();

    public f(Context context) {
        this.mContext = context;
    }

    public void setConvertType(int i) {
        this.hof = i;
    }

    public void destroy() {
        this.hod = true;
        abortConvert();
        bAN();
    }

    private void startService() {
        if (this.mContext != null) {
            Intent intent = new Intent("com.baidu.tieba.video.convert.VideoConvertService");
            intent.setPackage("com.baidu.tieba");
            this.mContext.startService(intent);
        }
    }

    private void Te() {
        if (this.mContext != null) {
            Intent intent = new Intent("com.baidu.tieba.video.convert.VideoConvertService");
            intent.setPackage("com.baidu.tieba");
            this.mContext.bindService(intent, this.hog, 1);
        }
    }

    private void bAN() {
        if (this.hnV != null && this.mContext != null) {
            this.mContext.unbindService(this.hog);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bAO() {
        int i = -1;
        try {
            this.hnV.setIVideoConvertListener(this.hob);
            this.hnV.setConvertType(this.hof);
            i = this.hnV.doConvert(this.hnW, this.hnX);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        if (this.hoa != null) {
            if (i == 0) {
                this.hoa.bAL();
            } else {
                this.hoa.wD(i);
            }
        }
    }

    public void ci(String str, String str2) {
        this.hoe = true;
        this.hod = false;
        this.hoc = -3;
        this.hnW = str;
        this.hnX = str2;
        this.hnY = new File(this.hnW);
        this.hnZ = new File(this.hnX);
        if (this.hnV == null) {
            startService();
            Te();
            return;
        }
        bAO();
    }

    public boolean isConvertRunning() {
        try {
            if (this.hnV != null) {
                if (this.hnV.isConvertRunning()) {
                    return true;
                }
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void abortConvert() {
        if (this.hnV != null) {
            try {
                this.hnV.abortConvert();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends IVideoConvertListener.Stub {
        private a() {
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertSuccess() throws RemoteException {
            f.this.hoc = 1;
            if (f.this.hoa != null) {
                f.this.hoa.onConvertSuccess();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertFailed() throws RemoteException {
            if (f.this.hoa != null) {
                f.this.hoa.onConvertFailed();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertProgress(int i) throws RemoteException {
            if (f.this.hoa != null) {
                f.this.hoa.onConvertProgress(i);
            }
            if ((f.this.hnY != null && !f.this.hnY.exists()) || (f.this.hnZ != null && !f.this.hnZ.exists())) {
                f.this.abortConvert();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertAborted() throws RemoteException {
            if (f.this.hoa != null) {
                f.this.hoa.onConvertAborted();
            }
        }
    }

    public void a(c cVar) {
        this.hoa = cVar;
    }

    public static String tC(String str) {
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
    public static int tD(String str) {
        int i = 0;
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            try {
                mediaMetadataRetriever.setDataSource(str);
                i = com.baidu.adp.lib.g.b.h(mediaMetadataRetriever.extractMetadata(20), 0);
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

    public static boolean bAP() {
        File file = new File(hnI);
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
