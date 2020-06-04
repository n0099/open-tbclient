package com.baidu.tieba.personExtra;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
/* loaded from: classes11.dex */
public class PersonChangeModel extends BdBaseModel {
    PersonChangeData kqp;

    public PersonChangeModel(PersonChangeData personChangeData) {
        super(null);
        this.kqp = null;
        this.kqp = personChangeData;
        if (this.kqp == null) {
            this.kqp = new PersonChangeData();
        }
    }

    public PersonChangeData cOE() {
        return this.kqp;
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
