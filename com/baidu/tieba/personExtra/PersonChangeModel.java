package com.baidu.tieba.personExtra;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
/* loaded from: classes23.dex */
public class PersonChangeModel extends BdBaseModel {
    PersonChangeData lsj;

    public PersonChangeModel(PersonChangeData personChangeData) {
        super(null);
        this.lsj = null;
        this.lsj = personChangeData;
        if (this.lsj == null) {
            this.lsj = new PersonChangeData();
        }
    }

    public PersonChangeData dlp() {
        return this.lsj;
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
