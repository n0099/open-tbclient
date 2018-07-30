package com.baidu.tieba.video.record;

import android.widget.ImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.video.record.ProgressView;
import com.faceunity.a.d;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class i {
    private long PD;
    private RecordVideoActivity hiK;
    private int hjv;
    private ProgressView hjw;
    protected List<a> hjx;
    private boolean hjy;
    private int mProgress;
    private int mStatus = 1;

    /* loaded from: classes2.dex */
    public interface a {
        void uQ(int i);
    }

    public i(RecordVideoActivity recordVideoActivity) {
        this.hiK = recordVideoActivity;
        if (this.hiK != null) {
            ImageView imageView = (ImageView) this.hiK.findViewById(d.g.camera_switch);
            ImageView imageView2 = (ImageView) this.hiK.findViewById(d.g.flash_switch);
            this.hjw = (ProgressView) this.hiK.findViewById(d.g.video_progress_view);
            this.hjw.setListener(new AnonymousClass1());
            if (!com.baidu.tieba.video.record.a.mX(true)) {
                imageView2.setVisibility(4);
            }
            if (!com.baidu.tieba.video.record.a.c(recordVideoActivity.getPackageManager())) {
                imageView.setVisibility(8);
            }
        }
    }

    /* renamed from: com.baidu.tieba.video.record.i$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    class AnonymousClass1 implements ProgressView.a {
        AnonymousClass1() {
        }

        @Override // com.baidu.tieba.video.record.ProgressView.a
        public void uP(int i) {
            h hVar;
            final g bCs;
            i.this.mProgress = i;
            if (i == 100 && i.this.hiK != null && (hVar = i.this.hiK.him) != null && (bCs = hVar.bCs()) != null) {
                if (bCs instanceof GLVideoPreviewView) {
                    bCs.setOnEncoderStatusUpdateListener(new d.c() { // from class: com.baidu.tieba.video.record.i.1.1
                        @Override // com.faceunity.a.d.c
                        public void bCN() {
                        }

                        @Override // com.faceunity.a.d.c
                        public void bCO() {
                            com.baidu.adp.lib.g.e.in().post(new Runnable() { // from class: com.baidu.tieba.video.record.i.1.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (i.this.hiK != null) {
                                        i.this.hiK.bDi();
                                    }
                                }
                            });
                            bCs.setOnEncoderStatusUpdateListener(null);
                        }
                    });
                    i.this.stopRecord();
                    return;
                }
                i.this.stopRecord();
                if (i.this.hiK != null) {
                    i.this.hiK.bDi();
                }
            }
        }
    }

    public int getVideoDuration() {
        return this.hjv;
    }

    public void startRecord() {
        if (!this.hjy) {
            if (this.hjw != null) {
                this.hjw.setVisibility(0);
                this.hjw.setCurrentState(ProgressView.State.START);
            }
            if (!this.hjy) {
                this.hjy = true;
                this.PD = System.currentTimeMillis();
            }
            if (this.hiK != null && this.hiK.him != null) {
                this.hiK.him.startRecord();
                if (this.hiK.hkn != null) {
                    this.hiK.hkn.uR(this.hjv);
                }
            }
        }
    }

    public boolean bCJ() {
        if (this.hiK.hkn != null) {
            return this.hiK.hkn.bCJ();
        }
        return false;
    }

    public void stopRecord() {
        if (this.hjy) {
            if (this.hjw != null) {
                this.hjw.setCurrentState(ProgressView.State.PAUSE);
            }
            this.hjy = false;
            this.hjv = (int) (this.hjv + (System.currentTimeMillis() - this.PD));
            if (this.hjw != null && this.hjw.getLastProgress() != this.hjv) {
                this.hjw.uO(this.hjv);
            }
            if (this.hiK != null && this.hiK.him != null) {
                this.hiK.him.stopRecord();
            }
        }
    }

    public void bCK() {
        if (!this.hjy && this.hjw != null) {
            this.hjw.setCurrentState(ProgressView.State.ROLLBACK);
        }
    }

    public void bCL() {
        if (this.hjw != null) {
            this.hjw.setCurrentState(ProgressView.State.DELETE);
        }
        this.hjv = this.hjw.getLastProgress();
        if (this.hiK.him != null) {
            this.hiK.him.bCu();
        }
    }

    public boolean onBackPressed() {
        return this.hjw.bCI();
    }

    public int getStatus() {
        return this.mStatus;
    }

    public void setStatus(int i) {
        File[] listFiles;
        this.mStatus = i;
        if (i == 1) {
            this.hjw.setVisibility(4);
            this.hjw.reset();
            this.hjv = 0;
            File file = new File(com.baidu.tieba.video.c.hbD);
            if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
                for (File file2 : listFiles) {
                    if (file2.getPath().startsWith("rec_tmp_")) {
                        file2.delete();
                    }
                }
            }
        }
        if (this.hjx != null) {
            for (a aVar : this.hjx) {
                aVar.uQ(this.mStatus);
            }
        }
    }

    public boolean isRecording() {
        int status = getStatus();
        return status == 2 || status == 7;
    }

    public boolean bCM() {
        return this.mStatus == 6;
    }

    public int getProgress() {
        return this.mProgress;
    }

    public void a(a aVar) {
        if (this.hjx == null) {
            this.hjx = new ArrayList();
        }
        this.hjx.add(aVar);
    }
}
