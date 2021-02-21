package com.baidu.tieba.setting.model;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
/* loaded from: classes8.dex */
public class MoreModel extends BdBaseModel {
    private PersonChangeData mAX;
    private boolean nfl;

    /* loaded from: classes8.dex */
    public enum TaskType {
        DO_CACHE_CLEAR,
        GET_SIZE
    }

    public MoreModel(PersonChangeData personChangeData) {
        super(null);
        this.mAX = null;
        this.nfl = false;
        this.mAX = personChangeData;
        if (this.mAX == null) {
            this.mAX = new PersonChangeData();
        }
    }

    public void b(PersonChangeData personChangeData) {
        this.mAX = personChangeData;
    }

    public void xN(boolean z) {
        this.nfl = z;
    }

    public boolean dGA() {
        return this.nfl;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public PersonChangeData dGB() {
        return this.mAX;
    }
}
