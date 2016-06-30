package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.data.MyGift;
import java.util.List;
/* loaded from: classes.dex */
public class j implements com.baidu.adp.widget.ListView.v {
    public static final BdUniqueId eia = BdUniqueId.gen();
    private boolean chd = true;
    private boolean eib = false;
    private UserData mUserData;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return eia;
    }

    public List<MyGift> aLd() {
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
        this.chd = z;
    }

    public boolean getIsSelf() {
        return this.chd;
    }

    public String getUserId() {
        if (this.mUserData != null) {
            return this.mUserData.getUserId();
        }
        return null;
    }

    public boolean aLe() {
        return this.eib;
    }

    public void ij(boolean z) {
        this.eib = z;
    }
}
