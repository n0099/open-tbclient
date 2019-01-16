package com.baidu.tieba.video.editvideo.b;

import android.annotation.TargetApi;
import android.content.Context;
import java.io.File;
@TargetApi(18)
/* loaded from: classes5.dex */
public class b {
    private boolean Et = false;
    private String hEu;
    private a hGe;
    private String hGf;
    private f hGg;
    private d hGh;
    private e hGi;
    private volatile boolean hGj;
    private volatile boolean hGk;
    private volatile boolean hGl;
    private Context mContext;
    private String mFilterName;

    /* loaded from: classes5.dex */
    public interface a {
        void ap(int i, String str);

        void aq(int i, String str);

        void wU(String str);
    }

    public b(Context context, String str, String str2, String str3) {
        this.mContext = context;
        this.hGf = str;
        this.hEu = str2;
        this.mFilterName = str3;
    }

    public void bJX() {
        if (!this.Et) {
            this.Et = true;
            this.hGj = false;
            this.hGk = false;
            this.hGl = false;
            try {
                File file = new File(new File(this.hEu).getParent());
                if (!file.exists()) {
                    file.mkdirs();
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (this.hGe != null) {
                    this.hGe.ap(222, com.baidu.tieba.j.a.o(e));
                }
            }
            try {
                this.hGi = new e(this.hEu);
                this.hGg = new f(this.mContext, this.hGf, this.mFilterName, this.hGi, this.hGe) { // from class: com.baidu.tieba.video.editvideo.b.b.1
                    @Override // com.baidu.tieba.video.editvideo.b.f
                    public void onPostExecute() {
                        b.this.hGj = true;
                        b.this.bJZ();
                    }
                };
                this.hGg.start();
                this.hGh = new d(this.mContext, this.hGf, this.hGi, this.hGe) { // from class: com.baidu.tieba.video.editvideo.b.b.2
                    @Override // com.baidu.tieba.video.editvideo.b.d
                    public void onPostExecute() {
                        b.this.hGk = true;
                        b.this.bJZ();
                    }
                };
                this.hGh.start();
            } catch (Exception e2) {
            }
        }
    }

    public void bJY() {
        if (this.hGg != null) {
            this.hGg.interrupt();
            this.hGg = null;
        }
        if (this.hGh != null) {
            this.hGh.interrupt();
            this.hGh = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJZ() {
        if (this.hGj && this.hGk && !this.hGl) {
            this.hGi.stop();
            this.hGl = true;
            bKa();
        }
    }

    private void bKa() {
        if (this.hGe != null) {
            File file = new File(this.hEu);
            if (file.exists() && file.length() > 0) {
                this.hGe.wU(this.hEu);
            } else {
                this.hGe.ap(223, "Err empty outputFile");
            }
        }
        this.Et = false;
    }

    public boolean isRunning() {
        return this.Et;
    }

    public void a(a aVar) {
        this.hGe = aVar;
    }
}
