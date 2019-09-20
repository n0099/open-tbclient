package com.baidu.tieba.video.editvideo.b;

import android.annotation.TargetApi;
import android.content.Context;
import java.io.File;
@TargetApi(18)
/* loaded from: classes5.dex */
public class b {
    private boolean Cg = false;
    private String jxw;
    private a jzh;
    private String jzi;
    private f jzj;
    private d jzk;
    private e jzl;
    private volatile boolean jzm;
    private volatile boolean jzn;
    private volatile boolean jzo;
    private Context mContext;
    private String mFilterName;

    /* loaded from: classes5.dex */
    public interface a {
        void Gh(String str);

        void aK(int i, String str);

        void aL(int i, String str);
    }

    public b(Context context, String str, String str2, String str3) {
        this.mContext = context;
        this.jzi = str;
        this.jxw = str2;
        this.mFilterName = str3;
    }

    public void cvw() {
        if (!this.Cg) {
            this.Cg = true;
            this.jzm = false;
            this.jzn = false;
            this.jzo = false;
            try {
                File file = new File(new File(this.jxw).getParent());
                if (!file.exists()) {
                    file.mkdirs();
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (this.jzh != null) {
                    this.jzh.aK(222, com.baidu.tieba.j.a.p(e));
                }
            }
            try {
                this.jzl = new e(this.jxw);
                this.jzj = new f(this.mContext, this.jzi, this.mFilterName, this.jzl, this.jzh) { // from class: com.baidu.tieba.video.editvideo.b.b.1
                    @Override // com.baidu.tieba.video.editvideo.b.f
                    public void onPostExecute() {
                        b.this.jzm = true;
                        b.this.cvy();
                    }
                };
                this.jzj.start();
                this.jzk = new d(this.mContext, this.jzi, this.jzl, this.jzh) { // from class: com.baidu.tieba.video.editvideo.b.b.2
                    @Override // com.baidu.tieba.video.editvideo.b.d
                    public void onPostExecute() {
                        b.this.jzn = true;
                        b.this.cvy();
                    }
                };
                this.jzk.start();
            } catch (Exception e2) {
            }
        }
    }

    public void cvx() {
        if (this.jzj != null) {
            this.jzj.interrupt();
            this.jzj = null;
        }
        if (this.jzk != null) {
            this.jzk.interrupt();
            this.jzk = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cvy() {
        if (this.jzm && this.jzn && !this.jzo) {
            this.jzl.stop();
            this.jzo = true;
            cvz();
        }
    }

    private void cvz() {
        if (this.jzh != null) {
            File file = new File(this.jxw);
            if (file.exists() && file.length() > 0) {
                this.jzh.Gh(this.jxw);
            } else {
                this.jzh.aK(223, "Err empty outputFile");
            }
        }
        this.Cg = false;
    }

    public boolean isRunning() {
        return this.Cg;
    }

    public void a(a aVar) {
        this.jzh = aVar;
    }
}
