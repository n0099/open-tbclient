package com.baidu.tieba.video.editvideo.b;

import android.annotation.TargetApi;
import android.content.Context;
import java.io.File;
@TargetApi(18)
/* loaded from: classes5.dex */
public class b {
    private boolean Et = false;
    private String hEv;
    private a hGf;
    private String hGg;
    private f hGh;
    private d hGi;
    private e hGj;
    private volatile boolean hGk;
    private volatile boolean hGl;
    private volatile boolean hGm;
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
        this.hGg = str;
        this.hEv = str2;
        this.mFilterName = str3;
    }

    public void bJX() {
        if (!this.Et) {
            this.Et = true;
            this.hGk = false;
            this.hGl = false;
            this.hGm = false;
            try {
                File file = new File(new File(this.hEv).getParent());
                if (!file.exists()) {
                    file.mkdirs();
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (this.hGf != null) {
                    this.hGf.ap(222, com.baidu.tieba.j.a.o(e));
                }
            }
            try {
                this.hGj = new e(this.hEv);
                this.hGh = new f(this.mContext, this.hGg, this.mFilterName, this.hGj, this.hGf) { // from class: com.baidu.tieba.video.editvideo.b.b.1
                    @Override // com.baidu.tieba.video.editvideo.b.f
                    public void onPostExecute() {
                        b.this.hGk = true;
                        b.this.bJZ();
                    }
                };
                this.hGh.start();
                this.hGi = new d(this.mContext, this.hGg, this.hGj, this.hGf) { // from class: com.baidu.tieba.video.editvideo.b.b.2
                    @Override // com.baidu.tieba.video.editvideo.b.d
                    public void onPostExecute() {
                        b.this.hGl = true;
                        b.this.bJZ();
                    }
                };
                this.hGi.start();
            } catch (Exception e2) {
            }
        }
    }

    public void bJY() {
        if (this.hGh != null) {
            this.hGh.interrupt();
            this.hGh = null;
        }
        if (this.hGi != null) {
            this.hGi.interrupt();
            this.hGi = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJZ() {
        if (this.hGk && this.hGl && !this.hGm) {
            this.hGj.stop();
            this.hGm = true;
            bKa();
        }
    }

    private void bKa() {
        if (this.hGf != null) {
            File file = new File(this.hEv);
            if (file.exists() && file.length() > 0) {
                this.hGf.wU(this.hEv);
            } else {
                this.hGf.ap(223, "Err empty outputFile");
            }
        }
        this.Et = false;
    }

    public boolean isRunning() {
        return this.Et;
    }

    public void a(a aVar) {
        this.hGf = aVar;
    }
}
