package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.personInfo.PersonInfoPostList;
import com.baidu.tieba.personInfo.PersonTainInfo;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class p extends a {
    public static final BdUniqueId dzI = BdUniqueId.gen();
    private boolean bJq = true;
    private List<PersonInfoPostList> dyd = new ArrayList();
    private PersonTainInfo dzD;
    private UserData mUserData;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return dzI;
    }

    public String getPortrait() {
        if (this.mUserData != null) {
            return this.mUserData.getPortrait();
        }
        return null;
    }

    public int getPostNum() {
        if (this.mUserData != null) {
            return this.mUserData.getPosts_num();
        }
        return 0;
    }

    public void d(List<PersonInfoPostList> list) {
        this.dyd = list;
    }

    public List<PersonInfoPostList> aCo() {
        return this.dyd;
    }

    public void f(UserData userData) {
        this.mUserData = userData;
    }

    public UserData getUserData() {
        return this.mUserData;
    }

    public void setIsSelf(boolean z) {
        this.bJq = z;
    }

    public boolean getIsSelf() {
        return this.bJq;
    }

    public int getSex() {
        if (this.mUserData != null) {
            return this.mUserData.getSex();
        }
        return 0;
    }

    public void a(PersonTainInfo personTainInfo) {
        this.dzD = personTainInfo;
    }

    public PersonTainInfo aCk() {
        return this.dzD;
    }

    public com.baidu.tbadk.data.h aCl() {
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
