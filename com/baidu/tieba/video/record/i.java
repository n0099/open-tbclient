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
    private int nLS;
    private ProgressView nLT;
    protected List<a> nLU;
    private boolean nLV;
    private RecordVideoActivity nLk;

    /* loaded from: classes8.dex */
    public interface a {
        void LZ(int i);
    }

    public i(RecordVideoActivity recordVideoActivity) {
        this.nLk = recordVideoActivity;
        if (this.nLk != null) {
            ImageView imageView = (ImageView) this.nLk.findViewById(R.id.camera_switch);
            ImageView imageView2 = (ImageView) this.nLk.findViewById(R.id.flash_switch);
            this.nLT = (ProgressView) this.nLk.findViewById(R.id.video_progress_view);
            this.nLT.setListener(new AnonymousClass1());
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
            final g dVt;
            i.this.mProgress = i;
            if (i == 100 && i.this.nLk != null && (hVar = i.this.nLk.nKM) != null && (dVt = hVar.dVt()) != null) {
                if (dVt instanceof GLVideoPreviewView) {
                    dVt.setOnEncoderStatusUpdateListener(new d.c() { // from class: com.baidu.tieba.video.record.i.1.1
                        @Override // com.faceunity.a.d.c
                        public void XV() {
                        }

                        @Override // com.faceunity.a.d.c
                        public void dVP() {
                            com.baidu.adp.lib.f.e.mB().post(new Runnable() { // from class: com.baidu.tieba.video.record.i.1.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (i.this.nLk != null) {
                                        i.this.nLk.dWk();
                                    }
                                }
                            });
                            dVt.setOnEncoderStatusUpdateListener(null);
                        }
                    });
                    i.this.stopRecord();
                    return;
                }
                i.this.stopRecord();
                if (i.this.nLk != null) {
                    i.this.nLk.dWk();
                }
            }
        }
    }

    public int getVideoDuration() {
        return this.nLS;
    }

    public void startRecord() {
        if (!this.nLV) {
            if (this.nLT != null) {
                this.nLT.setVisibility(0);
                this.nLT.setCurrentState(ProgressView.State.START);
            }
            if (!this.nLV) {
                this.nLV = true;
                this.acA = System.currentTimeMillis();
            }
            if (this.nLk != null && this.nLk.nKM != null) {
                this.nLk.nKM.startRecord();
                if (this.nLk.nMH != null) {
                    this.nLk.nMH.Ma(this.nLS);
                }
            }
        }
    }

    public boolean dVM() {
        if (this.nLk.nMH != null) {
            return this.nLk.nMH.dVM();
        }
        return false;
    }

    public void stopRecord() {
        if (this.nLV) {
            if (this.nLT != null) {
                this.nLT.setCurrentState(ProgressView.State.PAUSE);
            }
            this.nLV = false;
            this.nLS = (int) (this.nLS + (System.currentTimeMillis() - this.acA));
            if (this.nLT != null && this.nLT.getLastProgress() != this.nLS) {
                this.nLT.LX(this.nLS);
            }
            if (this.nLk != null && this.nLk.nKM != null) {
                this.nLk.nKM.stopRecord();
            }
        }
    }

    public void dVN() {
        if (!this.nLV && this.nLT != null) {
            this.nLT.setCurrentState(ProgressView.State.ROLLBACK);
        }
    }

    public void dVO() {
        if (this.nLT != null) {
            this.nLT.setCurrentState(ProgressView.State.DELETE);
        }
        this.nLS = this.nLT.getLastProgress();
        if (this.nLk.nKM != null) {
            this.nLk.nKM.dVv();
        }
    }

    public boolean onBackPressed() {
        return this.nLT.dVL();
    }

    public int getStatus() {
        return this.mStatus;
    }

    public void setStatus(int i) {
        File[] listFiles;
        this.mStatus = i;
        if (i == 1) {
            this.nLT.setVisibility(4);
            this.nLT.reset();
            this.nLS = 0;
            File file = new File(com.baidu.tieba.video.c.nFg);
            if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
                for (File file2 : listFiles) {
                    if (file2.getPath().startsWith("rec_tmp_")) {
                        file2.delete();
                    }
                }
            }
        }
        if (this.nLU != null) {
            for (a aVar : this.nLU) {
                aVar.LZ(this.mStatus);
            }
        }
    }

    public boolean bzj() {
        int status = getStatus();
        return status == 2 || status == 7;
    }

    public boolean bXq() {
        return this.mStatus == 6;
    }

    public int getProgress() {
        return this.mProgress;
    }

    public void a(a aVar) {
        if (this.nLU == null) {
            this.nLU = new ArrayList();
        }
        this.nLU.add(aVar);
    }
}
