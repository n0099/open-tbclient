package com.baidu.tieba.person;

import com.baidu.tbadk.coreExtra.data.PersonChangeData;
/* loaded from: classes.dex */
public class aw extends com.baidu.adp.base.e {
    PersonChangeData dwG;

    public aw(PersonChangeData personChangeData) {
        super(null);
        this.dwG = null;
        this.dwG = personChangeData;
        if (this.dwG == null) {
            this.dwG = new PersonChangeData();
        }
    }

    public PersonChangeData aBP() {
        return this.dwG;
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
