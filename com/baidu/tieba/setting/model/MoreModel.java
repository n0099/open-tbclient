package com.baidu.tieba.setting.model;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
/* loaded from: classes25.dex */
public class MoreModel extends BdBaseModel {
    private boolean lXA;
    private PersonChangeData luT;

    /* loaded from: classes25.dex */
    public enum TaskType {
        DO_CACHE_CLEAR,
        GET_SIZE
    }

    public MoreModel(PersonChangeData personChangeData) {
        super(null);
        this.luT = null;
        this.lXA = false;
        this.luT = personChangeData;
        if (this.luT == null) {
            this.luT = new PersonChangeData();
        }
    }

    public void b(PersonChangeData personChangeData) {
        this.luT = personChangeData;
    }

    public void vJ(boolean z) {
        this.lXA = z;
    }

    public boolean dtY() {
        return this.lXA;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public PersonChangeData dtZ() {
        return this.luT;
    }
}
