package com.baidu.tieba.video.record;

import android.widget.ImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.video.record.ProgressView;
import com.faceunity.a.d;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class i {
    private long Ts;
    private RecordVideoActivity jBC;
    private int jCn;
    private ProgressView jCo;
    protected List<a> jCp;
    private boolean jCq;
    private int mProgress;
    private int mStatus = 1;

    /* loaded from: classes5.dex */
    public interface a {
        void Cs(int i);
    }

    public i(RecordVideoActivity recordVideoActivity) {
        this.jBC = recordVideoActivity;
        if (this.jBC != null) {
            ImageView imageView = (ImageView) this.jBC.findViewById(R.id.camera_switch);
            ImageView imageView2 = (ImageView) this.jBC.findViewById(R.id.flash_switch);
            this.jCo = (ProgressView) this.jBC.findViewById(R.id.video_progress_view);
            this.jCo.setListener(new AnonymousClass1());
            if (!com.baidu.tieba.video.record.a.rJ(true)) {
                imageView2.setVisibility(4);
            }
            if (!com.baidu.tieba.video.record.a.b(recordVideoActivity.getPackageManager())) {
                imageView.setVisibility(8);
            }
        }
    }

    /* renamed from: com.baidu.tieba.video.record.i$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    class AnonymousClass1 implements ProgressView.a {
        AnonymousClass1() {
        }

        @Override // com.baidu.tieba.video.record.ProgressView.a
        public void Cr(int i) {
            h hVar;
            final g cwm;
            i.this.mProgress = i;
            if (i == 100 && i.this.jBC != null && (hVar = i.this.jBC.jBe) != null && (cwm = hVar.cwm()) != null) {
                if (cwm instanceof GLVideoPreviewView) {
                    cwm.setOnEncoderStatusUpdateListener(new d.c() { // from class: com.baidu.tieba.video.record.i.1.1
                        @Override // com.faceunity.a.d.c
                        public void cwH() {
                        }

                        @Override // com.faceunity.a.d.c
                        public void cwI() {
                            com.baidu.adp.lib.g.e.iK().post(new Runnable() { // from class: com.baidu.tieba.video.record.i.1.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (i.this.jBC != null) {
                                        i.this.jBC.cxc();
                                    }
                                }
                            });
                            cwm.setOnEncoderStatusUpdateListener(null);
                        }
                    });
                    i.this.stopRecord();
                    return;
                }
                i.this.stopRecord();
                if (i.this.jBC != null) {
                    i.this.jBC.cxc();
                }
            }
        }
    }

    public int getVideoDuration() {
        return this.jCn;
    }

    public void startRecord() {
        if (!this.jCq) {
            if (this.jCo != null) {
                this.jCo.setVisibility(0);
                this.jCo.setCurrentState(ProgressView.State.START);
            }
            if (!this.jCq) {
                this.jCq = true;
                this.Ts = System.currentTimeMillis();
            }
            if (this.jBC != null && this.jBC.jBe != null) {
                this.jBC.jBe.startRecord();
                if (this.jBC.jDf != null) {
                    this.jBC.jDf.Ct(this.jCn);
                }
            }
        }
    }

    public boolean cwD() {
        if (this.jBC.jDf != null) {
            return this.jBC.jDf.cwD();
        }
        return false;
    }

    public void stopRecord() {
        if (this.jCq) {
            if (this.jCo != null) {
                this.jCo.setCurrentState(ProgressView.State.PAUSE);
            }
            this.jCq = false;
            this.jCn = (int) (this.jCn + (System.currentTimeMillis() - this.Ts));
            if (this.jCo != null && this.jCo.getLastProgress() != this.jCn) {
                this.jCo.Cq(this.jCn);
            }
            if (this.jBC != null && this.jBC.jBe != null) {
                this.jBC.jBe.stopRecord();
            }
        }
    }

    public void cwE() {
        if (!this.jCq && this.jCo != null) {
            this.jCo.setCurrentState(ProgressView.State.ROLLBACK);
        }
    }

    public void cwF() {
        if (this.jCo != null) {
            this.jCo.setCurrentState(ProgressView.State.DELETE);
        }
        this.jCn = this.jCo.getLastProgress();
        if (this.jBC.jBe != null) {
            this.jBC.jBe.cwo();
        }
    }

    public boolean onBackPressed() {
        return this.jCo.cwC();
    }

    public int getStatus() {
        return this.mStatus;
    }

    public void setStatus(int i) {
        File[] listFiles;
        this.mStatus = i;
        if (i == 1) {
            this.jCo.setVisibility(4);
            this.jCo.reset();
            this.jCn = 0;
            File file = new File(com.baidu.tieba.video.c.juG);
            if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
                for (File file2 : listFiles) {
                    if (file2.getPath().startsWith("rec_tmp_")) {
                        file2.delete();
                    }
                }
            }
        }
        if (this.jCp != null) {
            for (a aVar : this.jCp) {
                aVar.Cs(this.mStatus);
            }
        }
    }

    public boolean alC() {
        int status = getStatus();
        return status == 2 || status == 7;
    }

    public boolean cwG() {
        return this.mStatus == 6;
    }

    public int getProgress() {
        return this.mProgress;
    }

    public void a(a aVar) {
        if (this.jCp == null) {
            this.jCp = new ArrayList();
        }
        this.jCp.add(aVar);
    }
}
