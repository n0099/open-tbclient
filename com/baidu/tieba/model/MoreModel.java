package com.baidu.tieba.model;

import com.baidu.tieba.data.PersonChangeData;
/* loaded from: classes.dex */
public class MoreModel extends com.baidu.adp.a.d {

    /* renamed from: a  reason: collision with root package name */
    private PersonChangeData f1973a;
    private boolean b = false;

    /* loaded from: classes.dex */
    public enum TaskType {
        DO_CLEAR
    }

    public MoreModel(PersonChangeData personChangeData) {
        this.f1973a = null;
        this.f1973a = personChangeData;
        if (this.f1973a == null) {
            this.f1973a = new PersonChangeData();
        }
    }

    public void a(PersonChangeData personChangeData) {
        this.f1973a = personChangeData;
    }

    public void a(boolean z) {
        this.b = z;
    }

    public boolean a() {
        return this.b;
    }

    @Override // com.baidu.adp.a.d
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.a.d
    public boolean cancelLoadData() {
        return false;
    }

    public PersonChangeData b() {
        return this.f1973a;
    }
}
