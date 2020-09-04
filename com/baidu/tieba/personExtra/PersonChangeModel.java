package com.baidu.tieba.personExtra;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
/* loaded from: classes18.dex */
public class PersonChangeModel extends BdBaseModel {
    PersonChangeData ljn;

    public PersonChangeModel(PersonChangeData personChangeData) {
        super(null);
        this.ljn = null;
        this.ljn = personChangeData;
        if (this.ljn == null) {
            this.ljn = new PersonChangeData();
        }
    }

    public PersonChangeData dhK() {
        return this.ljn;
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
