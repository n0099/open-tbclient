package com.baidu.tieba.person;

import com.baidu.tieba.person.PersonPostListData;
/* loaded from: classes.dex */
public class PersonCenterListTopData extends PersonPostListData.PostList {
    private static final long serialVersionUID = 1;
    private int mDataType;
    private com.baidu.tieba.model.av mModel;

    public PersonCenterListTopData(com.baidu.tieba.model.av avVar, int i) {
        this.mModel = avVar;
        this.mDataType = i;
    }

    public com.baidu.tieba.model.av getmModel() {
        return this.mModel;
    }

    public void setmModel(com.baidu.tieba.model.av avVar) {
        this.mModel = avVar;
    }

    public int getmDataType() {
        return this.mDataType;
    }

    public void setmDataType(int i) {
        this.mDataType = i;
    }
}
