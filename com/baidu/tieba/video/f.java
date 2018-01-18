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
public class f {
    private String hmA;
    private String hmB;
    private File hmC;
    private File hmD;
    private c hmE;
    private IVideoConvertService hmz;
    private Context mContext;
    public static final String hmm = b.hmh;
    private static final String TAG = f.class.getSimpleName();
    private int hmG = -3;
    private boolean hmH = false;
    private boolean hmI = false;
    private int hmJ = 1;
    private ServiceConnection hmK = new ServiceConnection() { // from class: com.baidu.tieba.video.f.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            f.this.hmz = IVideoConvertService.Stub.asInterface(iBinder);
            if (f.this.hmI) {
                f.this.bAd();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            if (f.this.hmI) {
                if (!f.this.hmH && f.this.hmG == -3 && f.this.hmE != null) {
                    f.this.hmE.onConvertFailed();
                }
                f.this.hmI = false;
            }
            f.this.hmz = null;
        }
    };
    private a hmF = new a();

    public f(Context context) {
        this.mContext = context;
    }

    public void setConvertType(int i) {
        this.hmJ = i;
    }

    public void destroy() {
        this.hmH = true;
        abortConvert();
        bAc();
    }

    private void startService() {
        if (this.mContext != null) {
            Intent intent = new Intent("com.baidu.tieba.video.convert.VideoConvertService");
            intent.setPackage("com.baidu.tieba");
            this.mContext.startService(intent);
        }
    }

    private void Sw() {
        if (this.mContext != null) {
            Intent intent = new Intent("com.baidu.tieba.video.convert.VideoConvertService");
            intent.setPackage("com.baidu.tieba");
            this.mContext.bindService(intent, this.hmK, 1);
        }
    }

    private void bAc() {
        if (this.hmz != null && this.mContext != null) {
            this.mContext.unbindService(this.hmK);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bAd() {
        int i = -1;
        try {
            this.hmz.setIVideoConvertListener(this.hmF);
            this.hmz.setConvertType(this.hmJ);
            i = this.hmz.doConvert(this.hmA, this.hmB);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        if (this.hmE != null) {
            if (i == 0) {
                this.hmE.bAa();
            } else {
                this.hmE.wD(i);
            }
        }
    }

    public void ch(String str, String str2) {
        this.hmI = true;
        this.hmH = false;
        this.hmG = -3;
        this.hmA = str;
        this.hmB = str2;
        this.hmC = new File(this.hmA);
        this.hmD = new File(this.hmB);
        if (this.hmz == null) {
            startService();
            Sw();
            return;
        }
        bAd();
    }

    public boolean isConvertRunning() {
        try {
            if (this.hmz != null) {
                if (this.hmz.isConvertRunning()) {
                    return true;
                }
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void abortConvert() {
        if (this.hmz != null) {
            try {
                this.hmz.abortConvert();
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
            f.this.hmG = 1;
            if (f.this.hmE != null) {
                f.this.hmE.onConvertSuccess();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertFailed() throws RemoteException {
            if (f.this.hmE != null) {
                f.this.hmE.onConvertFailed();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertProgress(int i) throws RemoteException {
            if (f.this.hmE != null) {
                f.this.hmE.onConvertProgress(i);
            }
            if ((f.this.hmC != null && !f.this.hmC.exists()) || (f.this.hmD != null && !f.this.hmD.exists())) {
                f.this.abortConvert();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertAborted() throws RemoteException {
            if (f.this.hmE != null) {
                f.this.hmE.onConvertAborted();
            }
        }
    }

    public void a(c cVar) {
        this.hmE = cVar;
    }

    public static String tq(String str) {
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
    public static int tr(String str) {
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

    public static boolean bAe() {
        File file = new File(hmm);
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
