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
    private long axp;
    private RecordVideoActivity hvu;
    private int hwf;
    private ProgressView hwg;
    protected List<a> hwh;
    private boolean hwi;
    private int mProgress;
    private int mStatus = 1;

    /* loaded from: classes2.dex */
    public interface a {
        void wU(int i);
    }

    public j(RecordVideoActivity recordVideoActivity) {
        this.hvu = recordVideoActivity;
        if (this.hvu != null) {
            ImageView imageView = (ImageView) this.hvu.findViewById(d.g.camera_switch);
            ImageView imageView2 = (ImageView) this.hvu.findViewById(d.g.flash_switch);
            this.hwg = (ProgressView) this.hvu.findViewById(d.g.video_progress_view);
            this.hwg.setListener(new AnonymousClass1());
            if (!com.baidu.tieba.video.record.a.np(true)) {
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
        public void wT(int i) {
            i iVar;
            final h bDe;
            j.this.mProgress = i;
            if (i == 100 && j.this.hvu != null && (iVar = j.this.hvu.huW) != null && (bDe = iVar.bDe()) != null) {
                if (bDe instanceof g) {
                    bDe.setOnEncoderStatusUpdateListener(new d.c() { // from class: com.baidu.tieba.video.record.j.1.1
                        @Override // com.faceunity.a.d.c
                        public void bDB() {
                        }

                        @Override // com.faceunity.a.d.c
                        public void bDC() {
                            com.baidu.adp.lib.g.e.ns().post(new Runnable() { // from class: com.baidu.tieba.video.record.j.1.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (j.this.hvu != null) {
                                        j.this.hvu.bDH();
                                    }
                                }
                            });
                            bDe.setOnEncoderStatusUpdateListener(null);
                        }
                    });
                    j.this.stopRecord();
                    return;
                }
                j.this.stopRecord();
                if (j.this.hvu != null) {
                    j.this.hvu.bDH();
                }
            }
        }
    }

    public int getVideoDuration() {
        return this.hwf;
    }

    public void startRecord() {
        if (!this.hwi) {
            if (this.hwg != null) {
                this.hwg.setVisibility(0);
                this.hwg.setCurrentState(ProgressView.State.START);
            }
            if (!this.hwi) {
                this.hwi = true;
                this.axp = System.currentTimeMillis();
            }
            if (this.hvu != null && this.hvu.huW != null) {
                this.hvu.huW.startRecord();
                if (this.hvu.hwX != null) {
                    this.hvu.hwX.wV(this.hwf);
                }
            }
        }
    }

    public boolean bDy() {
        if (this.hvu.hwX != null) {
            return this.hvu.hwX.bDy();
        }
        return false;
    }

    public void stopRecord() {
        if (this.hwi) {
            if (this.hwg != null) {
                this.hwg.setCurrentState(ProgressView.State.PAUSE);
            }
            this.hwi = false;
            this.hwf = (int) (this.hwf + (System.currentTimeMillis() - this.axp));
            if (this.hwg != null && this.hwg.getLastProgress() != this.hwf) {
                this.hwg.wS(this.hwf);
            }
            if (this.hvu != null && this.hvu.huW != null) {
                this.hvu.huW.stopRecord();
            }
        }
    }

    public void bDz() {
        if (!this.hwi && this.hwg != null) {
            this.hwg.setCurrentState(ProgressView.State.ROLLBACK);
        }
    }

    public void bDA() {
        if (this.hwg != null) {
            this.hwg.setCurrentState(ProgressView.State.DELETE);
        }
        this.hwf = this.hwg.getLastProgress();
        if (this.hvu.huW != null) {
            this.hvu.huW.bDh();
        }
    }

    public boolean onBackPressed() {
        return this.hwg.bDx();
    }

    public int getStatus() {
        return this.mStatus;
    }

    public void setStatus(int i) {
        File[] listFiles;
        this.mStatus = i;
        if (i == 1) {
            this.hwg.setVisibility(4);
            this.hwg.reset();
            this.hwf = 0;
            File file = new File(com.baidu.tieba.video.b.hnQ);
            if (file.exists() && file.isDirectory()) {
                for (File file2 : file.listFiles()) {
                    if (file2.getPath().startsWith("rec_tmp_")) {
                        file2.delete();
                    }
                }
            }
        }
        if (this.hwh != null) {
            for (a aVar : this.hwh) {
                aVar.wU(this.mStatus);
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

    public void UD() {
        this.mProgress = 0;
        this.hwg.reset();
    }

    public void a(a aVar) {
        if (this.hwh == null) {
            this.hwh = new ArrayList();
        }
        this.hwh.add(aVar);
    }
}
