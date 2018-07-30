package com.baidu.tieba.video.editvideo.b;

import android.annotation.TargetApi;
import android.content.Context;
import java.io.File;
@TargetApi(18)
/* loaded from: classes2.dex */
public class b {
    private boolean Bl = false;
    private String hbX;
    private a hdI;
    private String hdJ;
    private f hdK;
    private d hdL;
    private e hdM;
    private volatile boolean hdN;
    private volatile boolean hdO;
    private volatile boolean hdP;
    private Context mContext;
    private String mFilterName;

    /* loaded from: classes2.dex */
    public interface a {
        void ap(int i, String str);

        void aq(int i, String str);

        void uE(String str);
    }

    public b(Context context, String str, String str2, String str3) {
        this.mContext = context;
        this.hdJ = str;
        this.hbX = str2;
        this.mFilterName = str3;
    }

    public void bAQ() {
        if (!this.Bl) {
            this.Bl = true;
            this.hdN = false;
            this.hdO = false;
            this.hdP = false;
            try {
                File file = new File(new File(this.hbX).getParent());
                if (!file.exists()) {
                    file.mkdirs();
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (this.hdI != null) {
                    this.hdI.ap(222, com.baidu.tieba.j.a.m(e));
                }
            }
            try {
                this.hdM = new e(this.hbX);
                this.hdK = new f(this.mContext, this.hdJ, this.mFilterName, this.hdM, this.hdI) { // from class: com.baidu.tieba.video.editvideo.b.b.1
                    @Override // com.baidu.tieba.video.editvideo.b.f
                    public void onPostExecute() {
                        b.this.hdN = true;
                        b.this.bAS();
                    }
                };
                this.hdK.start();
                this.hdL = new d(this.mContext, this.hdJ, this.hdM, this.hdI) { // from class: com.baidu.tieba.video.editvideo.b.b.2
                    @Override // com.baidu.tieba.video.editvideo.b.d
                    public void onPostExecute() {
                        b.this.hdO = true;
                        b.this.bAS();
                    }
                };
                this.hdL.start();
            } catch (Exception e2) {
            }
        }
    }

    public void bAR() {
        if (this.hdK != null) {
            this.hdK.interrupt();
            this.hdK = null;
        }
        if (this.hdL != null) {
            this.hdL.interrupt();
            this.hdL = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bAS() {
        if (this.hdN && this.hdO && !this.hdP) {
            this.hdM.stop();
            this.hdP = true;
            bAT();
        }
    }

    private void bAT() {
        if (this.hdI != null) {
            File file = new File(this.hbX);
            if (file.exists() && file.length() > 0) {
                this.hdI.uE(this.hbX);
            } else {
                this.hdI.ap(223, "Err empty outputFile");
            }
        }
        this.Bl = false;
    }

    public boolean isRunning() {
        return this.Bl;
    }

    public void a(a aVar) {
        this.hdI = aVar;
    }
}
