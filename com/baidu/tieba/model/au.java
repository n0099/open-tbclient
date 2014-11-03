package com.baidu.tieba.model;

import com.baidu.tieba.data.PersonChangeData;
/* loaded from: classes.dex */
public class au extends com.baidu.adp.base.e {
    PersonChangeData bpP;

    public au(PersonChangeData personChangeData) {
        super(null);
        this.bpP = null;
        this.bpP = personChangeData;
        if (this.bpP == null) {
            this.bpP = new PersonChangeData();
        }
    }

    public PersonChangeData TW() {
        return this.bpP;
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
