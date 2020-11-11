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
/* loaded from: classes23.dex */
public class b implements com.baidu.tieba.c.b, com.baidu.tieba.video.editvideo.b, b.a {
    private SelectMusicModel nnt;
    private com.baidu.tieba.video.editvideo.b.a nnv;
    private BaseActivity npX;
    private com.baidu.tieba.video.b npY;
    private String npZ;

    public b(com.baidu.tieba.video.b bVar) {
        this.npY = bVar;
        this.npX = this.npY.activity;
    }

    @Override // com.baidu.tieba.c.b
    public void start() {
        dPJ();
    }

    @Override // com.baidu.tieba.c.b
    public void cancel() {
        if (this.npY != null) {
            this.npY.xQ(true);
        }
        if (this.nnv != null && this.nnv.dOW()) {
            this.nnv.dOX();
        }
    }

    public void dPJ() {
        if (this.npY != null) {
            if (this.npY.isCancel()) {
                this.npY.onCancel();
                this.npY = null;
            } else if (!StringUtils.isNull(this.npY.musicPath) || this.npY.isMute) {
                if (this.nnt == null) {
                    this.nnt = new SelectMusicModel(this.npX.getPageContext(), this);
                }
                this.nnt.i(this.npY.originPath, this.npY.musicPath, com.baidu.tieba.video.c.nlN + "video_" + System.currentTimeMillis() + ".mp4", !this.npY.isMute);
            } else {
                v(this.npY.originPath, -4399, "");
            }
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void setMusicData(List<MusicData> list) {
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void v(String str, int i, String str2) {
        if (this.npY != null && this.npY.isCancel()) {
            this.npY.onCancel();
            this.npY = null;
        } else if (TextUtils.isEmpty(str)) {
            this.npX.showToast(R.string.mixing_fail);
            if (this.npY != null) {
                this.npY.bV(i, str2);
            }
        } else {
            if (this.npY != null) {
                this.npY.dOm();
            }
            if (!StringUtils.isNull(this.npY.filterName)) {
                if (!at.equals(str, this.npY.originPath)) {
                    this.npY.nlK = str;
                }
                if (this.nnv == null) {
                    this.nnv = new com.baidu.tieba.video.editvideo.b.a(this.npX.getActivity());
                    this.nnv.a(this);
                }
                this.nnv.gx(str, this.npY.filterName);
                return;
            }
            if (this.npY != null) {
                this.npY.dOn();
            }
            TT(str);
        }
    }

    private void TT(String str) {
        if (this.npY != null) {
            if (this.npY.isCancel()) {
                this.npY.onCancel();
                this.npY = null;
                return;
            }
            this.npZ = str;
            VideoInfo videoInfo = new VideoInfo();
            videoInfo.setVideoPath(this.npZ);
            videoInfo.setThumbPath(this.npY.coverPath);
            if (this.npY != null) {
                this.npY.a(videoInfo);
            }
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void TL(String str) {
        if (this.npY != null) {
            this.npY.dOn();
        }
        TT(str);
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void bX(int i, String str) {
        if (this.npY != null) {
            this.npY.bW(i, str);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void bY(int i, String str) {
        if (this.npY != null) {
            this.npY.bW(i, str);
        }
    }
}
