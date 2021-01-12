package com.baidu.tieba.video.editvideo.b;

import android.annotation.TargetApi;
import android.content.Context;
import java.io.File;
@TargetApi(18)
/* loaded from: classes7.dex */
public class b {
    private Context mContext;
    private String mFilterName;
    private boolean mIsRunning = false;
    private String mSourcePath;
    private String nAQ;
    private a nCB;
    private f nCC;
    private d nCD;
    private e nCE;
    private volatile boolean nCF;
    private volatile boolean nCG;
    private volatile boolean nCH;

    /* loaded from: classes7.dex */
    public interface a {
        void Tj(String str);

        void bW(int i, String str);

        void bX(int i, String str);
    }

    public b(Context context, String str, String str2, String str3) {
        this.mContext = context;
        this.mSourcePath = str;
        this.nAQ = str2;
        this.mFilterName = str3;
    }

    public void dQr() {
        if (!this.mIsRunning) {
            this.mIsRunning = true;
            this.nCF = false;
            this.nCG = false;
            this.nCH = false;
            try {
                File file = new File(new File(this.nAQ).getParent());
                if (!file.exists()) {
                    file.mkdirs();
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (this.nCB != null) {
                    this.nCB.bW(222, com.baidu.tieba.l.a.p(e));
                }
            }
            try {
                this.nCE = new e(this.nAQ);
                this.nCC = new f(this.mContext, this.mSourcePath, this.mFilterName, this.nCE, this.nCB) { // from class: com.baidu.tieba.video.editvideo.b.b.1
                    @Override // com.baidu.tieba.video.editvideo.b.f
                    public void onPostExecute() {
                        b.this.nCF = true;
                        b.this.dQt();
                    }
                };
                this.nCC.start();
                this.nCD = new d(this.mContext, this.mSourcePath, this.nCE, this.nCB) { // from class: com.baidu.tieba.video.editvideo.b.b.2
                    @Override // com.baidu.tieba.video.editvideo.b.d
                    public void onPostExecute() {
                        b.this.nCG = true;
                        b.this.dQt();
                    }
                };
                this.nCD.start();
            } catch (Exception e2) {
            }
        }
    }

    public void dQs() {
        if (this.nCC != null) {
            this.nCC.interrupt();
            this.nCC = null;
        }
        if (this.nCD != null) {
            this.nCD.interrupt();
            this.nCD = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dQt() {
        if (this.nCF && this.nCG && !this.nCH) {
            this.nCE.stop();
            this.nCH = true;
            dQu();
        }
    }

    private void dQu() {
        if (this.nCB != null) {
            File file = new File(this.nAQ);
            if (file.exists() && file.length() > 0) {
                this.nCB.Tj(this.nAQ);
            } else {
                this.nCB.bW(223, "Err empty outputFile");
            }
        }
        this.mIsRunning = false;
    }

    public boolean isRunning() {
        return this.mIsRunning;
    }

    public void a(a aVar) {
        this.nCB = aVar;
    }
}
