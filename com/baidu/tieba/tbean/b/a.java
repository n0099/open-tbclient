package com.baidu.tieba.tbean.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tieba.card.data.BaseCardInfo;
import tbclient.GetIconList.Custom;
import tbclient.GetIconList.Setting;
/* loaded from: classes8.dex */
public class a extends BaseCardInfo implements n {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    public Custom nsH;
    public Setting nsI;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return TYPE;
    }
}
