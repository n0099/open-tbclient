package com.baidu.tieba.personExtra;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
/* loaded from: classes11.dex */
public class PersonChangeModel extends BdBaseModel {
    PersonChangeData jlk;

    public PersonChangeModel(PersonChangeData personChangeData) {
        super(null);
        this.jlk = null;
        this.jlk = personChangeData;
        if (this.jlk == null) {
            this.jlk = new PersonChangeData();
        }
    }

    public PersonChangeData cwk() {
        return this.jlk;
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
