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
/* loaded from: classes8.dex */
public class b implements com.baidu.tieba.c.b, com.baidu.tieba.video.editvideo.b, b.a {
    private SelectMusicModel nGM;
    private com.baidu.tieba.video.editvideo.b.a nGO;
    private BaseActivity nJm;
    private com.baidu.tieba.video.b nJn;
    private String nJo;

    public b(com.baidu.tieba.video.b bVar) {
        this.nJn = bVar;
        this.nJm = this.nJn.activity;
    }

    @Override // com.baidu.tieba.c.b
    public void start() {
        dUT();
    }

    @Override // com.baidu.tieba.c.b
    public void cancel() {
        if (this.nJn != null) {
            this.nJn.yF(true);
        }
        if (this.nGO != null && this.nGO.dUf()) {
            this.nGO.dUg();
        }
    }

    public void dUT() {
        if (this.nJn != null) {
            if (this.nJn.isCancel()) {
                this.nJn.onCancel();
                this.nJn = null;
            } else if (!StringUtils.isNull(this.nJn.musicPath) || this.nJn.isMute) {
                if (this.nGM == null) {
                    this.nGM = new SelectMusicModel(this.nJm.getPageContext(), this);
                }
                this.nGM.k(this.nJn.originPath, this.nJn.musicPath, com.baidu.tieba.video.c.nFh + "video_" + System.currentTimeMillis() + ".mp4", !this.nJn.isMute);
            } else {
                u(this.nJn.originPath, -4399, "");
            }
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void setMusicData(List<MusicData> list) {
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void u(String str, int i, String str2) {
        if (this.nJn != null && this.nJn.isCancel()) {
            this.nJn.onCancel();
            this.nJn = null;
        } else if (TextUtils.isEmpty(str)) {
            this.nJm.showToast(R.string.mixing_fail);
            if (this.nJn != null) {
                this.nJn.bT(i, str2);
            }
        } else {
            if (this.nJn != null) {
                this.nJn.dTv();
            }
            if (!StringUtils.isNull(this.nJn.filterName)) {
                if (!at.equals(str, this.nJn.originPath)) {
                    this.nJn.nFe = str;
                }
                if (this.nGO == null) {
                    this.nGO = new com.baidu.tieba.video.editvideo.b.a(this.nJm.getActivity());
                    this.nGO.a(this);
                }
                this.nGO.gz(str, this.nJn.filterName);
                return;
            }
            if (this.nJn != null) {
                this.nJn.dTw();
            }
            UA(str);
        }
    }

    private void UA(String str) {
        if (this.nJn != null) {
            if (this.nJn.isCancel()) {
                this.nJn.onCancel();
                this.nJn = null;
                return;
            }
            this.nJo = str;
            VideoInfo videoInfo = new VideoInfo();
            videoInfo.setVideoPath(this.nJo);
            videoInfo.setThumbPath(this.nJn.coverPath);
            if (this.nJn != null) {
                this.nJn.a(videoInfo);
            }
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void Us(String str) {
        if (this.nJn != null) {
            this.nJn.dTw();
        }
        UA(str);
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void bV(int i, String str) {
        if (this.nJn != null) {
            this.nJn.bU(i, str);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void bW(int i, String str) {
        if (this.nJn != null) {
            this.nJn.bU(i, str);
        }
    }
}
