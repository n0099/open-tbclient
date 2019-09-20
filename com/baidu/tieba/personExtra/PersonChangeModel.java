package com.baidu.tieba.personExtra;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
/* loaded from: classes6.dex */
public class PersonChangeModel extends BdBaseModel {
    PersonChangeData iqW;

    public PersonChangeModel(PersonChangeData personChangeData) {
        super(null);
        this.iqW = null;
        this.iqW = personChangeData;
        if (this.iqW == null) {
            this.iqW = new PersonChangeData();
        }
    }

    public PersonChangeData cdo() {
        return this.iqW;
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
