package com.baidu.tieba.model;

import android.content.Context;
import com.baidu.tbadk.core.message.RequestUpdateMaskInfoMessage;
/* loaded from: classes.dex */
public class d extends com.baidu.adp.base.e {
    private int mMaskType;
    private RequestUpdateMaskInfoMessage mUpdateMessage;

    public d(Context context) {
        super(context);
        this.mMaskType = 2;
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        super.cancelMessage();
        return false;
    }

    public void addToBlackList(long j) {
        this.mUpdateMessage = new RequestUpdateMaskInfoMessage();
        this.mUpdateMessage.setIsMask(1);
        this.mUpdateMessage.setMaskType(10);
        this.mUpdateMessage.setList(String.valueOf(j));
        super.sendMessage(this.mUpdateMessage);
    }

    public void removeFromBlackList(long j) {
        this.mUpdateMessage = new RequestUpdateMaskInfoMessage();
        this.mUpdateMessage.setIsMask(0);
        this.mUpdateMessage.setMaskType(10);
        this.mUpdateMessage.setList(String.valueOf(j));
        super.sendMessage(this.mUpdateMessage);
    }

    public int getMaskType() {
        return this.mMaskType;
    }

    public void setMaskType(int i) {
        this.mMaskType = i;
    }
}
