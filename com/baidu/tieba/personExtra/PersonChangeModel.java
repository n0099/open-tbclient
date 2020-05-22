package com.baidu.tieba.personExtra;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
/* loaded from: classes11.dex */
public class PersonChangeModel extends BdBaseModel {
    PersonChangeData kpj;

    public PersonChangeModel(PersonChangeData personChangeData) {
        super(null);
        this.kpj = null;
        this.kpj = personChangeData;
        if (this.kpj == null) {
            this.kpj = new PersonChangeData();
        }
    }

    public PersonChangeData cOo() {
        return this.kpj;
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
