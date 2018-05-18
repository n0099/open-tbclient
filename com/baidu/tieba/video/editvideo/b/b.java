package com.baidu.tieba.video.editvideo.b;

import android.annotation.TargetApi;
import android.content.Context;
import java.io.File;
@TargetApi(18)
/* loaded from: classes2.dex */
public class b {
    private String gLd;
    private a gMP;
    private String gMQ;
    private f gMR;
    private d gMS;
    private e gMT;
    private volatile boolean gMU;
    private volatile boolean gMV;
    private volatile boolean gMW;
    private Context mContext;
    private String mFilterName;
    private boolean mIsRunning = false;

    /* loaded from: classes2.dex */
    public interface a {
        void ap(int i, String str);

        void aq(int i, String str);

        void tQ(String str);
    }

    public b(Context context, String str, String str2, String str3) {
        this.mContext = context;
        this.gMQ = str;
        this.gLd = str2;
        this.mFilterName = str3;
    }

    public void bwy() {
        if (!this.mIsRunning) {
            this.mIsRunning = true;
            this.gMU = false;
            this.gMV = false;
            this.gMW = false;
            try {
                File file = new File(new File(this.gLd).getParent());
                if (!file.exists()) {
                    file.mkdirs();
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (this.gMP != null) {
                    this.gMP.ap(222, com.baidu.tieba.j.a.g(e));
                }
            }
            try {
                this.gMT = new e(this.gLd);
                this.gMR = new f(this.mContext, this.gMQ, this.mFilterName, this.gMT, this.gMP) { // from class: com.baidu.tieba.video.editvideo.b.b.1
                    @Override // com.baidu.tieba.video.editvideo.b.f
                    public void onPostExecute() {
                        b.this.gMU = true;
                        b.this.bwA();
                    }
                };
                this.gMR.start();
                this.gMS = new d(this.mContext, this.gMQ, this.gMT, this.gMP) { // from class: com.baidu.tieba.video.editvideo.b.b.2
                    @Override // com.baidu.tieba.video.editvideo.b.d
                    public void onPostExecute() {
                        b.this.gMV = true;
                        b.this.bwA();
                    }
                };
                this.gMS.start();
            } catch (Exception e2) {
            }
        }
    }

    public void bwz() {
        if (this.gMR != null) {
            this.gMR.interrupt();
            this.gMR = null;
        }
        if (this.gMS != null) {
            this.gMS.interrupt();
            this.gMS = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bwA() {
        if (this.gMU && this.gMV && !this.gMW) {
            this.gMT.stop();
            this.gMW = true;
            bwB();
        }
    }

    private void bwB() {
        if (this.gMP != null) {
            File file = new File(this.gLd);
            if (file.exists() && file.length() > 0) {
                this.gMP.tQ(this.gLd);
            } else {
                this.gMP.ap(223, "Err empty outputFile");
            }
        }
        this.mIsRunning = false;
    }

    public boolean isRunning() {
        return this.mIsRunning;
    }

    public void a(a aVar) {
        this.gMP = aVar;
    }
}
