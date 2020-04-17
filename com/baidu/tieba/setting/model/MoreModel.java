package com.baidu.tieba.setting.model;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
/* loaded from: classes13.dex */
public class MoreModel extends BdBaseModel {
    private PersonChangeData jZS;
    private boolean kCo;

    /* loaded from: classes13.dex */
    public enum TaskType {
        DO_CACHE_CLEAR,
        GET_SIZE
    }

    public MoreModel(PersonChangeData personChangeData) {
        super(null);
        this.jZS = null;
        this.kCo = false;
        this.jZS = personChangeData;
        if (this.jZS == null) {
            this.jZS = new PersonChangeData();
        }
    }

    public void b(PersonChangeData personChangeData) {
        this.jZS = personChangeData;
    }

    public void tt(boolean z) {
        this.kCo = z;
    }

    public boolean cQa() {
        return this.kCo;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public PersonChangeData cQb() {
        return this.jZS;
    }
}
