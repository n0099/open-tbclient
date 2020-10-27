package com.baidu.tieba.personExtra;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
/* loaded from: classes24.dex */
public class PersonChangeModel extends BdBaseModel {
    PersonChangeData lTS;

    public PersonChangeModel(PersonChangeData personChangeData) {
        super(null);
        this.lTS = null;
        this.lTS = personChangeData;
        if (this.lTS == null) {
            this.lTS = new PersonChangeData();
        }
    }

    public PersonChangeData dsg() {
        return this.lTS;
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
