package com.baidu.tieba.video.record;

import android.widget.ImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.video.record.ProgressView;
import com.faceunity.a.d;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class i {
    private long acr;
    private int mProgress;
    private int mStatus = 1;
    private int nQV;
    private ProgressView nQW;
    protected List<a> nQX;
    private boolean nQY;
    private RecordVideoActivity nQo;

    /* loaded from: classes8.dex */
    public interface a {
        void KM(int i);
    }

    public i(RecordVideoActivity recordVideoActivity) {
        this.nQo = recordVideoActivity;
        if (this.nQo != null) {
            ImageView imageView = (ImageView) this.nQo.findViewById(R.id.camera_switch);
            ImageView imageView2 = (ImageView) this.nQo.findViewById(R.id.flash_switch);
            this.nQW = (ProgressView) this.nQo.findViewById(R.id.video_progress_view);
            this.nQW.setListener(new AnonymousClass1());
            if (!com.baidu.tieba.video.record.a.zb(true)) {
                imageView2.setVisibility(4);
            }
            if (!com.baidu.tieba.video.record.a.b(recordVideoActivity.getPackageManager())) {
                imageView.setVisibility(8);
            }
        }
    }

    /* renamed from: com.baidu.tieba.video.record.i$1  reason: invalid class name */
    /* loaded from: classes8.dex */
    class AnonymousClass1 implements ProgressView.a {
        AnonymousClass1() {
        }

        @Override // com.baidu.tieba.video.record.ProgressView.a
        public void KL(int i) {
            h hVar;
            final g dTM;
            i.this.mProgress = i;
            if (i == 100 && i.this.nQo != null && (hVar = i.this.nQo.nPR) != null && (dTM = hVar.dTM()) != null) {
                if (dTM instanceof GLVideoPreviewView) {
                    dTM.setOnEncoderStatusUpdateListener(new d.c() { // from class: com.baidu.tieba.video.record.i.1.1
                        @Override // com.faceunity.a.d.c
                        public void VL() {
                        }

                        @Override // com.faceunity.a.d.c
                        public void dUi() {
                            com.baidu.adp.lib.f.e.mA().post(new Runnable() { // from class: com.baidu.tieba.video.record.i.1.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (i.this.nQo != null) {
                                        i.this.nQo.dUD();
                                    }
                                }
                            });
                            dTM.setOnEncoderStatusUpdateListener(null);
                        }
                    });
                    i.this.stopRecord();
                    return;
                }
                i.this.stopRecord();
                if (i.this.nQo != null) {
                    i.this.nQo.dUD();
                }
            }
        }
    }

    public int getVideoDuration() {
        return this.nQV;
    }

    public void startRecord() {
        if (!this.nQY) {
            if (this.nQW != null) {
                this.nQW.setVisibility(0);
                this.nQW.setCurrentState(ProgressView.State.START);
            }
            if (!this.nQY) {
                this.nQY = true;
                this.acr = System.currentTimeMillis();
            }
            if (this.nQo != null && this.nQo.nPR != null) {
                this.nQo.nPR.startRecord();
                if (this.nQo.nRK != null) {
                    this.nQo.nRK.KN(this.nQV);
                }
            }
        }
    }

    public boolean dUf() {
        if (this.nQo.nRK != null) {
            return this.nQo.nRK.dUf();
        }
        return false;
    }

    public void stopRecord() {
        if (this.nQY) {
            if (this.nQW != null) {
                this.nQW.setCurrentState(ProgressView.State.PAUSE);
            }
            this.nQY = false;
            this.nQV = (int) (this.nQV + (System.currentTimeMillis() - this.acr));
            if (this.nQW != null && this.nQW.getLastProgress() != this.nQV) {
                this.nQW.KK(this.nQV);
            }
            if (this.nQo != null && this.nQo.nPR != null) {
                this.nQo.nPR.stopRecord();
            }
        }
    }

    public void dUg() {
        if (!this.nQY && this.nQW != null) {
            this.nQW.setCurrentState(ProgressView.State.ROLLBACK);
        }
    }

    public void dUh() {
        if (this.nQW != null) {
            this.nQW.setCurrentState(ProgressView.State.DELETE);
        }
        this.nQV = this.nQW.getLastProgress();
        if (this.nQo.nPR != null) {
            this.nQo.nPR.dTO();
        }
    }

    public boolean onBackPressed() {
        return this.nQW.dUe();
    }

    public int getStatus() {
        return this.mStatus;
    }

    public void setStatus(int i) {
        File[] listFiles;
        this.mStatus = i;
        if (i == 1) {
            this.nQW.setVisibility(4);
            this.nQW.reset();
            this.nQV = 0;
            File file = new File(com.baidu.tieba.video.c.nKm);
            if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
                for (File file2 : listFiles) {
                    if (file2.getPath().startsWith("rec_tmp_")) {
                        file2.delete();
                    }
                }
            }
        }
        if (this.nQX != null) {
            for (a aVar : this.nQX) {
                aVar.KM(this.mStatus);
            }
        }
    }

    public boolean isRecording() {
        int status = getStatus();
        return status == 2 || status == 7;
    }

    public boolean bUd() {
        return this.mStatus == 6;
    }

    public int getProgress() {
        return this.mProgress;
    }

    public void a(a aVar) {
        if (this.nQX == null) {
            this.nQX = new ArrayList();
        }
        this.nQX.add(aVar);
    }
}
