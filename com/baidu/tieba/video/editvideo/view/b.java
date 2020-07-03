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
    private SelectMusicModel lWa;
    private com.baidu.tieba.video.editvideo.b.a lWc;
    private BaseActivity lYF;
    private com.baidu.tieba.video.b lYG;
    private String lYH;

    public b(com.baidu.tieba.video.b bVar) {
        this.lYG = bVar;
        this.lYF = this.lYG.activity;
    }

    @Override // com.baidu.tieba.c.b
    public void start() {
        dnB();
    }

    @Override // com.baidu.tieba.c.b
    public void cancel() {
        if (this.lYG != null) {
            this.lYG.vf(true);
        }
        if (this.lWc != null && this.lWc.dmN()) {
            this.lWc.dmO();
        }
    }

    public void dnB() {
        if (this.lYG != null) {
            if (this.lYG.isCancel()) {
                this.lYG.onCancel();
                this.lYG = null;
            } else if (!StringUtils.isNull(this.lYG.musicPath) || this.lYG.isMute) {
                if (this.lWa == null) {
                    this.lWa = new SelectMusicModel(this.lYF.getPageContext(), this);
                }
                this.lWa.h(this.lYG.originPath, this.lYG.musicPath, com.baidu.tieba.video.d.lUu + "video_" + System.currentTimeMillis() + ".mp4", !this.lYG.isMute);
            } else {
                t(this.lYG.originPath, -4399, "");
            }
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void setMusicData(List<MusicData> list) {
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void t(String str, int i, String str2) {
        if (this.lYG != null && this.lYG.isCancel()) {
            this.lYG.onCancel();
            this.lYG = null;
        } else if (TextUtils.isEmpty(str)) {
            this.lYF.showToast(R.string.mixing_fail);
            if (this.lYG != null) {
                this.lYG.bE(i, str2);
            }
        } else {
            if (this.lYG != null) {
                this.lYG.dmd();
            }
            if (!StringUtils.isNull(this.lYG.filterName)) {
                if (!ar.equals(str, this.lYG.originPath)) {
                    this.lYG.lUr = str;
                }
                if (this.lWc == null) {
                    this.lWc = new com.baidu.tieba.video.editvideo.b.a(this.lYF.getActivity());
                    this.lWc.a(this);
                }
                this.lWc.fF(str, this.lYG.filterName);
                return;
            }
            if (this.lYG != null) {
                this.lYG.dme();
            }
            Oi(str);
        }
    }

    private void Oi(String str) {
        if (this.lYG != null) {
            if (this.lYG.isCancel()) {
                this.lYG.onCancel();
                this.lYG = null;
                return;
            }
            this.lYH = str;
            VideoInfo videoInfo = new VideoInfo();
            videoInfo.setVideoPath(this.lYH);
            videoInfo.setThumbPath(this.lYG.coverPath);
            if (this.lYG != null) {
                this.lYG.a(videoInfo);
            }
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void Oa(String str) {
        if (this.lYG != null) {
            this.lYG.dme();
        }
        Oi(str);
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void bG(int i, String str) {
        if (this.lYG != null) {
            this.lYG.bF(i, str);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void bH(int i, String str) {
        if (this.lYG != null) {
            this.lYG.bF(i, str);
        }
    }
}
