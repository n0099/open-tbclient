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
    private long PE;
    private RecordVideoActivity hdq;
    private int hea;
    private ProgressView heb;
    protected List<a> hec;
    private boolean hed;
    private int mProgress;
    private int mStatus = 1;

    /* loaded from: classes2.dex */
    public interface a {
        void uJ(int i);
    }

    public i(RecordVideoActivity recordVideoActivity) {
        this.hdq = recordVideoActivity;
        if (this.hdq != null) {
            ImageView imageView = (ImageView) this.hdq.findViewById(d.g.camera_switch);
            ImageView imageView2 = (ImageView) this.hdq.findViewById(d.g.flash_switch);
            this.heb = (ProgressView) this.hdq.findViewById(d.g.video_progress_view);
            this.heb.setListener(new AnonymousClass1());
            if (!com.baidu.tieba.video.record.a.nd(true)) {
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
        public void uI(int i) {
            h hVar;
            final g bDg;
            i.this.mProgress = i;
            if (i == 100 && i.this.hdq != null && (hVar = i.this.hdq.hcS) != null && (bDg = hVar.bDg()) != null) {
                if (bDg instanceof GLVideoPreviewView) {
                    bDg.setOnEncoderStatusUpdateListener(new d.c() { // from class: com.baidu.tieba.video.record.i.1.1
                        @Override // com.faceunity.a.d.c
                        public void bDD() {
                        }

                        @Override // com.faceunity.a.d.c
                        public void bDE() {
                            com.baidu.adp.lib.g.e.im().post(new Runnable() { // from class: com.baidu.tieba.video.record.i.1.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (i.this.hdq != null) {
                                        i.this.hdq.bDY();
                                    }
                                }
                            });
                            bDg.setOnEncoderStatusUpdateListener(null);
                        }
                    });
                    i.this.stopRecord();
                    return;
                }
                i.this.stopRecord();
                if (i.this.hdq != null) {
                    i.this.hdq.bDY();
                }
            }
        }
    }

    public int getVideoDuration() {
        return this.hea;
    }

    public void startRecord() {
        if (!this.hed) {
            if (this.heb != null) {
                this.heb.setVisibility(0);
                this.heb.setCurrentState(ProgressView.State.START);
            }
            if (!this.hed) {
                this.hed = true;
                this.PE = System.currentTimeMillis();
            }
            if (this.hdq != null && this.hdq.hcS != null) {
                this.hdq.hcS.startRecord();
                if (this.hdq.heS != null) {
                    this.hdq.heS.uK(this.hea);
                }
            }
        }
    }

    public boolean bDz() {
        if (this.hdq.heS != null) {
            return this.hdq.heS.bDz();
        }
        return false;
    }

    public void stopRecord() {
        if (this.hed) {
            if (this.heb != null) {
                this.heb.setCurrentState(ProgressView.State.PAUSE);
            }
            this.hed = false;
            this.hea = (int) (this.hea + (System.currentTimeMillis() - this.PE));
            if (this.heb != null && this.heb.getLastProgress() != this.hea) {
                this.heb.uH(this.hea);
            }
            if (this.hdq != null && this.hdq.hcS != null) {
                this.hdq.hcS.stopRecord();
            }
        }
    }

    public void bDA() {
        if (!this.hed && this.heb != null) {
            this.heb.setCurrentState(ProgressView.State.ROLLBACK);
        }
    }

    public void bDB() {
        if (this.heb != null) {
            this.heb.setCurrentState(ProgressView.State.DELETE);
        }
        this.hea = this.heb.getLastProgress();
        if (this.hdq.hcS != null) {
            this.hdq.hcS.bDi();
        }
    }

    public boolean onBackPressed() {
        return this.heb.bDy();
    }

    public int getStatus() {
        return this.mStatus;
    }

    public void setStatus(int i) {
        File[] listFiles;
        this.mStatus = i;
        if (i == 1) {
            this.heb.setVisibility(4);
            this.heb.reset();
            this.hea = 0;
            File file = new File(com.baidu.tieba.video.b.gWl);
            if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
                for (File file2 : listFiles) {
                    if (file2.getPath().startsWith("rec_tmp_")) {
                        file2.delete();
                    }
                }
            }
        }
        if (this.hec != null) {
            for (a aVar : this.hec) {
                aVar.uJ(this.mStatus);
            }
        }
    }

    public boolean isRecording() {
        int status = getStatus();
        return status == 2 || status == 7;
    }

    public boolean bDC() {
        return this.mStatus == 6;
    }

    public int getProgress() {
        return this.mProgress;
    }

    public void a(a aVar) {
        if (this.hec == null) {
            this.hec = new ArrayList();
        }
        this.hec.add(aVar);
    }
}
