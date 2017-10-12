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
    private f gxB;
    private IVideoConvertService gxw;
    private String gxx;
    private String gxy;
    private File gxz;
    private Context mContext;
    private int gxD = -3;
    private boolean gxE = false;
    private boolean gxF = false;
    private int gxG = 1;
    private ServiceConnection gbz = new ServiceConnection() { // from class: com.baidu.tieba.video.localvideo.g.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            g.this.gxw = IVideoConvertService.Stub.asInterface(iBinder);
            if (g.this.gxF) {
                g.this.bwz();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            if (g.this.gxF) {
                if (!g.this.gxE && g.this.gxD == -3 && g.this.gxB != null) {
                    g.this.gxB.onConvertFailed();
                }
                g.this.gxF = false;
            }
            g.this.gxw = null;
        }
    };
    private a gxC = new a();

    public g(Context context) {
        this.mContext = context;
    }

    public void setConvertType(int i) {
        this.gxG = i;
    }

    public void destroy() {
        this.gxE = true;
        abortConvert();
        boH();
    }

    private void startService() {
        if (this.mContext != null) {
            this.mContext.startService(new Intent("com.baidu.tieba.video.convert.VideoConvertService"));
        }
    }

    private void Kz() {
        if (this.mContext != null) {
            this.mContext.bindService(new Intent("com.baidu.tieba.video.convert.VideoConvertService"), this.gbz, 1);
        }
    }

    private void boH() {
        if (this.gxw != null && this.mContext != null) {
            this.mContext.unbindService(this.gbz);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bwz() {
        int i = -1;
        try {
            this.gxw.setIVideoConvertListener(this.gxC);
            this.gxw.setConvertType(this.gxG);
            i = this.gxw.doConvert(this.gxx, this.gxy);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        if (this.gxB != null) {
            if (i == 0) {
                this.gxB.bvQ();
            } else {
                this.gxB.uw(i);
            }
        }
    }

    public void cl(String str, String str2) {
        this.gxF = true;
        this.gxE = false;
        this.gxD = -3;
        this.gxx = str;
        this.gxy = str2;
        this.gxz = new File(this.gxx);
        this.gxA = new File(this.gxy);
        if (this.gxw == null) {
            startService();
            Kz();
            return;
        }
        bwz();
    }

    public boolean isConvertRunning() {
        try {
            if (this.gxw != null) {
                if (this.gxw.isConvertRunning()) {
                    return true;
                }
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void abortConvert() {
        if (this.gxw != null) {
            try {
                this.gxw.abortConvert();
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
            g.this.gxD = 1;
            if (g.this.gxB != null) {
                g.this.gxB.onConvertSuccess();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertFailed() throws RemoteException {
            if (g.this.gxB != null) {
                g.this.gxB.onConvertFailed();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertProgress(int i) throws RemoteException {
            if (g.this.gxB != null) {
                g.this.gxB.onConvertProgress(i);
            }
            if ((g.this.gxz != null && !g.this.gxz.exists()) || (g.this.gxA != null && !g.this.gxA.exists())) {
                g.this.abortConvert();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertAborted() throws RemoteException {
            if (g.this.gxB != null) {
                g.this.gxB.onConvertAborted();
            }
        }
    }

    public void a(f fVar) {
        this.gxB = fVar;
    }
}
