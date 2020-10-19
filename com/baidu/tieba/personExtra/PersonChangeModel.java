package com.baidu.tieba.personExtra;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
/* loaded from: classes24.dex */
public class PersonChangeModel extends BdBaseModel {
    PersonChangeData lHw;

    public PersonChangeModel(PersonChangeData personChangeData) {
        super(null);
        this.lHw = null;
        this.lHw = personChangeData;
        if (this.lHw == null) {
            this.lHw = new PersonChangeData();
        }
    }

    public PersonChangeData doZ() {
        return this.lHw;
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
