package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.u;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.data.MyGift;
import java.util.List;
/* loaded from: classes.dex */
public class i implements u {
    public static final BdUniqueId cSb = BdUniqueId.gen();
    private boolean bAA = true;
    private UserData mUserData;

    @Override // com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return cSb;
    }

    public List<MyGift> apr() {
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
        this.bAA = z;
    }

    public boolean getIsSelf() {
        return this.bAA;
    }

    public String getUserId() {
        if (this.mUserData != null) {
            return this.mUserData.getUserId();
        }
        return null;
    }
}
