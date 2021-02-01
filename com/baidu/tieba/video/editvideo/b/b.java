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
    private String nKB;
    private a nMm;
    private f nMn;
    private d nMo;
    private e nMp;
    private volatile boolean nMq;
    private volatile boolean nMr;
    private volatile boolean nMs;

    /* loaded from: classes8.dex */
    public interface a {
        void Uh(String str);

        void cd(int i, String str);

        void ce(int i, String str);
    }

    public b(Context context, String str, String str2, String str3) {
        this.mContext = context;
        this.mSourcePath = str;
        this.nKB = str2;
        this.mFilterName = str3;
    }

    public void dSC() {
        if (!this.mIsRunning) {
            this.mIsRunning = true;
            this.nMq = false;
            this.nMr = false;
            this.nMs = false;
            try {
                File file = new File(new File(this.nKB).getParent());
                if (!file.exists()) {
                    file.mkdirs();
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (this.nMm != null) {
                    this.nMm.cd(222, com.baidu.tieba.l.a.o(e));
                }
            }
            try {
                this.nMp = new e(this.nKB);
                this.nMn = new f(this.mContext, this.mSourcePath, this.mFilterName, this.nMp, this.nMm) { // from class: com.baidu.tieba.video.editvideo.b.b.1
                    @Override // com.baidu.tieba.video.editvideo.b.f
                    public void onPostExecute() {
                        b.this.nMq = true;
                        b.this.dSE();
                    }
                };
                this.nMn.start();
                this.nMo = new d(this.mContext, this.mSourcePath, this.nMp, this.nMm) { // from class: com.baidu.tieba.video.editvideo.b.b.2
                    @Override // com.baidu.tieba.video.editvideo.b.d
                    public void onPostExecute() {
                        b.this.nMr = true;
                        b.this.dSE();
                    }
                };
                this.nMo.start();
            } catch (Exception e2) {
            }
        }
    }

    public void dSD() {
        if (this.nMn != null) {
            this.nMn.interrupt();
            this.nMn = null;
        }
        if (this.nMo != null) {
            this.nMo.interrupt();
            this.nMo = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dSE() {
        if (this.nMq && this.nMr && !this.nMs) {
            this.nMp.stop();
            this.nMs = true;
            dSF();
        }
    }

    private void dSF() {
        if (this.nMm != null) {
            File file = new File(this.nKB);
            if (file.exists() && file.length() > 0) {
                this.nMm.Uh(this.nKB);
            } else {
                this.nMm.cd(223, "Err empty outputFile");
            }
        }
        this.mIsRunning = false;
    }

    public boolean isRunning() {
        return this.mIsRunning;
    }

    public void a(a aVar) {
        this.nMm = aVar;
    }
}
