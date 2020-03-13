package com.baidu.tieba.personExtra;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
/* loaded from: classes11.dex */
public class PersonChangeModel extends BdBaseModel {
    PersonChangeData jly;

    public PersonChangeModel(PersonChangeData personChangeData) {
        super(null);
        this.jly = null;
        this.jly = personChangeData;
        if (this.jly == null) {
            this.jly = new PersonChangeData();
        }
    }

    public PersonChangeData cwn() {
        return this.jly;
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
