package com.baidu.tieba.video.editvideo.b;

import android.annotation.TargetApi;
import android.content.Context;
import java.io.File;
@TargetApi(18)
/* loaded from: classes17.dex */
public class b {
    private Context mContext;
    private String mFilterName;
    private boolean mIsRunning = false;
    private String mcf;
    private a mdS;
    private String mdT;
    private f mdU;
    private d mdV;
    private e mdW;
    private volatile boolean mdX;
    private volatile boolean mdY;
    private volatile boolean mdZ;

    /* loaded from: classes17.dex */
    public interface a {
        void OJ(String str);

        void bH(int i, String str);

        void bI(int i, String str);
    }

    public b(Context context, String str, String str2, String str3) {
        this.mContext = context;
        this.mdT = str;
        this.mcf = str2;
        this.mFilterName = str3;
    }

    public void dqf() {
        if (!this.mIsRunning) {
            this.mIsRunning = true;
            this.mdX = false;
            this.mdY = false;
            this.mdZ = false;
            try {
                File file = new File(new File(this.mcf).getParent());
                if (!file.exists()) {
                    file.mkdirs();
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (this.mdS != null) {
                    this.mdS.bH(222, com.baidu.tieba.k.a.s(e));
                }
            }
            try {
                this.mdW = new e(this.mcf);
                this.mdU = new f(this.mContext, this.mdT, this.mFilterName, this.mdW, this.mdS) { // from class: com.baidu.tieba.video.editvideo.b.b.1
                    @Override // com.baidu.tieba.video.editvideo.b.f
                    public void onPostExecute() {
                        b.this.mdX = true;
                        b.this.dqh();
                    }
                };
                this.mdU.start();
                this.mdV = new d(this.mContext, this.mdT, this.mdW, this.mdS) { // from class: com.baidu.tieba.video.editvideo.b.b.2
                    @Override // com.baidu.tieba.video.editvideo.b.d
                    public void onPostExecute() {
                        b.this.mdY = true;
                        b.this.dqh();
                    }
                };
                this.mdV.start();
            } catch (Exception e2) {
            }
        }
    }

    public void dqg() {
        if (this.mdU != null) {
            this.mdU.interrupt();
            this.mdU = null;
        }
        if (this.mdV != null) {
            this.mdV.interrupt();
            this.mdV = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dqh() {
        if (this.mdX && this.mdY && !this.mdZ) {
            this.mdW.stop();
            this.mdZ = true;
            dqi();
        }
    }

    private void dqi() {
        if (this.mdS != null) {
            File file = new File(this.mcf);
            if (file.exists() && file.length() > 0) {
                this.mdS.OJ(this.mcf);
            } else {
                this.mdS.bH(223, "Err empty outputFile");
            }
        }
        this.mIsRunning = false;
    }

    public boolean isRunning() {
        return this.mIsRunning;
    }

    public void a(a aVar) {
        this.mdS = aVar;
    }
}
