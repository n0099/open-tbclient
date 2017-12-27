package com.baidu.tieba.video.editvideo.b;

import android.annotation.TargetApi;
import android.content.Context;
import java.io.File;
@TargetApi(18)
/* loaded from: classes2.dex */
public class b {
    private String hwY;
    private a hyI;
    private String hyJ;
    private f hyK;
    private d hyL;
    private e hyM;
    private volatile boolean hyN;
    private volatile boolean hyO;
    private volatile boolean hyP;
    private Context mContext;
    private String mFilterName;
    private boolean sx = false;

    /* loaded from: classes2.dex */
    public interface a {
        void ai(int i, String str);

        void aj(int i, String str);

        void tZ(String str);
    }

    public b(Context context, String str, String str2, String str3) {
        this.mContext = context;
        this.hyJ = str;
        this.hwY = str2;
        this.mFilterName = str3;
    }

    public void bHi() {
        if (!this.sx) {
            this.sx = true;
            this.hyN = false;
            this.hyO = false;
            this.hyP = false;
            try {
                File file = new File(new File(this.hwY).getParent());
                if (!file.exists()) {
                    file.mkdirs();
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (this.hyI != null) {
                    this.hyI.ai(222, com.baidu.tieba.i.a.i(e));
                }
            }
            try {
                this.hyM = new e(this.hwY);
                this.hyK = new f(this.mContext, this.hyJ, this.mFilterName, this.hyM, this.hyI) { // from class: com.baidu.tieba.video.editvideo.b.b.1
                    @Override // com.baidu.tieba.video.editvideo.b.f
                    public void bHm() {
                        b.this.hyN = true;
                        b.this.bHk();
                    }
                };
                this.hyK.start();
                this.hyL = new d(this.mContext, this.hyJ, this.hyM, this.hyI) { // from class: com.baidu.tieba.video.editvideo.b.b.2
                    @Override // com.baidu.tieba.video.editvideo.b.d
                    public void bHm() {
                        b.this.hyO = true;
                        b.this.bHk();
                    }
                };
                this.hyL.start();
            } catch (Exception e2) {
            }
        }
    }

    public void bHj() {
        if (this.hyK != null) {
            this.hyK.interrupt();
            this.hyK = null;
        }
        if (this.hyL != null) {
            this.hyL.interrupt();
            this.hyL = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHk() {
        if (this.hyN && this.hyO && !this.hyP) {
            this.hyM.stop();
            this.hyP = true;
            bHl();
        }
    }

    private void bHl() {
        if (this.hyI != null) {
            File file = new File(this.hwY);
            if (file.exists() && file.length() > 0) {
                this.hyI.tZ(this.hwY);
            } else {
                this.hyI.ai(223, "Err empty outputFile");
            }
        }
        this.sx = false;
    }

    public boolean isRunning() {
        return this.sx;
    }

    public void a(a aVar) {
        this.hyI = aVar;
    }
}
