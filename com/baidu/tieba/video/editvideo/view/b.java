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
/* loaded from: classes22.dex */
public class b implements com.baidu.tieba.c.b, com.baidu.tieba.video.editvideo.b, b.a {
    private SelectMusicModel mFk;
    private com.baidu.tieba.video.editvideo.b.a mFm;
    private BaseActivity mHP;
    private com.baidu.tieba.video.b mHQ;
    private String mHR;

    public b(com.baidu.tieba.video.b bVar) {
        this.mHQ = bVar;
        this.mHP = this.mHQ.activity;
    }

    @Override // com.baidu.tieba.c.b
    public void start() {
        dGn();
    }

    @Override // com.baidu.tieba.c.b
    public void cancel() {
        if (this.mHQ != null) {
            this.mHQ.wJ(true);
        }
        if (this.mFm != null && this.mFm.dFA()) {
            this.mFm.dFB();
        }
    }

    public void dGn() {
        if (this.mHQ != null) {
            if (this.mHQ.isCancel()) {
                this.mHQ.onCancel();
                this.mHQ = null;
            } else if (!StringUtils.isNull(this.mHQ.musicPath) || this.mHQ.isMute) {
                if (this.mFk == null) {
                    this.mFk = new SelectMusicModel(this.mHP.getPageContext(), this);
                }
                this.mFk.i(this.mHQ.originPath, this.mHQ.musicPath, com.baidu.tieba.video.c.mDD + "video_" + System.currentTimeMillis() + ".mp4", !this.mHQ.isMute);
            } else {
                s(this.mHQ.originPath, -4399, "");
            }
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void setMusicData(List<MusicData> list) {
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void s(String str, int i, String str2) {
        if (this.mHQ != null && this.mHQ.isCancel()) {
            this.mHQ.onCancel();
            this.mHQ = null;
        } else if (TextUtils.isEmpty(str)) {
            this.mHP.showToast(R.string.mixing_fail);
            if (this.mHQ != null) {
                this.mHQ.bG(i, str2);
            }
        } else {
            if (this.mHQ != null) {
                this.mHQ.dEQ();
            }
            if (!StringUtils.isNull(this.mHQ.filterName)) {
                if (!at.equals(str, this.mHQ.originPath)) {
                    this.mHQ.mDA = str;
                }
                if (this.mFm == null) {
                    this.mFm = new com.baidu.tieba.video.editvideo.b.a(this.mHP.getActivity());
                    this.mFm.a(this);
                }
                this.mFm.gl(str, this.mHQ.filterName);
                return;
            }
            if (this.mHQ != null) {
                this.mHQ.dER();
            }
            Sp(str);
        }
    }

    private void Sp(String str) {
        if (this.mHQ != null) {
            if (this.mHQ.isCancel()) {
                this.mHQ.onCancel();
                this.mHQ = null;
                return;
            }
            this.mHR = str;
            VideoInfo videoInfo = new VideoInfo();
            videoInfo.setVideoPath(this.mHR);
            videoInfo.setThumbPath(this.mHQ.coverPath);
            if (this.mHQ != null) {
                this.mHQ.a(videoInfo);
            }
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void Sh(String str) {
        if (this.mHQ != null) {
            this.mHQ.dER();
        }
        Sp(str);
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void bI(int i, String str) {
        if (this.mHQ != null) {
            this.mHQ.bH(i, str);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void bJ(int i, String str) {
        if (this.mHQ != null) {
            this.mHQ.bH(i, str);
        }
    }
}
