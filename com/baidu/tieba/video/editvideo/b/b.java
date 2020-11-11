package com.baidu.tieba.video.editvideo.b;

import android.annotation.TargetApi;
import android.content.Context;
import java.io.File;
@TargetApi(18)
/* loaded from: classes23.dex */
public class b {
    private Context mContext;
    private String mFilterName;
    private boolean mIsRunning = false;
    private String mSourcePath;
    private String nmd;
    private a nnQ;
    private f nnR;
    private d nnS;
    private e nnT;
    private volatile boolean nnU;
    private volatile boolean nnV;
    private volatile boolean nnW;

    /* loaded from: classes23.dex */
    public interface a {
        void TL(String str);

        void bX(int i, String str);

        void bY(int i, String str);
    }

    public b(Context context, String str, String str2, String str3) {
        this.mContext = context;
        this.mSourcePath = str;
        this.nmd = str2;
        this.mFilterName = str3;
    }

    public void dOZ() {
        if (!this.mIsRunning) {
            this.mIsRunning = true;
            this.nnU = false;
            this.nnV = false;
            this.nnW = false;
            try {
                File file = new File(new File(this.nmd).getParent());
                if (!file.exists()) {
                    file.mkdirs();
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (this.nnQ != null) {
                    this.nnQ.bX(222, com.baidu.tieba.k.a.r(e));
                }
            }
            try {
                this.nnT = new e(this.nmd);
                this.nnR = new f(this.mContext, this.mSourcePath, this.mFilterName, this.nnT, this.nnQ) { // from class: com.baidu.tieba.video.editvideo.b.b.1
                    @Override // com.baidu.tieba.video.editvideo.b.f
                    public void onPostExecute() {
                        b.this.nnU = true;
                        b.this.dPb();
                    }
                };
                this.nnR.start();
                this.nnS = new d(this.mContext, this.mSourcePath, this.nnT, this.nnQ) { // from class: com.baidu.tieba.video.editvideo.b.b.2
                    @Override // com.baidu.tieba.video.editvideo.b.d
                    public void onPostExecute() {
                        b.this.nnV = true;
                        b.this.dPb();
                    }
                };
                this.nnS.start();
            } catch (Exception e2) {
            }
        }
    }

    public void dPa() {
        if (this.nnR != null) {
            this.nnR.interrupt();
            this.nnR = null;
        }
        if (this.nnS != null) {
            this.nnS.interrupt();
            this.nnS = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dPb() {
        if (this.nnU && this.nnV && !this.nnW) {
            this.nnT.stop();
            this.nnW = true;
            dPc();
        }
    }

    private void dPc() {
        if (this.nnQ != null) {
            File file = new File(this.nmd);
            if (file.exists() && file.length() > 0) {
                this.nnQ.TL(this.nmd);
            } else {
                this.nnQ.bX(223, "Err empty outputFile");
            }
        }
        this.mIsRunning = false;
    }

    public boolean isRunning() {
        return this.mIsRunning;
    }

    public void a(a aVar) {
        this.nnQ = aVar;
    }
}
