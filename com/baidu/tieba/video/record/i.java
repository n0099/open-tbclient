package com.baidu.tieba.video.record;

import android.widget.ImageView;
import com.baidu.tieba.e;
import com.baidu.tieba.video.record.ProgressView;
import com.faceunity.a.d;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class i {
    private long Sx;
    private RecordVideoActivity hGK;
    private int hHv;
    private ProgressView hHw;
    protected List<a> hHx;
    private boolean hHy;
    private int mProgress;
    private int mStatus = 1;

    /* loaded from: classes5.dex */
    public interface a {
        void wD(int i);
    }

    public i(RecordVideoActivity recordVideoActivity) {
        this.hGK = recordVideoActivity;
        if (this.hGK != null) {
            ImageView imageView = (ImageView) this.hGK.findViewById(e.g.camera_switch);
            ImageView imageView2 = (ImageView) this.hGK.findViewById(e.g.flash_switch);
            this.hHw = (ProgressView) this.hGK.findViewById(e.g.video_progress_view);
            this.hHw.setListener(new AnonymousClass1());
            if (!com.baidu.tieba.video.record.a.ob(true)) {
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
        public void wC(int i) {
            h hVar;
            final g bKa;
            i.this.mProgress = i;
            if (i == 100 && i.this.hGK != null && (hVar = i.this.hGK.hGk) != null && (bKa = hVar.bKa()) != null) {
                if (bKa instanceof GLVideoPreviewView) {
                    bKa.setOnEncoderStatusUpdateListener(new d.c() { // from class: com.baidu.tieba.video.record.i.1.1
                        @Override // com.faceunity.a.d.c
                        public void bKv() {
                        }

                        @Override // com.faceunity.a.d.c
                        public void bKw() {
                            com.baidu.adp.lib.g.e.jG().post(new Runnable() { // from class: com.baidu.tieba.video.record.i.1.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (i.this.hGK != null) {
                                        i.this.hGK.bKQ();
                                    }
                                }
                            });
                            bKa.setOnEncoderStatusUpdateListener(null);
                        }
                    });
                    i.this.stopRecord();
                    return;
                }
                i.this.stopRecord();
                if (i.this.hGK != null) {
                    i.this.hGK.bKQ();
                }
            }
        }
    }

    public int getVideoDuration() {
        return this.hHv;
    }

    public void startRecord() {
        if (!this.hHy) {
            if (this.hHw != null) {
                this.hHw.setVisibility(0);
                this.hHw.setCurrentState(ProgressView.State.START);
            }
            if (!this.hHy) {
                this.hHy = true;
                this.Sx = System.currentTimeMillis();
            }
            if (this.hGK != null && this.hGK.hGk != null) {
                this.hGK.hGk.startRecord();
                if (this.hGK.hIn != null) {
                    this.hGK.hIn.wE(this.hHv);
                }
            }
        }
    }

    public boolean bKr() {
        if (this.hGK.hIn != null) {
            return this.hGK.hIn.bKr();
        }
        return false;
    }

    public void stopRecord() {
        if (this.hHy) {
            if (this.hHw != null) {
                this.hHw.setCurrentState(ProgressView.State.PAUSE);
            }
            this.hHy = false;
            this.hHv = (int) (this.hHv + (System.currentTimeMillis() - this.Sx));
            if (this.hHw != null && this.hHw.getLastProgress() != this.hHv) {
                this.hHw.wB(this.hHv);
            }
            if (this.hGK != null && this.hGK.hGk != null) {
                this.hGK.hGk.stopRecord();
            }
        }
    }

    public void bKs() {
        if (!this.hHy && this.hHw != null) {
            this.hHw.setCurrentState(ProgressView.State.ROLLBACK);
        }
    }

    public void bKt() {
        if (this.hHw != null) {
            this.hHw.setCurrentState(ProgressView.State.DELETE);
        }
        this.hHv = this.hHw.getLastProgress();
        if (this.hGK.hGk != null) {
            this.hGK.hGk.bKc();
        }
    }

    public boolean onBackPressed() {
        return this.hHw.bKq();
    }

    public int getStatus() {
        return this.mStatus;
    }

    public void setStatus(int i) {
        File[] listFiles;
        this.mStatus = i;
        if (i == 1) {
            this.hHw.setVisibility(4);
            this.hHw.reset();
            this.hHv = 0;
            File file = new File(com.baidu.tieba.video.c.hzI);
            if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
                for (File file2 : listFiles) {
                    if (file2.getPath().startsWith("rec_tmp_")) {
                        file2.delete();
                    }
                }
            }
        }
        if (this.hHx != null) {
            for (a aVar : this.hHx) {
                aVar.wD(this.mStatus);
            }
        }
    }

    public boolean FR() {
        int status = getStatus();
        return status == 2 || status == 7;
    }

    public boolean bKu() {
        return this.mStatus == 6;
    }

    public int getProgress() {
        return this.mProgress;
    }

    public void a(a aVar) {
        if (this.hHx == null) {
            this.hHx = new ArrayList();
        }
        this.hHx.add(aVar);
    }
}
