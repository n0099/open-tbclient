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
    private SelectMusicModel nCh;
    private com.baidu.tieba.video.editvideo.b.a nCj;
    private BaseActivity nEH;
    private com.baidu.tieba.video.b nEI;
    private String nEJ;

    public b(com.baidu.tieba.video.b bVar) {
        this.nEI = bVar;
        this.nEH = this.nEI.activity;
    }

    @Override // com.baidu.tieba.c.b
    public void start() {
        dRc();
    }

    @Override // com.baidu.tieba.c.b
    public void cancel() {
        if (this.nEI != null) {
            this.nEI.yB(true);
        }
        if (this.nCj != null && this.nCj.dQo()) {
            this.nCj.dQp();
        }
    }

    public void dRc() {
        if (this.nEI != null) {
            if (this.nEI.isCancel()) {
                this.nEI.onCancel();
                this.nEI = null;
            } else if (!StringUtils.isNull(this.nEI.musicPath) || this.nEI.isMute) {
                if (this.nCh == null) {
                    this.nCh = new SelectMusicModel(this.nEH.getPageContext(), this);
                }
                this.nCh.k(this.nEI.originPath, this.nEI.musicPath, com.baidu.tieba.video.c.nAC + "video_" + System.currentTimeMillis() + ".mp4", !this.nEI.isMute);
            } else {
                u(this.nEI.originPath, -4399, "");
            }
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void setMusicData(List<MusicData> list) {
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void u(String str, int i, String str2) {
        if (this.nEI != null && this.nEI.isCancel()) {
            this.nEI.onCancel();
            this.nEI = null;
        } else if (TextUtils.isEmpty(str)) {
            this.nEH.showToast(R.string.mixing_fail);
            if (this.nEI != null) {
                this.nEI.bU(i, str2);
            }
        } else {
            if (this.nEI != null) {
                this.nEI.dPE();
            }
            if (!StringUtils.isNull(this.nEI.filterName)) {
                if (!at.equals(str, this.nEI.originPath)) {
                    this.nEI.nAz = str;
                }
                if (this.nCj == null) {
                    this.nCj = new com.baidu.tieba.video.editvideo.b.a(this.nEH.getActivity());
                    this.nCj.a(this);
                }
                this.nCj.gy(str, this.nEI.filterName);
                return;
            }
            if (this.nEI != null) {
                this.nEI.dPF();
            }
            Ts(str);
        }
    }

    private void Ts(String str) {
        if (this.nEI != null) {
            if (this.nEI.isCancel()) {
                this.nEI.onCancel();
                this.nEI = null;
                return;
            }
            this.nEJ = str;
            VideoInfo videoInfo = new VideoInfo();
            videoInfo.setVideoPath(this.nEJ);
            videoInfo.setThumbPath(this.nEI.coverPath);
            if (this.nEI != null) {
                this.nEI.a(videoInfo);
            }
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void Tk(String str) {
        if (this.nEI != null) {
            this.nEI.dPF();
        }
        Ts(str);
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void bW(int i, String str) {
        if (this.nEI != null) {
            this.nEI.bV(i, str);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void bX(int i, String str) {
        if (this.nEI != null) {
            this.nEI.bV(i, str);
        }
    }
}
