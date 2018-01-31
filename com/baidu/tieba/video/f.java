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
    private IVideoConvertService hmT;
    private String hmU;
    private String hmV;
    private File hmW;
    private File hmX;
    private c hmY;
    private Context mContext;
    public static final String hmG = b.hmB;
    private static final String TAG = f.class.getSimpleName();
    private int hna = -3;
    private boolean hnb = false;
    private boolean hnc = false;
    private int hnd = 1;
    private ServiceConnection hne = new ServiceConnection() { // from class: com.baidu.tieba.video.f.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            f.this.hmT = IVideoConvertService.Stub.asInterface(iBinder);
            if (f.this.hnc) {
                f.this.bAf();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            if (f.this.hnc) {
                if (!f.this.hnb && f.this.hna == -3 && f.this.hmY != null) {
                    f.this.hmY.onConvertFailed();
                }
                f.this.hnc = false;
            }
            f.this.hmT = null;
        }
    };
    private a hmZ = new a();

    public f(Context context) {
        this.mContext = context;
    }

    public void setConvertType(int i) {
        this.hnd = i;
    }

    public void destroy() {
        this.hnb = true;
        abortConvert();
        bAe();
    }

    private void startService() {
        if (this.mContext != null) {
            Intent intent = new Intent("com.baidu.tieba.video.convert.VideoConvertService");
            intent.setPackage("com.baidu.tieba");
            this.mContext.startService(intent);
        }
    }

    private void Sy() {
        if (this.mContext != null) {
            Intent intent = new Intent("com.baidu.tieba.video.convert.VideoConvertService");
            intent.setPackage("com.baidu.tieba");
            this.mContext.bindService(intent, this.hne, 1);
        }
    }

    private void bAe() {
        if (this.hmT != null && this.mContext != null) {
            this.mContext.unbindService(this.hne);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bAf() {
        int i = -1;
        try {
            this.hmT.setIVideoConvertListener(this.hmZ);
            this.hmT.setConvertType(this.hnd);
            i = this.hmT.doConvert(this.hmU, this.hmV);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        if (this.hmY != null) {
            if (i == 0) {
                this.hmY.bAc();
            } else {
                this.hmY.wD(i);
            }
        }
    }

    public void cg(String str, String str2) {
        this.hnc = true;
        this.hnb = false;
        this.hna = -3;
        this.hmU = str;
        this.hmV = str2;
        this.hmW = new File(this.hmU);
        this.hmX = new File(this.hmV);
        if (this.hmT == null) {
            startService();
            Sy();
            return;
        }
        bAf();
    }

    public boolean isConvertRunning() {
        try {
            if (this.hmT != null) {
                if (this.hmT.isConvertRunning()) {
                    return true;
                }
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void abortConvert() {
        if (this.hmT != null) {
            try {
                this.hmT.abortConvert();
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
            f.this.hna = 1;
            if (f.this.hmY != null) {
                f.this.hmY.onConvertSuccess();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertFailed() throws RemoteException {
            if (f.this.hmY != null) {
                f.this.hmY.onConvertFailed();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertProgress(int i) throws RemoteException {
            if (f.this.hmY != null) {
                f.this.hmY.onConvertProgress(i);
            }
            if ((f.this.hmW != null && !f.this.hmW.exists()) || (f.this.hmX != null && !f.this.hmX.exists())) {
                f.this.abortConvert();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertAborted() throws RemoteException {
            if (f.this.hmY != null) {
                f.this.hmY.onConvertAborted();
            }
        }
    }

    public void a(c cVar) {
        this.hmY = cVar;
    }

    public static String tx(String str) {
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
    public static int ty(String str) {
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

    public static boolean bAg() {
        File file = new File(hmG);
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
