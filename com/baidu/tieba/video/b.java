package com.baidu.tieba.video;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import java.io.File;
/* loaded from: classes.dex */
public abstract class b {
    private boolean Mo;
    public BaseActivity activity;
    public String coverPath;
    public String filterName;
    public boolean isMute;
    public String musicPath;
    public String nfO;
    public String originPath;

    public abstract void dLK();

    public abstract void dLL();

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

    public void xH(boolean z) {
        this.Mo = z;
    }

    public boolean isCancel() {
        return this.Mo;
    }

    private void dLJ() {
        if (!at.isEmpty(this.nfO)) {
            n.deleteFile(new File(this.nfO));
        }
    }

    public void onCancel() {
        dLJ();
    }

    public void bR(int i, String str) {
        dLJ();
    }

    public void bS(int i, String str) {
        dLJ();
    }

    public void a(VideoInfo videoInfo) {
        dLJ();
    }
}
