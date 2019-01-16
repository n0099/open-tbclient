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
    private int hLN;
    private ProgressView hLO;
    protected List<a> hLP;
    private boolean hLQ;
    private RecordVideoActivity hLc;
    private int mProgress;
    private int mStatus = 1;

    /* loaded from: classes5.dex */
    public interface a {
        void wT(int i);
    }

    public i(RecordVideoActivity recordVideoActivity) {
        this.hLc = recordVideoActivity;
        if (this.hLc != null) {
            ImageView imageView = (ImageView) this.hLc.findViewById(e.g.camera_switch);
            ImageView imageView2 = (ImageView) this.hLc.findViewById(e.g.flash_switch);
            this.hLO = (ProgressView) this.hLc.findViewById(e.g.video_progress_view);
            this.hLO.setListener(new AnonymousClass1());
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
            if (i == 100 && i.this.hLc != null && (hVar = i.this.hLc.hKC) != null && (bLy = hVar.bLy()) != null) {
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
                                    if (i.this.hLc != null) {
                                        i.this.hLc.bMo();
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
                if (i.this.hLc != null) {
                    i.this.hLc.bMo();
                }
            }
        }
    }

    public int getVideoDuration() {
        return this.hLN;
    }

    public void startRecord() {
        if (!this.hLQ) {
            if (this.hLO != null) {
                this.hLO.setVisibility(0);
                this.hLO.setCurrentState(ProgressView.State.START);
            }
            if (!this.hLQ) {
                this.hLQ = true;
                this.SG = System.currentTimeMillis();
            }
            if (this.hLc != null && this.hLc.hKC != null) {
                this.hLc.hKC.startRecord();
                if (this.hLc.hMF != null) {
                    this.hLc.hMF.wU(this.hLN);
                }
            }
        }
    }

    public boolean bLP() {
        if (this.hLc.hMF != null) {
            return this.hLc.hMF.bLP();
        }
        return false;
    }

    public void stopRecord() {
        if (this.hLQ) {
            if (this.hLO != null) {
                this.hLO.setCurrentState(ProgressView.State.PAUSE);
            }
            this.hLQ = false;
            this.hLN = (int) (this.hLN + (System.currentTimeMillis() - this.SG));
            if (this.hLO != null && this.hLO.getLastProgress() != this.hLN) {
                this.hLO.wR(this.hLN);
            }
            if (this.hLc != null && this.hLc.hKC != null) {
                this.hLc.hKC.stopRecord();
            }
        }
    }

    public void bLQ() {
        if (!this.hLQ && this.hLO != null) {
            this.hLO.setCurrentState(ProgressView.State.ROLLBACK);
        }
    }

    public void bLR() {
        if (this.hLO != null) {
            this.hLO.setCurrentState(ProgressView.State.DELETE);
        }
        this.hLN = this.hLO.getLastProgress();
        if (this.hLc.hKC != null) {
            this.hLc.hKC.bLA();
        }
    }

    public boolean onBackPressed() {
        return this.hLO.bLO();
    }

    public int getStatus() {
        return this.mStatus;
    }

    public void setStatus(int i) {
        File[] listFiles;
        this.mStatus = i;
        if (i == 1) {
            this.hLO.setVisibility(4);
            this.hLO.reset();
            this.hLN = 0;
            File file = new File(com.baidu.tieba.video.c.hEa);
            if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
                for (File file2 : listFiles) {
                    if (file2.getPath().startsWith("rec_tmp_")) {
                        file2.delete();
                    }
                }
            }
        }
        if (this.hLP != null) {
            for (a aVar : this.hLP) {
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
        if (this.hLP == null) {
            this.hLP = new ArrayList();
        }
        this.hLP.add(aVar);
    }
}
