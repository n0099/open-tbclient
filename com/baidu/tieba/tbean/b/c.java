package com.baidu.tieba.tbean.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tieba.card.data.BaseCardInfo;
import tbclient.GetIconList.Custom;
import tbclient.GetIconList.Setting;
import tbclient.GetIconList.UserInfo;
/* loaded from: classes9.dex */
public class c extends BaseCardInfo implements n {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    public Custom nCq;
    public Setting nCr;
    public UserInfo userInfo;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return TYPE;
    }
}
