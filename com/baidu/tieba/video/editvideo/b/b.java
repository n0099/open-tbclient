package com.baidu.tieba.video.editvideo.b;

import android.annotation.TargetApi;
import android.content.Context;
import java.io.File;
@TargetApi(18)
/* loaded from: classes5.dex */
public class b {
    private boolean Ep = false;
    private String hrh;
    private a hsR;
    private String hsS;
    private f hsT;
    private d hsU;
    private e hsV;
    private volatile boolean hsW;
    private volatile boolean hsX;
    private volatile boolean hsY;
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
        this.hsS = str;
        this.hrh = str2;
        this.mFilterName = str3;
    }

    public void bGV() {
        if (!this.Ep) {
            this.Ep = true;
            this.hsW = false;
            this.hsX = false;
            this.hsY = false;
            try {
                File file = new File(new File(this.hrh).getParent());
                if (!file.exists()) {
                    file.mkdirs();
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (this.hsR != null) {
                    this.hsR.aq(222, com.baidu.tieba.j.a.o(e));
                }
            }
            try {
                this.hsV = new e(this.hrh);
                this.hsT = new f(this.mContext, this.hsS, this.mFilterName, this.hsV, this.hsR) { // from class: com.baidu.tieba.video.editvideo.b.b.1
                    @Override // com.baidu.tieba.video.editvideo.b.f
                    public void onPostExecute() {
                        b.this.hsW = true;
                        b.this.bGX();
                    }
                };
                this.hsT.start();
                this.hsU = new d(this.mContext, this.hsS, this.hsV, this.hsR) { // from class: com.baidu.tieba.video.editvideo.b.b.2
                    @Override // com.baidu.tieba.video.editvideo.b.d
                    public void onPostExecute() {
                        b.this.hsX = true;
                        b.this.bGX();
                    }
                };
                this.hsU.start();
            } catch (Exception e2) {
            }
        }
    }

    public void bGW() {
        if (this.hsT != null) {
            this.hsT.interrupt();
            this.hsT = null;
        }
        if (this.hsU != null) {
            this.hsU.interrupt();
            this.hsU = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGX() {
        if (this.hsW && this.hsX && !this.hsY) {
            this.hsV.stop();
            this.hsY = true;
            bGY();
        }
    }

    private void bGY() {
        if (this.hsR != null) {
            File file = new File(this.hrh);
            if (file.exists() && file.length() > 0) {
                this.hsR.vT(this.hrh);
            } else {
                this.hsR.aq(223, "Err empty outputFile");
            }
        }
        this.Ep = false;
    }

    public boolean isRunning() {
        return this.Ep;
    }

    public void a(a aVar) {
        this.hsR = aVar;
    }
}
