package com.baidu.tieba.video;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import java.io.File;
/* loaded from: classes.dex */
public abstract class b {
    private boolean LJ;
    public BaseActivity activity;
    public String coverPath;
    public String filterName;
    public boolean isMute;
    public String mtP;
    public String musicPath;
    public String originPath;

    public abstract void dAW();

    public abstract void dAX();

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

    public void wA(boolean z) {
        this.LJ = z;
    }

    public boolean isCancel() {
        return this.LJ;
    }

    private void dAV() {
        if (!at.isEmpty(this.mtP)) {
            n.deleteFile(new File(this.mtP));
        }
    }

    public void onCancel() {
        dAV();
    }

    public void bC(int i, String str) {
        dAV();
    }

    public void bD(int i, String str) {
        dAV();
    }

    public void a(VideoInfo videoInfo) {
        dAV();
    }
}
