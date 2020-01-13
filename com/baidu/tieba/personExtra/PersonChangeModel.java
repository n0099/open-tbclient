package com.baidu.tieba.personExtra;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
/* loaded from: classes9.dex */
public class PersonChangeModel extends BdBaseModel {
    PersonChangeData jkm;

    public PersonChangeModel(PersonChangeData personChangeData) {
        super(null);
        this.jkm = null;
        this.jkm = personChangeData;
        if (this.jkm == null) {
            this.jkm = new PersonChangeData();
        }
    }

    public PersonChangeData cuP() {
        return this.jkm;
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
