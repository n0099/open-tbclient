package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.personInfo.PersonInfoPostList;
import com.baidu.tieba.personInfo.PersonTainInfo;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class p extends a {
    public static final BdUniqueId eim = BdUniqueId.gen();
    private boolean chd = true;
    private List<PersonInfoPostList> egz = new ArrayList();
    private PersonTainInfo eih;
    private UserData mUserData;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return eim;
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
        this.egz = list;
    }

    public List<PersonInfoPostList> aLk() {
        return this.egz;
    }

    public void f(UserData userData) {
        this.mUserData = userData;
    }

    public UserData getUserData() {
        return this.mUserData;
    }

    public void setIsSelf(boolean z) {
        this.chd = z;
    }

    public boolean getIsSelf() {
        return this.chd;
    }

    public int getSex() {
        if (this.mUserData != null) {
            return this.mUserData.getSex();
        }
        return 0;
    }

    public void a(PersonTainInfo personTainInfo) {
        this.eih = personTainInfo;
    }

    public PersonTainInfo aLg() {
        return this.eih;
    }

    public com.baidu.tbadk.data.j aLh() {
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
