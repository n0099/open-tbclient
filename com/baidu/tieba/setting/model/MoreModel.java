package com.baidu.tieba.setting.model;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
/* loaded from: classes10.dex */
public class MoreModel extends BdBaseModel {
    private boolean jMN;
    private PersonChangeData jjr;

    /* loaded from: classes10.dex */
    public enum TaskType {
        DO_CACHE_CLEAR,
        GET_SIZE
    }

    public MoreModel(PersonChangeData personChangeData) {
        super(null);
        this.jjr = null;
        this.jMN = false;
        this.jjr = personChangeData;
        if (this.jjr == null) {
            this.jjr = new PersonChangeData();
        }
    }

    public void b(PersonChangeData personChangeData) {
        this.jjr = personChangeData;
    }

    public void rX(boolean z) {
        this.jMN = z;
    }

    public boolean cCy() {
        return this.jMN;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public PersonChangeData cCz() {
        return this.jjr;
    }
}
