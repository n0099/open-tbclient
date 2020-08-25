package com.baidu.tieba.video.editvideo.b;

import android.annotation.TargetApi;
import android.content.Context;
import java.io.File;
@TargetApi(18)
/* loaded from: classes17.dex */
public class b {
    private Context mContext;
    private String mFilterName;
    private boolean mIsRunning = false;
    private String mtQ;
    private a mvD;
    private String mvE;
    private f mvF;
    private d mvG;
    private e mvH;
    private volatile boolean mvI;
    private volatile boolean mvJ;
    private volatile boolean mvK;

    /* loaded from: classes17.dex */
    public interface a {
        void RH(String str);

        void bF(int i, String str);

        void bG(int i, String str);
    }

    public b(Context context, String str, String str2, String str3) {
        this.mContext = context;
        this.mvE = str;
        this.mtQ = str2;
        this.mFilterName = str3;
    }

    public void dBA() {
        if (!this.mIsRunning) {
            this.mIsRunning = true;
            this.mvI = false;
            this.mvJ = false;
            this.mvK = false;
            try {
                File file = new File(new File(this.mtQ).getParent());
                if (!file.exists()) {
                    file.mkdirs();
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (this.mvD != null) {
                    this.mvD.bF(222, com.baidu.tieba.k.a.r(e));
                }
            }
            try {
                this.mvH = new e(this.mtQ);
                this.mvF = new f(this.mContext, this.mvE, this.mFilterName, this.mvH, this.mvD) { // from class: com.baidu.tieba.video.editvideo.b.b.1
                    @Override // com.baidu.tieba.video.editvideo.b.f
                    public void onPostExecute() {
                        b.this.mvI = true;
                        b.this.dBC();
                    }
                };
                this.mvF.start();
                this.mvG = new d(this.mContext, this.mvE, this.mvH, this.mvD) { // from class: com.baidu.tieba.video.editvideo.b.b.2
                    @Override // com.baidu.tieba.video.editvideo.b.d
                    public void onPostExecute() {
                        b.this.mvJ = true;
                        b.this.dBC();
                    }
                };
                this.mvG.start();
            } catch (Exception e2) {
            }
        }
    }

    public void dBB() {
        if (this.mvF != null) {
            this.mvF.interrupt();
            this.mvF = null;
        }
        if (this.mvG != null) {
            this.mvG.interrupt();
            this.mvG = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dBC() {
        if (this.mvI && this.mvJ && !this.mvK) {
            this.mvH.stop();
            this.mvK = true;
            dBD();
        }
    }

    private void dBD() {
        if (this.mvD != null) {
            File file = new File(this.mtQ);
            if (file.exists() && file.length() > 0) {
                this.mvD.RH(this.mtQ);
            } else {
                this.mvD.bF(223, "Err empty outputFile");
            }
        }
        this.mIsRunning = false;
    }

    public boolean isRunning() {
        return this.mIsRunning;
    }

    public void a(a aVar) {
        this.mvD = aVar;
    }
}
