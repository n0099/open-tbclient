package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes3.dex */
public class e extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId gpK = BdUniqueId.gen();
    public String des;
    public String gpF;
    public String iconUrl;

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return gpK;
    }
}
