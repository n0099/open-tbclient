package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes23.dex */
public class h extends BaseCardInfo {
    public static final BdUniqueId mdP = BdUniqueId.gen();
    public int width = 0;
    public int height = 0;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return mdP;
    }
}
