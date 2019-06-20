package com.baidu.tieba.video.editvideo.b;

import android.annotation.TargetApi;
import android.content.Context;
import java.io.File;
@TargetApi(18)
/* loaded from: classes5.dex */
public class b {
    private boolean Ca = false;
    private String jnM;
    private d jpA;
    private e jpB;
    private volatile boolean jpC;
    private volatile boolean jpD;
    private volatile boolean jpE;
    private a jpx;
    private String jpy;
    private f jpz;
    private Context mContext;
    private String mFilterName;

    /* loaded from: classes5.dex */
    public interface a {
        void ES(String str);

        void aK(int i, String str);

        void aL(int i, String str);
    }

    public b(Context context, String str, String str2, String str3) {
        this.mContext = context;
        this.jpy = str;
        this.jnM = str2;
        this.mFilterName = str3;
    }

    public void crB() {
        if (!this.Ca) {
            this.Ca = true;
            this.jpC = false;
            this.jpD = false;
            this.jpE = false;
            try {
                File file = new File(new File(this.jnM).getParent());
                if (!file.exists()) {
                    file.mkdirs();
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (this.jpx != null) {
                    this.jpx.aK(222, com.baidu.tieba.j.a.p(e));
                }
            }
            try {
                this.jpB = new e(this.jnM);
                this.jpz = new f(this.mContext, this.jpy, this.mFilterName, this.jpB, this.jpx) { // from class: com.baidu.tieba.video.editvideo.b.b.1
                    @Override // com.baidu.tieba.video.editvideo.b.f
                    public void onPostExecute() {
                        b.this.jpC = true;
                        b.this.crD();
                    }
                };
                this.jpz.start();
                this.jpA = new d(this.mContext, this.jpy, this.jpB, this.jpx) { // from class: com.baidu.tieba.video.editvideo.b.b.2
                    @Override // com.baidu.tieba.video.editvideo.b.d
                    public void onPostExecute() {
                        b.this.jpD = true;
                        b.this.crD();
                    }
                };
                this.jpA.start();
            } catch (Exception e2) {
            }
        }
    }

    public void crC() {
        if (this.jpz != null) {
            this.jpz.interrupt();
            this.jpz = null;
        }
        if (this.jpA != null) {
            this.jpA.interrupt();
            this.jpA = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void crD() {
        if (this.jpC && this.jpD && !this.jpE) {
            this.jpB.stop();
            this.jpE = true;
            crE();
        }
    }

    private void crE() {
        if (this.jpx != null) {
            File file = new File(this.jnM);
            if (file.exists() && file.length() > 0) {
                this.jpx.ES(this.jnM);
            } else {
                this.jpx.aK(223, "Err empty outputFile");
            }
        }
        this.Ca = false;
    }

    public boolean isRunning() {
        return this.Ca;
    }

    public void a(a aVar) {
        this.jpx = aVar;
    }
}
