package com.baidu.tieba.personExtra;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
/* loaded from: classes6.dex */
public class PersonChangeModel extends BdBaseModel {
    PersonChangeData ioF;

    public PersonChangeModel(PersonChangeData personChangeData) {
        super(null);
        this.ioF = null;
        this.ioF = personChangeData;
        if (this.ioF == null) {
            this.ioF = new PersonChangeData();
        }
    }

    public PersonChangeData can() {
        return this.ioF;
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
