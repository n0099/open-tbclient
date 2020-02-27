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
    private boolean aWU;
    private ProgressView kBY;
    private RecordVideoActivity kBo;
    private int mProgress;
    private int mStatus = 1;
    protected List<a> mStatusListeners;
    private int mVideoLength;

    /* loaded from: classes10.dex */
    public interface a {
        void DI(int i);
    }

    public i(RecordVideoActivity recordVideoActivity) {
        this.kBo = recordVideoActivity;
        if (this.kBo != null) {
            ImageView imageView = (ImageView) this.kBo.findViewById(R.id.camera_switch);
            ImageView imageView2 = (ImageView) this.kBo.findViewById(R.id.flash_switch);
            this.kBY = (ProgressView) this.kBo.findViewById(R.id.video_progress_view);
            this.kBY.setListener(new AnonymousClass1());
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
            final g cRf;
            i.this.mProgress = i;
            if (i == 100 && i.this.kBo != null && (hVar = i.this.kBo.kAS) != null && (cRf = hVar.cRf()) != null) {
                if (cRf instanceof GLVideoPreviewView) {
                    cRf.setOnEncoderStatusUpdateListener(new d.c() { // from class: com.baidu.tieba.video.record.i.1.1
                        @Override // com.faceunity.a.d.c
                        public void onStartSuccess() {
                        }

                        @Override // com.faceunity.a.d.c
                        public void onStopSuccess() {
                            com.baidu.adp.lib.f.e.gx().post(new Runnable() { // from class: com.baidu.tieba.video.record.i.1.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (i.this.kBo != null) {
                                        i.this.kBo.cRT();
                                    }
                                }
                            });
                            cRf.setOnEncoderStatusUpdateListener(null);
                        }
                    });
                    i.this.stopRecord();
                    return;
                }
                i.this.stopRecord();
                if (i.this.kBo != null) {
                    i.this.kBo.cRT();
                }
            }
        }
    }

    public int getVideoDuration() {
        return this.mVideoLength;
    }

    public void startRecord() {
        if (!this.aWU) {
            if (this.kBY != null) {
                this.kBY.setVisibility(0);
                this.kBY.setCurrentState(ProgressView.State.START);
            }
            if (!this.aWU) {
                this.aWU = true;
                this.Fp = System.currentTimeMillis();
            }
            if (this.kBo != null && this.kBo.kAS != null) {
                this.kBo.kAS.startRecord();
                if (this.kBo.kCM != null) {
                    this.kBo.kCM.DJ(this.mVideoLength);
                }
            }
        }
    }

    public boolean cRx() {
        if (this.kBo.kCM != null) {
            return this.kBo.kCM.cRx();
        }
        return false;
    }

    public void stopRecord() {
        if (this.aWU) {
            if (this.kBY != null) {
                this.kBY.setCurrentState(ProgressView.State.PAUSE);
            }
            this.aWU = false;
            this.mVideoLength = (int) (this.mVideoLength + (System.currentTimeMillis() - this.Fp));
            if (this.kBY != null && this.kBY.getLastProgress() != this.mVideoLength) {
                this.kBY.DG(this.mVideoLength);
            }
            if (this.kBo != null && this.kBo.kAS != null) {
                this.kBo.kAS.stopRecord();
            }
        }
    }

    public void cRy() {
        if (!this.aWU && this.kBY != null) {
            this.kBY.setCurrentState(ProgressView.State.ROLLBACK);
        }
    }

    public void cRz() {
        if (this.kBY != null) {
            this.kBY.setCurrentState(ProgressView.State.DELETE);
        }
        this.mVideoLength = this.kBY.getLastProgress();
        if (this.kBo.kAS != null) {
            this.kBo.kAS.cRh();
        }
    }

    public boolean onBackPressed() {
        return this.kBY.cRw();
    }

    public int getStatus() {
        return this.mStatus;
    }

    public void setStatus(int i) {
        File[] listFiles;
        this.mStatus = i;
        if (i == 1) {
            this.kBY.setVisibility(4);
            this.kBY.reset();
            this.mVideoLength = 0;
            File file = new File(com.baidu.tieba.video.c.kuL);
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

    public boolean bei() {
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
