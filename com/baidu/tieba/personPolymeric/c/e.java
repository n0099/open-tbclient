package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes9.dex */
public class e extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId jnQ = BdUniqueId.gen();
    public String des;
    public String iconUrl;
    public String jnL;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return jnQ;
    }
}
