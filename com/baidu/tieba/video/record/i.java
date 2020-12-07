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
    private long abM;
    private boolean cte;
    private int mProgress;
    private int mStatus = 1;
    protected List<a> mStatusListeners;
    private RecordVideoActivity nHS;
    private int nIA;
    private ProgressView nIB;

    /* loaded from: classes23.dex */
    public interface a {
        void Mm(int i);
    }

    public i(RecordVideoActivity recordVideoActivity) {
        this.nHS = recordVideoActivity;
        if (this.nHS != null) {
            ImageView imageView = (ImageView) this.nHS.findViewById(R.id.camera_switch);
            ImageView imageView2 = (ImageView) this.nHS.findViewById(R.id.flash_switch);
            this.nIB = (ProgressView) this.nHS.findViewById(R.id.video_progress_view);
            this.nIB.setListener(new AnonymousClass1());
            if (!com.baidu.tieba.video.record.a.yM(true)) {
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
        public void Ml(int i) {
            h hVar;
            final g dVP;
            i.this.mProgress = i;
            if (i == 100 && i.this.nHS != null && (hVar = i.this.nHS.nHu) != null && (dVP = hVar.dVP()) != null) {
                if (dVP instanceof GLVideoPreviewView) {
                    dVP.setOnEncoderStatusUpdateListener(new d.c() { // from class: com.baidu.tieba.video.record.i.1.1
                        @Override // com.faceunity.a.d.c
                        public void WO() {
                        }

                        @Override // com.faceunity.a.d.c
                        public void dWl() {
                            com.baidu.adp.lib.f.e.mY().post(new Runnable() { // from class: com.baidu.tieba.video.record.i.1.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (i.this.nHS != null) {
                                        i.this.nHS.dWF();
                                    }
                                }
                            });
                            dVP.setOnEncoderStatusUpdateListener(null);
                        }
                    });
                    i.this.stopRecord();
                    return;
                }
                i.this.stopRecord();
                if (i.this.nHS != null) {
                    i.this.nHS.dWF();
                }
            }
        }
    }

    public int getVideoDuration() {
        return this.nIA;
    }

    public void startRecord() {
        if (!this.cte) {
            if (this.nIB != null) {
                this.nIB.setVisibility(0);
                this.nIB.setCurrentState(ProgressView.State.START);
            }
            if (!this.cte) {
                this.cte = true;
                this.abM = System.currentTimeMillis();
            }
            if (this.nHS != null && this.nHS.nHu != null) {
                this.nHS.nHu.startRecord();
                if (this.nHS.nJn != null) {
                    this.nHS.nJn.Mn(this.nIA);
                }
            }
        }
    }

    public boolean dWi() {
        if (this.nHS.nJn != null) {
            return this.nHS.nJn.dWi();
        }
        return false;
    }

    public void stopRecord() {
        if (this.cte) {
            if (this.nIB != null) {
                this.nIB.setCurrentState(ProgressView.State.PAUSE);
            }
            this.cte = false;
            this.nIA = (int) (this.nIA + (System.currentTimeMillis() - this.abM));
            if (this.nIB != null && this.nIB.getLastProgress() != this.nIA) {
                this.nIB.Mk(this.nIA);
            }
            if (this.nHS != null && this.nHS.nHu != null) {
                this.nHS.nHu.stopRecord();
            }
        }
    }

    public void dWj() {
        if (!this.cte && this.nIB != null) {
            this.nIB.setCurrentState(ProgressView.State.ROLLBACK);
        }
    }

    public void dWk() {
        if (this.nIB != null) {
            this.nIB.setCurrentState(ProgressView.State.DELETE);
        }
        this.nIA = this.nIB.getLastProgress();
        if (this.nHS.nHu != null) {
            this.nHS.nHu.dVR();
        }
    }

    public boolean onBackPressed() {
        return this.nIB.dWh();
    }

    public int getStatus() {
        return this.mStatus;
    }

    public void setStatus(int i) {
        File[] listFiles;
        this.mStatus = i;
        if (i == 1) {
            this.nIB.setVisibility(4);
            this.nIB.reset();
            this.nIA = 0;
            File file = new File(com.baidu.tieba.video.c.nAX);
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
                aVar.Mm(this.mStatus);
            }
        }
    }

    public boolean bwP() {
        int status = getStatus();
        return status == 2 || status == 7;
    }

    public boolean bUK() {
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
