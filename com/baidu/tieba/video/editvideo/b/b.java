package com.baidu.tieba.video.editvideo.b;

import android.annotation.TargetApi;
import android.content.Context;
import com.baidu.sapi2.SapiAccountManager;
import java.io.File;
@TargetApi(18)
/* loaded from: classes10.dex */
public class b {
    private a kwI;
    private String kwJ;
    private f kwK;
    private d kwL;
    private e kwM;
    private volatile boolean kwN;
    private volatile boolean kwO;
    private volatile boolean kwP;
    private Context mContext;
    private String mFilterName;
    private boolean mIsRunning = false;
    private String mOutputPath;

    /* loaded from: classes10.dex */
    public interface a {
        void cPH();

        void onGenFilterVideoFail(int i, String str);

        void onGenFilterVideoRecordError(int i, String str);

        void onGenFilterVideoSuccess(String str);
    }

    public b(Context context, String str, String str2, String str3) {
        this.mContext = context;
        this.kwJ = str;
        this.mOutputPath = str2;
        this.mFilterName = str3;
    }

    public void cPM() {
        if (!this.mIsRunning) {
            this.mIsRunning = true;
            this.kwN = false;
            this.kwO = false;
            this.kwP = false;
            try {
                File file = new File(new File(this.mOutputPath).getParent());
                if (!file.exists()) {
                    file.mkdirs();
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (this.kwI != null) {
                    this.kwI.onGenFilterVideoFail(222, com.baidu.tieba.k.a.q(e));
                }
            }
            try {
                this.kwM = new e(this.mOutputPath);
                this.kwK = new f(this.mContext, this.kwJ, this.mFilterName, this.kwM, this.kwI) { // from class: com.baidu.tieba.video.editvideo.b.b.1
                    @Override // com.baidu.tieba.video.editvideo.b.f
                    public void onPostExecute() {
                        b.this.kwN = true;
                        b.this.cPO();
                    }
                };
                this.kwK.start();
                this.kwL = new d(this.mContext, this.kwJ, this.kwM, this.kwI) { // from class: com.baidu.tieba.video.editvideo.b.b.2
                    @Override // com.baidu.tieba.video.editvideo.b.d
                    public void onPostExecute() {
                        b.this.kwO = true;
                        b.this.cPO();
                    }
                };
                this.kwL.start();
            } catch (Exception e2) {
            }
        }
    }

    public void cPN() {
        if (this.kwK != null) {
            this.kwK.interrupt();
            this.kwK = null;
        }
        if (this.kwL != null) {
            this.kwL.interrupt();
            this.kwL = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cPO() {
        if (this.kwN && this.kwO && !this.kwP) {
            this.kwM.stop();
            this.kwP = true;
            cPP();
        }
    }

    private void cPP() {
        if (this.kwI != null) {
            File file = new File(this.mOutputPath);
            if (file.exists() && file.length() > 0) {
                this.kwI.onGenFilterVideoSuccess(this.mOutputPath);
            } else {
                this.kwI.onGenFilterVideoFail(SapiAccountManager.VERSION_CODE, "Err empty outputFile");
            }
        }
        this.mIsRunning = false;
    }

    public boolean isRunning() {
        return this.mIsRunning;
    }

    public void a(a aVar) {
        this.kwI = aVar;
    }
}
