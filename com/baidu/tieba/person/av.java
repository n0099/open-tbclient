package com.baidu.tieba.person;

import com.baidu.tbadk.coreExtra.data.PersonChangeData;
/* loaded from: classes.dex */
public class av extends com.baidu.adp.base.e {
    PersonChangeData cKV;

    public av(PersonChangeData personChangeData) {
        super(null);
        this.cKV = null;
        this.cKV = personChangeData;
        if (this.cKV == null) {
            this.cKV = new PersonChangeData();
        }
    }

    public PersonChangeData anJ() {
        return this.cKV;
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
