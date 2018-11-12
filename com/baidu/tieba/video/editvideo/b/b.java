package com.baidu.tieba.video.editvideo.b;

import android.annotation.TargetApi;
import android.content.Context;
import java.io.File;
@TargetApi(18)
/* loaded from: classes5.dex */
public class b {
    private boolean Et = false;
    private String hsQ;
    private a huA;
    private String huB;
    private f huC;
    private d huD;
    private e huE;
    private volatile boolean huF;
    private volatile boolean huG;
    private volatile boolean huH;
    private Context mContext;
    private String mFilterName;

    /* loaded from: classes5.dex */
    public interface a {
        void am(int i, String str);

        void an(int i, String str);

        void vY(String str);
    }

    public b(Context context, String str, String str2, String str3) {
        this.mContext = context;
        this.huB = str;
        this.hsQ = str2;
        this.mFilterName = str3;
    }

    public void bGu() {
        if (!this.Et) {
            this.Et = true;
            this.huF = false;
            this.huG = false;
            this.huH = false;
            try {
                File file = new File(new File(this.hsQ).getParent());
                if (!file.exists()) {
                    file.mkdirs();
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (this.huA != null) {
                    this.huA.am(222, com.baidu.tieba.j.a.o(e));
                }
            }
            try {
                this.huE = new e(this.hsQ);
                this.huC = new f(this.mContext, this.huB, this.mFilterName, this.huE, this.huA) { // from class: com.baidu.tieba.video.editvideo.b.b.1
                    @Override // com.baidu.tieba.video.editvideo.b.f
                    public void onPostExecute() {
                        b.this.huF = true;
                        b.this.bGw();
                    }
                };
                this.huC.start();
                this.huD = new d(this.mContext, this.huB, this.huE, this.huA) { // from class: com.baidu.tieba.video.editvideo.b.b.2
                    @Override // com.baidu.tieba.video.editvideo.b.d
                    public void onPostExecute() {
                        b.this.huG = true;
                        b.this.bGw();
                    }
                };
                this.huD.start();
            } catch (Exception e2) {
            }
        }
    }

    public void bGv() {
        if (this.huC != null) {
            this.huC.interrupt();
            this.huC = null;
        }
        if (this.huD != null) {
            this.huD.interrupt();
            this.huD = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGw() {
        if (this.huF && this.huG && !this.huH) {
            this.huE.stop();
            this.huH = true;
            bGx();
        }
    }

    private void bGx() {
        if (this.huA != null) {
            File file = new File(this.hsQ);
            if (file.exists() && file.length() > 0) {
                this.huA.vY(this.hsQ);
            } else {
                this.huA.am(223, "Err empty outputFile");
            }
        }
        this.Et = false;
    }

    public boolean isRunning() {
        return this.Et;
    }

    public void a(a aVar) {
        this.huA = aVar;
    }
}
