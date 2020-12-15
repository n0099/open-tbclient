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
    private SelectMusicModel nCF;
    private com.baidu.tieba.video.editvideo.b.a nCH;
    private BaseActivity nFh;
    private com.baidu.tieba.video.b nFi;
    private String nFj;

    public b(com.baidu.tieba.video.b bVar) {
        this.nFi = bVar;
        this.nFh = this.nFi.activity;
    }

    @Override // com.baidu.tieba.d.b
    public void start() {
        dVd();
    }

    @Override // com.baidu.tieba.d.b
    public void cancel() {
        if (this.nFi != null) {
            this.nFi.yC(true);
        }
        if (this.nCH != null && this.nCH.dUo()) {
            this.nCH.dUp();
        }
    }

    public void dVd() {
        if (this.nFi != null) {
            if (this.nFi.isCancel()) {
                this.nFi.onCancel();
                this.nFi = null;
            } else if (!StringUtils.isNull(this.nFi.musicPath) || this.nFi.isMute) {
                if (this.nCF == null) {
                    this.nCF = new SelectMusicModel(this.nFh.getPageContext(), this);
                }
                this.nCF.i(this.nFi.originPath, this.nFi.musicPath, com.baidu.tieba.video.c.nAZ + "video_" + System.currentTimeMillis() + ".mp4", !this.nFi.isMute);
            } else {
                v(this.nFi.originPath, -4399, "");
            }
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void setMusicData(List<MusicData> list) {
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void v(String str, int i, String str2) {
        if (this.nFi != null && this.nFi.isCancel()) {
            this.nFi.onCancel();
            this.nFi = null;
        } else if (TextUtils.isEmpty(str)) {
            this.nFh.showToast(R.string.mixing_fail);
            if (this.nFi != null) {
                this.nFi.bT(i, str2);
            }
        } else {
            if (this.nFi != null) {
                this.nFi.dTE();
            }
            if (!StringUtils.isNull(this.nFi.filterName)) {
                if (!au.equals(str, this.nFi.originPath)) {
                    this.nFi.nAW = str;
                }
                if (this.nCH == null) {
                    this.nCH = new com.baidu.tieba.video.editvideo.b.a(this.nFh.getActivity());
                    this.nCH.a(this);
                }
                this.nCH.gC(str, this.nFi.filterName);
                return;
            }
            if (this.nFi != null) {
                this.nFi.dTF();
            }
            UT(str);
        }
    }

    private void UT(String str) {
        if (this.nFi != null) {
            if (this.nFi.isCancel()) {
                this.nFi.onCancel();
                this.nFi = null;
                return;
            }
            this.nFj = str;
            VideoInfo videoInfo = new VideoInfo();
            videoInfo.setVideoPath(this.nFj);
            videoInfo.setThumbPath(this.nFi.coverPath);
            if (this.nFi != null) {
                this.nFi.a(videoInfo);
            }
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void UL(String str) {
        if (this.nFi != null) {
            this.nFi.dTF();
        }
        UT(str);
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void bV(int i, String str) {
        if (this.nFi != null) {
            this.nFi.bU(i, str);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void bW(int i, String str) {
        if (this.nFi != null) {
            this.nFi.bU(i, str);
        }
    }
}
