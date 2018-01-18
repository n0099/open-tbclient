package com.baidu.tieba.video.editvideo.b;

import android.annotation.TargetApi;
import android.content.Context;
import java.io.File;
@TargetApi(18)
/* loaded from: classes2.dex */
public class b {
    private String hmB;
    private a hol;
    private String hom;
    private f hon;
    private d hoo;
    private e hop;
    private volatile boolean hoq;
    private volatile boolean hor;
    private volatile boolean hos;
    private Context mContext;
    private String mFilterName;
    private boolean sx = false;

    /* loaded from: classes2.dex */
    public interface a {
        void aj(int i, String str);

        void ak(int i, String str);

        void tu(String str);
    }

    public b(Context context, String str, String str2, String str3) {
        this.mContext = context;
        this.hom = str;
        this.hmB = str2;
        this.mFilterName = str3;
    }

    public void bAF() {
        if (!this.sx) {
            this.sx = true;
            this.hoq = false;
            this.hor = false;
            this.hos = false;
            try {
                File file = new File(new File(this.hmB).getParent());
                if (!file.exists()) {
                    file.mkdirs();
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (this.hol != null) {
                    this.hol.aj(222, com.baidu.tieba.i.a.i(e));
                }
            }
            try {
                this.hop = new e(this.hmB);
                this.hon = new f(this.mContext, this.hom, this.mFilterName, this.hop, this.hol) { // from class: com.baidu.tieba.video.editvideo.b.b.1
                    @Override // com.baidu.tieba.video.editvideo.b.f
                    public void bAJ() {
                        b.this.hoq = true;
                        b.this.bAH();
                    }
                };
                this.hon.start();
                this.hoo = new d(this.mContext, this.hom, this.hop, this.hol) { // from class: com.baidu.tieba.video.editvideo.b.b.2
                    @Override // com.baidu.tieba.video.editvideo.b.d
                    public void bAJ() {
                        b.this.hor = true;
                        b.this.bAH();
                    }
                };
                this.hoo.start();
            } catch (Exception e2) {
            }
        }
    }

    public void bAG() {
        if (this.hon != null) {
            this.hon.interrupt();
            this.hon = null;
        }
        if (this.hoo != null) {
            this.hoo.interrupt();
            this.hoo = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bAH() {
        if (this.hoq && this.hor && !this.hos) {
            this.hop.stop();
            this.hos = true;
            bAI();
        }
    }

    private void bAI() {
        if (this.hol != null) {
            File file = new File(this.hmB);
            if (file.exists() && file.length() > 0) {
                this.hol.tu(this.hmB);
            } else {
                this.hol.aj(223, "Err empty outputFile");
            }
        }
        this.sx = false;
    }

    public boolean isRunning() {
        return this.sx;
    }

    public void a(a aVar) {
        this.hol = aVar;
    }
}
