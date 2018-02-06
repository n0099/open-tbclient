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
    private IVideoConvertService hoi;
    private String hoj;
    private String hok;
    private File hol;
    private File hom;
    private c hon;
    private Context mContext;
    public static final String hnV = b.hnQ;
    private static final String TAG = f.class.getSimpleName();
    private int hop = -3;
    private boolean hoq = false;
    private boolean hor = false;
    private int hos = 1;
    private ServiceConnection hot = new ServiceConnection() { // from class: com.baidu.tieba.video.f.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            f.this.hoi = IVideoConvertService.Stub.asInterface(iBinder);
            if (f.this.hor) {
                f.this.bAP();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            if (f.this.hor) {
                if (!f.this.hoq && f.this.hop == -3 && f.this.hon != null) {
                    f.this.hon.onConvertFailed();
                }
                f.this.hor = false;
            }
            f.this.hoi = null;
        }
    };
    private a hoo = new a();

    public f(Context context) {
        this.mContext = context;
    }

    public void setConvertType(int i) {
        this.hos = i;
    }

    public void destroy() {
        this.hoq = true;
        abortConvert();
        bAO();
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
            this.mContext.bindService(intent, this.hot, 1);
        }
    }

    private void bAO() {
        if (this.hoi != null && this.mContext != null) {
            this.mContext.unbindService(this.hot);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bAP() {
        int i = -1;
        try {
            this.hoi.setIVideoConvertListener(this.hoo);
            this.hoi.setConvertType(this.hos);
            i = this.hoi.doConvert(this.hoj, this.hok);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        if (this.hon != null) {
            if (i == 0) {
                this.hon.bAM();
            } else {
                this.hon.wC(i);
            }
        }
    }

    public void ci(String str, String str2) {
        this.hor = true;
        this.hoq = false;
        this.hop = -3;
        this.hoj = str;
        this.hok = str2;
        this.hol = new File(this.hoj);
        this.hom = new File(this.hok);
        if (this.hoi == null) {
            startService();
            Tf();
            return;
        }
        bAP();
    }

    public boolean isConvertRunning() {
        try {
            if (this.hoi != null) {
                if (this.hoi.isConvertRunning()) {
                    return true;
                }
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void abortConvert() {
        if (this.hoi != null) {
            try {
                this.hoi.abortConvert();
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
            f.this.hop = 1;
            if (f.this.hon != null) {
                f.this.hon.onConvertSuccess();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertFailed() throws RemoteException {
            if (f.this.hon != null) {
                f.this.hon.onConvertFailed();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertProgress(int i) throws RemoteException {
            if (f.this.hon != null) {
                f.this.hon.onConvertProgress(i);
            }
            if ((f.this.hol != null && !f.this.hol.exists()) || (f.this.hom != null && !f.this.hom.exists())) {
                f.this.abortConvert();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertAborted() throws RemoteException {
            if (f.this.hon != null) {
                f.this.hon.onConvertAborted();
            }
        }
    }

    public void a(c cVar) {
        this.hon = cVar;
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

    public static boolean bAQ() {
        File file = new File(hnV);
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
