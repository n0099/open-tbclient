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
    private long YT;
    private boolean bDm;
    private RecordVideoActivity lGu;
    private int lHd;
    private ProgressView lHe;
    private int mProgress;
    private int mStatus = 1;
    protected List<a> mStatusListeners;

    /* loaded from: classes10.dex */
    public interface a {
        void Ff(int i);
    }

    public i(RecordVideoActivity recordVideoActivity) {
        this.lGu = recordVideoActivity;
        if (this.lGu != null) {
            ImageView imageView = (ImageView) this.lGu.findViewById(R.id.camera_switch);
            ImageView imageView2 = (ImageView) this.lGu.findViewById(R.id.flash_switch);
            this.lHe = (ProgressView) this.lGu.findViewById(R.id.video_progress_view);
            this.lHe.setListener(new AnonymousClass1());
            if (!com.baidu.tieba.video.record.a.uX(true)) {
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
        public void Fe(int i) {
            h hVar;
            final g djN;
            i.this.mProgress = i;
            if (i == 100 && i.this.lGu != null && (hVar = i.this.lGu.lFW) != null && (djN = hVar.djN()) != null) {
                if (djN instanceof GLVideoPreviewView) {
                    djN.setOnEncoderStatusUpdateListener(new d.c() { // from class: com.baidu.tieba.video.record.i.1.1
                        @Override // com.faceunity.a.d.c
                        public void Ih() {
                        }

                        @Override // com.faceunity.a.d.c
                        public void dkj() {
                            com.baidu.adp.lib.f.e.ld().post(new Runnable() { // from class: com.baidu.tieba.video.record.i.1.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (i.this.lGu != null) {
                                        i.this.lGu.dkD();
                                    }
                                }
                            });
                            djN.setOnEncoderStatusUpdateListener(null);
                        }
                    });
                    i.this.stopRecord();
                    return;
                }
                i.this.stopRecord();
                if (i.this.lGu != null) {
                    i.this.lGu.dkD();
                }
            }
        }
    }

    public int getVideoDuration() {
        return this.lHd;
    }

    public void startRecord() {
        if (!this.bDm) {
            if (this.lHe != null) {
                this.lHe.setVisibility(0);
                this.lHe.setCurrentState(ProgressView.State.START);
            }
            if (!this.bDm) {
                this.bDm = true;
                this.YT = System.currentTimeMillis();
            }
            if (this.lGu != null && this.lGu.lFW != null) {
                this.lGu.lFW.startRecord();
                if (this.lGu.lHS != null) {
                    this.lGu.lHS.Fg(this.lHd);
                }
            }
        }
    }

    public boolean dkg() {
        if (this.lGu.lHS != null) {
            return this.lGu.lHS.dkg();
        }
        return false;
    }

    public void stopRecord() {
        if (this.bDm) {
            if (this.lHe != null) {
                this.lHe.setCurrentState(ProgressView.State.PAUSE);
            }
            this.bDm = false;
            this.lHd = (int) (this.lHd + (System.currentTimeMillis() - this.YT));
            if (this.lHe != null && this.lHe.getLastProgress() != this.lHd) {
                this.lHe.Fd(this.lHd);
            }
            if (this.lGu != null && this.lGu.lFW != null) {
                this.lGu.lFW.stopRecord();
            }
        }
    }

    public void dkh() {
        if (!this.bDm && this.lHe != null) {
            this.lHe.setCurrentState(ProgressView.State.ROLLBACK);
        }
    }

    public void dki() {
        if (this.lHe != null) {
            this.lHe.setCurrentState(ProgressView.State.DELETE);
        }
        this.lHd = this.lHe.getLastProgress();
        if (this.lGu.lFW != null) {
            this.lGu.lFW.djP();
        }
    }

    public boolean onBackPressed() {
        return this.lHe.dkf();
    }

    public int getStatus() {
        return this.mStatus;
    }

    public void setStatus(int i) {
        File[] listFiles;
        this.mStatus = i;
        if (i == 1) {
            this.lHe.setVisibility(4);
            this.lHe.reset();
            this.lHd = 0;
            File file = new File(com.baidu.tieba.video.c.lzF);
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
                aVar.Ff(this.mStatus);
            }
        }
    }

    public boolean aXs() {
        int status = getStatus();
        return status == 2 || status == 7;
    }

    public boolean btw() {
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
