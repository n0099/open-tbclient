package com.baidu.tieba.video.record;

import android.widget.ImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.video.record.ProgressView;
import com.faceunity.a.d;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes17.dex */
public class i {
    private long Zt;
    private boolean bIz;
    private int mProgress;
    private int mStatus = 1;
    protected List<a> mStatusListeners;
    private RecordVideoActivity miN;
    private int mjw;
    private ProgressView mjx;

    /* loaded from: classes17.dex */
    public interface a {
        void GG(int i);
    }

    public i(RecordVideoActivity recordVideoActivity) {
        this.miN = recordVideoActivity;
        if (this.miN != null) {
            ImageView imageView = (ImageView) this.miN.findViewById(R.id.camera_switch);
            ImageView imageView2 = (ImageView) this.miN.findViewById(R.id.flash_switch);
            this.mjx = (ProgressView) this.miN.findViewById(R.id.video_progress_view);
            this.mjx.setListener(new AnonymousClass1());
            if (!com.baidu.tieba.video.record.a.vT(true)) {
                imageView2.setVisibility(4);
            }
            if (!com.baidu.tieba.video.record.a.b(recordVideoActivity.getPackageManager())) {
                imageView.setVisibility(8);
            }
        }
    }

    /* renamed from: com.baidu.tieba.video.record.i$1  reason: invalid class name */
    /* loaded from: classes17.dex */
    class AnonymousClass1 implements ProgressView.a {
        AnonymousClass1() {
        }

        @Override // com.baidu.tieba.video.record.ProgressView.a
        public void GF(int i) {
            h hVar;
            final g drB;
            i.this.mProgress = i;
            if (i == 100 && i.this.miN != null && (hVar = i.this.miN.mip) != null && (drB = hVar.drB()) != null) {
                if (drB instanceof GLVideoPreviewView) {
                    drB.setOnEncoderStatusUpdateListener(new d.c() { // from class: com.baidu.tieba.video.record.i.1.1
                        @Override // com.faceunity.a.d.c
                        public void JB() {
                        }

                        @Override // com.faceunity.a.d.c
                        public void drX() {
                            com.baidu.adp.lib.f.e.lt().post(new Runnable() { // from class: com.baidu.tieba.video.record.i.1.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (i.this.miN != null) {
                                        i.this.miN.dsr();
                                    }
                                }
                            });
                            drB.setOnEncoderStatusUpdateListener(null);
                        }
                    });
                    i.this.stopRecord();
                    return;
                }
                i.this.stopRecord();
                if (i.this.miN != null) {
                    i.this.miN.dsr();
                }
            }
        }
    }

    public int getVideoDuration() {
        return this.mjw;
    }

    public void startRecord() {
        if (!this.bIz) {
            if (this.mjx != null) {
                this.mjx.setVisibility(0);
                this.mjx.setCurrentState(ProgressView.State.START);
            }
            if (!this.bIz) {
                this.bIz = true;
                this.Zt = System.currentTimeMillis();
            }
            if (this.miN != null && this.miN.mip != null) {
                this.miN.mip.startRecord();
                if (this.miN.mkk != null) {
                    this.miN.mkk.GH(this.mjw);
                }
            }
        }
    }

    public boolean drU() {
        if (this.miN.mkk != null) {
            return this.miN.mkk.drU();
        }
        return false;
    }

    public void stopRecord() {
        if (this.bIz) {
            if (this.mjx != null) {
                this.mjx.setCurrentState(ProgressView.State.PAUSE);
            }
            this.bIz = false;
            this.mjw = (int) (this.mjw + (System.currentTimeMillis() - this.Zt));
            if (this.mjx != null && this.mjx.getLastProgress() != this.mjw) {
                this.mjx.GE(this.mjw);
            }
            if (this.miN != null && this.miN.mip != null) {
                this.miN.mip.stopRecord();
            }
        }
    }

    public void drV() {
        if (!this.bIz && this.mjx != null) {
            this.mjx.setCurrentState(ProgressView.State.ROLLBACK);
        }
    }

    public void drW() {
        if (this.mjx != null) {
            this.mjx.setCurrentState(ProgressView.State.DELETE);
        }
        this.mjw = this.mjx.getLastProgress();
        if (this.miN.mip != null) {
            this.miN.mip.drD();
        }
    }

    public boolean onBackPressed() {
        return this.mjx.drT();
    }

    public int getStatus() {
        return this.mStatus;
    }

    public void setStatus(int i) {
        File[] listFiles;
        this.mStatus = i;
        if (i == 1) {
            this.mjx.setVisibility(4);
            this.mjx.reset();
            this.mjw = 0;
            File file = new File(com.baidu.tieba.video.c.mbN);
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
                aVar.GG(this.mStatus);
            }
        }
    }

    public boolean bdw() {
        int status = getStatus();
        return status == 2 || status == 7;
    }

    public boolean bzK() {
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
