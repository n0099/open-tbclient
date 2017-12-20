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
    private IVideoConvertService gPP;
    private String gPQ;
    private String gPR;
    private File gPS;
    private File gPT;
    private c gPU;
    private Context mContext;
    public static final String gPG = b.gPB;
    private static final String TAG = f.class.getSimpleName();
    private int gPW = -3;
    private boolean gPX = false;
    private boolean gPY = false;
    private int gPZ = 1;
    private ServiceConnection gwy = new ServiceConnection() { // from class: com.baidu.tieba.video.f.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            f.this.gPP = IVideoConvertService.Stub.asInterface(iBinder);
            if (f.this.gPY) {
                f.this.bBi();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            if (f.this.gPY) {
                if (!f.this.gPX && f.this.gPW == -3 && f.this.gPU != null) {
                    f.this.gPU.onConvertFailed();
                }
                f.this.gPY = false;
            }
            f.this.gPP = null;
        }
    };
    private a gPV = new a();

    public f(Context context) {
        this.mContext = context;
    }

    public void setConvertType(int i) {
        this.gPZ = i;
    }

    public void destroy() {
        this.gPX = true;
        abortConvert();
        bub();
    }

    private void startService() {
        if (this.mContext != null) {
            this.mContext.startService(new Intent("com.baidu.tieba.video.convert.VideoConvertService"));
        }
    }

    private void Lj() {
        if (this.mContext != null) {
            this.mContext.bindService(new Intent("com.baidu.tieba.video.convert.VideoConvertService"), this.gwy, 1);
        }
    }

    private void bub() {
        if (this.gPP != null && this.mContext != null) {
            this.mContext.unbindService(this.gwy);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBi() {
        int i = -1;
        try {
            this.gPP.setIVideoConvertListener(this.gPV);
            this.gPP.setConvertType(this.gPZ);
            i = this.gPP.doConvert(this.gPQ, this.gPR);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        if (this.gPU != null) {
            if (i == 0) {
                this.gPU.bBh();
            } else {
                this.gPU.vn(i);
            }
        }
    }

    public void cm(String str, String str2) {
        this.gPY = true;
        this.gPX = false;
        this.gPW = -3;
        this.gPQ = str;
        this.gPR = str2;
        this.gPS = new File(this.gPQ);
        this.gPT = new File(this.gPR);
        if (this.gPP == null) {
            startService();
            Lj();
            return;
        }
        bBi();
    }

    public boolean isConvertRunning() {
        try {
            if (this.gPP != null) {
                if (this.gPP.isConvertRunning()) {
                    return true;
                }
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void abortConvert() {
        if (this.gPP != null) {
            try {
                this.gPP.abortConvert();
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
            f.this.gPW = 1;
            if (f.this.gPU != null) {
                f.this.gPU.onConvertSuccess();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertFailed() throws RemoteException {
            if (f.this.gPU != null) {
                f.this.gPU.onConvertFailed();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertProgress(int i) throws RemoteException {
            if (f.this.gPU != null) {
                f.this.gPU.onConvertProgress(i);
            }
            if ((f.this.gPS != null && !f.this.gPS.exists()) || (f.this.gPT != null && !f.this.gPT.exists())) {
                f.this.abortConvert();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertAborted() throws RemoteException {
            if (f.this.gPU != null) {
                f.this.gPU.onConvertAborted();
            }
        }
    }

    public void a(c cVar) {
        this.gPU = cVar;
    }

    public static String tU(String str) {
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
    public static int tV(String str) {
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

    public static boolean bBj() {
        File file = new File(gPG);
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
