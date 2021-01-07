package com.baidu.tieba.setting.model;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
/* loaded from: classes8.dex */
public class MoreModel extends BdBaseModel {
    private boolean mZH;
    private PersonChangeData mwn;

    /* loaded from: classes8.dex */
    public enum TaskType {
        DO_CACHE_CLEAR,
        GET_SIZE
    }

    public MoreModel(PersonChangeData personChangeData) {
        super(null);
        this.mwn = null;
        this.mZH = false;
        this.mwn = personChangeData;
        if (this.mwn == null) {
            this.mwn = new PersonChangeData();
        }
    }

    public void b(PersonChangeData personChangeData) {
        this.mwn = personChangeData;
    }

    public void xy(boolean z) {
        this.mZH = z;
    }

    public boolean dHZ() {
        return this.mZH;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public PersonChangeData dIa() {
        return this.mwn;
    }
}
