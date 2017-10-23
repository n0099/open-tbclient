package com.baidu.tieba.video.record;

import android.widget.ImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.video.record.ProgressView;
/* loaded from: classes2.dex */
public class i {
    private long Ja;
    private int gzM;
    private ProgressView gzN;
    private boolean gzO;
    private RecordVideoActivity gzg;
    private int mProgress;
    private int mStatus = 1;

    public i(RecordVideoActivity recordVideoActivity) {
        this.gzg = recordVideoActivity;
        if (this.gzg != null) {
            ImageView imageView = (ImageView) this.gzg.findViewById(d.h.camera_switch);
            ImageView imageView2 = (ImageView) this.gzg.findViewById(d.h.flash_switch);
            this.gzN = (ProgressView) this.gzg.findViewById(d.h.video_progress_view);
            this.gzN.setListener(new ProgressView.a() { // from class: com.baidu.tieba.video.record.i.1
                @Override // com.baidu.tieba.video.record.ProgressView.a
                public void uD(int i) {
                    i.this.mProgress = i;
                    if (i == 100) {
                        i.this.stopRecord();
                        if (i.this.gzg != null) {
                            i.this.gzg.bxv();
                        }
                    }
                }
            });
            if (!a.ne(true)) {
                imageView2.setVisibility(4);
            }
            if (!a.c(recordVideoActivity.getPackageManager())) {
                imageView.setVisibility(8);
            }
        }
    }

    public int getVideoDuration() {
        return this.gzM;
    }

    public void startRecord() {
        if (!this.gzO) {
            if (this.gzN != null) {
                this.gzN.setVisibility(0);
                this.gzN.setCurrentState(ProgressView.State.START);
            }
            if (!this.gzO) {
                this.gzO = true;
                this.Ja = System.currentTimeMillis();
            }
            if (this.gzg != null && this.gzg.gyK != null) {
                this.gzg.gyK.startRecord();
            }
        }
    }

    public void stopRecord() {
        if (this.gzO) {
            if (this.gzN != null) {
                this.gzN.setCurrentState(ProgressView.State.PAUSE);
            }
            this.gzO = false;
            this.gzM = (int) (this.gzM + (System.currentTimeMillis() - this.Ja));
            if (this.gzN != null && this.gzN.getLastProgress() != this.gzM) {
                this.gzN.uC(this.gzM);
            }
            if (this.gzg != null && this.gzg.gyK != null) {
                this.gzg.gyK.stopRecord();
            }
        }
    }

    public void bxi() {
        if (!this.gzO && this.gzN != null) {
            this.gzN.setCurrentState(ProgressView.State.ROLLBACK);
        }
    }

    public void bxj() {
        if (this.gzN != null) {
            this.gzN.setCurrentState(ProgressView.State.DELETE);
        }
        this.gzM = this.gzN.getLastProgress();
        if (this.gzg.gyK != null) {
            this.gzg.gyK.bwV();
        }
    }

    public boolean onBackPressed() {
        return this.gzN.bxh();
    }

    public int getStatus() {
        return this.mStatus;
    }

    public void setStatus(int i) {
        this.mStatus = i;
        if (i == 1) {
            this.gzN.setVisibility(4);
            this.gzN.reset();
            this.gzM = 0;
        }
    }

    public boolean isRecording() {
        int status = getStatus();
        return status == 2 || status == 7;
    }

    public int getProgress() {
        return this.mProgress;
    }

    public void Lx() {
        this.mProgress = 0;
    }
}
