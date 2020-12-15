package com.baidu.tieba.video;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import java.io.File;
/* loaded from: classes.dex */
public abstract class b {
    private boolean Nj;
    public BaseActivity activity;
    public String coverPath;
    public String filterName;
    public boolean isMute;
    public String musicPath;
    public String nAW;
    public String originPath;

    public abstract void dTE();

    public abstract void dTF();

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

    public void yC(boolean z) {
        this.Nj = z;
    }

    public boolean isCancel() {
        return this.Nj;
    }

    private void dTD() {
        if (!au.isEmpty(this.nAW)) {
            n.deleteFile(new File(this.nAW));
        }
    }

    public void onCancel() {
        dTD();
    }

    public void bT(int i, String str) {
        dTD();
    }

    public void bU(int i, String str) {
        dTD();
    }

    public void a(VideoInfo videoInfo) {
        dTD();
    }
}
