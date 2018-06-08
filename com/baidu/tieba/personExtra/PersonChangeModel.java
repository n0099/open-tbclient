package com.baidu.tieba.personExtra;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
/* loaded from: classes3.dex */
public class PersonChangeModel extends BdBaseModel {
    PersonChangeData fTU;

    public PersonChangeModel(PersonChangeData personChangeData) {
        super(null);
        this.fTU = null;
        this.fTU = personChangeData;
        if (this.fTU == null) {
            this.fTU = new PersonChangeData();
        }
    }

    public PersonChangeData bjJ() {
        return this.fTU;
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
