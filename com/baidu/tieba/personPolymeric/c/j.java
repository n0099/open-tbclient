package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes24.dex */
public class j extends BaseCardInfo {
    public static final BdUniqueId mrX = BdUniqueId.gen();
    public boolean ioa;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return mrX;
    }
}
