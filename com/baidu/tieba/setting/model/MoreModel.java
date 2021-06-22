package com.baidu.tieba.setting.model;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
/* loaded from: classes5.dex */
public class MoreModel extends BdBaseModel {

    /* renamed from: e  reason: collision with root package name */
    public PersonChangeData f20556e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f20557f;

    /* loaded from: classes5.dex */
    public enum TaskType {
        DO_CACHE_CLEAR,
        GET_SIZE
    }

    public MoreModel(PersonChangeData personChangeData) {
        super(null);
        this.f20556e = null;
        this.f20557f = false;
        this.f20556e = personChangeData;
        if (personChangeData == null) {
            this.f20556e = new PersonChangeData();
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

    public PersonChangeData w() {
        return this.f20556e;
    }

    public boolean x() {
        return this.f20557f;
    }

    public void y(PersonChangeData personChangeData) {
        this.f20556e = personChangeData;
    }

    public void z(boolean z) {
        this.f20557f = z;
    }
}
