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
    private int jbY;
    private ProgressView jbZ;
    private RecordVideoActivity jbn;
    protected List<a> jca;
    private boolean jcb;
    private int mProgress;
    private int mStatus = 1;

    /* loaded from: classes5.dex */
    public interface a {
        void AB(int i);
    }

    public i(RecordVideoActivity recordVideoActivity) {
        this.jbn = recordVideoActivity;
        if (this.jbn != null) {
            ImageView imageView = (ImageView) this.jbn.findViewById(d.g.camera_switch);
            ImageView imageView2 = (ImageView) this.jbn.findViewById(d.g.flash_switch);
            this.jbZ = (ProgressView) this.jbn.findViewById(d.g.video_progress_view);
            this.jbZ.setListener(new AnonymousClass1());
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
            if (i == 100 && i.this.jbn != null && (hVar = i.this.jbn.jaP) != null && (ckX = hVar.ckX()) != null) {
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
                                    if (i.this.jbn != null) {
                                        i.this.jbn.clN();
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
                if (i.this.jbn != null) {
                    i.this.jbn.clN();
                }
            }
        }
    }

    public int getVideoDuration() {
        return this.jbY;
    }

    public void startRecord() {
        if (!this.jcb) {
            if (this.jbZ != null) {
                this.jbZ.setVisibility(0);
                this.jbZ.setCurrentState(ProgressView.State.START);
            }
            if (!this.jcb) {
                this.jcb = true;
                this.Vn = System.currentTimeMillis();
            }
            if (this.jbn != null && this.jbn.jaP != null) {
                this.jbn.jaP.startRecord();
                if (this.jbn.jcQ != null) {
                    this.jbn.jcQ.AC(this.jbY);
                }
            }
        }
    }

    public boolean clo() {
        if (this.jbn.jcQ != null) {
            return this.jbn.jcQ.clo();
        }
        return false;
    }

    public void stopRecord() {
        if (this.jcb) {
            if (this.jbZ != null) {
                this.jbZ.setCurrentState(ProgressView.State.PAUSE);
            }
            this.jcb = false;
            this.jbY = (int) (this.jbY + (System.currentTimeMillis() - this.Vn));
            if (this.jbZ != null && this.jbZ.getLastProgress() != this.jbY) {
                this.jbZ.Az(this.jbY);
            }
            if (this.jbn != null && this.jbn.jaP != null) {
                this.jbn.jaP.stopRecord();
            }
        }
    }

    public void clp() {
        if (!this.jcb && this.jbZ != null) {
            this.jbZ.setCurrentState(ProgressView.State.ROLLBACK);
        }
    }

    public void clq() {
        if (this.jbZ != null) {
            this.jbZ.setCurrentState(ProgressView.State.DELETE);
        }
        this.jbY = this.jbZ.getLastProgress();
        if (this.jbn.jaP != null) {
            this.jbn.jaP.ckZ();
        }
    }

    public boolean onBackPressed() {
        return this.jbZ.cln();
    }

    public int getStatus() {
        return this.mStatus;
    }

    public void setStatus(int i) {
        File[] listFiles;
        this.mStatus = i;
        if (i == 1) {
            this.jbZ.setVisibility(4);
            this.jbZ.reset();
            this.jbY = 0;
            File file = new File(com.baidu.tieba.video.c.iUp);
            if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
                for (File file2 : listFiles) {
                    if (file2.getPath().startsWith("rec_tmp_")) {
                        file2.delete();
                    }
                }
            }
        }
        if (this.jca != null) {
            for (a aVar : this.jca) {
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
        if (this.jca == null) {
            this.jca = new ArrayList();
        }
        this.jca.add(aVar);
    }
}
