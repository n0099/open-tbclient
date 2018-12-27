package com.baidu.tieba.video.editvideo.b;

import android.annotation.TargetApi;
import android.content.Context;
import java.io.File;
@TargetApi(18)
/* loaded from: classes5.dex */
public class b {
    private boolean Et = false;
    private String hDn;
    private a hEX;
    private String hEY;
    private f hEZ;
    private d hFa;
    private e hFb;
    private volatile boolean hFc;
    private volatile boolean hFd;
    private volatile boolean hFe;
    private Context mContext;
    private String mFilterName;

    /* loaded from: classes5.dex */
    public interface a {
        void an(int i, String str);

        void ao(int i, String str);

        void wE(String str);
    }

    public b(Context context, String str, String str2, String str3) {
        this.mContext = context;
        this.hEY = str;
        this.hDn = str2;
        this.mFilterName = str3;
    }

    public void bJo() {
        if (!this.Et) {
            this.Et = true;
            this.hFc = false;
            this.hFd = false;
            this.hFe = false;
            try {
                File file = new File(new File(this.hDn).getParent());
                if (!file.exists()) {
                    file.mkdirs();
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (this.hEX != null) {
                    this.hEX.an(222, com.baidu.tieba.j.a.o(e));
                }
            }
            try {
                this.hFb = new e(this.hDn);
                this.hEZ = new f(this.mContext, this.hEY, this.mFilterName, this.hFb, this.hEX) { // from class: com.baidu.tieba.video.editvideo.b.b.1
                    @Override // com.baidu.tieba.video.editvideo.b.f
                    public void onPostExecute() {
                        b.this.hFc = true;
                        b.this.bJq();
                    }
                };
                this.hEZ.start();
                this.hFa = new d(this.mContext, this.hEY, this.hFb, this.hEX) { // from class: com.baidu.tieba.video.editvideo.b.b.2
                    @Override // com.baidu.tieba.video.editvideo.b.d
                    public void onPostExecute() {
                        b.this.hFd = true;
                        b.this.bJq();
                    }
                };
                this.hFa.start();
            } catch (Exception e2) {
            }
        }
    }

    public void bJp() {
        if (this.hEZ != null) {
            this.hEZ.interrupt();
            this.hEZ = null;
        }
        if (this.hFa != null) {
            this.hFa.interrupt();
            this.hFa = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJq() {
        if (this.hFc && this.hFd && !this.hFe) {
            this.hFb.stop();
            this.hFe = true;
            bJr();
        }
    }

    private void bJr() {
        if (this.hEX != null) {
            File file = new File(this.hDn);
            if (file.exists() && file.length() > 0) {
                this.hEX.wE(this.hDn);
            } else {
                this.hEX.an(223, "Err empty outputFile");
            }
        }
        this.Et = false;
    }

    public boolean isRunning() {
        return this.Et;
    }

    public void a(a aVar) {
        this.hEX = aVar;
    }
}
