package com.baidu.tieba.personExtra;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
/* loaded from: classes24.dex */
public class PersonChangeModel extends BdBaseModel {
    PersonChangeData lZO;

    public PersonChangeModel(PersonChangeData personChangeData) {
        super(null);
        this.lZO = null;
        this.lZO = personChangeData;
        if (this.lZO == null) {
            this.lZO = new PersonChangeData();
        }
    }

    public PersonChangeData duI() {
        return this.lZO;
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
