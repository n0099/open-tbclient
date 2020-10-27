package com.baidu.tieba.video.record;

import android.widget.ImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.video.record.ProgressView;
import com.faceunity.a.d;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes23.dex */
public class i {
    private long aaK;
    private boolean chY;
    private int mProgress;
    private int mStatus = 1;
    protected List<a> mStatusListeners;
    private RecordVideoActivity nmM;
    private int nnu;
    private ProgressView nnv;

    /* loaded from: classes23.dex */
    public interface a {
        void KE(int i);
    }

    public i(RecordVideoActivity recordVideoActivity) {
        this.nmM = recordVideoActivity;
        if (this.nmM != null) {
            ImageView imageView = (ImageView) this.nmM.findViewById(R.id.camera_switch);
            ImageView imageView2 = (ImageView) this.nmM.findViewById(R.id.flash_switch);
            this.nnv = (ProgressView) this.nmM.findViewById(R.id.video_progress_view);
            this.nnv.setListener(new AnonymousClass1());
            if (!com.baidu.tieba.video.record.a.xR(true)) {
                imageView2.setVisibility(4);
            }
            if (!com.baidu.tieba.video.record.a.b(recordVideoActivity.getPackageManager())) {
                imageView.setVisibility(8);
            }
        }
    }

    /* renamed from: com.baidu.tieba.video.record.i$1  reason: invalid class name */
    /* loaded from: classes23.dex */
    class AnonymousClass1 implements ProgressView.a {
        AnonymousClass1() {
        }

        @Override // com.baidu.tieba.video.record.ProgressView.a
        public void KD(int i) {
            h hVar;
            final g dNU;
            i.this.mProgress = i;
            if (i == 100 && i.this.nmM != null && (hVar = i.this.nmM.nmo) != null && (dNU = hVar.dNU()) != null) {
                if (dNU instanceof GLVideoPreviewView) {
                    dNU.setOnEncoderStatusUpdateListener(new d.c() { // from class: com.baidu.tieba.video.record.i.1.1
                        @Override // com.faceunity.a.d.c
                        public void Sm() {
                        }

                        @Override // com.faceunity.a.d.c
                        public void dOq() {
                            com.baidu.adp.lib.f.e.mY().post(new Runnable() { // from class: com.baidu.tieba.video.record.i.1.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (i.this.nmM != null) {
                                        i.this.nmM.dOK();
                                    }
                                }
                            });
                            dNU.setOnEncoderStatusUpdateListener(null);
                        }
                    });
                    i.this.stopRecord();
                    return;
                }
                i.this.stopRecord();
                if (i.this.nmM != null) {
                    i.this.nmM.dOK();
                }
            }
        }
    }

    public int getVideoDuration() {
        return this.nnu;
    }

    public void startRecord() {
        if (!this.chY) {
            if (this.nnv != null) {
                this.nnv.setVisibility(0);
                this.nnv.setCurrentState(ProgressView.State.START);
            }
            if (!this.chY) {
                this.chY = true;
                this.aaK = System.currentTimeMillis();
            }
            if (this.nmM != null && this.nmM.nmo != null) {
                this.nmM.nmo.startRecord();
                if (this.nmM.noi != null) {
                    this.nmM.noi.KF(this.nnu);
                }
            }
        }
    }

    public boolean dOn() {
        if (this.nmM.noi != null) {
            return this.nmM.noi.dOn();
        }
        return false;
    }

    public void stopRecord() {
        if (this.chY) {
            if (this.nnv != null) {
                this.nnv.setCurrentState(ProgressView.State.PAUSE);
            }
            this.chY = false;
            this.nnu = (int) (this.nnu + (System.currentTimeMillis() - this.aaK));
            if (this.nnv != null && this.nnv.getLastProgress() != this.nnu) {
                this.nnv.KC(this.nnu);
            }
            if (this.nmM != null && this.nmM.nmo != null) {
                this.nmM.nmo.stopRecord();
            }
        }
    }

    public void dOo() {
        if (!this.chY && this.nnv != null) {
            this.nnv.setCurrentState(ProgressView.State.ROLLBACK);
        }
    }

    public void dOp() {
        if (this.nnv != null) {
            this.nnv.setCurrentState(ProgressView.State.DELETE);
        }
        this.nnu = this.nnv.getLastProgress();
        if (this.nmM.nmo != null) {
            this.nmM.nmo.dNW();
        }
    }

    public boolean onBackPressed() {
        return this.nnv.dOm();
    }

    public int getStatus() {
        return this.mStatus;
    }

    public void setStatus(int i) {
        File[] listFiles;
        this.mStatus = i;
        if (i == 1) {
            this.nnv.setVisibility(4);
            this.nnv.reset();
            this.nnu = 0;
            File file = new File(com.baidu.tieba.video.c.nfR);
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
                aVar.KE(this.mStatus);
            }
        }
    }

    public boolean brz() {
        int status = getStatus();
        return status == 2 || status == 7;
    }

    public boolean bPh() {
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
