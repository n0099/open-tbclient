package com.baidu.tieba.video.editvideo.b;

import android.annotation.TargetApi;
import android.content.Context;
import java.io.File;
@TargetApi(18)
/* loaded from: classes2.dex */
public class b {
    private String hmV;
    private a hoF;
    private String hoG;
    private f hoH;
    private d hoI;
    private e hoJ;
    private volatile boolean hoK;
    private volatile boolean hoL;
    private volatile boolean hoM;
    private Context mContext;
    private String mFilterName;
    private boolean sx = false;

    /* loaded from: classes2.dex */
    public interface a {
        void al(int i, String str);

        void am(int i, String str);

        void tC(String str);
    }

    public b(Context context, String str, String str2, String str3) {
        this.mContext = context;
        this.hoG = str;
        this.hmV = str2;
        this.mFilterName = str3;
    }

    public void bAH() {
        if (!this.sx) {
            this.sx = true;
            this.hoK = false;
            this.hoL = false;
            this.hoM = false;
            try {
                File file = new File(new File(this.hmV).getParent());
                if (!file.exists()) {
                    file.mkdirs();
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (this.hoF != null) {
                    this.hoF.al(222, com.baidu.tieba.i.a.i(e));
                }
            }
            try {
                this.hoJ = new e(this.hmV);
                this.hoH = new f(this.mContext, this.hoG, this.mFilterName, this.hoJ, this.hoF) { // from class: com.baidu.tieba.video.editvideo.b.b.1
                    @Override // com.baidu.tieba.video.editvideo.b.f
                    public void bAL() {
                        b.this.hoK = true;
                        b.this.bAJ();
                    }
                };
                this.hoH.start();
                this.hoI = new d(this.mContext, this.hoG, this.hoJ, this.hoF) { // from class: com.baidu.tieba.video.editvideo.b.b.2
                    @Override // com.baidu.tieba.video.editvideo.b.d
                    public void bAL() {
                        b.this.hoL = true;
                        b.this.bAJ();
                    }
                };
                this.hoI.start();
            } catch (Exception e2) {
            }
        }
    }

    public void bAI() {
        if (this.hoH != null) {
            this.hoH.interrupt();
            this.hoH = null;
        }
        if (this.hoI != null) {
            this.hoI.interrupt();
            this.hoI = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bAJ() {
        if (this.hoK && this.hoL && !this.hoM) {
            this.hoJ.stop();
            this.hoM = true;
            bAK();
        }
    }

    private void bAK() {
        if (this.hoF != null) {
            File file = new File(this.hmV);
            if (file.exists() && file.length() > 0) {
                this.hoF.tC(this.hmV);
            } else {
                this.hoF.al(223, "Err empty outputFile");
            }
        }
        this.sx = false;
    }

    public boolean isRunning() {
        return this.sx;
    }

    public void a(a aVar) {
        this.hoF = aVar;
    }
}
