package com.baidu.tieba.personExtra;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
/* loaded from: classes3.dex */
public class PersonChangeModel extends BdBaseModel {
    PersonChangeData fYn;

    public PersonChangeModel(PersonChangeData personChangeData) {
        super(null);
        this.fYn = null;
        this.fYn = personChangeData;
        if (this.fYn == null) {
            this.fYn = new PersonChangeData();
        }
    }

    public PersonChangeData biF() {
        return this.fYn;
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
