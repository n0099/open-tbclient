package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.personInfo.PersonInfoPostList;
import com.baidu.tieba.personInfo.PersonTainInfo;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class n extends a {
    public static final BdUniqueId cSi = BdUniqueId.gen();
    private boolean bAA = true;
    private List<PersonInfoPostList> cQY = new ArrayList();
    private PersonTainInfo cSd;
    private UserData mUserData;

    @Override // com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return cSi;
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
        this.cQY = list;
    }

    public List<PersonInfoPostList> apw() {
        return this.cQY;
    }

    public void f(UserData userData) {
        this.mUserData = userData;
    }

    public UserData getUserData() {
        return this.mUserData;
    }

    public void setIsSelf(boolean z) {
        this.bAA = z;
    }

    public boolean getIsSelf() {
        return this.bAA;
    }

    public int getSex() {
        if (this.mUserData != null) {
            return this.mUserData.getSex();
        }
        return 0;
    }

    public void a(PersonTainInfo personTainInfo) {
        this.cSd = personTainInfo;
    }

    public PersonTainInfo apt() {
        return this.cSd;
    }

    public com.baidu.tbadk.data.f apu() {
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
