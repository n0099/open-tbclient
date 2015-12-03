package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.u;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.personInfo.PersonTainInfo;
/* loaded from: classes.dex */
public class k implements u {
    public static final BdUniqueId cNA = BdUniqueId.gen();
    private boolean bwJ;
    private PersonTainInfo cNB;
    private UserData mUserData;

    public UserData getUserData() {
        return this.mUserData;
    }

    public void f(UserData userData) {
        this.mUserData = userData;
    }

    public boolean getIsSelf() {
        return this.bwJ;
    }

    public void setIsSelf(boolean z) {
        this.bwJ = z;
    }

    public void b(PersonTainInfo personTainInfo) {
        this.cNB = personTainInfo;
    }

    public PersonTainInfo aol() {
        return this.cNB;
    }

    @Override // com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return cNA;
    }
}
