package com.baidu.tieba.video.record;

import android.widget.ImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.video.record.ProgressView;
import com.faceunity.a.d;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class i {
    private long Ta;
    private int juX;
    private ProgressView juY;
    protected List<a> juZ;
    private RecordVideoActivity jun;
    private boolean jva;
    private int mProgress;
    private int mStatus = 1;

    /* loaded from: classes5.dex */
    public interface a {
        void BJ(int i);
    }

    public i(RecordVideoActivity recordVideoActivity) {
        this.jun = recordVideoActivity;
        if (this.jun != null) {
            ImageView imageView = (ImageView) this.jun.findViewById(R.id.camera_switch);
            ImageView imageView2 = (ImageView) this.jun.findViewById(R.id.flash_switch);
            this.juY = (ProgressView) this.jun.findViewById(R.id.video_progress_view);
            this.juY.setListener(new AnonymousClass1());
            if (!com.baidu.tieba.video.record.a.rv(true)) {
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
        public void BI(int i) {
            h hVar;
            final g ctb;
            i.this.mProgress = i;
            if (i == 100 && i.this.jun != null && (hVar = i.this.jun.jtP) != null && (ctb = hVar.ctb()) != null) {
                if (ctb instanceof GLVideoPreviewView) {
                    ctb.setOnEncoderStatusUpdateListener(new d.c() { // from class: com.baidu.tieba.video.record.i.1.1
                        @Override // com.faceunity.a.d.c
                        public void ctw() {
                        }

                        @Override // com.faceunity.a.d.c
                        public void ctx() {
                            com.baidu.adp.lib.g.e.iB().post(new Runnable() { // from class: com.baidu.tieba.video.record.i.1.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (i.this.jun != null) {
                                        i.this.jun.ctR();
                                    }
                                }
                            });
                            ctb.setOnEncoderStatusUpdateListener(null);
                        }
                    });
                    i.this.stopRecord();
                    return;
                }
                i.this.stopRecord();
                if (i.this.jun != null) {
                    i.this.jun.ctR();
                }
            }
        }
    }

    public int getVideoDuration() {
        return this.juX;
    }

    public void startRecord() {
        if (!this.jva) {
            if (this.juY != null) {
                this.juY.setVisibility(0);
                this.juY.setCurrentState(ProgressView.State.START);
            }
            if (!this.jva) {
                this.jva = true;
                this.Ta = System.currentTimeMillis();
            }
            if (this.jun != null && this.jun.jtP != null) {
                this.jun.jtP.startRecord();
                if (this.jun.jvP != null) {
                    this.jun.jvP.BK(this.juX);
                }
            }
        }
    }

    public boolean cts() {
        if (this.jun.jvP != null) {
            return this.jun.jvP.cts();
        }
        return false;
    }

    public void stopRecord() {
        if (this.jva) {
            if (this.juY != null) {
                this.juY.setCurrentState(ProgressView.State.PAUSE);
            }
            this.jva = false;
            this.juX = (int) (this.juX + (System.currentTimeMillis() - this.Ta));
            if (this.juY != null && this.juY.getLastProgress() != this.juX) {
                this.juY.BH(this.juX);
            }
            if (this.jun != null && this.jun.jtP != null) {
                this.jun.jtP.stopRecord();
            }
        }
    }

    public void ctt() {
        if (!this.jva && this.juY != null) {
            this.juY.setCurrentState(ProgressView.State.ROLLBACK);
        }
    }

    public void ctu() {
        if (this.juY != null) {
            this.juY.setCurrentState(ProgressView.State.DELETE);
        }
        this.juX = this.juY.getLastProgress();
        if (this.jun.jtP != null) {
            this.jun.jtP.ctd();
        }
    }

    public boolean onBackPressed() {
        return this.juY.ctr();
    }

    public int getStatus() {
        return this.mStatus;
    }

    public void setStatus(int i) {
        File[] listFiles;
        this.mStatus = i;
        if (i == 1) {
            this.juY.setVisibility(4);
            this.juY.reset();
            this.juX = 0;
            File file = new File(com.baidu.tieba.video.c.jns);
            if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
                for (File file2 : listFiles) {
                    if (file2.getPath().startsWith("rec_tmp_")) {
                        file2.delete();
                    }
                }
            }
        }
        if (this.juZ != null) {
            for (a aVar : this.juZ) {
                aVar.BJ(this.mStatus);
            }
        }
    }

    public boolean akv() {
        int status = getStatus();
        return status == 2 || status == 7;
    }

    public boolean ctv() {
        return this.mStatus == 6;
    }

    public int getProgress() {
        return this.mProgress;
    }

    public void a(a aVar) {
        if (this.juZ == null) {
            this.juZ = new ArrayList();
        }
        this.juZ.add(aVar);
    }
}
