package com.baidu.tieba.model;

import com.baidu.tieba.data.PersonChangeData;
/* loaded from: classes.dex */
public class bl extends com.baidu.adp.a.c {

    /* renamed from: a  reason: collision with root package name */
    PersonChangeData f1386a;

    public bl(PersonChangeData personChangeData) {
        this.f1386a = null;
        this.f1386a = personChangeData;
        if (this.f1386a == null) {
            this.f1386a = new PersonChangeData();
        }
    }

    public PersonChangeData a() {
        return this.f1386a;
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
