package com.baidu.tieba.setting.model;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
/* loaded from: classes8.dex */
public class MoreModel extends BdBaseModel {
    private boolean mZI;
    private PersonChangeData mwo;

    /* loaded from: classes8.dex */
    public enum TaskType {
        DO_CACHE_CLEAR,
        GET_SIZE
    }

    public MoreModel(PersonChangeData personChangeData) {
        super(null);
        this.mwo = null;
        this.mZI = false;
        this.mwo = personChangeData;
        if (this.mwo == null) {
            this.mwo = new PersonChangeData();
        }
    }

    public void b(PersonChangeData personChangeData) {
        this.mwo = personChangeData;
    }

    public void xy(boolean z) {
        this.mZI = z;
    }

    public boolean dHY() {
        return this.mZI;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public PersonChangeData dHZ() {
        return this.mwo;
    }
}
