package com.baidu.tieba.video.record;

import android.widget.ImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.video.record.ProgressView;
/* loaded from: classes2.dex */
public class i {
    private long IZ;
    private int gAb;
    private ProgressView gAc;
    private boolean gAd;
    private RecordVideoActivity gzv;
    private int mProgress;
    private int mStatus = 1;

    public i(RecordVideoActivity recordVideoActivity) {
        this.gzv = recordVideoActivity;
        if (this.gzv != null) {
            ImageView imageView = (ImageView) this.gzv.findViewById(d.h.camera_switch);
            ImageView imageView2 = (ImageView) this.gzv.findViewById(d.h.flash_switch);
            this.gAc = (ProgressView) this.gzv.findViewById(d.h.video_progress_view);
            this.gAc.setListener(new ProgressView.a() { // from class: com.baidu.tieba.video.record.i.1
                @Override // com.baidu.tieba.video.record.ProgressView.a
                public void uE(int i) {
                    i.this.mProgress = i;
                    if (i == 100) {
                        i.this.stopRecord();
                        if (i.this.gzv != null) {
                            i.this.gzv.bxD();
                        }
                    }
                }
            });
            if (!a.nf(true)) {
                imageView2.setVisibility(4);
            }
            if (!a.c(recordVideoActivity.getPackageManager())) {
                imageView.setVisibility(8);
            }
        }
    }

    public int getVideoDuration() {
        return this.gAb;
    }

    public void startRecord() {
        if (!this.gAd) {
            if (this.gAc != null) {
                this.gAc.setVisibility(0);
                this.gAc.setCurrentState(ProgressView.State.START);
            }
            if (!this.gAd) {
                this.gAd = true;
                this.IZ = System.currentTimeMillis();
            }
            if (this.gzv != null && this.gzv.gyY != null) {
                this.gzv.gyY.startRecord();
            }
        }
    }

    public void stopRecord() {
        if (this.gAd) {
            if (this.gAc != null) {
                this.gAc.setCurrentState(ProgressView.State.PAUSE);
            }
            this.gAd = false;
            this.gAb = (int) (this.gAb + (System.currentTimeMillis() - this.IZ));
            if (this.gAc != null && this.gAc.getLastProgress() != this.gAb) {
                this.gAc.uD(this.gAb);
            }
            if (this.gzv != null && this.gzv.gyY != null) {
                this.gzv.gyY.stopRecord();
            }
        }
    }

    public void bxq() {
        if (!this.gAd && this.gAc != null) {
            this.gAc.setCurrentState(ProgressView.State.ROLLBACK);
        }
    }

    public void bxr() {
        if (this.gAc != null) {
            this.gAc.setCurrentState(ProgressView.State.DELETE);
        }
        this.gAb = this.gAc.getLastProgress();
        if (this.gzv.gyY != null) {
            this.gzv.gyY.bxd();
        }
    }

    public boolean onBackPressed() {
        return this.gAc.bxp();
    }

    public int getStatus() {
        return this.mStatus;
    }

    public void setStatus(int i) {
        this.mStatus = i;
        if (i == 1) {
            this.gAc.setVisibility(4);
            this.gAc.reset();
            this.gAb = 0;
        }
    }

    public boolean isRecording() {
        int status = getStatus();
        return status == 2 || status == 7;
    }

    public int getProgress() {
        return this.mProgress;
    }

    public void LD() {
        this.mProgress = 0;
    }
}
