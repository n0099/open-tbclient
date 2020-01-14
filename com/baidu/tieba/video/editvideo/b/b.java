package com.baidu.tieba.video.editvideo.b;

import android.annotation.TargetApi;
import android.content.Context;
import com.baidu.sapi2.SapiAccountManager;
import java.io.File;
@TargetApi(18)
/* loaded from: classes8.dex */
public class b {
    private a kvL;
    private String kvM;
    private f kvN;
    private d kvO;
    private e kvP;
    private volatile boolean kvQ;
    private volatile boolean kvR;
    private volatile boolean kvS;
    private Context mContext;
    private String mFilterName;
    private boolean mIsRunning = false;
    private String mOutputPath;

    /* loaded from: classes8.dex */
    public interface a {
        void onGenFilterVideoFail(int i, String str);

        void onGenFilterVideoRecordError(int i, String str);

        void onGenFilterVideoSuccess(String str);
    }

    public b(Context context, String str, String str2, String str3) {
        this.mContext = context;
        this.kvM = str;
        this.mOutputPath = str2;
        this.mFilterName = str3;
    }

    public void cOq() {
        if (!this.mIsRunning) {
            this.mIsRunning = true;
            this.kvQ = false;
            this.kvR = false;
            this.kvS = false;
            try {
                File file = new File(new File(this.mOutputPath).getParent());
                if (!file.exists()) {
                    file.mkdirs();
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (this.kvL != null) {
                    this.kvL.onGenFilterVideoFail(222, com.baidu.tieba.j.a.r(e));
                }
            }
            try {
                this.kvP = new e(this.mOutputPath);
                this.kvN = new f(this.mContext, this.kvM, this.mFilterName, this.kvP, this.kvL) { // from class: com.baidu.tieba.video.editvideo.b.b.1
                    @Override // com.baidu.tieba.video.editvideo.b.f
                    public void onPostExecute() {
                        b.this.kvQ = true;
                        b.this.cOs();
                    }
                };
                this.kvN.start();
                this.kvO = new d(this.mContext, this.kvM, this.kvP, this.kvL) { // from class: com.baidu.tieba.video.editvideo.b.b.2
                    @Override // com.baidu.tieba.video.editvideo.b.d
                    public void onPostExecute() {
                        b.this.kvR = true;
                        b.this.cOs();
                    }
                };
                this.kvO.start();
            } catch (Exception e2) {
            }
        }
    }

    public void cOr() {
        if (this.kvN != null) {
            this.kvN.interrupt();
            this.kvN = null;
        }
        if (this.kvO != null) {
            this.kvO.interrupt();
            this.kvO = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cOs() {
        if (this.kvQ && this.kvR && !this.kvS) {
            this.kvP.stop();
            this.kvS = true;
            cOt();
        }
    }

    private void cOt() {
        if (this.kvL != null) {
            File file = new File(this.mOutputPath);
            if (file.exists() && file.length() > 0) {
                this.kvL.onGenFilterVideoSuccess(this.mOutputPath);
            } else {
                this.kvL.onGenFilterVideoFail(SapiAccountManager.VERSION_CODE, "Err empty outputFile");
            }
        }
        this.mIsRunning = false;
    }

    public boolean isRunning() {
        return this.mIsRunning;
    }

    public void a(a aVar) {
        this.kvL = aVar;
    }
}
