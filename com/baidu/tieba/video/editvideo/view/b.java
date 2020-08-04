package com.baidu.tieba.video.editvideo.view;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.video.editvideo.b.b;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.editvideo.model.SelectMusicModel;
import java.util.List;
/* loaded from: classes17.dex */
public class b implements com.baidu.tieba.c.b, com.baidu.tieba.video.editvideo.b, b.a {
    private SelectMusicModel mdv;
    private com.baidu.tieba.video.editvideo.b.a mdx;
    private BaseActivity mgb;
    private com.baidu.tieba.video.b mgc;
    private String mgd;

    public b(com.baidu.tieba.video.b bVar) {
        this.mgc = bVar;
        this.mgb = this.mgc.activity;
    }

    @Override // com.baidu.tieba.c.b
    public void start() {
        dqP();
    }

    @Override // com.baidu.tieba.c.b
    public void cancel() {
        if (this.mgc != null) {
            this.mgc.vJ(true);
        }
        if (this.mdx != null && this.mdx.dqc()) {
            this.mdx.dqd();
        }
    }

    public void dqP() {
        if (this.mgc != null) {
            if (this.mgc.isCancel()) {
                this.mgc.onCancel();
                this.mgc = null;
            } else if (!StringUtils.isNull(this.mgc.musicPath) || this.mgc.isMute) {
                if (this.mdv == null) {
                    this.mdv = new SelectMusicModel(this.mgb.getPageContext(), this);
                }
                this.mdv.h(this.mgc.originPath, this.mgc.musicPath, com.baidu.tieba.video.c.mbP + "video_" + System.currentTimeMillis() + ".mp4", !this.mgc.isMute);
            } else {
                t(this.mgc.originPath, -4399, "");
            }
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void setMusicData(List<MusicData> list) {
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void t(String str, int i, String str2) {
        if (this.mgc != null && this.mgc.isCancel()) {
            this.mgc.onCancel();
            this.mgc = null;
        } else if (TextUtils.isEmpty(str)) {
            this.mgb.showToast(R.string.mixing_fail);
            if (this.mgc != null) {
                this.mgc.bF(i, str2);
            }
        } else {
            if (this.mgc != null) {
                this.mgc.dps();
            }
            if (!StringUtils.isNull(this.mgc.filterName)) {
                if (!as.equals(str, this.mgc.originPath)) {
                    this.mgc.mbM = str;
                }
                if (this.mdx == null) {
                    this.mdx = new com.baidu.tieba.video.editvideo.b.a(this.mgb.getActivity());
                    this.mdx.a(this);
                }
                this.mdx.fH(str, this.mgc.filterName);
                return;
            }
            if (this.mgc != null) {
                this.mgc.dpt();
            }
            OR(str);
        }
    }

    private void OR(String str) {
        if (this.mgc != null) {
            if (this.mgc.isCancel()) {
                this.mgc.onCancel();
                this.mgc = null;
                return;
            }
            this.mgd = str;
            VideoInfo videoInfo = new VideoInfo();
            videoInfo.setVideoPath(this.mgd);
            videoInfo.setThumbPath(this.mgc.coverPath);
            if (this.mgc != null) {
                this.mgc.a(videoInfo);
            }
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void OJ(String str) {
        if (this.mgc != null) {
            this.mgc.dpt();
        }
        OR(str);
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void bH(int i, String str) {
        if (this.mgc != null) {
            this.mgc.bG(i, str);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void bI(int i, String str) {
        if (this.mgc != null) {
            this.mgc.bG(i, str);
        }
    }
}
