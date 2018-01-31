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
    private long axq;
    private int huR;
    private ProgressView huS;
    protected List<a> huT;
    private boolean huU;
    private RecordVideoActivity huf;
    private int mProgress;
    private int mStatus = 1;

    /* loaded from: classes2.dex */
    public interface a {
        void wV(int i);
    }

    public j(RecordVideoActivity recordVideoActivity) {
        this.huf = recordVideoActivity;
        if (this.huf != null) {
            ImageView imageView = (ImageView) this.huf.findViewById(d.g.camera_switch);
            ImageView imageView2 = (ImageView) this.huf.findViewById(d.g.flash_switch);
            this.huS = (ProgressView) this.huf.findViewById(d.g.video_progress_view);
            this.huS.setListener(new AnonymousClass1());
            if (!com.baidu.tieba.video.record.a.nh(true)) {
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
            final h bCv;
            j.this.mProgress = i;
            if (i == 100 && j.this.huf != null && (iVar = j.this.huf.htH) != null && (bCv = iVar.bCv()) != null) {
                if (bCv instanceof g) {
                    bCv.setOnEncoderStatusUpdateListener(new d.c() { // from class: com.baidu.tieba.video.record.j.1.1
                        @Override // com.faceunity.a.d.c
                        public void bCT() {
                        }

                        @Override // com.faceunity.a.d.c
                        public void bCU() {
                            com.baidu.adp.lib.g.e.ns().post(new Runnable() { // from class: com.baidu.tieba.video.record.j.1.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (j.this.huf != null) {
                                        j.this.huf.bCZ();
                                    }
                                }
                            });
                            bCv.setOnEncoderStatusUpdateListener(null);
                        }
                    });
                    j.this.stopRecord();
                    return;
                }
                j.this.stopRecord();
                if (j.this.huf != null) {
                    j.this.huf.bCZ();
                }
            }
        }
    }

    public int getVideoDuration() {
        return this.huR;
    }

    public void startRecord() {
        if (!this.huU) {
            if (this.huS != null) {
                this.huS.setVisibility(0);
                this.huS.setCurrentState(ProgressView.State.START);
            }
            if (!this.huU) {
                this.huU = true;
                this.axq = System.currentTimeMillis();
            }
            if (this.huf != null && this.huf.htH != null) {
                this.huf.htH.startRecord();
                if (this.huf.hvJ != null) {
                    this.huf.hvJ.wW(this.huR);
                }
            }
        }
    }

    public boolean bCQ() {
        if (this.huf.hvJ != null) {
            return this.huf.hvJ.bCQ();
        }
        return false;
    }

    public void stopRecord() {
        if (this.huU) {
            if (this.huS != null) {
                this.huS.setCurrentState(ProgressView.State.PAUSE);
            }
            this.huU = false;
            this.huR = (int) (this.huR + (System.currentTimeMillis() - this.axq));
            if (this.huS != null && this.huS.getLastProgress() != this.huR) {
                this.huS.wT(this.huR);
            }
            if (this.huf != null && this.huf.htH != null) {
                this.huf.htH.stopRecord();
            }
        }
    }

    public void bCR() {
        if (!this.huU && this.huS != null) {
            this.huS.setCurrentState(ProgressView.State.ROLLBACK);
        }
    }

    public void bCS() {
        if (this.huS != null) {
            this.huS.setCurrentState(ProgressView.State.DELETE);
        }
        this.huR = this.huS.getLastProgress();
        if (this.huf.htH != null) {
            this.huf.htH.bCy();
        }
    }

    public boolean onBackPressed() {
        return this.huS.bCP();
    }

    public int getStatus() {
        return this.mStatus;
    }

    public void setStatus(int i) {
        File[] listFiles;
        this.mStatus = i;
        if (i == 1) {
            this.huS.setVisibility(4);
            this.huS.reset();
            this.huR = 0;
            File file = new File(com.baidu.tieba.video.b.hmB);
            if (file.exists() && file.isDirectory()) {
                for (File file2 : file.listFiles()) {
                    if (file2.getPath().startsWith("rec_tmp_")) {
                        file2.delete();
                    }
                }
            }
        }
        if (this.huT != null) {
            for (a aVar : this.huT) {
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

    public void TL() {
        this.mProgress = 0;
        this.huS.reset();
    }

    public void a(a aVar) {
        if (this.huT == null) {
            this.huT = new ArrayList();
        }
        this.huT.add(aVar);
    }
}
