package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.data.MyGroup;
import com.baidu.tieba.personInfo.PersonTainInfo;
import java.util.List;
/* loaded from: classes.dex */
public class k extends a {
    public static final BdUniqueId dwy = BdUniqueId.gen();
    private boolean bJj = true;
    private PersonTainInfo dwz;
    private UserData mUserData;

    @Override // com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return dwy;
    }

    public List<MyGroup> aBR() {
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
        this.bJj = z;
    }

    public boolean getIsSelf() {
        return this.bJj;
    }

    public int getSex() {
        if (this.mUserData != null) {
            return this.mUserData.getSex();
        }
        return 0;
    }

    public void a(PersonTainInfo personTainInfo) {
        this.dwz = personTainInfo;
    }

    public PersonTainInfo aBS() {
        return this.dwz;
    }

    public com.baidu.tbadk.data.g aBT() {
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
