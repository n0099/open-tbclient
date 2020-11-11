package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes24.dex */
public class h extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId mdx = BdUniqueId.gen();
    public int width = 0;
    public int height = 0;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return mdx;
    }
}
