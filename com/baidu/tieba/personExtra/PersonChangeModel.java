package com.baidu.tieba.personExtra;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
/* loaded from: classes3.dex */
public class PersonChangeModel extends BdBaseModel {
    PersonChangeData gnf;

    public PersonChangeModel(PersonChangeData personChangeData) {
        super(null);
        this.gnf = null;
        this.gnf = personChangeData;
        if (this.gnf == null) {
            this.gnf = new PersonChangeData();
        }
    }

    public PersonChangeData bor() {
        return this.gnf;
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
