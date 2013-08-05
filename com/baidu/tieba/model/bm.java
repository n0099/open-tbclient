package com.baidu.tieba.model;

import com.baidu.tieba.data.PersonChangeData;
/* loaded from: classes.dex */
public class bm extends com.baidu.adp.a.c {

    /* renamed from: a  reason: collision with root package name */
    PersonChangeData f1354a;

    public bm(PersonChangeData personChangeData) {
        this.f1354a = null;
        this.f1354a = personChangeData;
        if (this.f1354a == null) {
            this.f1354a = new PersonChangeData();
        }
    }

    public PersonChangeData a() {
        return this.f1354a;
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
