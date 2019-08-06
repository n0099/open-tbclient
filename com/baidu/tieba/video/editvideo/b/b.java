package com.baidu.tieba.video.editvideo.b;

import android.annotation.TargetApi;
import android.content.Context;
import java.io.File;
@TargetApi(18)
/* loaded from: classes5.dex */
public class b {
    private boolean Cg = false;
    private String jva;
    private a jwL;
    private String jwM;
    private f jwN;
    private d jwO;
    private e jwP;
    private volatile boolean jwQ;
    private volatile boolean jwR;
    private volatile boolean jwS;
    private Context mContext;
    private String mFilterName;

    /* loaded from: classes5.dex */
    public interface a {
        void FH(String str);

        void aK(int i, String str);

        void aL(int i, String str);
    }

    public b(Context context, String str, String str2, String str3) {
        this.mContext = context;
        this.jwM = str;
        this.jva = str2;
        this.mFilterName = str3;
    }

    public void cuI() {
        if (!this.Cg) {
            this.Cg = true;
            this.jwQ = false;
            this.jwR = false;
            this.jwS = false;
            try {
                File file = new File(new File(this.jva).getParent());
                if (!file.exists()) {
                    file.mkdirs();
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (this.jwL != null) {
                    this.jwL.aK(222, com.baidu.tieba.j.a.p(e));
                }
            }
            try {
                this.jwP = new e(this.jva);
                this.jwN = new f(this.mContext, this.jwM, this.mFilterName, this.jwP, this.jwL) { // from class: com.baidu.tieba.video.editvideo.b.b.1
                    @Override // com.baidu.tieba.video.editvideo.b.f
                    public void onPostExecute() {
                        b.this.jwQ = true;
                        b.this.cuK();
                    }
                };
                this.jwN.start();
                this.jwO = new d(this.mContext, this.jwM, this.jwP, this.jwL) { // from class: com.baidu.tieba.video.editvideo.b.b.2
                    @Override // com.baidu.tieba.video.editvideo.b.d
                    public void onPostExecute() {
                        b.this.jwR = true;
                        b.this.cuK();
                    }
                };
                this.jwO.start();
            } catch (Exception e2) {
            }
        }
    }

    public void cuJ() {
        if (this.jwN != null) {
            this.jwN.interrupt();
            this.jwN = null;
        }
        if (this.jwO != null) {
            this.jwO.interrupt();
            this.jwO = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cuK() {
        if (this.jwQ && this.jwR && !this.jwS) {
            this.jwP.stop();
            this.jwS = true;
            cuL();
        }
    }

    private void cuL() {
        if (this.jwL != null) {
            File file = new File(this.jva);
            if (file.exists() && file.length() > 0) {
                this.jwL.FH(this.jva);
            } else {
                this.jwL.aK(223, "Err empty outputFile");
            }
        }
        this.Cg = false;
    }

    public boolean isRunning() {
        return this.Cg;
    }

    public void a(a aVar) {
        this.jwL = aVar;
    }
}
