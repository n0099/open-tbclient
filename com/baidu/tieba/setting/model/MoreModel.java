package com.baidu.tieba.setting.model;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
/* loaded from: classes13.dex */
public class MoreModel extends BdBaseModel {
    private PersonChangeData jZW;
    private boolean kCs;

    /* loaded from: classes13.dex */
    public enum TaskType {
        DO_CACHE_CLEAR,
        GET_SIZE
    }

    public MoreModel(PersonChangeData personChangeData) {
        super(null);
        this.jZW = null;
        this.kCs = false;
        this.jZW = personChangeData;
        if (this.jZW == null) {
            this.jZW = new PersonChangeData();
        }
    }

    public void b(PersonChangeData personChangeData) {
        this.jZW = personChangeData;
    }

    public void tt(boolean z) {
        this.kCs = z;
    }

    public boolean cPX() {
        return this.kCs;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public PersonChangeData cPY() {
        return this.jZW;
    }
}
