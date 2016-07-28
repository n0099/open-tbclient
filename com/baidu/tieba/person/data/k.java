package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.data.MyGroup;
import com.baidu.tieba.personInfo.PersonTainInfo;
import java.util.List;
/* loaded from: classes.dex */
public class k extends a {
    public static final BdUniqueId esk = BdUniqueId.gen();
    private boolean cjo = true;
    private PersonTainInfo esl;
    private UserData mUserData;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return esk;
    }

    public List<MyGroup> aNI() {
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
        this.cjo = z;
    }

    public boolean getIsSelf() {
        return this.cjo;
    }

    public int getSex() {
        if (this.mUserData != null) {
            return this.mUserData.getSex();
        }
        return 0;
    }

    public void a(PersonTainInfo personTainInfo) {
        this.esl = personTainInfo;
    }

    public PersonTainInfo aNJ() {
        return this.esl;
    }

    public com.baidu.tbadk.data.j aNK() {
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
