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
    private String mui;
    private a mvV;
    private String mvW;
    private f mvX;
    private d mvY;
    private e mvZ;
    private volatile boolean mwa;
    private volatile boolean mwb;
    private volatile boolean mwc;

    /* loaded from: classes17.dex */
    public interface a {
        void RH(String str);

        void bE(int i, String str);

        void bF(int i, String str);
    }

    public b(Context context, String str, String str2, String str3) {
        this.mContext = context;
        this.mvW = str;
        this.mui = str2;
        this.mFilterName = str3;
    }

    public void dBJ() {
        if (!this.mIsRunning) {
            this.mIsRunning = true;
            this.mwa = false;
            this.mwb = false;
            this.mwc = false;
            try {
                File file = new File(new File(this.mui).getParent());
                if (!file.exists()) {
                    file.mkdirs();
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (this.mvV != null) {
                    this.mvV.bE(222, com.baidu.tieba.k.a.r(e));
                }
            }
            try {
                this.mvZ = new e(this.mui);
                this.mvX = new f(this.mContext, this.mvW, this.mFilterName, this.mvZ, this.mvV) { // from class: com.baidu.tieba.video.editvideo.b.b.1
                    @Override // com.baidu.tieba.video.editvideo.b.f
                    public void onPostExecute() {
                        b.this.mwa = true;
                        b.this.dBL();
                    }
                };
                this.mvX.start();
                this.mvY = new d(this.mContext, this.mvW, this.mvZ, this.mvV) { // from class: com.baidu.tieba.video.editvideo.b.b.2
                    @Override // com.baidu.tieba.video.editvideo.b.d
                    public void onPostExecute() {
                        b.this.mwb = true;
                        b.this.dBL();
                    }
                };
                this.mvY.start();
            } catch (Exception e2) {
            }
        }
    }

    public void dBK() {
        if (this.mvX != null) {
            this.mvX.interrupt();
            this.mvX = null;
        }
        if (this.mvY != null) {
            this.mvY.interrupt();
            this.mvY = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dBL() {
        if (this.mwa && this.mwb && !this.mwc) {
            this.mvZ.stop();
            this.mwc = true;
            dBM();
        }
    }

    private void dBM() {
        if (this.mvV != null) {
            File file = new File(this.mui);
            if (file.exists() && file.length() > 0) {
                this.mvV.RH(this.mui);
            } else {
                this.mvV.bE(223, "Err empty outputFile");
            }
        }
        this.mIsRunning = false;
    }

    public boolean isRunning() {
        return this.mIsRunning;
    }

    public void a(a aVar) {
        this.mvV = aVar;
    }
}
