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
    private SelectMusicModel nhx;
    private com.baidu.tieba.video.editvideo.b.a nhz;
    private BaseActivity nka;
    private com.baidu.tieba.video.b nkb;
    private String nkc;

    public b(com.baidu.tieba.video.b bVar) {
        this.nkb = bVar;
        this.nka = this.nkb.activity;
    }

    @Override // com.baidu.tieba.c.b
    public void start() {
        dNh();
    }

    @Override // com.baidu.tieba.c.b
    public void cancel() {
        if (this.nkb != null) {
            this.nkb.xH(true);
        }
        if (this.nhz != null && this.nhz.dMu()) {
            this.nhz.dMv();
        }
    }

    public void dNh() {
        if (this.nkb != null) {
            if (this.nkb.isCancel()) {
                this.nkb.onCancel();
                this.nkb = null;
            } else if (!StringUtils.isNull(this.nkb.musicPath) || this.nkb.isMute) {
                if (this.nhx == null) {
                    this.nhx = new SelectMusicModel(this.nka.getPageContext(), this);
                }
                this.nhx.i(this.nkb.originPath, this.nkb.musicPath, com.baidu.tieba.video.c.nfR + "video_" + System.currentTimeMillis() + ".mp4", !this.nkb.isMute);
            } else {
                u(this.nkb.originPath, -4399, "");
            }
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void setMusicData(List<MusicData> list) {
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void u(String str, int i, String str2) {
        if (this.nkb != null && this.nkb.isCancel()) {
            this.nkb.onCancel();
            this.nkb = null;
        } else if (TextUtils.isEmpty(str)) {
            this.nka.showToast(R.string.mixing_fail);
            if (this.nkb != null) {
                this.nkb.bR(i, str2);
            }
        } else {
            if (this.nkb != null) {
                this.nkb.dLK();
            }
            if (!StringUtils.isNull(this.nkb.filterName)) {
                if (!at.equals(str, this.nkb.originPath)) {
                    this.nkb.nfO = str;
                }
                if (this.nhz == null) {
                    this.nhz = new com.baidu.tieba.video.editvideo.b.a(this.nka.getActivity());
                    this.nhz.a(this);
                }
                this.nhz.gx(str, this.nkb.filterName);
                return;
            }
            if (this.nkb != null) {
                this.nkb.dLL();
            }
            TC(str);
        }
    }

    private void TC(String str) {
        if (this.nkb != null) {
            if (this.nkb.isCancel()) {
                this.nkb.onCancel();
                this.nkb = null;
                return;
            }
            this.nkc = str;
            VideoInfo videoInfo = new VideoInfo();
            videoInfo.setVideoPath(this.nkc);
            videoInfo.setThumbPath(this.nkb.coverPath);
            if (this.nkb != null) {
                this.nkb.a(videoInfo);
            }
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void Tu(String str) {
        if (this.nkb != null) {
            this.nkb.dLL();
        }
        TC(str);
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void bT(int i, String str) {
        if (this.nkb != null) {
            this.nkb.bS(i, str);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void bU(int i, String str) {
        if (this.nkb != null) {
            this.nkb.bS(i, str);
        }
    }
}
