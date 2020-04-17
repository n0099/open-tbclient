package com.baidu.tieba.video.editvideo.b;

import android.annotation.TargetApi;
import android.content.Context;
import com.baidu.sapi2.SapiAccountManager;
import java.io.File;
@TargetApi(18)
/* loaded from: classes10.dex */
public class b {
    private String lhg;
    private a liQ;
    private String liR;
    private f liS;
    private d liT;
    private e liU;
    private volatile boolean liV;
    private volatile boolean liW;
    private volatile boolean liX;
    private Context mContext;
    private String mFilterName;
    private boolean mIsRunning = false;

    /* loaded from: classes10.dex */
    public interface a {
        void LF(String str);

        void bu(int i, String str);

        void bv(int i, String str);

        void dba();
    }

    public b(Context context, String str, String str2, String str3) {
        this.mContext = context;
        this.liR = str;
        this.lhg = str2;
        this.mFilterName = str3;
    }

    public void dbg() {
        if (!this.mIsRunning) {
            this.mIsRunning = true;
            this.liV = false;
            this.liW = false;
            this.liX = false;
            try {
                File file = new File(new File(this.lhg).getParent());
                if (!file.exists()) {
                    file.mkdirs();
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (this.liQ != null) {
                    this.liQ.bu(222, com.baidu.tieba.k.a.s(e));
                }
            }
            try {
                this.liU = new e(this.lhg);
                this.liS = new f(this.mContext, this.liR, this.mFilterName, this.liU, this.liQ) { // from class: com.baidu.tieba.video.editvideo.b.b.1
                    @Override // com.baidu.tieba.video.editvideo.b.f
                    public void onPostExecute() {
                        b.this.liV = true;
                        b.this.dbi();
                    }
                };
                this.liS.start();
                this.liT = new d(this.mContext, this.liR, this.liU, this.liQ) { // from class: com.baidu.tieba.video.editvideo.b.b.2
                    @Override // com.baidu.tieba.video.editvideo.b.d
                    public void onPostExecute() {
                        b.this.liW = true;
                        b.this.dbi();
                    }
                };
                this.liT.start();
            } catch (Exception e2) {
            }
        }
    }

    public void dbh() {
        if (this.liS != null) {
            this.liS.interrupt();
            this.liS = null;
        }
        if (this.liT != null) {
            this.liT.interrupt();
            this.liT = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dbi() {
        if (this.liV && this.liW && !this.liX) {
            this.liU.stop();
            this.liX = true;
            dbj();
        }
    }

    private void dbj() {
        if (this.liQ != null) {
            File file = new File(this.lhg);
            if (file.exists() && file.length() > 0) {
                this.liQ.LF(this.lhg);
            } else {
                this.liQ.bu(SapiAccountManager.VERSION_CODE, "Err empty outputFile");
            }
        }
        this.mIsRunning = false;
    }

    public boolean isRunning() {
        return this.mIsRunning;
    }

    public void a(a aVar) {
        this.liQ = aVar;
    }
}
