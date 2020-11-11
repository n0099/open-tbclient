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
    private boolean cnU;
    private int mProgress;
    private int mStatus = 1;
    protected List<a> mStatusListeners;
    private RecordVideoActivity nsJ;
    private int ntr;
    private ProgressView nts;

    /* loaded from: classes23.dex */
    public interface a {
        void KR(int i);
    }

    public i(RecordVideoActivity recordVideoActivity) {
        this.nsJ = recordVideoActivity;
        if (this.nsJ != null) {
            ImageView imageView = (ImageView) this.nsJ.findViewById(R.id.camera_switch);
            ImageView imageView2 = (ImageView) this.nsJ.findViewById(R.id.flash_switch);
            this.nts = (ProgressView) this.nsJ.findViewById(R.id.video_progress_view);
            this.nts.setListener(new AnonymousClass1());
            if (!com.baidu.tieba.video.record.a.ya(true)) {
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
        public void KQ(int i) {
            h hVar;
            final g dQw;
            i.this.mProgress = i;
            if (i == 100 && i.this.nsJ != null && (hVar = i.this.nsJ.nsl) != null && (dQw = hVar.dQw()) != null) {
                if (dQw instanceof GLVideoPreviewView) {
                    dQw.setOnEncoderStatusUpdateListener(new d.c() { // from class: com.baidu.tieba.video.record.i.1.1
                        @Override // com.faceunity.a.d.c
                        public void UV() {
                        }

                        @Override // com.faceunity.a.d.c
                        public void dQS() {
                            com.baidu.adp.lib.f.e.mY().post(new Runnable() { // from class: com.baidu.tieba.video.record.i.1.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (i.this.nsJ != null) {
                                        i.this.nsJ.dRm();
                                    }
                                }
                            });
                            dQw.setOnEncoderStatusUpdateListener(null);
                        }
                    });
                    i.this.stopRecord();
                    return;
                }
                i.this.stopRecord();
                if (i.this.nsJ != null) {
                    i.this.nsJ.dRm();
                }
            }
        }
    }

    public int getVideoDuration() {
        return this.ntr;
    }

    public void startRecord() {
        if (!this.cnU) {
            if (this.nts != null) {
                this.nts.setVisibility(0);
                this.nts.setCurrentState(ProgressView.State.START);
            }
            if (!this.cnU) {
                this.cnU = true;
                this.aaK = System.currentTimeMillis();
            }
            if (this.nsJ != null && this.nsJ.nsl != null) {
                this.nsJ.nsl.startRecord();
                if (this.nsJ.nue != null) {
                    this.nsJ.nue.KS(this.ntr);
                }
            }
        }
    }

    public boolean dQP() {
        if (this.nsJ.nue != null) {
            return this.nsJ.nue.dQP();
        }
        return false;
    }

    public void stopRecord() {
        if (this.cnU) {
            if (this.nts != null) {
                this.nts.setCurrentState(ProgressView.State.PAUSE);
            }
            this.cnU = false;
            this.ntr = (int) (this.ntr + (System.currentTimeMillis() - this.aaK));
            if (this.nts != null && this.nts.getLastProgress() != this.ntr) {
                this.nts.KP(this.ntr);
            }
            if (this.nsJ != null && this.nsJ.nsl != null) {
                this.nsJ.nsl.stopRecord();
            }
        }
    }

    public void dQQ() {
        if (!this.cnU && this.nts != null) {
            this.nts.setCurrentState(ProgressView.State.ROLLBACK);
        }
    }

    public void dQR() {
        if (this.nts != null) {
            this.nts.setCurrentState(ProgressView.State.DELETE);
        }
        this.ntr = this.nts.getLastProgress();
        if (this.nsJ.nsl != null) {
            this.nsJ.nsl.dQy();
        }
    }

    public boolean onBackPressed() {
        return this.nts.dQO();
    }

    public int getStatus() {
        return this.mStatus;
    }

    public void setStatus(int i) {
        File[] listFiles;
        this.mStatus = i;
        if (i == 1) {
            this.nts.setVisibility(4);
            this.nts.reset();
            this.ntr = 0;
            File file = new File(com.baidu.tieba.video.c.nlN);
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
                aVar.KR(this.mStatus);
            }
        }
    }

    public boolean btZ() {
        int status = getStatus();
        return status == 2 || status == 7;
    }

    public boolean bRH() {
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
