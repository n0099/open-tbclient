package com.baidu.tieba.video.record;

import android.widget.ImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.video.record.ProgressView;
import com.faceunity.a.d;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes17.dex */
public class i {
    private long aaa;
    private boolean bOe;
    private RecordVideoActivity mAP;
    private ProgressView mBA;
    private int mBz;
    private int mProgress;
    private int mStatus = 1;
    protected List<a> mStatusListeners;

    /* loaded from: classes17.dex */
    public interface a {
        void Jc(int i);
    }

    public i(RecordVideoActivity recordVideoActivity) {
        this.mAP = recordVideoActivity;
        if (this.mAP != null) {
            ImageView imageView = (ImageView) this.mAP.findViewById(R.id.camera_switch);
            ImageView imageView2 = (ImageView) this.mAP.findViewById(R.id.flash_switch);
            this.mBA = (ProgressView) this.mAP.findViewById(R.id.video_progress_view);
            this.mBA.setListener(new AnonymousClass1());
            if (!com.baidu.tieba.video.record.a.wK(true)) {
                imageView2.setVisibility(4);
            }
            if (!com.baidu.tieba.video.record.a.b(recordVideoActivity.getPackageManager())) {
                imageView.setVisibility(8);
            }
        }
    }

    /* renamed from: com.baidu.tieba.video.record.i$1  reason: invalid class name */
    /* loaded from: classes17.dex */
    class AnonymousClass1 implements ProgressView.a {
        AnonymousClass1() {
        }

        @Override // com.baidu.tieba.video.record.ProgressView.a
        public void Jb(int i) {
            h hVar;
            final g dDg;
            i.this.mProgress = i;
            if (i == 100 && i.this.mAP != null && (hVar = i.this.mAP.mAr) != null && (dDg = hVar.dDg()) != null) {
                if (dDg instanceof GLVideoPreviewView) {
                    dDg.setOnEncoderStatusUpdateListener(new d.c() { // from class: com.baidu.tieba.video.record.i.1.1
                        @Override // com.faceunity.a.d.c
                        public void Pt() {
                        }

                        @Override // com.faceunity.a.d.c
                        public void dDC() {
                            com.baidu.adp.lib.f.e.mS().post(new Runnable() { // from class: com.baidu.tieba.video.record.i.1.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (i.this.mAP != null) {
                                        i.this.mAP.dDW();
                                    }
                                }
                            });
                            dDg.setOnEncoderStatusUpdateListener(null);
                        }
                    });
                    i.this.stopRecord();
                    return;
                }
                i.this.stopRecord();
                if (i.this.mAP != null) {
                    i.this.mAP.dDW();
                }
            }
        }
    }

    public int getVideoDuration() {
        return this.mBz;
    }

    public void startRecord() {
        if (!this.bOe) {
            if (this.mBA != null) {
                this.mBA.setVisibility(0);
                this.mBA.setCurrentState(ProgressView.State.START);
            }
            if (!this.bOe) {
                this.bOe = true;
                this.aaa = System.currentTimeMillis();
            }
            if (this.mAP != null && this.mAP.mAr != null) {
                this.mAP.mAr.startRecord();
                if (this.mAP.mCn != null) {
                    this.mAP.mCn.Jd(this.mBz);
                }
            }
        }
    }

    public boolean dDz() {
        if (this.mAP.mCn != null) {
            return this.mAP.mCn.dDz();
        }
        return false;
    }

    public void stopRecord() {
        if (this.bOe) {
            if (this.mBA != null) {
                this.mBA.setCurrentState(ProgressView.State.PAUSE);
            }
            this.bOe = false;
            this.mBz = (int) (this.mBz + (System.currentTimeMillis() - this.aaa));
            if (this.mBA != null && this.mBA.getLastProgress() != this.mBz) {
                this.mBA.Ja(this.mBz);
            }
            if (this.mAP != null && this.mAP.mAr != null) {
                this.mAP.mAr.stopRecord();
            }
        }
    }

    public void dDA() {
        if (!this.bOe && this.mBA != null) {
            this.mBA.setCurrentState(ProgressView.State.ROLLBACK);
        }
    }

    public void dDB() {
        if (this.mBA != null) {
            this.mBA.setCurrentState(ProgressView.State.DELETE);
        }
        this.mBz = this.mBA.getLastProgress();
        if (this.mAP.mAr != null) {
            this.mAP.mAr.dDi();
        }
    }

    public boolean onBackPressed() {
        return this.mBA.dDy();
    }

    public int getStatus() {
        return this.mStatus;
    }

    public void setStatus(int i) {
        File[] listFiles;
        this.mStatus = i;
        if (i == 1) {
            this.mBA.setVisibility(4);
            this.mBA.reset();
            this.mBz = 0;
            File file = new File(com.baidu.tieba.video.c.mtS);
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
                aVar.Jc(this.mStatus);
            }
        }
    }

    public boolean bmc() {
        int status = getStatus();
        return status == 2 || status == 7;
    }

    public boolean bIO() {
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
