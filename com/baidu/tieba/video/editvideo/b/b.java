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
    private String nBp;
    private a nDc;
    private f nDd;
    private d nDe;
    private e nDf;
    private volatile boolean nDg;
    private volatile boolean nDh;
    private volatile boolean nDi;

    /* loaded from: classes23.dex */
    public interface a {
        void UL(String str);

        void bV(int i, String str);

        void bW(int i, String str);
    }

    public b(Context context, String str, String str2, String str3) {
        this.mContext = context;
        this.mSourcePath = str;
        this.nBp = str2;
        this.mFilterName = str3;
    }

    public void dUr() {
        if (!this.mIsRunning) {
            this.mIsRunning = true;
            this.nDg = false;
            this.nDh = false;
            this.nDi = false;
            try {
                File file = new File(new File(this.nBp).getParent());
                if (!file.exists()) {
                    file.mkdirs();
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (this.nDc != null) {
                    this.nDc.bV(222, com.baidu.tieba.l.a.r(e));
                }
            }
            try {
                this.nDf = new e(this.nBp);
                this.nDd = new f(this.mContext, this.mSourcePath, this.mFilterName, this.nDf, this.nDc) { // from class: com.baidu.tieba.video.editvideo.b.b.1
                    @Override // com.baidu.tieba.video.editvideo.b.f
                    public void onPostExecute() {
                        b.this.nDg = true;
                        b.this.dUt();
                    }
                };
                this.nDd.start();
                this.nDe = new d(this.mContext, this.mSourcePath, this.nDf, this.nDc) { // from class: com.baidu.tieba.video.editvideo.b.b.2
                    @Override // com.baidu.tieba.video.editvideo.b.d
                    public void onPostExecute() {
                        b.this.nDh = true;
                        b.this.dUt();
                    }
                };
                this.nDe.start();
            } catch (Exception e2) {
            }
        }
    }

    public void dUs() {
        if (this.nDd != null) {
            this.nDd.interrupt();
            this.nDd = null;
        }
        if (this.nDe != null) {
            this.nDe.interrupt();
            this.nDe = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dUt() {
        if (this.nDg && this.nDh && !this.nDi) {
            this.nDf.stop();
            this.nDi = true;
            dUu();
        }
    }

    private void dUu() {
        if (this.nDc != null) {
            File file = new File(this.nBp);
            if (file.exists() && file.length() > 0) {
                this.nDc.UL(this.nBp);
            } else {
                this.nDc.bV(223, "Err empty outputFile");
            }
        }
        this.mIsRunning = false;
    }

    public boolean isRunning() {
        return this.mIsRunning;
    }

    public void a(a aVar) {
        this.nDc = aVar;
    }
}
