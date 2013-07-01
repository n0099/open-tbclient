package com.baidu.tieba.model;

import com.baidu.tieba.data.PersonChangeData;
/* loaded from: classes.dex */
public class bh extends com.baidu.adp.a.c {

    /* renamed from: a  reason: collision with root package name */
    PersonChangeData f1037a;

    public bh(PersonChangeData personChangeData) {
        this.f1037a = null;
        this.f1037a = personChangeData;
        if (this.f1037a == null) {
            this.f1037a = new PersonChangeData();
        }
    }

    public PersonChangeData a() {
        return this.f1037a;
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
