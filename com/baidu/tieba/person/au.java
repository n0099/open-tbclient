package com.baidu.tieba.person;

import com.baidu.tbadk.coreExtra.data.PersonChangeData;
/* loaded from: classes.dex */
public class au extends com.baidu.adp.base.e {
    PersonChangeData cpU;

    public au(PersonChangeData personChangeData) {
        super(null);
        this.cpU = null;
        this.cpU = personChangeData;
        if (this.cpU == null) {
            this.cpU = new PersonChangeData();
        }
    }

    public PersonChangeData aiE() {
        return this.cpU;
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        return false;
    }
}
