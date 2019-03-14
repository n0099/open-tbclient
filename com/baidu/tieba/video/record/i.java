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
    private long Vn;
    private RecordVideoActivity jbz;
    private int jck;
    private ProgressView jcl;
    protected List<a> jcm;
    private boolean jcn;
    private int mProgress;
    private int mStatus = 1;

    /* loaded from: classes5.dex */
    public interface a {
        void AF(int i);
    }

    public i(RecordVideoActivity recordVideoActivity) {
        this.jbz = recordVideoActivity;
        if (this.jbz != null) {
            ImageView imageView = (ImageView) this.jbz.findViewById(d.g.camera_switch);
            ImageView imageView2 = (ImageView) this.jbz.findViewById(d.g.flash_switch);
            this.jcl = (ProgressView) this.jbz.findViewById(d.g.video_progress_view);
            this.jcl.setListener(new AnonymousClass1());
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
        public void AE(int i) {
            h hVar;
            final g ckZ;
            i.this.mProgress = i;
            if (i == 100 && i.this.jbz != null && (hVar = i.this.jbz.jbb) != null && (ckZ = hVar.ckZ()) != null) {
                if (ckZ instanceof GLVideoPreviewView) {
                    ckZ.setOnEncoderStatusUpdateListener(new d.c() { // from class: com.baidu.tieba.video.record.i.1.1
                        @Override // com.faceunity.a.d.c
                        public void clu() {
                        }

                        @Override // com.faceunity.a.d.c
                        public void clv() {
                            com.baidu.adp.lib.g.e.jH().post(new Runnable() { // from class: com.baidu.tieba.video.record.i.1.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (i.this.jbz != null) {
                                        i.this.jbz.clP();
                                    }
                                }
                            });
                            ckZ.setOnEncoderStatusUpdateListener(null);
                        }
                    });
                    i.this.stopRecord();
                    return;
                }
                i.this.stopRecord();
                if (i.this.jbz != null) {
                    i.this.jbz.clP();
                }
            }
        }
    }

    public int getVideoDuration() {
        return this.jck;
    }

    public void startRecord() {
        if (!this.jcn) {
            if (this.jcl != null) {
                this.jcl.setVisibility(0);
                this.jcl.setCurrentState(ProgressView.State.START);
            }
            if (!this.jcn) {
                this.jcn = true;
                this.Vn = System.currentTimeMillis();
            }
            if (this.jbz != null && this.jbz.jbb != null) {
                this.jbz.jbb.startRecord();
                if (this.jbz.jdc != null) {
                    this.jbz.jdc.AG(this.jck);
                }
            }
        }
    }

    public boolean clq() {
        if (this.jbz.jdc != null) {
            return this.jbz.jdc.clq();
        }
        return false;
    }

    public void stopRecord() {
        if (this.jcn) {
            if (this.jcl != null) {
                this.jcl.setCurrentState(ProgressView.State.PAUSE);
            }
            this.jcn = false;
            this.jck = (int) (this.jck + (System.currentTimeMillis() - this.Vn));
            if (this.jcl != null && this.jcl.getLastProgress() != this.jck) {
                this.jcl.AD(this.jck);
            }
            if (this.jbz != null && this.jbz.jbb != null) {
                this.jbz.jbb.stopRecord();
            }
        }
    }

    public void clr() {
        if (!this.jcn && this.jcl != null) {
            this.jcl.setCurrentState(ProgressView.State.ROLLBACK);
        }
    }

    public void cls() {
        if (this.jcl != null) {
            this.jcl.setCurrentState(ProgressView.State.DELETE);
        }
        this.jck = this.jcl.getLastProgress();
        if (this.jbz.jbb != null) {
            this.jbz.jbb.clb();
        }
    }

    public boolean onBackPressed() {
        return this.jcl.clp();
    }

    public int getStatus() {
        return this.mStatus;
    }

    public void setStatus(int i) {
        File[] listFiles;
        this.mStatus = i;
        if (i == 1) {
            this.jcl.setVisibility(4);
            this.jcl.reset();
            this.jck = 0;
            File file = new File(com.baidu.tieba.video.c.iUB);
            if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
                for (File file2 : listFiles) {
                    if (file2.getPath().startsWith("rec_tmp_")) {
                        file2.delete();
                    }
                }
            }
        }
        if (this.jcm != null) {
            for (a aVar : this.jcm) {
                aVar.AF(this.mStatus);
            }
        }
    }

    public boolean afz() {
        int status = getStatus();
        return status == 2 || status == 7;
    }

    public boolean clt() {
        return this.mStatus == 6;
    }

    public int getProgress() {
        return this.mProgress;
    }

    public void a(a aVar) {
        if (this.jcm == null) {
            this.jcm = new ArrayList();
        }
        this.jcm.add(aVar);
    }
}
