package com.baidu.tieba.setting.model;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
/* loaded from: classes13.dex */
public class MoreModel extends BdBaseModel {
    private boolean jRE;
    private PersonChangeData jof;

    /* loaded from: classes13.dex */
    public enum TaskType {
        DO_CACHE_CLEAR,
        GET_SIZE
    }

    public MoreModel(PersonChangeData personChangeData) {
        super(null);
        this.jof = null;
        this.jRE = false;
        this.jof = personChangeData;
        if (this.jof == null) {
            this.jof = new PersonChangeData();
        }
    }

    public void b(PersonChangeData personChangeData) {
        this.jof = personChangeData;
    }

    public void sm(boolean z) {
        this.jRE = z;
    }

    public boolean cFi() {
        return this.jRE;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public PersonChangeData cFj() {
        return this.jof;
    }
}
