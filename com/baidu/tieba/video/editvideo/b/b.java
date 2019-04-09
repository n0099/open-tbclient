package com.baidu.tieba.video.editvideo.b;

import android.annotation.TargetApi;
import android.content.Context;
import java.io.File;
@TargetApi(18)
/* loaded from: classes5.dex */
public class b {
    private boolean Es = false;
    private String iUK;
    private volatile boolean iWA;
    private volatile boolean iWB;
    private volatile boolean iWC;
    private a iWv;
    private String iWw;
    private f iWx;
    private d iWy;
    private e iWz;
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
        this.iWw = str;
        this.iUK = str2;
        this.mFilterName = str3;
    }

    public void cjv() {
        if (!this.Es) {
            this.Es = true;
            this.iWA = false;
            this.iWB = false;
            this.iWC = false;
            try {
                File file = new File(new File(this.iUK).getParent());
                if (!file.exists()) {
                    file.mkdirs();
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (this.iWv != null) {
                    this.iWv.aH(222, com.baidu.tieba.j.a.p(e));
                }
            }
            try {
                this.iWz = new e(this.iUK);
                this.iWx = new f(this.mContext, this.iWw, this.mFilterName, this.iWz, this.iWv) { // from class: com.baidu.tieba.video.editvideo.b.b.1
                    @Override // com.baidu.tieba.video.editvideo.b.f
                    public void onPostExecute() {
                        b.this.iWA = true;
                        b.this.cjx();
                    }
                };
                this.iWx.start();
                this.iWy = new d(this.mContext, this.iWw, this.iWz, this.iWv) { // from class: com.baidu.tieba.video.editvideo.b.b.2
                    @Override // com.baidu.tieba.video.editvideo.b.d
                    public void onPostExecute() {
                        b.this.iWB = true;
                        b.this.cjx();
                    }
                };
                this.iWy.start();
            } catch (Exception e2) {
            }
        }
    }

    public void cjw() {
        if (this.iWx != null) {
            this.iWx.interrupt();
            this.iWx = null;
        }
        if (this.iWy != null) {
            this.iWy.interrupt();
            this.iWy = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cjx() {
        if (this.iWA && this.iWB && !this.iWC) {
            this.iWz.stop();
            this.iWC = true;
            cjy();
        }
    }

    private void cjy() {
        if (this.iWv != null) {
            File file = new File(this.iUK);
            if (file.exists() && file.length() > 0) {
                this.iWv.Du(this.iUK);
            } else {
                this.iWv.aH(223, "Err empty outputFile");
            }
        }
        this.Es = false;
    }

    public boolean isRunning() {
        return this.Es;
    }

    public void a(a aVar) {
        this.iWv = aVar;
    }
}
