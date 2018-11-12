package com.baidu.tieba.personExtra;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
/* loaded from: classes3.dex */
public class PersonChangeModel extends BdBaseModel {
    PersonChangeData goE;

    public PersonChangeModel(PersonChangeData personChangeData) {
        super(null);
        this.goE = null;
        this.goE = personChangeData;
        if (this.goE == null) {
            this.goE = new PersonChangeData();
        }
    }

    public PersonChangeData bnM() {
        return this.goE;
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
