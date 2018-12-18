package com.baidu.tieba.video.editvideo.b;

import android.annotation.TargetApi;
import android.content.Context;
import java.io.File;
@TargetApi(18)
/* loaded from: classes5.dex */
public class b {
    private boolean Et = false;
    private String hAc;
    private a hBM;
    private String hBN;
    private f hBO;
    private d hBP;
    private e hBQ;
    private volatile boolean hBR;
    private volatile boolean hBS;
    private volatile boolean hBT;
    private Context mContext;
    private String mFilterName;

    /* loaded from: classes5.dex */
    public interface a {
        void am(int i, String str);

        void an(int i, String str);

        void wB(String str);
    }

    public b(Context context, String str, String str2, String str3) {
        this.mContext = context;
        this.hBN = str;
        this.hAc = str2;
        this.mFilterName = str3;
    }

    public void bIy() {
        if (!this.Et) {
            this.Et = true;
            this.hBR = false;
            this.hBS = false;
            this.hBT = false;
            try {
                File file = new File(new File(this.hAc).getParent());
                if (!file.exists()) {
                    file.mkdirs();
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (this.hBM != null) {
                    this.hBM.am(222, com.baidu.tieba.j.a.o(e));
                }
            }
            try {
                this.hBQ = new e(this.hAc);
                this.hBO = new f(this.mContext, this.hBN, this.mFilterName, this.hBQ, this.hBM) { // from class: com.baidu.tieba.video.editvideo.b.b.1
                    @Override // com.baidu.tieba.video.editvideo.b.f
                    public void onPostExecute() {
                        b.this.hBR = true;
                        b.this.bIA();
                    }
                };
                this.hBO.start();
                this.hBP = new d(this.mContext, this.hBN, this.hBQ, this.hBM) { // from class: com.baidu.tieba.video.editvideo.b.b.2
                    @Override // com.baidu.tieba.video.editvideo.b.d
                    public void onPostExecute() {
                        b.this.hBS = true;
                        b.this.bIA();
                    }
                };
                this.hBP.start();
            } catch (Exception e2) {
            }
        }
    }

    public void bIz() {
        if (this.hBO != null) {
            this.hBO.interrupt();
            this.hBO = null;
        }
        if (this.hBP != null) {
            this.hBP.interrupt();
            this.hBP = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIA() {
        if (this.hBR && this.hBS && !this.hBT) {
            this.hBQ.stop();
            this.hBT = true;
            bIB();
        }
    }

    private void bIB() {
        if (this.hBM != null) {
            File file = new File(this.hAc);
            if (file.exists() && file.length() > 0) {
                this.hBM.wB(this.hAc);
            } else {
                this.hBM.am(223, "Err empty outputFile");
            }
        }
        this.Et = false;
    }

    public boolean isRunning() {
        return this.Et;
    }

    public void a(a aVar) {
        this.hBM = aVar;
    }
}
