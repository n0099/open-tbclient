package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
public class n implements com.baidu.adp.widget.ListView.v {
    public static final BdUniqueId eij = BdUniqueId.gen();
    public boolean chd;
    public String mContent;
    public String mLink;
    public String mTitle;
    public UserData mUserData;
    public String mVipIcon;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return eij;
    }
}
