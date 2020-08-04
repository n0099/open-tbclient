package com.baidu.tieba.personExtra;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
/* loaded from: classes18.dex */
public class PersonChangeModel extends BdBaseModel {
    PersonChangeData kTq;

    public PersonChangeModel(PersonChangeData personChangeData) {
        super(null);
        this.kTq = null;
        this.kTq = personChangeData;
        if (this.kTq == null) {
            this.kTq = new PersonChangeData();
        }
    }

    public PersonChangeData cWM() {
        return this.kTq;
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
