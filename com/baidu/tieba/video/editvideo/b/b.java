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
    private String nFw;
    private a nHh;
    private f nHi;
    private d nHj;
    private e nHk;
    private volatile boolean nHl;
    private volatile boolean nHm;
    private volatile boolean nHn;

    /* loaded from: classes8.dex */
    public interface a {
        void Us(String str);

        void bV(int i, String str);

        void bW(int i, String str);
    }

    public b(Context context, String str, String str2, String str3) {
        this.mContext = context;
        this.mSourcePath = str;
        this.nFw = str2;
        this.mFilterName = str3;
    }

    public void dUi() {
        if (!this.mIsRunning) {
            this.mIsRunning = true;
            this.nHl = false;
            this.nHm = false;
            this.nHn = false;
            try {
                File file = new File(new File(this.nFw).getParent());
                if (!file.exists()) {
                    file.mkdirs();
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (this.nHh != null) {
                    this.nHh.bV(222, com.baidu.tieba.l.a.p(e));
                }
            }
            try {
                this.nHk = new e(this.nFw);
                this.nHi = new f(this.mContext, this.mSourcePath, this.mFilterName, this.nHk, this.nHh) { // from class: com.baidu.tieba.video.editvideo.b.b.1
                    @Override // com.baidu.tieba.video.editvideo.b.f
                    public void onPostExecute() {
                        b.this.nHl = true;
                        b.this.dUk();
                    }
                };
                this.nHi.start();
                this.nHj = new d(this.mContext, this.mSourcePath, this.nHk, this.nHh) { // from class: com.baidu.tieba.video.editvideo.b.b.2
                    @Override // com.baidu.tieba.video.editvideo.b.d
                    public void onPostExecute() {
                        b.this.nHm = true;
                        b.this.dUk();
                    }
                };
                this.nHj.start();
            } catch (Exception e2) {
            }
        }
    }

    public void dUj() {
        if (this.nHi != null) {
            this.nHi.interrupt();
            this.nHi = null;
        }
        if (this.nHj != null) {
            this.nHj.interrupt();
            this.nHj = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dUk() {
        if (this.nHl && this.nHm && !this.nHn) {
            this.nHk.stop();
            this.nHn = true;
            dUl();
        }
    }

    private void dUl() {
        if (this.nHh != null) {
            File file = new File(this.nFw);
            if (file.exists() && file.length() > 0) {
                this.nHh.Us(this.nFw);
            } else {
                this.nHh.bV(223, "Err empty outputFile");
            }
        }
        this.mIsRunning = false;
    }

    public boolean isRunning() {
        return this.mIsRunning;
    }

    public void a(a aVar) {
        this.nHh = aVar;
    }
}
