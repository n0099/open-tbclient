package com.baidu.tieba.personExtra;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
/* loaded from: classes3.dex */
public class PersonChangeModel extends BdBaseModel {
    PersonChangeData gne;

    public PersonChangeModel(PersonChangeData personChangeData) {
        super(null);
        this.gne = null;
        this.gne = personChangeData;
        if (this.gne == null) {
            this.gne = new PersonChangeData();
        }
    }

    public PersonChangeData bor() {
        return this.gne;
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
