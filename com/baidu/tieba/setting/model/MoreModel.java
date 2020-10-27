package com.baidu.tieba.setting.model;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
/* loaded from: classes26.dex */
public class MoreModel extends BdBaseModel {
    private PersonChangeData lWB;
    private boolean mzH;

    /* loaded from: classes26.dex */
    public enum TaskType {
        DO_CACHE_CLEAR,
        GET_SIZE
    }

    public MoreModel(PersonChangeData personChangeData) {
        super(null);
        this.lWB = null;
        this.mzH = false;
        this.lWB = personChangeData;
        if (this.lWB == null) {
            this.lWB = new PersonChangeData();
        }
    }

    public void b(PersonChangeData personChangeData) {
        this.lWB = personChangeData;
    }

    public void wH(boolean z) {
        this.mzH = z;
    }

    public boolean dAR() {
        return this.mzH;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public PersonChangeData dAS() {
        return this.lWB;
    }
}
