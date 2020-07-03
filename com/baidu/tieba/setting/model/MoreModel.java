package com.baidu.tieba.setting.model;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
/* loaded from: classes13.dex */
public class MoreModel extends BdBaseModel {
    private PersonChangeData kMS;
    private boolean lpA;

    /* loaded from: classes13.dex */
    public enum TaskType {
        DO_CACHE_CLEAR,
        GET_SIZE
    }

    public MoreModel(PersonChangeData personChangeData) {
        super(null);
        this.kMS = null;
        this.lpA = false;
        this.kMS = personChangeData;
        if (this.kMS == null) {
            this.kMS = new PersonChangeData();
        }
    }

    public void b(PersonChangeData personChangeData) {
        this.kMS = personChangeData;
    }

    public void ug(boolean z) {
        this.lpA = z;
    }

    public boolean dbG() {
        return this.lpA;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public PersonChangeData dbH() {
        return this.kMS;
    }
}
