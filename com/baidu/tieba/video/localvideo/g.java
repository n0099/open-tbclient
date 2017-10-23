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
    private IVideoConvertService gxi;
    private String gxj;
    private String gxk;
    private File gxl;
    private File gxm;
    private f gxn;
    private Context mContext;
    private int gxp = -3;
    private boolean gxq = false;
    private boolean gxr = false;
    private int gxs = 1;
    private ServiceConnection gbl = new ServiceConnection() { // from class: com.baidu.tieba.video.localvideo.g.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            g.this.gxi = IVideoConvertService.Stub.asInterface(iBinder);
            if (g.this.gxr) {
                g.this.bwr();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            if (g.this.gxr) {
                if (!g.this.gxq && g.this.gxp == -3 && g.this.gxn != null) {
                    g.this.gxn.onConvertFailed();
                }
                g.this.gxr = false;
            }
            g.this.gxi = null;
        }
    };
    private a gxo = new a();

    public g(Context context) {
        this.mContext = context;
    }

    public void setConvertType(int i) {
        this.gxs = i;
    }

    public void destroy() {
        this.gxq = true;
        abortConvert();
        boA();
    }

    private void startService() {
        if (this.mContext != null) {
            this.mContext.startService(new Intent("com.baidu.tieba.video.convert.VideoConvertService"));
        }
    }

    private void Kt() {
        if (this.mContext != null) {
            this.mContext.bindService(new Intent("com.baidu.tieba.video.convert.VideoConvertService"), this.gbl, 1);
        }
    }

    private void boA() {
        if (this.gxi != null && this.mContext != null) {
            this.mContext.unbindService(this.gbl);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bwr() {
        int i = -1;
        try {
            this.gxi.setIVideoConvertListener(this.gxo);
            this.gxi.setConvertType(this.gxs);
            i = this.gxi.doConvert(this.gxj, this.gxk);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        if (this.gxn != null) {
            if (i == 0) {
                this.gxn.bvI();
            } else {
                this.gxn.uv(i);
            }
        }
    }

    public void ck(String str, String str2) {
        this.gxr = true;
        this.gxq = false;
        this.gxp = -3;
        this.gxj = str;
        this.gxk = str2;
        this.gxl = new File(this.gxj);
        this.gxm = new File(this.gxk);
        if (this.gxi == null) {
            startService();
            Kt();
            return;
        }
        bwr();
    }

    public boolean isConvertRunning() {
        try {
            if (this.gxi != null) {
                if (this.gxi.isConvertRunning()) {
                    return true;
                }
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void abortConvert() {
        if (this.gxi != null) {
            try {
                this.gxi.abortConvert();
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
            g.this.gxp = 1;
            if (g.this.gxn != null) {
                g.this.gxn.onConvertSuccess();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertFailed() throws RemoteException {
            if (g.this.gxn != null) {
                g.this.gxn.onConvertFailed();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertProgress(int i) throws RemoteException {
            if (g.this.gxn != null) {
                g.this.gxn.onConvertProgress(i);
            }
            if ((g.this.gxl != null && !g.this.gxl.exists()) || (g.this.gxm != null && !g.this.gxm.exists())) {
                g.this.abortConvert();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertAborted() throws RemoteException {
            if (g.this.gxn != null) {
                g.this.gxn.onConvertAborted();
            }
        }
    }

    public void a(f fVar) {
        this.gxn = fVar;
    }
}
