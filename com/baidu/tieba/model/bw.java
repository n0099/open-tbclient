package com.baidu.tieba.model;

import com.baidu.tieba.data.PersonChangeData;
/* loaded from: classes.dex */
public class bw extends com.baidu.adp.a.d {
    PersonChangeData a;

    public bw(PersonChangeData personChangeData) {
        this.a = null;
        this.a = personChangeData;
        if (this.a == null) {
            this.a = new PersonChangeData();
        }
    }

    public PersonChangeData a() {
        return this.a;
    }

    @Override // com.baidu.adp.a.d
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.a.d
    public boolean cancelLoadData() {
        return false;
    }
}
