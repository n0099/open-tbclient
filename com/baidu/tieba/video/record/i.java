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
    private RecordVideoActivity gJV;
    private int gKB;
    private ProgressView gKC;
    protected List<a> gKD;
    private boolean gKE;
    private int mProgress;
    private int mStatus = 1;

    /* loaded from: classes2.dex */
    public interface a {
        void uZ(int i);
    }

    public i(RecordVideoActivity recordVideoActivity) {
        this.gJV = recordVideoActivity;
        if (this.gJV != null) {
            ImageView imageView = (ImageView) this.gJV.findViewById(d.g.camera_switch);
            ImageView imageView2 = (ImageView) this.gJV.findViewById(d.g.flash_switch);
            this.gKC = (ProgressView) this.gJV.findViewById(d.g.video_progress_view);
            this.gKC.setListener(new ProgressView.a() { // from class: com.baidu.tieba.video.record.i.1
                @Override // com.baidu.tieba.video.record.ProgressView.a
                public void uY(int i) {
                    i.this.mProgress = i;
                    if (i == 100) {
                        i.this.stopRecord();
                        if (i.this.gJV != null) {
                            i.this.gJV.bAO();
                        }
                    }
                }
            });
            if (!com.baidu.tieba.video.record.a.nh(true)) {
                imageView2.setVisibility(4);
            }
            if (!com.baidu.tieba.video.record.a.c(recordVideoActivity.getPackageManager())) {
                imageView.setVisibility(8);
            }
        }
    }

    public int getVideoDuration() {
        return this.gKB;
    }

    public void startRecord() {
        if (!this.gKE) {
            if (this.gKC != null) {
                this.gKC.setVisibility(0);
                this.gKC.setCurrentState(ProgressView.State.START);
            }
            if (!this.gKE) {
                this.gKE = true;
                this.Is = System.currentTimeMillis();
            }
            if (this.gJV != null && this.gJV.gJz != null) {
                this.gJV.gJz.startRecord();
                if (this.gJV.gLf != null) {
                    this.gJV.gLf.nk(this.gKB <= 0);
                }
            }
        }
    }

    public void stopRecord() {
        if (this.gKE) {
            if (this.gKC != null) {
                this.gKC.setCurrentState(ProgressView.State.PAUSE);
            }
            this.gKE = false;
            this.gKB = (int) (this.gKB + (System.currentTimeMillis() - this.Is));
            if (this.gKC != null && this.gKC.getLastProgress() != this.gKB) {
                this.gKC.uX(this.gKB);
            }
            if (this.gJV != null && this.gJV.gJz != null) {
                this.gJV.gJz.stopRecord();
            }
        }
    }

    public void bAK() {
        if (!this.gKE && this.gKC != null) {
            this.gKC.setCurrentState(ProgressView.State.ROLLBACK);
        }
    }

    public void bAL() {
        if (this.gKC != null) {
            this.gKC.setCurrentState(ProgressView.State.DELETE);
        }
        this.gKB = this.gKC.getLastProgress();
        if (this.gJV.gJz != null) {
            this.gJV.gJz.bAx();
        }
    }

    public boolean onBackPressed() {
        return this.gKC.bAJ();
    }

    public int getStatus() {
        return this.mStatus;
    }

    public void setStatus(int i) {
        File[] listFiles;
        this.mStatus = i;
        if (i == 1) {
            this.gKC.setVisibility(4);
            this.gKC.reset();
            this.gKB = 0;
            File file = new File(com.baidu.tieba.video.b.gDB);
            if (file.exists() && file.isDirectory()) {
                for (File file2 : file.listFiles()) {
                    if (file2.getPath().startsWith("rec_tmp_")) {
                        file2.delete();
                    }
                }
            }
        }
        if (this.gKD != null) {
            for (a aVar : this.gKD) {
                aVar.uZ(this.mStatus);
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

    public void LR() {
        this.mProgress = 0;
    }

    public void a(a aVar) {
        if (this.gKD == null) {
            this.gKD = new ArrayList();
        }
        this.gKD.add(aVar);
    }
}
