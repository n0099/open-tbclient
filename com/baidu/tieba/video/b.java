package com.baidu.tieba.video;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import java.io.File;
/* loaded from: classes.dex */
public abstract class b {
    private boolean Mn;
    public BaseActivity activity;
    public String coverPath;
    public String filterName;
    public boolean isMute;
    public String mTm;
    public String musicPath;
    public String originPath;

    public abstract void dIC();

    public abstract void dID();

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

    public void xq(boolean z) {
        this.Mn = z;
    }

    public boolean isCancel() {
        return this.Mn;
    }

    private void dIB() {
        if (!at.isEmpty(this.mTm)) {
            n.deleteFile(new File(this.mTm));
        }
    }

    public void onCancel() {
        dIB();
    }

    public void bQ(int i, String str) {
        dIB();
    }

    public void bR(int i, String str) {
        dIB();
    }

    public void a(VideoInfo videoInfo) {
        dIB();
    }
}
