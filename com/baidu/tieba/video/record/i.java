package com.baidu.tieba.video.record;

import android.widget.ImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.video.record.ProgressView;
import com.faceunity.a.d;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class i {
    private long Zy;
    private boolean bIa;
    private int mProgress;
    private int mStatus = 1;
    protected List<a> mStatusListeners;
    private RecordVideoActivity mbu;
    private int mcd;
    private ProgressView mce;

    /* loaded from: classes10.dex */
    public interface a {
        void Gk(int i);
    }

    public i(RecordVideoActivity recordVideoActivity) {
        this.mbu = recordVideoActivity;
        if (this.mbu != null) {
            ImageView imageView = (ImageView) this.mbu.findViewById(R.id.camera_switch);
            ImageView imageView2 = (ImageView) this.mbu.findViewById(R.id.flash_switch);
            this.mce = (ProgressView) this.mbu.findViewById(R.id.video_progress_view);
            this.mce.setListener(new AnonymousClass1());
            if (!com.baidu.tieba.video.record.a.vp(true)) {
                imageView2.setVisibility(4);
            }
            if (!com.baidu.tieba.video.record.a.b(recordVideoActivity.getPackageManager())) {
                imageView.setVisibility(8);
            }
        }
    }

    /* renamed from: com.baidu.tieba.video.record.i$1  reason: invalid class name */
    /* loaded from: classes10.dex */
    class AnonymousClass1 implements ProgressView.a {
        AnonymousClass1() {
        }

        @Override // com.baidu.tieba.video.record.ProgressView.a
        public void Gj(int i) {
            h hVar;
            final g doo;
            i.this.mProgress = i;
            if (i == 100 && i.this.mbu != null && (hVar = i.this.mbu.maW) != null && (doo = hVar.doo()) != null) {
                if (doo instanceof GLVideoPreviewView) {
                    doo.setOnEncoderStatusUpdateListener(new d.c() { // from class: com.baidu.tieba.video.record.i.1.1
                        @Override // com.faceunity.a.d.c
                        public void Ju() {
                        }

                        @Override // com.faceunity.a.d.c
                        public void doK() {
                            com.baidu.adp.lib.f.e.lt().post(new Runnable() { // from class: com.baidu.tieba.video.record.i.1.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (i.this.mbu != null) {
                                        i.this.mbu.dpe();
                                    }
                                }
                            });
                            doo.setOnEncoderStatusUpdateListener(null);
                        }
                    });
                    i.this.stopRecord();
                    return;
                }
                i.this.stopRecord();
                if (i.this.mbu != null) {
                    i.this.mbu.dpe();
                }
            }
        }
    }

    public int getVideoDuration() {
        return this.mcd;
    }

    public void startRecord() {
        if (!this.bIa) {
            if (this.mce != null) {
                this.mce.setVisibility(0);
                this.mce.setCurrentState(ProgressView.State.START);
            }
            if (!this.bIa) {
                this.bIa = true;
                this.Zy = System.currentTimeMillis();
            }
            if (this.mbu != null && this.mbu.maW != null) {
                this.mbu.maW.startRecord();
                if (this.mbu.mcR != null) {
                    this.mbu.mcR.Gl(this.mcd);
                }
            }
        }
    }

    public boolean doH() {
        if (this.mbu.mcR != null) {
            return this.mbu.mcR.doH();
        }
        return false;
    }

    public void stopRecord() {
        if (this.bIa) {
            if (this.mce != null) {
                this.mce.setCurrentState(ProgressView.State.PAUSE);
            }
            this.bIa = false;
            this.mcd = (int) (this.mcd + (System.currentTimeMillis() - this.Zy));
            if (this.mce != null && this.mce.getLastProgress() != this.mcd) {
                this.mce.Gi(this.mcd);
            }
            if (this.mbu != null && this.mbu.maW != null) {
                this.mbu.maW.stopRecord();
            }
        }
    }

    public void doI() {
        if (!this.bIa && this.mce != null) {
            this.mce.setCurrentState(ProgressView.State.ROLLBACK);
        }
    }

    public void doJ() {
        if (this.mce != null) {
            this.mce.setCurrentState(ProgressView.State.DELETE);
        }
        this.mcd = this.mce.getLastProgress();
        if (this.mbu.maW != null) {
            this.mbu.maW.doq();
        }
    }

    public boolean onBackPressed() {
        return this.mce.doG();
    }

    public int getStatus() {
        return this.mStatus;
    }

    public void setStatus(int i) {
        File[] listFiles;
        this.mStatus = i;
        if (i == 1) {
            this.mce.setVisibility(4);
            this.mce.reset();
            this.mcd = 0;
            File file = new File(com.baidu.tieba.video.d.lUu);
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
                aVar.Gk(this.mStatus);
            }
        }
    }

    public boolean aZz() {
        int status = getStatus();
        return status == 2 || status == 7;
    }

    public boolean bwt() {
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
