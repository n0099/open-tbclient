package com.baidu.tieba.model;

import com.baidu.tieba.data.PersonChangeData;
/* loaded from: classes.dex */
public class MoreModel extends com.baidu.adp.a.c {
    private PersonChangeData b;

    /* renamed from: a  reason: collision with root package name */
    private az f1315a = null;
    private boolean c = false;

    /* loaded from: classes.dex */
    public enum TaskType {
        DO_CLEAR;

        /* JADX DEBUG: Replace access to removed values field (a) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static TaskType[] valuesCustom() {
            TaskType[] valuesCustom = values();
            int length = valuesCustom.length;
            TaskType[] taskTypeArr = new TaskType[length];
            System.arraycopy(valuesCustom, 0, taskTypeArr, 0, length);
            return taskTypeArr;
        }
    }

    public MoreModel(PersonChangeData personChangeData) {
        this.b = null;
        this.b = personChangeData;
        if (this.b == null) {
            this.b = new PersonChangeData();
        }
    }

    public void a(PersonChangeData personChangeData) {
        this.b = personChangeData;
    }

    public void a(boolean z) {
        this.c = z;
    }

    public boolean a() {
        return this.c;
    }

    @Override // com.baidu.adp.a.c
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.a.c
    public boolean cancelLoadData() {
        return false;
    }

    public void b() {
        if (this.f1315a == null) {
            this.f1315a = new az(this, null);
            this.f1315a.execute(new String[0]);
        }
    }

    public PersonChangeData c() {
        return this.b;
    }
}
