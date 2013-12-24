package com.baidu.tieba.model;

import com.baidu.tieba.data.PersonChangeData;
/* loaded from: classes.dex */
public class MoreModel extends com.baidu.adp.a.d {
    private PersonChangeData a;
    private boolean b = false;

    /* loaded from: classes.dex */
    public enum TaskType {
        DO_CLEAR
    }

    public MoreModel(PersonChangeData personChangeData) {
        this.a = null;
        this.a = personChangeData;
        if (this.a == null) {
            this.a = new PersonChangeData();
        }
    }

    public void a(PersonChangeData personChangeData) {
        this.a = personChangeData;
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
        return this.a;
    }
}
