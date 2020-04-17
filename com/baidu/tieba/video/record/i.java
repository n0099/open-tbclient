package com.baidu.tieba.video.record;

import android.widget.ImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.video.record.ProgressView;
import com.faceunity.a.d;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class i {
    private long YB;
    private boolean bvE;
    private RecordVideoActivity lnH;
    private int lot;
    private ProgressView lou;
    private int mProgress;
    private int mStatus = 1;
    protected List<a> mStatusListeners;

    /* loaded from: classes10.dex */
    public interface a {
        void Eu(int i);
    }

    public i(RecordVideoActivity recordVideoActivity) {
        this.lnH = recordVideoActivity;
        if (this.lnH != null) {
            ImageView imageView = (ImageView) this.lnH.findViewById(R.id.camera_switch);
            ImageView imageView2 = (ImageView) this.lnH.findViewById(R.id.flash_switch);
            this.lou = (ProgressView) this.lnH.findViewById(R.id.video_progress_view);
            this.lou.setListener(new AnonymousClass1());
            if (!com.baidu.tieba.video.record.a.uz(true)) {
                imageView2.setVisibility(4);
            }
            if (!com.baidu.tieba.video.record.a.b(recordVideoActivity.getPackageManager())) {
                imageView.setVisibility(8);
            }
        }
    }

    /* renamed from: com.baidu.tieba.video.record.i$1  reason: invalid class name */
    /* loaded from: classes10.dex */
    class AnonymousClass1 implements ProgressView.a {
        AnonymousClass1() {
        }

        @Override // com.baidu.tieba.video.record.ProgressView.a
        public void Et(int i) {
            h hVar;
            final g dcB;
            i.this.mProgress = i;
            if (i == 100 && i.this.lnH != null && (hVar = i.this.lnH.lnj) != null && (dcB = hVar.dcB()) != null) {
                if (dcB instanceof GLVideoPreviewView) {
                    dcB.setOnEncoderStatusUpdateListener(new d.c() { // from class: com.baidu.tieba.video.record.i.1.1
                        @Override // com.faceunity.a.d.c
                        public void Gp() {
                        }

                        @Override // com.faceunity.a.d.c
                        public void dcX() {
                            com.baidu.adp.lib.f.e.lb().post(new Runnable() { // from class: com.baidu.tieba.video.record.i.1.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (i.this.lnH != null) {
                                        i.this.lnH.ddr();
                                    }
                                }
                            });
                            dcB.setOnEncoderStatusUpdateListener(null);
                        }
                    });
                    i.this.stopRecord();
                    return;
                }
                i.this.stopRecord();
                if (i.this.lnH != null) {
                    i.this.lnH.ddr();
                }
            }
        }
    }

    public int getVideoDuration() {
        return this.lot;
    }

    public void startRecord() {
        if (!this.bvE) {
            if (this.lou != null) {
                this.lou.setVisibility(0);
                this.lou.setCurrentState(ProgressView.State.START);
            }
            if (!this.bvE) {
                this.bvE = true;
                this.YB = System.currentTimeMillis();
            }
            if (this.lnH != null && this.lnH.lnj != null) {
                this.lnH.lnj.startRecord();
                if (this.lnH.lpj != null) {
                    this.lnH.lpj.Ev(this.lot);
                }
            }
        }
    }

    public boolean dcU() {
        if (this.lnH.lpj != null) {
            return this.lnH.lpj.dcU();
        }
        return false;
    }

    public void stopRecord() {
        if (this.bvE) {
            if (this.lou != null) {
                this.lou.setCurrentState(ProgressView.State.PAUSE);
            }
            this.bvE = false;
            this.lot = (int) (this.lot + (System.currentTimeMillis() - this.YB));
            if (this.lou != null && this.lou.getLastProgress() != this.lot) {
                this.lou.Es(this.lot);
            }
            if (this.lnH != null && this.lnH.lnj != null) {
                this.lnH.lnj.stopRecord();
            }
        }
    }

    public void dcV() {
        if (!this.bvE && this.lou != null) {
            this.lou.setCurrentState(ProgressView.State.ROLLBACK);
        }
    }

    public void dcW() {
        if (this.lou != null) {
            this.lou.setCurrentState(ProgressView.State.DELETE);
        }
        this.lot = this.lou.getLastProgress();
        if (this.lnH.lnj != null) {
            this.lnH.lnj.dcD();
        }
    }

    public boolean onBackPressed() {
        return this.lou.dcT();
    }

    public int getStatus() {
        return this.mStatus;
    }

    public void setStatus(int i) {
        File[] listFiles;
        this.mStatus = i;
        if (i == 1) {
            this.lou.setVisibility(4);
            this.lou.reset();
            this.lot = 0;
            File file = new File(com.baidu.tieba.video.c.lgQ);
            if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
                for (File file2 : listFiles) {
                    if (file2.getPath().startsWith("rec_tmp_")) {
                        file2.delete();
                    }
                }
            }
        }
        if (this.mStatusListeners != null) {
            for (a aVar : this.mStatusListeners) {
                aVar.Eu(this.mStatus);
            }
        }
    }

    public boolean aRo() {
        int status = getStatus();
        return status == 2 || status == 7;
    }

    public boolean bnG() {
        return this.mStatus == 6;
    }

    public int getProgress() {
        return this.mProgress;
    }

    public void a(a aVar) {
        if (this.mStatusListeners == null) {
            this.mStatusListeners = new ArrayList();
        }
        this.mStatusListeners.add(aVar);
    }
}
