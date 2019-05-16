package com.baidu.tieba.video.editvideo.b;

import android.annotation.TargetApi;
import android.content.Context;
import java.io.File;
@TargetApi(18)
/* loaded from: classes5.dex */
public class b {
    private boolean Cb = false;
    private String jnH;
    private a jps;
    private String jpt;
    private f jpu;
    private d jpv;
    private e jpw;
    private volatile boolean jpx;
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
        this.jpt = str;
        this.jnH = str2;
        this.mFilterName = str3;
    }

    public void cry() {
        if (!this.Cb) {
            this.Cb = true;
            this.jpx = false;
            this.jpy = false;
            this.jpz = false;
            try {
                File file = new File(new File(this.jnH).getParent());
                if (!file.exists()) {
                    file.mkdirs();
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (this.jps != null) {
                    this.jps.aK(222, com.baidu.tieba.j.a.p(e));
                }
            }
            try {
                this.jpw = new e(this.jnH);
                this.jpu = new f(this.mContext, this.jpt, this.mFilterName, this.jpw, this.jps) { // from class: com.baidu.tieba.video.editvideo.b.b.1
                    @Override // com.baidu.tieba.video.editvideo.b.f
                    public void onPostExecute() {
                        b.this.jpx = true;
                        b.this.crA();
                    }
                };
                this.jpu.start();
                this.jpv = new d(this.mContext, this.jpt, this.jpw, this.jps) { // from class: com.baidu.tieba.video.editvideo.b.b.2
                    @Override // com.baidu.tieba.video.editvideo.b.d
                    public void onPostExecute() {
                        b.this.jpy = true;
                        b.this.crA();
                    }
                };
                this.jpv.start();
            } catch (Exception e2) {
            }
        }
    }

    public void crz() {
        if (this.jpu != null) {
            this.jpu.interrupt();
            this.jpu = null;
        }
        if (this.jpv != null) {
            this.jpv.interrupt();
            this.jpv = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void crA() {
        if (this.jpx && this.jpy && !this.jpz) {
            this.jpw.stop();
            this.jpz = true;
            crB();
        }
    }

    private void crB() {
        if (this.jps != null) {
            File file = new File(this.jnH);
            if (file.exists() && file.length() > 0) {
                this.jps.EQ(this.jnH);
            } else {
                this.jps.aK(223, "Err empty outputFile");
            }
        }
        this.Cb = false;
    }

    public boolean isRunning() {
        return this.Cb;
    }

    public void a(a aVar) {
        this.jps = aVar;
    }
}
