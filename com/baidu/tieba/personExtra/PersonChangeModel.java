package com.baidu.tieba.personExtra;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
/* loaded from: classes5.dex */
public class PersonChangeModel extends BdBaseModel {

    /* renamed from: e  reason: collision with root package name */
    public PersonChangeData f19852e;

    public PersonChangeModel(PersonChangeData personChangeData) {
        super(null);
        this.f19852e = null;
        this.f19852e = personChangeData;
        if (personChangeData == null) {
            this.f19852e = new PersonChangeData();
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public PersonChangeData s() {
        return this.f19852e;
    }
}
