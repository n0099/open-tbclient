package com.baidu.tieba.video;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.as;
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
    public String mbM;
    public String musicPath;
    public String originPath;

    public abstract void dps();

    public abstract void dpt();

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

    public void vJ(boolean z) {
        this.Le = z;
    }

    public boolean isCancel() {
        return this.Le;
    }

    private void dpr() {
        if (!as.isEmpty(this.mbM)) {
            n.deleteFile(new File(this.mbM));
        }
    }

    public void onCancel() {
        dpr();
    }

    public void bF(int i, String str) {
        dpr();
    }

    public void bG(int i, String str) {
        dpr();
    }

    public void a(VideoInfo videoInfo) {
        dpr();
    }
}
