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
    private long CJ;
    private RecordVideoActivity jDQ;
    private int jEA;
    private ProgressView jEB;
    protected List<a> jEC;
    private boolean jED;
    private int mProgress;
    private int mStatus = 1;

    /* loaded from: classes5.dex */
    public interface a {
        void Bc(int i);
    }

    public i(RecordVideoActivity recordVideoActivity) {
        this.jDQ = recordVideoActivity;
        if (this.jDQ != null) {
            ImageView imageView = (ImageView) this.jDQ.findViewById(R.id.camera_switch);
            ImageView imageView2 = (ImageView) this.jDQ.findViewById(R.id.flash_switch);
            this.jEB = (ProgressView) this.jDQ.findViewById(R.id.video_progress_view);
            this.jEB.setListener(new AnonymousClass1());
            if (!com.baidu.tieba.video.record.a.rv(true)) {
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
        public void Bb(int i) {
            h hVar;
            final g cuO;
            i.this.mProgress = i;
            if (i == 100 && i.this.jDQ != null && (hVar = i.this.jDQ.jDs) != null && (cuO = hVar.cuO()) != null) {
                if (cuO instanceof GLVideoPreviewView) {
                    cuO.setOnEncoderStatusUpdateListener(new d.c() { // from class: com.baidu.tieba.video.record.i.1.1
                        @Override // com.faceunity.a.d.c
                        public void cvl() {
                        }

                        @Override // com.faceunity.a.d.c
                        public void cvm() {
                            com.baidu.adp.lib.g.e.fZ().post(new Runnable() { // from class: com.baidu.tieba.video.record.i.1.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (i.this.jDQ != null) {
                                        i.this.jDQ.cvG();
                                    }
                                }
                            });
                            cuO.setOnEncoderStatusUpdateListener(null);
                        }
                    });
                    i.this.stopRecord();
                    return;
                }
                i.this.stopRecord();
                if (i.this.jDQ != null) {
                    i.this.jDQ.cvG();
                }
            }
        }
    }

    public int getVideoDuration() {
        return this.jEA;
    }

    public void startRecord() {
        if (!this.jED) {
            if (this.jEB != null) {
                this.jEB.setVisibility(0);
                this.jEB.setCurrentState(ProgressView.State.START);
            }
            if (!this.jED) {
                this.jED = true;
                this.CJ = System.currentTimeMillis();
            }
            if (this.jDQ != null && this.jDQ.jDs != null) {
                this.jDQ.jDs.startRecord();
                if (this.jDQ.jFr != null) {
                    this.jDQ.jFr.Bd(this.jEA);
                }
            }
        }
    }

    public boolean cvh() {
        if (this.jDQ.jFr != null) {
            return this.jDQ.jFr.cvh();
        }
        return false;
    }

    public void stopRecord() {
        if (this.jED) {
            if (this.jEB != null) {
                this.jEB.setCurrentState(ProgressView.State.PAUSE);
            }
            this.jED = false;
            this.jEA = (int) (this.jEA + (System.currentTimeMillis() - this.CJ));
            if (this.jEB != null && this.jEB.getLastProgress() != this.jEA) {
                this.jEB.Ba(this.jEA);
            }
            if (this.jDQ != null && this.jDQ.jDs != null) {
                this.jDQ.jDs.stopRecord();
            }
        }
    }

    public void cvi() {
        if (!this.jED && this.jEB != null) {
            this.jEB.setCurrentState(ProgressView.State.ROLLBACK);
        }
    }

    public void cvj() {
        if (this.jEB != null) {
            this.jEB.setCurrentState(ProgressView.State.DELETE);
        }
        this.jEA = this.jEB.getLastProgress();
        if (this.jDQ.jDs != null) {
            this.jDQ.jDs.cuQ();
        }
    }

    public boolean onBackPressed() {
        return this.jEB.cvg();
    }

    public int getStatus() {
        return this.mStatus;
    }

    public void setStatus(int i) {
        File[] listFiles;
        this.mStatus = i;
        if (i == 1) {
            this.jEB.setVisibility(4);
            this.jEB.reset();
            this.jEA = 0;
            File file = new File(com.baidu.tieba.video.c.jwU);
            if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
                for (File file2 : listFiles) {
                    if (file2.getPath().startsWith("rec_tmp_")) {
                        file2.delete();
                    }
                }
            }
        }
        if (this.jEC != null) {
            for (a aVar : this.jEC) {
                aVar.Bc(this.mStatus);
            }
        }
    }

    public boolean aoC() {
        int status = getStatus();
        return status == 2 || status == 7;
    }

    public boolean cvk() {
        return this.mStatus == 6;
    }

    public int getProgress() {
        return this.mProgress;
    }

    public void a(a aVar) {
        if (this.jEC == null) {
            this.jEC = new ArrayList();
        }
        this.jEC.add(aVar);
    }
}
