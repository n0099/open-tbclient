package com.baidu.tieba.setting.model;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
/* loaded from: classes13.dex */
public class MoreModel extends BdBaseModel {
    private boolean jRq;
    private PersonChangeData jnR;

    /* loaded from: classes13.dex */
    public enum TaskType {
        DO_CACHE_CLEAR,
        GET_SIZE
    }

    public MoreModel(PersonChangeData personChangeData) {
        super(null);
        this.jnR = null;
        this.jRq = false;
        this.jnR = personChangeData;
        if (this.jnR == null) {
            this.jnR = new PersonChangeData();
        }
    }

    public void b(PersonChangeData personChangeData) {
        this.jnR = personChangeData;
    }

    public void sm(boolean z) {
        this.jRq = z;
    }

    public boolean cFf() {
        return this.jRq;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public PersonChangeData cFg() {
        return this.jnR;
    }
}
