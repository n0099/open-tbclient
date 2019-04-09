package com.baidu.tieba.video.record;

import android.widget.ImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.video.record.ProgressView;
import com.faceunity.a.d;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class i {
    private long Vo;
    private int jbZ;
    private RecordVideoActivity jbo;
    private ProgressView jca;
    protected List<a> jcb;
    private boolean jcc;
    private int mProgress;
    private int mStatus = 1;

    /* loaded from: classes5.dex */
    public interface a {
        void AB(int i);
    }

    public i(RecordVideoActivity recordVideoActivity) {
        this.jbo = recordVideoActivity;
        if (this.jbo != null) {
            ImageView imageView = (ImageView) this.jbo.findViewById(d.g.camera_switch);
            ImageView imageView2 = (ImageView) this.jbo.findViewById(d.g.flash_switch);
            this.jca = (ProgressView) this.jbo.findViewById(d.g.video_progress_view);
            this.jca.setListener(new AnonymousClass1());
            if (!com.baidu.tieba.video.record.a.qF(true)) {
                imageView2.setVisibility(4);
            }
            if (!com.baidu.tieba.video.record.a.b(recordVideoActivity.getPackageManager())) {
                imageView.setVisibility(8);
            }
        }
    }

    /* renamed from: com.baidu.tieba.video.record.i$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    class AnonymousClass1 implements ProgressView.a {
        AnonymousClass1() {
        }

        @Override // com.baidu.tieba.video.record.ProgressView.a
        public void AA(int i) {
            h hVar;
            final g ckX;
            i.this.mProgress = i;
            if (i == 100 && i.this.jbo != null && (hVar = i.this.jbo.jaQ) != null && (ckX = hVar.ckX()) != null) {
                if (ckX instanceof GLVideoPreviewView) {
                    ckX.setOnEncoderStatusUpdateListener(new d.c() { // from class: com.baidu.tieba.video.record.i.1.1
                        @Override // com.faceunity.a.d.c
                        public void cls() {
                        }

                        @Override // com.faceunity.a.d.c
                        public void clt() {
                            com.baidu.adp.lib.g.e.jH().post(new Runnable() { // from class: com.baidu.tieba.video.record.i.1.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (i.this.jbo != null) {
                                        i.this.jbo.clN();
                                    }
                                }
                            });
                            ckX.setOnEncoderStatusUpdateListener(null);
                        }
                    });
                    i.this.stopRecord();
                    return;
                }
                i.this.stopRecord();
                if (i.this.jbo != null) {
                    i.this.jbo.clN();
                }
            }
        }
    }

    public int getVideoDuration() {
        return this.jbZ;
    }

    public void startRecord() {
        if (!this.jcc) {
            if (this.jca != null) {
                this.jca.setVisibility(0);
                this.jca.setCurrentState(ProgressView.State.START);
            }
            if (!this.jcc) {
                this.jcc = true;
                this.Vo = System.currentTimeMillis();
            }
            if (this.jbo != null && this.jbo.jaQ != null) {
                this.jbo.jaQ.startRecord();
                if (this.jbo.jcR != null) {
                    this.jbo.jcR.AC(this.jbZ);
                }
            }
        }
    }

    public boolean clo() {
        if (this.jbo.jcR != null) {
            return this.jbo.jcR.clo();
        }
        return false;
    }

    public void stopRecord() {
        if (this.jcc) {
            if (this.jca != null) {
                this.jca.setCurrentState(ProgressView.State.PAUSE);
            }
            this.jcc = false;
            this.jbZ = (int) (this.jbZ + (System.currentTimeMillis() - this.Vo));
            if (this.jca != null && this.jca.getLastProgress() != this.jbZ) {
                this.jca.Az(this.jbZ);
            }
            if (this.jbo != null && this.jbo.jaQ != null) {
                this.jbo.jaQ.stopRecord();
            }
        }
    }

    public void clp() {
        if (!this.jcc && this.jca != null) {
            this.jca.setCurrentState(ProgressView.State.ROLLBACK);
        }
    }

    public void clq() {
        if (this.jca != null) {
            this.jca.setCurrentState(ProgressView.State.DELETE);
        }
        this.jbZ = this.jca.getLastProgress();
        if (this.jbo.jaQ != null) {
            this.jbo.jaQ.ckZ();
        }
    }

    public boolean onBackPressed() {
        return this.jca.cln();
    }

    public int getStatus() {
        return this.mStatus;
    }

    public void setStatus(int i) {
        File[] listFiles;
        this.mStatus = i;
        if (i == 1) {
            this.jca.setVisibility(4);
            this.jca.reset();
            this.jbZ = 0;
            File file = new File(com.baidu.tieba.video.c.iUq);
            if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
                for (File file2 : listFiles) {
                    if (file2.getPath().startsWith("rec_tmp_")) {
                        file2.delete();
                    }
                }
            }
        }
        if (this.jcb != null) {
            for (a aVar : this.jcb) {
                aVar.AB(this.mStatus);
            }
        }
    }

    public boolean afw() {
        int status = getStatus();
        return status == 2 || status == 7;
    }

    public boolean clr() {
        return this.mStatus == 6;
    }

    public int getProgress() {
        return this.mProgress;
    }

    public void a(a aVar) {
        if (this.jcb == null) {
            this.jcb = new ArrayList();
        }
        this.jcb.add(aVar);
    }
}
