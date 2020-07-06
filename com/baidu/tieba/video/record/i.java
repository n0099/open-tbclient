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
    private RecordVideoActivity mbx;
    private int mcg;
    private ProgressView mch;

    /* loaded from: classes10.dex */
    public interface a {
        void Gk(int i);
    }

    public i(RecordVideoActivity recordVideoActivity) {
        this.mbx = recordVideoActivity;
        if (this.mbx != null) {
            ImageView imageView = (ImageView) this.mbx.findViewById(R.id.camera_switch);
            ImageView imageView2 = (ImageView) this.mbx.findViewById(R.id.flash_switch);
            this.mch = (ProgressView) this.mbx.findViewById(R.id.video_progress_view);
            this.mch.setListener(new AnonymousClass1());
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
            final g dos;
            i.this.mProgress = i;
            if (i == 100 && i.this.mbx != null && (hVar = i.this.mbx.maZ) != null && (dos = hVar.dos()) != null) {
                if (dos instanceof GLVideoPreviewView) {
                    dos.setOnEncoderStatusUpdateListener(new d.c() { // from class: com.baidu.tieba.video.record.i.1.1
                        @Override // com.faceunity.a.d.c
                        public void Ju() {
                        }

                        @Override // com.faceunity.a.d.c
                        public void doO() {
                            com.baidu.adp.lib.f.e.lt().post(new Runnable() { // from class: com.baidu.tieba.video.record.i.1.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (i.this.mbx != null) {
                                        i.this.mbx.dpi();
                                    }
                                }
                            });
                            dos.setOnEncoderStatusUpdateListener(null);
                        }
                    });
                    i.this.stopRecord();
                    return;
                }
                i.this.stopRecord();
                if (i.this.mbx != null) {
                    i.this.mbx.dpi();
                }
            }
        }
    }

    public int getVideoDuration() {
        return this.mcg;
    }

    public void startRecord() {
        if (!this.bIa) {
            if (this.mch != null) {
                this.mch.setVisibility(0);
                this.mch.setCurrentState(ProgressView.State.START);
            }
            if (!this.bIa) {
                this.bIa = true;
                this.Zy = System.currentTimeMillis();
            }
            if (this.mbx != null && this.mbx.maZ != null) {
                this.mbx.maZ.startRecord();
                if (this.mbx.mcU != null) {
                    this.mbx.mcU.Gl(this.mcg);
                }
            }
        }
    }

    public boolean doL() {
        if (this.mbx.mcU != null) {
            return this.mbx.mcU.doL();
        }
        return false;
    }

    public void stopRecord() {
        if (this.bIa) {
            if (this.mch != null) {
                this.mch.setCurrentState(ProgressView.State.PAUSE);
            }
            this.bIa = false;
            this.mcg = (int) (this.mcg + (System.currentTimeMillis() - this.Zy));
            if (this.mch != null && this.mch.getLastProgress() != this.mcg) {
                this.mch.Gi(this.mcg);
            }
            if (this.mbx != null && this.mbx.maZ != null) {
                this.mbx.maZ.stopRecord();
            }
        }
    }

    public void doM() {
        if (!this.bIa && this.mch != null) {
            this.mch.setCurrentState(ProgressView.State.ROLLBACK);
        }
    }

    public void doN() {
        if (this.mch != null) {
            this.mch.setCurrentState(ProgressView.State.DELETE);
        }
        this.mcg = this.mch.getLastProgress();
        if (this.mbx.maZ != null) {
            this.mbx.maZ.dou();
        }
    }

    public boolean onBackPressed() {
        return this.mch.doK();
    }

    public int getStatus() {
        return this.mStatus;
    }

    public void setStatus(int i) {
        File[] listFiles;
        this.mStatus = i;
        if (i == 1) {
            this.mch.setVisibility(4);
            this.mch.reset();
            this.mcg = 0;
            File file = new File(com.baidu.tieba.video.d.lUx);
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

    public boolean bwu() {
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
