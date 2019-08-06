package com.baidu.tieba.personExtra;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
/* loaded from: classes6.dex */
public class PersonChangeModel extends BdBaseModel {
    PersonChangeData ioX;

    public PersonChangeModel(PersonChangeData personChangeData) {
        super(null);
        this.ioX = null;
        this.ioX = personChangeData;
        if (this.ioX == null) {
            this.ioX = new PersonChangeData();
        }
    }

    public PersonChangeData ccA() {
        return this.ioX;
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
