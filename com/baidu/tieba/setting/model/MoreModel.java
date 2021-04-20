package com.baidu.tieba.setting.model;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
/* loaded from: classes4.dex */
public class MoreModel extends BdBaseModel {

    /* renamed from: e  reason: collision with root package name */
    public PersonChangeData f20670e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f20671f;

    /* loaded from: classes4.dex */
    public enum TaskType {
        DO_CACHE_CLEAR,
        GET_SIZE
    }

    public MoreModel(PersonChangeData personChangeData) {
        super(null);
        this.f20670e = null;
        this.f20671f = false;
        this.f20670e = personChangeData;
        if (personChangeData == null) {
            this.f20670e = new PersonChangeData();
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public PersonChangeData s() {
        return this.f20670e;
    }

    public boolean t() {
        return this.f20671f;
    }

    public void u(PersonChangeData personChangeData) {
        this.f20670e = personChangeData;
    }

    public void v(boolean z) {
        this.f20671f = z;
    }
}
