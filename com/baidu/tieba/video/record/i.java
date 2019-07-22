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
    private RecordVideoActivity jAv;
    private int jBg;
    private ProgressView jBh;
    protected List<a> jBi;
    private boolean jBj;
    private int mProgress;
    private int mStatus = 1;

    /* loaded from: classes5.dex */
    public interface a {
        void Cq(int i);
    }

    public i(RecordVideoActivity recordVideoActivity) {
        this.jAv = recordVideoActivity;
        if (this.jAv != null) {
            ImageView imageView = (ImageView) this.jAv.findViewById(R.id.camera_switch);
            ImageView imageView2 = (ImageView) this.jAv.findViewById(R.id.flash_switch);
            this.jBh = (ProgressView) this.jAv.findViewById(R.id.video_progress_view);
            this.jBh.setListener(new AnonymousClass1());
            if (!com.baidu.tieba.video.record.a.rI(true)) {
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
        public void Cp(int i) {
            h hVar;
            final g cvQ;
            i.this.mProgress = i;
            if (i == 100 && i.this.jAv != null && (hVar = i.this.jAv.jzX) != null && (cvQ = hVar.cvQ()) != null) {
                if (cvQ instanceof GLVideoPreviewView) {
                    cvQ.setOnEncoderStatusUpdateListener(new d.c() { // from class: com.baidu.tieba.video.record.i.1.1
                        @Override // com.faceunity.a.d.c
                        public void cwl() {
                        }

                        @Override // com.faceunity.a.d.c
                        public void cwm() {
                            com.baidu.adp.lib.g.e.iK().post(new Runnable() { // from class: com.baidu.tieba.video.record.i.1.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (i.this.jAv != null) {
                                        i.this.jAv.cwG();
                                    }
                                }
                            });
                            cvQ.setOnEncoderStatusUpdateListener(null);
                        }
                    });
                    i.this.stopRecord();
                    return;
                }
                i.this.stopRecord();
                if (i.this.jAv != null) {
                    i.this.jAv.cwG();
                }
            }
        }
    }

    public int getVideoDuration() {
        return this.jBg;
    }

    public void startRecord() {
        if (!this.jBj) {
            if (this.jBh != null) {
                this.jBh.setVisibility(0);
                this.jBh.setCurrentState(ProgressView.State.START);
            }
            if (!this.jBj) {
                this.jBj = true;
                this.Ts = System.currentTimeMillis();
            }
            if (this.jAv != null && this.jAv.jzX != null) {
                this.jAv.jzX.startRecord();
                if (this.jAv.jBY != null) {
                    this.jAv.jBY.Cr(this.jBg);
                }
            }
        }
    }

    public boolean cwh() {
        if (this.jAv.jBY != null) {
            return this.jAv.jBY.cwh();
        }
        return false;
    }

    public void stopRecord() {
        if (this.jBj) {
            if (this.jBh != null) {
                this.jBh.setCurrentState(ProgressView.State.PAUSE);
            }
            this.jBj = false;
            this.jBg = (int) (this.jBg + (System.currentTimeMillis() - this.Ts));
            if (this.jBh != null && this.jBh.getLastProgress() != this.jBg) {
                this.jBh.Co(this.jBg);
            }
            if (this.jAv != null && this.jAv.jzX != null) {
                this.jAv.jzX.stopRecord();
            }
        }
    }

    public void cwi() {
        if (!this.jBj && this.jBh != null) {
            this.jBh.setCurrentState(ProgressView.State.ROLLBACK);
        }
    }

    public void cwj() {
        if (this.jBh != null) {
            this.jBh.setCurrentState(ProgressView.State.DELETE);
        }
        this.jBg = this.jBh.getLastProgress();
        if (this.jAv.jzX != null) {
            this.jAv.jzX.cvS();
        }
    }

    public boolean onBackPressed() {
        return this.jBh.cwg();
    }

    public int getStatus() {
        return this.mStatus;
    }

    public void setStatus(int i) {
        File[] listFiles;
        this.mStatus = i;
        if (i == 1) {
            this.jBh.setVisibility(4);
            this.jBh.reset();
            this.jBg = 0;
            File file = new File(com.baidu.tieba.video.c.jtz);
            if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
                for (File file2 : listFiles) {
                    if (file2.getPath().startsWith("rec_tmp_")) {
                        file2.delete();
                    }
                }
            }
        }
        if (this.jBi != null) {
            for (a aVar : this.jBi) {
                aVar.Cq(this.mStatus);
            }
        }
    }

    public boolean alA() {
        int status = getStatus();
        return status == 2 || status == 7;
    }

    public boolean cwk() {
        return this.mStatus == 6;
    }

    public int getProgress() {
        return this.mProgress;
    }

    public void a(a aVar) {
        if (this.jBi == null) {
            this.jBi = new ArrayList();
        }
        this.jBi.add(aVar);
    }
}
