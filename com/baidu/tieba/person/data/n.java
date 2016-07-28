package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.personInfo.PersonTainInfo;
/* loaded from: classes.dex */
public class n implements v {
    public static final BdUniqueId eso = BdUniqueId.gen();
    private boolean cjo;
    private PersonTainInfo esp;
    private UserData mUserData;

    public UserData getUserData() {
        return this.mUserData;
    }

    public void f(UserData userData) {
        this.mUserData = userData;
    }

    public boolean getIsSelf() {
        return this.cjo;
    }

    public void setIsSelf(boolean z) {
        this.cjo = z;
    }

    public void b(PersonTainInfo personTainInfo) {
        this.esp = personTainInfo;
    }

    public PersonTainInfo aNM() {
        return this.esp;
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return eso;
    }
}
