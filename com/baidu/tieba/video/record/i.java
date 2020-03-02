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
    private long Fp;
    private boolean aWV;
    private RecordVideoActivity kBq;
    private ProgressView kCa;
    private int mProgress;
    private int mStatus = 1;
    protected List<a> mStatusListeners;
    private int mVideoLength;

    /* loaded from: classes10.dex */
    public interface a {
        void DI(int i);
    }

    public i(RecordVideoActivity recordVideoActivity) {
        this.kBq = recordVideoActivity;
        if (this.kBq != null) {
            ImageView imageView = (ImageView) this.kBq.findViewById(R.id.camera_switch);
            ImageView imageView2 = (ImageView) this.kBq.findViewById(R.id.flash_switch);
            this.kCa = (ProgressView) this.kBq.findViewById(R.id.video_progress_view);
            this.kCa.setListener(new AnonymousClass1());
            if (!com.baidu.tieba.video.record.a.tr(true)) {
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
        public void DH(int i) {
            h hVar;
            final g cRh;
            i.this.mProgress = i;
            if (i == 100 && i.this.kBq != null && (hVar = i.this.kBq.kAU) != null && (cRh = hVar.cRh()) != null) {
                if (cRh instanceof GLVideoPreviewView) {
                    cRh.setOnEncoderStatusUpdateListener(new d.c() { // from class: com.baidu.tieba.video.record.i.1.1
                        @Override // com.faceunity.a.d.c
                        public void onStartSuccess() {
                        }

                        @Override // com.faceunity.a.d.c
                        public void onStopSuccess() {
                            com.baidu.adp.lib.f.e.gx().post(new Runnable() { // from class: com.baidu.tieba.video.record.i.1.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (i.this.kBq != null) {
                                        i.this.kBq.cRV();
                                    }
                                }
                            });
                            cRh.setOnEncoderStatusUpdateListener(null);
                        }
                    });
                    i.this.stopRecord();
                    return;
                }
                i.this.stopRecord();
                if (i.this.kBq != null) {
                    i.this.kBq.cRV();
                }
            }
        }
    }

    public int getVideoDuration() {
        return this.mVideoLength;
    }

    public void startRecord() {
        if (!this.aWV) {
            if (this.kCa != null) {
                this.kCa.setVisibility(0);
                this.kCa.setCurrentState(ProgressView.State.START);
            }
            if (!this.aWV) {
                this.aWV = true;
                this.Fp = System.currentTimeMillis();
            }
            if (this.kBq != null && this.kBq.kAU != null) {
                this.kBq.kAU.startRecord();
                if (this.kBq.kCO != null) {
                    this.kBq.kCO.DJ(this.mVideoLength);
                }
            }
        }
    }

    public boolean cRz() {
        if (this.kBq.kCO != null) {
            return this.kBq.kCO.cRz();
        }
        return false;
    }

    public void stopRecord() {
        if (this.aWV) {
            if (this.kCa != null) {
                this.kCa.setCurrentState(ProgressView.State.PAUSE);
            }
            this.aWV = false;
            this.mVideoLength = (int) (this.mVideoLength + (System.currentTimeMillis() - this.Fp));
            if (this.kCa != null && this.kCa.getLastProgress() != this.mVideoLength) {
                this.kCa.DG(this.mVideoLength);
            }
            if (this.kBq != null && this.kBq.kAU != null) {
                this.kBq.kAU.stopRecord();
            }
        }
    }

    public void cRA() {
        if (!this.aWV && this.kCa != null) {
            this.kCa.setCurrentState(ProgressView.State.ROLLBACK);
        }
    }

    public void cRB() {
        if (this.kCa != null) {
            this.kCa.setCurrentState(ProgressView.State.DELETE);
        }
        this.mVideoLength = this.kCa.getLastProgress();
        if (this.kBq.kAU != null) {
            this.kBq.kAU.cRj();
        }
    }

    public boolean onBackPressed() {
        return this.kCa.cRy();
    }

    public int getStatus() {
        return this.mStatus;
    }

    public void setStatus(int i) {
        File[] listFiles;
        this.mStatus = i;
        if (i == 1) {
            this.kCa.setVisibility(4);
            this.kCa.reset();
            this.mVideoLength = 0;
            File file = new File(com.baidu.tieba.video.c.kuN);
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
                aVar.DI(this.mStatus);
            }
        }
    }

    public boolean isRecording() {
        int status = getStatus();
        return status == 2 || status == 7;
    }

    public boolean bek() {
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
