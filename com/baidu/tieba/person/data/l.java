package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.personInfo.PersonInfoPostList;
import com.baidu.tieba.personInfo.PersonTainInfo;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class l extends a {
    public static final BdUniqueId cNC = BdUniqueId.gen();
    private boolean bwJ = true;
    private List<PersonInfoPostList> cME = new ArrayList();
    private PersonTainInfo cNx;
    private UserData mUserData;

    @Override // com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return cNC;
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
        this.cME = list;
    }

    public List<PersonInfoPostList> aom() {
        return this.cME;
    }

    public void f(UserData userData) {
        this.mUserData = userData;
    }

    public UserData getUserData() {
        return this.mUserData;
    }

    public void setIsSelf(boolean z) {
        this.bwJ = z;
    }

    public boolean getIsSelf() {
        return this.bwJ;
    }

    public int getSex() {
        if (this.mUserData != null) {
            return this.mUserData.getSex();
        }
        return 0;
    }

    public void a(PersonTainInfo personTainInfo) {
        this.cNx = personTainInfo;
    }

    public PersonTainInfo aoj() {
        return this.cNx;
    }

    public com.baidu.tbadk.data.f aok() {
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
