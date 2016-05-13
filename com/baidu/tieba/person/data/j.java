package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.data.MyGift;
import java.util.List;
/* loaded from: classes.dex */
public class j implements v {
    public static final BdUniqueId dzw = BdUniqueId.gen();
    private boolean bJq = true;
    private boolean dzx = false;
    private UserData mUserData;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return dzw;
    }

    public List<MyGift> aCk() {
        if (this.mUserData != null) {
            return this.mUserData.getGift();
        }
        return null;
    }

    public int getSex() {
        if (this.mUserData != null) {
            return this.mUserData.getSex();
        }
        return 0;
    }

    public int getGiftNum() {
        if (this.mUserData != null) {
            return this.mUserData.getGiftNum();
        }
        return 0;
    }

    public void f(UserData userData) {
        this.mUserData = userData;
    }

    public UserData getUserData() {
        return this.mUserData;
    }

    public void setIsSelf(boolean z) {
        this.bJq = z;
    }

    public boolean getIsSelf() {
        return this.bJq;
    }

    public String getUserId() {
        if (this.mUserData != null) {
            return this.mUserData.getUserId();
        }
        return null;
    }

    public boolean aCl() {
        return this.dzx;
    }

    public void ho(boolean z) {
        this.dzx = z;
    }
}
