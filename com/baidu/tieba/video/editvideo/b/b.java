package com.baidu.tieba.video.editvideo.b;

import android.annotation.TargetApi;
import android.content.Context;
import java.io.File;
@TargetApi(18)
/* loaded from: classes10.dex */
public class b {
    private String lBe;
    private a lCO;
    private String lCP;
    private f lCQ;
    private d lCR;
    private e lCS;
    private volatile boolean lCT;
    private volatile boolean lCU;
    private volatile boolean lCV;
    private Context mContext;
    private String mFilterName;
    private boolean mIsRunning = false;

    /* loaded from: classes10.dex */
    public interface a {
        void Nw(String str);

        void bA(int i, String str);

        void bz(int i, String str);

        void diB();
    }

    public b(Context context, String str, String str2, String str3) {
        this.mContext = context;
        this.lCP = str;
        this.lBe = str2;
        this.mFilterName = str3;
    }

    public void diH() {
        if (!this.mIsRunning) {
            this.mIsRunning = true;
            this.lCT = false;
            this.lCU = false;
            this.lCV = false;
            try {
                File file = new File(new File(this.lBe).getParent());
                if (!file.exists()) {
                    file.mkdirs();
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (this.lCO != null) {
                    this.lCO.bz(222, com.baidu.tieba.k.a.t(e));
                }
            }
            try {
                this.lCS = new e(this.lBe);
                this.lCQ = new f(this.mContext, this.lCP, this.mFilterName, this.lCS, this.lCO) { // from class: com.baidu.tieba.video.editvideo.b.b.1
                    @Override // com.baidu.tieba.video.editvideo.b.f
                    public void onPostExecute() {
                        b.this.lCT = true;
                        b.this.diJ();
                    }
                };
                this.lCQ.start();
                this.lCR = new d(this.mContext, this.lCP, this.lCS, this.lCO) { // from class: com.baidu.tieba.video.editvideo.b.b.2
                    @Override // com.baidu.tieba.video.editvideo.b.d
                    public void onPostExecute() {
                        b.this.lCU = true;
                        b.this.diJ();
                    }
                };
                this.lCR.start();
            } catch (Exception e2) {
            }
        }
    }

    public void diI() {
        if (this.lCQ != null) {
            this.lCQ.interrupt();
            this.lCQ = null;
        }
        if (this.lCR != null) {
            this.lCR.interrupt();
            this.lCR = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void diJ() {
        if (this.lCT && this.lCU && !this.lCV) {
            this.lCS.stop();
            this.lCV = true;
            diK();
        }
    }

    private void diK() {
        if (this.lCO != null) {
            File file = new File(this.lBe);
            if (file.exists() && file.length() > 0) {
                this.lCO.Nw(this.lBe);
            } else {
                this.lCO.bz(223, "Err empty outputFile");
            }
        }
        this.mIsRunning = false;
    }

    public boolean isRunning() {
        return this.mIsRunning;
    }

    public void a(a aVar) {
        this.lCO = aVar;
    }
}
