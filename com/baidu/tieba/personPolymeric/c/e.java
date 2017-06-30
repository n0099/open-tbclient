package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class e extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId eWB = BdUniqueId.gen();
    public String cLo;
    public String des;
    public String iconUrl;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return eWB;
    }
}
