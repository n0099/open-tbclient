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
    private SelectMusicModel nGL;
    private com.baidu.tieba.video.editvideo.b.a nGN;
    private BaseActivity nJl;
    private com.baidu.tieba.video.b nJm;
    private String nJn;

    public b(com.baidu.tieba.video.b bVar) {
        this.nJm = bVar;
        this.nJl = this.nJm.activity;
    }

    @Override // com.baidu.tieba.c.b
    public void start() {
        dUU();
    }

    @Override // com.baidu.tieba.c.b
    public void cancel() {
        if (this.nJm != null) {
            this.nJm.yF(true);
        }
        if (this.nGN != null && this.nGN.dUg()) {
            this.nGN.dUh();
        }
    }

    public void dUU() {
        if (this.nJm != null) {
            if (this.nJm.isCancel()) {
                this.nJm.onCancel();
                this.nJm = null;
            } else if (!StringUtils.isNull(this.nJm.musicPath) || this.nJm.isMute) {
                if (this.nGL == null) {
                    this.nGL = new SelectMusicModel(this.nJl.getPageContext(), this);
                }
                this.nGL.k(this.nJm.originPath, this.nJm.musicPath, com.baidu.tieba.video.c.nFg + "video_" + System.currentTimeMillis() + ".mp4", !this.nJm.isMute);
            } else {
                u(this.nJm.originPath, -4399, "");
            }
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void setMusicData(List<MusicData> list) {
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void u(String str, int i, String str2) {
        if (this.nJm != null && this.nJm.isCancel()) {
            this.nJm.onCancel();
            this.nJm = null;
        } else if (TextUtils.isEmpty(str)) {
            this.nJl.showToast(R.string.mixing_fail);
            if (this.nJm != null) {
                this.nJm.bT(i, str2);
            }
        } else {
            if (this.nJm != null) {
                this.nJm.dTw();
            }
            if (!StringUtils.isNull(this.nJm.filterName)) {
                if (!at.equals(str, this.nJm.originPath)) {
                    this.nJm.nFd = str;
                }
                if (this.nGN == null) {
                    this.nGN = new com.baidu.tieba.video.editvideo.b.a(this.nJl.getActivity());
                    this.nGN.a(this);
                }
                this.nGN.gz(str, this.nJm.filterName);
                return;
            }
            if (this.nJm != null) {
                this.nJm.dTx();
            }
            Uz(str);
        }
    }

    private void Uz(String str) {
        if (this.nJm != null) {
            if (this.nJm.isCancel()) {
                this.nJm.onCancel();
                this.nJm = null;
                return;
            }
            this.nJn = str;
            VideoInfo videoInfo = new VideoInfo();
            videoInfo.setVideoPath(this.nJn);
            videoInfo.setThumbPath(this.nJm.coverPath);
            if (this.nJm != null) {
                this.nJm.a(videoInfo);
            }
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void Ur(String str) {
        if (this.nJm != null) {
            this.nJm.dTx();
        }
        Uz(str);
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void bV(int i, String str) {
        if (this.nJm != null) {
            this.nJm.bU(i, str);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void bW(int i, String str) {
        if (this.nJm != null) {
            this.nJm.bU(i, str);
        }
    }
}
