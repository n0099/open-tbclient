package com.baidu.tieba.video.editvideo.b;

import android.annotation.TargetApi;
import android.content.Context;
import java.io.File;
@TargetApi(18)
/* loaded from: classes7.dex */
public class b {
    private Context mContext;
    private String mFilterName;
    private boolean mIsRunning = false;
    private String mSourcePath;
    private String nNg;
    private a nOR;
    private f nOS;
    private d nOT;
    private e nOU;
    private volatile boolean nOV;
    private volatile boolean nOW;
    private volatile boolean nOX;

    /* loaded from: classes7.dex */
    public interface a {
        void UA(String str);

        void cd(int i, String str);

        void ce(int i, String str);
    }

    public b(Context context, String str, String str2, String str3) {
        this.mContext = context;
        this.mSourcePath = str;
        this.nNg = str2;
        this.mFilterName = str3;
    }

    public void dSS() {
        if (!this.mIsRunning) {
            this.mIsRunning = true;
            this.nOV = false;
            this.nOW = false;
            this.nOX = false;
            try {
                File file = new File(new File(this.nNg).getParent());
                if (!file.exists()) {
                    file.mkdirs();
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (this.nOR != null) {
                    this.nOR.cd(222, com.baidu.tieba.l.a.o(e));
                }
            }
            try {
                this.nOU = new e(this.nNg);
                this.nOS = new f(this.mContext, this.mSourcePath, this.mFilterName, this.nOU, this.nOR) { // from class: com.baidu.tieba.video.editvideo.b.b.1
                    @Override // com.baidu.tieba.video.editvideo.b.f
                    public void onPostExecute() {
                        b.this.nOV = true;
                        b.this.dSU();
                    }
                };
                this.nOS.start();
                this.nOT = new d(this.mContext, this.mSourcePath, this.nOU, this.nOR) { // from class: com.baidu.tieba.video.editvideo.b.b.2
                    @Override // com.baidu.tieba.video.editvideo.b.d
                    public void onPostExecute() {
                        b.this.nOW = true;
                        b.this.dSU();
                    }
                };
                this.nOT.start();
            } catch (Exception e2) {
            }
        }
    }

    public void dST() {
        if (this.nOS != null) {
            this.nOS.interrupt();
            this.nOS = null;
        }
        if (this.nOT != null) {
            this.nOT.interrupt();
            this.nOT = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dSU() {
        if (this.nOV && this.nOW && !this.nOX) {
            this.nOU.stop();
            this.nOX = true;
            dSV();
        }
    }

    private void dSV() {
        if (this.nOR != null) {
            File file = new File(this.nNg);
            if (file.exists() && file.length() > 0) {
                this.nOR.UA(this.nNg);
            } else {
                this.nOR.cd(223, "Err empty outputFile");
            }
        }
        this.mIsRunning = false;
    }

    public boolean isRunning() {
        return this.mIsRunning;
    }

    public void a(a aVar) {
        this.nOR = aVar;
    }
}
