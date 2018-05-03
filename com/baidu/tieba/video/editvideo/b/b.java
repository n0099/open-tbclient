package com.baidu.tieba.video.editvideo.b;

import android.annotation.TargetApi;
import android.content.Context;
import java.io.File;
@TargetApi(18)
/* loaded from: classes2.dex */
public class b {
    private String gKa;
    private a gLM;
    private String gLN;
    private f gLO;
    private d gLP;
    private e gLQ;
    private volatile boolean gLR;
    private volatile boolean gLS;
    private volatile boolean gLT;
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
        this.gLN = str;
        this.gKa = str2;
        this.mFilterName = str3;
    }

    public void bwA() {
        if (!this.mIsRunning) {
            this.mIsRunning = true;
            this.gLR = false;
            this.gLS = false;
            this.gLT = false;
            try {
                File file = new File(new File(this.gKa).getParent());
                if (!file.exists()) {
                    file.mkdirs();
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (this.gLM != null) {
                    this.gLM.ap(222, com.baidu.tieba.j.a.g(e));
                }
            }
            try {
                this.gLQ = new e(this.gKa);
                this.gLO = new f(this.mContext, this.gLN, this.mFilterName, this.gLQ, this.gLM) { // from class: com.baidu.tieba.video.editvideo.b.b.1
                    @Override // com.baidu.tieba.video.editvideo.b.f
                    public void onPostExecute() {
                        b.this.gLR = true;
                        b.this.bwC();
                    }
                };
                this.gLO.start();
                this.gLP = new d(this.mContext, this.gLN, this.gLQ, this.gLM) { // from class: com.baidu.tieba.video.editvideo.b.b.2
                    @Override // com.baidu.tieba.video.editvideo.b.d
                    public void onPostExecute() {
                        b.this.gLS = true;
                        b.this.bwC();
                    }
                };
                this.gLP.start();
            } catch (Exception e2) {
            }
        }
    }

    public void bwB() {
        if (this.gLO != null) {
            this.gLO.interrupt();
            this.gLO = null;
        }
        if (this.gLP != null) {
            this.gLP.interrupt();
            this.gLP = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bwC() {
        if (this.gLR && this.gLS && !this.gLT) {
            this.gLQ.stop();
            this.gLT = true;
            bwD();
        }
    }

    private void bwD() {
        if (this.gLM != null) {
            File file = new File(this.gKa);
            if (file.exists() && file.length() > 0) {
                this.gLM.tN(this.gKa);
            } else {
                this.gLM.ap(223, "Err empty outputFile");
            }
        }
        this.mIsRunning = false;
    }

    public boolean isRunning() {
        return this.mIsRunning;
    }

    public void a(a aVar) {
        this.gLM = aVar;
    }
}
