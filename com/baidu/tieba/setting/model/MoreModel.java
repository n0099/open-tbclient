package com.baidu.tieba.setting.model;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
/* loaded from: classes11.dex */
public class MoreModel extends BdBaseModel {
    private boolean jQq;
    private PersonChangeData jmT;

    /* loaded from: classes11.dex */
    public enum TaskType {
        DO_CACHE_CLEAR,
        GET_SIZE
    }

    public MoreModel(PersonChangeData personChangeData) {
        super(null);
        this.jmT = null;
        this.jQq = false;
        this.jmT = personChangeData;
        if (this.jmT == null) {
            this.jmT = new PersonChangeData();
        }
    }

    public void b(PersonChangeData personChangeData) {
        this.jmT = personChangeData;
    }

    public void sj(boolean z) {
        this.jQq = z;
    }

    public boolean cDC() {
        return this.jQq;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public PersonChangeData cDD() {
        return this.jmT;
    }
}
