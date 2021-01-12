package com.baidu.tieba.video;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import java.io.File;
/* loaded from: classes.dex */
public abstract class b {
    private boolean MF;
    public BaseActivity activity;
    public String coverPath;
    public String filterName;
    public boolean isMute;
    public String musicPath;
    public String nAy;
    public String originPath;

    public abstract void dPE();

    public abstract void dPF();

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

    public void yB(boolean z) {
        this.MF = z;
    }

    public boolean isCancel() {
        return this.MF;
    }

    private void dPD() {
        if (!at.isEmpty(this.nAy)) {
            n.deleteFile(new File(this.nAy));
        }
    }

    public void onCancel() {
        dPD();
    }

    public void bU(int i, String str) {
        dPD();
    }

    public void bV(int i, String str) {
        dPD();
    }

    public void a(VideoInfo videoInfo) {
        dPD();
    }
}
