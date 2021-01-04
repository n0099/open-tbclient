package com.baidu.tieba.personExtra;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
/* loaded from: classes8.dex */
public class PersonChangeModel extends BdBaseModel {
    PersonChangeData mtD;

    public PersonChangeModel(PersonChangeData personChangeData) {
        super(null);
        this.mtD = null;
        this.mtD = personChangeData;
        if (this.mtD == null) {
            this.mtD = new PersonChangeData();
        }
    }

    public PersonChangeData dzq() {
        return this.mtD;
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
