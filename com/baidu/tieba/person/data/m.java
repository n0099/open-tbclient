package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
public class m implements v {
    public static final BdUniqueId esn = BdUniqueId.gen();
    public boolean cjo;
    public String mContent;
    public String mLink;
    public String mTitle;
    public UserData mUserData;
    public String mVipIcon;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return esn;
    }
}
