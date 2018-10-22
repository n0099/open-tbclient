package com.baidu.tieba.video.record;

import android.widget.ImageView;
import com.baidu.tieba.e;
import com.baidu.tieba.video.record.ProgressView;
import com.faceunity.a.d;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class i {
    private long Sv;
    private RecordVideoActivity hxO;
    private ProgressView hyA;
    protected List<a> hyB;
    private boolean hyC;
    private int hyz;
    private int mProgress;
    private int mStatus = 1;

    /* loaded from: classes5.dex */
    public interface a {
        void vN(int i);
    }

    public i(RecordVideoActivity recordVideoActivity) {
        this.hxO = recordVideoActivity;
        if (this.hxO != null) {
            ImageView imageView = (ImageView) this.hxO.findViewById(e.g.camera_switch);
            ImageView imageView2 = (ImageView) this.hxO.findViewById(e.g.flash_switch);
            this.hyA = (ProgressView) this.hxO.findViewById(e.g.video_progress_view);
            this.hyA.setListener(new AnonymousClass1());
            if (!com.baidu.tieba.video.record.a.nL(true)) {
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
        public void vM(int i) {
            h hVar;
            final g bIw;
            i.this.mProgress = i;
            if (i == 100 && i.this.hxO != null && (hVar = i.this.hxO.hxq) != null && (bIw = hVar.bIw()) != null) {
                if (bIw instanceof GLVideoPreviewView) {
                    bIw.setOnEncoderStatusUpdateListener(new d.c() { // from class: com.baidu.tieba.video.record.i.1.1
                        @Override // com.faceunity.a.d.c
                        public void bIR() {
                        }

                        @Override // com.faceunity.a.d.c
                        public void bIS() {
                            com.baidu.adp.lib.g.e.jI().post(new Runnable() { // from class: com.baidu.tieba.video.record.i.1.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (i.this.hxO != null) {
                                        i.this.hxO.bJm();
                                    }
                                }
                            });
                            bIw.setOnEncoderStatusUpdateListener(null);
                        }
                    });
                    i.this.stopRecord();
                    return;
                }
                i.this.stopRecord();
                if (i.this.hxO != null) {
                    i.this.hxO.bJm();
                }
            }
        }
    }

    public int getVideoDuration() {
        return this.hyz;
    }

    public void startRecord() {
        if (!this.hyC) {
            if (this.hyA != null) {
                this.hyA.setVisibility(0);
                this.hyA.setCurrentState(ProgressView.State.START);
            }
            if (!this.hyC) {
                this.hyC = true;
                this.Sv = System.currentTimeMillis();
            }
            if (this.hxO != null && this.hxO.hxq != null) {
                this.hxO.hxq.startRecord();
                if (this.hxO.hzr != null) {
                    this.hxO.hzr.vO(this.hyz);
                }
            }
        }
    }

    public boolean bIN() {
        if (this.hxO.hzr != null) {
            return this.hxO.hzr.bIN();
        }
        return false;
    }

    public void stopRecord() {
        if (this.hyC) {
            if (this.hyA != null) {
                this.hyA.setCurrentState(ProgressView.State.PAUSE);
            }
            this.hyC = false;
            this.hyz = (int) (this.hyz + (System.currentTimeMillis() - this.Sv));
            if (this.hyA != null && this.hyA.getLastProgress() != this.hyz) {
                this.hyA.vL(this.hyz);
            }
            if (this.hxO != null && this.hxO.hxq != null) {
                this.hxO.hxq.stopRecord();
            }
        }
    }

    public void bIO() {
        if (!this.hyC && this.hyA != null) {
            this.hyA.setCurrentState(ProgressView.State.ROLLBACK);
        }
    }

    public void bIP() {
        if (this.hyA != null) {
            this.hyA.setCurrentState(ProgressView.State.DELETE);
        }
        this.hyz = this.hyA.getLastProgress();
        if (this.hxO.hxq != null) {
            this.hxO.hxq.bIy();
        }
    }

    public boolean onBackPressed() {
        return this.hyA.bIM();
    }

    public int getStatus() {
        return this.mStatus;
    }

    public void setStatus(int i) {
        File[] listFiles;
        this.mStatus = i;
        if (i == 1) {
            this.hyA.setVisibility(4);
            this.hyA.reset();
            this.hyz = 0;
            File file = new File(com.baidu.tieba.video.c.hqN);
            if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
                for (File file2 : listFiles) {
                    if (file2.getPath().startsWith("rec_tmp_")) {
                        file2.delete();
                    }
                }
            }
        }
        if (this.hyB != null) {
            for (a aVar : this.hyB) {
                aVar.vN(this.mStatus);
            }
        }
    }

    public boolean isRecording() {
        int status = getStatus();
        return status == 2 || status == 7;
    }

    public boolean bIQ() {
        return this.mStatus == 6;
    }

    public int getProgress() {
        return this.mProgress;
    }

    public void a(a aVar) {
        if (this.hyB == null) {
            this.hyB = new ArrayList();
        }
        this.hyB.add(aVar);
    }
}
