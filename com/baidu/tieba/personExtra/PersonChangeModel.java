package com.baidu.tieba.personExtra;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
/* loaded from: classes7.dex */
public class PersonChangeModel extends BdBaseModel {
    PersonChangeData moX;

    public PersonChangeModel(PersonChangeData personChangeData) {
        super(null);
        this.moX = null;
        this.moX = personChangeData;
        if (this.moX == null) {
            this.moX = new PersonChangeData();
        }
    }

    public PersonChangeData dvz() {
        return this.moX;
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
