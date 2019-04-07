package com.baidu.tieba.personExtra;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
/* loaded from: classes6.dex */
public class PersonChangeModel extends BdBaseModel {
    PersonChangeData hPb;

    public PersonChangeModel(PersonChangeData personChangeData) {
        super(null);
        this.hPb = null;
        this.hPb = personChangeData;
        if (this.hPb == null) {
            this.hPb = new PersonChangeData();
        }
    }

    public PersonChangeData bRs() {
        return this.hPb;
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
