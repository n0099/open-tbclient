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
    private long acA;
    private int mProgress;
    private int mStatus = 1;
    private int nLT;
    private ProgressView nLU;
    protected List<a> nLV;
    private boolean nLW;
    private RecordVideoActivity nLl;

    /* loaded from: classes8.dex */
    public interface a {
        void LZ(int i);
    }

    public i(RecordVideoActivity recordVideoActivity) {
        this.nLl = recordVideoActivity;
        if (this.nLl != null) {
            ImageView imageView = (ImageView) this.nLl.findViewById(R.id.camera_switch);
            ImageView imageView2 = (ImageView) this.nLl.findViewById(R.id.flash_switch);
            this.nLU = (ProgressView) this.nLl.findViewById(R.id.video_progress_view);
            this.nLU.setListener(new AnonymousClass1());
            if (!com.baidu.tieba.video.record.a.yM(true)) {
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
        public void LY(int i) {
            h hVar;
            final g dVs;
            i.this.mProgress = i;
            if (i == 100 && i.this.nLl != null && (hVar = i.this.nLl.nKN) != null && (dVs = hVar.dVs()) != null) {
                if (dVs instanceof GLVideoPreviewView) {
                    dVs.setOnEncoderStatusUpdateListener(new d.c() { // from class: com.baidu.tieba.video.record.i.1.1
                        @Override // com.faceunity.a.d.c
                        public void XU() {
                        }

                        @Override // com.faceunity.a.d.c
                        public void dVO() {
                            com.baidu.adp.lib.f.e.mB().post(new Runnable() { // from class: com.baidu.tieba.video.record.i.1.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (i.this.nLl != null) {
                                        i.this.nLl.dWj();
                                    }
                                }
                            });
                            dVs.setOnEncoderStatusUpdateListener(null);
                        }
                    });
                    i.this.stopRecord();
                    return;
                }
                i.this.stopRecord();
                if (i.this.nLl != null) {
                    i.this.nLl.dWj();
                }
            }
        }
    }

    public int getVideoDuration() {
        return this.nLT;
    }

    public void startRecord() {
        if (!this.nLW) {
            if (this.nLU != null) {
                this.nLU.setVisibility(0);
                this.nLU.setCurrentState(ProgressView.State.START);
            }
            if (!this.nLW) {
                this.nLW = true;
                this.acA = System.currentTimeMillis();
            }
            if (this.nLl != null && this.nLl.nKN != null) {
                this.nLl.nKN.startRecord();
                if (this.nLl.nMI != null) {
                    this.nLl.nMI.Ma(this.nLT);
                }
            }
        }
    }

    public boolean dVL() {
        if (this.nLl.nMI != null) {
            return this.nLl.nMI.dVL();
        }
        return false;
    }

    public void stopRecord() {
        if (this.nLW) {
            if (this.nLU != null) {
                this.nLU.setCurrentState(ProgressView.State.PAUSE);
            }
            this.nLW = false;
            this.nLT = (int) (this.nLT + (System.currentTimeMillis() - this.acA));
            if (this.nLU != null && this.nLU.getLastProgress() != this.nLT) {
                this.nLU.LX(this.nLT);
            }
            if (this.nLl != null && this.nLl.nKN != null) {
                this.nLl.nKN.stopRecord();
            }
        }
    }

    public void dVM() {
        if (!this.nLW && this.nLU != null) {
            this.nLU.setCurrentState(ProgressView.State.ROLLBACK);
        }
    }

    public void dVN() {
        if (this.nLU != null) {
            this.nLU.setCurrentState(ProgressView.State.DELETE);
        }
        this.nLT = this.nLU.getLastProgress();
        if (this.nLl.nKN != null) {
            this.nLl.nKN.dVu();
        }
    }

    public boolean onBackPressed() {
        return this.nLU.dVK();
    }

    public int getStatus() {
        return this.mStatus;
    }

    public void setStatus(int i) {
        File[] listFiles;
        this.mStatus = i;
        if (i == 1) {
            this.nLU.setVisibility(4);
            this.nLU.reset();
            this.nLT = 0;
            File file = new File(com.baidu.tieba.video.c.nFh);
            if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
                for (File file2 : listFiles) {
                    if (file2.getPath().startsWith("rec_tmp_")) {
                        file2.delete();
                    }
                }
            }
        }
        if (this.nLV != null) {
            for (a aVar : this.nLV) {
                aVar.LZ(this.mStatus);
            }
        }
    }

    public boolean bzi() {
        int status = getStatus();
        return status == 2 || status == 7;
    }

    public boolean bXp() {
        return this.mStatus == 6;
    }

    public int getProgress() {
        return this.mProgress;
    }

    public void a(a aVar) {
        if (this.nLV == null) {
            this.nLV = new ArrayList();
        }
        this.nLV.add(aVar);
    }
}
