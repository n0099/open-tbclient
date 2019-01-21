package com.baidu.tieba.personExtra;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
/* loaded from: classes3.dex */
public class PersonChangeModel extends BdBaseModel {
    PersonChangeData gzq;

    public PersonChangeModel(PersonChangeData personChangeData) {
        super(null);
        this.gzq = null;
        this.gzq = personChangeData;
        if (this.gzq == null) {
            this.gzq = new PersonChangeData();
        }
    }

    public PersonChangeData bqZ() {
        return this.gzq;
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
