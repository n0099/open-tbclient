package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.data.MyGroup;
import com.baidu.tieba.personInfo.PersonTainInfo;
import java.util.List;
/* loaded from: classes.dex */
public class k extends a {
    public static final BdUniqueId dbV = BdUniqueId.gen();
    private boolean bDM = true;
    private PersonTainInfo dbW;
    private UserData mUserData;

    @Override // com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return dbV;
    }

    public List<MyGroup> aul() {
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
        this.bDM = z;
    }

    public boolean getIsSelf() {
        return this.bDM;
    }

    public int getSex() {
        if (this.mUserData != null) {
            return this.mUserData.getSex();
        }
        return 0;
    }

    public void a(PersonTainInfo personTainInfo) {
        this.dbW = personTainInfo;
    }

    public PersonTainInfo aum() {
        return this.dbW;
    }

    public com.baidu.tbadk.data.f aun() {
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
