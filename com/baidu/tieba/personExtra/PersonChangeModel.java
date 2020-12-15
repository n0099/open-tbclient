package com.baidu.tieba.personExtra;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
/* loaded from: classes24.dex */
public class PersonChangeModel extends BdBaseModel {
    PersonChangeData mor;

    public PersonChangeModel(PersonChangeData personChangeData) {
        super(null);
        this.mor = null;
        this.mor = personChangeData;
        if (this.mor == null) {
            this.mor = new PersonChangeData();
        }
    }

    public PersonChangeData dzB() {
        return this.mor;
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
