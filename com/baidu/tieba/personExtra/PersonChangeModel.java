package com.baidu.tieba.personExtra;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
/* loaded from: classes18.dex */
public class PersonChangeModel extends BdBaseModel {
    PersonChangeData kTo;

    public PersonChangeModel(PersonChangeData personChangeData) {
        super(null);
        this.kTo = null;
        this.kTo = personChangeData;
        if (this.kTo == null) {
            this.kTo = new PersonChangeData();
        }
    }

    public PersonChangeData cWM() {
        return this.kTo;
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
