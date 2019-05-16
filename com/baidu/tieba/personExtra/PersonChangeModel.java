package com.baidu.tieba.personExtra;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
/* loaded from: classes6.dex */
public class PersonChangeModel extends BdBaseModel {
    PersonChangeData ihx;

    public PersonChangeModel(PersonChangeData personChangeData) {
        super(null);
        this.ihx = null;
        this.ihx = personChangeData;
        if (this.ihx == null) {
            this.ihx = new PersonChangeData();
        }
    }

    public PersonChangeData bZp() {
        return this.ihx;
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
