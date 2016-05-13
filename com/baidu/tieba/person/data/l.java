package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.data.MyGroup;
import com.baidu.tieba.personInfo.PersonTainInfo;
import java.util.List;
/* loaded from: classes.dex */
public class l extends a {
    public static final BdUniqueId dzC = BdUniqueId.gen();
    private boolean bJq = true;
    private PersonTainInfo dzD;
    private UserData mUserData;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return dzC;
    }

    public List<MyGroup> aCm() {
        if (this.mUserData != null) {
            return this.mUserData.getGroup();
        }
        return null;
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

    public int getSex() {
        if (this.mUserData != null) {
            return this.mUserData.getSex();
        }
        return 0;
    }

    public void a(PersonTainInfo personTainInfo) {
        this.dzD = personTainInfo;
    }

    public PersonTainInfo aCn() {
        return this.dzD;
    }

    public com.baidu.tbadk.data.h aCo() {
        if (this.mUserData != null) {
            return this.mUserData.getPersonPrivate();
        }
        return null;
    }

    public String getUserId() {
        if (this.mUserData != null) {
            return this.mUserData.getUserId();
        }
        return null;
    }
}
