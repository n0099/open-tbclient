package com.baidu.tieba.video.record;

import android.widget.ImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.video.record.ProgressView;
import com.faceunity.a.d;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes22.dex */
public class i {
    private long aaP;
    private boolean cmj;
    private int mProgress;
    private int mStatus = 1;
    protected List<a> mStatusListeners;
    private RecordVideoActivity ntQ;
    private ProgressView nuA;
    private int nuz;

    /* loaded from: classes22.dex */
    public interface a {
        void Lu(int i);
    }

    public i(RecordVideoActivity recordVideoActivity) {
        this.ntQ = recordVideoActivity;
        if (this.ntQ != null) {
            ImageView imageView = (ImageView) this.ntQ.findViewById(R.id.camera_switch);
            ImageView imageView2 = (ImageView) this.ntQ.findViewById(R.id.flash_switch);
            this.nuA = (ProgressView) this.ntQ.findViewById(R.id.video_progress_view);
            this.nuA.setListener(new AnonymousClass1());
            if (!com.baidu.tieba.video.record.a.yh(true)) {
                imageView2.setVisibility(4);
            }
            if (!com.baidu.tieba.video.record.a.b(recordVideoActivity.getPackageManager())) {
                imageView.setVisibility(8);
            }
        }
    }

    /* renamed from: com.baidu.tieba.video.record.i$1  reason: invalid class name */
    /* loaded from: classes22.dex */
    class AnonymousClass1 implements ProgressView.a {
        AnonymousClass1() {
        }

        @Override // com.baidu.tieba.video.record.ProgressView.a
        public void Lt(int i) {
            h hVar;
            final g dQv;
            i.this.mProgress = i;
            if (i == 100 && i.this.ntQ != null && (hVar = i.this.ntQ.nts) != null && (dQv = hVar.dQv()) != null) {
                if (dQv instanceof GLVideoPreviewView) {
                    dQv.setOnEncoderStatusUpdateListener(new d.c() { // from class: com.baidu.tieba.video.record.i.1.1
                        @Override // com.faceunity.a.d.c
                        public void Um() {
                        }

                        @Override // com.faceunity.a.d.c
                        public void dQR() {
                            com.baidu.adp.lib.f.e.mY().post(new Runnable() { // from class: com.baidu.tieba.video.record.i.1.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (i.this.ntQ != null) {
                                        i.this.ntQ.dRl();
                                    }
                                }
                            });
                            dQv.setOnEncoderStatusUpdateListener(null);
                        }
                    });
                    i.this.stopRecord();
                    return;
                }
                i.this.stopRecord();
                if (i.this.ntQ != null) {
                    i.this.ntQ.dRl();
                }
            }
        }
    }

    public int getVideoDuration() {
        return this.nuz;
    }

    public void startRecord() {
        if (!this.cmj) {
            if (this.nuA != null) {
                this.nuA.setVisibility(0);
                this.nuA.setCurrentState(ProgressView.State.START);
            }
            if (!this.cmj) {
                this.cmj = true;
                this.aaP = System.currentTimeMillis();
            }
            if (this.ntQ != null && this.ntQ.nts != null) {
                this.ntQ.nts.startRecord();
                if (this.ntQ.nvm != null) {
                    this.ntQ.nvm.Lv(this.nuz);
                }
            }
        }
    }

    public boolean dQO() {
        if (this.ntQ.nvm != null) {
            return this.ntQ.nvm.dQO();
        }
        return false;
    }

    public void stopRecord() {
        if (this.cmj) {
            if (this.nuA != null) {
                this.nuA.setCurrentState(ProgressView.State.PAUSE);
            }
            this.cmj = false;
            this.nuz = (int) (this.nuz + (System.currentTimeMillis() - this.aaP));
            if (this.nuA != null && this.nuA.getLastProgress() != this.nuz) {
                this.nuA.Ls(this.nuz);
            }
            if (this.ntQ != null && this.ntQ.nts != null) {
                this.ntQ.nts.stopRecord();
            }
        }
    }

    public void dQP() {
        if (!this.cmj && this.nuA != null) {
            this.nuA.setCurrentState(ProgressView.State.ROLLBACK);
        }
    }

    public void dQQ() {
        if (this.nuA != null) {
            this.nuA.setCurrentState(ProgressView.State.DELETE);
        }
        this.nuz = this.nuA.getLastProgress();
        if (this.ntQ.nts != null) {
            this.ntQ.nts.dQx();
        }
    }

    public boolean onBackPressed() {
        return this.nuA.dQN();
    }

    public int getStatus() {
        return this.mStatus;
    }

    public void setStatus(int i) {
        File[] listFiles;
        this.mStatus = i;
        if (i == 1) {
            this.nuA.setVisibility(4);
            this.nuA.reset();
            this.nuz = 0;
            File file = new File(com.baidu.tieba.video.c.nmU);
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
                aVar.Lu(this.mStatus);
            }
        }
    }

    public boolean btp() {
        int status = getStatus();
        return status == 2 || status == 7;
    }

    public boolean bRa() {
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
