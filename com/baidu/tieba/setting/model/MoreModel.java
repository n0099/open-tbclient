package com.baidu.tieba.setting.model;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
/* loaded from: classes20.dex */
public class MoreModel extends BdBaseModel {
    private boolean lOu;
    private PersonChangeData llW;

    /* loaded from: classes20.dex */
    public enum TaskType {
        DO_CACHE_CLEAR,
        GET_SIZE
    }

    public MoreModel(PersonChangeData personChangeData) {
        super(null);
        this.llW = null;
        this.lOu = false;
        this.llW = personChangeData;
        if (this.llW == null) {
            this.llW = new PersonChangeData();
        }
    }

    public void b(PersonChangeData personChangeData) {
        this.llW = personChangeData;
    }

    public void vB(boolean z) {
        this.lOu = z;
    }

    public boolean dqk() {
        return this.lOu;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public PersonChangeData dql() {
        return this.llW;
    }
}
