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
    private long Jo;
    private RecordVideoActivity gRP;
    private ProgressView gSA;
    protected List<a> gSB;
    private boolean gSC;
    private int gSz;
    private int mProgress;
    private int mStatus = 1;

    /* loaded from: classes2.dex */
    public interface a {
        void uw(int i);
    }

    public i(RecordVideoActivity recordVideoActivity) {
        this.gRP = recordVideoActivity;
        if (this.gRP != null) {
            ImageView imageView = (ImageView) this.gRP.findViewById(d.g.camera_switch);
            ImageView imageView2 = (ImageView) this.gRP.findViewById(d.g.flash_switch);
            this.gSA = (ProgressView) this.gRP.findViewById(d.g.video_progress_view);
            this.gSA.setListener(new AnonymousClass1());
            if (!com.baidu.tieba.video.record.a.mX(true)) {
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
        public void uv(int i) {
            h hVar;
            final g bya;
            i.this.mProgress = i;
            if (i == 100 && i.this.gRP != null && (hVar = i.this.gRP.gRr) != null && (bya = hVar.bya()) != null) {
                if (bya instanceof GLVideoPreviewView) {
                    bya.setOnEncoderStatusUpdateListener(new d.c() { // from class: com.baidu.tieba.video.record.i.1.1
                        @Override // com.faceunity.a.d.c
                        public void byx() {
                        }

                        @Override // com.faceunity.a.d.c
                        public void byy() {
                            com.baidu.adp.lib.g.e.fw().post(new Runnable() { // from class: com.baidu.tieba.video.record.i.1.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (i.this.gRP != null) {
                                        i.this.gRP.byS();
                                    }
                                }
                            });
                            bya.setOnEncoderStatusUpdateListener(null);
                        }
                    });
                    i.this.stopRecord();
                    return;
                }
                i.this.stopRecord();
                if (i.this.gRP != null) {
                    i.this.gRP.byS();
                }
            }
        }
    }

    public int getVideoDuration() {
        return this.gSz;
    }

    public void startRecord() {
        if (!this.gSC) {
            if (this.gSA != null) {
                this.gSA.setVisibility(0);
                this.gSA.setCurrentState(ProgressView.State.START);
            }
            if (!this.gSC) {
                this.gSC = true;
                this.Jo = System.currentTimeMillis();
            }
            if (this.gRP != null && this.gRP.gRr != null) {
                this.gRP.gRr.startRecord();
                if (this.gRP.gTr != null) {
                    this.gRP.gTr.ux(this.gSz);
                }
            }
        }
    }

    public boolean byt() {
        if (this.gRP.gTr != null) {
            return this.gRP.gTr.byt();
        }
        return false;
    }

    public void stopRecord() {
        if (this.gSC) {
            if (this.gSA != null) {
                this.gSA.setCurrentState(ProgressView.State.PAUSE);
            }
            this.gSC = false;
            this.gSz = (int) (this.gSz + (System.currentTimeMillis() - this.Jo));
            if (this.gSA != null && this.gSA.getLastProgress() != this.gSz) {
                this.gSA.uu(this.gSz);
            }
            if (this.gRP != null && this.gRP.gRr != null) {
                this.gRP.gRr.stopRecord();
            }
        }
    }

    public void byu() {
        if (!this.gSC && this.gSA != null) {
            this.gSA.setCurrentState(ProgressView.State.ROLLBACK);
        }
    }

    public void byv() {
        if (this.gSA != null) {
            this.gSA.setCurrentState(ProgressView.State.DELETE);
        }
        this.gSz = this.gSA.getLastProgress();
        if (this.gRP.gRr != null) {
            this.gRP.gRr.byc();
        }
    }

    public boolean onBackPressed() {
        return this.gSA.bys();
    }

    public int getStatus() {
        return this.mStatus;
    }

    public void setStatus(int i) {
        File[] listFiles;
        this.mStatus = i;
        if (i == 1) {
            this.gSA.setVisibility(4);
            this.gSA.reset();
            this.gSz = 0;
            File file = new File(com.baidu.tieba.video.b.gKJ);
            if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
                for (File file2 : listFiles) {
                    if (file2.getPath().startsWith("rec_tmp_")) {
                        file2.delete();
                    }
                }
            }
        }
        if (this.gSB != null) {
            for (a aVar : this.gSB) {
                aVar.uw(this.mStatus);
            }
        }
    }

    public boolean isRecording() {
        int status = getStatus();
        return status == 2 || status == 7;
    }

    public boolean byw() {
        return this.mStatus == 6;
    }

    public int getProgress() {
        return this.mProgress;
    }

    public void a(a aVar) {
        if (this.gSB == null) {
            this.gSB = new ArrayList();
        }
        this.gSB.add(aVar);
    }
}
