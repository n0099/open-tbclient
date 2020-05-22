package com.baidu.tieba.setting.model;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
/* loaded from: classes13.dex */
public class MoreModel extends BdBaseModel {
    private boolean kUu;
    private PersonChangeData krP;

    /* loaded from: classes13.dex */
    public enum TaskType {
        DO_CACHE_CLEAR,
        GET_SIZE
    }

    public MoreModel(PersonChangeData personChangeData) {
        super(null);
        this.krP = null;
        this.kUu = false;
        this.krP = personChangeData;
        if (this.krP == null) {
            this.krP = new PersonChangeData();
        }
    }

    public void b(PersonChangeData personChangeData) {
        this.krP = personChangeData;
    }

    public void tR(boolean z) {
        this.kUu = z;
    }

    public boolean cXb() {
        return this.kUu;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public PersonChangeData cXc() {
        return this.krP;
    }
}
