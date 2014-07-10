package com.baidu.tieba.person;

import com.baidu.tieba.person.PersonPostListData;
/* loaded from: classes.dex */
public class PersonCenterListTopData extends PersonPostListData.PostList {
    private static final long serialVersionUID = 1;
    private int mDataType;
    private com.baidu.tieba.model.au mModel;

    public PersonCenterListTopData(com.baidu.tieba.model.au auVar, int i) {
        this.mModel = auVar;
        this.mDataType = i;
    }

    public com.baidu.tieba.model.au getmModel() {
        return this.mModel;
    }

    public void setmModel(com.baidu.tieba.model.au auVar) {
        this.mModel = auVar;
    }

    public int getmDataType() {
        return this.mDataType;
    }

    public void setmDataType(int i) {
        this.mDataType = i;
    }
}
