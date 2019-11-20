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
    private long Cj;
    private RecordVideoActivity jCZ;
    private int jDJ;
    private ProgressView jDK;
    protected List<a> jDL;
    private boolean jDM;
    private int mProgress;
    private int mStatus = 1;

    /* loaded from: classes5.dex */
    public interface a {
        void Bb(int i);
    }

    public i(RecordVideoActivity recordVideoActivity) {
        this.jCZ = recordVideoActivity;
        if (this.jCZ != null) {
            ImageView imageView = (ImageView) this.jCZ.findViewById(R.id.camera_switch);
            ImageView imageView2 = (ImageView) this.jCZ.findViewById(R.id.flash_switch);
            this.jDK = (ProgressView) this.jCZ.findViewById(R.id.video_progress_view);
            this.jDK.setListener(new AnonymousClass1());
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
        public void Ba(int i) {
            h hVar;
            final g cuM;
            i.this.mProgress = i;
            if (i == 100 && i.this.jCZ != null && (hVar = i.this.jCZ.jCB) != null && (cuM = hVar.cuM()) != null) {
                if (cuM instanceof GLVideoPreviewView) {
                    cuM.setOnEncoderStatusUpdateListener(new d.c() { // from class: com.baidu.tieba.video.record.i.1.1
                        @Override // com.faceunity.a.d.c
                        public void cvj() {
                        }

                        @Override // com.faceunity.a.d.c
                        public void cvk() {
                            com.baidu.adp.lib.g.e.fZ().post(new Runnable() { // from class: com.baidu.tieba.video.record.i.1.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (i.this.jCZ != null) {
                                        i.this.jCZ.cvE();
                                    }
                                }
                            });
                            cuM.setOnEncoderStatusUpdateListener(null);
                        }
                    });
                    i.this.stopRecord();
                    return;
                }
                i.this.stopRecord();
                if (i.this.jCZ != null) {
                    i.this.jCZ.cvE();
                }
            }
        }
    }

    public int getVideoDuration() {
        return this.jDJ;
    }

    public void startRecord() {
        if (!this.jDM) {
            if (this.jDK != null) {
                this.jDK.setVisibility(0);
                this.jDK.setCurrentState(ProgressView.State.START);
            }
            if (!this.jDM) {
                this.jDM = true;
                this.Cj = System.currentTimeMillis();
            }
            if (this.jCZ != null && this.jCZ.jCB != null) {
                this.jCZ.jCB.startRecord();
                if (this.jCZ.jEA != null) {
                    this.jCZ.jEA.Bc(this.jDJ);
                }
            }
        }
    }

    public boolean cvf() {
        if (this.jCZ.jEA != null) {
            return this.jCZ.jEA.cvf();
        }
        return false;
    }

    public void stopRecord() {
        if (this.jDM) {
            if (this.jDK != null) {
                this.jDK.setCurrentState(ProgressView.State.PAUSE);
            }
            this.jDM = false;
            this.jDJ = (int) (this.jDJ + (System.currentTimeMillis() - this.Cj));
            if (this.jDK != null && this.jDK.getLastProgress() != this.jDJ) {
                this.jDK.AZ(this.jDJ);
            }
            if (this.jCZ != null && this.jCZ.jCB != null) {
                this.jCZ.jCB.stopRecord();
            }
        }
    }

    public void cvg() {
        if (!this.jDM && this.jDK != null) {
            this.jDK.setCurrentState(ProgressView.State.ROLLBACK);
        }
    }

    public void cvh() {
        if (this.jDK != null) {
            this.jDK.setCurrentState(ProgressView.State.DELETE);
        }
        this.jDJ = this.jDK.getLastProgress();
        if (this.jCZ.jCB != null) {
            this.jCZ.jCB.cuO();
        }
    }

    public boolean onBackPressed() {
        return this.jDK.cve();
    }

    public int getStatus() {
        return this.mStatus;
    }

    public void setStatus(int i) {
        File[] listFiles;
        this.mStatus = i;
        if (i == 1) {
            this.jDK.setVisibility(4);
            this.jDK.reset();
            this.jDJ = 0;
            File file = new File(com.baidu.tieba.video.c.jwd);
            if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
                for (File file2 : listFiles) {
                    if (file2.getPath().startsWith("rec_tmp_")) {
                        file2.delete();
                    }
                }
            }
        }
        if (this.jDL != null) {
            for (a aVar : this.jDL) {
                aVar.Bb(this.mStatus);
            }
        }
    }

    public boolean aoA() {
        int status = getStatus();
        return status == 2 || status == 7;
    }

    public boolean cvi() {
        return this.mStatus == 6;
    }

    public int getProgress() {
        return this.mProgress;
    }

    public void a(a aVar) {
        if (this.jDL == null) {
            this.jDL = new ArrayList();
        }
        this.jDL.add(aVar);
    }
}
