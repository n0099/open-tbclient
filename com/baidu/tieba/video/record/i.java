package com.baidu.tieba.video.record;

import android.widget.ImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.video.record.ProgressView;
import com.faceunity.a.d;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class i {
    private long acy;
    private int mProgress;
    private int mStatus = 1;
    private RecordVideoActivity nGF;
    private int nHn;
    private ProgressView nHo;
    protected List<a> nHp;
    private boolean nHq;

    /* loaded from: classes7.dex */
    public interface a {
        void Ks(int i);
    }

    public i(RecordVideoActivity recordVideoActivity) {
        this.nGF = recordVideoActivity;
        if (this.nGF != null) {
            ImageView imageView = (ImageView) this.nGF.findViewById(R.id.camera_switch);
            ImageView imageView2 = (ImageView) this.nGF.findViewById(R.id.flash_switch);
            this.nHo = (ProgressView) this.nGF.findViewById(R.id.video_progress_view);
            this.nHo.setListener(new AnonymousClass1());
            if (!com.baidu.tieba.video.record.a.yI(true)) {
                imageView2.setVisibility(4);
            }
            if (!com.baidu.tieba.video.record.a.b(recordVideoActivity.getPackageManager())) {
                imageView.setVisibility(8);
            }
        }
    }

    /* renamed from: com.baidu.tieba.video.record.i$1  reason: invalid class name */
    /* loaded from: classes7.dex */
    class AnonymousClass1 implements ProgressView.a {
        AnonymousClass1() {
        }

        @Override // com.baidu.tieba.video.record.ProgressView.a
        public void Kr(int i) {
            h hVar;
            final g dRB;
            i.this.mProgress = i;
            if (i == 100 && i.this.nGF != null && (hVar = i.this.nGF.nGh) != null && (dRB = hVar.dRB()) != null) {
                if (dRB instanceof GLVideoPreviewView) {
                    dRB.setOnEncoderStatusUpdateListener(new d.c() { // from class: com.baidu.tieba.video.record.i.1.1
                        @Override // com.faceunity.a.d.c
                        public void Uc() {
                        }

                        @Override // com.faceunity.a.d.c
                        public void dRX() {
                            com.baidu.adp.lib.f.e.mB().post(new Runnable() { // from class: com.baidu.tieba.video.record.i.1.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (i.this.nGF != null) {
                                        i.this.nGF.dSs();
                                    }
                                }
                            });
                            dRB.setOnEncoderStatusUpdateListener(null);
                        }
                    });
                    i.this.stopRecord();
                    return;
                }
                i.this.stopRecord();
                if (i.this.nGF != null) {
                    i.this.nGF.dSs();
                }
            }
        }
    }

    public int getVideoDuration() {
        return this.nHn;
    }

    public void startRecord() {
        if (!this.nHq) {
            if (this.nHo != null) {
                this.nHo.setVisibility(0);
                this.nHo.setCurrentState(ProgressView.State.START);
            }
            if (!this.nHq) {
                this.nHq = true;
                this.acy = System.currentTimeMillis();
            }
            if (this.nGF != null && this.nGF.nGh != null) {
                this.nGF.nGh.startRecord();
                if (this.nGF.nIc != null) {
                    this.nGF.nIc.Kt(this.nHn);
                }
            }
        }
    }

    public boolean dRU() {
        if (this.nGF.nIc != null) {
            return this.nGF.nIc.dRU();
        }
        return false;
    }

    public void stopRecord() {
        if (this.nHq) {
            if (this.nHo != null) {
                this.nHo.setCurrentState(ProgressView.State.PAUSE);
            }
            this.nHq = false;
            this.nHn = (int) (this.nHn + (System.currentTimeMillis() - this.acy));
            if (this.nHo != null && this.nHo.getLastProgress() != this.nHn) {
                this.nHo.Kq(this.nHn);
            }
            if (this.nGF != null && this.nGF.nGh != null) {
                this.nGF.nGh.stopRecord();
            }
        }
    }

    public void dRV() {
        if (!this.nHq && this.nHo != null) {
            this.nHo.setCurrentState(ProgressView.State.ROLLBACK);
        }
    }

    public void dRW() {
        if (this.nHo != null) {
            this.nHo.setCurrentState(ProgressView.State.DELETE);
        }
        this.nHn = this.nHo.getLastProgress();
        if (this.nGF.nGh != null) {
            this.nGF.nGh.dRD();
        }
    }

    public boolean onBackPressed() {
        return this.nHo.dRT();
    }

    public int getStatus() {
        return this.mStatus;
    }

    public void setStatus(int i) {
        File[] listFiles;
        this.mStatus = i;
        if (i == 1) {
            this.nHo.setVisibility(4);
            this.nHo.reset();
            this.nHn = 0;
            File file = new File(com.baidu.tieba.video.c.nAB);
            if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
                for (File file2 : listFiles) {
                    if (file2.getPath().startsWith("rec_tmp_")) {
                        file2.delete();
                    }
                }
            }
        }
        if (this.nHp != null) {
            for (a aVar : this.nHp) {
                aVar.Ks(this.mStatus);
            }
        }
    }

    public boolean bvp() {
        int status = getStatus();
        return status == 2 || status == 7;
    }

    public boolean bTy() {
        return this.mStatus == 6;
    }

    public int getProgress() {
        return this.mProgress;
    }

    public void a(a aVar) {
        if (this.nHp == null) {
            this.nHp = new ArrayList();
        }
        this.nHp.add(aVar);
    }
}
