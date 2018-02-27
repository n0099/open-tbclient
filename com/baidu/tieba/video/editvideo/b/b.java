package com.baidu.tieba.video.editvideo.b;

import android.annotation.TargetApi;
import android.content.Context;
import java.io.File;
@TargetApi(18)
/* loaded from: classes2.dex */
public class b {
    private String hnX;
    private a hpH;
    private String hpI;
    private f hpJ;
    private d hpK;
    private e hpL;
    private volatile boolean hpM;
    private volatile boolean hpN;
    private volatile boolean hpO;
    private Context mContext;
    private String mFilterName;
    private boolean sw = false;

    /* loaded from: classes2.dex */
    public interface a {
        void aj(int i, String str);

        void ak(int i, String str);

        void tG(String str);
    }

    public b(Context context, String str, String str2, String str3) {
        this.mContext = context;
        this.hpI = str;
        this.hnX = str2;
        this.mFilterName = str3;
    }

    public void bBq() {
        if (!this.sw) {
            this.sw = true;
            this.hpM = false;
            this.hpN = false;
            this.hpO = false;
            try {
                File file = new File(new File(this.hnX).getParent());
                if (!file.exists()) {
                    file.mkdirs();
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (this.hpH != null) {
                    this.hpH.aj(222, com.baidu.tieba.i.a.i(e));
                }
            }
            try {
                this.hpL = new e(this.hnX);
                this.hpJ = new f(this.mContext, this.hpI, this.mFilterName, this.hpL, this.hpH) { // from class: com.baidu.tieba.video.editvideo.b.b.1
                    @Override // com.baidu.tieba.video.editvideo.b.f
                    public void onPostExecute() {
                        b.this.hpM = true;
                        b.this.bBs();
                    }
                };
                this.hpJ.start();
                this.hpK = new d(this.mContext, this.hpI, this.hpL, this.hpH) { // from class: com.baidu.tieba.video.editvideo.b.b.2
                    @Override // com.baidu.tieba.video.editvideo.b.d
                    public void onPostExecute() {
                        b.this.hpN = true;
                        b.this.bBs();
                    }
                };
                this.hpK.start();
            } catch (Exception e2) {
            }
        }
    }

    public void bBr() {
        if (this.hpJ != null) {
            this.hpJ.interrupt();
            this.hpJ = null;
        }
        if (this.hpK != null) {
            this.hpK.interrupt();
            this.hpK = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBs() {
        if (this.hpM && this.hpN && !this.hpO) {
            this.hpL.stop();
            this.hpO = true;
            bBt();
        }
    }

    private void bBt() {
        if (this.hpH != null) {
            File file = new File(this.hnX);
            if (file.exists() && file.length() > 0) {
                this.hpH.tG(this.hnX);
            } else {
                this.hpH.aj(223, "Err empty outputFile");
            }
        }
        this.sw = false;
    }

    public boolean isRunning() {
        return this.sw;
    }

    public void a(a aVar) {
        this.hpH = aVar;
    }
}
