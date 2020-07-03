package com.baidu.tieba.video;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import java.io.File;
/* loaded from: classes.dex */
public abstract class b {
    private boolean Le;
    public BaseActivity activity;
    public String coverPath;
    public String filterName;
    public boolean isMute;
    public String lUr;
    public String musicPath;
    public String originPath;

    public abstract void dmd();

    public abstract void dme();

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

    public void vf(boolean z) {
        this.Le = z;
    }

    public boolean isCancel() {
        return this.Le;
    }

    private void dmc() {
        if (!ar.isEmpty(this.lUr)) {
            n.deleteFile(new File(this.lUr));
        }
    }

    public void onCancel() {
        dmc();
    }

    public void bE(int i, String str) {
        dmc();
    }

    public void bF(int i, String str) {
        dmc();
    }

    public void a(VideoInfo videoInfo) {
        dmc();
    }
}
