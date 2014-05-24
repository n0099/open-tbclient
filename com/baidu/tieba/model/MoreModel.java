package com.baidu.tieba.model;

import com.baidu.tieba.data.PersonChangeData;
/* loaded from: classes.dex */
public class MoreModel extends com.baidu.adp.base.b {
    private PersonChangeData a;
    private boolean b = false;

    /* loaded from: classes.dex */
    public enum TaskType {
        DO_CACHE_CLEAR,
        GET_SIZE,
        DO_IM_CLEAR;

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

    @Override // com.baidu.adp.base.b
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.b
    public boolean cancelLoadData() {
        return false;
    }

    public PersonChangeData b() {
        return this.a;
    }
}
