package com.baidu.tieba.video.editvideo.view;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.video.editvideo.b.b;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.editvideo.model.SelectMusicModel;
import java.util.List;
/* loaded from: classes10.dex */
public class b implements com.baidu.tieba.c.b, com.baidu.tieba.video.editvideo.b, b.a {
    private SelectMusicModel lWd;
    private com.baidu.tieba.video.editvideo.b.a lWf;
    private BaseActivity lYI;
    private com.baidu.tieba.video.b lYJ;
    private String lYK;

    public b(com.baidu.tieba.video.b bVar) {
        this.lYJ = bVar;
        this.lYI = this.lYJ.activity;
    }

    @Override // com.baidu.tieba.c.b
    public void start() {
        dnF();
    }

    @Override // com.baidu.tieba.c.b
    public void cancel() {
        if (this.lYJ != null) {
            this.lYJ.vf(true);
        }
        if (this.lWf != null && this.lWf.dmR()) {
            this.lWf.dmS();
        }
    }

    public void dnF() {
        if (this.lYJ != null) {
            if (this.lYJ.isCancel()) {
                this.lYJ.onCancel();
                this.lYJ = null;
            } else if (!StringUtils.isNull(this.lYJ.musicPath) || this.lYJ.isMute) {
                if (this.lWd == null) {
                    this.lWd = new SelectMusicModel(this.lYI.getPageContext(), this);
                }
                this.lWd.h(this.lYJ.originPath, this.lYJ.musicPath, com.baidu.tieba.video.d.lUx + "video_" + System.currentTimeMillis() + ".mp4", !this.lYJ.isMute);
            } else {
                t(this.lYJ.originPath, -4399, "");
            }
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void setMusicData(List<MusicData> list) {
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void t(String str, int i, String str2) {
        if (this.lYJ != null && this.lYJ.isCancel()) {
            this.lYJ.onCancel();
            this.lYJ = null;
        } else if (TextUtils.isEmpty(str)) {
            this.lYI.showToast(R.string.mixing_fail);
            if (this.lYJ != null) {
                this.lYJ.bE(i, str2);
            }
        } else {
            if (this.lYJ != null) {
                this.lYJ.dmh();
            }
            if (!StringUtils.isNull(this.lYJ.filterName)) {
                if (!ar.equals(str, this.lYJ.originPath)) {
                    this.lYJ.lUu = str;
                }
                if (this.lWf == null) {
                    this.lWf = new com.baidu.tieba.video.editvideo.b.a(this.lYI.getActivity());
                    this.lWf.a(this);
                }
                this.lWf.fF(str, this.lYJ.filterName);
                return;
            }
            if (this.lYJ != null) {
                this.lYJ.dmi();
            }
            Oj(str);
        }
    }

    private void Oj(String str) {
        if (this.lYJ != null) {
            if (this.lYJ.isCancel()) {
                this.lYJ.onCancel();
                this.lYJ = null;
                return;
            }
            this.lYK = str;
            VideoInfo videoInfo = new VideoInfo();
            videoInfo.setVideoPath(this.lYK);
            videoInfo.setThumbPath(this.lYJ.coverPath);
            if (this.lYJ != null) {
                this.lYJ.a(videoInfo);
            }
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void Ob(String str) {
        if (this.lYJ != null) {
            this.lYJ.dmi();
        }
        Oj(str);
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void bG(int i, String str) {
        if (this.lYJ != null) {
            this.lYJ.bF(i, str);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void bH(int i, String str) {
        if (this.lYJ != null) {
            this.lYJ.bF(i, str);
        }
    }
}
