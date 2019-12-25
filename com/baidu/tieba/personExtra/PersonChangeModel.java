package com.baidu.tieba.personExtra;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
/* loaded from: classes8.dex */
public class PersonChangeModel extends BdBaseModel {
    PersonChangeData jgJ;

    public PersonChangeModel(PersonChangeData personChangeData) {
        super(null);
        this.jgJ = null;
        this.jgJ = personChangeData;
        if (this.jgJ == null) {
            this.jgJ = new PersonChangeData();
        }
    }

    public PersonChangeData ctI() {
        return this.jgJ;
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
