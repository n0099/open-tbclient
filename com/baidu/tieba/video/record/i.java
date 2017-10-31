package com.baidu.tieba.video.record;

import android.widget.ImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.video.record.ProgressView;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class i {
    private long Is;
    private RecordVideoActivity gIN;
    private int gJt;
    private ProgressView gJu;
    protected List<a> gJv;
    private boolean gJw;
    private int mProgress;
    private int mStatus = 1;

    /* loaded from: classes2.dex */
    public interface a {
        void uV(int i);
    }

    public i(RecordVideoActivity recordVideoActivity) {
        this.gIN = recordVideoActivity;
        if (this.gIN != null) {
            ImageView imageView = (ImageView) this.gIN.findViewById(d.g.camera_switch);
            ImageView imageView2 = (ImageView) this.gIN.findViewById(d.g.flash_switch);
            this.gJu = (ProgressView) this.gIN.findViewById(d.g.video_progress_view);
            this.gJu.setListener(new ProgressView.a() { // from class: com.baidu.tieba.video.record.i.1
                @Override // com.baidu.tieba.video.record.ProgressView.a
                public void uU(int i) {
                    i.this.mProgress = i;
                    if (i == 100) {
                        i.this.stopRecord();
                        if (i.this.gIN != null) {
                            i.this.gIN.bAC();
                        }
                    }
                }
            });
            if (!com.baidu.tieba.video.record.a.mZ(true)) {
                imageView2.setVisibility(4);
            }
            if (!com.baidu.tieba.video.record.a.c(recordVideoActivity.getPackageManager())) {
                imageView.setVisibility(8);
            }
        }
    }

    public int getVideoDuration() {
        return this.gJt;
    }

    public void startRecord() {
        if (!this.gJw) {
            if (this.gJu != null) {
                this.gJu.setVisibility(0);
                this.gJu.setCurrentState(ProgressView.State.START);
            }
            if (!this.gJw) {
                this.gJw = true;
                this.Is = System.currentTimeMillis();
            }
            if (this.gIN != null && this.gIN.gIr != null) {
                this.gIN.gIr.startRecord();
                if (this.gIN.gJX != null) {
                    this.gIN.gJX.nc(this.gJt <= 0);
                }
            }
        }
    }

    public void stopRecord() {
        if (this.gJw) {
            if (this.gJu != null) {
                this.gJu.setCurrentState(ProgressView.State.PAUSE);
            }
            this.gJw = false;
            this.gJt = (int) (this.gJt + (System.currentTimeMillis() - this.Is));
            if (this.gJu != null && this.gJu.getLastProgress() != this.gJt) {
                this.gJu.uT(this.gJt);
            }
            if (this.gIN != null && this.gIN.gIr != null) {
                this.gIN.gIr.stopRecord();
            }
        }
    }

    public void bAy() {
        if (!this.gJw && this.gJu != null) {
            this.gJu.setCurrentState(ProgressView.State.ROLLBACK);
        }
    }

    public void bAz() {
        if (this.gJu != null) {
            this.gJu.setCurrentState(ProgressView.State.DELETE);
        }
        this.gJt = this.gJu.getLastProgress();
        if (this.gIN.gIr != null) {
            this.gIN.gIr.bAl();
        }
    }

    public boolean onBackPressed() {
        return this.gJu.bAx();
    }

    public int getStatus() {
        return this.mStatus;
    }

    public void setStatus(int i) {
        File[] listFiles;
        this.mStatus = i;
        if (i == 1) {
            this.gJu.setVisibility(4);
            this.gJu.reset();
            this.gJt = 0;
            File file = new File(com.baidu.tieba.video.b.gCt);
            if (file.exists() && file.isDirectory()) {
                for (File file2 : file.listFiles()) {
                    if (file2.getPath().startsWith("rec_tmp_")) {
                        file2.delete();
                    }
                }
            }
        }
        if (this.gJv != null) {
            for (a aVar : this.gJv) {
                aVar.uV(this.mStatus);
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

    public void LG() {
        this.mProgress = 0;
    }

    public void a(a aVar) {
        if (this.gJv == null) {
            this.gJv = new ArrayList();
        }
        this.gJv.add(aVar);
    }
}
