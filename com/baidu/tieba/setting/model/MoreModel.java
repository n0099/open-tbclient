package com.baidu.tieba.setting.model;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
/* loaded from: classes3.dex */
public class MoreModel extends BdBaseModel {
    private boolean iSt;
    private PersonChangeData mPersonChangeData;

    /* loaded from: classes3.dex */
    public enum TaskType {
        DO_CACHE_CLEAR,
        GET_SIZE
    }

    public MoreModel(PersonChangeData personChangeData) {
        super(null);
        this.mPersonChangeData = null;
        this.iSt = false;
        this.mPersonChangeData = personChangeData;
        if (this.mPersonChangeData == null) {
            this.mPersonChangeData = new PersonChangeData();
        }
    }

    public void setPersonChangeData(PersonChangeData personChangeData) {
        this.mPersonChangeData = personChangeData;
    }

    public void qo(boolean z) {
        this.iSt = z;
    }

    public boolean civ() {
        return this.iSt;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public PersonChangeData getPersonChangeData() {
        return this.mPersonChangeData;
    }
}
