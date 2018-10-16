package com.baidu.tieba.video.editvideo.b;

import android.annotation.TargetApi;
import android.content.Context;
import java.io.File;
@TargetApi(18)
/* loaded from: classes5.dex */
public class b {
    private boolean Ep = false;
    private String hrg;
    private a hsQ;
    private String hsR;
    private f hsS;
    private d hsT;
    private e hsU;
    private volatile boolean hsV;
    private volatile boolean hsW;
    private volatile boolean hsX;
    private Context mContext;
    private String mFilterName;

    /* loaded from: classes5.dex */
    public interface a {
        void aq(int i, String str);

        void ar(int i, String str);

        void vT(String str);
    }

    public b(Context context, String str, String str2, String str3) {
        this.mContext = context;
        this.hsR = str;
        this.hrg = str2;
        this.mFilterName = str3;
    }

    public void bGV() {
        if (!this.Ep) {
            this.Ep = true;
            this.hsV = false;
            this.hsW = false;
            this.hsX = false;
            try {
                File file = new File(new File(this.hrg).getParent());
                if (!file.exists()) {
                    file.mkdirs();
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (this.hsQ != null) {
                    this.hsQ.aq(222, com.baidu.tieba.j.a.o(e));
                }
            }
            try {
                this.hsU = new e(this.hrg);
                this.hsS = new f(this.mContext, this.hsR, this.mFilterName, this.hsU, this.hsQ) { // from class: com.baidu.tieba.video.editvideo.b.b.1
                    @Override // com.baidu.tieba.video.editvideo.b.f
                    public void onPostExecute() {
                        b.this.hsV = true;
                        b.this.bGX();
                    }
                };
                this.hsS.start();
                this.hsT = new d(this.mContext, this.hsR, this.hsU, this.hsQ) { // from class: com.baidu.tieba.video.editvideo.b.b.2
                    @Override // com.baidu.tieba.video.editvideo.b.d
                    public void onPostExecute() {
                        b.this.hsW = true;
                        b.this.bGX();
                    }
                };
                this.hsT.start();
            } catch (Exception e2) {
            }
        }
    }

    public void bGW() {
        if (this.hsS != null) {
            this.hsS.interrupt();
            this.hsS = null;
        }
        if (this.hsT != null) {
            this.hsT.interrupt();
            this.hsT = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGX() {
        if (this.hsV && this.hsW && !this.hsX) {
            this.hsU.stop();
            this.hsX = true;
            bGY();
        }
    }

    private void bGY() {
        if (this.hsQ != null) {
            File file = new File(this.hrg);
            if (file.exists() && file.length() > 0) {
                this.hsQ.vT(this.hrg);
            } else {
                this.hsQ.aq(223, "Err empty outputFile");
            }
        }
        this.Ep = false;
    }

    public boolean isRunning() {
        return this.Ep;
    }

    public void a(a aVar) {
        this.hsQ = aVar;
    }
}
