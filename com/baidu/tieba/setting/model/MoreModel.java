package com.baidu.tieba.setting.model;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
/* loaded from: classes13.dex */
public class MoreModel extends BdBaseModel {
    private boolean jRs;
    private PersonChangeData jnT;

    /* loaded from: classes13.dex */
    public enum TaskType {
        DO_CACHE_CLEAR,
        GET_SIZE
    }

    public MoreModel(PersonChangeData personChangeData) {
        super(null);
        this.jnT = null;
        this.jRs = false;
        this.jnT = personChangeData;
        if (this.jnT == null) {
            this.jnT = new PersonChangeData();
        }
    }

    public void b(PersonChangeData personChangeData) {
        this.jnT = personChangeData;
    }

    public void sm(boolean z) {
        this.jRs = z;
    }

    public boolean cFh() {
        return this.jRs;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public PersonChangeData cFi() {
        return this.jnT;
    }
}
