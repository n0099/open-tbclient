package com.baidu.tieba.personExtra;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
/* loaded from: classes3.dex */
public class PersonChangeModel extends BdBaseModel {
    PersonChangeData gmI;

    public PersonChangeModel(PersonChangeData personChangeData) {
        super(null);
        this.gmI = null;
        this.gmI = personChangeData;
        if (this.gmI == null) {
            this.gmI = new PersonChangeData();
        }
    }

    public PersonChangeData bjG() {
        return this.gmI;
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
