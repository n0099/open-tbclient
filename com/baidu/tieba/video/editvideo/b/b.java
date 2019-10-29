package com.baidu.tieba.video.editvideo.b;

import android.annotation.TargetApi;
import android.content.Context;
import java.io.File;
@TargetApi(18)
/* loaded from: classes5.dex */
public class b {
    private String jxo;
    private a jyZ;
    private String jza;
    private f jzb;
    private d jzc;
    private e jzd;
    private volatile boolean jze;
    private volatile boolean jzf;
    private volatile boolean jzg;
    private Context mContext;
    private String mFilterName;
    private boolean mIsRunning = false;

    /* loaded from: classes5.dex */
    public interface a {
        void EJ(String str);

        void aL(int i, String str);

        void aM(int i, String str);
    }

    public b(Context context, String str, String str2, String str3) {
        this.mContext = context;
        this.jza = str;
        this.jxo = str2;
        this.mFilterName = str3;
    }

    public void ctk() {
        if (!this.mIsRunning) {
            this.mIsRunning = true;
            this.jze = false;
            this.jzf = false;
            this.jzg = false;
            try {
                File file = new File(new File(this.jxo).getParent());
                if (!file.exists()) {
                    file.mkdirs();
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (this.jyZ != null) {
                    this.jyZ.aL(222, com.baidu.tieba.j.a.o(e));
                }
            }
            try {
                this.jzd = new e(this.jxo);
                this.jzb = new f(this.mContext, this.jza, this.mFilterName, this.jzd, this.jyZ) { // from class: com.baidu.tieba.video.editvideo.b.b.1
                    @Override // com.baidu.tieba.video.editvideo.b.f
                    public void onPostExecute() {
                        b.this.jze = true;
                        b.this.ctm();
                    }
                };
                this.jzb.start();
                this.jzc = new d(this.mContext, this.jza, this.jzd, this.jyZ) { // from class: com.baidu.tieba.video.editvideo.b.b.2
                    @Override // com.baidu.tieba.video.editvideo.b.d
                    public void onPostExecute() {
                        b.this.jzf = true;
                        b.this.ctm();
                    }
                };
                this.jzc.start();
            } catch (Exception e2) {
            }
        }
    }

    public void ctl() {
        if (this.jzb != null) {
            this.jzb.interrupt();
            this.jzb = null;
        }
        if (this.jzc != null) {
            this.jzc.interrupt();
            this.jzc = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ctm() {
        if (this.jze && this.jzf && !this.jzg) {
            this.jzd.stop();
            this.jzg = true;
            ctn();
        }
    }

    private void ctn() {
        if (this.jyZ != null) {
            File file = new File(this.jxo);
            if (file.exists() && file.length() > 0) {
                this.jyZ.EJ(this.jxo);
            } else {
                this.jyZ.aL(223, "Err empty outputFile");
            }
        }
        this.mIsRunning = false;
    }

    public boolean isRunning() {
        return this.mIsRunning;
    }

    public void a(a aVar) {
        this.jyZ = aVar;
    }
}
