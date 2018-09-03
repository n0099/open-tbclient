package com.baidu.tieba.video.record;

import android.widget.ImageView;
import com.baidu.tieba.f;
import com.baidu.tieba.video.record.ProgressView;
import com.faceunity.a.d;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class i {
    private long PD;
    private RecordVideoActivity hiL;
    private int hjw;
    private ProgressView hjx;
    protected List<a> hjy;
    private boolean hjz;
    private int mProgress;
    private int mStatus = 1;

    /* loaded from: classes2.dex */
    public interface a {
        void uQ(int i);
    }

    public i(RecordVideoActivity recordVideoActivity) {
        this.hiL = recordVideoActivity;
        if (this.hiL != null) {
            ImageView imageView = (ImageView) this.hiL.findViewById(f.g.camera_switch);
            ImageView imageView2 = (ImageView) this.hiL.findViewById(f.g.flash_switch);
            this.hjx = (ProgressView) this.hiL.findViewById(f.g.video_progress_view);
            this.hjx.setListener(new AnonymousClass1());
            if (!com.baidu.tieba.video.record.a.mX(true)) {
                imageView2.setVisibility(4);
            }
            if (!com.baidu.tieba.video.record.a.b(recordVideoActivity.getPackageManager())) {
                imageView.setVisibility(8);
            }
        }
    }

    /* renamed from: com.baidu.tieba.video.record.i$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    class AnonymousClass1 implements ProgressView.a {
        AnonymousClass1() {
        }

        @Override // com.baidu.tieba.video.record.ProgressView.a
        public void uP(int i) {
            h hVar;
            final g bCu;
            i.this.mProgress = i;
            if (i == 100 && i.this.hiL != null && (hVar = i.this.hiL.hin) != null && (bCu = hVar.bCu()) != null) {
                if (bCu instanceof GLVideoPreviewView) {
                    bCu.setOnEncoderStatusUpdateListener(new d.c() { // from class: com.baidu.tieba.video.record.i.1.1
                        @Override // com.faceunity.a.d.c
                        public void bCP() {
                        }

                        @Override // com.faceunity.a.d.c
                        public void bCQ() {
                            com.baidu.adp.lib.g.e.in().post(new Runnable() { // from class: com.baidu.tieba.video.record.i.1.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (i.this.hiL != null) {
                                        i.this.hiL.bDk();
                                    }
                                }
                            });
                            bCu.setOnEncoderStatusUpdateListener(null);
                        }
                    });
                    i.this.stopRecord();
                    return;
                }
                i.this.stopRecord();
                if (i.this.hiL != null) {
                    i.this.hiL.bDk();
                }
            }
        }
    }

    public int getVideoDuration() {
        return this.hjw;
    }

    public void startRecord() {
        if (!this.hjz) {
            if (this.hjx != null) {
                this.hjx.setVisibility(0);
                this.hjx.setCurrentState(ProgressView.State.START);
            }
            if (!this.hjz) {
                this.hjz = true;
                this.PD = System.currentTimeMillis();
            }
            if (this.hiL != null && this.hiL.hin != null) {
                this.hiL.hin.startRecord();
                if (this.hiL.hko != null) {
                    this.hiL.hko.uR(this.hjw);
                }
            }
        }
    }

    public boolean bCL() {
        if (this.hiL.hko != null) {
            return this.hiL.hko.bCL();
        }
        return false;
    }

    public void stopRecord() {
        if (this.hjz) {
            if (this.hjx != null) {
                this.hjx.setCurrentState(ProgressView.State.PAUSE);
            }
            this.hjz = false;
            this.hjw = (int) (this.hjw + (System.currentTimeMillis() - this.PD));
            if (this.hjx != null && this.hjx.getLastProgress() != this.hjw) {
                this.hjx.uO(this.hjw);
            }
            if (this.hiL != null && this.hiL.hin != null) {
                this.hiL.hin.stopRecord();
            }
        }
    }

    public void bCM() {
        if (!this.hjz && this.hjx != null) {
            this.hjx.setCurrentState(ProgressView.State.ROLLBACK);
        }
    }

    public void bCN() {
        if (this.hjx != null) {
            this.hjx.setCurrentState(ProgressView.State.DELETE);
        }
        this.hjw = this.hjx.getLastProgress();
        if (this.hiL.hin != null) {
            this.hiL.hin.bCw();
        }
    }

    public boolean onBackPressed() {
        return this.hjx.bCK();
    }

    public int getStatus() {
        return this.mStatus;
    }

    public void setStatus(int i) {
        File[] listFiles;
        this.mStatus = i;
        if (i == 1) {
            this.hjx.setVisibility(4);
            this.hjx.reset();
            this.hjw = 0;
            File file = new File(com.baidu.tieba.video.c.hbE);
            if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
                for (File file2 : listFiles) {
                    if (file2.getPath().startsWith("rec_tmp_")) {
                        file2.delete();
                    }
                }
            }
        }
        if (this.hjy != null) {
            for (a aVar : this.hjy) {
                aVar.uQ(this.mStatus);
            }
        }
    }

    public boolean isRecording() {
        int status = getStatus();
        return status == 2 || status == 7;
    }

    public boolean bCO() {
        return this.mStatus == 6;
    }

    public int getProgress() {
        return this.mProgress;
    }

    public void a(a aVar) {
        if (this.hjy == null) {
            this.hjy = new ArrayList();
        }
        this.hjy.add(aVar);
    }
}
