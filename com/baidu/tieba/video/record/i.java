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
    private RecordVideoActivity hxN;
    protected List<a> hyA;
    private boolean hyB;
    private int hyy;
    private ProgressView hyz;
    private int mProgress;
    private int mStatus = 1;

    /* loaded from: classes5.dex */
    public interface a {
        void vN(int i);
    }

    public i(RecordVideoActivity recordVideoActivity) {
        this.hxN = recordVideoActivity;
        if (this.hxN != null) {
            ImageView imageView = (ImageView) this.hxN.findViewById(e.g.camera_switch);
            ImageView imageView2 = (ImageView) this.hxN.findViewById(e.g.flash_switch);
            this.hyz = (ProgressView) this.hxN.findViewById(e.g.video_progress_view);
            this.hyz.setListener(new AnonymousClass1());
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
            if (i == 100 && i.this.hxN != null && (hVar = i.this.hxN.hxp) != null && (bIw = hVar.bIw()) != null) {
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
                                    if (i.this.hxN != null) {
                                        i.this.hxN.bJm();
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
                if (i.this.hxN != null) {
                    i.this.hxN.bJm();
                }
            }
        }
    }

    public int getVideoDuration() {
        return this.hyy;
    }

    public void startRecord() {
        if (!this.hyB) {
            if (this.hyz != null) {
                this.hyz.setVisibility(0);
                this.hyz.setCurrentState(ProgressView.State.START);
            }
            if (!this.hyB) {
                this.hyB = true;
                this.Sv = System.currentTimeMillis();
            }
            if (this.hxN != null && this.hxN.hxp != null) {
                this.hxN.hxp.startRecord();
                if (this.hxN.hzq != null) {
                    this.hxN.hzq.vO(this.hyy);
                }
            }
        }
    }

    public boolean bIN() {
        if (this.hxN.hzq != null) {
            return this.hxN.hzq.bIN();
        }
        return false;
    }

    public void stopRecord() {
        if (this.hyB) {
            if (this.hyz != null) {
                this.hyz.setCurrentState(ProgressView.State.PAUSE);
            }
            this.hyB = false;
            this.hyy = (int) (this.hyy + (System.currentTimeMillis() - this.Sv));
            if (this.hyz != null && this.hyz.getLastProgress() != this.hyy) {
                this.hyz.vL(this.hyy);
            }
            if (this.hxN != null && this.hxN.hxp != null) {
                this.hxN.hxp.stopRecord();
            }
        }
    }

    public void bIO() {
        if (!this.hyB && this.hyz != null) {
            this.hyz.setCurrentState(ProgressView.State.ROLLBACK);
        }
    }

    public void bIP() {
        if (this.hyz != null) {
            this.hyz.setCurrentState(ProgressView.State.DELETE);
        }
        this.hyy = this.hyz.getLastProgress();
        if (this.hxN.hxp != null) {
            this.hxN.hxp.bIy();
        }
    }

    public boolean onBackPressed() {
        return this.hyz.bIM();
    }

    public int getStatus() {
        return this.mStatus;
    }

    public void setStatus(int i) {
        File[] listFiles;
        this.mStatus = i;
        if (i == 1) {
            this.hyz.setVisibility(4);
            this.hyz.reset();
            this.hyy = 0;
            File file = new File(com.baidu.tieba.video.c.hqM);
            if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
                for (File file2 : listFiles) {
                    if (file2.getPath().startsWith("rec_tmp_")) {
                        file2.delete();
                    }
                }
            }
        }
        if (this.hyA != null) {
            for (a aVar : this.hyA) {
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
        if (this.hyA == null) {
            this.hyA = new ArrayList();
        }
        this.hyA.add(aVar);
    }
}
