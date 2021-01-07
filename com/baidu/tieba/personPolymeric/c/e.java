package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes8.dex */
public class e extends BaseCardInfo {
    public static final BdUniqueId mxd = BdUniqueId.gen();
    public String des;
    public String iconUrl;
    public String jYM;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return mxd;
    }
}
