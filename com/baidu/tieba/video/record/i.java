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
    private RecordVideoActivity nGG;
    private int nHo;
    private ProgressView nHp;
    protected List<a> nHq;
    private boolean nHr;

    /* loaded from: classes7.dex */
    public interface a {
        void Ks(int i);
    }

    public i(RecordVideoActivity recordVideoActivity) {
        this.nGG = recordVideoActivity;
        if (this.nGG != null) {
            ImageView imageView = (ImageView) this.nGG.findViewById(R.id.camera_switch);
            ImageView imageView2 = (ImageView) this.nGG.findViewById(R.id.flash_switch);
            this.nHp = (ProgressView) this.nGG.findViewById(R.id.video_progress_view);
            this.nHp.setListener(new AnonymousClass1());
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
            if (i == 100 && i.this.nGG != null && (hVar = i.this.nGG.nGi) != null && (dRB = hVar.dRB()) != null) {
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
                                    if (i.this.nGG != null) {
                                        i.this.nGG.dSs();
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
                if (i.this.nGG != null) {
                    i.this.nGG.dSs();
                }
            }
        }
    }

    public int getVideoDuration() {
        return this.nHo;
    }

    public void startRecord() {
        if (!this.nHr) {
            if (this.nHp != null) {
                this.nHp.setVisibility(0);
                this.nHp.setCurrentState(ProgressView.State.START);
            }
            if (!this.nHr) {
                this.nHr = true;
                this.acy = System.currentTimeMillis();
            }
            if (this.nGG != null && this.nGG.nGi != null) {
                this.nGG.nGi.startRecord();
                if (this.nGG.nId != null) {
                    this.nGG.nId.Kt(this.nHo);
                }
            }
        }
    }

    public boolean dRU() {
        if (this.nGG.nId != null) {
            return this.nGG.nId.dRU();
        }
        return false;
    }

    public void stopRecord() {
        if (this.nHr) {
            if (this.nHp != null) {
                this.nHp.setCurrentState(ProgressView.State.PAUSE);
            }
            this.nHr = false;
            this.nHo = (int) (this.nHo + (System.currentTimeMillis() - this.acy));
            if (this.nHp != null && this.nHp.getLastProgress() != this.nHo) {
                this.nHp.Kq(this.nHo);
            }
            if (this.nGG != null && this.nGG.nGi != null) {
                this.nGG.nGi.stopRecord();
            }
        }
    }

    public void dRV() {
        if (!this.nHr && this.nHp != null) {
            this.nHp.setCurrentState(ProgressView.State.ROLLBACK);
        }
    }

    public void dRW() {
        if (this.nHp != null) {
            this.nHp.setCurrentState(ProgressView.State.DELETE);
        }
        this.nHo = this.nHp.getLastProgress();
        if (this.nGG.nGi != null) {
            this.nGG.nGi.dRD();
        }
    }

    public boolean onBackPressed() {
        return this.nHp.dRT();
    }

    public int getStatus() {
        return this.mStatus;
    }

    public void setStatus(int i) {
        File[] listFiles;
        this.mStatus = i;
        if (i == 1) {
            this.nHp.setVisibility(4);
            this.nHp.reset();
            this.nHo = 0;
            File file = new File(com.baidu.tieba.video.c.nAC);
            if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
                for (File file2 : listFiles) {
                    if (file2.getPath().startsWith("rec_tmp_")) {
                        file2.delete();
                    }
                }
            }
        }
        if (this.nHq != null) {
            for (a aVar : this.nHq) {
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
        if (this.nHq == null) {
            this.nHq = new ArrayList();
        }
        this.nHq.add(aVar);
    }
}
