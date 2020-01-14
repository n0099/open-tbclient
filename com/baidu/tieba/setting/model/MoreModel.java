package com.baidu.tieba.setting.model;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
/* loaded from: classes11.dex */
public class MoreModel extends BdBaseModel {
    private boolean jQv;
    private PersonChangeData jmY;

    /* loaded from: classes11.dex */
    public enum TaskType {
        DO_CACHE_CLEAR,
        GET_SIZE
    }

    public MoreModel(PersonChangeData personChangeData) {
        super(null);
        this.jmY = null;
        this.jQv = false;
        this.jmY = personChangeData;
        if (this.jmY == null) {
            this.jmY = new PersonChangeData();
        }
    }

    public void b(PersonChangeData personChangeData) {
        this.jmY = personChangeData;
    }

    public void sj(boolean z) {
        this.jQv = z;
    }

    public boolean cDE() {
        return this.jQv;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public PersonChangeData cDF() {
        return this.jmY;
    }
}
