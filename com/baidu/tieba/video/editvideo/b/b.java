package com.baidu.tieba.video.editvideo.b;

import android.annotation.TargetApi;
import android.content.Context;
import com.baidu.sapi2.SapiAccountManager;
import java.io.File;
@TargetApi(18)
/* loaded from: classes10.dex */
public class b {
    private a kyB;
    private String kyC;
    private f kyD;
    private d kyE;
    private e kyF;
    private volatile boolean kyG;
    private volatile boolean kyH;
    private volatile boolean kyI;
    private Context mContext;
    private String mFilterName;
    private boolean mIsRunning = false;
    private String mOutputPath;

    /* loaded from: classes10.dex */
    public interface a {
        void cQe();

        void onGenFilterVideoFail(int i, String str);

        void onGenFilterVideoRecordError(int i, String str);

        void onGenFilterVideoSuccess(String str);
    }

    public b(Context context, String str, String str2, String str3) {
        this.mContext = context;
        this.kyC = str;
        this.mOutputPath = str2;
        this.mFilterName = str3;
    }

    public void cQj() {
        if (!this.mIsRunning) {
            this.mIsRunning = true;
            this.kyG = false;
            this.kyH = false;
            this.kyI = false;
            try {
                File file = new File(new File(this.mOutputPath).getParent());
                if (!file.exists()) {
                    file.mkdirs();
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (this.kyB != null) {
                    this.kyB.onGenFilterVideoFail(222, com.baidu.tieba.k.a.q(e));
                }
            }
            try {
                this.kyF = new e(this.mOutputPath);
                this.kyD = new f(this.mContext, this.kyC, this.mFilterName, this.kyF, this.kyB) { // from class: com.baidu.tieba.video.editvideo.b.b.1
                    @Override // com.baidu.tieba.video.editvideo.b.f
                    public void onPostExecute() {
                        b.this.kyG = true;
                        b.this.cQl();
                    }
                };
                this.kyD.start();
                this.kyE = new d(this.mContext, this.kyC, this.kyF, this.kyB) { // from class: com.baidu.tieba.video.editvideo.b.b.2
                    @Override // com.baidu.tieba.video.editvideo.b.d
                    public void onPostExecute() {
                        b.this.kyH = true;
                        b.this.cQl();
                    }
                };
                this.kyE.start();
            } catch (Exception e2) {
            }
        }
    }

    public void cQk() {
        if (this.kyD != null) {
            this.kyD.interrupt();
            this.kyD = null;
        }
        if (this.kyE != null) {
            this.kyE.interrupt();
            this.kyE = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cQl() {
        if (this.kyG && this.kyH && !this.kyI) {
            this.kyF.stop();
            this.kyI = true;
            cQm();
        }
    }

    private void cQm() {
        if (this.kyB != null) {
            File file = new File(this.mOutputPath);
            if (file.exists() && file.length() > 0) {
                this.kyB.onGenFilterVideoSuccess(this.mOutputPath);
            } else {
                this.kyB.onGenFilterVideoFail(SapiAccountManager.VERSION_CODE, "Err empty outputFile");
            }
        }
        this.mIsRunning = false;
    }

    public boolean isRunning() {
        return this.mIsRunning;
    }

    public void a(a aVar) {
        this.kyB = aVar;
    }
}
