package com.baidu.tieba.video.editvideo.b;

import android.annotation.TargetApi;
import android.content.Context;
import java.io.File;
@TargetApi(18)
/* loaded from: classes23.dex */
public class b {
    private Context mContext;
    private String mFilterName;
    private boolean mIsRunning = false;
    private String mSourcePath;
    private String mTG;
    private volatile boolean mVA;
    private a mVu;
    private f mVv;
    private d mVw;
    private e mVx;
    private volatile boolean mVy;
    private volatile boolean mVz;

    /* loaded from: classes23.dex */
    public interface a {
        void SV(String str);

        void bS(int i, String str);

        void bT(int i, String str);
    }

    public b(Context context, String str, String str2, String str3) {
        this.mContext = context;
        this.mSourcePath = str;
        this.mTG = str2;
        this.mFilterName = str3;
    }

    public void dJp() {
        if (!this.mIsRunning) {
            this.mIsRunning = true;
            this.mVy = false;
            this.mVz = false;
            this.mVA = false;
            try {
                File file = new File(new File(this.mTG).getParent());
                if (!file.exists()) {
                    file.mkdirs();
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (this.mVu != null) {
                    this.mVu.bS(222, com.baidu.tieba.k.a.r(e));
                }
            }
            try {
                this.mVx = new e(this.mTG);
                this.mVv = new f(this.mContext, this.mSourcePath, this.mFilterName, this.mVx, this.mVu) { // from class: com.baidu.tieba.video.editvideo.b.b.1
                    @Override // com.baidu.tieba.video.editvideo.b.f
                    public void onPostExecute() {
                        b.this.mVy = true;
                        b.this.dJr();
                    }
                };
                this.mVv.start();
                this.mVw = new d(this.mContext, this.mSourcePath, this.mVx, this.mVu) { // from class: com.baidu.tieba.video.editvideo.b.b.2
                    @Override // com.baidu.tieba.video.editvideo.b.d
                    public void onPostExecute() {
                        b.this.mVz = true;
                        b.this.dJr();
                    }
                };
                this.mVw.start();
            } catch (Exception e2) {
            }
        }
    }

    public void dJq() {
        if (this.mVv != null) {
            this.mVv.interrupt();
            this.mVv = null;
        }
        if (this.mVw != null) {
            this.mVw.interrupt();
            this.mVw = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dJr() {
        if (this.mVy && this.mVz && !this.mVA) {
            this.mVx.stop();
            this.mVA = true;
            dJs();
        }
    }

    private void dJs() {
        if (this.mVu != null) {
            File file = new File(this.mTG);
            if (file.exists() && file.length() > 0) {
                this.mVu.SV(this.mTG);
            } else {
                this.mVu.bS(223, "Err empty outputFile");
            }
        }
        this.mIsRunning = false;
    }

    public boolean isRunning() {
        return this.mIsRunning;
    }

    public void a(a aVar) {
        this.mVu = aVar;
    }
}
