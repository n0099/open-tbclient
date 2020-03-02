package com.baidu.tieba.personExtra;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
/* loaded from: classes11.dex */
public class PersonChangeModel extends BdBaseModel {
    PersonChangeData jlm;

    public PersonChangeModel(PersonChangeData personChangeData) {
        super(null);
        this.jlm = null;
        this.jlm = personChangeData;
        if (this.jlm == null) {
            this.jlm = new PersonChangeData();
        }
    }

    public PersonChangeData cwm() {
        return this.jlm;
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
