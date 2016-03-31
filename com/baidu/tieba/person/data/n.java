package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.u;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.personInfo.PersonTainInfo;
/* loaded from: classes.dex */
public class n implements u {
    public static final BdUniqueId dwC = BdUniqueId.gen();
    private boolean bJj;
    private PersonTainInfo dwD;
    private UserData mUserData;

    public UserData getUserData() {
        return this.mUserData;
    }

    public void f(UserData userData) {
        this.mUserData = userData;
    }

    public boolean getIsSelf() {
        return this.bJj;
    }

    public void setIsSelf(boolean z) {
        this.bJj = z;
    }

    public void b(PersonTainInfo personTainInfo) {
        this.dwD = personTainInfo;
    }

    public PersonTainInfo aBV() {
        return this.dwD;
    }

    @Override // com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return dwC;
    }
}
