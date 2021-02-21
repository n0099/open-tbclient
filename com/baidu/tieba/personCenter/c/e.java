package com.baidu.tieba.personCenter.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes2.dex */
public class e extends BaseCardInfo implements com.baidu.adp.widget.ListView.n {
    public static BdUniqueId mtU = BdUniqueId.gen();

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return mtU;
    }
}
