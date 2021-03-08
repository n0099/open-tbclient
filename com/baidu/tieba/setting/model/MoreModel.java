package com.baidu.tieba.setting.model;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
/* loaded from: classes7.dex */
public class MoreModel extends BdBaseModel {
    private PersonChangeData mDc;
    private boolean nhp;

    /* loaded from: classes7.dex */
    public enum TaskType {
        DO_CACHE_CLEAR,
        GET_SIZE
    }

    public MoreModel(PersonChangeData personChangeData) {
        super(null);
        this.mDc = null;
        this.nhp = false;
        this.mDc = personChangeData;
        if (this.mDc == null) {
            this.mDc = new PersonChangeData();
        }
    }

    public void b(PersonChangeData personChangeData) {
        this.mDc = personChangeData;
    }

    public void xN(boolean z) {
        this.nhp = z;
    }

    public boolean dGI() {
        return this.nhp;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public PersonChangeData dGJ() {
        return this.mDc;
    }
}
