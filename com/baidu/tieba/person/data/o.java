package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.personInfo.PersonInfoPostList;
import com.baidu.tieba.personInfo.PersonTainInfo;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class o extends a {
    public static final BdUniqueId dwE = BdUniqueId.gen();
    private boolean bJj = true;
    private List<PersonInfoPostList> dvh = new ArrayList();
    private PersonTainInfo dwz;
    private UserData mUserData;

    @Override // com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return dwE;
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
        this.dvh = list;
    }

    public List<PersonInfoPostList> aBW() {
        return this.dvh;
    }

    public void f(UserData userData) {
        this.mUserData = userData;
    }

    public UserData getUserData() {
        return this.mUserData;
    }

    public void setIsSelf(boolean z) {
        this.bJj = z;
    }

    public boolean getIsSelf() {
        return this.bJj;
    }

    public int getSex() {
        if (this.mUserData != null) {
            return this.mUserData.getSex();
        }
        return 0;
    }

    public void a(PersonTainInfo personTainInfo) {
        this.dwz = personTainInfo;
    }

    public PersonTainInfo aBS() {
        return this.dwz;
    }

    public com.baidu.tbadk.data.g aBT() {
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
