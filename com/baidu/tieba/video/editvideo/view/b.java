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
    private SelectMusicModel nMr;
    private com.baidu.tieba.video.editvideo.b.a nMt;
    private BaseActivity nOR;
    private com.baidu.tieba.video.b nOS;
    private String nOT;

    public b(com.baidu.tieba.video.b bVar) {
        this.nOS = bVar;
        this.nOR = this.nOS.activity;
    }

    @Override // com.baidu.tieba.c.b
    public void start() {
        dTv();
    }

    @Override // com.baidu.tieba.c.b
    public void cancel() {
        if (this.nOS != null) {
            this.nOS.yU(true);
        }
        if (this.nMt != null && this.nMt.dSH()) {
            this.nMt.dSI();
        }
    }

    public void dTv() {
        if (this.nOS != null) {
            if (this.nOS.isCancel()) {
                this.nOS.onCancel();
                this.nOS = null;
            } else if (!StringUtils.isNull(this.nOS.musicPath) || this.nOS.isMute) {
                if (this.nMr == null) {
                    this.nMr = new SelectMusicModel(this.nOR.getPageContext(), this);
                }
                this.nMr.k(this.nOS.originPath, this.nOS.musicPath, com.baidu.tieba.video.c.nKM + "video_" + System.currentTimeMillis() + ".mp4", !this.nOS.isMute);
            } else {
                u(this.nOS.originPath, -4399, "");
            }
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void setMusicData(List<MusicData> list) {
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void u(String str, int i, String str2) {
        if (this.nOS != null && this.nOS.isCancel()) {
            this.nOS.onCancel();
            this.nOS = null;
        } else if (TextUtils.isEmpty(str)) {
            this.nOR.showToast(R.string.mixing_fail);
            if (this.nOS != null) {
                this.nOS.cb(i, str2);
            }
        } else {
            if (this.nOS != null) {
                this.nOS.dRX();
            }
            if (!StringUtils.isNull(this.nOS.filterName)) {
                if (!au.equals(str, this.nOS.originPath)) {
                    this.nOS.nKJ = str;
                }
                if (this.nMt == null) {
                    this.nMt = new com.baidu.tieba.video.editvideo.b.a(this.nOR.getActivity());
                    this.nMt.a(this);
                }
                this.nMt.gG(str, this.nOS.filterName);
                return;
            }
            if (this.nOS != null) {
                this.nOS.dRY();
            }
            UB(str);
        }
    }

    private void UB(String str) {
        if (this.nOS != null) {
            if (this.nOS.isCancel()) {
                this.nOS.onCancel();
                this.nOS = null;
                return;
            }
            this.nOT = str;
            VideoInfo videoInfo = new VideoInfo();
            videoInfo.setVideoPath(this.nOT);
            videoInfo.setThumbPath(this.nOS.coverPath);
            if (this.nOS != null) {
                this.nOS.a(videoInfo);
            }
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void Ut(String str) {
        if (this.nOS != null) {
            this.nOS.dRY();
        }
        UB(str);
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void cd(int i, String str) {
        if (this.nOS != null) {
            this.nOS.cc(i, str);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void ce(int i, String str) {
        if (this.nOS != null) {
            this.nOS.cc(i, str);
        }
    }
}
