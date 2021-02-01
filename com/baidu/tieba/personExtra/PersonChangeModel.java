package com.baidu.tieba.personExtra;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
/* loaded from: classes8.dex */
public class PersonChangeModel extends BdBaseModel {
    PersonChangeData mxX;

    public PersonChangeModel(PersonChangeData personChangeData) {
        super(null);
        this.mxX = null;
        this.mxX = personChangeData;
        if (this.mxX == null) {
            this.mxX = new PersonChangeData();
        }
    }

    public PersonChangeData dxI() {
        return this.mxX;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }
}
