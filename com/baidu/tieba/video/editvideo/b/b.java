package com.baidu.tieba.video.editvideo.b;

import android.annotation.TargetApi;
import android.content.Context;
import java.io.File;
@TargetApi(18)
/* loaded from: classes2.dex */
public class b {
    private boolean Bq = false;
    private String haK;
    private e hcA;
    private volatile boolean hcB;
    private volatile boolean hcC;
    private volatile boolean hcD;
    private a hcw;
    private String hcx;
    private f hcy;
    private d hcz;
    private Context mContext;
    private String mFilterName;

    /* loaded from: classes2.dex */
    public interface a {
        void am(int i, String str);

        void an(int i, String str);

        void uG(String str);
    }

    public b(Context context, String str, String str2, String str3) {
        this.mContext = context;
        this.hcx = str;
        this.haK = str2;
        this.mFilterName = str3;
    }

    public void bCf() {
        if (!this.Bq) {
            this.Bq = true;
            this.hcB = false;
            this.hcC = false;
            this.hcD = false;
            try {
                File file = new File(new File(this.haK).getParent());
                if (!file.exists()) {
                    file.mkdirs();
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (this.hcw != null) {
                    this.hcw.am(222, com.baidu.tieba.j.a.m(e));
                }
            }
            try {
                this.hcA = new e(this.haK);
                this.hcy = new f(this.mContext, this.hcx, this.mFilterName, this.hcA, this.hcw) { // from class: com.baidu.tieba.video.editvideo.b.b.1
                    @Override // com.baidu.tieba.video.editvideo.b.f
                    public void onPostExecute() {
                        b.this.hcB = true;
                        b.this.bCh();
                    }
                };
                this.hcy.start();
                this.hcz = new d(this.mContext, this.hcx, this.hcA, this.hcw) { // from class: com.baidu.tieba.video.editvideo.b.b.2
                    @Override // com.baidu.tieba.video.editvideo.b.d
                    public void onPostExecute() {
                        b.this.hcC = true;
                        b.this.bCh();
                    }
                };
                this.hcz.start();
            } catch (Exception e2) {
            }
        }
    }

    public void bCg() {
        if (this.hcy != null) {
            this.hcy.interrupt();
            this.hcy = null;
        }
        if (this.hcz != null) {
            this.hcz.interrupt();
            this.hcz = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bCh() {
        if (this.hcB && this.hcC && !this.hcD) {
            this.hcA.stop();
            this.hcD = true;
            bCi();
        }
    }

    private void bCi() {
        if (this.hcw != null) {
            File file = new File(this.haK);
            if (file.exists() && file.length() > 0) {
                this.hcw.uG(this.haK);
            } else {
                this.hcw.am(223, "Err empty outputFile");
            }
        }
        this.Bq = false;
    }

    public boolean isRunning() {
        return this.Bq;
    }

    public void a(a aVar) {
        this.hcw = aVar;
    }
}
