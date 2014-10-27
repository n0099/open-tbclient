package com.baidu.tieba.model;

import com.baidu.tieba.data.PersonChangeData;
/* loaded from: classes.dex */
public class MoreModel extends com.baidu.adp.base.e {
    private PersonChangeData adR;
    private boolean bpn;

    /* loaded from: classes.dex */
    public enum TaskType {
        DO_CACHE_CLEAR,
        GET_SIZE;

        /* JADX DEBUG: Replace access to removed values field (bpo) with 'values()' method */
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
        super(null);
        this.adR = null;
        this.bpn = false;
        this.adR = personChangeData;
        if (this.adR == null) {
            this.adR = new PersonChangeData();
        }
    }

    public void a(PersonChangeData personChangeData) {
        this.adR = personChangeData;
    }

    public void dG(boolean z) {
        this.bpn = z;
    }

    public boolean TM() {
        return this.bpn;
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        return false;
    }

    public PersonChangeData TN() {
        return this.adR;
    }
}
