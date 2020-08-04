package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes18.dex */
public class e extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId kWK = BdUniqueId.gen();
    public String des;
    public String iSY;
    public String iconUrl;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return kWK;
    }
}
