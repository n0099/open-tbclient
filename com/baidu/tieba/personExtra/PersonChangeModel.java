package com.baidu.tieba.personExtra;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
/* loaded from: classes3.dex */
public class PersonChangeModel extends BdBaseModel {
    PersonChangeData fIy;

    public PersonChangeModel(PersonChangeData personChangeData) {
        super(null);
        this.fIy = null;
        this.fIy = personChangeData;
        if (this.fIy == null) {
            this.fIy = new PersonChangeData();
        }
    }

    public PersonChangeData beJ() {
        return this.fIy;
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
