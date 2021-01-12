package com.baidu.tieba.setting.model;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
/* loaded from: classes7.dex */
public class MoreModel extends BdBaseModel {
    private boolean mVc;
    private PersonChangeData mrI;

    /* loaded from: classes7.dex */
    public enum TaskType {
        DO_CACHE_CLEAR,
        GET_SIZE
    }

    public MoreModel(PersonChangeData personChangeData) {
        super(null);
        this.mrI = null;
        this.mVc = false;
        this.mrI = personChangeData;
        if (this.mrI == null) {
            this.mrI = new PersonChangeData();
        }
    }

    public void b(PersonChangeData personChangeData) {
        this.mrI = personChangeData;
    }

    public void xu(boolean z) {
        this.mVc = z;
    }

    public boolean dEh() {
        return this.mVc;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public PersonChangeData dEi() {
        return this.mrI;
    }
}
