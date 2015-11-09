package com.baidu.tieba.person;

import com.baidu.tbadk.coreExtra.data.PersonChangeData;
/* loaded from: classes.dex */
public class au extends com.baidu.adp.base.e {
    PersonChangeData crB;

    public au(PersonChangeData personChangeData) {
        super(null);
        this.crB = null;
        this.crB = personChangeData;
        if (this.crB == null) {
            this.crB = new PersonChangeData();
        }
    }

    public PersonChangeData ajg() {
        return this.crB;
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
