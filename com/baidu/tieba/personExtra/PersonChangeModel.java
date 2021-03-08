package com.baidu.tieba.personExtra;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
/* loaded from: classes7.dex */
public class PersonChangeModel extends BdBaseModel {
    PersonChangeData mAo;

    public PersonChangeModel(PersonChangeData personChangeData) {
        super(null);
        this.mAo = null;
        this.mAo = personChangeData;
        if (this.mAo == null) {
            this.mAo = new PersonChangeData();
        }
    }

    public PersonChangeData dxY() {
        return this.mAo;
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
