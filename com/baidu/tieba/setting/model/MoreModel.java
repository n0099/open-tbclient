package com.baidu.tieba.setting.model;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
/* loaded from: classes25.dex */
public class MoreModel extends BdBaseModel {
    private boolean mGg;
    private PersonChangeData mcS;

    /* loaded from: classes25.dex */
    public enum TaskType {
        DO_CACHE_CLEAR,
        GET_SIZE
    }

    public MoreModel(PersonChangeData personChangeData) {
        super(null);
        this.mcS = null;
        this.mGg = false;
        this.mcS = personChangeData;
        if (this.mcS == null) {
            this.mcS = new PersonChangeData();
        }
    }

    public void b(PersonChangeData personChangeData) {
        this.mcS = personChangeData;
    }

    public void wT(boolean z) {
        this.mGg = z;
    }

    public boolean dCX() {
        return this.mGg;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public PersonChangeData dCY() {
        return this.mcS;
    }
}
