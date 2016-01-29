package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.u;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.personInfo.PersonTainInfo;
/* loaded from: classes.dex */
public class n implements u {
    public static final BdUniqueId dbZ = BdUniqueId.gen();
    private boolean bDM;
    private PersonTainInfo dca;
    private UserData mUserData;

    public UserData getUserData() {
        return this.mUserData;
    }

    public void f(UserData userData) {
        this.mUserData = userData;
    }

    public boolean getIsSelf() {
        return this.bDM;
    }

    public void setIsSelf(boolean z) {
        this.bDM = z;
    }

    public void b(PersonTainInfo personTainInfo) {
        this.dca = personTainInfo;
    }

    public PersonTainInfo aup() {
        return this.dca;
    }

    @Override // com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return dbZ;
    }
}
