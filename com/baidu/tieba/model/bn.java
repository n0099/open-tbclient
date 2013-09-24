package com.baidu.tieba.model;

import com.baidu.tieba.data.PersonChangeData;
/* loaded from: classes.dex */
public class bn extends com.baidu.adp.a.c {

    /* renamed from: a  reason: collision with root package name */
    PersonChangeData f1423a;

    public bn(PersonChangeData personChangeData) {
        this.f1423a = null;
        this.f1423a = personChangeData;
        if (this.f1423a == null) {
            this.f1423a = new PersonChangeData();
        }
    }

    public PersonChangeData a() {
        return this.f1423a;
    }

    @Override // com.baidu.adp.a.c
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.a.c
    public boolean cancelLoadData() {
        return false;
    }
}
