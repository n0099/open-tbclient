package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.personInfo.PersonTainInfo;
/* loaded from: classes.dex */
public class o implements v {
    public static final BdUniqueId dzG = BdUniqueId.gen();
    private boolean bJq;
    private PersonTainInfo dzH;
    private UserData mUserData;

    public UserData getUserData() {
        return this.mUserData;
    }

    public void f(UserData userData) {
        this.mUserData = userData;
    }

    public boolean getIsSelf() {
        return this.bJq;
    }

    public void setIsSelf(boolean z) {
        this.bJq = z;
    }

    public void b(PersonTainInfo personTainInfo) {
        this.dzH = personTainInfo;
    }

    public PersonTainInfo aCq() {
        return this.dzH;
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return dzG;
    }
}
