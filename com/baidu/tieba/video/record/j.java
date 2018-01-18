package com.baidu.tieba.video.record;

import android.widget.ImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.video.record.ProgressView;
import com.faceunity.a.d;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class j {
    private long axn;
    private RecordVideoActivity htL;
    private boolean huA;
    private int hux;
    private ProgressView huy;
    protected List<a> huz;
    private int mProgress;
    private int mStatus = 1;

    /* loaded from: classes2.dex */
    public interface a {
        void wV(int i);
    }

    public j(RecordVideoActivity recordVideoActivity) {
        this.htL = recordVideoActivity;
        if (this.htL != null) {
            ImageView imageView = (ImageView) this.htL.findViewById(d.g.camera_switch);
            ImageView imageView2 = (ImageView) this.htL.findViewById(d.g.flash_switch);
            this.huy = (ProgressView) this.htL.findViewById(d.g.video_progress_view);
            this.huy.setListener(new AnonymousClass1());
            if (!com.baidu.tieba.video.record.a.nf(true)) {
                imageView2.setVisibility(4);
            }
            if (!com.baidu.tieba.video.record.a.c(recordVideoActivity.getPackageManager())) {
                imageView.setVisibility(8);
            }
        }
    }

    /* renamed from: com.baidu.tieba.video.record.j$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    class AnonymousClass1 implements ProgressView.a {
        AnonymousClass1() {
        }

        @Override // com.baidu.tieba.video.record.ProgressView.a
        public void wU(int i) {
            i iVar;
            final h bCt;
            j.this.mProgress = i;
            if (i == 100 && j.this.htL != null && (iVar = j.this.htL.htn) != null && (bCt = iVar.bCt()) != null) {
                if (bCt instanceof g) {
                    bCt.setOnEncoderStatusUpdateListener(new d.c() { // from class: com.baidu.tieba.video.record.j.1.1
                        @Override // com.faceunity.a.d.c
                        public void bCR() {
                        }

                        @Override // com.faceunity.a.d.c
                        public void bCS() {
                            com.baidu.adp.lib.g.e.nr().post(new Runnable() { // from class: com.baidu.tieba.video.record.j.1.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (j.this.htL != null) {
                                        j.this.htL.bCX();
                                    }
                                }
                            });
                            bCt.setOnEncoderStatusUpdateListener(null);
                        }
                    });
                    j.this.stopRecord();
                    return;
                }
                j.this.stopRecord();
                if (j.this.htL != null) {
                    j.this.htL.bCX();
                }
            }
        }
    }

    public int getVideoDuration() {
        return this.hux;
    }

    public void startRecord() {
        if (!this.huA) {
            if (this.huy != null) {
                this.huy.setVisibility(0);
                this.huy.setCurrentState(ProgressView.State.START);
            }
            if (!this.huA) {
                this.huA = true;
                this.axn = System.currentTimeMillis();
            }
            if (this.htL != null && this.htL.htn != null) {
                this.htL.htn.startRecord();
                if (this.htL.hvp != null) {
                    this.htL.hvp.wW(this.hux);
                }
            }
        }
    }

    public boolean bCO() {
        if (this.htL.hvp != null) {
            return this.htL.hvp.bCO();
        }
        return false;
    }

    public void stopRecord() {
        if (this.huA) {
            if (this.huy != null) {
                this.huy.setCurrentState(ProgressView.State.PAUSE);
            }
            this.huA = false;
            this.hux = (int) (this.hux + (System.currentTimeMillis() - this.axn));
            if (this.huy != null && this.huy.getLastProgress() != this.hux) {
                this.huy.wT(this.hux);
            }
            if (this.htL != null && this.htL.htn != null) {
                this.htL.htn.stopRecord();
            }
        }
    }

    public void bCP() {
        if (!this.huA && this.huy != null) {
            this.huy.setCurrentState(ProgressView.State.ROLLBACK);
        }
    }

    public void bCQ() {
        if (this.huy != null) {
            this.huy.setCurrentState(ProgressView.State.DELETE);
        }
        this.hux = this.huy.getLastProgress();
        if (this.htL.htn != null) {
            this.htL.htn.bCw();
        }
    }

    public boolean onBackPressed() {
        return this.huy.bCN();
    }

    public int getStatus() {
        return this.mStatus;
    }

    public void setStatus(int i) {
        File[] listFiles;
        this.mStatus = i;
        if (i == 1) {
            this.huy.setVisibility(4);
            this.huy.reset();
            this.hux = 0;
            File file = new File(com.baidu.tieba.video.b.hmh);
            if (file.exists() && file.isDirectory()) {
                for (File file2 : file.listFiles()) {
                    if (file2.getPath().startsWith("rec_tmp_")) {
                        file2.delete();
                    }
                }
            }
        }
        if (this.huz != null) {
            for (a aVar : this.huz) {
                aVar.wV(this.mStatus);
            }
        }
    }

    public boolean isRecording() {
        int status = getStatus();
        return status == 2 || status == 7;
    }

    public int getProgress() {
        return this.mProgress;
    }

    public void TJ() {
        this.mProgress = 0;
        this.huy.reset();
    }

    public void a(a aVar) {
        if (this.huz == null) {
            this.huz = new ArrayList();
        }
        this.huz.add(aVar);
    }
}
