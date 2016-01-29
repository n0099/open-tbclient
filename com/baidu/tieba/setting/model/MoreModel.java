package com.baidu.tieba.setting.model;

import com.baidu.tbadk.coreExtra.data.PersonChangeData;
/* loaded from: classes.dex */
public class MoreModel extends com.baidu.adp.base.e {
    private boolean dIU;
    private PersonChangeData mPersonChangeData;

    /* loaded from: classes.dex */
    public enum TaskType {
        DO_CACHE_CLEAR,
        GET_SIZE;

        /* JADX DEBUG: Replace access to removed values field (dIV) with 'values()' method */
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
        this.mPersonChangeData = null;
        this.dIU = false;
        this.mPersonChangeData = personChangeData;
        if (this.mPersonChangeData == null) {
            this.mPersonChangeData = new PersonChangeData();
        }
    }

    public void setPersonChangeData(PersonChangeData personChangeData) {
        this.mPersonChangeData = personChangeData;
    }

    public void hy(boolean z) {
        this.dIU = z;
    }

    public boolean aGD() {
        return this.dIU;
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        return false;
    }

    public PersonChangeData getPersonChangeData() {
        return this.mPersonChangeData;
    }
}
