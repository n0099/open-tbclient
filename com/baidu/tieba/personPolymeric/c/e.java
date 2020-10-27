package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes24.dex */
public class e extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId lXr = BdUniqueId.gen();
    public String des;
    public String iconUrl;
    public String jrg;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return lXr;
    }
}
