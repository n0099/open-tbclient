package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.u;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.personInfo.PersonTainInfo;
/* loaded from: classes.dex */
public class m implements u {
    public static final BdUniqueId cSg = BdUniqueId.gen();
    private boolean bAA;
    private PersonTainInfo cSh;
    private UserData mUserData;

    public UserData getUserData() {
        return this.mUserData;
    }

    public void f(UserData userData) {
        this.mUserData = userData;
    }

    public boolean getIsSelf() {
        return this.bAA;
    }

    public void setIsSelf(boolean z) {
        this.bAA = z;
    }

    public void b(PersonTainInfo personTainInfo) {
        this.cSh = personTainInfo;
    }

    public PersonTainInfo apv() {
        return this.cSh;
    }

    @Override // com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return cSg;
    }
}
