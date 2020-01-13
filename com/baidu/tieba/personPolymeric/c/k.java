package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes9.dex */
public class k extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId jnV = BdUniqueId.gen();
    public int fMd;
    public int jnW;
    public int paddingLeft;
    public int titleId;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return jnV;
    }
}
