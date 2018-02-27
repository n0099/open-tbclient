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
    private long axg;
    private int hvS;
    private ProgressView hvT;
    protected List<a> hvU;
    private boolean hvV;
    private RecordVideoActivity hvh;
    private int mProgress;
    private int mStatus = 1;

    /* loaded from: classes2.dex */
    public interface a {
        void wV(int i);
    }

    public j(RecordVideoActivity recordVideoActivity) {
        this.hvh = recordVideoActivity;
        if (this.hvh != null) {
            ImageView imageView = (ImageView) this.hvh.findViewById(d.g.camera_switch);
            ImageView imageView2 = (ImageView) this.hvh.findViewById(d.g.flash_switch);
            this.hvT = (ProgressView) this.hvh.findViewById(d.g.video_progress_view);
            this.hvT.setListener(new AnonymousClass1());
            if (!com.baidu.tieba.video.record.a.np(true)) {
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
            final h bDd;
            j.this.mProgress = i;
            if (i == 100 && j.this.hvh != null && (iVar = j.this.hvh.huJ) != null && (bDd = iVar.bDd()) != null) {
                if (bDd instanceof g) {
                    bDd.setOnEncoderStatusUpdateListener(new d.c() { // from class: com.baidu.tieba.video.record.j.1.1
                        @Override // com.faceunity.a.d.c
                        public void bDA() {
                        }

                        @Override // com.faceunity.a.d.c
                        public void bDB() {
                            com.baidu.adp.lib.g.e.ns().post(new Runnable() { // from class: com.baidu.tieba.video.record.j.1.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (j.this.hvh != null) {
                                        j.this.hvh.bDG();
                                    }
                                }
                            });
                            bDd.setOnEncoderStatusUpdateListener(null);
                        }
                    });
                    j.this.stopRecord();
                    return;
                }
                j.this.stopRecord();
                if (j.this.hvh != null) {
                    j.this.hvh.bDG();
                }
            }
        }
    }

    public int getVideoDuration() {
        return this.hvS;
    }

    public void startRecord() {
        if (!this.hvV) {
            if (this.hvT != null) {
                this.hvT.setVisibility(0);
                this.hvT.setCurrentState(ProgressView.State.START);
            }
            if (!this.hvV) {
                this.hvV = true;
                this.axg = System.currentTimeMillis();
            }
            if (this.hvh != null && this.hvh.huJ != null) {
                this.hvh.huJ.startRecord();
                if (this.hvh.hwK != null) {
                    this.hvh.hwK.wW(this.hvS);
                }
            }
        }
    }

    public boolean bDx() {
        if (this.hvh.hwK != null) {
            return this.hvh.hwK.bDx();
        }
        return false;
    }

    public void stopRecord() {
        if (this.hvV) {
            if (this.hvT != null) {
                this.hvT.setCurrentState(ProgressView.State.PAUSE);
            }
            this.hvV = false;
            this.hvS = (int) (this.hvS + (System.currentTimeMillis() - this.axg));
            if (this.hvT != null && this.hvT.getLastProgress() != this.hvS) {
                this.hvT.wT(this.hvS);
            }
            if (this.hvh != null && this.hvh.huJ != null) {
                this.hvh.huJ.stopRecord();
            }
        }
    }

    public void bDy() {
        if (!this.hvV && this.hvT != null) {
            this.hvT.setCurrentState(ProgressView.State.ROLLBACK);
        }
    }

    public void bDz() {
        if (this.hvT != null) {
            this.hvT.setCurrentState(ProgressView.State.DELETE);
        }
        this.hvS = this.hvT.getLastProgress();
        if (this.hvh.huJ != null) {
            this.hvh.huJ.bDg();
        }
    }

    public boolean onBackPressed() {
        return this.hvT.bDw();
    }

    public int getStatus() {
        return this.mStatus;
    }

    public void setStatus(int i) {
        File[] listFiles;
        this.mStatus = i;
        if (i == 1) {
            this.hvT.setVisibility(4);
            this.hvT.reset();
            this.hvS = 0;
            File file = new File(com.baidu.tieba.video.b.hnD);
            if (file.exists() && file.isDirectory()) {
                for (File file2 : file.listFiles()) {
                    if (file2.getPath().startsWith("rec_tmp_")) {
                        file2.delete();
                    }
                }
            }
        }
        if (this.hvU != null) {
            for (a aVar : this.hvU) {
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

    public void UC() {
        this.mProgress = 0;
        this.hvT.reset();
    }

    public void a(a aVar) {
        if (this.hvU == null) {
            this.hvU = new ArrayList();
        }
        this.hvU.add(aVar);
    }
}
