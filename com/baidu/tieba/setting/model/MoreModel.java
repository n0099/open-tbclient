package com.baidu.tieba.setting.model;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
/* loaded from: classes26.dex */
public class MoreModel extends BdBaseModel {
    private boolean mUj;
    private PersonChangeData mqY;

    /* loaded from: classes26.dex */
    public enum TaskType {
        DO_CACHE_CLEAR,
        GET_SIZE
    }

    public MoreModel(PersonChangeData personChangeData) {
        super(null);
        this.mqY = null;
        this.mUj = false;
        this.mqY = personChangeData;
        if (this.mqY == null) {
            this.mqY = new PersonChangeData();
        }
    }

    public void b(PersonChangeData personChangeData) {
        this.mqY = personChangeData;
    }

    public void xx(boolean z) {
        this.mUj = z;
    }

    public boolean dIi() {
        return this.mUj;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public PersonChangeData dIj() {
        return this.mqY;
    }
}
