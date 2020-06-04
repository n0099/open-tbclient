package com.baidu.tieba.setting.model;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
/* loaded from: classes13.dex */
public class MoreModel extends BdBaseModel {
    private boolean kVD;
    private PersonChangeData ksV;

    /* loaded from: classes13.dex */
    public enum TaskType {
        DO_CACHE_CLEAR,
        GET_SIZE
    }

    public MoreModel(PersonChangeData personChangeData) {
        super(null);
        this.ksV = null;
        this.kVD = false;
        this.ksV = personChangeData;
        if (this.ksV == null) {
            this.ksV = new PersonChangeData();
        }
    }

    public void b(PersonChangeData personChangeData) {
        this.ksV = personChangeData;
    }

    public void tR(boolean z) {
        this.kVD = z;
    }

    public boolean cXr() {
        return this.kVD;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public PersonChangeData cXs() {
        return this.ksV;
    }
}
