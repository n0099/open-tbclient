package com.baidu.tieba.setting.model;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
/* loaded from: classes4.dex */
public class MoreModel extends BdBaseModel {

    /* renamed from: e  reason: collision with root package name */
    public PersonChangeData f20678e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f20679f;

    /* loaded from: classes4.dex */
    public enum TaskType {
        DO_CACHE_CLEAR,
        GET_SIZE
    }

    public MoreModel(PersonChangeData personChangeData) {
        super(null);
        this.f20678e = null;
        this.f20679f = false;
        this.f20678e = personChangeData;
        if (personChangeData == null) {
            this.f20678e = new PersonChangeData();
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
        return this.f20678e;
    }

    public boolean t() {
        return this.f20679f;
    }

    public void u(PersonChangeData personChangeData) {
        this.f20678e = personChangeData;
    }

    public void v(boolean z) {
        this.f20679f = z;
    }
}
