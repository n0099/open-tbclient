package com.baidu.tieba.video.editvideo.b;

import android.annotation.TargetApi;
import android.content.Context;
import com.baidu.sapi2.SapiAccountManager;
import java.io.File;
@TargetApi(18)
/* loaded from: classes8.dex */
public class b {
    private a kvG;
    private String kvH;
    private f kvI;
    private d kvJ;
    private e kvK;
    private volatile boolean kvL;
    private volatile boolean kvM;
    private volatile boolean kvN;
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
        this.kvH = str;
        this.mOutputPath = str2;
        this.mFilterName = str3;
    }

    public void cOo() {
        if (!this.mIsRunning) {
            this.mIsRunning = true;
            this.kvL = false;
            this.kvM = false;
            this.kvN = false;
            try {
                File file = new File(new File(this.mOutputPath).getParent());
                if (!file.exists()) {
                    file.mkdirs();
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (this.kvG != null) {
                    this.kvG.onGenFilterVideoFail(222, com.baidu.tieba.j.a.r(e));
                }
            }
            try {
                this.kvK = new e(this.mOutputPath);
                this.kvI = new f(this.mContext, this.kvH, this.mFilterName, this.kvK, this.kvG) { // from class: com.baidu.tieba.video.editvideo.b.b.1
                    @Override // com.baidu.tieba.video.editvideo.b.f
                    public void onPostExecute() {
                        b.this.kvL = true;
                        b.this.cOq();
                    }
                };
                this.kvI.start();
                this.kvJ = new d(this.mContext, this.kvH, this.kvK, this.kvG) { // from class: com.baidu.tieba.video.editvideo.b.b.2
                    @Override // com.baidu.tieba.video.editvideo.b.d
                    public void onPostExecute() {
                        b.this.kvM = true;
                        b.this.cOq();
                    }
                };
                this.kvJ.start();
            } catch (Exception e2) {
            }
        }
    }

    public void cOp() {
        if (this.kvI != null) {
            this.kvI.interrupt();
            this.kvI = null;
        }
        if (this.kvJ != null) {
            this.kvJ.interrupt();
            this.kvJ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cOq() {
        if (this.kvL && this.kvM && !this.kvN) {
            this.kvK.stop();
            this.kvN = true;
            cOr();
        }
    }

    private void cOr() {
        if (this.kvG != null) {
            File file = new File(this.mOutputPath);
            if (file.exists() && file.length() > 0) {
                this.kvG.onGenFilterVideoSuccess(this.mOutputPath);
            } else {
                this.kvG.onGenFilterVideoFail(SapiAccountManager.VERSION_CODE, "Err empty outputFile");
            }
        }
        this.mIsRunning = false;
    }

    public boolean isRunning() {
        return this.mIsRunning;
    }

    public void a(a aVar) {
        this.kvG = aVar;
    }
}
