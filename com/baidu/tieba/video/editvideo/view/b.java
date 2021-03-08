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
/* loaded from: classes7.dex */
public class b implements com.baidu.tieba.c.b, com.baidu.tieba.video.editvideo.b, b.a {
    private SelectMusicModel nOw;
    private com.baidu.tieba.video.editvideo.b.a nOy;
    private BaseActivity nQW;
    private com.baidu.tieba.video.b nQX;
    private String nQY;

    public b(com.baidu.tieba.video.b bVar) {
        this.nQX = bVar;
        this.nQW = this.nQX.activity;
    }

    @Override // com.baidu.tieba.c.b
    public void start() {
        dTD();
    }

    @Override // com.baidu.tieba.c.b
    public void cancel() {
        if (this.nQX != null) {
            this.nQX.yT(true);
        }
        if (this.nOy != null && this.nOy.dSP()) {
            this.nOy.dSQ();
        }
    }

    public void dTD() {
        if (this.nQX != null) {
            if (this.nQX.isCancel()) {
                this.nQX.onCancel();
                this.nQX = null;
            } else if (!StringUtils.isNull(this.nQX.musicPath) || this.nQX.isMute) {
                if (this.nOw == null) {
                    this.nOw = new SelectMusicModel(this.nQW.getPageContext(), this);
                }
                this.nOw.k(this.nQX.originPath, this.nQX.musicPath, com.baidu.tieba.video.c.nMR + "video_" + System.currentTimeMillis() + ".mp4", !this.nQX.isMute);
            } else {
                v(this.nQX.originPath, -4399, "");
            }
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void setMusicData(List<MusicData> list) {
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void v(String str, int i, String str2) {
        if (this.nQX != null && this.nQX.isCancel()) {
            this.nQX.onCancel();
            this.nQX = null;
        } else if (TextUtils.isEmpty(str)) {
            this.nQW.showToast(R.string.mixing_fail);
            if (this.nQX != null) {
                this.nQX.cb(i, str2);
            }
        } else {
            if (this.nQX != null) {
                this.nQX.dSf();
            }
            if (!StringUtils.isNull(this.nQX.filterName)) {
                if (!au.equals(str, this.nQX.originPath)) {
                    this.nQX.nMO = str;
                }
                if (this.nOy == null) {
                    this.nOy = new com.baidu.tieba.video.editvideo.b.a(this.nQW.getActivity());
                    this.nOy.a(this);
                }
                this.nOy.gG(str, this.nQX.filterName);
                return;
            }
            if (this.nQX != null) {
                this.nQX.dSg();
            }
            UI(str);
        }
    }

    private void UI(String str) {
        if (this.nQX != null) {
            if (this.nQX.isCancel()) {
                this.nQX.onCancel();
                this.nQX = null;
                return;
            }
            this.nQY = str;
            VideoInfo videoInfo = new VideoInfo();
            videoInfo.setVideoPath(this.nQY);
            videoInfo.setThumbPath(this.nQX.coverPath);
            if (this.nQX != null) {
                this.nQX.a(videoInfo);
            }
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void UA(String str) {
        if (this.nQX != null) {
            this.nQX.dSg();
        }
        UI(str);
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void cd(int i, String str) {
        if (this.nQX != null) {
            this.nQX.cc(i, str);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void ce(int i, String str) {
        if (this.nQX != null) {
            this.nQX.cc(i, str);
        }
    }
}
