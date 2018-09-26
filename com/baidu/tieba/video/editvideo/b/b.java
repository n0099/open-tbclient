package com.baidu.tieba.video.editvideo.b;

import android.annotation.TargetApi;
import android.content.Context;
import java.io.File;
@TargetApi(18)
/* loaded from: classes2.dex */
public class b {
    private boolean DG = false;
    private String hjQ;
    private a hlB;
    private String hlC;
    private f hlD;
    private d hlE;
    private e hlF;
    private volatile boolean hlG;
    private volatile boolean hlH;
    private volatile boolean hlI;
    private Context mContext;
    private String mFilterName;

    /* loaded from: classes2.dex */
    public interface a {
        void aq(int i, String str);

        void ar(int i, String str);

        void vr(String str);
    }

    public b(Context context, String str, String str2, String str3) {
        this.mContext = context;
        this.hlC = str;
        this.hjQ = str2;
        this.mFilterName = str3;
    }

    public void bDH() {
        if (!this.DG) {
            this.DG = true;
            this.hlG = false;
            this.hlH = false;
            this.hlI = false;
            try {
                File file = new File(new File(this.hjQ).getParent());
                if (!file.exists()) {
                    file.mkdirs();
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (this.hlB != null) {
                    this.hlB.aq(222, com.baidu.tieba.j.a.m(e));
                }
            }
            try {
                this.hlF = new e(this.hjQ);
                this.hlD = new f(this.mContext, this.hlC, this.mFilterName, this.hlF, this.hlB) { // from class: com.baidu.tieba.video.editvideo.b.b.1
                    @Override // com.baidu.tieba.video.editvideo.b.f
                    public void onPostExecute() {
                        b.this.hlG = true;
                        b.this.bDJ();
                    }
                };
                this.hlD.start();
                this.hlE = new d(this.mContext, this.hlC, this.hlF, this.hlB) { // from class: com.baidu.tieba.video.editvideo.b.b.2
                    @Override // com.baidu.tieba.video.editvideo.b.d
                    public void onPostExecute() {
                        b.this.hlH = true;
                        b.this.bDJ();
                    }
                };
                this.hlE.start();
            } catch (Exception e2) {
            }
        }
    }

    public void bDI() {
        if (this.hlD != null) {
            this.hlD.interrupt();
            this.hlD = null;
        }
        if (this.hlE != null) {
            this.hlE.interrupt();
            this.hlE = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bDJ() {
        if (this.hlG && this.hlH && !this.hlI) {
            this.hlF.stop();
            this.hlI = true;
            bDK();
        }
    }

    private void bDK() {
        if (this.hlB != null) {
            File file = new File(this.hjQ);
            if (file.exists() && file.length() > 0) {
                this.hlB.vr(this.hjQ);
            } else {
                this.hlB.aq(223, "Err empty outputFile");
            }
        }
        this.DG = false;
    }

    public boolean isRunning() {
        return this.DG;
    }

    public void a(a aVar) {
        this.hlB = aVar;
    }
}
