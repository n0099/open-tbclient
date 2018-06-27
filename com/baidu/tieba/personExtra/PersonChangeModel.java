package com.baidu.tieba.personExtra;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
/* loaded from: classes3.dex */
public class PersonChangeModel extends BdBaseModel {
    PersonChangeData fXW;

    public PersonChangeModel(PersonChangeData personChangeData) {
        super(null);
        this.fXW = null;
        this.fXW = personChangeData;
        if (this.fXW == null) {
            this.fXW = new PersonChangeData();
        }
    }

    public PersonChangeData bkp() {
        return this.fXW;
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
