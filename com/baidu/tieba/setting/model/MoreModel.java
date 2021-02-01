package com.baidu.tieba.setting.model;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
/* loaded from: classes8.dex */
public class MoreModel extends BdBaseModel {
    private PersonChangeData mAI;
    private boolean neL;

    /* loaded from: classes8.dex */
    public enum TaskType {
        DO_CACHE_CLEAR,
        GET_SIZE
    }

    public MoreModel(PersonChangeData personChangeData) {
        super(null);
        this.mAI = null;
        this.neL = false;
        this.mAI = personChangeData;
        if (this.mAI == null) {
            this.mAI = new PersonChangeData();
        }
    }

    public void b(PersonChangeData personChangeData) {
        this.mAI = personChangeData;
    }

    public void xN(boolean z) {
        this.neL = z;
    }

    public boolean dGs() {
        return this.neL;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public PersonChangeData dGt() {
        return this.mAI;
    }
}
