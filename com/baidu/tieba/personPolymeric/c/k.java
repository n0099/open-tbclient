package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes24.dex */
public class k extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId lLf = BdUniqueId.gen();
    public int paddingBottom;
    public int paddingLeft;
    public int paddingTop;
    public int titleId;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return lLf;
    }
}
