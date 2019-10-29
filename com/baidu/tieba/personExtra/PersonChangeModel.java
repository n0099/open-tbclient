package com.baidu.tieba.personExtra;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
/* loaded from: classes6.dex */
public class PersonChangeModel extends BdBaseModel {
    PersonChangeData ipw;

    public PersonChangeModel(PersonChangeData personChangeData) {
        super(null);
        this.ipw = null;
        this.ipw = personChangeData;
        if (this.ipw == null) {
            this.ipw = new PersonChangeData();
        }
    }

    public PersonChangeData cap() {
        return this.ipw;
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
