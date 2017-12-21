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
    private long Ir;
    private int gXR;
    private ProgressView gXS;
    protected List<a> gXT;
    private boolean gXU;
    private RecordVideoActivity gXd;
    private int mProgress;
    private int mStatus = 1;

    /* loaded from: classes2.dex */
    public interface a {
        void vD(int i);
    }

    public j(RecordVideoActivity recordVideoActivity) {
        this.gXd = recordVideoActivity;
        if (this.gXd != null) {
            ImageView imageView = (ImageView) this.gXd.findViewById(d.g.camera_switch);
            ImageView imageView2 = (ImageView) this.gXd.findViewById(d.g.flash_switch);
            this.gXS = (ProgressView) this.gXd.findViewById(d.g.video_progress_view);
            this.gXS.setListener(new AnonymousClass1());
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
            if (i == 100 && j.this.gXd != null && (iVar = j.this.gXd.gWF) != null && (bDx = iVar.bDx()) != null) {
                if (bDx instanceof g) {
                    bDx.setOnEncoderStatusUpdateListener(new c.InterfaceC0166c() { // from class: com.baidu.tieba.video.record.j.1.1
                        @Override // com.faceunity.a.c.InterfaceC0166c
                        public void bDU() {
                        }

                        @Override // com.faceunity.a.c.InterfaceC0166c
                        public void bDV() {
                            com.baidu.adp.lib.g.e.fP().post(new Runnable() { // from class: com.baidu.tieba.video.record.j.1.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (j.this.gXd != null) {
                                        j.this.gXd.bEa();
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
                if (j.this.gXd != null) {
                    j.this.gXd.bEa();
                }
            }
        }
    }

    public int getVideoDuration() {
        return this.gXR;
    }

    public void startRecord() {
        if (!this.gXU) {
            if (this.gXS != null) {
                this.gXS.setVisibility(0);
                this.gXS.setCurrentState(ProgressView.State.START);
            }
            if (!this.gXU) {
                this.gXU = true;
                this.Ir = System.currentTimeMillis();
            }
            if (this.gXd != null && this.gXd.gWF != null) {
                this.gXd.gWF.startRecord();
                if (this.gXd.gYJ != null) {
                    this.gXd.gYJ.vE(this.gXR);
                }
            }
        }
    }

    public void stopRecord() {
        if (this.gXU) {
            if (this.gXS != null) {
                this.gXS.setCurrentState(ProgressView.State.PAUSE);
            }
            this.gXU = false;
            this.gXR = (int) (this.gXR + (System.currentTimeMillis() - this.Ir));
            if (this.gXS != null && this.gXS.getLastProgress() != this.gXR) {
                this.gXS.vB(this.gXR);
            }
            if (this.gXd != null && this.gXd.gWF != null) {
                this.gXd.gWF.stopRecord();
            }
        }
    }

    public void bDS() {
        if (!this.gXU && this.gXS != null) {
            this.gXS.setCurrentState(ProgressView.State.ROLLBACK);
        }
    }

    public void bDT() {
        if (this.gXS != null) {
            this.gXS.setCurrentState(ProgressView.State.DELETE);
        }
        this.gXR = this.gXS.getLastProgress();
        if (this.gXd.gWF != null) {
            this.gXd.gWF.bDA();
        }
    }

    public boolean onBackPressed() {
        return this.gXS.bDR();
    }

    public int getStatus() {
        return this.mStatus;
    }

    public void setStatus(int i) {
        File[] listFiles;
        this.mStatus = i;
        if (i == 1) {
            this.gXS.setVisibility(4);
            this.gXS.reset();
            this.gXR = 0;
            File file = new File(com.baidu.tieba.video.b.gPG);
            if (file.exists() && file.isDirectory()) {
                for (File file2 : file.listFiles()) {
                    if (file2.getPath().startsWith("rec_tmp_")) {
                        file2.delete();
                    }
                }
            }
        }
        if (this.gXT != null) {
            for (a aVar : this.gXT) {
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
        this.gXS.reset();
    }

    public void a(a aVar) {
        if (this.gXT == null) {
            this.gXT = new ArrayList();
        }
        this.gXT.add(aVar);
    }
}
