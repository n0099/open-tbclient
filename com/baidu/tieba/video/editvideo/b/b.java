package com.baidu.tieba.video.editvideo.b;

import android.annotation.TargetApi;
import android.content.Context;
import java.io.File;
@TargetApi(18)
/* loaded from: classes5.dex */
public class b {
    private boolean Es = false;
    private String iUV;
    private a iWG;
    private String iWH;
    private f iWI;
    private d iWJ;
    private e iWK;
    private volatile boolean iWL;
    private volatile boolean iWM;
    private volatile boolean iWN;
    private Context mContext;
    private String mFilterName;

    /* loaded from: classes5.dex */
    public interface a {
        void Dv(String str);

        void aF(int i, String str);

        void aG(int i, String str);
    }

    public b(Context context, String str, String str2, String str3) {
        this.mContext = context;
        this.iWH = str;
        this.iUV = str2;
        this.mFilterName = str3;
    }

    public void cjx() {
        if (!this.Es) {
            this.Es = true;
            this.iWL = false;
            this.iWM = false;
            this.iWN = false;
            try {
                File file = new File(new File(this.iUV).getParent());
                if (!file.exists()) {
                    file.mkdirs();
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (this.iWG != null) {
                    this.iWG.aF(222, com.baidu.tieba.j.a.p(e));
                }
            }
            try {
                this.iWK = new e(this.iUV);
                this.iWI = new f(this.mContext, this.iWH, this.mFilterName, this.iWK, this.iWG) { // from class: com.baidu.tieba.video.editvideo.b.b.1
                    @Override // com.baidu.tieba.video.editvideo.b.f
                    public void onPostExecute() {
                        b.this.iWL = true;
                        b.this.cjz();
                    }
                };
                this.iWI.start();
                this.iWJ = new d(this.mContext, this.iWH, this.iWK, this.iWG) { // from class: com.baidu.tieba.video.editvideo.b.b.2
                    @Override // com.baidu.tieba.video.editvideo.b.d
                    public void onPostExecute() {
                        b.this.iWM = true;
                        b.this.cjz();
                    }
                };
                this.iWJ.start();
            } catch (Exception e2) {
            }
        }
    }

    public void cjy() {
        if (this.iWI != null) {
            this.iWI.interrupt();
            this.iWI = null;
        }
        if (this.iWJ != null) {
            this.iWJ.interrupt();
            this.iWJ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cjz() {
        if (this.iWL && this.iWM && !this.iWN) {
            this.iWK.stop();
            this.iWN = true;
            cjA();
        }
    }

    private void cjA() {
        if (this.iWG != null) {
            File file = new File(this.iUV);
            if (file.exists() && file.length() > 0) {
                this.iWG.Dv(this.iUV);
            } else {
                this.iWG.aF(223, "Err empty outputFile");
            }
        }
        this.Es = false;
    }

    public boolean isRunning() {
        return this.Es;
    }

    public void a(a aVar) {
        this.iWG = aVar;
    }
}
