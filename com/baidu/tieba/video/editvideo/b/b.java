package com.baidu.tieba.video.editvideo.b;

import android.annotation.TargetApi;
import android.content.Context;
import java.io.File;
@TargetApi(18)
/* loaded from: classes8.dex */
public class b {
    private Context mContext;
    private String mFilterName;
    private boolean mIsRunning = false;
    private String mSourcePath;
    private String nFv;
    private a nHg;
    private f nHh;
    private d nHi;
    private e nHj;
    private volatile boolean nHk;
    private volatile boolean nHl;
    private volatile boolean nHm;

    /* loaded from: classes8.dex */
    public interface a {
        void Ur(String str);

        void bV(int i, String str);

        void bW(int i, String str);
    }

    public b(Context context, String str, String str2, String str3) {
        this.mContext = context;
        this.mSourcePath = str;
        this.nFv = str2;
        this.mFilterName = str3;
    }

    public void dUj() {
        if (!this.mIsRunning) {
            this.mIsRunning = true;
            this.nHk = false;
            this.nHl = false;
            this.nHm = false;
            try {
                File file = new File(new File(this.nFv).getParent());
                if (!file.exists()) {
                    file.mkdirs();
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (this.nHg != null) {
                    this.nHg.bV(222, com.baidu.tieba.l.a.p(e));
                }
            }
            try {
                this.nHj = new e(this.nFv);
                this.nHh = new f(this.mContext, this.mSourcePath, this.mFilterName, this.nHj, this.nHg) { // from class: com.baidu.tieba.video.editvideo.b.b.1
                    @Override // com.baidu.tieba.video.editvideo.b.f
                    public void onPostExecute() {
                        b.this.nHk = true;
                        b.this.dUl();
                    }
                };
                this.nHh.start();
                this.nHi = new d(this.mContext, this.mSourcePath, this.nHj, this.nHg) { // from class: com.baidu.tieba.video.editvideo.b.b.2
                    @Override // com.baidu.tieba.video.editvideo.b.d
                    public void onPostExecute() {
                        b.this.nHl = true;
                        b.this.dUl();
                    }
                };
                this.nHi.start();
            } catch (Exception e2) {
            }
        }
    }

    public void dUk() {
        if (this.nHh != null) {
            this.nHh.interrupt();
            this.nHh = null;
        }
        if (this.nHi != null) {
            this.nHi.interrupt();
            this.nHi = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dUl() {
        if (this.nHk && this.nHl && !this.nHm) {
            this.nHj.stop();
            this.nHm = true;
            dUm();
        }
    }

    private void dUm() {
        if (this.nHg != null) {
            File file = new File(this.nFv);
            if (file.exists() && file.length() > 0) {
                this.nHg.Ur(this.nFv);
            } else {
                this.nHg.bV(223, "Err empty outputFile");
            }
        }
        this.mIsRunning = false;
    }

    public boolean isRunning() {
        return this.mIsRunning;
    }

    public void a(a aVar) {
        this.nHg = aVar;
    }
}
