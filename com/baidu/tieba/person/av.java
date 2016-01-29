package com.baidu.tieba.person;

import com.baidu.tbadk.coreExtra.data.PersonChangeData;
/* loaded from: classes.dex */
public class av extends com.baidu.adp.base.e {
    PersonChangeData cYI;

    public av(PersonChangeData personChangeData) {
        super(null);
        this.cYI = null;
        this.cYI = personChangeData;
        if (this.cYI == null) {
            this.cYI = new PersonChangeData();
        }
    }

    public PersonChangeData atN() {
        return this.cYI;
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
