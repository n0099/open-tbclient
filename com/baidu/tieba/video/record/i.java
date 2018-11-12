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
    private int hAj;
    private ProgressView hAk;
    protected List<a> hAl;
    private boolean hAm;
    private RecordVideoActivity hzy;
    private int mProgress;
    private int mStatus = 1;

    /* loaded from: classes5.dex */
    public interface a {
        void wg(int i);
    }

    public i(RecordVideoActivity recordVideoActivity) {
        this.hzy = recordVideoActivity;
        if (this.hzy != null) {
            ImageView imageView = (ImageView) this.hzy.findViewById(e.g.camera_switch);
            ImageView imageView2 = (ImageView) this.hzy.findViewById(e.g.flash_switch);
            this.hAk = (ProgressView) this.hzy.findViewById(e.g.video_progress_view);
            this.hAk.setListener(new AnonymousClass1());
            if (!com.baidu.tieba.video.record.a.nZ(true)) {
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
        public void wf(int i) {
            h hVar;
            final g bHV;
            i.this.mProgress = i;
            if (i == 100 && i.this.hzy != null && (hVar = i.this.hzy.hyY) != null && (bHV = hVar.bHV()) != null) {
                if (bHV instanceof GLVideoPreviewView) {
                    bHV.setOnEncoderStatusUpdateListener(new d.c() { // from class: com.baidu.tieba.video.record.i.1.1
                        @Override // com.faceunity.a.d.c
                        public void bIq() {
                        }

                        @Override // com.faceunity.a.d.c
                        public void bIr() {
                            com.baidu.adp.lib.g.e.jG().post(new Runnable() { // from class: com.baidu.tieba.video.record.i.1.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (i.this.hzy != null) {
                                        i.this.hzy.bIL();
                                    }
                                }
                            });
                            bHV.setOnEncoderStatusUpdateListener(null);
                        }
                    });
                    i.this.stopRecord();
                    return;
                }
                i.this.stopRecord();
                if (i.this.hzy != null) {
                    i.this.hzy.bIL();
                }
            }
        }
    }

    public int getVideoDuration() {
        return this.hAj;
    }

    public void startRecord() {
        if (!this.hAm) {
            if (this.hAk != null) {
                this.hAk.setVisibility(0);
                this.hAk.setCurrentState(ProgressView.State.START);
            }
            if (!this.hAm) {
                this.hAm = true;
                this.Sx = System.currentTimeMillis();
            }
            if (this.hzy != null && this.hzy.hyY != null) {
                this.hzy.hyY.startRecord();
                if (this.hzy.hBb != null) {
                    this.hzy.hBb.wh(this.hAj);
                }
            }
        }
    }

    public boolean bIm() {
        if (this.hzy.hBb != null) {
            return this.hzy.hBb.bIm();
        }
        return false;
    }

    public void stopRecord() {
        if (this.hAm) {
            if (this.hAk != null) {
                this.hAk.setCurrentState(ProgressView.State.PAUSE);
            }
            this.hAm = false;
            this.hAj = (int) (this.hAj + (System.currentTimeMillis() - this.Sx));
            if (this.hAk != null && this.hAk.getLastProgress() != this.hAj) {
                this.hAk.we(this.hAj);
            }
            if (this.hzy != null && this.hzy.hyY != null) {
                this.hzy.hyY.stopRecord();
            }
        }
    }

    public void bIn() {
        if (!this.hAm && this.hAk != null) {
            this.hAk.setCurrentState(ProgressView.State.ROLLBACK);
        }
    }

    public void bIo() {
        if (this.hAk != null) {
            this.hAk.setCurrentState(ProgressView.State.DELETE);
        }
        this.hAj = this.hAk.getLastProgress();
        if (this.hzy.hyY != null) {
            this.hzy.hyY.bHX();
        }
    }

    public boolean onBackPressed() {
        return this.hAk.bIl();
    }

    public int getStatus() {
        return this.mStatus;
    }

    public void setStatus(int i) {
        File[] listFiles;
        this.mStatus = i;
        if (i == 1) {
            this.hAk.setVisibility(4);
            this.hAk.reset();
            this.hAj = 0;
            File file = new File(com.baidu.tieba.video.c.hsw);
            if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
                for (File file2 : listFiles) {
                    if (file2.getPath().startsWith("rec_tmp_")) {
                        file2.delete();
                    }
                }
            }
        }
        if (this.hAl != null) {
            for (a aVar : this.hAl) {
                aVar.wg(this.mStatus);
            }
        }
    }

    public boolean EN() {
        int status = getStatus();
        return status == 2 || status == 7;
    }

    public boolean bIp() {
        return this.mStatus == 6;
    }

    public int getProgress() {
        return this.mProgress;
    }

    public void a(a aVar) {
        if (this.hAl == null) {
            this.hAl = new ArrayList();
        }
        this.hAl.add(aVar);
    }
}
