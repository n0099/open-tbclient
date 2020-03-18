package com.baidu.tieba.setting.model;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
/* loaded from: classes13.dex */
public class MoreModel extends BdBaseModel {
    private boolean jTg;
    private PersonChangeData jpE;

    /* loaded from: classes13.dex */
    public enum TaskType {
        DO_CACHE_CLEAR,
        GET_SIZE
    }

    public MoreModel(PersonChangeData personChangeData) {
        super(null);
        this.jpE = null;
        this.jTg = false;
        this.jpE = personChangeData;
        if (this.jpE == null) {
            this.jpE = new PersonChangeData();
        }
    }

    public void b(PersonChangeData personChangeData) {
        this.jpE = personChangeData;
    }

    public void ss(boolean z) {
        this.jTg = z;
    }

    public boolean cFC() {
        return this.jTg;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public PersonChangeData cFD() {
        return this.jpE;
    }
}
