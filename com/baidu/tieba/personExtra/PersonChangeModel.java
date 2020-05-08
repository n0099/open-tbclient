package com.baidu.tieba.personExtra;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
/* loaded from: classes11.dex */
public class PersonChangeModel extends BdBaseModel {
    PersonChangeData jXq;

    public PersonChangeModel(PersonChangeData personChangeData) {
        super(null);
        this.jXq = null;
        this.jXq = personChangeData;
        if (this.jXq == null) {
            this.jXq = new PersonChangeData();
        }
    }

    public PersonChangeData cHo() {
        return this.jXq;
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
