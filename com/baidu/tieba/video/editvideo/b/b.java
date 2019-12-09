package com.baidu.tieba.video.editvideo.b;

import android.annotation.TargetApi;
import android.content.Context;
import com.baidu.sapi2.SapiAccountManager;
import java.io.File;
@TargetApi(18)
/* loaded from: classes5.dex */
public class b {
    private String jwx;
    private a jyi;
    private String jyj;
    private f jyk;
    private d jyl;
    private e jym;
    private volatile boolean jyn;
    private volatile boolean jyo;
    private volatile boolean jyp;
    private Context mContext;
    private String mFilterName;
    private boolean mIsRunning = false;

    /* loaded from: classes5.dex */
    public interface a {
        void EJ(String str);

        void aK(int i, String str);

        void aL(int i, String str);
    }

    public b(Context context, String str, String str2, String str3) {
        this.mContext = context;
        this.jyj = str;
        this.jwx = str2;
        this.mFilterName = str3;
    }

    public void cti() {
        if (!this.mIsRunning) {
            this.mIsRunning = true;
            this.jyn = false;
            this.jyo = false;
            this.jyp = false;
            try {
                File file = new File(new File(this.jwx).getParent());
                if (!file.exists()) {
                    file.mkdirs();
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (this.jyi != null) {
                    this.jyi.aK(222, com.baidu.tieba.j.a.o(e));
                }
            }
            try {
                this.jym = new e(this.jwx);
                this.jyk = new f(this.mContext, this.jyj, this.mFilterName, this.jym, this.jyi) { // from class: com.baidu.tieba.video.editvideo.b.b.1
                    @Override // com.baidu.tieba.video.editvideo.b.f
                    public void onPostExecute() {
                        b.this.jyn = true;
                        b.this.ctk();
                    }
                };
                this.jyk.start();
                this.jyl = new d(this.mContext, this.jyj, this.jym, this.jyi) { // from class: com.baidu.tieba.video.editvideo.b.b.2
                    @Override // com.baidu.tieba.video.editvideo.b.d
                    public void onPostExecute() {
                        b.this.jyo = true;
                        b.this.ctk();
                    }
                };
                this.jyl.start();
            } catch (Exception e2) {
            }
        }
    }

    public void ctj() {
        if (this.jyk != null) {
            this.jyk.interrupt();
            this.jyk = null;
        }
        if (this.jyl != null) {
            this.jyl.interrupt();
            this.jyl = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ctk() {
        if (this.jyn && this.jyo && !this.jyp) {
            this.jym.stop();
            this.jyp = true;
            ctl();
        }
    }

    private void ctl() {
        if (this.jyi != null) {
            File file = new File(this.jwx);
            if (file.exists() && file.length() > 0) {
                this.jyi.EJ(this.jwx);
            } else {
                this.jyi.aK(SapiAccountManager.VERSION_CODE, "Err empty outputFile");
            }
        }
        this.mIsRunning = false;
    }

    public boolean isRunning() {
        return this.mIsRunning;
    }

    public void a(a aVar) {
        this.jyi = aVar;
    }
}
