package com.baidu.tieba.setting.model;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
/* loaded from: classes20.dex */
public class MoreModel extends BdBaseModel {
    private boolean lOh;
    private PersonChangeData llL;

    /* loaded from: classes20.dex */
    public enum TaskType {
        DO_CACHE_CLEAR,
        GET_SIZE
    }

    public MoreModel(PersonChangeData personChangeData) {
        super(null);
        this.llL = null;
        this.lOh = false;
        this.llL = personChangeData;
        if (this.llL == null) {
            this.llL = new PersonChangeData();
        }
    }

    public void b(PersonChangeData personChangeData) {
        this.llL = personChangeData;
    }

    public void vz(boolean z) {
        this.lOh = z;
    }

    public boolean dqh() {
        return this.lOh;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public PersonChangeData dqi() {
        return this.llL;
    }
}
