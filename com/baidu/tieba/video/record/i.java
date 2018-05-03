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
    private RecordVideoActivity gQL;
    private int gRv;
    private ProgressView gRw;
    protected List<a> gRx;
    private boolean gRy;
    private int mProgress;
    private int mStatus = 1;

    /* loaded from: classes2.dex */
    public interface a {
        void ux(int i);
    }

    public i(RecordVideoActivity recordVideoActivity) {
        this.gQL = recordVideoActivity;
        if (this.gQL != null) {
            ImageView imageView = (ImageView) this.gQL.findViewById(d.g.camera_switch);
            ImageView imageView2 = (ImageView) this.gQL.findViewById(d.g.flash_switch);
            this.gRw = (ProgressView) this.gQL.findViewById(d.g.video_progress_view);
            this.gRw.setListener(new AnonymousClass1());
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
            if (i == 100 && i.this.gQL != null && (hVar = i.this.gQL.gQn) != null && (byc = hVar.byc()) != null) {
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
                                    if (i.this.gQL != null) {
                                        i.this.gQL.byU();
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
                if (i.this.gQL != null) {
                    i.this.gQL.byU();
                }
            }
        }
    }

    public int getVideoDuration() {
        return this.gRv;
    }

    public void startRecord() {
        if (!this.gRy) {
            if (this.gRw != null) {
                this.gRw.setVisibility(0);
                this.gRw.setCurrentState(ProgressView.State.START);
            }
            if (!this.gRy) {
                this.gRy = true;
                this.Js = System.currentTimeMillis();
            }
            if (this.gQL != null && this.gQL.gQn != null) {
                this.gQL.gQn.startRecord();
                if (this.gQL.gSn != null) {
                    this.gQL.gSn.uy(this.gRv);
                }
            }
        }
    }

    public boolean byv() {
        if (this.gQL.gSn != null) {
            return this.gQL.gSn.byv();
        }
        return false;
    }

    public void stopRecord() {
        if (this.gRy) {
            if (this.gRw != null) {
                this.gRw.setCurrentState(ProgressView.State.PAUSE);
            }
            this.gRy = false;
            this.gRv = (int) (this.gRv + (System.currentTimeMillis() - this.Js));
            if (this.gRw != null && this.gRw.getLastProgress() != this.gRv) {
                this.gRw.uv(this.gRv);
            }
            if (this.gQL != null && this.gQL.gQn != null) {
                this.gQL.gQn.stopRecord();
            }
        }
    }

    public void byw() {
        if (!this.gRy && this.gRw != null) {
            this.gRw.setCurrentState(ProgressView.State.ROLLBACK);
        }
    }

    public void byx() {
        if (this.gRw != null) {
            this.gRw.setCurrentState(ProgressView.State.DELETE);
        }
        this.gRv = this.gRw.getLastProgress();
        if (this.gQL.gQn != null) {
            this.gQL.gQn.bye();
        }
    }

    public boolean onBackPressed() {
        return this.gRw.byu();
    }

    public int getStatus() {
        return this.mStatus;
    }

    public void setStatus(int i) {
        File[] listFiles;
        this.mStatus = i;
        if (i == 1) {
            this.gRw.setVisibility(4);
            this.gRw.reset();
            this.gRv = 0;
            File file = new File(com.baidu.tieba.video.b.gJG);
            if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
                for (File file2 : listFiles) {
                    if (file2.getPath().startsWith("rec_tmp_")) {
                        file2.delete();
                    }
                }
            }
        }
        if (this.gRx != null) {
            for (a aVar : this.gRx) {
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
        if (this.gRx == null) {
            this.gRx = new ArrayList();
        }
        this.gRx.add(aVar);
    }
}
