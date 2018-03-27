package com.baidu.tieba.video.record;

import android.widget.ImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.video.record.ProgressView;
import com.faceunity.a.d;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class j {
    private long axh;
    private RecordVideoActivity hvF;
    private int hwq;
    private ProgressView hwr;
    protected List<a> hws;
    private boolean hwt;
    private int mProgress;
    private int mStatus = 1;

    /* loaded from: classes2.dex */
    public interface a {
        void wV(int i);
    }

    public j(RecordVideoActivity recordVideoActivity) {
        this.hvF = recordVideoActivity;
        if (this.hvF != null) {
            ImageView imageView = (ImageView) this.hvF.findViewById(d.g.camera_switch);
            ImageView imageView2 = (ImageView) this.hvF.findViewById(d.g.flash_switch);
            this.hwr = (ProgressView) this.hvF.findViewById(d.g.video_progress_view);
            this.hwr.setListener(new AnonymousClass1());
            if (!com.baidu.tieba.video.record.a.nu(true)) {
                imageView2.setVisibility(4);
            }
            if (!com.baidu.tieba.video.record.a.c(recordVideoActivity.getPackageManager())) {
                imageView.setVisibility(8);
            }
        }
    }

    /* renamed from: com.baidu.tieba.video.record.j$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    class AnonymousClass1 implements ProgressView.a {
        AnonymousClass1() {
        }

        @Override // com.baidu.tieba.video.record.ProgressView.a
        public void wU(int i) {
            i iVar;
            final h bDi;
            j.this.mProgress = i;
            if (i == 100 && j.this.hvF != null && (iVar = j.this.hvF.hvh) != null && (bDi = iVar.bDi()) != null) {
                if (bDi instanceof g) {
                    bDi.setOnEncoderStatusUpdateListener(new d.c() { // from class: com.baidu.tieba.video.record.j.1.1
                        @Override // com.faceunity.a.d.c
                        public void bDF() {
                        }

                        @Override // com.faceunity.a.d.c
                        public void bDG() {
                            com.baidu.adp.lib.g.e.ns().post(new Runnable() { // from class: com.baidu.tieba.video.record.j.1.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (j.this.hvF != null) {
                                        j.this.hvF.bDL();
                                    }
                                }
                            });
                            bDi.setOnEncoderStatusUpdateListener(null);
                        }
                    });
                    j.this.stopRecord();
                    return;
                }
                j.this.stopRecord();
                if (j.this.hvF != null) {
                    j.this.hvF.bDL();
                }
            }
        }
    }

    public int getVideoDuration() {
        return this.hwq;
    }

    public void startRecord() {
        if (!this.hwt) {
            if (this.hwr != null) {
                this.hwr.setVisibility(0);
                this.hwr.setCurrentState(ProgressView.State.START);
            }
            if (!this.hwt) {
                this.hwt = true;
                this.axh = System.currentTimeMillis();
            }
            if (this.hvF != null && this.hvF.hvh != null) {
                this.hvF.hvh.startRecord();
                if (this.hvF.hxi != null) {
                    this.hvF.hxi.wW(this.hwq);
                }
            }
        }
    }

    public boolean bDC() {
        if (this.hvF.hxi != null) {
            return this.hvF.hxi.bDC();
        }
        return false;
    }

    public void stopRecord() {
        if (this.hwt) {
            if (this.hwr != null) {
                this.hwr.setCurrentState(ProgressView.State.PAUSE);
            }
            this.hwt = false;
            this.hwq = (int) (this.hwq + (System.currentTimeMillis() - this.axh));
            if (this.hwr != null && this.hwr.getLastProgress() != this.hwq) {
                this.hwr.wT(this.hwq);
            }
            if (this.hvF != null && this.hvF.hvh != null) {
                this.hvF.hvh.stopRecord();
            }
        }
    }

    public void bDD() {
        if (!this.hwt && this.hwr != null) {
            this.hwr.setCurrentState(ProgressView.State.ROLLBACK);
        }
    }

    public void bDE() {
        if (this.hwr != null) {
            this.hwr.setCurrentState(ProgressView.State.DELETE);
        }
        this.hwq = this.hwr.getLastProgress();
        if (this.hvF.hvh != null) {
            this.hvF.hvh.bDl();
        }
    }

    public boolean onBackPressed() {
        return this.hwr.bDB();
    }

    public int getStatus() {
        return this.mStatus;
    }

    public void setStatus(int i) {
        File[] listFiles;
        this.mStatus = i;
        if (i == 1) {
            this.hwr.setVisibility(4);
            this.hwr.reset();
            this.hwq = 0;
            File file = new File(com.baidu.tieba.video.b.hob);
            if (file.exists() && file.isDirectory()) {
                for (File file2 : file.listFiles()) {
                    if (file2.getPath().startsWith("rec_tmp_")) {
                        file2.delete();
                    }
                }
            }
        }
        if (this.hws != null) {
            for (a aVar : this.hws) {
                aVar.wV(this.mStatus);
            }
        }
    }

    public boolean isRecording() {
        int status = getStatus();
        return status == 2 || status == 7;
    }

    public int getProgress() {
        return this.mProgress;
    }

    public void UD() {
        this.mProgress = 0;
        this.hwr.reset();
    }

    public void a(a aVar) {
        if (this.hws == null) {
            this.hws = new ArrayList();
        }
        this.hws.add(aVar);
    }
}
