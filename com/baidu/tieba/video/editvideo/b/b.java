package com.baidu.tieba.video.editvideo.b;

import android.annotation.TargetApi;
import android.content.Context;
import java.io.File;
@TargetApi(18)
/* loaded from: classes5.dex */
public class b {
    private boolean Cb = false;
    private String jnI;
    private volatile boolean jpA;
    private a jpt;
    private String jpu;
    private f jpv;
    private d jpw;
    private e jpx;
    private volatile boolean jpy;
    private volatile boolean jpz;
    private Context mContext;
    private String mFilterName;

    /* loaded from: classes5.dex */
    public interface a {
        void EQ(String str);

        void aK(int i, String str);

        void aL(int i, String str);
    }

    public b(Context context, String str, String str2, String str3) {
        this.mContext = context;
        this.jpu = str;
        this.jnI = str2;
        this.mFilterName = str3;
    }

    public void crA() {
        if (!this.Cb) {
            this.Cb = true;
            this.jpy = false;
            this.jpz = false;
            this.jpA = false;
            try {
                File file = new File(new File(this.jnI).getParent());
                if (!file.exists()) {
                    file.mkdirs();
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (this.jpt != null) {
                    this.jpt.aK(222, com.baidu.tieba.j.a.p(e));
                }
            }
            try {
                this.jpx = new e(this.jnI);
                this.jpv = new f(this.mContext, this.jpu, this.mFilterName, this.jpx, this.jpt) { // from class: com.baidu.tieba.video.editvideo.b.b.1
                    @Override // com.baidu.tieba.video.editvideo.b.f
                    public void onPostExecute() {
                        b.this.jpy = true;
                        b.this.crC();
                    }
                };
                this.jpv.start();
                this.jpw = new d(this.mContext, this.jpu, this.jpx, this.jpt) { // from class: com.baidu.tieba.video.editvideo.b.b.2
                    @Override // com.baidu.tieba.video.editvideo.b.d
                    public void onPostExecute() {
                        b.this.jpz = true;
                        b.this.crC();
                    }
                };
                this.jpw.start();
            } catch (Exception e2) {
            }
        }
    }

    public void crB() {
        if (this.jpv != null) {
            this.jpv.interrupt();
            this.jpv = null;
        }
        if (this.jpw != null) {
            this.jpw.interrupt();
            this.jpw = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void crC() {
        if (this.jpy && this.jpz && !this.jpA) {
            this.jpx.stop();
            this.jpA = true;
            crD();
        }
    }

    private void crD() {
        if (this.jpt != null) {
            File file = new File(this.jnI);
            if (file.exists() && file.length() > 0) {
                this.jpt.EQ(this.jnI);
            } else {
                this.jpt.aK(223, "Err empty outputFile");
            }
        }
        this.Cb = false;
    }

    public boolean isRunning() {
        return this.Cb;
    }

    public void a(a aVar) {
        this.jpt = aVar;
    }
}
