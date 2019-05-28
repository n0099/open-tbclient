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
    private long Tb;
    private int juU;
    private ProgressView juV;
    protected List<a> juW;
    private boolean juX;
    private RecordVideoActivity juk;
    private int mProgress;
    private int mStatus = 1;

    /* loaded from: classes5.dex */
    public interface a {
        void BJ(int i);
    }

    public i(RecordVideoActivity recordVideoActivity) {
        this.juk = recordVideoActivity;
        if (this.juk != null) {
            ImageView imageView = (ImageView) this.juk.findViewById(R.id.camera_switch);
            ImageView imageView2 = (ImageView) this.juk.findViewById(R.id.flash_switch);
            this.juV = (ProgressView) this.juk.findViewById(R.id.video_progress_view);
            this.juV.setListener(new AnonymousClass1());
            if (!com.baidu.tieba.video.record.a.ru(true)) {
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
            final g ctc;
            i.this.mProgress = i;
            if (i == 100 && i.this.juk != null && (hVar = i.this.juk.jtM) != null && (ctc = hVar.ctc()) != null) {
                if (ctc instanceof GLVideoPreviewView) {
                    ctc.setOnEncoderStatusUpdateListener(new d.c() { // from class: com.baidu.tieba.video.record.i.1.1
                        @Override // com.faceunity.a.d.c
                        public void ctx() {
                        }

                        @Override // com.faceunity.a.d.c
                        public void cty() {
                            com.baidu.adp.lib.g.e.iB().post(new Runnable() { // from class: com.baidu.tieba.video.record.i.1.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (i.this.juk != null) {
                                        i.this.juk.ctS();
                                    }
                                }
                            });
                            ctc.setOnEncoderStatusUpdateListener(null);
                        }
                    });
                    i.this.stopRecord();
                    return;
                }
                i.this.stopRecord();
                if (i.this.juk != null) {
                    i.this.juk.ctS();
                }
            }
        }
    }

    public int getVideoDuration() {
        return this.juU;
    }

    public void startRecord() {
        if (!this.juX) {
            if (this.juV != null) {
                this.juV.setVisibility(0);
                this.juV.setCurrentState(ProgressView.State.START);
            }
            if (!this.juX) {
                this.juX = true;
                this.Tb = System.currentTimeMillis();
            }
            if (this.juk != null && this.juk.jtM != null) {
                this.juk.jtM.startRecord();
                if (this.juk.jvM != null) {
                    this.juk.jvM.BK(this.juU);
                }
            }
        }
    }

    public boolean ctt() {
        if (this.juk.jvM != null) {
            return this.juk.jvM.ctt();
        }
        return false;
    }

    public void stopRecord() {
        if (this.juX) {
            if (this.juV != null) {
                this.juV.setCurrentState(ProgressView.State.PAUSE);
            }
            this.juX = false;
            this.juU = (int) (this.juU + (System.currentTimeMillis() - this.Tb));
            if (this.juV != null && this.juV.getLastProgress() != this.juU) {
                this.juV.BH(this.juU);
            }
            if (this.juk != null && this.juk.jtM != null) {
                this.juk.jtM.stopRecord();
            }
        }
    }

    public void ctu() {
        if (!this.juX && this.juV != null) {
            this.juV.setCurrentState(ProgressView.State.ROLLBACK);
        }
    }

    public void ctv() {
        if (this.juV != null) {
            this.juV.setCurrentState(ProgressView.State.DELETE);
        }
        this.juU = this.juV.getLastProgress();
        if (this.juk.jtM != null) {
            this.juk.jtM.cte();
        }
    }

    public boolean onBackPressed() {
        return this.juV.cts();
    }

    public int getStatus() {
        return this.mStatus;
    }

    public void setStatus(int i) {
        File[] listFiles;
        this.mStatus = i;
        if (i == 1) {
            this.juV.setVisibility(4);
            this.juV.reset();
            this.juU = 0;
            File file = new File(com.baidu.tieba.video.c.jno);
            if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
                for (File file2 : listFiles) {
                    if (file2.getPath().startsWith("rec_tmp_")) {
                        file2.delete();
                    }
                }
            }
        }
        if (this.juW != null) {
            for (a aVar : this.juW) {
                aVar.BJ(this.mStatus);
            }
        }
    }

    public boolean akv() {
        int status = getStatus();
        return status == 2 || status == 7;
    }

    public boolean ctw() {
        return this.mStatus == 6;
    }

    public int getProgress() {
        return this.mProgress;
    }

    public void a(a aVar) {
        if (this.juW == null) {
            this.juW = new ArrayList();
        }
        this.juW.add(aVar);
    }
}
