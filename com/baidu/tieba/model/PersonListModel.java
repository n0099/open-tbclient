package com.baidu.tieba.model;

import com.baidu.tieba.data.PersonListData;
/* loaded from: classes.dex */
public class PersonListModel {
    private PersonListData mData = new PersonListData();
    private boolean mIsFollow = true;
    private String mId = null;

    public void setId(String id) {
        this.mId = id;
    }

    public String getId() {
        return this.mId;
    }

    public void setIsFollow(boolean isFollow) {
        this.mIsFollow = isFollow;
    }

    public boolean getIsFollow() {
        return this.mIsFollow;
    }

    public void setData(PersonListData data) {
        this.mData = data;
    }

    public PersonListData getData() {
        return this.mData;
    }
}
