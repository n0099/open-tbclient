package com.baidu.tieba.video.editvideo.b;

import android.annotation.TargetApi;
import android.content.Context;
import java.io.File;
@TargetApi(18)
/* loaded from: classes2.dex */
public class b {
    private String hok;
    private a hpU;
    private String hpV;
    private f hpW;
    private d hpX;
    private e hpY;
    private volatile boolean hpZ;
    private volatile boolean hqa;
    private volatile boolean hqb;
    private Context mContext;
    private String mFilterName;
    private boolean sx = false;

    /* loaded from: classes2.dex */
    public interface a {
        void aj(int i, String str);

        void ak(int i, String str);

        void tG(String str);
    }

    public b(Context context, String str, String str2, String str3) {
        this.mContext = context;
        this.hpV = str;
        this.hok = str2;
        this.mFilterName = str3;
    }

    public void bBr() {
        if (!this.sx) {
            this.sx = true;
            this.hpZ = false;
            this.hqa = false;
            this.hqb = false;
            try {
                File file = new File(new File(this.hok).getParent());
                if (!file.exists()) {
                    file.mkdirs();
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (this.hpU != null) {
                    this.hpU.aj(222, com.baidu.tieba.i.a.i(e));
                }
            }
            try {
                this.hpY = new e(this.hok);
                this.hpW = new f(this.mContext, this.hpV, this.mFilterName, this.hpY, this.hpU) { // from class: com.baidu.tieba.video.editvideo.b.b.1
                    @Override // com.baidu.tieba.video.editvideo.b.f
                    public void onPostExecute() {
                        b.this.hpZ = true;
                        b.this.bBt();
                    }
                };
                this.hpW.start();
                this.hpX = new d(this.mContext, this.hpV, this.hpY, this.hpU) { // from class: com.baidu.tieba.video.editvideo.b.b.2
                    @Override // com.baidu.tieba.video.editvideo.b.d
                    public void onPostExecute() {
                        b.this.hqa = true;
                        b.this.bBt();
                    }
                };
                this.hpX.start();
            } catch (Exception e2) {
            }
        }
    }

    public void bBs() {
        if (this.hpW != null) {
            this.hpW.interrupt();
            this.hpW = null;
        }
        if (this.hpX != null) {
            this.hpX.interrupt();
            this.hpX = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBt() {
        if (this.hpZ && this.hqa && !this.hqb) {
            this.hpY.stop();
            this.hqb = true;
            bBu();
        }
    }

    private void bBu() {
        if (this.hpU != null) {
            File file = new File(this.hok);
            if (file.exists() && file.length() > 0) {
                this.hpU.tG(this.hok);
            } else {
                this.hpU.aj(223, "Err empty outputFile");
            }
        }
        this.sx = false;
    }

    public boolean isRunning() {
        return this.sx;
    }

    public void a(a aVar) {
        this.hpU = aVar;
    }
}
