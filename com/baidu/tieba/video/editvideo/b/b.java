package com.baidu.tieba.video.editvideo.b;

import android.annotation.TargetApi;
import android.content.Context;
import java.io.File;
@TargetApi(18)
/* loaded from: classes2.dex */
public class b {
    private String gPW;
    private a gRG;
    private String gRH;
    private f gRI;
    private d gRJ;
    private e gRK;
    private volatile boolean gRL;
    private volatile boolean gRM;
    private volatile boolean gRN;
    private Context mContext;
    private String mFilterName;
    private boolean wz = false;

    /* loaded from: classes2.dex */
    public interface a {
        void aj(int i, String str);

        void ak(int i, String str);

        void tY(String str);
    }

    public b(Context context, String str, String str2, String str3) {
        this.mContext = context;
        this.gRH = str;
        this.gPW = str2;
        this.mFilterName = str3;
    }

    public void bBL() {
        if (!this.wz) {
            this.wz = true;
            this.gRL = false;
            this.gRM = false;
            this.gRN = false;
            try {
                File file = new File(new File(this.gPW).getParent());
                if (!file.exists()) {
                    file.mkdirs();
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (this.gRG != null) {
                    this.gRG.aj(222, com.baidu.tieba.i.a.g(e));
                }
            }
            try {
                this.gRK = new e(this.gPW);
                this.gRI = new f(this.mContext, this.gRH, this.mFilterName, this.gRK, this.gRG) { // from class: com.baidu.tieba.video.editvideo.b.b.1
                    @Override // com.baidu.tieba.video.editvideo.b.f
                    public void bBP() {
                        b.this.gRL = true;
                        b.this.bBN();
                    }
                };
                this.gRI.start();
                this.gRJ = new d(this.mContext, this.gRH, this.gRK, this.gRG) { // from class: com.baidu.tieba.video.editvideo.b.b.2
                    @Override // com.baidu.tieba.video.editvideo.b.d
                    public void bBP() {
                        b.this.gRM = true;
                        b.this.bBN();
                    }
                };
                this.gRJ.start();
            } catch (Exception e2) {
            }
        }
    }

    public void bBM() {
        if (this.gRI != null) {
            this.gRI.interrupt();
            this.gRI = null;
        }
        if (this.gRJ != null) {
            this.gRJ.interrupt();
            this.gRJ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBN() {
        if (this.gRL && this.gRM && !this.gRN) {
            this.gRK.stop();
            this.gRN = true;
            bBO();
        }
    }

    private void bBO() {
        if (this.gRG != null) {
            File file = new File(this.gPW);
            if (file.exists() && file.length() > 0) {
                this.gRG.tY(this.gPW);
            } else {
                this.gRG.aj(223, "Err empty outputFile");
            }
        }
        this.wz = false;
    }

    public boolean isRunning() {
        return this.wz;
    }

    public void a(a aVar) {
        this.gRG = aVar;
    }
}
