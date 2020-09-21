package com.baidu.tieba.video.record;

import android.widget.ImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.video.record.ProgressView;
import com.faceunity.a.d;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes22.dex */
public class i {
    private long aat;
    private boolean bQe;
    private RecordVideoActivity mKF;
    private int mLo;
    private ProgressView mLp;
    private int mProgress;
    private int mStatus = 1;
    protected List<a> mStatusListeners;

    /* loaded from: classes22.dex */
    public interface a {
        void JG(int i);
    }

    public i(RecordVideoActivity recordVideoActivity) {
        this.mKF = recordVideoActivity;
        if (this.mKF != null) {
            ImageView imageView = (ImageView) this.mKF.findViewById(R.id.camera_switch);
            ImageView imageView2 = (ImageView) this.mKF.findViewById(R.id.flash_switch);
            this.mLp = (ProgressView) this.mKF.findViewById(R.id.video_progress_view);
            this.mLp.setListener(new AnonymousClass1());
            if (!com.baidu.tieba.video.record.a.wT(true)) {
                imageView2.setVisibility(4);
            }
            if (!com.baidu.tieba.video.record.a.b(recordVideoActivity.getPackageManager())) {
                imageView.setVisibility(8);
            }
        }
    }

    /* renamed from: com.baidu.tieba.video.record.i$1  reason: invalid class name */
    /* loaded from: classes22.dex */
    class AnonymousClass1 implements ProgressView.a {
        AnonymousClass1() {
        }

        @Override // com.baidu.tieba.video.record.ProgressView.a
        public void JF(int i) {
            h hVar;
            final g dHa;
            i.this.mProgress = i;
            if (i == 100 && i.this.mKF != null && (hVar = i.this.mKF.mKh) != null && (dHa = hVar.dHa()) != null) {
                if (dHa instanceof GLVideoPreviewView) {
                    dHa.setOnEncoderStatusUpdateListener(new d.c() { // from class: com.baidu.tieba.video.record.i.1.1
                        @Override // com.faceunity.a.d.c
                        public void Qb() {
                        }

                        @Override // com.faceunity.a.d.c
                        public void dHw() {
                            com.baidu.adp.lib.f.e.mX().post(new Runnable() { // from class: com.baidu.tieba.video.record.i.1.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (i.this.mKF != null) {
                                        i.this.mKF.dHQ();
                                    }
                                }
                            });
                            dHa.setOnEncoderStatusUpdateListener(null);
                        }
                    });
                    i.this.stopRecord();
                    return;
                }
                i.this.stopRecord();
                if (i.this.mKF != null) {
                    i.this.mKF.dHQ();
                }
            }
        }
    }

    public int getVideoDuration() {
        return this.mLo;
    }

    public void startRecord() {
        if (!this.bQe) {
            if (this.mLp != null) {
                this.mLp.setVisibility(0);
                this.mLp.setCurrentState(ProgressView.State.START);
            }
            if (!this.bQe) {
                this.bQe = true;
                this.aat = System.currentTimeMillis();
            }
            if (this.mKF != null && this.mKF.mKh != null) {
                this.mKF.mKh.startRecord();
                if (this.mKF.mMc != null) {
                    this.mKF.mMc.JH(this.mLo);
                }
            }
        }
    }

    public boolean dHt() {
        if (this.mKF.mMc != null) {
            return this.mKF.mMc.dHt();
        }
        return false;
    }

    public void stopRecord() {
        if (this.bQe) {
            if (this.mLp != null) {
                this.mLp.setCurrentState(ProgressView.State.PAUSE);
            }
            this.bQe = false;
            this.mLo = (int) (this.mLo + (System.currentTimeMillis() - this.aat));
            if (this.mLp != null && this.mLp.getLastProgress() != this.mLo) {
                this.mLp.JE(this.mLo);
            }
            if (this.mKF != null && this.mKF.mKh != null) {
                this.mKF.mKh.stopRecord();
            }
        }
    }

    public void dHu() {
        if (!this.bQe && this.mLp != null) {
            this.mLp.setCurrentState(ProgressView.State.ROLLBACK);
        }
    }

    public void dHv() {
        if (this.mLp != null) {
            this.mLp.setCurrentState(ProgressView.State.DELETE);
        }
        this.mLo = this.mLp.getLastProgress();
        if (this.mKF.mKh != null) {
            this.mKF.mKh.dHc();
        }
    }

    public boolean onBackPressed() {
        return this.mLp.dHs();
    }

    public int getStatus() {
        return this.mStatus;
    }

    public void setStatus(int i) {
        File[] listFiles;
        this.mStatus = i;
        if (i == 1) {
            this.mLp.setVisibility(4);
            this.mLp.reset();
            this.mLo = 0;
            File file = new File(com.baidu.tieba.video.c.mDD);
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
                aVar.JG(this.mStatus);
            }
        }
    }

    public boolean bmW() {
        int status = getStatus();
        return status == 2 || status == 7;
    }

    public boolean bJX() {
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
