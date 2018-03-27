package com.baidu.tieba.videoplay;

import com.baidu.adp.base.BdBaseModel;
/* loaded from: classes2.dex */
public class VideoPlayModel extends BdBaseModel {
    private VideoPlayActivity hzF;

    public VideoPlayModel(VideoPlayActivity videoPlayActivity) {
        super(videoPlayActivity.getPageContext());
        this.hzF = videoPlayActivity;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }
}
