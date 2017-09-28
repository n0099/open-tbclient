package com.baidu.tieba.video.localvideo;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.baidu.tieba.video.convert.IVideoConvertListener;
import com.baidu.tieba.video.convert.IVideoConvertService;
import java.io.File;
/* loaded from: classes2.dex */
public class g {
    private static final String TAG = g.class.getSimpleName();
    private File gxA;
    private File gxB;
    private f gxC;
    private IVideoConvertService gxx;
    private String gxy;
    private String gxz;
    private Context mContext;
    private int gxE = -3;
    private boolean gxF = false;
    private boolean gxG = false;
    private int gxH = 1;
    private ServiceConnection gbA = new ServiceConnection() { // from class: com.baidu.tieba.video.localvideo.g.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            g.this.gxx = IVideoConvertService.Stub.asInterface(iBinder);
            if (g.this.gxG) {
                g.this.bwA();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            if (g.this.gxG) {
                if (!g.this.gxF && g.this.gxE == -3 && g.this.gxC != null) {
                    g.this.gxC.onConvertFailed();
                }
                g.this.gxG = false;
            }
            g.this.gxx = null;
        }
    };
    private a gxD = new a();

    public g(Context context) {
        this.mContext = context;
    }

    public void setConvertType(int i) {
        this.gxH = i;
    }

    public void destroy() {
        this.gxF = true;
        abortConvert();
        boI();
    }

    private void startService() {
        if (this.mContext != null) {
            this.mContext.startService(new Intent("com.baidu.tieba.video.convert.VideoConvertService"));
        }
    }

    private void Kz() {
        if (this.mContext != null) {
            this.mContext.bindService(new Intent("com.baidu.tieba.video.convert.VideoConvertService"), this.gbA, 1);
        }
    }

    private void boI() {
        if (this.gxx != null && this.mContext != null) {
            this.mContext.unbindService(this.gbA);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bwA() {
        int i = -1;
        try {
            this.gxx.setIVideoConvertListener(this.gxD);
            this.gxx.setConvertType(this.gxH);
            i = this.gxx.doConvert(this.gxy, this.gxz);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        if (this.gxC != null) {
            if (i == 0) {
                this.gxC.bvR();
            } else {
                this.gxC.uw(i);
            }
        }
    }

    public void cl(String str, String str2) {
        this.gxG = true;
        this.gxF = false;
        this.gxE = -3;
        this.gxy = str;
        this.gxz = str2;
        this.gxA = new File(this.gxy);
        this.gxB = new File(this.gxz);
        if (this.gxx == null) {
            startService();
            Kz();
            return;
        }
        bwA();
    }

    public boolean isConvertRunning() {
        try {
            if (this.gxx != null) {
                if (this.gxx.isConvertRunning()) {
                    return true;
                }
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void abortConvert() {
        if (this.gxx != null) {
            try {
                this.gxx.abortConvert();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a extends IVideoConvertListener.Stub {
        private a() {
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertSuccess() throws RemoteException {
            g.this.gxE = 1;
            if (g.this.gxC != null) {
                g.this.gxC.onConvertSuccess();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertFailed() throws RemoteException {
            if (g.this.gxC != null) {
                g.this.gxC.onConvertFailed();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertProgress(int i) throws RemoteException {
            if (g.this.gxC != null) {
                g.this.gxC.onConvertProgress(i);
            }
            if ((g.this.gxA != null && !g.this.gxA.exists()) || (g.this.gxB != null && !g.this.gxB.exists())) {
                g.this.abortConvert();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertAborted() throws RemoteException {
            if (g.this.gxC != null) {
                g.this.gxC.onConvertAborted();
            }
        }
    }

    public void a(f fVar) {
        this.gxC = fVar;
    }
}
