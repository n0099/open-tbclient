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
    private long Tr;
    private RecordVideoActivity jDY;
    private int jEJ;
    private ProgressView jEK;
    protected List<a> jEL;
    private boolean jEM;
    private int mProgress;
    private int mStatus = 1;

    /* loaded from: classes5.dex */
    public interface a {
        void Cw(int i);
    }

    public i(RecordVideoActivity recordVideoActivity) {
        this.jDY = recordVideoActivity;
        if (this.jDY != null) {
            ImageView imageView = (ImageView) this.jDY.findViewById(R.id.camera_switch);
            ImageView imageView2 = (ImageView) this.jDY.findViewById(R.id.flash_switch);
            this.jEK = (ProgressView) this.jDY.findViewById(R.id.video_progress_view);
            this.jEK.setListener(new AnonymousClass1());
            if (!com.baidu.tieba.video.record.a.rM(true)) {
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
        public void Cv(int i) {
            h hVar;
            final g cxa;
            i.this.mProgress = i;
            if (i == 100 && i.this.jDY != null && (hVar = i.this.jDY.jDA) != null && (cxa = hVar.cxa()) != null) {
                if (cxa instanceof GLVideoPreviewView) {
                    cxa.setOnEncoderStatusUpdateListener(new d.c() { // from class: com.baidu.tieba.video.record.i.1.1
                        @Override // com.faceunity.a.d.c
                        public void cxv() {
                        }

                        @Override // com.faceunity.a.d.c
                        public void cxw() {
                            com.baidu.adp.lib.g.e.iK().post(new Runnable() { // from class: com.baidu.tieba.video.record.i.1.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (i.this.jDY != null) {
                                        i.this.jDY.cxQ();
                                    }
                                }
                            });
                            cxa.setOnEncoderStatusUpdateListener(null);
                        }
                    });
                    i.this.stopRecord();
                    return;
                }
                i.this.stopRecord();
                if (i.this.jDY != null) {
                    i.this.jDY.cxQ();
                }
            }
        }
    }

    public int getVideoDuration() {
        return this.jEJ;
    }

    public void startRecord() {
        if (!this.jEM) {
            if (this.jEK != null) {
                this.jEK.setVisibility(0);
                this.jEK.setCurrentState(ProgressView.State.START);
            }
            if (!this.jEM) {
                this.jEM = true;
                this.Tr = System.currentTimeMillis();
            }
            if (this.jDY != null && this.jDY.jDA != null) {
                this.jDY.jDA.startRecord();
                if (this.jDY.jFB != null) {
                    this.jDY.jFB.Cx(this.jEJ);
                }
            }
        }
    }

    public boolean cxr() {
        if (this.jDY.jFB != null) {
            return this.jDY.jFB.cxr();
        }
        return false;
    }

    public void stopRecord() {
        if (this.jEM) {
            if (this.jEK != null) {
                this.jEK.setCurrentState(ProgressView.State.PAUSE);
            }
            this.jEM = false;
            this.jEJ = (int) (this.jEJ + (System.currentTimeMillis() - this.Tr));
            if (this.jEK != null && this.jEK.getLastProgress() != this.jEJ) {
                this.jEK.Cu(this.jEJ);
            }
            if (this.jDY != null && this.jDY.jDA != null) {
                this.jDY.jDA.stopRecord();
            }
        }
    }

    public void cxs() {
        if (!this.jEM && this.jEK != null) {
            this.jEK.setCurrentState(ProgressView.State.ROLLBACK);
        }
    }

    public void cxt() {
        if (this.jEK != null) {
            this.jEK.setCurrentState(ProgressView.State.DELETE);
        }
        this.jEJ = this.jEK.getLastProgress();
        if (this.jDY.jDA != null) {
            this.jDY.jDA.cxc();
        }
    }

    public boolean onBackPressed() {
        return this.jEK.cxq();
    }

    public int getStatus() {
        return this.mStatus;
    }

    public void setStatus(int i) {
        File[] listFiles;
        this.mStatus = i;
        if (i == 1) {
            this.jEK.setVisibility(4);
            this.jEK.reset();
            this.jEJ = 0;
            File file = new File(com.baidu.tieba.video.c.jxc);
            if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
                for (File file2 : listFiles) {
                    if (file2.getPath().startsWith("rec_tmp_")) {
                        file2.delete();
                    }
                }
            }
        }
        if (this.jEL != null) {
            for (a aVar : this.jEL) {
                aVar.Cw(this.mStatus);
            }
        }
    }

    public boolean alO() {
        int status = getStatus();
        return status == 2 || status == 7;
    }

    public boolean cxu() {
        return this.mStatus == 6;
    }

    public int getProgress() {
        return this.mProgress;
    }

    public void a(a aVar) {
        if (this.jEL == null) {
            this.jEL = new ArrayList();
        }
        this.jEL.add(aVar);
    }
}
