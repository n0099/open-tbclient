package com.baidu.tieba.personExtra;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
/* loaded from: classes6.dex */
public class PersonChangeModel extends BdBaseModel {
    PersonChangeData hPc;

    public PersonChangeModel(PersonChangeData personChangeData) {
        super(null);
        this.hPc = null;
        this.hPc = personChangeData;
        if (this.hPc == null) {
            this.hPc = new PersonChangeData();
        }
    }

    public PersonChangeData bRs() {
        return this.hPc;
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
