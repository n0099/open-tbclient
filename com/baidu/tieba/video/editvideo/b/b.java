package com.baidu.tieba.video.editvideo.b;

import android.annotation.TargetApi;
import android.content.Context;
import java.io.File;
@TargetApi(18)
/* loaded from: classes17.dex */
public class b {
    private Context mContext;
    private String mFilterName;
    private boolean mIsRunning = false;
    private String mcd;
    private a mdQ;
    private String mdR;
    private f mdS;
    private d mdT;
    private e mdU;
    private volatile boolean mdV;
    private volatile boolean mdW;
    private volatile boolean mdX;

    /* loaded from: classes17.dex */
    public interface a {
        void OJ(String str);

        void bH(int i, String str);

        void bI(int i, String str);
    }

    public b(Context context, String str, String str2, String str3) {
        this.mContext = context;
        this.mdR = str;
        this.mcd = str2;
        this.mFilterName = str3;
    }

    public void dqe() {
        if (!this.mIsRunning) {
            this.mIsRunning = true;
            this.mdV = false;
            this.mdW = false;
            this.mdX = false;
            try {
                File file = new File(new File(this.mcd).getParent());
                if (!file.exists()) {
                    file.mkdirs();
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (this.mdQ != null) {
                    this.mdQ.bH(222, com.baidu.tieba.k.a.s(e));
                }
            }
            try {
                this.mdU = new e(this.mcd);
                this.mdS = new f(this.mContext, this.mdR, this.mFilterName, this.mdU, this.mdQ) { // from class: com.baidu.tieba.video.editvideo.b.b.1
                    @Override // com.baidu.tieba.video.editvideo.b.f
                    public void onPostExecute() {
                        b.this.mdV = true;
                        b.this.dqg();
                    }
                };
                this.mdS.start();
                this.mdT = new d(this.mContext, this.mdR, this.mdU, this.mdQ) { // from class: com.baidu.tieba.video.editvideo.b.b.2
                    @Override // com.baidu.tieba.video.editvideo.b.d
                    public void onPostExecute() {
                        b.this.mdW = true;
                        b.this.dqg();
                    }
                };
                this.mdT.start();
            } catch (Exception e2) {
            }
        }
    }

    public void dqf() {
        if (this.mdS != null) {
            this.mdS.interrupt();
            this.mdS = null;
        }
        if (this.mdT != null) {
            this.mdT.interrupt();
            this.mdT = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dqg() {
        if (this.mdV && this.mdW && !this.mdX) {
            this.mdU.stop();
            this.mdX = true;
            dqh();
        }
    }

    private void dqh() {
        if (this.mdQ != null) {
            File file = new File(this.mcd);
            if (file.exists() && file.length() > 0) {
                this.mdQ.OJ(this.mcd);
            } else {
                this.mdQ.bH(223, "Err empty outputFile");
            }
        }
        this.mIsRunning = false;
    }

    public boolean isRunning() {
        return this.mIsRunning;
    }

    public void a(a aVar) {
        this.mdQ = aVar;
    }
}
