package com.baidu.tieba.video.editvideo.view;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.video.editvideo.b.b;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.editvideo.model.SelectMusicModel;
import java.util.List;
/* loaded from: classes23.dex */
public class b implements com.baidu.tieba.d.b, com.baidu.tieba.video.editvideo.b, b.a {
    private SelectMusicModel nCD;
    private com.baidu.tieba.video.editvideo.b.a nCF;
    private BaseActivity nFf;
    private com.baidu.tieba.video.b nFg;
    private String nFh;

    public b(com.baidu.tieba.video.b bVar) {
        this.nFg = bVar;
        this.nFf = this.nFg.activity;
    }

    @Override // com.baidu.tieba.d.b
    public void start() {
        dVc();
    }

    @Override // com.baidu.tieba.d.b
    public void cancel() {
        if (this.nFg != null) {
            this.nFg.yC(true);
        }
        if (this.nCF != null && this.nCF.dUn()) {
            this.nCF.dUo();
        }
    }

    public void dVc() {
        if (this.nFg != null) {
            if (this.nFg.isCancel()) {
                this.nFg.onCancel();
                this.nFg = null;
            } else if (!StringUtils.isNull(this.nFg.musicPath) || this.nFg.isMute) {
                if (this.nCD == null) {
                    this.nCD = new SelectMusicModel(this.nFf.getPageContext(), this);
                }
                this.nCD.i(this.nFg.originPath, this.nFg.musicPath, com.baidu.tieba.video.c.nAX + "video_" + System.currentTimeMillis() + ".mp4", !this.nFg.isMute);
            } else {
                v(this.nFg.originPath, -4399, "");
            }
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void setMusicData(List<MusicData> list) {
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void v(String str, int i, String str2) {
        if (this.nFg != null && this.nFg.isCancel()) {
            this.nFg.onCancel();
            this.nFg = null;
        } else if (TextUtils.isEmpty(str)) {
            this.nFf.showToast(R.string.mixing_fail);
            if (this.nFg != null) {
                this.nFg.bT(i, str2);
            }
        } else {
            if (this.nFg != null) {
                this.nFg.dTD();
            }
            if (!StringUtils.isNull(this.nFg.filterName)) {
                if (!au.equals(str, this.nFg.originPath)) {
                    this.nFg.nAU = str;
                }
                if (this.nCF == null) {
                    this.nCF = new com.baidu.tieba.video.editvideo.b.a(this.nFf.getActivity());
                    this.nCF.a(this);
                }
                this.nCF.gC(str, this.nFg.filterName);
                return;
            }
            if (this.nFg != null) {
                this.nFg.dTE();
            }
            UT(str);
        }
    }

    private void UT(String str) {
        if (this.nFg != null) {
            if (this.nFg.isCancel()) {
                this.nFg.onCancel();
                this.nFg = null;
                return;
            }
            this.nFh = str;
            VideoInfo videoInfo = new VideoInfo();
            videoInfo.setVideoPath(this.nFh);
            videoInfo.setThumbPath(this.nFg.coverPath);
            if (this.nFg != null) {
                this.nFg.a(videoInfo);
            }
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void UL(String str) {
        if (this.nFg != null) {
            this.nFg.dTE();
        }
        UT(str);
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void bV(int i, String str) {
        if (this.nFg != null) {
            this.nFg.bU(i, str);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void bW(int i, String str) {
        if (this.nFg != null) {
            this.nFg.bU(i, str);
        }
    }
}
