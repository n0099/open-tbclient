package com.baidu.tieba.setting.model;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
/* loaded from: classes20.dex */
public class MoreModel extends BdBaseModel {
    private PersonChangeData kVS;
    private boolean lwR;

    /* loaded from: classes20.dex */
    public enum TaskType {
        DO_CACHE_CLEAR,
        GET_SIZE
    }

    public MoreModel(PersonChangeData personChangeData) {
        super(null);
        this.kVS = null;
        this.lwR = false;
        this.kVS = personChangeData;
        if (this.kVS == null) {
            this.kVS = new PersonChangeData();
        }
    }

    public void b(PersonChangeData personChangeData) {
        this.kVS = personChangeData;
    }

    public void uK(boolean z) {
        this.lwR = z;
    }

    public boolean deO() {
        return this.lwR;
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
        return this.kVS;
    }
}
