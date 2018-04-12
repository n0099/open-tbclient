package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes3.dex */
public class k extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId fKB = BdUniqueId.gen();
    public int paddingBottom;
    public int paddingLeft;
    public int paddingTop;
    public int titleId;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return fKB;
    }
}
