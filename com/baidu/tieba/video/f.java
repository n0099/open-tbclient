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
    private IVideoConvertService hot;
    private String hou;
    private String hov;
    private File how;
    private File hox;
    private c hoy;
    private Context mContext;
    public static final String hog = b.hob;
    private static final String TAG = f.class.getSimpleName();
    private int hoA = -3;
    private boolean hoB = false;
    private boolean hoC = false;
    private int hoD = 1;
    private ServiceConnection hoE = new ServiceConnection() { // from class: com.baidu.tieba.video.f.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            f.this.hot = IVideoConvertService.Stub.asInterface(iBinder);
            if (f.this.hoC) {
                f.this.bAT();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            if (f.this.hoC) {
                if (!f.this.hoB && f.this.hoA == -3 && f.this.hoy != null) {
                    f.this.hoy.onConvertFailed();
                }
                f.this.hoC = false;
            }
            f.this.hot = null;
        }
    };
    private a hoz = new a();

    public f(Context context) {
        this.mContext = context;
    }

    public void setConvertType(int i) {
        this.hoD = i;
    }

    public void destroy() {
        this.hoB = true;
        abortConvert();
        bAS();
    }

    private void startService() {
        if (this.mContext != null) {
            Intent intent = new Intent("com.baidu.tieba.video.convert.VideoConvertService");
            intent.setPackage("com.baidu.tieba");
            this.mContext.startService(intent);
        }
    }

    private void Tf() {
        if (this.mContext != null) {
            Intent intent = new Intent("com.baidu.tieba.video.convert.VideoConvertService");
            intent.setPackage("com.baidu.tieba");
            this.mContext.bindService(intent, this.hoE, 1);
        }
    }

    private void bAS() {
        if (this.hot != null && this.mContext != null) {
            this.mContext.unbindService(this.hoE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bAT() {
        int i = -1;
        try {
            this.hot.setIVideoConvertListener(this.hoz);
            this.hot.setConvertType(this.hoD);
            i = this.hot.doConvert(this.hou, this.hov);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        if (this.hoy != null) {
            if (i == 0) {
                this.hoy.bAQ();
            } else {
                this.hoy.wD(i);
            }
        }
    }

    public void ci(String str, String str2) {
        this.hoC = true;
        this.hoB = false;
        this.hoA = -3;
        this.hou = str;
        this.hov = str2;
        this.how = new File(this.hou);
        this.hox = new File(this.hov);
        if (this.hot == null) {
            startService();
            Tf();
            return;
        }
        bAT();
    }

    public boolean isConvertRunning() {
        try {
            if (this.hot != null) {
                if (this.hot.isConvertRunning()) {
                    return true;
                }
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void abortConvert() {
        if (this.hot != null) {
            try {
                this.hot.abortConvert();
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
            f.this.hoA = 1;
            if (f.this.hoy != null) {
                f.this.hoy.onConvertSuccess();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertFailed() throws RemoteException {
            if (f.this.hoy != null) {
                f.this.hoy.onConvertFailed();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertProgress(int i) throws RemoteException {
            if (f.this.hoy != null) {
                f.this.hoy.onConvertProgress(i);
            }
            if ((f.this.how != null && !f.this.how.exists()) || (f.this.hox != null && !f.this.hox.exists())) {
                f.this.abortConvert();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertAborted() throws RemoteException {
            if (f.this.hoy != null) {
                f.this.hoy.onConvertAborted();
            }
        }
    }

    public void a(c cVar) {
        this.hoy = cVar;
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

    public static boolean bAU() {
        File file = new File(hog);
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
