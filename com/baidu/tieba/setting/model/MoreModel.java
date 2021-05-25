package com.baidu.tieba.setting.model;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
/* loaded from: classes5.dex */
public class MoreModel extends BdBaseModel {

    /* renamed from: e  reason: collision with root package name */
    public PersonChangeData f20397e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f20398f;

    /* loaded from: classes5.dex */
    public enum TaskType {
        DO_CACHE_CLEAR,
        GET_SIZE
    }

    public MoreModel(PersonChangeData personChangeData) {
        super(null);
        this.f20397e = null;
        this.f20398f = false;
        this.f20397e = personChangeData;
        if (personChangeData == null) {
            this.f20397e = new PersonChangeData();
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
        return this.f20397e;
    }

    public boolean t() {
        return this.f20398f;
    }

    public void u(PersonChangeData personChangeData) {
        this.f20397e = personChangeData;
    }

    public void v(boolean z) {
        this.f20398f = z;
    }
}
