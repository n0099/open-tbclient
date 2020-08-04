package com.baidu.tieba.setting.model;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
/* loaded from: classes20.dex */
public class MoreModel extends BdBaseModel {
    private PersonChangeData kVU;
    private boolean lwT;

    /* loaded from: classes20.dex */
    public enum TaskType {
        DO_CACHE_CLEAR,
        GET_SIZE
    }

    public MoreModel(PersonChangeData personChangeData) {
        super(null);
        this.kVU = null;
        this.lwT = false;
        this.kVU = personChangeData;
        if (this.kVU == null) {
            this.kVU = new PersonChangeData();
        }
    }

    public void b(PersonChangeData personChangeData) {
        this.kVU = personChangeData;
    }

    public void uK(boolean z) {
        this.lwT = z;
    }

    public boolean deO() {
        return this.lwT;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public PersonChangeData deP() {
        return this.kVU;
    }
}
