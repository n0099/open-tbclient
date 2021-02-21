package com.baidu.tieba.video;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.o;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import java.io.File;
/* loaded from: classes.dex */
public abstract class b {
    private boolean MD;
    public BaseActivity activity;
    public String coverPath;
    public String filterName;
    public boolean isMute;
    public String musicPath;
    public String nKJ;
    public String originPath;

    public abstract void dRX();

    public abstract void dRY();

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

    public void yU(boolean z) {
        this.MD = z;
    }

    public boolean isCancel() {
        return this.MD;
    }

    private void dRW() {
        if (!au.isEmpty(this.nKJ)) {
            o.deleteFile(new File(this.nKJ));
        }
    }

    public void onCancel() {
        dRW();
    }

    public void cb(int i, String str) {
        dRW();
    }

    public void cc(int i, String str) {
        dRW();
    }

    public void a(VideoInfo videoInfo) {
        dRW();
    }
}
