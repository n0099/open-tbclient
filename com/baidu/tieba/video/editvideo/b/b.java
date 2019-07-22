package com.baidu.tieba.video.editvideo.b;

import android.annotation.TargetApi;
import android.content.Context;
import java.io.File;
@TargetApi(18)
/* loaded from: classes5.dex */
public class b {
    private boolean Cg = false;
    private String jtT;
    private a jvE;
    private String jvF;
    private f jvG;
    private d jvH;
    private e jvI;
    private volatile boolean jvJ;
    private volatile boolean jvK;
    private volatile boolean jvL;
    private Context mContext;
    private String mFilterName;

    /* loaded from: classes5.dex */
    public interface a {
        void FG(String str);

        void aK(int i, String str);

        void aL(int i, String str);
    }

    public b(Context context, String str, String str2, String str3) {
        this.mContext = context;
        this.jvF = str;
        this.jtT = str2;
        this.mFilterName = str3;
    }

    public void cum() {
        if (!this.Cg) {
            this.Cg = true;
            this.jvJ = false;
            this.jvK = false;
            this.jvL = false;
            try {
                File file = new File(new File(this.jtT).getParent());
                if (!file.exists()) {
                    file.mkdirs();
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (this.jvE != null) {
                    this.jvE.aK(222, com.baidu.tieba.j.a.p(e));
                }
            }
            try {
                this.jvI = new e(this.jtT);
                this.jvG = new f(this.mContext, this.jvF, this.mFilterName, this.jvI, this.jvE) { // from class: com.baidu.tieba.video.editvideo.b.b.1
                    @Override // com.baidu.tieba.video.editvideo.b.f
                    public void onPostExecute() {
                        b.this.jvJ = true;
                        b.this.cuo();
                    }
                };
                this.jvG.start();
                this.jvH = new d(this.mContext, this.jvF, this.jvI, this.jvE) { // from class: com.baidu.tieba.video.editvideo.b.b.2
                    @Override // com.baidu.tieba.video.editvideo.b.d
                    public void onPostExecute() {
                        b.this.jvK = true;
                        b.this.cuo();
                    }
                };
                this.jvH.start();
            } catch (Exception e2) {
            }
        }
    }

    public void cun() {
        if (this.jvG != null) {
            this.jvG.interrupt();
            this.jvG = null;
        }
        if (this.jvH != null) {
            this.jvH.interrupt();
            this.jvH = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cuo() {
        if (this.jvJ && this.jvK && !this.jvL) {
            this.jvI.stop();
            this.jvL = true;
            cup();
        }
    }

    private void cup() {
        if (this.jvE != null) {
            File file = new File(this.jtT);
            if (file.exists() && file.length() > 0) {
                this.jvE.FG(this.jtT);
            } else {
                this.jvE.aK(223, "Err empty outputFile");
            }
        }
        this.Cg = false;
    }

    public boolean isRunning() {
        return this.Cg;
    }

    public void a(a aVar) {
        this.jvE = aVar;
    }
}
