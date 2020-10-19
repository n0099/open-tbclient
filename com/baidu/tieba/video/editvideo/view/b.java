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
/* loaded from: classes23.dex */
public class b implements com.baidu.tieba.c.b, com.baidu.tieba.video.editvideo.b, b.a {
    private SelectMusicModel mUX;
    private com.baidu.tieba.video.editvideo.b.a mUZ;
    private BaseActivity mXA;
    private com.baidu.tieba.video.b mXB;
    private String mXC;

    public b(com.baidu.tieba.video.b bVar) {
        this.mXB = bVar;
        this.mXA = this.mXB.activity;
    }

    @Override // com.baidu.tieba.c.b
    public void start() {
        dJZ();
    }

    @Override // com.baidu.tieba.c.b
    public void cancel() {
        if (this.mXB != null) {
            this.mXB.xq(true);
        }
        if (this.mUZ != null && this.mUZ.dJm()) {
            this.mUZ.dJn();
        }
    }

    public void dJZ() {
        if (this.mXB != null) {
            if (this.mXB.isCancel()) {
                this.mXB.onCancel();
                this.mXB = null;
            } else if (!StringUtils.isNull(this.mXB.musicPath) || this.mXB.isMute) {
                if (this.mUX == null) {
                    this.mUX = new SelectMusicModel(this.mXA.getPageContext(), this);
                }
                this.mUX.i(this.mXB.originPath, this.mXB.musicPath, com.baidu.tieba.video.c.mTq + "video_" + System.currentTimeMillis() + ".mp4", !this.mXB.isMute);
            } else {
                u(this.mXB.originPath, -4399, "");
            }
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void setMusicData(List<MusicData> list) {
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void u(String str, int i, String str2) {
        if (this.mXB != null && this.mXB.isCancel()) {
            this.mXB.onCancel();
            this.mXB = null;
        } else if (TextUtils.isEmpty(str)) {
            this.mXA.showToast(R.string.mixing_fail);
            if (this.mXB != null) {
                this.mXB.bQ(i, str2);
            }
        } else {
            if (this.mXB != null) {
                this.mXB.dIC();
            }
            if (!StringUtils.isNull(this.mXB.filterName)) {
                if (!at.equals(str, this.mXB.originPath)) {
                    this.mXB.mTm = str;
                }
                if (this.mUZ == null) {
                    this.mUZ = new com.baidu.tieba.video.editvideo.b.a(this.mXA.getActivity());
                    this.mUZ.a(this);
                }
                this.mUZ.gs(str, this.mXB.filterName);
                return;
            }
            if (this.mXB != null) {
                this.mXB.dID();
            }
            Td(str);
        }
    }

    private void Td(String str) {
        if (this.mXB != null) {
            if (this.mXB.isCancel()) {
                this.mXB.onCancel();
                this.mXB = null;
                return;
            }
            this.mXC = str;
            VideoInfo videoInfo = new VideoInfo();
            videoInfo.setVideoPath(this.mXC);
            videoInfo.setThumbPath(this.mXB.coverPath);
            if (this.mXB != null) {
                this.mXB.a(videoInfo);
            }
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void SV(String str) {
        if (this.mXB != null) {
            this.mXB.dID();
        }
        Td(str);
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void bS(int i, String str) {
        if (this.mXB != null) {
            this.mXB.bR(i, str);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void bT(int i, String str) {
        if (this.mXB != null) {
            this.mXB.bR(i, str);
        }
    }
}
