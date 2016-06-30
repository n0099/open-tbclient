package com.baidu.tieba.person;

import com.baidu.tbadk.coreExtra.data.PersonChangeData;
/* loaded from: classes.dex */
public class ax extends com.baidu.adp.base.e {
    PersonChangeData eeY;

    public ax(PersonChangeData personChangeData) {
        super(null);
        this.eeY = null;
        this.eeY = personChangeData;
        if (this.eeY == null) {
            this.eeY = new PersonChangeData();
        }
    }

    public PersonChangeData aKK() {
        return this.eeY;
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
