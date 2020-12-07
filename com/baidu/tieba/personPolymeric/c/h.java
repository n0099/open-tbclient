package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes24.dex */
public class h extends BaseCardInfo {
    public static final BdUniqueId mrV = BdUniqueId.gen();
    public int width = 0;
    public int height = 0;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return mrV;
    }
}
