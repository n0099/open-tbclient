package com.baidu.tieba.video.record;

import android.widget.ImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.video.record.ProgressView;
import com.faceunity.a.d;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes23.dex */
public class i {
    private long abM;
    private boolean cte;
    private int mProgress;
    private int mStatus = 1;
    protected List<a> mStatusListeners;
    private RecordVideoActivity nHU;
    private int nIC;
    private ProgressView nID;

    /* loaded from: classes23.dex */
    public interface a {
        void Mm(int i);
    }

    public i(RecordVideoActivity recordVideoActivity) {
        this.nHU = recordVideoActivity;
        if (this.nHU != null) {
            ImageView imageView = (ImageView) this.nHU.findViewById(R.id.camera_switch);
            ImageView imageView2 = (ImageView) this.nHU.findViewById(R.id.flash_switch);
            this.nID = (ProgressView) this.nHU.findViewById(R.id.video_progress_view);
            this.nID.setListener(new AnonymousClass1());
            if (!com.baidu.tieba.video.record.a.yM(true)) {
                imageView2.setVisibility(4);
            }
            if (!com.baidu.tieba.video.record.a.b(recordVideoActivity.getPackageManager())) {
                imageView.setVisibility(8);
            }
        }
    }

    /* renamed from: com.baidu.tieba.video.record.i$1  reason: invalid class name */
    /* loaded from: classes23.dex */
    class AnonymousClass1 implements ProgressView.a {
        AnonymousClass1() {
        }

        @Override // com.baidu.tieba.video.record.ProgressView.a
        public void Ml(int i) {
            h hVar;
            final g dVQ;
            i.this.mProgress = i;
            if (i == 100 && i.this.nHU != null && (hVar = i.this.nHU.nHw) != null && (dVQ = hVar.dVQ()) != null) {
                if (dVQ instanceof GLVideoPreviewView) {
                    dVQ.setOnEncoderStatusUpdateListener(new d.c() { // from class: com.baidu.tieba.video.record.i.1.1
                        @Override // com.faceunity.a.d.c
                        public void WO() {
                        }

                        @Override // com.faceunity.a.d.c
                        public void dWm() {
                            com.baidu.adp.lib.f.e.mY().post(new Runnable() { // from class: com.baidu.tieba.video.record.i.1.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (i.this.nHU != null) {
                                        i.this.nHU.dWG();
                                    }
                                }
                            });
                            dVQ.setOnEncoderStatusUpdateListener(null);
                        }
                    });
                    i.this.stopRecord();
                    return;
                }
                i.this.stopRecord();
                if (i.this.nHU != null) {
                    i.this.nHU.dWG();
                }
            }
        }
    }

    public int getVideoDuration() {
        return this.nIC;
    }

    public void startRecord() {
        if (!this.cte) {
            if (this.nID != null) {
                this.nID.setVisibility(0);
                this.nID.setCurrentState(ProgressView.State.START);
            }
            if (!this.cte) {
                this.cte = true;
                this.abM = System.currentTimeMillis();
            }
            if (this.nHU != null && this.nHU.nHw != null) {
                this.nHU.nHw.startRecord();
                if (this.nHU.nJp != null) {
                    this.nHU.nJp.Mn(this.nIC);
                }
            }
        }
    }

    public boolean dWj() {
        if (this.nHU.nJp != null) {
            return this.nHU.nJp.dWj();
        }
        return false;
    }

    public void stopRecord() {
        if (this.cte) {
            if (this.nID != null) {
                this.nID.setCurrentState(ProgressView.State.PAUSE);
            }
            this.cte = false;
            this.nIC = (int) (this.nIC + (System.currentTimeMillis() - this.abM));
            if (this.nID != null && this.nID.getLastProgress() != this.nIC) {
                this.nID.Mk(this.nIC);
            }
            if (this.nHU != null && this.nHU.nHw != null) {
                this.nHU.nHw.stopRecord();
            }
        }
    }

    public void dWk() {
        if (!this.cte && this.nID != null) {
            this.nID.setCurrentState(ProgressView.State.ROLLBACK);
        }
    }

    public void dWl() {
        if (this.nID != null) {
            this.nID.setCurrentState(ProgressView.State.DELETE);
        }
        this.nIC = this.nID.getLastProgress();
        if (this.nHU.nHw != null) {
            this.nHU.nHw.dVS();
        }
    }

    public boolean onBackPressed() {
        return this.nID.dWi();
    }

    public int getStatus() {
        return this.mStatus;
    }

    public void setStatus(int i) {
        File[] listFiles;
        this.mStatus = i;
        if (i == 1) {
            this.nID.setVisibility(4);
            this.nID.reset();
            this.nIC = 0;
            File file = new File(com.baidu.tieba.video.c.nAZ);
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
                aVar.Mm(this.mStatus);
            }
        }
    }

    public boolean bwP() {
        int status = getStatus();
        return status == 2 || status == 7;
    }

    public boolean bUL() {
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
