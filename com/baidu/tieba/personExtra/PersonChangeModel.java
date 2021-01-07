package com.baidu.tieba.personExtra;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
/* loaded from: classes8.dex */
public class PersonChangeModel extends BdBaseModel {
    PersonChangeData mtC;

    public PersonChangeModel(PersonChangeData personChangeData) {
        super(null);
        this.mtC = null;
        this.mtC = personChangeData;
        if (this.mtC == null) {
            this.mtC = new PersonChangeData();
        }
    }

    public PersonChangeData dzr() {
        return this.mtC;
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
