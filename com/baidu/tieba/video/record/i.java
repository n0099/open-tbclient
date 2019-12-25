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
    private long ER;
    private boolean aRD;
    private RecordVideoActivity kwM;
    private ProgressView kxw;
    private int mProgress;
    private int mStatus = 1;
    protected List<a> mStatusListeners;
    private int mVideoLength;

    /* loaded from: classes7.dex */
    public interface a {
        void Dw(int i);
    }

    public i(RecordVideoActivity recordVideoActivity) {
        this.kwM = recordVideoActivity;
        if (this.kwM != null) {
            ImageView imageView = (ImageView) this.kwM.findViewById(R.id.camera_switch);
            ImageView imageView2 = (ImageView) this.kwM.findViewById(R.id.flash_switch);
            this.kxw = (ProgressView) this.kwM.findViewById(R.id.video_progress_view);
            this.kxw.setListener(new AnonymousClass1());
            if (!com.baidu.tieba.video.record.a.tb(true)) {
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
        public void Dv(int i) {
            h hVar;
            final g cOH;
            i.this.mProgress = i;
            if (i == 100 && i.this.kwM != null && (hVar = i.this.kwM.kwq) != null && (cOH = hVar.cOH()) != null) {
                if (cOH instanceof GLVideoPreviewView) {
                    cOH.setOnEncoderStatusUpdateListener(new d.c() { // from class: com.baidu.tieba.video.record.i.1.1
                        @Override // com.faceunity.a.d.c
                        public void onStartSuccess() {
                        }

                        @Override // com.faceunity.a.d.c
                        public void onStopSuccess() {
                            com.baidu.adp.lib.f.e.gy().post(new Runnable() { // from class: com.baidu.tieba.video.record.i.1.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (i.this.kwM != null) {
                                        i.this.kwM.cPv();
                                    }
                                }
                            });
                            cOH.setOnEncoderStatusUpdateListener(null);
                        }
                    });
                    i.this.stopRecord();
                    return;
                }
                i.this.stopRecord();
                if (i.this.kwM != null) {
                    i.this.kwM.cPv();
                }
            }
        }
    }

    public int getVideoDuration() {
        return this.mVideoLength;
    }

    public void startRecord() {
        if (!this.aRD) {
            if (this.kxw != null) {
                this.kxw.setVisibility(0);
                this.kxw.setCurrentState(ProgressView.State.START);
            }
            if (!this.aRD) {
                this.aRD = true;
                this.ER = System.currentTimeMillis();
            }
            if (this.kwM != null && this.kwM.kwq != null) {
                this.kwM.kwq.startRecord();
                if (this.kwM.kyk != null) {
                    this.kwM.kyk.Dx(this.mVideoLength);
                }
            }
        }
    }

    public boolean cOZ() {
        if (this.kwM.kyk != null) {
            return this.kwM.kyk.cOZ();
        }
        return false;
    }

    public void stopRecord() {
        if (this.aRD) {
            if (this.kxw != null) {
                this.kxw.setCurrentState(ProgressView.State.PAUSE);
            }
            this.aRD = false;
            this.mVideoLength = (int) (this.mVideoLength + (System.currentTimeMillis() - this.ER));
            if (this.kxw != null && this.kxw.getLastProgress() != this.mVideoLength) {
                this.kxw.Du(this.mVideoLength);
            }
            if (this.kwM != null && this.kwM.kwq != null) {
                this.kwM.kwq.stopRecord();
            }
        }
    }

    public void cPa() {
        if (!this.aRD && this.kxw != null) {
            this.kxw.setCurrentState(ProgressView.State.ROLLBACK);
        }
    }

    public void cPb() {
        if (this.kxw != null) {
            this.kxw.setCurrentState(ProgressView.State.DELETE);
        }
        this.mVideoLength = this.kxw.getLastProgress();
        if (this.kwM.kwq != null) {
            this.kwM.kwq.cOJ();
        }
    }

    public boolean onBackPressed() {
        return this.kxw.cOY();
    }

    public int getStatus() {
        return this.mStatus;
    }

    public void setStatus(int i) {
        File[] listFiles;
        this.mStatus = i;
        if (i == 1) {
            this.kxw.setVisibility(4);
            this.kxw.reset();
            this.mVideoLength = 0;
            File file = new File(com.baidu.tieba.video.c.kqg);
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
                aVar.Dw(this.mStatus);
            }
        }
    }

    public boolean isRecording() {
        int status = getStatus();
        return status == 2 || status == 7;
    }

    public boolean bby() {
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
