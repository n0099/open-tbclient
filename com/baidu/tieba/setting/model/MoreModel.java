package com.baidu.tieba.setting.model;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
/* loaded from: classes5.dex */
public class MoreModel extends BdBaseModel {

    /* renamed from: e  reason: collision with root package name */
    public PersonChangeData f21233e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f21234f;

    /* loaded from: classes5.dex */
    public enum TaskType {
        DO_CACHE_CLEAR,
        GET_SIZE
    }

    public MoreModel(PersonChangeData personChangeData) {
        super(null);
        this.f21233e = null;
        this.f21234f = false;
        this.f21233e = personChangeData;
        if (personChangeData == null) {
            this.f21233e = new PersonChangeData();
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
        return this.f21233e;
    }

    public boolean t() {
        return this.f21234f;
    }

    public void u(PersonChangeData personChangeData) {
        this.f21233e = personChangeData;
    }

    public void v(boolean z) {
        this.f21234f = z;
    }
}
