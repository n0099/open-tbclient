package com.baidu.tieba.video.editvideo.b;

import android.annotation.TargetApi;
import android.content.Context;
import java.io.File;
@TargetApi(18)
/* loaded from: classes10.dex */
public class b {
    private String lhk;
    private a liU;
    private String liV;
    private f liW;
    private d liX;
    private e liY;
    private volatile boolean liZ;
    private volatile boolean lja;
    private volatile boolean ljb;
    private Context mContext;
    private String mFilterName;
    private boolean mIsRunning = false;

    /* loaded from: classes10.dex */
    public interface a {
        void LI(String str);

        void bu(int i, String str);

        void bv(int i, String str);

        void daX();
    }

    public b(Context context, String str, String str2, String str3) {
        this.mContext = context;
        this.liV = str;
        this.lhk = str2;
        this.mFilterName = str3;
    }

    public void dbd() {
        if (!this.mIsRunning) {
            this.mIsRunning = true;
            this.liZ = false;
            this.lja = false;
            this.ljb = false;
            try {
                File file = new File(new File(this.lhk).getParent());
                if (!file.exists()) {
                    file.mkdirs();
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (this.liU != null) {
                    this.liU.bu(222, com.baidu.tieba.k.a.s(e));
                }
            }
            try {
                this.liY = new e(this.lhk);
                this.liW = new f(this.mContext, this.liV, this.mFilterName, this.liY, this.liU) { // from class: com.baidu.tieba.video.editvideo.b.b.1
                    @Override // com.baidu.tieba.video.editvideo.b.f
                    public void onPostExecute() {
                        b.this.liZ = true;
                        b.this.dbf();
                    }
                };
                this.liW.start();
                this.liX = new d(this.mContext, this.liV, this.liY, this.liU) { // from class: com.baidu.tieba.video.editvideo.b.b.2
                    @Override // com.baidu.tieba.video.editvideo.b.d
                    public void onPostExecute() {
                        b.this.lja = true;
                        b.this.dbf();
                    }
                };
                this.liX.start();
            } catch (Exception e2) {
            }
        }
    }

    public void dbe() {
        if (this.liW != null) {
            this.liW.interrupt();
            this.liW = null;
        }
        if (this.liX != null) {
            this.liX.interrupt();
            this.liX = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dbf() {
        if (this.liZ && this.lja && !this.ljb) {
            this.liY.stop();
            this.ljb = true;
            dbg();
        }
    }

    private void dbg() {
        if (this.liU != null) {
            File file = new File(this.lhk);
            if (file.exists() && file.length() > 0) {
                this.liU.LI(this.lhk);
            } else {
                this.liU.bu(223, "Err empty outputFile");
            }
        }
        this.mIsRunning = false;
    }

    public boolean isRunning() {
        return this.mIsRunning;
    }

    public void a(a aVar) {
        this.liU = aVar;
    }
}
