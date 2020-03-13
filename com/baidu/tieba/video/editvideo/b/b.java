package com.baidu.tieba.video.editvideo.b;

import android.annotation.TargetApi;
import android.content.Context;
import com.baidu.sapi2.SapiAccountManager;
import java.io.File;
@TargetApi(18)
/* loaded from: classes10.dex */
public class b {
    private a kwW;
    private String kwX;
    private f kwY;
    private d kwZ;
    private e kxa;
    private volatile boolean kxb;
    private volatile boolean kxc;
    private volatile boolean kxd;
    private Context mContext;
    private String mFilterName;
    private boolean mIsRunning = false;
    private String mOutputPath;

    /* loaded from: classes10.dex */
    public interface a {
        void cPK();

        void onGenFilterVideoFail(int i, String str);

        void onGenFilterVideoRecordError(int i, String str);

        void onGenFilterVideoSuccess(String str);
    }

    public b(Context context, String str, String str2, String str3) {
        this.mContext = context;
        this.kwX = str;
        this.mOutputPath = str2;
        this.mFilterName = str3;
    }

    public void cPP() {
        if (!this.mIsRunning) {
            this.mIsRunning = true;
            this.kxb = false;
            this.kxc = false;
            this.kxd = false;
            try {
                File file = new File(new File(this.mOutputPath).getParent());
                if (!file.exists()) {
                    file.mkdirs();
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (this.kwW != null) {
                    this.kwW.onGenFilterVideoFail(222, com.baidu.tieba.k.a.q(e));
                }
            }
            try {
                this.kxa = new e(this.mOutputPath);
                this.kwY = new f(this.mContext, this.kwX, this.mFilterName, this.kxa, this.kwW) { // from class: com.baidu.tieba.video.editvideo.b.b.1
                    @Override // com.baidu.tieba.video.editvideo.b.f
                    public void onPostExecute() {
                        b.this.kxb = true;
                        b.this.cPR();
                    }
                };
                this.kwY.start();
                this.kwZ = new d(this.mContext, this.kwX, this.kxa, this.kwW) { // from class: com.baidu.tieba.video.editvideo.b.b.2
                    @Override // com.baidu.tieba.video.editvideo.b.d
                    public void onPostExecute() {
                        b.this.kxc = true;
                        b.this.cPR();
                    }
                };
                this.kwZ.start();
            } catch (Exception e2) {
            }
        }
    }

    public void cPQ() {
        if (this.kwY != null) {
            this.kwY.interrupt();
            this.kwY = null;
        }
        if (this.kwZ != null) {
            this.kwZ.interrupt();
            this.kwZ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cPR() {
        if (this.kxb && this.kxc && !this.kxd) {
            this.kxa.stop();
            this.kxd = true;
            cPS();
        }
    }

    private void cPS() {
        if (this.kwW != null) {
            File file = new File(this.mOutputPath);
            if (file.exists() && file.length() > 0) {
                this.kwW.onGenFilterVideoSuccess(this.mOutputPath);
            } else {
                this.kwW.onGenFilterVideoFail(SapiAccountManager.VERSION_CODE, "Err empty outputFile");
            }
        }
        this.mIsRunning = false;
    }

    public boolean isRunning() {
        return this.mIsRunning;
    }

    public void a(a aVar) {
        this.kwW = aVar;
    }
}
