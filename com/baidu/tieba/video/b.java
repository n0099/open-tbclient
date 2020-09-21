package com.baidu.tieba.video;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import java.io.File;
/* loaded from: classes.dex */
public abstract class b {
    private boolean LX;
    public BaseActivity activity;
    public String coverPath;
    public String filterName;
    public boolean isMute;
    public String mDA;
    public String musicPath;
    public String originPath;

    public abstract void dEQ();

    public abstract void dER();

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

    public void wJ(boolean z) {
        this.LX = z;
    }

    public boolean isCancel() {
        return this.LX;
    }

    private void dEP() {
        if (!at.isEmpty(this.mDA)) {
            n.deleteFile(new File(this.mDA));
        }
    }

    public void onCancel() {
        dEP();
    }

    public void bG(int i, String str) {
        dEP();
    }

    public void bH(int i, String str) {
        dEP();
    }

    public void a(VideoInfo videoInfo) {
        dEP();
    }
}
