package com.baidu.tieba.personCenter.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.o;
/* loaded from: classes9.dex */
public class e extends com.baidu.tieba.card.data.b implements o {
    public static BdUniqueId klf = BdUniqueId.gen();

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.o
    public BdUniqueId getType() {
        return klf;
    }
}
