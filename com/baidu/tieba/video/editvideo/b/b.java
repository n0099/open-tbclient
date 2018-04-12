package com.baidu.tieba.video.editvideo.b;

import android.annotation.TargetApi;
import android.content.Context;
import java.io.File;
@TargetApi(18)
/* loaded from: classes2.dex */
public class b {
    private String gKd;
    private a gLP;
    private String gLQ;
    private f gLR;
    private d gLS;
    private e gLT;
    private volatile boolean gLU;
    private volatile boolean gLV;
    private volatile boolean gLW;
    private Context mContext;
    private String mFilterName;
    private boolean mIsRunning = false;

    /* loaded from: classes2.dex */
    public interface a {
        void ap(int i, String str);

        void aq(int i, String str);

        void tN(String str);
    }

    public b(Context context, String str, String str2, String str3) {
        this.mContext = context;
        this.gLQ = str;
        this.gKd = str2;
        this.mFilterName = str3;
    }

    public void bwA() {
        if (!this.mIsRunning) {
            this.mIsRunning = true;
            this.gLU = false;
            this.gLV = false;
            this.gLW = false;
            try {
                File file = new File(new File(this.gKd).getParent());
                if (!file.exists()) {
                    file.mkdirs();
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (this.gLP != null) {
                    this.gLP.ap(222, com.baidu.tieba.j.a.g(e));
                }
            }
            try {
                this.gLT = new e(this.gKd);
                this.gLR = new f(this.mContext, this.gLQ, this.mFilterName, this.gLT, this.gLP) { // from class: com.baidu.tieba.video.editvideo.b.b.1
                    @Override // com.baidu.tieba.video.editvideo.b.f
                    public void onPostExecute() {
                        b.this.gLU = true;
                        b.this.bwC();
                    }
                };
                this.gLR.start();
                this.gLS = new d(this.mContext, this.gLQ, this.gLT, this.gLP) { // from class: com.baidu.tieba.video.editvideo.b.b.2
                    @Override // com.baidu.tieba.video.editvideo.b.d
                    public void onPostExecute() {
                        b.this.gLV = true;
                        b.this.bwC();
                    }
                };
                this.gLS.start();
            } catch (Exception e2) {
            }
        }
    }

    public void bwB() {
        if (this.gLR != null) {
            this.gLR.interrupt();
            this.gLR = null;
        }
        if (this.gLS != null) {
            this.gLS.interrupt();
            this.gLS = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bwC() {
        if (this.gLU && this.gLV && !this.gLW) {
            this.gLT.stop();
            this.gLW = true;
            bwD();
        }
    }

    private void bwD() {
        if (this.gLP != null) {
            File file = new File(this.gKd);
            if (file.exists() && file.length() > 0) {
                this.gLP.tN(this.gKd);
            } else {
                this.gLP.ap(223, "Err empty outputFile");
            }
        }
        this.mIsRunning = false;
    }

    public boolean isRunning() {
        return this.mIsRunning;
    }

    public void a(a aVar) {
        this.gLP = aVar;
    }
}
