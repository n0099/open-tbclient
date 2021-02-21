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
    private String nLb;
    private a nMM;
    private f nMN;
    private d nMO;
    private e nMP;
    private volatile boolean nMQ;
    private volatile boolean nMR;
    private volatile boolean nMS;

    /* loaded from: classes8.dex */
    public interface a {
        void Ut(String str);

        void cd(int i, String str);

        void ce(int i, String str);
    }

    public b(Context context, String str, String str2, String str3) {
        this.mContext = context;
        this.mSourcePath = str;
        this.nLb = str2;
        this.mFilterName = str3;
    }

    public void dSK() {
        if (!this.mIsRunning) {
            this.mIsRunning = true;
            this.nMQ = false;
            this.nMR = false;
            this.nMS = false;
            try {
                File file = new File(new File(this.nLb).getParent());
                if (!file.exists()) {
                    file.mkdirs();
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (this.nMM != null) {
                    this.nMM.cd(222, com.baidu.tieba.l.a.o(e));
                }
            }
            try {
                this.nMP = new e(this.nLb);
                this.nMN = new f(this.mContext, this.mSourcePath, this.mFilterName, this.nMP, this.nMM) { // from class: com.baidu.tieba.video.editvideo.b.b.1
                    @Override // com.baidu.tieba.video.editvideo.b.f
                    public void onPostExecute() {
                        b.this.nMQ = true;
                        b.this.dSM();
                    }
                };
                this.nMN.start();
                this.nMO = new d(this.mContext, this.mSourcePath, this.nMP, this.nMM) { // from class: com.baidu.tieba.video.editvideo.b.b.2
                    @Override // com.baidu.tieba.video.editvideo.b.d
                    public void onPostExecute() {
                        b.this.nMR = true;
                        b.this.dSM();
                    }
                };
                this.nMO.start();
            } catch (Exception e2) {
            }
        }
    }

    public void dSL() {
        if (this.nMN != null) {
            this.nMN.interrupt();
            this.nMN = null;
        }
        if (this.nMO != null) {
            this.nMO.interrupt();
            this.nMO = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dSM() {
        if (this.nMQ && this.nMR && !this.nMS) {
            this.nMP.stop();
            this.nMS = true;
            dSN();
        }
    }

    private void dSN() {
        if (this.nMM != null) {
            File file = new File(this.nLb);
            if (file.exists() && file.length() > 0) {
                this.nMM.Ut(this.nLb);
            } else {
                this.nMM.cd(223, "Err empty outputFile");
            }
        }
        this.mIsRunning = false;
    }

    public boolean isRunning() {
        return this.mIsRunning;
    }

    public void a(a aVar) {
        this.nMM = aVar;
    }
}
