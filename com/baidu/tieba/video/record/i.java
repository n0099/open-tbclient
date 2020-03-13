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
    private boolean aWW;
    private RecordVideoActivity kBC;
    private ProgressView kCm;
    private int mProgress;
    private int mStatus = 1;
    protected List<a> mStatusListeners;
    private int mVideoLength;

    /* loaded from: classes10.dex */
    public interface a {
        void DI(int i);
    }

    public i(RecordVideoActivity recordVideoActivity) {
        this.kBC = recordVideoActivity;
        if (this.kBC != null) {
            ImageView imageView = (ImageView) this.kBC.findViewById(R.id.camera_switch);
            ImageView imageView2 = (ImageView) this.kBC.findViewById(R.id.flash_switch);
            this.kCm = (ProgressView) this.kBC.findViewById(R.id.video_progress_view);
            this.kCm.setListener(new AnonymousClass1());
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
            final g cRi;
            i.this.mProgress = i;
            if (i == 100 && i.this.kBC != null && (hVar = i.this.kBC.kBg) != null && (cRi = hVar.cRi()) != null) {
                if (cRi instanceof GLVideoPreviewView) {
                    cRi.setOnEncoderStatusUpdateListener(new d.c() { // from class: com.baidu.tieba.video.record.i.1.1
                        @Override // com.faceunity.a.d.c
                        public void onStartSuccess() {
                        }

                        @Override // com.faceunity.a.d.c
                        public void onStopSuccess() {
                            com.baidu.adp.lib.f.e.gx().post(new Runnable() { // from class: com.baidu.tieba.video.record.i.1.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (i.this.kBC != null) {
                                        i.this.kBC.cRW();
                                    }
                                }
                            });
                            cRi.setOnEncoderStatusUpdateListener(null);
                        }
                    });
                    i.this.stopRecord();
                    return;
                }
                i.this.stopRecord();
                if (i.this.kBC != null) {
                    i.this.kBC.cRW();
                }
            }
        }
    }

    public int getVideoDuration() {
        return this.mVideoLength;
    }

    public void startRecord() {
        if (!this.aWW) {
            if (this.kCm != null) {
                this.kCm.setVisibility(0);
                this.kCm.setCurrentState(ProgressView.State.START);
            }
            if (!this.aWW) {
                this.aWW = true;
                this.Fp = System.currentTimeMillis();
            }
            if (this.kBC != null && this.kBC.kBg != null) {
                this.kBC.kBg.startRecord();
                if (this.kBC.kDa != null) {
                    this.kBC.kDa.DJ(this.mVideoLength);
                }
            }
        }
    }

    public boolean cRA() {
        if (this.kBC.kDa != null) {
            return this.kBC.kDa.cRA();
        }
        return false;
    }

    public void stopRecord() {
        if (this.aWW) {
            if (this.kCm != null) {
                this.kCm.setCurrentState(ProgressView.State.PAUSE);
            }
            this.aWW = false;
            this.mVideoLength = (int) (this.mVideoLength + (System.currentTimeMillis() - this.Fp));
            if (this.kCm != null && this.kCm.getLastProgress() != this.mVideoLength) {
                this.kCm.DG(this.mVideoLength);
            }
            if (this.kBC != null && this.kBC.kBg != null) {
                this.kBC.kBg.stopRecord();
            }
        }
    }

    public void cRB() {
        if (!this.aWW && this.kCm != null) {
            this.kCm.setCurrentState(ProgressView.State.ROLLBACK);
        }
    }

    public void cRC() {
        if (this.kCm != null) {
            this.kCm.setCurrentState(ProgressView.State.DELETE);
        }
        this.mVideoLength = this.kCm.getLastProgress();
        if (this.kBC.kBg != null) {
            this.kBC.kBg.cRk();
        }
    }

    public boolean onBackPressed() {
        return this.kCm.cRz();
    }

    public int getStatus() {
        return this.mStatus;
    }

    public void setStatus(int i) {
        File[] listFiles;
        this.mStatus = i;
        if (i == 1) {
            this.kCm.setVisibility(4);
            this.kCm.reset();
            this.mVideoLength = 0;
            File file = new File(com.baidu.tieba.video.c.kuZ);
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

    public boolean bel() {
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
