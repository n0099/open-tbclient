package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes8.dex */
public class i extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId jkr = BdUniqueId.gen();
    public boolean isHost;
    public int sex;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return jkr;
    }
}
