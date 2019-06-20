package com.baidu.tieba.personExtra;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
/* loaded from: classes6.dex */
public class PersonChangeModel extends BdBaseModel {
    PersonChangeData ihB;

    public PersonChangeModel(PersonChangeData personChangeData) {
        super(null);
        this.ihB = null;
        this.ihB = personChangeData;
        if (this.ihB == null) {
            this.ihB = new PersonChangeData();
        }
    }

    public PersonChangeData bZt() {
        return this.ihB;
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
