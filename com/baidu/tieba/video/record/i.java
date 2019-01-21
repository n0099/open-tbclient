package com.baidu.tieba.video.record;

import android.widget.ImageView;
import com.baidu.tieba.e;
import com.baidu.tieba.video.record.ProgressView;
import com.faceunity.a.d;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class i {
    private long SG;
    private int hLO;
    private ProgressView hLP;
    protected List<a> hLQ;
    private boolean hLR;
    private RecordVideoActivity hLd;
    private int mProgress;
    private int mStatus = 1;

    /* loaded from: classes5.dex */
    public interface a {
        void wT(int i);
    }

    public i(RecordVideoActivity recordVideoActivity) {
        this.hLd = recordVideoActivity;
        if (this.hLd != null) {
            ImageView imageView = (ImageView) this.hLd.findViewById(e.g.camera_switch);
            ImageView imageView2 = (ImageView) this.hLd.findViewById(e.g.flash_switch);
            this.hLP = (ProgressView) this.hLd.findViewById(e.g.video_progress_view);
            this.hLP.setListener(new AnonymousClass1());
            if (!com.baidu.tieba.video.record.a.of(true)) {
                imageView2.setVisibility(4);
            }
            if (!com.baidu.tieba.video.record.a.b(recordVideoActivity.getPackageManager())) {
                imageView.setVisibility(8);
            }
        }
    }

    /* renamed from: com.baidu.tieba.video.record.i$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    class AnonymousClass1 implements ProgressView.a {
        AnonymousClass1() {
        }

        @Override // com.baidu.tieba.video.record.ProgressView.a
        public void wS(int i) {
            h hVar;
            final g bLy;
            i.this.mProgress = i;
            if (i == 100 && i.this.hLd != null && (hVar = i.this.hLd.hKD) != null && (bLy = hVar.bLy()) != null) {
                if (bLy instanceof GLVideoPreviewView) {
                    bLy.setOnEncoderStatusUpdateListener(new d.c() { // from class: com.baidu.tieba.video.record.i.1.1
                        @Override // com.faceunity.a.d.c
                        public void bLT() {
                        }

                        @Override // com.faceunity.a.d.c
                        public void bLU() {
                            com.baidu.adp.lib.g.e.jG().post(new Runnable() { // from class: com.baidu.tieba.video.record.i.1.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (i.this.hLd != null) {
                                        i.this.hLd.bMo();
                                    }
                                }
                            });
                            bLy.setOnEncoderStatusUpdateListener(null);
                        }
                    });
                    i.this.stopRecord();
                    return;
                }
                i.this.stopRecord();
                if (i.this.hLd != null) {
                    i.this.hLd.bMo();
                }
            }
        }
    }

    public int getVideoDuration() {
        return this.hLO;
    }

    public void startRecord() {
        if (!this.hLR) {
            if (this.hLP != null) {
                this.hLP.setVisibility(0);
                this.hLP.setCurrentState(ProgressView.State.START);
            }
            if (!this.hLR) {
                this.hLR = true;
                this.SG = System.currentTimeMillis();
            }
            if (this.hLd != null && this.hLd.hKD != null) {
                this.hLd.hKD.startRecord();
                if (this.hLd.hMG != null) {
                    this.hLd.hMG.wU(this.hLO);
                }
            }
        }
    }

    public boolean bLP() {
        if (this.hLd.hMG != null) {
            return this.hLd.hMG.bLP();
        }
        return false;
    }

    public void stopRecord() {
        if (this.hLR) {
            if (this.hLP != null) {
                this.hLP.setCurrentState(ProgressView.State.PAUSE);
            }
            this.hLR = false;
            this.hLO = (int) (this.hLO + (System.currentTimeMillis() - this.SG));
            if (this.hLP != null && this.hLP.getLastProgress() != this.hLO) {
                this.hLP.wR(this.hLO);
            }
            if (this.hLd != null && this.hLd.hKD != null) {
                this.hLd.hKD.stopRecord();
            }
        }
    }

    public void bLQ() {
        if (!this.hLR && this.hLP != null) {
            this.hLP.setCurrentState(ProgressView.State.ROLLBACK);
        }
    }

    public void bLR() {
        if (this.hLP != null) {
            this.hLP.setCurrentState(ProgressView.State.DELETE);
        }
        this.hLO = this.hLP.getLastProgress();
        if (this.hLd.hKD != null) {
            this.hLd.hKD.bLA();
        }
    }

    public boolean onBackPressed() {
        return this.hLP.bLO();
    }

    public int getStatus() {
        return this.mStatus;
    }

    public void setStatus(int i) {
        File[] listFiles;
        this.mStatus = i;
        if (i == 1) {
            this.hLP.setVisibility(4);
            this.hLP.reset();
            this.hLO = 0;
            File file = new File(com.baidu.tieba.video.c.hEb);
            if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
                for (File file2 : listFiles) {
                    if (file2.getPath().startsWith("rec_tmp_")) {
                        file2.delete();
                    }
                }
            }
        }
        if (this.hLQ != null) {
            for (a aVar : this.hLQ) {
                aVar.wT(this.mStatus);
            }
        }
    }

    public boolean Gf() {
        int status = getStatus();
        return status == 2 || status == 7;
    }

    public boolean bLS() {
        return this.mStatus == 6;
    }

    public int getProgress() {
        return this.mProgress;
    }

    public void a(a aVar) {
        if (this.hLQ == null) {
            this.hLQ = new ArrayList();
        }
        this.hLQ.add(aVar);
    }
}
