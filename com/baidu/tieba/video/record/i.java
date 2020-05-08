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
    private long YE;
    private boolean bvJ;
    private RecordVideoActivity lnL;
    private int loy;
    private ProgressView loz;
    private int mProgress;
    private int mStatus = 1;
    protected List<a> mStatusListeners;

    /* loaded from: classes10.dex */
    public interface a {
        void Eu(int i);
    }

    public i(RecordVideoActivity recordVideoActivity) {
        this.lnL = recordVideoActivity;
        if (this.lnL != null) {
            ImageView imageView = (ImageView) this.lnL.findViewById(R.id.camera_switch);
            ImageView imageView2 = (ImageView) this.lnL.findViewById(R.id.flash_switch);
            this.loz = (ProgressView) this.lnL.findViewById(R.id.video_progress_view);
            this.loz.setListener(new AnonymousClass1());
            if (!com.baidu.tieba.video.record.a.uz(true)) {
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
        public void Et(int i) {
            h hVar;
            final g dcy;
            i.this.mProgress = i;
            if (i == 100 && i.this.lnL != null && (hVar = i.this.lnL.lnn) != null && (dcy = hVar.dcy()) != null) {
                if (dcy instanceof GLVideoPreviewView) {
                    dcy.setOnEncoderStatusUpdateListener(new d.c() { // from class: com.baidu.tieba.video.record.i.1.1
                        @Override // com.faceunity.a.d.c
                        public void Go() {
                        }

                        @Override // com.faceunity.a.d.c
                        public void dcU() {
                            com.baidu.adp.lib.f.e.lb().post(new Runnable() { // from class: com.baidu.tieba.video.record.i.1.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (i.this.lnL != null) {
                                        i.this.lnL.ddo();
                                    }
                                }
                            });
                            dcy.setOnEncoderStatusUpdateListener(null);
                        }
                    });
                    i.this.stopRecord();
                    return;
                }
                i.this.stopRecord();
                if (i.this.lnL != null) {
                    i.this.lnL.ddo();
                }
            }
        }
    }

    public int getVideoDuration() {
        return this.loy;
    }

    public void startRecord() {
        if (!this.bvJ) {
            if (this.loz != null) {
                this.loz.setVisibility(0);
                this.loz.setCurrentState(ProgressView.State.START);
            }
            if (!this.bvJ) {
                this.bvJ = true;
                this.YE = System.currentTimeMillis();
            }
            if (this.lnL != null && this.lnL.lnn != null) {
                this.lnL.lnn.startRecord();
                if (this.lnL.lpn != null) {
                    this.lnL.lpn.Ev(this.loy);
                }
            }
        }
    }

    public boolean dcR() {
        if (this.lnL.lpn != null) {
            return this.lnL.lpn.dcR();
        }
        return false;
    }

    public void stopRecord() {
        if (this.bvJ) {
            if (this.loz != null) {
                this.loz.setCurrentState(ProgressView.State.PAUSE);
            }
            this.bvJ = false;
            this.loy = (int) (this.loy + (System.currentTimeMillis() - this.YE));
            if (this.loz != null && this.loz.getLastProgress() != this.loy) {
                this.loz.Es(this.loy);
            }
            if (this.lnL != null && this.lnL.lnn != null) {
                this.lnL.lnn.stopRecord();
            }
        }
    }

    public void dcS() {
        if (!this.bvJ && this.loz != null) {
            this.loz.setCurrentState(ProgressView.State.ROLLBACK);
        }
    }

    public void dcT() {
        if (this.loz != null) {
            this.loz.setCurrentState(ProgressView.State.DELETE);
        }
        this.loy = this.loz.getLastProgress();
        if (this.lnL.lnn != null) {
            this.lnL.lnn.dcA();
        }
    }

    public boolean onBackPressed() {
        return this.loz.dcQ();
    }

    public int getStatus() {
        return this.mStatus;
    }

    public void setStatus(int i) {
        File[] listFiles;
        this.mStatus = i;
        if (i == 1) {
            this.loz.setVisibility(4);
            this.loz.reset();
            this.loy = 0;
            File file = new File(com.baidu.tieba.video.c.lgU);
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
                aVar.Eu(this.mStatus);
            }
        }
    }

    public boolean aRl() {
        int status = getStatus();
        return status == 2 || status == 7;
    }

    public boolean bnE() {
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
