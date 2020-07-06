package com.baidu.tieba.video.editvideo.b;

import android.annotation.TargetApi;
import android.content.Context;
import java.io.File;
@TargetApi(18)
/* loaded from: classes10.dex */
public class b {
    private String lUN;
    private a lWA;
    private String lWB;
    private f lWC;
    private d lWD;
    private e lWE;
    private volatile boolean lWF;
    private volatile boolean lWG;
    private volatile boolean lWH;
    private Context mContext;
    private String mFilterName;
    private boolean mIsRunning = false;

    /* loaded from: classes10.dex */
    public interface a {
        void Ob(String str);

        void bG(int i, String str);

        void bH(int i, String str);
    }

    public b(Context context, String str, String str2, String str3) {
        this.mContext = context;
        this.lWB = str;
        this.lUN = str2;
        this.mFilterName = str3;
    }

    public void dmU() {
        if (!this.mIsRunning) {
            this.mIsRunning = true;
            this.lWF = false;
            this.lWG = false;
            this.lWH = false;
            try {
                File file = new File(new File(this.lUN).getParent());
                if (!file.exists()) {
                    file.mkdirs();
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (this.lWA != null) {
                    this.lWA.bG(222, com.baidu.tieba.k.a.t(e));
                }
            }
            try {
                this.lWE = new e(this.lUN);
                this.lWC = new f(this.mContext, this.lWB, this.mFilterName, this.lWE, this.lWA) { // from class: com.baidu.tieba.video.editvideo.b.b.1
                    @Override // com.baidu.tieba.video.editvideo.b.f
                    public void onPostExecute() {
                        b.this.lWF = true;
                        b.this.dmW();
                    }
                };
                this.lWC.start();
                this.lWD = new d(this.mContext, this.lWB, this.lWE, this.lWA) { // from class: com.baidu.tieba.video.editvideo.b.b.2
                    @Override // com.baidu.tieba.video.editvideo.b.d
                    public void onPostExecute() {
                        b.this.lWG = true;
                        b.this.dmW();
                    }
                };
                this.lWD.start();
            } catch (Exception e2) {
            }
        }
    }

    public void dmV() {
        if (this.lWC != null) {
            this.lWC.interrupt();
            this.lWC = null;
        }
        if (this.lWD != null) {
            this.lWD.interrupt();
            this.lWD = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dmW() {
        if (this.lWF && this.lWG && !this.lWH) {
            this.lWE.stop();
            this.lWH = true;
            dmX();
        }
    }

    private void dmX() {
        if (this.lWA != null) {
            File file = new File(this.lUN);
            if (file.exists() && file.length() > 0) {
                this.lWA.Ob(this.lUN);
            } else {
                this.lWA.bG(223, "Err empty outputFile");
            }
        }
        this.mIsRunning = false;
    }

    public boolean isRunning() {
        return this.mIsRunning;
    }

    public void a(a aVar) {
        this.lWA = aVar;
    }
}
