package com.baidu.tieba.model;

import com.baidu.tieba.data.PersonChangeData;
/* loaded from: classes.dex */
public final class au extends com.baidu.adp.a.e {
    PersonChangeData a;

    public au(PersonChangeData personChangeData) {
        this.a = null;
        this.a = personChangeData;
        if (this.a == null) {
            this.a = new PersonChangeData();
        }
    }

    public final PersonChangeData a() {
        return this.a;
    }

    @Override // com.baidu.adp.a.e
    protected final boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.a.e
    public final boolean cancelLoadData() {
        return false;
    }
}
