package com.baidu.tieba.video.editvideo.b;

import android.annotation.TargetApi;
import android.content.Context;
import java.io.File;
@TargetApi(18)
/* loaded from: classes2.dex */
public class b {
    private String hov;
    private a hqf;
    private String hqg;
    private f hqh;
    private d hqi;
    private e hqj;
    private volatile boolean hqk;
    private volatile boolean hql;
    private volatile boolean hqm;
    private Context mContext;
    private String mFilterName;
    private boolean sw = false;

    /* loaded from: classes2.dex */
    public interface a {
        void aj(int i, String str);

        void ak(int i, String str);

        void tG(String str);
    }

    public b(Context context, String str, String str2, String str3) {
        this.mContext = context;
        this.hqg = str;
        this.hov = str2;
        this.mFilterName = str3;
    }

    public void bBv() {
        if (!this.sw) {
            this.sw = true;
            this.hqk = false;
            this.hql = false;
            this.hqm = false;
            try {
                File file = new File(new File(this.hov).getParent());
                if (!file.exists()) {
                    file.mkdirs();
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (this.hqf != null) {
                    this.hqf.aj(222, com.baidu.tieba.i.a.i(e));
                }
            }
            try {
                this.hqj = new e(this.hov);
                this.hqh = new f(this.mContext, this.hqg, this.mFilterName, this.hqj, this.hqf) { // from class: com.baidu.tieba.video.editvideo.b.b.1
                    @Override // com.baidu.tieba.video.editvideo.b.f
                    public void onPostExecute() {
                        b.this.hqk = true;
                        b.this.bBx();
                    }
                };
                this.hqh.start();
                this.hqi = new d(this.mContext, this.hqg, this.hqj, this.hqf) { // from class: com.baidu.tieba.video.editvideo.b.b.2
                    @Override // com.baidu.tieba.video.editvideo.b.d
                    public void onPostExecute() {
                        b.this.hql = true;
                        b.this.bBx();
                    }
                };
                this.hqi.start();
            } catch (Exception e2) {
            }
        }
    }

    public void bBw() {
        if (this.hqh != null) {
            this.hqh.interrupt();
            this.hqh = null;
        }
        if (this.hqi != null) {
            this.hqi.interrupt();
            this.hqi = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBx() {
        if (this.hqk && this.hql && !this.hqm) {
            this.hqj.stop();
            this.hqm = true;
            bBy();
        }
    }

    private void bBy() {
        if (this.hqf != null) {
            File file = new File(this.hov);
            if (file.exists() && file.length() > 0) {
                this.hqf.tG(this.hov);
            } else {
                this.hqf.aj(223, "Err empty outputFile");
            }
        }
        this.sw = false;
    }

    public boolean isRunning() {
        return this.sw;
    }

    public void a(a aVar) {
        this.hqf = aVar;
    }
}
