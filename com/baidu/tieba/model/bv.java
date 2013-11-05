package com.baidu.tieba.model;

import com.baidu.tieba.data.PersonChangeData;
/* loaded from: classes.dex */
public class bv extends com.baidu.adp.a.d {

    /* renamed from: a  reason: collision with root package name */
    PersonChangeData f1926a;

    public bv(PersonChangeData personChangeData) {
        this.f1926a = null;
        this.f1926a = personChangeData;
        if (this.f1926a == null) {
            this.f1926a = new PersonChangeData();
        }
    }

    public PersonChangeData a() {
        return this.f1926a;
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
