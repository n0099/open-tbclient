package com.baidu.tieba.personExtra;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
/* loaded from: classes3.dex */
public class PersonChangeModel extends BdBaseModel {
    PersonChangeData gmT;

    public PersonChangeModel(PersonChangeData personChangeData) {
        super(null);
        this.gmT = null;
        this.gmT = personChangeData;
        if (this.gmT == null) {
            this.gmT = new PersonChangeData();
        }
    }

    public PersonChangeData bjH() {
        return this.gmT;
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
