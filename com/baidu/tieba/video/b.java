package com.baidu.tieba.video;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import java.io.File;
/* loaded from: classes2.dex */
public abstract class b {
    private boolean LJ;
    public BaseActivity activity;
    public String coverPath;
    public String filterName;
    public boolean isMute;
    public String mtx;
    public String musicPath;
    public String originPath;

    public abstract void dAN();

    public abstract void dAO();

    public b(BaseActivity baseActivity, String str, String str2) {
        this.originPath = str;
        this.coverPath = str2;
        this.activity = baseActivity;
    }

    public b(BaseActivity baseActivity, EditVideoData editVideoData) {
        if (editVideoData != null) {
            this.originPath = editVideoData.originPath;
            this.coverPath = editVideoData.coverPath;
            this.musicPath = editVideoData.musicPath;
            this.isMute = editVideoData.isMute;
            this.filterName = editVideoData.filterName;
        }
        this.activity = baseActivity;
    }

    public void a(EditVideoData editVideoData) {
        if (editVideoData != null) {
            this.originPath = editVideoData.originPath;
            this.coverPath = editVideoData.coverPath;
            this.musicPath = editVideoData.musicPath;
            this.isMute = editVideoData.isMute;
            this.filterName = editVideoData.filterName;
        }
    }

    public void wy(boolean z) {
        this.LJ = z;
    }

    public boolean isCancel() {
        return this.LJ;
    }

    private void dAM() {
        if (!at.isEmpty(this.mtx)) {
            n.deleteFile(new File(this.mtx));
        }
    }

    public void onCancel() {
        dAM();
    }

    public void bD(int i, String str) {
        dAM();
    }

    public void bE(int i, String str) {
        dAM();
    }

    public void a(VideoInfo videoInfo) {
        dAM();
    }
}
