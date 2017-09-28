package com.baidu.tieba.video.record;

import android.widget.ImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.video.record.ProgressView;
/* loaded from: classes2.dex */
public class i {
    private long IZ;
    private int gAc;
    private ProgressView gAd;
    private boolean gAe;
    private RecordVideoActivity gzw;
    private int mProgress;
    private int mStatus = 1;

    public i(RecordVideoActivity recordVideoActivity) {
        this.gzw = recordVideoActivity;
        if (this.gzw != null) {
            ImageView imageView = (ImageView) this.gzw.findViewById(d.h.camera_switch);
            ImageView imageView2 = (ImageView) this.gzw.findViewById(d.h.flash_switch);
            this.gAd = (ProgressView) this.gzw.findViewById(d.h.video_progress_view);
            this.gAd.setListener(new ProgressView.a() { // from class: com.baidu.tieba.video.record.i.1
                @Override // com.baidu.tieba.video.record.ProgressView.a
                public void uE(int i) {
                    i.this.mProgress = i;
                    if (i == 100) {
                        i.this.stopRecord();
                        if (i.this.gzw != null) {
                            i.this.gzw.bxE();
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
        return this.gAc;
    }

    public void startRecord() {
        if (!this.gAe) {
            if (this.gAd != null) {
                this.gAd.setVisibility(0);
                this.gAd.setCurrentState(ProgressView.State.START);
            }
            if (!this.gAe) {
                this.gAe = true;
                this.IZ = System.currentTimeMillis();
            }
            if (this.gzw != null && this.gzw.gyZ != null) {
                this.gzw.gyZ.startRecord();
            }
        }
    }

    public void stopRecord() {
        if (this.gAe) {
            if (this.gAd != null) {
                this.gAd.setCurrentState(ProgressView.State.PAUSE);
            }
            this.gAe = false;
            this.gAc = (int) (this.gAc + (System.currentTimeMillis() - this.IZ));
            if (this.gAd != null && this.gAd.getLastProgress() != this.gAc) {
                this.gAd.uD(this.gAc);
            }
            if (this.gzw != null && this.gzw.gyZ != null) {
                this.gzw.gyZ.stopRecord();
            }
        }
    }

    public void bxr() {
        if (!this.gAe && this.gAd != null) {
            this.gAd.setCurrentState(ProgressView.State.ROLLBACK);
        }
    }

    public void bxs() {
        if (this.gAd != null) {
            this.gAd.setCurrentState(ProgressView.State.DELETE);
        }
        this.gAc = this.gAd.getLastProgress();
        if (this.gzw.gyZ != null) {
            this.gzw.gyZ.bxe();
        }
    }

    public boolean onBackPressed() {
        return this.gAd.bxq();
    }

    public int getStatus() {
        return this.mStatus;
    }

    public void setStatus(int i) {
        this.mStatus = i;
        if (i == 1) {
            this.gAd.setVisibility(4);
            this.gAd.reset();
            this.gAc = 0;
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
