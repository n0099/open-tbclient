package com.baidu.tieba.personExtra;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
/* loaded from: classes6.dex */
public class PersonChangeModel extends BdBaseModel {
    PersonChangeData hPp;

    public PersonChangeModel(PersonChangeData personChangeData) {
        super(null);
        this.hPp = null;
        this.hPp = personChangeData;
        if (this.hPp == null) {
            this.hPp = new PersonChangeData();
        }
    }

    public PersonChangeData bRw() {
        return this.hPp;
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
