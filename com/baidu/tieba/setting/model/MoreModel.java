package com.baidu.tieba.setting.model;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
/* loaded from: classes26.dex */
public class MoreModel extends BdBaseModel {
    private boolean mUm;
    private PersonChangeData mra;

    /* loaded from: classes26.dex */
    public enum TaskType {
        DO_CACHE_CLEAR,
        GET_SIZE
    }

    public MoreModel(PersonChangeData personChangeData) {
        super(null);
        this.mra = null;
        this.mUm = false;
        this.mra = personChangeData;
        if (this.mra == null) {
            this.mra = new PersonChangeData();
        }
    }

    public void b(PersonChangeData personChangeData) {
        this.mra = personChangeData;
    }

    public void xx(boolean z) {
        this.mUm = z;
    }

    public boolean dIj() {
        return this.mUm;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public PersonChangeData dIk() {
        return this.mra;
    }
}
