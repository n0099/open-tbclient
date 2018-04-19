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
    private long Js;
    private RecordVideoActivity gQO;
    protected List<a> gRA;
    private boolean gRB;
    private int gRy;
    private ProgressView gRz;
    private int mProgress;
    private int mStatus = 1;

    /* loaded from: classes2.dex */
    public interface a {
        void ux(int i);
    }

    public i(RecordVideoActivity recordVideoActivity) {
        this.gQO = recordVideoActivity;
        if (this.gQO != null) {
            ImageView imageView = (ImageView) this.gQO.findViewById(d.g.camera_switch);
            ImageView imageView2 = (ImageView) this.gQO.findViewById(d.g.flash_switch);
            this.gRz = (ProgressView) this.gQO.findViewById(d.g.video_progress_view);
            this.gRz.setListener(new AnonymousClass1());
            if (!com.baidu.tieba.video.record.a.mW(true)) {
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
        public void uw(int i) {
            h hVar;
            final g byc;
            i.this.mProgress = i;
            if (i == 100 && i.this.gQO != null && (hVar = i.this.gQO.gQq) != null && (byc = hVar.byc()) != null) {
                if (byc instanceof GLVideoPreviewView) {
                    byc.setOnEncoderStatusUpdateListener(new d.c() { // from class: com.baidu.tieba.video.record.i.1.1
                        @Override // com.faceunity.a.d.c
                        public void byz() {
                        }

                        @Override // com.faceunity.a.d.c
                        public void byA() {
                            com.baidu.adp.lib.g.e.fw().post(new Runnable() { // from class: com.baidu.tieba.video.record.i.1.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (i.this.gQO != null) {
                                        i.this.gQO.byU();
                                    }
                                }
                            });
                            byc.setOnEncoderStatusUpdateListener(null);
                        }
                    });
                    i.this.stopRecord();
                    return;
                }
                i.this.stopRecord();
                if (i.this.gQO != null) {
                    i.this.gQO.byU();
                }
            }
        }
    }

    public int getVideoDuration() {
        return this.gRy;
    }

    public void startRecord() {
        if (!this.gRB) {
            if (this.gRz != null) {
                this.gRz.setVisibility(0);
                this.gRz.setCurrentState(ProgressView.State.START);
            }
            if (!this.gRB) {
                this.gRB = true;
                this.Js = System.currentTimeMillis();
            }
            if (this.gQO != null && this.gQO.gQq != null) {
                this.gQO.gQq.startRecord();
                if (this.gQO.gSq != null) {
                    this.gQO.gSq.uy(this.gRy);
                }
            }
        }
    }

    public boolean byv() {
        if (this.gQO.gSq != null) {
            return this.gQO.gSq.byv();
        }
        return false;
    }

    public void stopRecord() {
        if (this.gRB) {
            if (this.gRz != null) {
                this.gRz.setCurrentState(ProgressView.State.PAUSE);
            }
            this.gRB = false;
            this.gRy = (int) (this.gRy + (System.currentTimeMillis() - this.Js));
            if (this.gRz != null && this.gRz.getLastProgress() != this.gRy) {
                this.gRz.uv(this.gRy);
            }
            if (this.gQO != null && this.gQO.gQq != null) {
                this.gQO.gQq.stopRecord();
            }
        }
    }

    public void byw() {
        if (!this.gRB && this.gRz != null) {
            this.gRz.setCurrentState(ProgressView.State.ROLLBACK);
        }
    }

    public void byx() {
        if (this.gRz != null) {
            this.gRz.setCurrentState(ProgressView.State.DELETE);
        }
        this.gRy = this.gRz.getLastProgress();
        if (this.gQO.gQq != null) {
            this.gQO.gQq.bye();
        }
    }

    public boolean onBackPressed() {
        return this.gRz.byu();
    }

    public int getStatus() {
        return this.mStatus;
    }

    public void setStatus(int i) {
        File[] listFiles;
        this.mStatus = i;
        if (i == 1) {
            this.gRz.setVisibility(4);
            this.gRz.reset();
            this.gRy = 0;
            File file = new File(com.baidu.tieba.video.b.gJJ);
            if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
                for (File file2 : listFiles) {
                    if (file2.getPath().startsWith("rec_tmp_")) {
                        file2.delete();
                    }
                }
            }
        }
        if (this.gRA != null) {
            for (a aVar : this.gRA) {
                aVar.ux(this.mStatus);
            }
        }
    }

    public boolean isRecording() {
        int status = getStatus();
        return status == 2 || status == 7;
    }

    public boolean byy() {
        return this.mStatus == 6;
    }

    public int getProgress() {
        return this.mProgress;
    }

    public void a(a aVar) {
        if (this.gRA == null) {
            this.gRA = new ArrayList();
        }
        this.gRA.add(aVar);
    }
}
