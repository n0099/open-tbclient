package com.baidu.tieba.memberCenter.index;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes3.dex */
public class MembercenterModel extends BdBaseModel<BaseFragmentActivity> {
    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        sendMessage(new MembercenterRequestMessage());
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }
}
