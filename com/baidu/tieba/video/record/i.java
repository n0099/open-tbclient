package com.baidu.tieba.video.record;

import android.widget.ImageView;
import com.baidu.tieba.e;
import com.baidu.tieba.video.record.ProgressView;
import com.faceunity.a.d;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class i {
    private long Sx;
    private RecordVideoActivity hJV;
    private int hKG;
    private ProgressView hKH;
    protected List<a> hKI;
    private boolean hKJ;
    private int mProgress;
    private int mStatus = 1;

    /* loaded from: classes5.dex */
    public interface a {
        void wQ(int i);
    }

    public i(RecordVideoActivity recordVideoActivity) {
        this.hJV = recordVideoActivity;
        if (this.hJV != null) {
            ImageView imageView = (ImageView) this.hJV.findViewById(e.g.camera_switch);
            ImageView imageView2 = (ImageView) this.hJV.findViewById(e.g.flash_switch);
            this.hKH = (ProgressView) this.hJV.findViewById(e.g.video_progress_view);
            this.hKH.setListener(new AnonymousClass1());
            if (!com.baidu.tieba.video.record.a.oe(true)) {
                imageView2.setVisibility(4);
            }
            if (!com.baidu.tieba.video.record.a.b(recordVideoActivity.getPackageManager())) {
                imageView.setVisibility(8);
            }
        }
    }

    /* renamed from: com.baidu.tieba.video.record.i$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    class AnonymousClass1 implements ProgressView.a {
        AnonymousClass1() {
        }

        @Override // com.baidu.tieba.video.record.ProgressView.a
        public void wP(int i) {
            h hVar;
            final g bKP;
            i.this.mProgress = i;
            if (i == 100 && i.this.hJV != null && (hVar = i.this.hJV.hJv) != null && (bKP = hVar.bKP()) != null) {
                if (bKP instanceof GLVideoPreviewView) {
                    bKP.setOnEncoderStatusUpdateListener(new d.c() { // from class: com.baidu.tieba.video.record.i.1.1
                        @Override // com.faceunity.a.d.c
                        public void bLk() {
                        }

                        @Override // com.faceunity.a.d.c
                        public void bLl() {
                            com.baidu.adp.lib.g.e.jG().post(new Runnable() { // from class: com.baidu.tieba.video.record.i.1.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (i.this.hJV != null) {
                                        i.this.hJV.bLF();
                                    }
                                }
                            });
                            bKP.setOnEncoderStatusUpdateListener(null);
                        }
                    });
                    i.this.stopRecord();
                    return;
                }
                i.this.stopRecord();
                if (i.this.hJV != null) {
                    i.this.hJV.bLF();
                }
            }
        }
    }

    public int getVideoDuration() {
        return this.hKG;
    }

    public void startRecord() {
        if (!this.hKJ) {
            if (this.hKH != null) {
                this.hKH.setVisibility(0);
                this.hKH.setCurrentState(ProgressView.State.START);
            }
            if (!this.hKJ) {
                this.hKJ = true;
                this.Sx = System.currentTimeMillis();
            }
            if (this.hJV != null && this.hJV.hJv != null) {
                this.hJV.hJv.startRecord();
                if (this.hJV.hLy != null) {
                    this.hJV.hLy.wR(this.hKG);
                }
            }
        }
    }

    public boolean bLg() {
        if (this.hJV.hLy != null) {
            return this.hJV.hLy.bLg();
        }
        return false;
    }

    public void stopRecord() {
        if (this.hKJ) {
            if (this.hKH != null) {
                this.hKH.setCurrentState(ProgressView.State.PAUSE);
            }
            this.hKJ = false;
            this.hKG = (int) (this.hKG + (System.currentTimeMillis() - this.Sx));
            if (this.hKH != null && this.hKH.getLastProgress() != this.hKG) {
                this.hKH.wO(this.hKG);
            }
            if (this.hJV != null && this.hJV.hJv != null) {
                this.hJV.hJv.stopRecord();
            }
        }
    }

    public void bLh() {
        if (!this.hKJ && this.hKH != null) {
            this.hKH.setCurrentState(ProgressView.State.ROLLBACK);
        }
    }

    public void bLi() {
        if (this.hKH != null) {
            this.hKH.setCurrentState(ProgressView.State.DELETE);
        }
        this.hKG = this.hKH.getLastProgress();
        if (this.hJV.hJv != null) {
            this.hJV.hJv.bKR();
        }
    }

    public boolean onBackPressed() {
        return this.hKH.bLf();
    }

    public int getStatus() {
        return this.mStatus;
    }

    public void setStatus(int i) {
        File[] listFiles;
        this.mStatus = i;
        if (i == 1) {
            this.hKH.setVisibility(4);
            this.hKH.reset();
            this.hKG = 0;
            File file = new File(com.baidu.tieba.video.c.hCT);
            if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
                for (File file2 : listFiles) {
                    if (file2.getPath().startsWith("rec_tmp_")) {
                        file2.delete();
                    }
                }
            }
        }
        if (this.hKI != null) {
            for (a aVar : this.hKI) {
                aVar.wQ(this.mStatus);
            }
        }
    }

    public boolean FS() {
        int status = getStatus();
        return status == 2 || status == 7;
    }

    public boolean bLj() {
        return this.mStatus == 6;
    }

    public int getProgress() {
        return this.mProgress;
    }

    public void a(a aVar) {
        if (this.hKI == null) {
            this.hKI = new ArrayList();
        }
        this.hKI.add(aVar);
    }
}
