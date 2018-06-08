package com.baidu.tieba.video.editvideo.b;

import android.annotation.TargetApi;
import android.content.Context;
import java.io.File;
@TargetApi(18)
/* loaded from: classes2.dex */
public class b {
    private boolean Bo = false;
    private String gWF;
    private a gYr;
    private String gYs;
    private f gYt;
    private d gYu;
    private e gYv;
    private volatile boolean gYw;
    private volatile boolean gYx;
    private volatile boolean gYy;
    private Context mContext;
    private String mFilterName;

    /* loaded from: classes2.dex */
    public interface a {
        void ap(int i, String str);

        void aq(int i, String str);

        void uK(String str);
    }

    public b(Context context, String str, String str2, String str3) {
        this.mContext = context;
        this.gYs = str;
        this.gWF = str2;
        this.mFilterName = str3;
    }

    public void bBF() {
        if (!this.Bo) {
            this.Bo = true;
            this.gYw = false;
            this.gYx = false;
            this.gYy = false;
            try {
                File file = new File(new File(this.gWF).getParent());
                if (!file.exists()) {
                    file.mkdirs();
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (this.gYr != null) {
                    this.gYr.ap(222, com.baidu.tieba.j.a.m(e));
                }
            }
            try {
                this.gYv = new e(this.gWF);
                this.gYt = new f(this.mContext, this.gYs, this.mFilterName, this.gYv, this.gYr) { // from class: com.baidu.tieba.video.editvideo.b.b.1
                    @Override // com.baidu.tieba.video.editvideo.b.f
                    public void onPostExecute() {
                        b.this.gYw = true;
                        b.this.bBH();
                    }
                };
                this.gYt.start();
                this.gYu = new d(this.mContext, this.gYs, this.gYv, this.gYr) { // from class: com.baidu.tieba.video.editvideo.b.b.2
                    @Override // com.baidu.tieba.video.editvideo.b.d
                    public void onPostExecute() {
                        b.this.gYx = true;
                        b.this.bBH();
                    }
                };
                this.gYu.start();
            } catch (Exception e2) {
            }
        }
    }

    public void bBG() {
        if (this.gYt != null) {
            this.gYt.interrupt();
            this.gYt = null;
        }
        if (this.gYu != null) {
            this.gYu.interrupt();
            this.gYu = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBH() {
        if (this.gYw && this.gYx && !this.gYy) {
            this.gYv.stop();
            this.gYy = true;
            bBI();
        }
    }

    private void bBI() {
        if (this.gYr != null) {
            File file = new File(this.gWF);
            if (file.exists() && file.length() > 0) {
                this.gYr.uK(this.gWF);
            } else {
                this.gYr.ap(223, "Err empty outputFile");
            }
        }
        this.Bo = false;
    }

    public boolean isRunning() {
        return this.Bo;
    }

    public void a(a aVar) {
        this.gYr = aVar;
    }
}
