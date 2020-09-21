package com.baidu.tieba.video.editvideo.b;

import android.annotation.TargetApi;
import android.content.Context;
import java.io.File;
@TargetApi(18)
/* loaded from: classes22.dex */
public class b {
    private Context mContext;
    private String mDT;
    private a mFH;
    private f mFI;
    private d mFJ;
    private e mFK;
    private volatile boolean mFL;
    private volatile boolean mFM;
    private volatile boolean mFN;
    private String mFilterName;
    private boolean mIsRunning = false;
    private String mSourcePath;

    /* loaded from: classes22.dex */
    public interface a {
        void Sh(String str);

        void bI(int i, String str);

        void bJ(int i, String str);
    }

    public b(Context context, String str, String str2, String str3) {
        this.mContext = context;
        this.mSourcePath = str;
        this.mDT = str2;
        this.mFilterName = str3;
    }

    public void dFD() {
        if (!this.mIsRunning) {
            this.mIsRunning = true;
            this.mFL = false;
            this.mFM = false;
            this.mFN = false;
            try {
                File file = new File(new File(this.mDT).getParent());
                if (!file.exists()) {
                    file.mkdirs();
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (this.mFH != null) {
                    this.mFH.bI(222, com.baidu.tieba.k.a.r(e));
                }
            }
            try {
                this.mFK = new e(this.mDT);
                this.mFI = new f(this.mContext, this.mSourcePath, this.mFilterName, this.mFK, this.mFH) { // from class: com.baidu.tieba.video.editvideo.b.b.1
                    @Override // com.baidu.tieba.video.editvideo.b.f
                    public void onPostExecute() {
                        b.this.mFL = true;
                        b.this.dFF();
                    }
                };
                this.mFI.start();
                this.mFJ = new d(this.mContext, this.mSourcePath, this.mFK, this.mFH) { // from class: com.baidu.tieba.video.editvideo.b.b.2
                    @Override // com.baidu.tieba.video.editvideo.b.d
                    public void onPostExecute() {
                        b.this.mFM = true;
                        b.this.dFF();
                    }
                };
                this.mFJ.start();
            } catch (Exception e2) {
            }
        }
    }

    public void dFE() {
        if (this.mFI != null) {
            this.mFI.interrupt();
            this.mFI = null;
        }
        if (this.mFJ != null) {
            this.mFJ.interrupt();
            this.mFJ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dFF() {
        if (this.mFL && this.mFM && !this.mFN) {
            this.mFK.stop();
            this.mFN = true;
            dFG();
        }
    }

    private void dFG() {
        if (this.mFH != null) {
            File file = new File(this.mDT);
            if (file.exists() && file.length() > 0) {
                this.mFH.Sh(this.mDT);
            } else {
                this.mFH.bI(223, "Err empty outputFile");
            }
        }
        this.mIsRunning = false;
    }

    public boolean isRunning() {
        return this.mIsRunning;
    }

    public void a(a aVar) {
        this.mFH = aVar;
    }
}
