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
    private IVideoConvertService gPU;
    private String gPV;
    private String gPW;
    private File gPX;
    private File gPY;
    private c gPZ;
    private Context mContext;
    public static final String gPL = b.gPG;
    private static final String TAG = f.class.getSimpleName();
    private int gQb = -3;
    private boolean gQc = false;
    private boolean gQd = false;
    private int gQe = 1;
    private ServiceConnection gwD = new ServiceConnection() { // from class: com.baidu.tieba.video.f.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            f.this.gPU = IVideoConvertService.Stub.asInterface(iBinder);
            if (f.this.gQd) {
                f.this.bBj();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            if (f.this.gQd) {
                if (!f.this.gQc && f.this.gQb == -3 && f.this.gPZ != null) {
                    f.this.gPZ.onConvertFailed();
                }
                f.this.gQd = false;
            }
            f.this.gPU = null;
        }
    };
    private a gQa = new a();

    public f(Context context) {
        this.mContext = context;
    }

    public void setConvertType(int i) {
        this.gQe = i;
    }

    public void destroy() {
        this.gQc = true;
        abortConvert();
        buc();
    }

    private void startService() {
        if (this.mContext != null) {
            this.mContext.startService(new Intent("com.baidu.tieba.video.convert.VideoConvertService"));
        }
    }

    private void Lj() {
        if (this.mContext != null) {
            this.mContext.bindService(new Intent("com.baidu.tieba.video.convert.VideoConvertService"), this.gwD, 1);
        }
    }

    private void buc() {
        if (this.gPU != null && this.mContext != null) {
            this.mContext.unbindService(this.gwD);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBj() {
        int i = -1;
        try {
            this.gPU.setIVideoConvertListener(this.gQa);
            this.gPU.setConvertType(this.gQe);
            i = this.gPU.doConvert(this.gPV, this.gPW);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        if (this.gPZ != null) {
            if (i == 0) {
                this.gPZ.bBi();
            } else {
                this.gPZ.vn(i);
            }
        }
    }

    public void cm(String str, String str2) {
        this.gQd = true;
        this.gQc = false;
        this.gQb = -3;
        this.gPV = str;
        this.gPW = str2;
        this.gPX = new File(this.gPV);
        this.gPY = new File(this.gPW);
        if (this.gPU == null) {
            startService();
            Lj();
            return;
        }
        bBj();
    }

    public boolean isConvertRunning() {
        try {
            if (this.gPU != null) {
                if (this.gPU.isConvertRunning()) {
                    return true;
                }
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void abortConvert() {
        if (this.gPU != null) {
            try {
                this.gPU.abortConvert();
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
            f.this.gQb = 1;
            if (f.this.gPZ != null) {
                f.this.gPZ.onConvertSuccess();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertFailed() throws RemoteException {
            if (f.this.gPZ != null) {
                f.this.gPZ.onConvertFailed();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertProgress(int i) throws RemoteException {
            if (f.this.gPZ != null) {
                f.this.gPZ.onConvertProgress(i);
            }
            if ((f.this.gPX != null && !f.this.gPX.exists()) || (f.this.gPY != null && !f.this.gPY.exists())) {
                f.this.abortConvert();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertAborted() throws RemoteException {
            if (f.this.gPZ != null) {
                f.this.gPZ.onConvertAborted();
            }
        }
    }

    public void a(c cVar) {
        this.gPZ = cVar;
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

    public static boolean bBk() {
        File file = new File(gPL);
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
