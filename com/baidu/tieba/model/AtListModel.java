package com.baidu.tieba.model;

import com.baidu.tieba.data.FriendData;
import com.baidu.tieba.data.SuggestData;
/* loaded from: classes.dex */
public class AtListModel {
    private FriendData mFriendData = null;
    private SuggestData mSuggestData = null;

    public FriendData getFriendData() {
        return this.mFriendData;
    }

    public void setFriendData(FriendData friendData) {
        this.mFriendData = friendData;
    }

    public SuggestData getSuggestData() {
        return this.mSuggestData;
    }

    public void setSuggestData(SuggestData suggestData) {
        this.mSuggestData = suggestData;
    }
}
