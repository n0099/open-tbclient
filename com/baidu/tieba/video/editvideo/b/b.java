package com.baidu.tieba.video.editvideo.b;

import android.annotation.TargetApi;
import android.content.Context;
import java.io.File;
@TargetApi(18)
/* loaded from: classes2.dex */
public class b {
    private String gNj;
    private a gOS;
    private String gOT;
    private f gOU;
    private d gOV;
    private e gOW;
    private volatile boolean gOX;
    private volatile boolean gOY;
    private volatile boolean gOZ;
    private Context mContext;
    private String mFilterName;
    private boolean wB = false;

    /* loaded from: classes2.dex */
    public interface a {
        void aj(int i, String str);

        void ak(int i, String str);

        void tT(String str);
    }

    public b(Context context, String str, String str2, String str3) {
        this.mContext = context;
        this.gOT = str;
        this.gNj = str2;
        this.mFilterName = str3;
    }

    public void bBe() {
        if (!this.wB) {
            this.wB = true;
            this.gOX = false;
            this.gOY = false;
            this.gOZ = false;
            try {
                File file = new File(new File(this.gNj).getParent());
                if (!file.exists()) {
                    file.mkdirs();
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (this.gOS != null) {
                    this.gOS.aj(222, com.baidu.tieba.i.a.g(e));
                }
            }
            try {
                this.gOW = new e(this.gNj);
                this.gOU = new f(this.mContext, this.gOT, this.mFilterName, this.gOW, this.gOS) { // from class: com.baidu.tieba.video.editvideo.b.b.1
                    @Override // com.baidu.tieba.video.editvideo.b.f
                    public void bBi() {
                        b.this.gOX = true;
                        b.this.bBg();
                    }
                };
                this.gOU.start();
                this.gOV = new d(this.mContext, this.gOT, this.gOW, this.gOS) { // from class: com.baidu.tieba.video.editvideo.b.b.2
                    @Override // com.baidu.tieba.video.editvideo.b.d
                    public void bBi() {
                        b.this.gOY = true;
                        b.this.bBg();
                    }
                };
                this.gOV.start();
            } catch (Exception e2) {
            }
        }
    }

    public void bBf() {
        if (this.gOU != null) {
            this.gOU.interrupt();
            this.gOU = null;
        }
        if (this.gOV != null) {
            this.gOV.interrupt();
            this.gOV = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBg() {
        if (this.gOX && this.gOY && !this.gOZ) {
            this.gOW.stop();
            this.gOZ = true;
            bBh();
        }
    }

    private void bBh() {
        if (this.gOS != null) {
            File file = new File(this.gNj);
            if (file.exists() && file.length() > 0) {
                this.gOS.tT(this.gNj);
            } else {
                this.gOS.aj(223, "Err empty outputFile");
            }
        }
        this.wB = false;
    }

    public boolean isRunning() {
        return this.wB;
    }

    public void a(a aVar) {
        this.gOS = aVar;
    }
}
