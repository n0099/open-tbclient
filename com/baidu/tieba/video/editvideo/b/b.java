package com.baidu.tieba.video.editvideo.b;

import android.annotation.TargetApi;
import android.content.Context;
import java.io.File;
@TargetApi(18)
/* loaded from: classes2.dex */
public class b {
    private String gPR;
    private a gRB;
    private String gRC;
    private f gRD;
    private d gRE;
    private e gRF;
    private volatile boolean gRG;
    private volatile boolean gRH;
    private volatile boolean gRI;
    private Context mContext;
    private String mFilterName;
    private boolean wy = false;

    /* loaded from: classes2.dex */
    public interface a {
        void aj(int i, String str);

        void ak(int i, String str);

        void tY(String str);
    }

    public b(Context context, String str, String str2, String str3) {
        this.mContext = context;
        this.gRC = str;
        this.gPR = str2;
        this.mFilterName = str3;
    }

    public void bBK() {
        if (!this.wy) {
            this.wy = true;
            this.gRG = false;
            this.gRH = false;
            this.gRI = false;
            try {
                File file = new File(new File(this.gPR).getParent());
                if (!file.exists()) {
                    file.mkdirs();
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (this.gRB != null) {
                    this.gRB.aj(222, com.baidu.tieba.i.a.g(e));
                }
            }
            try {
                this.gRF = new e(this.gPR);
                this.gRD = new f(this.mContext, this.gRC, this.mFilterName, this.gRF, this.gRB) { // from class: com.baidu.tieba.video.editvideo.b.b.1
                    @Override // com.baidu.tieba.video.editvideo.b.f
                    public void bBO() {
                        b.this.gRG = true;
                        b.this.bBM();
                    }
                };
                this.gRD.start();
                this.gRE = new d(this.mContext, this.gRC, this.gRF, this.gRB) { // from class: com.baidu.tieba.video.editvideo.b.b.2
                    @Override // com.baidu.tieba.video.editvideo.b.d
                    public void bBO() {
                        b.this.gRH = true;
                        b.this.bBM();
                    }
                };
                this.gRE.start();
            } catch (Exception e2) {
            }
        }
    }

    public void bBL() {
        if (this.gRD != null) {
            this.gRD.interrupt();
            this.gRD = null;
        }
        if (this.gRE != null) {
            this.gRE.interrupt();
            this.gRE = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBM() {
        if (this.gRG && this.gRH && !this.gRI) {
            this.gRF.stop();
            this.gRI = true;
            bBN();
        }
    }

    private void bBN() {
        if (this.gRB != null) {
            File file = new File(this.gPR);
            if (file.exists() && file.length() > 0) {
                this.gRB.tY(this.gPR);
            } else {
                this.gRB.aj(223, "Err empty outputFile");
            }
        }
        this.wy = false;
    }

    public boolean isRunning() {
        return this.wy;
    }

    public void a(a aVar) {
        this.gRB = aVar;
    }
}
