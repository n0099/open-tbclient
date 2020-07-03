package com.baidu.tieba.video.editvideo.b;

import android.annotation.TargetApi;
import android.content.Context;
import java.io.File;
@TargetApi(18)
/* loaded from: classes10.dex */
public class b {
    private String lUK;
    private d lWA;
    private e lWB;
    private volatile boolean lWC;
    private volatile boolean lWD;
    private volatile boolean lWE;
    private a lWx;
    private String lWy;
    private f lWz;
    private Context mContext;
    private String mFilterName;
    private boolean mIsRunning = false;

    /* loaded from: classes10.dex */
    public interface a {
        void Oa(String str);

        void bG(int i, String str);

        void bH(int i, String str);
    }

    public b(Context context, String str, String str2, String str3) {
        this.mContext = context;
        this.lWy = str;
        this.lUK = str2;
        this.mFilterName = str3;
    }

    public void dmQ() {
        if (!this.mIsRunning) {
            this.mIsRunning = true;
            this.lWC = false;
            this.lWD = false;
            this.lWE = false;
            try {
                File file = new File(new File(this.lUK).getParent());
                if (!file.exists()) {
                    file.mkdirs();
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (this.lWx != null) {
                    this.lWx.bG(222, com.baidu.tieba.k.a.t(e));
                }
            }
            try {
                this.lWB = new e(this.lUK);
                this.lWz = new f(this.mContext, this.lWy, this.mFilterName, this.lWB, this.lWx) { // from class: com.baidu.tieba.video.editvideo.b.b.1
                    @Override // com.baidu.tieba.video.editvideo.b.f
                    public void onPostExecute() {
                        b.this.lWC = true;
                        b.this.dmS();
                    }
                };
                this.lWz.start();
                this.lWA = new d(this.mContext, this.lWy, this.lWB, this.lWx) { // from class: com.baidu.tieba.video.editvideo.b.b.2
                    @Override // com.baidu.tieba.video.editvideo.b.d
                    public void onPostExecute() {
                        b.this.lWD = true;
                        b.this.dmS();
                    }
                };
                this.lWA.start();
            } catch (Exception e2) {
            }
        }
    }

    public void dmR() {
        if (this.lWz != null) {
            this.lWz.interrupt();
            this.lWz = null;
        }
        if (this.lWA != null) {
            this.lWA.interrupt();
            this.lWA = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dmS() {
        if (this.lWC && this.lWD && !this.lWE) {
            this.lWB.stop();
            this.lWE = true;
            dmT();
        }
    }

    private void dmT() {
        if (this.lWx != null) {
            File file = new File(this.lUK);
            if (file.exists() && file.length() > 0) {
                this.lWx.Oa(this.lUK);
            } else {
                this.lWx.bG(223, "Err empty outputFile");
            }
        }
        this.mIsRunning = false;
    }

    public boolean isRunning() {
        return this.mIsRunning;
    }

    public void a(a aVar) {
        this.lWx = aVar;
    }
}
