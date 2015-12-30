package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.data.MyGroup;
import com.baidu.tieba.personInfo.PersonTainInfo;
import java.util.List;
/* loaded from: classes.dex */
public class j extends a {
    public static final BdUniqueId cSc = BdUniqueId.gen();
    private boolean bAA = true;
    private PersonTainInfo cSd;
    private UserData mUserData;

    @Override // com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return cSc;
    }

    public List<MyGroup> aps() {
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
        this.bAA = z;
    }

    public boolean getIsSelf() {
        return this.bAA;
    }

    public int getSex() {
        if (this.mUserData != null) {
            return this.mUserData.getSex();
        }
        return 0;
    }

    public void a(PersonTainInfo personTainInfo) {
        this.cSd = personTainInfo;
    }

    public PersonTainInfo apt() {
        return this.cSd;
    }

    public com.baidu.tbadk.data.f apu() {
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
