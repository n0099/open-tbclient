package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes23.dex */
public class j extends BaseCardInfo {
    public static final BdUniqueId mdR = BdUniqueId.gen();
    public boolean idc;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return mdR;
    }
}
