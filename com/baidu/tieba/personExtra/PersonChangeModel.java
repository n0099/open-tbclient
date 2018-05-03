package com.baidu.tieba.personExtra;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
/* loaded from: classes3.dex */
public class PersonChangeModel extends BdBaseModel {
    PersonChangeData fHs;

    public PersonChangeModel(PersonChangeData personChangeData) {
        super(null);
        this.fHs = null;
        this.fHs = personChangeData;
        if (this.fHs == null) {
            this.fHs = new PersonChangeData();
        }
    }

    public PersonChangeData beJ() {
        return this.fHs;
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
