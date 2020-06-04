package com.baidu.tieba.video.record;

import android.widget.ImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.video.record.ProgressView;
import com.faceunity.a.d;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class i {
    private long YT;
    private boolean bDm;
    private RecordVideoActivity lHD;
    private int lIm;
    private ProgressView lIn;
    private int mProgress;
    private int mStatus = 1;
    protected List<a> mStatusListeners;

    /* loaded from: classes10.dex */
    public interface a {
        void Fh(int i);
    }

    public i(RecordVideoActivity recordVideoActivity) {
        this.lHD = recordVideoActivity;
        if (this.lHD != null) {
            ImageView imageView = (ImageView) this.lHD.findViewById(R.id.camera_switch);
            ImageView imageView2 = (ImageView) this.lHD.findViewById(R.id.flash_switch);
            this.lIn = (ProgressView) this.lHD.findViewById(R.id.video_progress_view);
            this.lIn.setListener(new AnonymousClass1());
            if (!com.baidu.tieba.video.record.a.uX(true)) {
                imageView2.setVisibility(4);
            }
            if (!com.baidu.tieba.video.record.a.b(recordVideoActivity.getPackageManager())) {
                imageView.setVisibility(8);
            }
        }
    }

    /* renamed from: com.baidu.tieba.video.record.i$1  reason: invalid class name */
    /* loaded from: classes10.dex */
    class AnonymousClass1 implements ProgressView.a {
        AnonymousClass1() {
        }

        @Override // com.baidu.tieba.video.record.ProgressView.a
        public void Fg(int i) {
            h hVar;
            final g dkc;
            i.this.mProgress = i;
            if (i == 100 && i.this.lHD != null && (hVar = i.this.lHD.lHf) != null && (dkc = hVar.dkc()) != null) {
                if (dkc instanceof GLVideoPreviewView) {
                    dkc.setOnEncoderStatusUpdateListener(new d.c() { // from class: com.baidu.tieba.video.record.i.1.1
                        @Override // com.faceunity.a.d.c
                        public void Ih() {
                        }

                        @Override // com.faceunity.a.d.c
                        public void dky() {
                            com.baidu.adp.lib.f.e.ld().post(new Runnable() { // from class: com.baidu.tieba.video.record.i.1.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (i.this.lHD != null) {
                                        i.this.lHD.dkS();
                                    }
                                }
                            });
                            dkc.setOnEncoderStatusUpdateListener(null);
                        }
                    });
                    i.this.stopRecord();
                    return;
                }
                i.this.stopRecord();
                if (i.this.lHD != null) {
                    i.this.lHD.dkS();
                }
            }
        }
    }

    public int getVideoDuration() {
        return this.lIm;
    }

    public void startRecord() {
        if (!this.bDm) {
            if (this.lIn != null) {
                this.lIn.setVisibility(0);
                this.lIn.setCurrentState(ProgressView.State.START);
            }
            if (!this.bDm) {
                this.bDm = true;
                this.YT = System.currentTimeMillis();
            }
            if (this.lHD != null && this.lHD.lHf != null) {
                this.lHD.lHf.startRecord();
                if (this.lHD.lJa != null) {
                    this.lHD.lJa.Fi(this.lIm);
                }
            }
        }
    }

    public boolean dkv() {
        if (this.lHD.lJa != null) {
            return this.lHD.lJa.dkv();
        }
        return false;
    }

    public void stopRecord() {
        if (this.bDm) {
            if (this.lIn != null) {
                this.lIn.setCurrentState(ProgressView.State.PAUSE);
            }
            this.bDm = false;
            this.lIm = (int) (this.lIm + (System.currentTimeMillis() - this.YT));
            if (this.lIn != null && this.lIn.getLastProgress() != this.lIm) {
                this.lIn.Ff(this.lIm);
            }
            if (this.lHD != null && this.lHD.lHf != null) {
                this.lHD.lHf.stopRecord();
            }
        }
    }

    public void dkw() {
        if (!this.bDm && this.lIn != null) {
            this.lIn.setCurrentState(ProgressView.State.ROLLBACK);
        }
    }

    public void dkx() {
        if (this.lIn != null) {
            this.lIn.setCurrentState(ProgressView.State.DELETE);
        }
        this.lIm = this.lIn.getLastProgress();
        if (this.lHD.lHf != null) {
            this.lHD.lHf.dke();
        }
    }

    public boolean onBackPressed() {
        return this.lIn.dku();
    }

    public int getStatus() {
        return this.mStatus;
    }

    public void setStatus(int i) {
        File[] listFiles;
        this.mStatus = i;
        if (i == 1) {
            this.lIn.setVisibility(4);
            this.lIn.reset();
            this.lIm = 0;
            File file = new File(com.baidu.tieba.video.c.lAO);
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
                aVar.Fh(this.mStatus);
            }
        }
    }

    public boolean aXt() {
        int status = getStatus();
        return status == 2 || status == 7;
    }

    public boolean bty() {
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
