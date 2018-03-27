package com.baidu.tieba.personExtra;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
/* loaded from: classes3.dex */
public class PersonChangeModel extends BdBaseModel {
    PersonChangeData gmY;

    public PersonChangeModel(PersonChangeData personChangeData) {
        super(null);
        this.gmY = null;
        this.gmY = personChangeData;
        if (this.gmY == null) {
            this.gmY = new PersonChangeData();
        }
    }

    public PersonChangeData bjH() {
        return this.gmY;
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
