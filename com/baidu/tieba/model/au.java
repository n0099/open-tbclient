package com.baidu.tieba.model;

import com.baidu.tieba.data.PersonChangeData;
/* loaded from: classes.dex */
public class au extends com.baidu.adp.base.e {
    PersonChangeData bpB;

    public au(PersonChangeData personChangeData) {
        super(null);
        this.bpB = null;
        this.bpB = personChangeData;
        if (this.bpB == null) {
            this.bpB = new PersonChangeData();
        }
    }

    public PersonChangeData TT() {
        return this.bpB;
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
