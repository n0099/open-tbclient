package com.baidu.yuyinala.emoticon;

import com.baidu.live.tieba.pb.interactionpopupwindow.IBaseDialogData;
import java.util.List;
/* loaded from: classes11.dex */
public class AlaEmoticonListDialogData implements IBaseDialogData {
    private List<com.baidu.yuyinala.emoticon.a.a> emoticonList;
    private boolean isNetError;
    private int mSendIntervalTime;

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.IBaseDialogData
    public int getType() {
        return 0;
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.IBaseDialogData
    public int getFrom() {
        return 0;
    }

    public List<com.baidu.yuyinala.emoticon.a.a> getEmoticonList() {
        return this.emoticonList;
    }

    public void setEmoticonList(List<com.baidu.yuyinala.emoticon.a.a> list) {
        this.emoticonList = list;
    }

    public int getSendIntervalTime() {
        return this.mSendIntervalTime;
    }

    public void setSendIntervalTime(int i) {
        this.mSendIntervalTime = i;
    }

    public boolean isNetError() {
        return this.isNetError;
    }

    public void setNetError(boolean z) {
        this.isNetError = z;
    }
}
