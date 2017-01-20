package com.baidu.tieba.model;

import com.baidu.adp.base.BdBaseModel;
/* loaded from: classes.dex */
public class BuildOrderModel<T> extends BdBaseModel<T> {
    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }
}
