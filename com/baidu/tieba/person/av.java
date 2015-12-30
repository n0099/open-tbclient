package com.baidu.tieba.person;

import com.baidu.tbadk.coreExtra.data.PersonChangeData;
/* loaded from: classes.dex */
public class av extends com.baidu.adp.base.e {
    PersonChangeData cPl;

    public av(PersonChangeData personChangeData) {
        super(null);
        this.cPl = null;
        this.cPl = personChangeData;
        if (this.cPl == null) {
            this.cPl = new PersonChangeData();
        }
    }

    public PersonChangeData aoU() {
        return this.cPl;
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
