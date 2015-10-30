package com.baidu.tieba.person;

import com.baidu.tbadk.coreExtra.data.PersonChangeData;
/* loaded from: classes.dex */
public class au extends com.baidu.adp.base.e {
    PersonChangeData cqf;

    public au(PersonChangeData personChangeData) {
        super(null);
        this.cqf = null;
        this.cqf = personChangeData;
        if (this.cqf == null) {
            this.cqf = new PersonChangeData();
        }
    }

    public PersonChangeData aiA() {
        return this.cqf;
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
