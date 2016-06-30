package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.personInfo.PersonTainInfo;
/* loaded from: classes.dex */
public class o implements com.baidu.adp.widget.ListView.v {
    public static final BdUniqueId eik = BdUniqueId.gen();
    private boolean chd;
    private PersonTainInfo eil;
    private UserData mUserData;

    public UserData getUserData() {
        return this.mUserData;
    }

    public void f(UserData userData) {
        this.mUserData = userData;
    }

    public boolean getIsSelf() {
        return this.chd;
    }

    public void setIsSelf(boolean z) {
        this.chd = z;
    }

    public void b(PersonTainInfo personTainInfo) {
        this.eil = personTainInfo;
    }

    public PersonTainInfo aLj() {
        return this.eil;
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return eik;
    }
}
