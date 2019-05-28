package com.baidu.tieba.personExtra;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
/* loaded from: classes6.dex */
public class PersonChangeModel extends BdBaseModel {
    PersonChangeData ihA;

    public PersonChangeModel(PersonChangeData personChangeData) {
        super(null);
        this.ihA = null;
        this.ihA = personChangeData;
        if (this.ihA == null) {
            this.ihA = new PersonChangeData();
        }
    }

    public PersonChangeData bZs() {
        return this.ihA;
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
