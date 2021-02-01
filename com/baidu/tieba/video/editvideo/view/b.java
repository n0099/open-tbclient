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
/* loaded from: classes8.dex */
public class b implements com.baidu.tieba.c.b, com.baidu.tieba.video.editvideo.b, b.a {
    private SelectMusicModel nLR;
    private com.baidu.tieba.video.editvideo.b.a nLT;
    private BaseActivity nOr;
    private com.baidu.tieba.video.b nOs;
    private String nOt;

    public b(com.baidu.tieba.video.b bVar) {
        this.nOs = bVar;
        this.nOr = this.nOs.activity;
    }

    @Override // com.baidu.tieba.c.b
    public void start() {
        dTn();
    }

    @Override // com.baidu.tieba.c.b
    public void cancel() {
        if (this.nOs != null) {
            this.nOs.yU(true);
        }
        if (this.nLT != null && this.nLT.dSz()) {
            this.nLT.dSA();
        }
    }

    public void dTn() {
        if (this.nOs != null) {
            if (this.nOs.isCancel()) {
                this.nOs.onCancel();
                this.nOs = null;
            } else if (!StringUtils.isNull(this.nOs.musicPath) || this.nOs.isMute) {
                if (this.nLR == null) {
                    this.nLR = new SelectMusicModel(this.nOr.getPageContext(), this);
                }
                this.nLR.k(this.nOs.originPath, this.nOs.musicPath, com.baidu.tieba.video.c.nKm + "video_" + System.currentTimeMillis() + ".mp4", !this.nOs.isMute);
            } else {
                u(this.nOs.originPath, -4399, "");
            }
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void setMusicData(List<MusicData> list) {
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void u(String str, int i, String str2) {
        if (this.nOs != null && this.nOs.isCancel()) {
            this.nOs.onCancel();
            this.nOs = null;
        } else if (TextUtils.isEmpty(str)) {
            this.nOr.showToast(R.string.mixing_fail);
            if (this.nOs != null) {
                this.nOs.cb(i, str2);
            }
        } else {
            if (this.nOs != null) {
                this.nOs.dRP();
            }
            if (!StringUtils.isNull(this.nOs.filterName)) {
                if (!au.equals(str, this.nOs.originPath)) {
                    this.nOs.nKj = str;
                }
                if (this.nLT == null) {
                    this.nLT = new com.baidu.tieba.video.editvideo.b.a(this.nOr.getActivity());
                    this.nLT.a(this);
                }
                this.nLT.gE(str, this.nOs.filterName);
                return;
            }
            if (this.nOs != null) {
                this.nOs.dRQ();
            }
            Up(str);
        }
    }

    private void Up(String str) {
        if (this.nOs != null) {
            if (this.nOs.isCancel()) {
                this.nOs.onCancel();
                this.nOs = null;
                return;
            }
            this.nOt = str;
            VideoInfo videoInfo = new VideoInfo();
            videoInfo.setVideoPath(this.nOt);
            videoInfo.setThumbPath(this.nOs.coverPath);
            if (this.nOs != null) {
                this.nOs.a(videoInfo);
            }
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void Uh(String str) {
        if (this.nOs != null) {
            this.nOs.dRQ();
        }
        Up(str);
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void cd(int i, String str) {
        if (this.nOs != null) {
            this.nOs.cc(i, str);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void ce(int i, String str) {
        if (this.nOs != null) {
            this.nOs.cc(i, str);
        }
    }
}
