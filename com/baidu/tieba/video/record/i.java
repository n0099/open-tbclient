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
    private RecordVideoActivity miP;
    private int mjy;
    private ProgressView mjz;

    /* loaded from: classes17.dex */
    public interface a {
        void GG(int i);
    }

    public i(RecordVideoActivity recordVideoActivity) {
        this.miP = recordVideoActivity;
        if (this.miP != null) {
            ImageView imageView = (ImageView) this.miP.findViewById(R.id.camera_switch);
            ImageView imageView2 = (ImageView) this.miP.findViewById(R.id.flash_switch);
            this.mjz = (ProgressView) this.miP.findViewById(R.id.video_progress_view);
            this.mjz.setListener(new AnonymousClass1());
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
            final g drC;
            i.this.mProgress = i;
            if (i == 100 && i.this.miP != null && (hVar = i.this.miP.mir) != null && (drC = hVar.drC()) != null) {
                if (drC instanceof GLVideoPreviewView) {
                    drC.setOnEncoderStatusUpdateListener(new d.c() { // from class: com.baidu.tieba.video.record.i.1.1
                        @Override // com.faceunity.a.d.c
                        public void JB() {
                        }

                        @Override // com.faceunity.a.d.c
                        public void drY() {
                            com.baidu.adp.lib.f.e.lt().post(new Runnable() { // from class: com.baidu.tieba.video.record.i.1.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (i.this.miP != null) {
                                        i.this.miP.dss();
                                    }
                                }
                            });
                            drC.setOnEncoderStatusUpdateListener(null);
                        }
                    });
                    i.this.stopRecord();
                    return;
                }
                i.this.stopRecord();
                if (i.this.miP != null) {
                    i.this.miP.dss();
                }
            }
        }
    }

    public int getVideoDuration() {
        return this.mjy;
    }

    public void startRecord() {
        if (!this.bIz) {
            if (this.mjz != null) {
                this.mjz.setVisibility(0);
                this.mjz.setCurrentState(ProgressView.State.START);
            }
            if (!this.bIz) {
                this.bIz = true;
                this.Zt = System.currentTimeMillis();
            }
            if (this.miP != null && this.miP.mir != null) {
                this.miP.mir.startRecord();
                if (this.miP.mkm != null) {
                    this.miP.mkm.GH(this.mjy);
                }
            }
        }
    }

    public boolean drV() {
        if (this.miP.mkm != null) {
            return this.miP.mkm.drV();
        }
        return false;
    }

    public void stopRecord() {
        if (this.bIz) {
            if (this.mjz != null) {
                this.mjz.setCurrentState(ProgressView.State.PAUSE);
            }
            this.bIz = false;
            this.mjy = (int) (this.mjy + (System.currentTimeMillis() - this.Zt));
            if (this.mjz != null && this.mjz.getLastProgress() != this.mjy) {
                this.mjz.GE(this.mjy);
            }
            if (this.miP != null && this.miP.mir != null) {
                this.miP.mir.stopRecord();
            }
        }
    }

    public void drW() {
        if (!this.bIz && this.mjz != null) {
            this.mjz.setCurrentState(ProgressView.State.ROLLBACK);
        }
    }

    public void drX() {
        if (this.mjz != null) {
            this.mjz.setCurrentState(ProgressView.State.DELETE);
        }
        this.mjy = this.mjz.getLastProgress();
        if (this.miP.mir != null) {
            this.miP.mir.drE();
        }
    }

    public boolean onBackPressed() {
        return this.mjz.drU();
    }

    public int getStatus() {
        return this.mStatus;
    }

    public void setStatus(int i) {
        File[] listFiles;
        this.mStatus = i;
        if (i == 1) {
            this.mjz.setVisibility(4);
            this.mjz.reset();
            this.mjy = 0;
            File file = new File(com.baidu.tieba.video.c.mbP);
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
