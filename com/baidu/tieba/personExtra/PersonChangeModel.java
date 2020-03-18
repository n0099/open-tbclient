package com.baidu.tieba.personExtra;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
/* loaded from: classes11.dex */
public class PersonChangeModel extends BdBaseModel {
    PersonChangeData jmY;

    public PersonChangeModel(PersonChangeData personChangeData) {
        super(null);
        this.jmY = null;
        this.jmY = personChangeData;
        if (this.jmY == null) {
            this.jmY = new PersonChangeData();
        }
    }

    public PersonChangeData cwG() {
        return this.jmY;
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
