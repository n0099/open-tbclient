package com.baidu.tieba.person;

import com.baidu.tbadk.coreExtra.data.PersonChangeData;
/* loaded from: classes.dex */
public class av extends com.baidu.adp.base.e {
    PersonChangeData dtk;

    public av(PersonChangeData personChangeData) {
        super(null);
        this.dtk = null;
        this.dtk = personChangeData;
        if (this.dtk == null) {
            this.dtk = new PersonChangeData();
        }
    }

    public PersonChangeData aBt() {
        return this.dtk;
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
