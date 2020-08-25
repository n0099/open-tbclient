package com.baidu.tieba.personExtra;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
/* loaded from: classes18.dex */
public class PersonChangeModel extends BdBaseModel {
    PersonChangeData ljg;

    public PersonChangeModel(PersonChangeData personChangeData) {
        super(null);
        this.ljg = null;
        this.ljg = personChangeData;
        if (this.ljg == null) {
            this.ljg = new PersonChangeData();
        }
    }

    public PersonChangeData dhJ() {
        return this.ljg;
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
