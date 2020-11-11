package com.baidu.tieba.setting.model;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
/* loaded from: classes26.dex */
public class MoreModel extends BdBaseModel {
    private boolean mFJ;
    private PersonChangeData mcA;

    /* loaded from: classes26.dex */
    public enum TaskType {
        DO_CACHE_CLEAR,
        GET_SIZE
    }

    public MoreModel(PersonChangeData personChangeData) {
        super(null);
        this.mcA = null;
        this.mFJ = false;
        this.mcA = personChangeData;
        if (this.mcA == null) {
            this.mcA = new PersonChangeData();
        }
    }

    public void b(PersonChangeData personChangeData) {
        this.mcA = personChangeData;
    }

    public void wQ(boolean z) {
        this.mFJ = z;
    }

    public boolean dDt() {
        return this.mFJ;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public PersonChangeData dDu() {
        return this.mcA;
    }
}
