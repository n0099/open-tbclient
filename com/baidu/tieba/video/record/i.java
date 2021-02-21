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
    private long acr;
    private int mProgress;
    private int mStatus = 1;
    private RecordVideoActivity nQO;
    private int nRv;
    private ProgressView nRw;
    protected List<a> nRx;
    private boolean nRy;

    /* loaded from: classes8.dex */
    public interface a {
        void KM(int i);
    }

    public i(RecordVideoActivity recordVideoActivity) {
        this.nQO = recordVideoActivity;
        if (this.nQO != null) {
            ImageView imageView = (ImageView) this.nQO.findViewById(R.id.camera_switch);
            ImageView imageView2 = (ImageView) this.nQO.findViewById(R.id.flash_switch);
            this.nRw = (ProgressView) this.nQO.findViewById(R.id.video_progress_view);
            this.nRw.setListener(new AnonymousClass1());
            if (!com.baidu.tieba.video.record.a.zb(true)) {
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
        public void KL(int i) {
            h hVar;
            final g dTU;
            i.this.mProgress = i;
            if (i == 100 && i.this.nQO != null && (hVar = i.this.nQO.nQr) != null && (dTU = hVar.dTU()) != null) {
                if (dTU instanceof GLVideoPreviewView) {
                    dTU.setOnEncoderStatusUpdateListener(new d.c() { // from class: com.baidu.tieba.video.record.i.1.1
                        @Override // com.faceunity.a.d.c
                        public void VL() {
                        }

                        @Override // com.faceunity.a.d.c
                        public void dUq() {
                            com.baidu.adp.lib.f.e.mA().post(new Runnable() { // from class: com.baidu.tieba.video.record.i.1.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (i.this.nQO != null) {
                                        i.this.nQO.dUL();
                                    }
                                }
                            });
                            dTU.setOnEncoderStatusUpdateListener(null);
                        }
                    });
                    i.this.stopRecord();
                    return;
                }
                i.this.stopRecord();
                if (i.this.nQO != null) {
                    i.this.nQO.dUL();
                }
            }
        }
    }

    public int getVideoDuration() {
        return this.nRv;
    }

    public void startRecord() {
        if (!this.nRy) {
            if (this.nRw != null) {
                this.nRw.setVisibility(0);
                this.nRw.setCurrentState(ProgressView.State.START);
            }
            if (!this.nRy) {
                this.nRy = true;
                this.acr = System.currentTimeMillis();
            }
            if (this.nQO != null && this.nQO.nQr != null) {
                this.nQO.nQr.startRecord();
                if (this.nQO.nSk != null) {
                    this.nQO.nSk.KN(this.nRv);
                }
            }
        }
    }

    public boolean dUn() {
        if (this.nQO.nSk != null) {
            return this.nQO.nSk.dUn();
        }
        return false;
    }

    public void stopRecord() {
        if (this.nRy) {
            if (this.nRw != null) {
                this.nRw.setCurrentState(ProgressView.State.PAUSE);
            }
            this.nRy = false;
            this.nRv = (int) (this.nRv + (System.currentTimeMillis() - this.acr));
            if (this.nRw != null && this.nRw.getLastProgress() != this.nRv) {
                this.nRw.KK(this.nRv);
            }
            if (this.nQO != null && this.nQO.nQr != null) {
                this.nQO.nQr.stopRecord();
            }
        }
    }

    public void dUo() {
        if (!this.nRy && this.nRw != null) {
            this.nRw.setCurrentState(ProgressView.State.ROLLBACK);
        }
    }

    public void dUp() {
        if (this.nRw != null) {
            this.nRw.setCurrentState(ProgressView.State.DELETE);
        }
        this.nRv = this.nRw.getLastProgress();
        if (this.nQO.nQr != null) {
            this.nQO.nQr.dTW();
        }
    }

    public boolean onBackPressed() {
        return this.nRw.dUm();
    }

    public int getStatus() {
        return this.mStatus;
    }

    public void setStatus(int i) {
        File[] listFiles;
        this.mStatus = i;
        if (i == 1) {
            this.nRw.setVisibility(4);
            this.nRw.reset();
            this.nRv = 0;
            File file = new File(com.baidu.tieba.video.c.nKM);
            if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
                for (File file2 : listFiles) {
                    if (file2.getPath().startsWith("rec_tmp_")) {
                        file2.delete();
                    }
                }
            }
        }
        if (this.nRx != null) {
            for (a aVar : this.nRx) {
                aVar.KM(this.mStatus);
            }
        }
    }

    public boolean isRecording() {
        int status = getStatus();
        return status == 2 || status == 7;
    }

    public boolean bUk() {
        return this.mStatus == 6;
    }

    public int getProgress() {
        return this.mProgress;
    }

    public void a(a aVar) {
        if (this.nRx == null) {
            this.nRx = new ArrayList();
        }
        this.nRx.add(aVar);
    }
}
