package com.baidu.tieba.tbean.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tieba.card.data.BaseCardInfo;
import tbclient.GetIconList.IconInfo;
import tbclient.GetIconList.Setting;
import tbclient.GetIconList.UserInfo;
/* loaded from: classes9.dex */
public class b extends BaseCardInfo implements n {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    public Setting nCR;
    public IconInfo nCS;
    public UserInfo userInfo;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return TYPE;
    }
}
