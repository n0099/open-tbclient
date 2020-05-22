package com.baidu.tieba.video.editvideo.b;

import android.annotation.TargetApi;
import android.content.Context;
import java.io.File;
@TargetApi(18)
/* loaded from: classes10.dex */
public class b {
    private a lBF;
    private String lBG;
    private f lBH;
    private d lBI;
    private e lBJ;
    private volatile boolean lBK;
    private volatile boolean lBL;
    private volatile boolean lBM;
    private String lzV;
    private Context mContext;
    private String mFilterName;
    private boolean mIsRunning = false;

    /* loaded from: classes10.dex */
    public interface a {
        void Nv(String str);

        void bA(int i, String str);

        void bz(int i, String str);

        void dim();
    }

    public b(Context context, String str, String str2, String str3) {
        this.mContext = context;
        this.lBG = str;
        this.lzV = str2;
        this.mFilterName = str3;
    }

    public void dis() {
        if (!this.mIsRunning) {
            this.mIsRunning = true;
            this.lBK = false;
            this.lBL = false;
            this.lBM = false;
            try {
                File file = new File(new File(this.lzV).getParent());
                if (!file.exists()) {
                    file.mkdirs();
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (this.lBF != null) {
                    this.lBF.bz(222, com.baidu.tieba.k.a.t(e));
                }
            }
            try {
                this.lBJ = new e(this.lzV);
                this.lBH = new f(this.mContext, this.lBG, this.mFilterName, this.lBJ, this.lBF) { // from class: com.baidu.tieba.video.editvideo.b.b.1
                    @Override // com.baidu.tieba.video.editvideo.b.f
                    public void onPostExecute() {
                        b.this.lBK = true;
                        b.this.diu();
                    }
                };
                this.lBH.start();
                this.lBI = new d(this.mContext, this.lBG, this.lBJ, this.lBF) { // from class: com.baidu.tieba.video.editvideo.b.b.2
                    @Override // com.baidu.tieba.video.editvideo.b.d
                    public void onPostExecute() {
                        b.this.lBL = true;
                        b.this.diu();
                    }
                };
                this.lBI.start();
            } catch (Exception e2) {
            }
        }
    }

    public void dit() {
        if (this.lBH != null) {
            this.lBH.interrupt();
            this.lBH = null;
        }
        if (this.lBI != null) {
            this.lBI.interrupt();
            this.lBI = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void diu() {
        if (this.lBK && this.lBL && !this.lBM) {
            this.lBJ.stop();
            this.lBM = true;
            div();
        }
    }

    private void div() {
        if (this.lBF != null) {
            File file = new File(this.lzV);
            if (file.exists() && file.length() > 0) {
                this.lBF.Nv(this.lzV);
            } else {
                this.lBF.bz(223, "Err empty outputFile");
            }
        }
        this.mIsRunning = false;
    }

    public boolean isRunning() {
        return this.mIsRunning;
    }

    public void a(a aVar) {
        this.lBF = aVar;
    }
}
