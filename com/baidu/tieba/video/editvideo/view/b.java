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
/* loaded from: classes22.dex */
public class b implements com.baidu.tieba.d.b, com.baidu.tieba.video.editvideo.b, b.a {
    private SelectMusicModel noC;
    private com.baidu.tieba.video.editvideo.b.a noE;
    private BaseActivity nre;
    private com.baidu.tieba.video.b nrf;
    private String nrg;

    public b(com.baidu.tieba.video.b bVar) {
        this.nrf = bVar;
        this.nre = this.nrf.activity;
    }

    @Override // com.baidu.tieba.d.b
    public void start() {
        dPI();
    }

    @Override // com.baidu.tieba.d.b
    public void cancel() {
        if (this.nrf != null) {
            this.nrf.xX(true);
        }
        if (this.noE != null && this.noE.dOV()) {
            this.noE.dOW();
        }
    }

    public void dPI() {
        if (this.nrf != null) {
            if (this.nrf.isCancel()) {
                this.nrf.onCancel();
                this.nrf = null;
            } else if (!StringUtils.isNull(this.nrf.musicPath) || this.nrf.isMute) {
                if (this.noC == null) {
                    this.noC = new SelectMusicModel(this.nre.getPageContext(), this);
                }
                this.noC.i(this.nrf.originPath, this.nrf.musicPath, com.baidu.tieba.video.c.nmU + "video_" + System.currentTimeMillis() + ".mp4", !this.nrf.isMute);
            } else {
                v(this.nrf.originPath, -4399, "");
            }
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void setMusicData(List<MusicData> list) {
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void v(String str, int i, String str2) {
        if (this.nrf != null && this.nrf.isCancel()) {
            this.nrf.onCancel();
            this.nrf = null;
        } else if (TextUtils.isEmpty(str)) {
            this.nre.showToast(R.string.mixing_fail);
            if (this.nrf != null) {
                this.nrf.bT(i, str2);
            }
        } else {
            if (this.nrf != null) {
                this.nrf.dOl();
            }
            if (!StringUtils.isNull(this.nrf.filterName)) {
                if (!au.equals(str, this.nrf.originPath)) {
                    this.nrf.nmR = str;
                }
                if (this.noE == null) {
                    this.noE = new com.baidu.tieba.video.editvideo.b.a(this.nre.getActivity());
                    this.noE.a(this);
                }
                this.noE.gx(str, this.nrf.filterName);
                return;
            }
            if (this.nrf != null) {
                this.nrf.dOm();
            }
            TE(str);
        }
    }

    private void TE(String str) {
        if (this.nrf != null) {
            if (this.nrf.isCancel()) {
                this.nrf.onCancel();
                this.nrf = null;
                return;
            }
            this.nrg = str;
            VideoInfo videoInfo = new VideoInfo();
            videoInfo.setVideoPath(this.nrg);
            videoInfo.setThumbPath(this.nrf.coverPath);
            if (this.nrf != null) {
                this.nrf.a(videoInfo);
            }
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void Tw(String str) {
        if (this.nrf != null) {
            this.nrf.dOm();
        }
        TE(str);
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void bV(int i, String str) {
        if (this.nrf != null) {
            this.nrf.bU(i, str);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void bW(int i, String str) {
        if (this.nrf != null) {
            this.nrf.bU(i, str);
        }
    }
}
