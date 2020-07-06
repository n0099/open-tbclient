package com.baidu.tieba.personExtra;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
/* loaded from: classes11.dex */
public class PersonChangeModel extends BdBaseModel {
    PersonChangeData kKn;

    public PersonChangeModel(PersonChangeData personChangeData) {
        super(null);
        this.kKn = null;
        this.kKn = personChangeData;
        if (this.kKn == null) {
            this.kKn = new PersonChangeData();
        }
    }

    public PersonChangeData cSW() {
        return this.kKn;
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
