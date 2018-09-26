package com.baidu.tieba.personExtra;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
/* loaded from: classes3.dex */
public class PersonChangeModel extends BdBaseModel {
    PersonChangeData gfD;

    public PersonChangeModel(PersonChangeData personChangeData) {
        super(null);
        this.gfD = null;
        this.gfD = personChangeData;
        if (this.gfD == null) {
            this.gfD = new PersonChangeData();
        }
    }

    public PersonChangeData blg() {
        return this.gfD;
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
