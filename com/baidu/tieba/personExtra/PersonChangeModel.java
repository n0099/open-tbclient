package com.baidu.tieba.personExtra;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
/* loaded from: classes11.dex */
public class PersonChangeModel extends BdBaseModel {
    PersonChangeData jXm;

    public PersonChangeModel(PersonChangeData personChangeData) {
        super(null);
        this.jXm = null;
        this.jXm = personChangeData;
        if (this.jXm == null) {
            this.jXm = new PersonChangeData();
        }
    }

    public PersonChangeData cHr() {
        return this.jXm;
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
