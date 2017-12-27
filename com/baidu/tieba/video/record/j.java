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
    private long axo;
    private int hEU;
    private ProgressView hEV;
    protected List<a> hEW;
    private boolean hEX;
    private RecordVideoActivity hEh;
    private int mProgress;
    private int mStatus = 1;

    /* loaded from: classes2.dex */
    public interface a {
        void yt(int i);
    }

    public j(RecordVideoActivity recordVideoActivity) {
        this.hEh = recordVideoActivity;
        if (this.hEh != null) {
            ImageView imageView = (ImageView) this.hEh.findViewById(d.g.camera_switch);
            ImageView imageView2 = (ImageView) this.hEh.findViewById(d.g.flash_switch);
            this.hEV = (ProgressView) this.hEh.findViewById(d.g.video_progress_view);
            this.hEV.setListener(new AnonymousClass1());
            if (!com.baidu.tieba.video.record.a.oc(true)) {
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
        public void ys(int i) {
            i iVar;
            final h bIW;
            j.this.mProgress = i;
            if (i == 100 && j.this.hEh != null && (iVar = j.this.hEh.hDJ) != null && (bIW = iVar.bIW()) != null) {
                if (bIW instanceof g) {
                    bIW.setOnEncoderStatusUpdateListener(new d.c() { // from class: com.baidu.tieba.video.record.j.1.1
                        @Override // com.faceunity.a.d.c
                        public void bJu() {
                        }

                        @Override // com.faceunity.a.d.c
                        public void bJv() {
                            com.baidu.adp.lib.g.e.nr().post(new Runnable() { // from class: com.baidu.tieba.video.record.j.1.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (j.this.hEh != null) {
                                        j.this.hEh.bJA();
                                    }
                                }
                            });
                            bIW.setOnEncoderStatusUpdateListener(null);
                        }
                    });
                    j.this.stopRecord();
                    return;
                }
                j.this.stopRecord();
                if (j.this.hEh != null) {
                    j.this.hEh.bJA();
                }
            }
        }
    }

    public int getVideoDuration() {
        return this.hEU;
    }

    public void startRecord() {
        if (!this.hEX) {
            if (this.hEV != null) {
                this.hEV.setVisibility(0);
                this.hEV.setCurrentState(ProgressView.State.START);
            }
            if (!this.hEX) {
                this.hEX = true;
                this.axo = System.currentTimeMillis();
            }
            if (this.hEh != null && this.hEh.hDJ != null) {
                this.hEh.hDJ.startRecord();
                if (this.hEh.hFM != null) {
                    this.hEh.hFM.yu(this.hEU);
                }
            }
        }
    }

    public boolean bJr() {
        if (this.hEh.hFM != null) {
            return this.hEh.hFM.bJr();
        }
        return false;
    }

    public void stopRecord() {
        if (this.hEX) {
            if (this.hEV != null) {
                this.hEV.setCurrentState(ProgressView.State.PAUSE);
            }
            this.hEX = false;
            this.hEU = (int) (this.hEU + (System.currentTimeMillis() - this.axo));
            if (this.hEV != null && this.hEV.getLastProgress() != this.hEU) {
                this.hEV.yr(this.hEU);
            }
            if (this.hEh != null && this.hEh.hDJ != null) {
                this.hEh.hDJ.stopRecord();
            }
        }
    }

    public void bJs() {
        if (!this.hEX && this.hEV != null) {
            this.hEV.setCurrentState(ProgressView.State.ROLLBACK);
        }
    }

    public void bJt() {
        if (this.hEV != null) {
            this.hEV.setCurrentState(ProgressView.State.DELETE);
        }
        this.hEU = this.hEV.getLastProgress();
        if (this.hEh.hDJ != null) {
            this.hEh.hDJ.bIZ();
        }
    }

    public boolean onBackPressed() {
        return this.hEV.bJq();
    }

    public int getStatus() {
        return this.mStatus;
    }

    public void setStatus(int i) {
        File[] listFiles;
        this.mStatus = i;
        if (i == 1) {
            this.hEV.setVisibility(4);
            this.hEV.reset();
            this.hEU = 0;
            File file = new File(com.baidu.tieba.video.b.hwE);
            if (file.exists() && file.isDirectory()) {
                for (File file2 : file.listFiles()) {
                    if (file2.getPath().startsWith("rec_tmp_")) {
                        file2.delete();
                    }
                }
            }
        }
        if (this.hEW != null) {
            for (a aVar : this.hEW) {
                aVar.yt(this.mStatus);
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

    public void TV() {
        this.mProgress = 0;
        this.hEV.reset();
    }

    public void a(a aVar) {
        if (this.hEW == null) {
            this.hEW = new ArrayList();
        }
        this.hEW.add(aVar);
    }
}
