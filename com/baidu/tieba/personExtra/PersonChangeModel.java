package com.baidu.tieba.personExtra;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
/* loaded from: classes3.dex */
public class PersonChangeModel extends BdBaseModel {
    PersonChangeData fHv;

    public PersonChangeModel(PersonChangeData personChangeData) {
        super(null);
        this.fHv = null;
        this.fHv = personChangeData;
        if (this.fHv == null) {
            this.fHv = new PersonChangeData();
        }
    }

    public PersonChangeData beJ() {
        return this.fHv;
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
