package com.baidu.tieba.video.record;

import android.widget.ImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.video.record.ProgressView;
import com.faceunity.a.d;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class i {
    private long adM;
    private int mProgress;
    private int mStatus = 1;
    private RecordVideoActivity nST;
    private int nTA;
    private ProgressView nTB;
    protected List<a> nTC;
    private boolean nTD;

    /* loaded from: classes7.dex */
    public interface a {
        void KR(int i);
    }

    public i(RecordVideoActivity recordVideoActivity) {
        this.nST = recordVideoActivity;
        if (this.nST != null) {
            ImageView imageView = (ImageView) this.nST.findViewById(R.id.camera_switch);
            ImageView imageView2 = (ImageView) this.nST.findViewById(R.id.flash_switch);
            this.nTB = (ProgressView) this.nST.findViewById(R.id.video_progress_view);
            this.nTB.setListener(new AnonymousClass1());
            if (!com.baidu.tieba.video.record.a.za(true)) {
                imageView2.setVisibility(4);
            }
            if (!com.baidu.tieba.video.record.a.b(recordVideoActivity.getPackageManager())) {
                imageView.setVisibility(8);
            }
        }
    }

    /* renamed from: com.baidu.tieba.video.record.i$1  reason: invalid class name */
    /* loaded from: classes7.dex */
    class AnonymousClass1 implements ProgressView.a {
        AnonymousClass1() {
        }

        @Override // com.baidu.tieba.video.record.ProgressView.a
        public void KQ(int i) {
            h hVar;
            final g dUc;
            i.this.mProgress = i;
            if (i == 100 && i.this.nST != null && (hVar = i.this.nST.nSw) != null && (dUc = hVar.dUc()) != null) {
                if (dUc instanceof GLVideoPreviewView) {
                    dUc.setOnEncoderStatusUpdateListener(new d.c() { // from class: com.baidu.tieba.video.record.i.1.1
                        @Override // com.faceunity.a.d.c
                        public void VO() {
                        }

                        @Override // com.faceunity.a.d.c
                        public void dUy() {
                            com.baidu.adp.lib.f.e.mA().post(new Runnable() { // from class: com.baidu.tieba.video.record.i.1.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (i.this.nST != null) {
                                        i.this.nST.dUT();
                                    }
                                }
                            });
                            dUc.setOnEncoderStatusUpdateListener(null);
                        }
                    });
                    i.this.stopRecord();
                    return;
                }
                i.this.stopRecord();
                if (i.this.nST != null) {
                    i.this.nST.dUT();
                }
            }
        }
    }

    public int getVideoDuration() {
        return this.nTA;
    }

    public void startRecord() {
        if (!this.nTD) {
            if (this.nTB != null) {
                this.nTB.setVisibility(0);
                this.nTB.setCurrentState(ProgressView.State.START);
            }
            if (!this.nTD) {
                this.nTD = true;
                this.adM = System.currentTimeMillis();
            }
            if (this.nST != null && this.nST.nSw != null) {
                this.nST.nSw.startRecord();
                if (this.nST.nUp != null) {
                    this.nST.nUp.KS(this.nTA);
                }
            }
        }
    }

    public boolean dUv() {
        if (this.nST.nUp != null) {
            return this.nST.nUp.dUv();
        }
        return false;
    }

    public void stopRecord() {
        if (this.nTD) {
            if (this.nTB != null) {
                this.nTB.setCurrentState(ProgressView.State.PAUSE);
            }
            this.nTD = false;
            this.nTA = (int) (this.nTA + (System.currentTimeMillis() - this.adM));
            if (this.nTB != null && this.nTB.getLastProgress() != this.nTA) {
                this.nTB.KP(this.nTA);
            }
            if (this.nST != null && this.nST.nSw != null) {
                this.nST.nSw.stopRecord();
            }
        }
    }

    public void dUw() {
        if (!this.nTD && this.nTB != null) {
            this.nTB.setCurrentState(ProgressView.State.ROLLBACK);
        }
    }

    public void dUx() {
        if (this.nTB != null) {
            this.nTB.setCurrentState(ProgressView.State.DELETE);
        }
        this.nTA = this.nTB.getLastProgress();
        if (this.nST.nSw != null) {
            this.nST.nSw.dUe();
        }
    }

    public boolean onBackPressed() {
        return this.nTB.dUu();
    }

    public int getStatus() {
        return this.mStatus;
    }

    public void setStatus(int i) {
        File[] listFiles;
        this.mStatus = i;
        if (i == 1) {
            this.nTB.setVisibility(4);
            this.nTB.reset();
            this.nTA = 0;
            File file = new File(com.baidu.tieba.video.c.nMR);
            if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
                for (File file2 : listFiles) {
                    if (file2.getPath().startsWith("rec_tmp_")) {
                        file2.delete();
                    }
                }
            }
        }
        if (this.nTC != null) {
            for (a aVar : this.nTC) {
                aVar.KR(this.mStatus);
            }
        }
    }

    public boolean isRecording() {
        int status = getStatus();
        return status == 2 || status == 7;
    }

    public boolean bUq() {
        return this.mStatus == 6;
    }

    public int getProgress() {
        return this.mProgress;
    }

    public void a(a aVar) {
        if (this.nTC == null) {
            this.nTC = new ArrayList();
        }
        this.nTC.add(aVar);
    }
}
