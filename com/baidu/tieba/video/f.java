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
    private IVideoConvertService hwW;
    private String hwX;
    private String hwY;
    private File hwZ;
    private File hxa;
    private c hxb;
    private Context mContext;
    public static final String hwJ = b.hwE;
    private static final String TAG = f.class.getSimpleName();
    private int hxd = -3;
    private boolean hxe = false;
    private boolean hxf = false;
    private int hxg = 1;
    private ServiceConnection hxh = new ServiceConnection() { // from class: com.baidu.tieba.video.f.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            f.this.hwW = IVideoConvertService.Stub.asInterface(iBinder);
            if (f.this.hxf) {
                f.this.bGG();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            if (f.this.hxf) {
                if (!f.this.hxe && f.this.hxd == -3 && f.this.hxb != null) {
                    f.this.hxb.onConvertFailed();
                }
                f.this.hxf = false;
            }
            f.this.hwW = null;
        }
    };
    private a hxc = new a();

    public f(Context context) {
        this.mContext = context;
    }

    public void setConvertType(int i) {
        this.hxg = i;
    }

    public void destroy() {
        this.hxe = true;
        abortConvert();
        bGF();
    }

    private void startService() {
        if (this.mContext != null) {
            Intent intent = new Intent("com.baidu.tieba.video.convert.VideoConvertService");
            intent.setPackage("com.baidu.tieba");
            this.mContext.startService(intent);
        }
    }

    private void SI() {
        if (this.mContext != null) {
            Intent intent = new Intent("com.baidu.tieba.video.convert.VideoConvertService");
            intent.setPackage("com.baidu.tieba");
            this.mContext.bindService(intent, this.hxh, 1);
        }
    }

    private void bGF() {
        if (this.hwW != null && this.mContext != null) {
            this.mContext.unbindService(this.hxh);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGG() {
        int i = -1;
        try {
            this.hwW.setIVideoConvertListener(this.hxc);
            this.hwW.setConvertType(this.hxg);
            i = this.hwW.doConvert(this.hwX, this.hwY);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        if (this.hxb != null) {
            if (i == 0) {
                this.hxb.bGD();
            } else {
                this.hxb.yb(i);
            }
        }
    }

    public void cn(String str, String str2) {
        this.hxf = true;
        this.hxe = false;
        this.hxd = -3;
        this.hwX = str;
        this.hwY = str2;
        this.hwZ = new File(this.hwX);
        this.hxa = new File(this.hwY);
        if (this.hwW == null) {
            startService();
            SI();
            return;
        }
        bGG();
    }

    public boolean isConvertRunning() {
        try {
            if (this.hwW != null) {
                if (this.hwW.isConvertRunning()) {
                    return true;
                }
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void abortConvert() {
        if (this.hwW != null) {
            try {
                this.hwW.abortConvert();
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
            f.this.hxd = 1;
            if (f.this.hxb != null) {
                f.this.hxb.onConvertSuccess();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertFailed() throws RemoteException {
            if (f.this.hxb != null) {
                f.this.hxb.onConvertFailed();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertProgress(int i) throws RemoteException {
            if (f.this.hxb != null) {
                f.this.hxb.onConvertProgress(i);
            }
            if ((f.this.hwZ != null && !f.this.hwZ.exists()) || (f.this.hxa != null && !f.this.hxa.exists())) {
                f.this.abortConvert();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertAborted() throws RemoteException {
            if (f.this.hxb != null) {
                f.this.hxb.onConvertAborted();
            }
        }
    }

    public void a(c cVar) {
        this.hxb = cVar;
    }

    public static String tV(String str) {
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
    public static int tW(String str) {
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

    public static boolean bGH() {
        File file = new File(hwJ);
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
