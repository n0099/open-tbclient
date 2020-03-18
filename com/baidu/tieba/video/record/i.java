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
    private boolean aXj;
    private ProgressView kDT;
    private RecordVideoActivity kDj;
    private int mProgress;
    private int mStatus = 1;
    protected List<a> mStatusListeners;
    private int mVideoLength;

    /* loaded from: classes10.dex */
    public interface a {
        void DQ(int i);
    }

    public i(RecordVideoActivity recordVideoActivity) {
        this.kDj = recordVideoActivity;
        if (this.kDj != null) {
            ImageView imageView = (ImageView) this.kDj.findViewById(R.id.camera_switch);
            ImageView imageView2 = (ImageView) this.kDj.findViewById(R.id.flash_switch);
            this.kDT = (ProgressView) this.kDj.findViewById(R.id.video_progress_view);
            this.kDT.setListener(new AnonymousClass1());
            if (!com.baidu.tieba.video.record.a.tx(true)) {
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
        public void DP(int i) {
            h hVar;
            final g cRC;
            i.this.mProgress = i;
            if (i == 100 && i.this.kDj != null && (hVar = i.this.kDj.kCN) != null && (cRC = hVar.cRC()) != null) {
                if (cRC instanceof GLVideoPreviewView) {
                    cRC.setOnEncoderStatusUpdateListener(new d.c() { // from class: com.baidu.tieba.video.record.i.1.1
                        @Override // com.faceunity.a.d.c
                        public void onStartSuccess() {
                        }

                        @Override // com.faceunity.a.d.c
                        public void onStopSuccess() {
                            com.baidu.adp.lib.f.e.gx().post(new Runnable() { // from class: com.baidu.tieba.video.record.i.1.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (i.this.kDj != null) {
                                        i.this.kDj.cSq();
                                    }
                                }
                            });
                            cRC.setOnEncoderStatusUpdateListener(null);
                        }
                    });
                    i.this.stopRecord();
                    return;
                }
                i.this.stopRecord();
                if (i.this.kDj != null) {
                    i.this.kDj.cSq();
                }
            }
        }
    }

    public int getVideoDuration() {
        return this.mVideoLength;
    }

    public void startRecord() {
        if (!this.aXj) {
            if (this.kDT != null) {
                this.kDT.setVisibility(0);
                this.kDT.setCurrentState(ProgressView.State.START);
            }
            if (!this.aXj) {
                this.aXj = true;
                this.Fp = System.currentTimeMillis();
            }
            if (this.kDj != null && this.kDj.kCN != null) {
                this.kDj.kCN.startRecord();
                if (this.kDj.kEH != null) {
                    this.kDj.kEH.DR(this.mVideoLength);
                }
            }
        }
    }

    public boolean cRU() {
        if (this.kDj.kEH != null) {
            return this.kDj.kEH.cRU();
        }
        return false;
    }

    public void stopRecord() {
        if (this.aXj) {
            if (this.kDT != null) {
                this.kDT.setCurrentState(ProgressView.State.PAUSE);
            }
            this.aXj = false;
            this.mVideoLength = (int) (this.mVideoLength + (System.currentTimeMillis() - this.Fp));
            if (this.kDT != null && this.kDT.getLastProgress() != this.mVideoLength) {
                this.kDT.DO(this.mVideoLength);
            }
            if (this.kDj != null && this.kDj.kCN != null) {
                this.kDj.kCN.stopRecord();
            }
        }
    }

    public void cRV() {
        if (!this.aXj && this.kDT != null) {
            this.kDT.setCurrentState(ProgressView.State.ROLLBACK);
        }
    }

    public void cRW() {
        if (this.kDT != null) {
            this.kDT.setCurrentState(ProgressView.State.DELETE);
        }
        this.mVideoLength = this.kDT.getLastProgress();
        if (this.kDj.kCN != null) {
            this.kDj.kCN.cRE();
        }
    }

    public boolean onBackPressed() {
        return this.kDT.cRT();
    }

    public int getStatus() {
        return this.mStatus;
    }

    public void setStatus(int i) {
        File[] listFiles;
        this.mStatus = i;
        if (i == 1) {
            this.kDT.setVisibility(4);
            this.kDT.reset();
            this.mVideoLength = 0;
            File file = new File(com.baidu.tieba.video.c.kwD);
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
                aVar.DQ(this.mStatus);
            }
        }
    }

    public boolean isRecording() {
        int status = getStatus();
        return status == 2 || status == 7;
    }

    public boolean beq() {
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
