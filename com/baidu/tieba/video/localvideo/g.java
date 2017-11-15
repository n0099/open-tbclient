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
    private IVideoConvertService gHW;
    private String gHX;
    private String gHY;
    private File gHZ;
    private File gIa;
    private f gIb;
    private Context mContext;
    private int gId = -3;
    private boolean gIe = false;
    private boolean gIf = false;
    private int gIg = 1;
    private ServiceConnection gla = new ServiceConnection() { // from class: com.baidu.tieba.video.localvideo.g.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            g.this.gHW = IVideoConvertService.Stub.asInterface(iBinder);
            if (g.this.gIf) {
                g.this.bzQ();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            if (g.this.gIf) {
                if (!g.this.gIe && g.this.gId == -3 && g.this.gIb != null) {
                    g.this.gIb.onConvertFailed();
                }
                g.this.gIf = false;
            }
            g.this.gHW = null;
        }
    };
    private a gIc = new a();

    public g(Context context) {
        this.mContext = context;
    }

    public void setConvertType(int i) {
        this.gIg = i;
    }

    public void destroy() {
        this.gIe = true;
        abortConvert();
        brP();
    }

    private void startService() {
        if (this.mContext != null) {
            this.mContext.startService(new Intent("com.baidu.tieba.video.convert.VideoConvertService"));
        }
    }

    private void KN() {
        if (this.mContext != null) {
            this.mContext.bindService(new Intent("com.baidu.tieba.video.convert.VideoConvertService"), this.gla, 1);
        }
    }

    private void brP() {
        if (this.gHW != null && this.mContext != null) {
            this.mContext.unbindService(this.gla);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bzQ() {
        int i = -1;
        try {
            this.gHW.setIVideoConvertListener(this.gIc);
            this.gHW.setConvertType(this.gIg);
            i = this.gHW.doConvert(this.gHX, this.gHY);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        if (this.gIb != null) {
            if (i == 0) {
                this.gIb.byZ();
            } else {
                this.gIb.uQ(i);
            }
        }
    }

    public void cl(String str, String str2) {
        this.gIf = true;
        this.gIe = false;
        this.gId = -3;
        this.gHX = str;
        this.gHY = str2;
        this.gHZ = new File(this.gHX);
        this.gIa = new File(this.gHY);
        if (this.gHW == null) {
            startService();
            KN();
            return;
        }
        bzQ();
    }

    public boolean isConvertRunning() {
        try {
            if (this.gHW != null) {
                if (this.gHW.isConvertRunning()) {
                    return true;
                }
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void abortConvert() {
        if (this.gHW != null) {
            try {
                this.gHW.abortConvert();
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
            g.this.gId = 1;
            if (g.this.gIb != null) {
                g.this.gIb.onConvertSuccess();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertFailed() throws RemoteException {
            if (g.this.gIb != null) {
                g.this.gIb.onConvertFailed();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertProgress(int i) throws RemoteException {
            if (g.this.gIb != null) {
                g.this.gIb.onConvertProgress(i);
            }
            if ((g.this.gHZ != null && !g.this.gHZ.exists()) || (g.this.gIa != null && !g.this.gIa.exists())) {
                g.this.abortConvert();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertAborted() throws RemoteException {
            if (g.this.gIb != null) {
                g.this.gIb.onConvertAborted();
            }
        }
    }

    public void a(f fVar) {
        this.gIb = fVar;
    }
}
