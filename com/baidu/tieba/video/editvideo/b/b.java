package com.baidu.tieba.video.editvideo.b;

import android.annotation.TargetApi;
import android.content.Context;
import java.io.File;
@TargetApi(18)
/* loaded from: classes22.dex */
public class b {
    private Context mContext;
    private String mFilterName;
    private boolean mIsRunning = false;
    private String mSourcePath;
    private String nnk;
    private a noZ;
    private f npa;
    private d npb;
    private e npc;
    private volatile boolean npd;
    private volatile boolean npe;
    private volatile boolean npf;

    /* loaded from: classes22.dex */
    public interface a {
        void Tw(String str);

        void bV(int i, String str);

        void bW(int i, String str);
    }

    public b(Context context, String str, String str2, String str3) {
        this.mContext = context;
        this.mSourcePath = str;
        this.nnk = str2;
        this.mFilterName = str3;
    }

    public void dOY() {
        if (!this.mIsRunning) {
            this.mIsRunning = true;
            this.npd = false;
            this.npe = false;
            this.npf = false;
            try {
                File file = new File(new File(this.nnk).getParent());
                if (!file.exists()) {
                    file.mkdirs();
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (this.noZ != null) {
                    this.noZ.bV(222, com.baidu.tieba.l.a.r(e));
                }
            }
            try {
                this.npc = new e(this.nnk);
                this.npa = new f(this.mContext, this.mSourcePath, this.mFilterName, this.npc, this.noZ) { // from class: com.baidu.tieba.video.editvideo.b.b.1
                    @Override // com.baidu.tieba.video.editvideo.b.f
                    public void onPostExecute() {
                        b.this.npd = true;
                        b.this.dPa();
                    }
                };
                this.npa.start();
                this.npb = new d(this.mContext, this.mSourcePath, this.npc, this.noZ) { // from class: com.baidu.tieba.video.editvideo.b.b.2
                    @Override // com.baidu.tieba.video.editvideo.b.d
                    public void onPostExecute() {
                        b.this.npe = true;
                        b.this.dPa();
                    }
                };
                this.npb.start();
            } catch (Exception e2) {
            }
        }
    }

    public void dOZ() {
        if (this.npa != null) {
            this.npa.interrupt();
            this.npa = null;
        }
        if (this.npb != null) {
            this.npb.interrupt();
            this.npb = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dPa() {
        if (this.npd && this.npe && !this.npf) {
            this.npc.stop();
            this.npf = true;
            dPb();
        }
    }

    private void dPb() {
        if (this.noZ != null) {
            File file = new File(this.nnk);
            if (file.exists() && file.length() > 0) {
                this.noZ.Tw(this.nnk);
            } else {
                this.noZ.bV(223, "Err empty outputFile");
            }
        }
        this.mIsRunning = false;
    }

    public boolean isRunning() {
        return this.mIsRunning;
    }

    public void a(a aVar) {
        this.noZ = aVar;
    }
}
