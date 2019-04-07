package com.baidu.tieba.video.editvideo.b;

import android.annotation.TargetApi;
import android.content.Context;
import java.io.File;
@TargetApi(18)
/* loaded from: classes5.dex */
public class b {
    private boolean Es = false;
    private String iUJ;
    private volatile boolean iWA;
    private volatile boolean iWB;
    private a iWu;
    private String iWv;
    private f iWw;
    private d iWx;
    private e iWy;
    private volatile boolean iWz;
    private Context mContext;
    private String mFilterName;

    /* loaded from: classes5.dex */
    public interface a {
        void Du(String str);

        void aH(int i, String str);

        void aI(int i, String str);
    }

    public b(Context context, String str, String str2, String str3) {
        this.mContext = context;
        this.iWv = str;
        this.iUJ = str2;
        this.mFilterName = str3;
    }

    public void cjv() {
        if (!this.Es) {
            this.Es = true;
            this.iWz = false;
            this.iWA = false;
            this.iWB = false;
            try {
                File file = new File(new File(this.iUJ).getParent());
                if (!file.exists()) {
                    file.mkdirs();
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (this.iWu != null) {
                    this.iWu.aH(222, com.baidu.tieba.j.a.p(e));
                }
            }
            try {
                this.iWy = new e(this.iUJ);
                this.iWw = new f(this.mContext, this.iWv, this.mFilterName, this.iWy, this.iWu) { // from class: com.baidu.tieba.video.editvideo.b.b.1
                    @Override // com.baidu.tieba.video.editvideo.b.f
                    public void onPostExecute() {
                        b.this.iWz = true;
                        b.this.cjx();
                    }
                };
                this.iWw.start();
                this.iWx = new d(this.mContext, this.iWv, this.iWy, this.iWu) { // from class: com.baidu.tieba.video.editvideo.b.b.2
                    @Override // com.baidu.tieba.video.editvideo.b.d
                    public void onPostExecute() {
                        b.this.iWA = true;
                        b.this.cjx();
                    }
                };
                this.iWx.start();
            } catch (Exception e2) {
            }
        }
    }

    public void cjw() {
        if (this.iWw != null) {
            this.iWw.interrupt();
            this.iWw = null;
        }
        if (this.iWx != null) {
            this.iWx.interrupt();
            this.iWx = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cjx() {
        if (this.iWz && this.iWA && !this.iWB) {
            this.iWy.stop();
            this.iWB = true;
            cjy();
        }
    }

    private void cjy() {
        if (this.iWu != null) {
            File file = new File(this.iUJ);
            if (file.exists() && file.length() > 0) {
                this.iWu.Du(this.iUJ);
            } else {
                this.iWu.aH(223, "Err empty outputFile");
            }
        }
        this.Es = false;
    }

    public boolean isRunning() {
        return this.Es;
    }

    public void a(a aVar) {
        this.iWu = aVar;
    }
}
