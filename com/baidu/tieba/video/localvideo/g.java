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
    private IVideoConvertService gGO;
    private String gGP;
    private String gGQ;
    private File gGR;
    private File gGS;
    private f gGT;
    private Context mContext;
    private int gGV = -3;
    private boolean gGW = false;
    private boolean gGX = false;
    private int gGY = 1;
    private ServiceConnection gjY = new ServiceConnection() { // from class: com.baidu.tieba.video.localvideo.g.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            g.this.gGO = IVideoConvertService.Stub.asInterface(iBinder);
            if (g.this.gGX) {
                g.this.bzE();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            if (g.this.gGX) {
                if (!g.this.gGW && g.this.gGV == -3 && g.this.gGT != null) {
                    g.this.gGT.onConvertFailed();
                }
                g.this.gGX = false;
            }
            g.this.gGO = null;
        }
    };
    private a gGU = new a();

    public g(Context context) {
        this.mContext = context;
    }

    public void setConvertType(int i) {
        this.gGY = i;
    }

    public void destroy() {
        this.gGW = true;
        abortConvert();
        brE();
    }

    private void startService() {
        if (this.mContext != null) {
            this.mContext.startService(new Intent("com.baidu.tieba.video.convert.VideoConvertService"));
        }
    }

    private void KC() {
        if (this.mContext != null) {
            this.mContext.bindService(new Intent("com.baidu.tieba.video.convert.VideoConvertService"), this.gjY, 1);
        }
    }

    private void brE() {
        if (this.gGO != null && this.mContext != null) {
            this.mContext.unbindService(this.gjY);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bzE() {
        int i = -1;
        try {
            this.gGO.setIVideoConvertListener(this.gGU);
            this.gGO.setConvertType(this.gGY);
            i = this.gGO.doConvert(this.gGP, this.gGQ);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        if (this.gGT != null) {
            if (i == 0) {
                this.gGT.byN();
            } else {
                this.gGT.uM(i);
            }
        }
    }

    public void ch(String str, String str2) {
        this.gGX = true;
        this.gGW = false;
        this.gGV = -3;
        this.gGP = str;
        this.gGQ = str2;
        this.gGR = new File(this.gGP);
        this.gGS = new File(this.gGQ);
        if (this.gGO == null) {
            startService();
            KC();
            return;
        }
        bzE();
    }

    public boolean isConvertRunning() {
        try {
            if (this.gGO != null) {
                if (this.gGO.isConvertRunning()) {
                    return true;
                }
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void abortConvert() {
        if (this.gGO != null) {
            try {
                this.gGO.abortConvert();
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
            g.this.gGV = 1;
            if (g.this.gGT != null) {
                g.this.gGT.onConvertSuccess();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertFailed() throws RemoteException {
            if (g.this.gGT != null) {
                g.this.gGT.onConvertFailed();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertProgress(int i) throws RemoteException {
            if (g.this.gGT != null) {
                g.this.gGT.onConvertProgress(i);
            }
            if ((g.this.gGR != null && !g.this.gGR.exists()) || (g.this.gGS != null && !g.this.gGS.exists())) {
                g.this.abortConvert();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertAborted() throws RemoteException {
            if (g.this.gGT != null) {
                g.this.gGT.onConvertAborted();
            }
        }
    }

    public void a(f fVar) {
        this.gGT = fVar;
    }
}
