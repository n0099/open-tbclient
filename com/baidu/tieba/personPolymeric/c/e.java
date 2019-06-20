package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes6.dex */
public class e extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId ikD = BdUniqueId.gen();
    public String des;
    public String iconUrl;
    public String iky;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return ikD;
    }
}
