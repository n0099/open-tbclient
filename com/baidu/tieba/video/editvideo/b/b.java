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
    private String ngh;
    private a nhU;
    private f nhV;
    private d nhW;
    private e nhX;
    private volatile boolean nhY;
    private volatile boolean nhZ;
    private volatile boolean nia;

    /* loaded from: classes23.dex */
    public interface a {
        void Tu(String str);

        void bT(int i, String str);

        void bU(int i, String str);
    }

    public b(Context context, String str, String str2, String str3) {
        this.mContext = context;
        this.mSourcePath = str;
        this.ngh = str2;
        this.mFilterName = str3;
    }

    public void dMx() {
        if (!this.mIsRunning) {
            this.mIsRunning = true;
            this.nhY = false;
            this.nhZ = false;
            this.nia = false;
            try {
                File file = new File(new File(this.ngh).getParent());
                if (!file.exists()) {
                    file.mkdirs();
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (this.nhU != null) {
                    this.nhU.bT(222, com.baidu.tieba.k.a.r(e));
                }
            }
            try {
                this.nhX = new e(this.ngh);
                this.nhV = new f(this.mContext, this.mSourcePath, this.mFilterName, this.nhX, this.nhU) { // from class: com.baidu.tieba.video.editvideo.b.b.1
                    @Override // com.baidu.tieba.video.editvideo.b.f
                    public void onPostExecute() {
                        b.this.nhY = true;
                        b.this.dMz();
                    }
                };
                this.nhV.start();
                this.nhW = new d(this.mContext, this.mSourcePath, this.nhX, this.nhU) { // from class: com.baidu.tieba.video.editvideo.b.b.2
                    @Override // com.baidu.tieba.video.editvideo.b.d
                    public void onPostExecute() {
                        b.this.nhZ = true;
                        b.this.dMz();
                    }
                };
                this.nhW.start();
            } catch (Exception e2) {
            }
        }
    }

    public void dMy() {
        if (this.nhV != null) {
            this.nhV.interrupt();
            this.nhV = null;
        }
        if (this.nhW != null) {
            this.nhW.interrupt();
            this.nhW = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dMz() {
        if (this.nhY && this.nhZ && !this.nia) {
            this.nhX.stop();
            this.nia = true;
            dMA();
        }
    }

    private void dMA() {
        if (this.nhU != null) {
            File file = new File(this.ngh);
            if (file.exists() && file.length() > 0) {
                this.nhU.Tu(this.ngh);
            } else {
                this.nhU.bT(223, "Err empty outputFile");
            }
        }
        this.mIsRunning = false;
    }

    public boolean isRunning() {
        return this.mIsRunning;
    }

    public void a(a aVar) {
        this.nhU = aVar;
    }
}
