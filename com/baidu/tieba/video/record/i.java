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
    private long ZY;
    private boolean bOa;
    private RecordVideoActivity mAx;
    private int mBh;
    private ProgressView mBi;
    private int mProgress;
    private int mStatus = 1;
    protected List<a> mStatusListeners;

    /* loaded from: classes17.dex */
    public interface a {
        void Jc(int i);
    }

    public i(RecordVideoActivity recordVideoActivity) {
        this.mAx = recordVideoActivity;
        if (this.mAx != null) {
            ImageView imageView = (ImageView) this.mAx.findViewById(R.id.camera_switch);
            ImageView imageView2 = (ImageView) this.mAx.findViewById(R.id.flash_switch);
            this.mBi = (ProgressView) this.mAx.findViewById(R.id.video_progress_view);
            this.mBi.setListener(new AnonymousClass1());
            if (!com.baidu.tieba.video.record.a.wI(true)) {
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
        public void Jb(int i) {
            h hVar;
            final g dCX;
            i.this.mProgress = i;
            if (i == 100 && i.this.mAx != null && (hVar = i.this.mAx.mzZ) != null && (dCX = hVar.dCX()) != null) {
                if (dCX instanceof GLVideoPreviewView) {
                    dCX.setOnEncoderStatusUpdateListener(new d.c() { // from class: com.baidu.tieba.video.record.i.1.1
                        @Override // com.faceunity.a.d.c
                        public void Pt() {
                        }

                        @Override // com.faceunity.a.d.c
                        public void dDt() {
                            com.baidu.adp.lib.f.e.mS().post(new Runnable() { // from class: com.baidu.tieba.video.record.i.1.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (i.this.mAx != null) {
                                        i.this.mAx.dDN();
                                    }
                                }
                            });
                            dCX.setOnEncoderStatusUpdateListener(null);
                        }
                    });
                    i.this.stopRecord();
                    return;
                }
                i.this.stopRecord();
                if (i.this.mAx != null) {
                    i.this.mAx.dDN();
                }
            }
        }
    }

    public int getVideoDuration() {
        return this.mBh;
    }

    public void startRecord() {
        if (!this.bOa) {
            if (this.mBi != null) {
                this.mBi.setVisibility(0);
                this.mBi.setCurrentState(ProgressView.State.START);
            }
            if (!this.bOa) {
                this.bOa = true;
                this.ZY = System.currentTimeMillis();
            }
            if (this.mAx != null && this.mAx.mzZ != null) {
                this.mAx.mzZ.startRecord();
                if (this.mAx.mBV != null) {
                    this.mAx.mBV.Jd(this.mBh);
                }
            }
        }
    }

    public boolean dDq() {
        if (this.mAx.mBV != null) {
            return this.mAx.mBV.dDq();
        }
        return false;
    }

    public void stopRecord() {
        if (this.bOa) {
            if (this.mBi != null) {
                this.mBi.setCurrentState(ProgressView.State.PAUSE);
            }
            this.bOa = false;
            this.mBh = (int) (this.mBh + (System.currentTimeMillis() - this.ZY));
            if (this.mBi != null && this.mBi.getLastProgress() != this.mBh) {
                this.mBi.Ja(this.mBh);
            }
            if (this.mAx != null && this.mAx.mzZ != null) {
                this.mAx.mzZ.stopRecord();
            }
        }
    }

    public void dDr() {
        if (!this.bOa && this.mBi != null) {
            this.mBi.setCurrentState(ProgressView.State.ROLLBACK);
        }
    }

    public void dDs() {
        if (this.mBi != null) {
            this.mBi.setCurrentState(ProgressView.State.DELETE);
        }
        this.mBh = this.mBi.getLastProgress();
        if (this.mAx.mzZ != null) {
            this.mAx.mzZ.dCZ();
        }
    }

    public boolean onBackPressed() {
        return this.mBi.dDp();
    }

    public int getStatus() {
        return this.mStatus;
    }

    public void setStatus(int i) {
        File[] listFiles;
        this.mStatus = i;
        if (i == 1) {
            this.mBi.setVisibility(4);
            this.mBi.reset();
            this.mBh = 0;
            File file = new File(com.baidu.tieba.video.c.mtA);
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
                aVar.Jc(this.mStatus);
            }
        }
    }

    public boolean bmc() {
        int status = getStatus();
        return status == 2 || status == 7;
    }

    public boolean bIN() {
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
