package com.baidu.yuyinala.mode;

import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tieba.pb.interactionpopupwindow.IBaseDialogData;
import java.util.List;
/* loaded from: classes4.dex */
public class AlaAudioModeDialogData implements IBaseDialogData {
    private List<com.baidu.yuyinala.mode.b.a> mModeList;

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.IBaseDialogData
    public int getType() {
        return 0;
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.IBaseDialogData
    public int getFrom() {
        return 0;
    }

    public List<com.baidu.yuyinala.mode.b.a> getModeList() {
        return this.mModeList;
    }

    public void setModeList(List<com.baidu.yuyinala.mode.b.a> list) {
        this.mModeList = list;
    }

    public com.baidu.yuyinala.mode.b.a getChosenMode() {
        if (ListUtils.isEmpty(this.mModeList)) {
            return null;
        }
        for (com.baidu.yuyinala.mode.b.a aVar : this.mModeList) {
            if (aVar != null && aVar.eey()) {
                return aVar;
            }
        }
        return null;
    }
}
