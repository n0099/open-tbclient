package com.baidu.tieba.personExtra;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
/* loaded from: classes24.dex */
public class PersonChangeModel extends BdBaseModel {
    PersonChangeData mop;

    public PersonChangeModel(PersonChangeData personChangeData) {
        super(null);
        this.mop = null;
        this.mop = personChangeData;
        if (this.mop == null) {
            this.mop = new PersonChangeData();
        }
    }

    public PersonChangeData dzA() {
        return this.mop;
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
