package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
public class n implements v {
    public static final BdUniqueId dzF = BdUniqueId.gen();
    private boolean bJq;
    private String mContent;
    private String mLink;
    private UserData mUserData;
    private String mVipIcon;

    public UserData getUserData() {
        return this.mUserData;
    }

    public boolean getIsSelf() {
        return this.bJq;
    }

    public String getVipIcon() {
        return this.mVipIcon;
    }

    public String getVipLink() {
        return this.mLink;
    }

    public String getVipContent() {
        return this.mContent;
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return dzF;
    }
}
