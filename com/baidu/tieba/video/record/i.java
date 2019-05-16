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
    private int juT;
    private ProgressView juU;
    protected List<a> juV;
    private boolean juW;
    private RecordVideoActivity juj;
    private int mProgress;
    private int mStatus = 1;

    /* loaded from: classes5.dex */
    public interface a {
        void BJ(int i);
    }

    public i(RecordVideoActivity recordVideoActivity) {
        this.juj = recordVideoActivity;
        if (this.juj != null) {
            ImageView imageView = (ImageView) this.juj.findViewById(R.id.camera_switch);
            ImageView imageView2 = (ImageView) this.juj.findViewById(R.id.flash_switch);
            this.juU = (ProgressView) this.juj.findViewById(R.id.video_progress_view);
            this.juU.setListener(new AnonymousClass1());
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
            final g cta;
            i.this.mProgress = i;
            if (i == 100 && i.this.juj != null && (hVar = i.this.juj.jtL) != null && (cta = hVar.cta()) != null) {
                if (cta instanceof GLVideoPreviewView) {
                    cta.setOnEncoderStatusUpdateListener(new d.c() { // from class: com.baidu.tieba.video.record.i.1.1
                        @Override // com.faceunity.a.d.c
                        public void ctv() {
                        }

                        @Override // com.faceunity.a.d.c
                        public void ctw() {
                            com.baidu.adp.lib.g.e.iB().post(new Runnable() { // from class: com.baidu.tieba.video.record.i.1.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (i.this.juj != null) {
                                        i.this.juj.ctQ();
                                    }
                                }
                            });
                            cta.setOnEncoderStatusUpdateListener(null);
                        }
                    });
                    i.this.stopRecord();
                    return;
                }
                i.this.stopRecord();
                if (i.this.juj != null) {
                    i.this.juj.ctQ();
                }
            }
        }
    }

    public int getVideoDuration() {
        return this.juT;
    }

    public void startRecord() {
        if (!this.juW) {
            if (this.juU != null) {
                this.juU.setVisibility(0);
                this.juU.setCurrentState(ProgressView.State.START);
            }
            if (!this.juW) {
                this.juW = true;
                this.Tb = System.currentTimeMillis();
            }
            if (this.juj != null && this.juj.jtL != null) {
                this.juj.jtL.startRecord();
                if (this.juj.jvL != null) {
                    this.juj.jvL.BK(this.juT);
                }
            }
        }
    }

    public boolean ctr() {
        if (this.juj.jvL != null) {
            return this.juj.jvL.ctr();
        }
        return false;
    }

    public void stopRecord() {
        if (this.juW) {
            if (this.juU != null) {
                this.juU.setCurrentState(ProgressView.State.PAUSE);
            }
            this.juW = false;
            this.juT = (int) (this.juT + (System.currentTimeMillis() - this.Tb));
            if (this.juU != null && this.juU.getLastProgress() != this.juT) {
                this.juU.BH(this.juT);
            }
            if (this.juj != null && this.juj.jtL != null) {
                this.juj.jtL.stopRecord();
            }
        }
    }

    public void cts() {
        if (!this.juW && this.juU != null) {
            this.juU.setCurrentState(ProgressView.State.ROLLBACK);
        }
    }

    public void ctt() {
        if (this.juU != null) {
            this.juU.setCurrentState(ProgressView.State.DELETE);
        }
        this.juT = this.juU.getLastProgress();
        if (this.juj.jtL != null) {
            this.juj.jtL.ctc();
        }
    }

    public boolean onBackPressed() {
        return this.juU.ctq();
    }

    public int getStatus() {
        return this.mStatus;
    }

    public void setStatus(int i) {
        File[] listFiles;
        this.mStatus = i;
        if (i == 1) {
            this.juU.setVisibility(4);
            this.juU.reset();
            this.juT = 0;
            File file = new File(com.baidu.tieba.video.c.jnn);
            if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
                for (File file2 : listFiles) {
                    if (file2.getPath().startsWith("rec_tmp_")) {
                        file2.delete();
                    }
                }
            }
        }
        if (this.juV != null) {
            for (a aVar : this.juV) {
                aVar.BJ(this.mStatus);
            }
        }
    }

    public boolean akv() {
        int status = getStatus();
        return status == 2 || status == 7;
    }

    public boolean ctu() {
        return this.mStatus == 6;
    }

    public int getProgress() {
        return this.mProgress;
    }

    public void a(a aVar) {
        if (this.juV == null) {
            this.juV = new ArrayList();
        }
        this.juV.add(aVar);
    }
}
