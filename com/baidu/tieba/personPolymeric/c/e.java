package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes6.dex */
public class e extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId hSa = BdUniqueId.gen();
    public String des;
    public String hRV;
    public String iconUrl;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return hSa;
    }
}
