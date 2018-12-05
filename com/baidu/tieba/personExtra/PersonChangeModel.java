package com.baidu.tieba.personExtra;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
/* loaded from: classes3.dex */
public class PersonChangeModel extends BdBaseModel {
    PersonChangeData gvu;

    public PersonChangeModel(PersonChangeData personChangeData) {
        super(null);
        this.gvu = null;
        this.gvu = personChangeData;
        if (this.gvu == null) {
            this.gvu = new PersonChangeData();
        }
    }

    public PersonChangeData bpF() {
        return this.gvu;
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
