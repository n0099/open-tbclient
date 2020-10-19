package com.baidu.tieba.video.record;

import android.widget.ImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.video.record.ProgressView;
import com.faceunity.a.d;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes23.dex */
public class i {
    private long aaJ;
    private boolean bZA;
    private int mProgress;
    private int mStatus = 1;
    protected List<a> mStatusListeners;
    private int naU;
    private ProgressView naV;
    private RecordVideoActivity nam;

    /* loaded from: classes23.dex */
    public interface a {
        void Km(int i);
    }

    public i(RecordVideoActivity recordVideoActivity) {
        this.nam = recordVideoActivity;
        if (this.nam != null) {
            ImageView imageView = (ImageView) this.nam.findViewById(R.id.camera_switch);
            ImageView imageView2 = (ImageView) this.nam.findViewById(R.id.flash_switch);
            this.naV = (ProgressView) this.nam.findViewById(R.id.video_progress_view);
            this.naV.setListener(new AnonymousClass1());
            if (!com.baidu.tieba.video.record.a.xA(true)) {
                imageView2.setVisibility(4);
            }
            if (!com.baidu.tieba.video.record.a.b(recordVideoActivity.getPackageManager())) {
                imageView.setVisibility(8);
            }
        }
    }

    /* renamed from: com.baidu.tieba.video.record.i$1  reason: invalid class name */
    /* loaded from: classes23.dex */
    class AnonymousClass1 implements ProgressView.a {
        AnonymousClass1() {
        }

        @Override // com.baidu.tieba.video.record.ProgressView.a
        public void Kl(int i) {
            h hVar;
            final g dKM;
            i.this.mProgress = i;
            if (i == 100 && i.this.nam != null && (hVar = i.this.nam.mZO) != null && (dKM = hVar.dKM()) != null) {
                if (dKM instanceof GLVideoPreviewView) {
                    dKM.setOnEncoderStatusUpdateListener(new d.c() { // from class: com.baidu.tieba.video.record.i.1.1
                        @Override // com.faceunity.a.d.c
                        public void Rm() {
                        }

                        @Override // com.faceunity.a.d.c
                        public void dLi() {
                            com.baidu.adp.lib.f.e.mY().post(new Runnable() { // from class: com.baidu.tieba.video.record.i.1.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (i.this.nam != null) {
                                        i.this.nam.dLC();
                                    }
                                }
                            });
                            dKM.setOnEncoderStatusUpdateListener(null);
                        }
                    });
                    i.this.stopRecord();
                    return;
                }
                i.this.stopRecord();
                if (i.this.nam != null) {
                    i.this.nam.dLC();
                }
            }
        }
    }

    public int getVideoDuration() {
        return this.naU;
    }

    public void startRecord() {
        if (!this.bZA) {
            if (this.naV != null) {
                this.naV.setVisibility(0);
                this.naV.setCurrentState(ProgressView.State.START);
            }
            if (!this.bZA) {
                this.bZA = true;
                this.aaJ = System.currentTimeMillis();
            }
            if (this.nam != null && this.nam.mZO != null) {
                this.nam.mZO.startRecord();
                if (this.nam.nbI != null) {
                    this.nam.nbI.Kn(this.naU);
                }
            }
        }
    }

    public boolean dLf() {
        if (this.nam.nbI != null) {
            return this.nam.nbI.dLf();
        }
        return false;
    }

    public void stopRecord() {
        if (this.bZA) {
            if (this.naV != null) {
                this.naV.setCurrentState(ProgressView.State.PAUSE);
            }
            this.bZA = false;
            this.naU = (int) (this.naU + (System.currentTimeMillis() - this.aaJ));
            if (this.naV != null && this.naV.getLastProgress() != this.naU) {
                this.naV.Kk(this.naU);
            }
            if (this.nam != null && this.nam.mZO != null) {
                this.nam.mZO.stopRecord();
            }
        }
    }

    public void dLg() {
        if (!this.bZA && this.naV != null) {
            this.naV.setCurrentState(ProgressView.State.ROLLBACK);
        }
    }

    public void dLh() {
        if (this.naV != null) {
            this.naV.setCurrentState(ProgressView.State.DELETE);
        }
        this.naU = this.naV.getLastProgress();
        if (this.nam.mZO != null) {
            this.nam.mZO.dKO();
        }
    }

    public boolean onBackPressed() {
        return this.naV.dLe();
    }

    public int getStatus() {
        return this.mStatus;
    }

    public void setStatus(int i) {
        File[] listFiles;
        this.mStatus = i;
        if (i == 1) {
            this.naV.setVisibility(4);
            this.naV.reset();
            this.naU = 0;
            File file = new File(com.baidu.tieba.video.c.mTq);
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
                aVar.Km(this.mStatus);
            }
        }
    }

    public boolean bpG() {
        int status = getStatus();
        return status == 2 || status == 7;
    }

    public boolean bMH() {
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
