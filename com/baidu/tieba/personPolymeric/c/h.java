package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes11.dex */
public class h extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId ksP = BdUniqueId.gen();
    public int width = 0;
    public int height = 0;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.o
    public BdUniqueId getType() {
        return ksP;
    }
}
