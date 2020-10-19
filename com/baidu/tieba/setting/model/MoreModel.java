package com.baidu.tieba.setting.model;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
/* loaded from: classes26.dex */
public class MoreModel extends BdBaseModel {
    private PersonChangeData lKf;
    private boolean mng;

    /* loaded from: classes26.dex */
    public enum TaskType {
        DO_CACHE_CLEAR,
        GET_SIZE
    }

    public MoreModel(PersonChangeData personChangeData) {
        super(null);
        this.lKf = null;
        this.mng = false;
        this.lKf = personChangeData;
        if (this.lKf == null) {
            this.lKf = new PersonChangeData();
        }
    }

    public void b(PersonChangeData personChangeData) {
        this.lKf = personChangeData;
    }

    public void wq(boolean z) {
        this.mng = z;
    }

    public boolean dxJ() {
        return this.mng;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public PersonChangeData dxK() {
        return this.lKf;
    }
}
