package com.baidu.tieba.video.editvideo.view;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.video.editvideo.b.b;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.editvideo.model.SelectMusicModel;
import java.util.List;
/* loaded from: classes17.dex */
public class b implements com.baidu.tieba.c.b, com.baidu.tieba.video.editvideo.b, b.a {
    private com.baidu.tieba.video.editvideo.b.a mvA;
    private SelectMusicModel mvy;
    private BaseActivity myd;
    private com.baidu.tieba.video.b mye;
    private String myf;

    public b(com.baidu.tieba.video.b bVar) {
        this.mye = bVar;
        this.myd = this.mye.activity;
    }

    @Override // com.baidu.tieba.c.b
    public void start() {
        dCt();
    }

    @Override // com.baidu.tieba.c.b
    public void cancel() {
        if (this.mye != null) {
            this.mye.wA(true);
        }
        if (this.mvA != null && this.mvA.dBG()) {
            this.mvA.dBH();
        }
    }

    public void dCt() {
        if (this.mye != null) {
            if (this.mye.isCancel()) {
                this.mye.onCancel();
                this.mye = null;
            } else if (!StringUtils.isNull(this.mye.musicPath) || this.mye.isMute) {
                if (this.mvy == null) {
                    this.mvy = new SelectMusicModel(this.myd.getPageContext(), this);
                }
                this.mvy.h(this.mye.originPath, this.mye.musicPath, com.baidu.tieba.video.c.mtS + "video_" + System.currentTimeMillis() + ".mp4", !this.mye.isMute);
            } else {
                s(this.mye.originPath, -4399, "");
            }
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void setMusicData(List<MusicData> list) {
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void s(String str, int i, String str2) {
        if (this.mye != null && this.mye.isCancel()) {
            this.mye.onCancel();
            this.mye = null;
        } else if (TextUtils.isEmpty(str)) {
            this.myd.showToast(R.string.mixing_fail);
            if (this.mye != null) {
                this.mye.bC(i, str2);
            }
        } else {
            if (this.mye != null) {
                this.mye.dAW();
            }
            if (!StringUtils.isNull(this.mye.filterName)) {
                if (!at.equals(str, this.mye.originPath)) {
                    this.mye.mtP = str;
                }
                if (this.mvA == null) {
                    this.mvA = new com.baidu.tieba.video.editvideo.b.a(this.myd.getActivity());
                    this.mvA.a(this);
                }
                this.mvA.fZ(str, this.mye.filterName);
                return;
            }
            if (this.mye != null) {
                this.mye.dAX();
            }
            RP(str);
        }
    }

    private void RP(String str) {
        if (this.mye != null) {
            if (this.mye.isCancel()) {
                this.mye.onCancel();
                this.mye = null;
                return;
            }
            this.myf = str;
            VideoInfo videoInfo = new VideoInfo();
            videoInfo.setVideoPath(this.myf);
            videoInfo.setThumbPath(this.mye.coverPath);
            if (this.mye != null) {
                this.mye.a(videoInfo);
            }
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void RH(String str) {
        if (this.mye != null) {
            this.mye.dAX();
        }
        RP(str);
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void bE(int i, String str) {
        if (this.mye != null) {
            this.mye.bD(i, str);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void bF(int i, String str) {
        if (this.mye != null) {
            this.mye.bD(i, str);
        }
    }
}
