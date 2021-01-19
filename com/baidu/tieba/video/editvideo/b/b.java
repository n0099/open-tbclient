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
    private String nAR;
    private a nCC;
    private f nCD;
    private d nCE;
    private e nCF;
    private volatile boolean nCG;
    private volatile boolean nCH;
    private volatile boolean nCI;

    /* loaded from: classes7.dex */
    public interface a {
        void Tk(String str);

        void bW(int i, String str);

        void bX(int i, String str);
    }

    public b(Context context, String str, String str2, String str3) {
        this.mContext = context;
        this.mSourcePath = str;
        this.nAR = str2;
        this.mFilterName = str3;
    }

    public void dQr() {
        if (!this.mIsRunning) {
            this.mIsRunning = true;
            this.nCG = false;
            this.nCH = false;
            this.nCI = false;
            try {
                File file = new File(new File(this.nAR).getParent());
                if (!file.exists()) {
                    file.mkdirs();
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (this.nCC != null) {
                    this.nCC.bW(222, com.baidu.tieba.l.a.p(e));
                }
            }
            try {
                this.nCF = new e(this.nAR);
                this.nCD = new f(this.mContext, this.mSourcePath, this.mFilterName, this.nCF, this.nCC) { // from class: com.baidu.tieba.video.editvideo.b.b.1
                    @Override // com.baidu.tieba.video.editvideo.b.f
                    public void onPostExecute() {
                        b.this.nCG = true;
                        b.this.dQt();
                    }
                };
                this.nCD.start();
                this.nCE = new d(this.mContext, this.mSourcePath, this.nCF, this.nCC) { // from class: com.baidu.tieba.video.editvideo.b.b.2
                    @Override // com.baidu.tieba.video.editvideo.b.d
                    public void onPostExecute() {
                        b.this.nCH = true;
                        b.this.dQt();
                    }
                };
                this.nCE.start();
            } catch (Exception e2) {
            }
        }
    }

    public void dQs() {
        if (this.nCD != null) {
            this.nCD.interrupt();
            this.nCD = null;
        }
        if (this.nCE != null) {
            this.nCE.interrupt();
            this.nCE = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dQt() {
        if (this.nCG && this.nCH && !this.nCI) {
            this.nCF.stop();
            this.nCI = true;
            dQu();
        }
    }

    private void dQu() {
        if (this.nCC != null) {
            File file = new File(this.nAR);
            if (file.exists() && file.length() > 0) {
                this.nCC.Tk(this.nAR);
            } else {
                this.nCC.bW(223, "Err empty outputFile");
            }
        }
        this.mIsRunning = false;
    }

    public boolean isRunning() {
        return this.mIsRunning;
    }

    public void a(a aVar) {
        this.nCC = aVar;
    }
}
