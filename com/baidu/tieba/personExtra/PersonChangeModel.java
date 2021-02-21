package com.baidu.tieba.personExtra;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
/* loaded from: classes8.dex */
public class PersonChangeModel extends BdBaseModel {
    PersonChangeData mym;

    public PersonChangeModel(PersonChangeData personChangeData) {
        super(null);
        this.mym = null;
        this.mym = personChangeData;
        if (this.mym == null) {
            this.mym = new PersonChangeData();
        }
    }

    public PersonChangeData dxP() {
        return this.mym;
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
