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
    private IVideoConvertService gNh;
    private String gNi;
    private String gNj;
    private File gNk;
    private File gNl;
    private c gNm;
    private Context mContext;
    public static final String gMY = b.gMT;
    private static final String TAG = f.class.getSimpleName();
    private int gNo = -3;
    private boolean gNp = false;
    private boolean gNq = false;
    private int gNr = 1;
    private ServiceConnection gtR = new ServiceConnection() { // from class: com.baidu.tieba.video.f.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            f.this.gNh = IVideoConvertService.Stub.asInterface(iBinder);
            if (f.this.gNq) {
                f.this.bAC();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            if (f.this.gNq) {
                if (!f.this.gNp && f.this.gNo == -3 && f.this.gNm != null) {
                    f.this.gNm.onConvertFailed();
                }
                f.this.gNq = false;
            }
            f.this.gNh = null;
        }
    };
    private a gNn = new a();

    public f(Context context) {
        this.mContext = context;
    }

    public void setConvertType(int i) {
        this.gNr = i;
    }

    public void destroy() {
        this.gNp = true;
        abortConvert();
        btw();
    }

    private void startService() {
        if (this.mContext != null) {
            this.mContext.startService(new Intent("com.baidu.tieba.video.convert.VideoConvertService"));
        }
    }

    private void Lj() {
        if (this.mContext != null) {
            this.mContext.bindService(new Intent("com.baidu.tieba.video.convert.VideoConvertService"), this.gtR, 1);
        }
    }

    private void btw() {
        if (this.gNh != null && this.mContext != null) {
            this.mContext.unbindService(this.gtR);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bAC() {
        int i = -1;
        try {
            this.gNh.setIVideoConvertListener(this.gNn);
            this.gNh.setConvertType(this.gNr);
            i = this.gNh.doConvert(this.gNi, this.gNj);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        if (this.gNm != null) {
            if (i == 0) {
                this.gNm.bAB();
            } else {
                this.gNm.vc(i);
            }
        }
    }

    public void cl(String str, String str2) {
        this.gNq = true;
        this.gNp = false;
        this.gNo = -3;
        this.gNi = str;
        this.gNj = str2;
        this.gNk = new File(this.gNi);
        this.gNl = new File(this.gNj);
        if (this.gNh == null) {
            startService();
            Lj();
            return;
        }
        bAC();
    }

    public boolean isConvertRunning() {
        try {
            if (this.gNh != null) {
                if (this.gNh.isConvertRunning()) {
                    return true;
                }
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void abortConvert() {
        if (this.gNh != null) {
            try {
                this.gNh.abortConvert();
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
            f.this.gNo = 1;
            if (f.this.gNm != null) {
                f.this.gNm.onConvertSuccess();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertFailed() throws RemoteException {
            if (f.this.gNm != null) {
                f.this.gNm.onConvertFailed();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertProgress(int i) throws RemoteException {
            if (f.this.gNm != null) {
                f.this.gNm.onConvertProgress(i);
            }
            if ((f.this.gNk != null && !f.this.gNk.exists()) || (f.this.gNl != null && !f.this.gNl.exists())) {
                f.this.abortConvert();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertAborted() throws RemoteException {
            if (f.this.gNm != null) {
                f.this.gNm.onConvertAborted();
            }
        }
    }

    public void a(c cVar) {
        this.gNm = cVar;
    }

    public static String tP(String str) {
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
    public static int tQ(String str) {
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

    public static boolean bAD() {
        File file = new File(gMY);
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
