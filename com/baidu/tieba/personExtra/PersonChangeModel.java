package com.baidu.tieba.personExtra;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
/* loaded from: classes3.dex */
public class PersonChangeModel extends BdBaseModel {
    PersonChangeData gyl;

    public PersonChangeModel(PersonChangeData personChangeData) {
        super(null);
        this.gyl = null;
        this.gyl = personChangeData;
        if (this.gyl == null) {
            this.gyl = new PersonChangeData();
        }
    }

    public PersonChangeData bqq() {
        return this.gyl;
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
