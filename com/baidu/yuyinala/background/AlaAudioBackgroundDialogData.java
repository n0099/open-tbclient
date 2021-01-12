package com.baidu.yuyinala.background;

import com.baidu.live.tieba.pb.interactionpopupwindow.IBaseDialogData;
import java.util.List;
/* loaded from: classes10.dex */
public class AlaAudioBackgroundDialogData implements IBaseDialogData {
    private List<com.baidu.yuyinala.background.b.a> mBgList;

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.IBaseDialogData
    public int getType() {
        return 0;
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.IBaseDialogData
    public int getFrom() {
        return 0;
    }

    public List<com.baidu.yuyinala.background.b.a> getBgList() {
        return this.mBgList;
    }

    public void setBgList(List<com.baidu.yuyinala.background.b.a> list) {
        this.mBgList = list;
    }
}
