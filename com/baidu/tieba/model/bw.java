package com.baidu.tieba.model;

import com.baidu.tieba.data.PersonChangeData;
/* loaded from: classes.dex */
public class bw extends com.baidu.adp.a.d {

    /* renamed from: a  reason: collision with root package name */
    PersonChangeData f2017a;

    public bw(PersonChangeData personChangeData) {
        this.f2017a = null;
        this.f2017a = personChangeData;
        if (this.f2017a == null) {
            this.f2017a = new PersonChangeData();
        }
    }

    public PersonChangeData a() {
        return this.f2017a;
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
