package com.baidu.tieba.video.record;

import android.widget.ImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.video.record.ProgressView;
import com.faceunity.a.d;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class i {
    private long PG;
    private RecordVideoActivity hhv;
    private int hih;
    private ProgressView hii;
    protected List<a> hij;
    private boolean hik;
    private int mProgress;
    private int mStatus = 1;

    /* loaded from: classes2.dex */
    public interface a {
        void uR(int i);
    }

    public i(RecordVideoActivity recordVideoActivity) {
        this.hhv = recordVideoActivity;
        if (this.hhv != null) {
            ImageView imageView = (ImageView) this.hhv.findViewById(d.g.camera_switch);
            ImageView imageView2 = (ImageView) this.hhv.findViewById(d.g.flash_switch);
            this.hii = (ProgressView) this.hhv.findViewById(d.g.video_progress_view);
            this.hii.setListener(new AnonymousClass1());
            if (!com.baidu.tieba.video.record.a.nl(true)) {
                imageView2.setVisibility(4);
            }
            if (!com.baidu.tieba.video.record.a.c(recordVideoActivity.getPackageManager())) {
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
        public void uQ(int i) {
            h hVar;
            final g bDG;
            i.this.mProgress = i;
            if (i == 100 && i.this.hhv != null && (hVar = i.this.hhv.hgX) != null && (bDG = hVar.bDG()) != null) {
                if (bDG instanceof GLVideoPreviewView) {
                    bDG.setOnEncoderStatusUpdateListener(new d.c() { // from class: com.baidu.tieba.video.record.i.1.1
                        @Override // com.faceunity.a.d.c
                        public void bEd() {
                        }

                        @Override // com.faceunity.a.d.c
                        public void bEe() {
                            com.baidu.adp.lib.g.e.im().post(new Runnable() { // from class: com.baidu.tieba.video.record.i.1.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (i.this.hhv != null) {
                                        i.this.hhv.bEy();
                                    }
                                }
                            });
                            bDG.setOnEncoderStatusUpdateListener(null);
                        }
                    });
                    i.this.stopRecord();
                    return;
                }
                i.this.stopRecord();
                if (i.this.hhv != null) {
                    i.this.hhv.bEy();
                }
            }
        }
    }

    public int getVideoDuration() {
        return this.hih;
    }

    public void startRecord() {
        if (!this.hik) {
            if (this.hii != null) {
                this.hii.setVisibility(0);
                this.hii.setCurrentState(ProgressView.State.START);
            }
            if (!this.hik) {
                this.hik = true;
                this.PG = System.currentTimeMillis();
            }
            if (this.hhv != null && this.hhv.hgX != null) {
                this.hhv.hgX.startRecord();
                if (this.hhv.hiZ != null) {
                    this.hhv.hiZ.uS(this.hih);
                }
            }
        }
    }

    public boolean bDZ() {
        if (this.hhv.hiZ != null) {
            return this.hhv.hiZ.bDZ();
        }
        return false;
    }

    public void stopRecord() {
        if (this.hik) {
            if (this.hii != null) {
                this.hii.setCurrentState(ProgressView.State.PAUSE);
            }
            this.hik = false;
            this.hih = (int) (this.hih + (System.currentTimeMillis() - this.PG));
            if (this.hii != null && this.hii.getLastProgress() != this.hih) {
                this.hii.uP(this.hih);
            }
            if (this.hhv != null && this.hhv.hgX != null) {
                this.hhv.hgX.stopRecord();
            }
        }
    }

    public void bEa() {
        if (!this.hik && this.hii != null) {
            this.hii.setCurrentState(ProgressView.State.ROLLBACK);
        }
    }

    public void bEb() {
        if (this.hii != null) {
            this.hii.setCurrentState(ProgressView.State.DELETE);
        }
        this.hih = this.hii.getLastProgress();
        if (this.hhv.hgX != null) {
            this.hhv.hgX.bDI();
        }
    }

    public boolean onBackPressed() {
        return this.hii.bDY();
    }

    public int getStatus() {
        return this.mStatus;
    }

    public void setStatus(int i) {
        File[] listFiles;
        this.mStatus = i;
        if (i == 1) {
            this.hii.setVisibility(4);
            this.hii.reset();
            this.hih = 0;
            File file = new File(com.baidu.tieba.video.b.haq);
            if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
                for (File file2 : listFiles) {
                    if (file2.getPath().startsWith("rec_tmp_")) {
                        file2.delete();
                    }
                }
            }
        }
        if (this.hij != null) {
            for (a aVar : this.hij) {
                aVar.uR(this.mStatus);
            }
        }
    }

    public boolean isRecording() {
        int status = getStatus();
        return status == 2 || status == 7;
    }

    public boolean bEc() {
        return this.mStatus == 6;
    }

    public int getProgress() {
        return this.mProgress;
    }

    public void a(a aVar) {
        if (this.hij == null) {
            this.hij = new ArrayList();
        }
        this.hij.add(aVar);
    }
}
