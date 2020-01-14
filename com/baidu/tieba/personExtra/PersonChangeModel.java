package com.baidu.tieba.personExtra;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
/* loaded from: classes9.dex */
public class PersonChangeModel extends BdBaseModel {
    PersonChangeData jkr;

    public PersonChangeModel(PersonChangeData personChangeData) {
        super(null);
        this.jkr = null;
        this.jkr = personChangeData;
        if (this.jkr == null) {
            this.jkr = new PersonChangeData();
        }
    }

    public PersonChangeData cuR() {
        return this.jkr;
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
