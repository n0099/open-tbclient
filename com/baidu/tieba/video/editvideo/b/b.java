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
    private String nBn;
    private a nDa;
    private f nDb;
    private d nDc;
    private e nDd;
    private volatile boolean nDe;
    private volatile boolean nDf;
    private volatile boolean nDg;

    /* loaded from: classes23.dex */
    public interface a {
        void UL(String str);

        void bV(int i, String str);

        void bW(int i, String str);
    }

    public b(Context context, String str, String str2, String str3) {
        this.mContext = context;
        this.mSourcePath = str;
        this.nBn = str2;
        this.mFilterName = str3;
    }

    public void dUq() {
        if (!this.mIsRunning) {
            this.mIsRunning = true;
            this.nDe = false;
            this.nDf = false;
            this.nDg = false;
            try {
                File file = new File(new File(this.nBn).getParent());
                if (!file.exists()) {
                    file.mkdirs();
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (this.nDa != null) {
                    this.nDa.bV(222, com.baidu.tieba.l.a.r(e));
                }
            }
            try {
                this.nDd = new e(this.nBn);
                this.nDb = new f(this.mContext, this.mSourcePath, this.mFilterName, this.nDd, this.nDa) { // from class: com.baidu.tieba.video.editvideo.b.b.1
                    @Override // com.baidu.tieba.video.editvideo.b.f
                    public void onPostExecute() {
                        b.this.nDe = true;
                        b.this.dUs();
                    }
                };
                this.nDb.start();
                this.nDc = new d(this.mContext, this.mSourcePath, this.nDd, this.nDa) { // from class: com.baidu.tieba.video.editvideo.b.b.2
                    @Override // com.baidu.tieba.video.editvideo.b.d
                    public void onPostExecute() {
                        b.this.nDf = true;
                        b.this.dUs();
                    }
                };
                this.nDc.start();
            } catch (Exception e2) {
            }
        }
    }

    public void dUr() {
        if (this.nDb != null) {
            this.nDb.interrupt();
            this.nDb = null;
        }
        if (this.nDc != null) {
            this.nDc.interrupt();
            this.nDc = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dUs() {
        if (this.nDe && this.nDf && !this.nDg) {
            this.nDd.stop();
            this.nDg = true;
            dUt();
        }
    }

    private void dUt() {
        if (this.nDa != null) {
            File file = new File(this.nBn);
            if (file.exists() && file.length() > 0) {
                this.nDa.UL(this.nBn);
            } else {
                this.nDa.bV(223, "Err empty outputFile");
            }
        }
        this.mIsRunning = false;
    }

    public boolean isRunning() {
        return this.mIsRunning;
    }

    public void a(a aVar) {
        this.nDa = aVar;
    }
}
