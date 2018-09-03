package com.baidu.tieba.video.editvideo.b;

import android.annotation.TargetApi;
import android.content.Context;
import java.io.File;
@TargetApi(18)
/* loaded from: classes2.dex */
public class b {
    private boolean Bm = false;
    private String hbY;
    private a hdJ;
    private String hdK;
    private f hdL;
    private d hdM;
    private e hdN;
    private volatile boolean hdO;
    private volatile boolean hdP;
    private volatile boolean hdQ;
    private Context mContext;
    private String mFilterName;

    /* loaded from: classes2.dex */
    public interface a {
        void ap(int i, String str);

        void aq(int i, String str);

        void uI(String str);
    }

    public b(Context context, String str, String str2, String str3) {
        this.mContext = context;
        this.hdK = str;
        this.hbY = str2;
        this.mFilterName = str3;
    }

    public void bAS() {
        if (!this.Bm) {
            this.Bm = true;
            this.hdO = false;
            this.hdP = false;
            this.hdQ = false;
            try {
                File file = new File(new File(this.hbY).getParent());
                if (!file.exists()) {
                    file.mkdirs();
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (this.hdJ != null) {
                    this.hdJ.ap(222, com.baidu.tieba.j.a.m(e));
                }
            }
            try {
                this.hdN = new e(this.hbY);
                this.hdL = new f(this.mContext, this.hdK, this.mFilterName, this.hdN, this.hdJ) { // from class: com.baidu.tieba.video.editvideo.b.b.1
                    @Override // com.baidu.tieba.video.editvideo.b.f
                    public void onPostExecute() {
                        b.this.hdO = true;
                        b.this.bAU();
                    }
                };
                this.hdL.start();
                this.hdM = new d(this.mContext, this.hdK, this.hdN, this.hdJ) { // from class: com.baidu.tieba.video.editvideo.b.b.2
                    @Override // com.baidu.tieba.video.editvideo.b.d
                    public void onPostExecute() {
                        b.this.hdP = true;
                        b.this.bAU();
                    }
                };
                this.hdM.start();
            } catch (Exception e2) {
            }
        }
    }

    public void bAT() {
        if (this.hdL != null) {
            this.hdL.interrupt();
            this.hdL = null;
        }
        if (this.hdM != null) {
            this.hdM.interrupt();
            this.hdM = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bAU() {
        if (this.hdO && this.hdP && !this.hdQ) {
            this.hdN.stop();
            this.hdQ = true;
            bAV();
        }
    }

    private void bAV() {
        if (this.hdJ != null) {
            File file = new File(this.hbY);
            if (file.exists() && file.length() > 0) {
                this.hdJ.uI(this.hbY);
            } else {
                this.hdJ.ap(223, "Err empty outputFile");
            }
        }
        this.Bm = false;
    }

    public boolean isRunning() {
        return this.Bm;
    }

    public void a(a aVar) {
        this.hdJ = aVar;
    }
}
