package com.baidu.tieba.video.record;

import android.widget.ImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.video.record.ProgressView;
import com.faceunity.a.c;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class j {
    private long Iq;
    private RecordVideoActivity gWY;
    private int gXM;
    private ProgressView gXN;
    protected List<a> gXO;
    private boolean gXP;
    private int mProgress;
    private int mStatus = 1;

    /* loaded from: classes2.dex */
    public interface a {
        void vD(int i);
    }

    public j(RecordVideoActivity recordVideoActivity) {
        this.gWY = recordVideoActivity;
        if (this.gWY != null) {
            ImageView imageView = (ImageView) this.gWY.findViewById(d.g.camera_switch);
            ImageView imageView2 = (ImageView) this.gWY.findViewById(d.g.flash_switch);
            this.gXN = (ProgressView) this.gWY.findViewById(d.g.video_progress_view);
            this.gXN.setListener(new AnonymousClass1());
            if (!com.baidu.tieba.video.record.a.nI(true)) {
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
        public void vC(int i) {
            i iVar;
            final h bDx;
            j.this.mProgress = i;
            if (i == 100 && j.this.gWY != null && (iVar = j.this.gWY.gWA) != null && (bDx = iVar.bDx()) != null) {
                if (bDx instanceof g) {
                    bDx.setOnEncoderStatusUpdateListener(new c.InterfaceC0167c() { // from class: com.baidu.tieba.video.record.j.1.1
                        @Override // com.faceunity.a.c.InterfaceC0167c
                        public void bDU() {
                        }

                        @Override // com.faceunity.a.c.InterfaceC0167c
                        public void bDV() {
                            com.baidu.adp.lib.g.e.fP().post(new Runnable() { // from class: com.baidu.tieba.video.record.j.1.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (j.this.gWY != null) {
                                        j.this.gWY.bEa();
                                    }
                                }
                            });
                            bDx.setOnEncoderStatusUpdateListener(null);
                        }
                    });
                    j.this.stopRecord();
                    return;
                }
                j.this.stopRecord();
                if (j.this.gWY != null) {
                    j.this.gWY.bEa();
                }
            }
        }
    }

    public int getVideoDuration() {
        return this.gXM;
    }

    public void startRecord() {
        if (!this.gXP) {
            if (this.gXN != null) {
                this.gXN.setVisibility(0);
                this.gXN.setCurrentState(ProgressView.State.START);
            }
            if (!this.gXP) {
                this.gXP = true;
                this.Iq = System.currentTimeMillis();
            }
            if (this.gWY != null && this.gWY.gWA != null) {
                this.gWY.gWA.startRecord();
                if (this.gWY.gYE != null) {
                    this.gWY.gYE.vE(this.gXM);
                }
            }
        }
    }

    public void stopRecord() {
        if (this.gXP) {
            if (this.gXN != null) {
                this.gXN.setCurrentState(ProgressView.State.PAUSE);
            }
            this.gXP = false;
            this.gXM = (int) (this.gXM + (System.currentTimeMillis() - this.Iq));
            if (this.gXN != null && this.gXN.getLastProgress() != this.gXM) {
                this.gXN.vB(this.gXM);
            }
            if (this.gWY != null && this.gWY.gWA != null) {
                this.gWY.gWA.stopRecord();
            }
        }
    }

    public void bDS() {
        if (!this.gXP && this.gXN != null) {
            this.gXN.setCurrentState(ProgressView.State.ROLLBACK);
        }
    }

    public void bDT() {
        if (this.gXN != null) {
            this.gXN.setCurrentState(ProgressView.State.DELETE);
        }
        this.gXM = this.gXN.getLastProgress();
        if (this.gWY.gWA != null) {
            this.gWY.gWA.bDA();
        }
    }

    public boolean onBackPressed() {
        return this.gXN.bDR();
    }

    public int getStatus() {
        return this.mStatus;
    }

    public void setStatus(int i) {
        File[] listFiles;
        this.mStatus = i;
        if (i == 1) {
            this.gXN.setVisibility(4);
            this.gXN.reset();
            this.gXM = 0;
            File file = new File(com.baidu.tieba.video.b.gPB);
            if (file.exists() && file.isDirectory()) {
                for (File file2 : file.listFiles()) {
                    if (file2.getPath().startsWith("rec_tmp_")) {
                        file2.delete();
                    }
                }
            }
        }
        if (this.gXO != null) {
            for (a aVar : this.gXO) {
                aVar.vD(this.mStatus);
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

    public void Mw() {
        this.mProgress = 0;
        this.gXN.reset();
    }

    public void a(a aVar) {
        if (this.gXO == null) {
            this.gXO = new ArrayList();
        }
        this.gXO.add(aVar);
    }
}
