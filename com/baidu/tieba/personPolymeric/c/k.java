package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes11.dex */
public class k extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId kba = BdUniqueId.gen();
    public int paddingBottom;
    public int paddingLeft;
    public int paddingTop;
    public int titleId;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return kba;
    }
}
