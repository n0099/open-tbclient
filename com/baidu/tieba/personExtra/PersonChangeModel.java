package com.baidu.tieba.personExtra;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
/* loaded from: classes3.dex */
public class PersonChangeModel extends BdBaseModel {
    PersonChangeData gzp;

    public PersonChangeModel(PersonChangeData personChangeData) {
        super(null);
        this.gzp = null;
        this.gzp = personChangeData;
        if (this.gzp == null) {
            this.gzp = new PersonChangeData();
        }
    }

    public PersonChangeData bqZ() {
        return this.gzp;
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
