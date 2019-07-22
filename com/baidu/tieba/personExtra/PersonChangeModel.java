package com.baidu.tieba.personExtra;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
/* loaded from: classes6.dex */
public class PersonChangeModel extends BdBaseModel {
    PersonChangeData inT;

    public PersonChangeModel(PersonChangeData personChangeData) {
        super(null);
        this.inT = null;
        this.inT = personChangeData;
        if (this.inT == null) {
            this.inT = new PersonChangeData();
        }
    }

    public PersonChangeData cci() {
        return this.inT;
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
