package com.baidu.tieba.video.editvideo.view;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.video.editvideo.b.b;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.editvideo.model.SelectMusicModel;
import java.util.List;
/* loaded from: classes17.dex */
public class b implements com.baidu.tieba.c.b, com.baidu.tieba.video.editvideo.b, b.a {
    private SelectMusicModel mdt;
    private com.baidu.tieba.video.editvideo.b.a mdv;
    private BaseActivity mfZ;
    private com.baidu.tieba.video.b mga;
    private String mgb;

    public b(com.baidu.tieba.video.b bVar) {
        this.mga = bVar;
        this.mfZ = this.mga.activity;
    }

    @Override // com.baidu.tieba.c.b
    public void start() {
        dqO();
    }

    @Override // com.baidu.tieba.c.b
    public void cancel() {
        if (this.mga != null) {
            this.mga.vJ(true);
        }
        if (this.mdv != null && this.mdv.dqb()) {
            this.mdv.dqc();
        }
    }

    public void dqO() {
        if (this.mga != null) {
            if (this.mga.isCancel()) {
                this.mga.onCancel();
                this.mga = null;
            } else if (!StringUtils.isNull(this.mga.musicPath) || this.mga.isMute) {
                if (this.mdt == null) {
                    this.mdt = new SelectMusicModel(this.mfZ.getPageContext(), this);
                }
                this.mdt.h(this.mga.originPath, this.mga.musicPath, com.baidu.tieba.video.c.mbN + "video_" + System.currentTimeMillis() + ".mp4", !this.mga.isMute);
            } else {
                t(this.mga.originPath, -4399, "");
            }
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void setMusicData(List<MusicData> list) {
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void t(String str, int i, String str2) {
        if (this.mga != null && this.mga.isCancel()) {
            this.mga.onCancel();
            this.mga = null;
        } else if (TextUtils.isEmpty(str)) {
            this.mfZ.showToast(R.string.mixing_fail);
            if (this.mga != null) {
                this.mga.bF(i, str2);
            }
        } else {
            if (this.mga != null) {
                this.mga.dpr();
            }
            if (!StringUtils.isNull(this.mga.filterName)) {
                if (!as.equals(str, this.mga.originPath)) {
                    this.mga.mbK = str;
                }
                if (this.mdv == null) {
                    this.mdv = new com.baidu.tieba.video.editvideo.b.a(this.mfZ.getActivity());
                    this.mdv.a(this);
                }
                this.mdv.fH(str, this.mga.filterName);
                return;
            }
            if (this.mga != null) {
                this.mga.dps();
            }
            OR(str);
        }
    }

    private void OR(String str) {
        if (this.mga != null) {
            if (this.mga.isCancel()) {
                this.mga.onCancel();
                this.mga = null;
                return;
            }
            this.mgb = str;
            VideoInfo videoInfo = new VideoInfo();
            videoInfo.setVideoPath(this.mgb);
            videoInfo.setThumbPath(this.mga.coverPath);
            if (this.mga != null) {
                this.mga.a(videoInfo);
            }
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void OJ(String str) {
        if (this.mga != null) {
            this.mga.dps();
        }
        OR(str);
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void bH(int i, String str) {
        if (this.mga != null) {
            this.mga.bG(i, str);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void bI(int i, String str) {
        if (this.mga != null) {
            this.mga.bG(i, str);
        }
    }
}
