package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.u;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
public class l implements u {
    public static final BdUniqueId cSf = BdUniqueId.gen();
    private boolean bAA;
    private String mContent;
    private String mLink;
    private UserData mUserData;
    private String mVipIcon;

    public UserData getUserData() {
        return this.mUserData;
    }

    public void f(UserData userData) {
        this.mUserData = userData;
    }

    public boolean getIsSelf() {
        return this.bAA;
    }

    public void setIsSelf(boolean z) {
        this.bAA = z;
    }

    public void setVipIcon(String str) {
        this.mVipIcon = str;
    }

    public String getVipIcon() {
        return this.mVipIcon;
    }

    public void setVipLink(String str) {
        this.mLink = str;
    }

    public String getVipLink() {
        return this.mLink;
    }

    public void setVipContent(String str) {
        this.mContent = str;
    }

    public String getVipContent() {
        return this.mContent;
    }

    @Override // com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return cSf;
    }
}
