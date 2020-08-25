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
    private SelectMusicModel mvg;
    private com.baidu.tieba.video.editvideo.b.a mvi;
    private BaseActivity mxL;
    private com.baidu.tieba.video.b mxM;
    private String mxN;

    public b(com.baidu.tieba.video.b bVar) {
        this.mxM = bVar;
        this.mxL = this.mxM.activity;
    }

    @Override // com.baidu.tieba.c.b
    public void start() {
        dCk();
    }

    @Override // com.baidu.tieba.c.b
    public void cancel() {
        if (this.mxM != null) {
            this.mxM.wy(true);
        }
        if (this.mvi != null && this.mvi.dBx()) {
            this.mvi.dBy();
        }
    }

    public void dCk() {
        if (this.mxM != null) {
            if (this.mxM.isCancel()) {
                this.mxM.onCancel();
                this.mxM = null;
            } else if (!StringUtils.isNull(this.mxM.musicPath) || this.mxM.isMute) {
                if (this.mvg == null) {
                    this.mvg = new SelectMusicModel(this.mxL.getPageContext(), this);
                }
                this.mvg.h(this.mxM.originPath, this.mxM.musicPath, com.baidu.tieba.video.c.mtA + "video_" + System.currentTimeMillis() + ".mp4", !this.mxM.isMute);
            } else {
                t(this.mxM.originPath, -4399, "");
            }
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void setMusicData(List<MusicData> list) {
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void t(String str, int i, String str2) {
        if (this.mxM != null && this.mxM.isCancel()) {
            this.mxM.onCancel();
            this.mxM = null;
        } else if (TextUtils.isEmpty(str)) {
            this.mxL.showToast(R.string.mixing_fail);
            if (this.mxM != null) {
                this.mxM.bD(i, str2);
            }
        } else {
            if (this.mxM != null) {
                this.mxM.dAN();
            }
            if (!StringUtils.isNull(this.mxM.filterName)) {
                if (!at.equals(str, this.mxM.originPath)) {
                    this.mxM.mtx = str;
                }
                if (this.mvi == null) {
                    this.mvi = new com.baidu.tieba.video.editvideo.b.a(this.mxL.getActivity());
                    this.mvi.a(this);
                }
                this.mvi.fY(str, this.mxM.filterName);
                return;
            }
            if (this.mxM != null) {
                this.mxM.dAO();
            }
            RP(str);
        }
    }

    private void RP(String str) {
        if (this.mxM != null) {
            if (this.mxM.isCancel()) {
                this.mxM.onCancel();
                this.mxM = null;
                return;
            }
            this.mxN = str;
            VideoInfo videoInfo = new VideoInfo();
            videoInfo.setVideoPath(this.mxN);
            videoInfo.setThumbPath(this.mxM.coverPath);
            if (this.mxM != null) {
                this.mxM.a(videoInfo);
            }
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void RH(String str) {
        if (this.mxM != null) {
            this.mxM.dAO();
        }
        RP(str);
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void bF(int i, String str) {
        if (this.mxM != null) {
            this.mxM.bE(i, str);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void bG(int i, String str) {
        if (this.mxM != null) {
            this.mxM.bE(i, str);
        }
    }
}
