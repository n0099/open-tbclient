package com.baidu.tieba.video.record;

import android.widget.ImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.video.record.ProgressView;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class j {
    private long Is;
    private RecordVideoActivity gUp;
    private int gVd;
    private ProgressView gVe;
    protected List<a> gVf;
    private boolean gVg;
    private int mProgress;
    private int mStatus = 1;

    /* loaded from: classes2.dex */
    public interface a {
        void vs(int i);
    }

    public j(RecordVideoActivity recordVideoActivity) {
        this.gUp = recordVideoActivity;
        if (this.gUp != null) {
            ImageView imageView = (ImageView) this.gUp.findViewById(d.g.camera_switch);
            ImageView imageView2 = (ImageView) this.gUp.findViewById(d.g.flash_switch);
            this.gVe = (ProgressView) this.gUp.findViewById(d.g.video_progress_view);
            this.gVe.setListener(new ProgressView.a() { // from class: com.baidu.tieba.video.record.j.1
                @Override // com.baidu.tieba.video.record.ProgressView.a
                public void vr(int i) {
                    j.this.mProgress = i;
                    if (i == 100) {
                        j.this.stopRecord();
                        if (j.this.gUp != null) {
                            j.this.gUp.bDr();
                        }
                    }
                }
            });
            if (!com.baidu.tieba.video.record.a.nG(true)) {
                imageView2.setVisibility(4);
            }
            if (!com.baidu.tieba.video.record.a.c(recordVideoActivity.getPackageManager())) {
                imageView.setVisibility(8);
            }
        }
    }

    public int getVideoDuration() {
        return this.gVd;
    }

    public void startRecord() {
        if (!this.gVg) {
            if (this.gVe != null) {
                this.gVe.setVisibility(0);
                this.gVe.setCurrentState(ProgressView.State.START);
            }
            if (!this.gVg) {
                this.gVg = true;
                this.Is = System.currentTimeMillis();
            }
            if (this.gUp != null && this.gUp.gTR != null) {
                this.gUp.gTR.startRecord();
                if (this.gUp.gVS != null) {
                    this.gUp.gVS.nK(this.gVd <= 0);
                }
            }
        }
    }

    public void stopRecord() {
        if (this.gVg) {
            if (this.gVe != null) {
                this.gVe.setCurrentState(ProgressView.State.PAUSE);
            }
            this.gVg = false;
            this.gVd = (int) (this.gVd + (System.currentTimeMillis() - this.Is));
            if (this.gVe != null && this.gVe.getLastProgress() != this.gVd) {
                this.gVe.vq(this.gVd);
            }
            if (this.gUp != null && this.gUp.gTR != null) {
                this.gUp.gTR.stopRecord();
            }
        }
    }

    public void bDl() {
        if (!this.gVg && this.gVe != null) {
            this.gVe.setCurrentState(ProgressView.State.ROLLBACK);
        }
    }

    public void bDm() {
        if (this.gVe != null) {
            this.gVe.setCurrentState(ProgressView.State.DELETE);
        }
        this.gVd = this.gVe.getLastProgress();
        if (this.gUp.gTR != null) {
            this.gUp.gTR.bCT();
        }
    }

    public boolean onBackPressed() {
        return this.gVe.bDk();
    }

    public int getStatus() {
        return this.mStatus;
    }

    public void setStatus(int i) {
        File[] listFiles;
        this.mStatus = i;
        if (i == 1) {
            this.gVe.setVisibility(4);
            this.gVe.reset();
            this.gVd = 0;
            File file = new File(com.baidu.tieba.video.b.gMT);
            if (file.exists() && file.isDirectory()) {
                for (File file2 : file.listFiles()) {
                    if (file2.getPath().startsWith("rec_tmp_")) {
                        file2.delete();
                    }
                }
            }
        }
        if (this.gVf != null) {
            for (a aVar : this.gVf) {
                aVar.vs(this.mStatus);
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
        this.gVe.reset();
    }

    public void a(a aVar) {
        if (this.gVf == null) {
            this.gVf = new ArrayList();
        }
        this.gVf.add(aVar);
    }
}
