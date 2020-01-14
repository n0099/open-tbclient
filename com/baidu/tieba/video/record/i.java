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
    private long EW;
    private boolean aSv;
    private RecordVideoActivity kAt;
    private ProgressView kBd;
    private int mProgress;
    private int mStatus = 1;
    protected List<a> mStatusListeners;
    private int mVideoLength;

    /* loaded from: classes8.dex */
    public interface a {
        void DC(int i);
    }

    public i(RecordVideoActivity recordVideoActivity) {
        this.kAt = recordVideoActivity;
        if (this.kAt != null) {
            ImageView imageView = (ImageView) this.kAt.findViewById(R.id.camera_switch);
            ImageView imageView2 = (ImageView) this.kAt.findViewById(R.id.flash_switch);
            this.kBd = (ProgressView) this.kAt.findViewById(R.id.video_progress_view);
            this.kBd.setListener(new AnonymousClass1());
            if (!com.baidu.tieba.video.record.a.tn(true)) {
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
        public void DB(int i) {
            h hVar;
            final g cPM;
            i.this.mProgress = i;
            if (i == 100 && i.this.kAt != null && (hVar = i.this.kAt.kzX) != null && (cPM = hVar.cPM()) != null) {
                if (cPM instanceof GLVideoPreviewView) {
                    cPM.setOnEncoderStatusUpdateListener(new d.c() { // from class: com.baidu.tieba.video.record.i.1.1
                        @Override // com.faceunity.a.d.c
                        public void onStartSuccess() {
                        }

                        @Override // com.faceunity.a.d.c
                        public void onStopSuccess() {
                            com.baidu.adp.lib.f.e.gx().post(new Runnable() { // from class: com.baidu.tieba.video.record.i.1.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (i.this.kAt != null) {
                                        i.this.kAt.cQA();
                                    }
                                }
                            });
                            cPM.setOnEncoderStatusUpdateListener(null);
                        }
                    });
                    i.this.stopRecord();
                    return;
                }
                i.this.stopRecord();
                if (i.this.kAt != null) {
                    i.this.kAt.cQA();
                }
            }
        }
    }

    public int getVideoDuration() {
        return this.mVideoLength;
    }

    public void startRecord() {
        if (!this.aSv) {
            if (this.kBd != null) {
                this.kBd.setVisibility(0);
                this.kBd.setCurrentState(ProgressView.State.START);
            }
            if (!this.aSv) {
                this.aSv = true;
                this.EW = System.currentTimeMillis();
            }
            if (this.kAt != null && this.kAt.kzX != null) {
                this.kAt.kzX.startRecord();
                if (this.kAt.kBR != null) {
                    this.kAt.kBR.DD(this.mVideoLength);
                }
            }
        }
    }

    public boolean cQe() {
        if (this.kAt.kBR != null) {
            return this.kAt.kBR.cQe();
        }
        return false;
    }

    public void stopRecord() {
        if (this.aSv) {
            if (this.kBd != null) {
                this.kBd.setCurrentState(ProgressView.State.PAUSE);
            }
            this.aSv = false;
            this.mVideoLength = (int) (this.mVideoLength + (System.currentTimeMillis() - this.EW));
            if (this.kBd != null && this.kBd.getLastProgress() != this.mVideoLength) {
                this.kBd.DA(this.mVideoLength);
            }
            if (this.kAt != null && this.kAt.kzX != null) {
                this.kAt.kzX.stopRecord();
            }
        }
    }

    public void cQf() {
        if (!this.aSv && this.kBd != null) {
            this.kBd.setCurrentState(ProgressView.State.ROLLBACK);
        }
    }

    public void cQg() {
        if (this.kBd != null) {
            this.kBd.setCurrentState(ProgressView.State.DELETE);
        }
        this.mVideoLength = this.kBd.getLastProgress();
        if (this.kAt.kzX != null) {
            this.kAt.kzX.cPO();
        }
    }

    public boolean onBackPressed() {
        return this.kBd.cQd();
    }

    public int getStatus() {
        return this.mStatus;
    }

    public void setStatus(int i) {
        File[] listFiles;
        this.mStatus = i;
        if (i == 1) {
            this.kBd.setVisibility(4);
            this.kBd.reset();
            this.mVideoLength = 0;
            File file = new File(com.baidu.tieba.video.c.ktO);
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
                aVar.DC(this.mStatus);
            }
        }
    }

    public boolean isRecording() {
        int status = getStatus();
        return status == 2 || status == 7;
    }

    public boolean bbT() {
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
