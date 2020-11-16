package com.baidu.tieba.personExtra;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
/* loaded from: classes23.dex */
public class PersonChangeModel extends BdBaseModel {
    PersonChangeData mah;

    public PersonChangeModel(PersonChangeData personChangeData) {
        super(null);
        this.mah = null;
        this.mah = personChangeData;
        if (this.mah == null) {
            this.mah = new PersonChangeData();
        }
    }

    public PersonChangeData dui() {
        return this.mah;
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
