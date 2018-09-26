package com.baidu.tieba.video.record;

import android.widget.ImageView;
import com.baidu.tieba.e;
import com.baidu.tieba.video.record.ProgressView;
import com.faceunity.a.d;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class i {
    private long Sg;
    private RecordVideoActivity hqA;
    private int hrl;
    private ProgressView hrm;
    protected List<a> hrn;
    private boolean hro;
    private int mProgress;
    private int mStatus = 1;

    /* loaded from: classes2.dex */
    public interface a {
        void vq(int i);
    }

    public i(RecordVideoActivity recordVideoActivity) {
        this.hqA = recordVideoActivity;
        if (this.hqA != null) {
            ImageView imageView = (ImageView) this.hqA.findViewById(e.g.camera_switch);
            ImageView imageView2 = (ImageView) this.hqA.findViewById(e.g.flash_switch);
            this.hrm = (ProgressView) this.hqA.findViewById(e.g.video_progress_view);
            this.hrm.setListener(new AnonymousClass1());
            if (!com.baidu.tieba.video.record.a.nu(true)) {
                imageView2.setVisibility(4);
            }
            if (!com.baidu.tieba.video.record.a.b(recordVideoActivity.getPackageManager())) {
                imageView.setVisibility(8);
            }
        }
    }

    /* renamed from: com.baidu.tieba.video.record.i$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    class AnonymousClass1 implements ProgressView.a {
        AnonymousClass1() {
        }

        @Override // com.baidu.tieba.video.record.ProgressView.a
        public void vp(int i) {
            h hVar;
            final g bFj;
            i.this.mProgress = i;
            if (i == 100 && i.this.hqA != null && (hVar = i.this.hqA.hqc) != null && (bFj = hVar.bFj()) != null) {
                if (bFj instanceof GLVideoPreviewView) {
                    bFj.setOnEncoderStatusUpdateListener(new d.c() { // from class: com.baidu.tieba.video.record.i.1.1
                        @Override // com.faceunity.a.d.c
                        public void bFE() {
                        }

                        @Override // com.faceunity.a.d.c
                        public void bFF() {
                            com.baidu.adp.lib.g.e.jt().post(new Runnable() { // from class: com.baidu.tieba.video.record.i.1.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (i.this.hqA != null) {
                                        i.this.hqA.bFZ();
                                    }
                                }
                            });
                            bFj.setOnEncoderStatusUpdateListener(null);
                        }
                    });
                    i.this.stopRecord();
                    return;
                }
                i.this.stopRecord();
                if (i.this.hqA != null) {
                    i.this.hqA.bFZ();
                }
            }
        }
    }

    public int getVideoDuration() {
        return this.hrl;
    }

    public void startRecord() {
        if (!this.hro) {
            if (this.hrm != null) {
                this.hrm.setVisibility(0);
                this.hrm.setCurrentState(ProgressView.State.START);
            }
            if (!this.hro) {
                this.hro = true;
                this.Sg = System.currentTimeMillis();
            }
            if (this.hqA != null && this.hqA.hqc != null) {
                this.hqA.hqc.startRecord();
                if (this.hqA.hsd != null) {
                    this.hqA.hsd.vr(this.hrl);
                }
            }
        }
    }

    public boolean bFA() {
        if (this.hqA.hsd != null) {
            return this.hqA.hsd.bFA();
        }
        return false;
    }

    public void stopRecord() {
        if (this.hro) {
            if (this.hrm != null) {
                this.hrm.setCurrentState(ProgressView.State.PAUSE);
            }
            this.hro = false;
            this.hrl = (int) (this.hrl + (System.currentTimeMillis() - this.Sg));
            if (this.hrm != null && this.hrm.getLastProgress() != this.hrl) {
                this.hrm.vo(this.hrl);
            }
            if (this.hqA != null && this.hqA.hqc != null) {
                this.hqA.hqc.stopRecord();
            }
        }
    }

    public void bFB() {
        if (!this.hro && this.hrm != null) {
            this.hrm.setCurrentState(ProgressView.State.ROLLBACK);
        }
    }

    public void bFC() {
        if (this.hrm != null) {
            this.hrm.setCurrentState(ProgressView.State.DELETE);
        }
        this.hrl = this.hrm.getLastProgress();
        if (this.hqA.hqc != null) {
            this.hqA.hqc.bFl();
        }
    }

    public boolean onBackPressed() {
        return this.hrm.bFz();
    }

    public int getStatus() {
        return this.mStatus;
    }

    public void setStatus(int i) {
        File[] listFiles;
        this.mStatus = i;
        if (i == 1) {
            this.hrm.setVisibility(4);
            this.hrm.reset();
            this.hrl = 0;
            File file = new File(com.baidu.tieba.video.c.hjw);
            if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
                for (File file2 : listFiles) {
                    if (file2.getPath().startsWith("rec_tmp_")) {
                        file2.delete();
                    }
                }
            }
        }
        if (this.hrn != null) {
            for (a aVar : this.hrn) {
                aVar.vq(this.mStatus);
            }
        }
    }

    public boolean isRecording() {
        int status = getStatus();
        return status == 2 || status == 7;
    }

    public boolean bFD() {
        return this.mStatus == 6;
    }

    public int getProgress() {
        return this.mProgress;
    }

    public void a(a aVar) {
        if (this.hrn == null) {
            this.hrn = new ArrayList();
        }
        this.hrn.add(aVar);
    }
}
