package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import java.util.List;
/* loaded from: classes8.dex */
public class m extends BaseCardInfo {
    public static final BdUniqueId mxp = BdUniqueId.gen();
    public List<com.baidu.adp.widget.ListView.n> mxq;
    public long uid;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return mxp;
    }
}
