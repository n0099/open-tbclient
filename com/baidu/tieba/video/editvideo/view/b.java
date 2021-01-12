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
/* loaded from: classes7.dex */
public class b implements com.baidu.tieba.c.b, com.baidu.tieba.video.editvideo.b, b.a {
    private SelectMusicModel nCg;
    private com.baidu.tieba.video.editvideo.b.a nCi;
    private BaseActivity nEG;
    private com.baidu.tieba.video.b nEH;
    private String nEI;

    public b(com.baidu.tieba.video.b bVar) {
        this.nEH = bVar;
        this.nEG = this.nEH.activity;
    }

    @Override // com.baidu.tieba.c.b
    public void start() {
        dRc();
    }

    @Override // com.baidu.tieba.c.b
    public void cancel() {
        if (this.nEH != null) {
            this.nEH.yB(true);
        }
        if (this.nCi != null && this.nCi.dQo()) {
            this.nCi.dQp();
        }
    }

    public void dRc() {
        if (this.nEH != null) {
            if (this.nEH.isCancel()) {
                this.nEH.onCancel();
                this.nEH = null;
            } else if (!StringUtils.isNull(this.nEH.musicPath) || this.nEH.isMute) {
                if (this.nCg == null) {
                    this.nCg = new SelectMusicModel(this.nEG.getPageContext(), this);
                }
                this.nCg.k(this.nEH.originPath, this.nEH.musicPath, com.baidu.tieba.video.c.nAB + "video_" + System.currentTimeMillis() + ".mp4", !this.nEH.isMute);
            } else {
                u(this.nEH.originPath, -4399, "");
            }
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void setMusicData(List<MusicData> list) {
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void u(String str, int i, String str2) {
        if (this.nEH != null && this.nEH.isCancel()) {
            this.nEH.onCancel();
            this.nEH = null;
        } else if (TextUtils.isEmpty(str)) {
            this.nEG.showToast(R.string.mixing_fail);
            if (this.nEH != null) {
                this.nEH.bU(i, str2);
            }
        } else {
            if (this.nEH != null) {
                this.nEH.dPE();
            }
            if (!StringUtils.isNull(this.nEH.filterName)) {
                if (!at.equals(str, this.nEH.originPath)) {
                    this.nEH.nAy = str;
                }
                if (this.nCi == null) {
                    this.nCi = new com.baidu.tieba.video.editvideo.b.a(this.nEG.getActivity());
                    this.nCi.a(this);
                }
                this.nCi.gy(str, this.nEH.filterName);
                return;
            }
            if (this.nEH != null) {
                this.nEH.dPF();
            }
            Tr(str);
        }
    }

    private void Tr(String str) {
        if (this.nEH != null) {
            if (this.nEH.isCancel()) {
                this.nEH.onCancel();
                this.nEH = null;
                return;
            }
            this.nEI = str;
            VideoInfo videoInfo = new VideoInfo();
            videoInfo.setVideoPath(this.nEI);
            videoInfo.setThumbPath(this.nEH.coverPath);
            if (this.nEH != null) {
                this.nEH.a(videoInfo);
            }
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void Tj(String str) {
        if (this.nEH != null) {
            this.nEH.dPF();
        }
        Tr(str);
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void bW(int i, String str) {
        if (this.nEH != null) {
            this.nEH.bV(i, str);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void bX(int i, String str) {
        if (this.nEH != null) {
            this.nEH.bV(i, str);
        }
    }
}
