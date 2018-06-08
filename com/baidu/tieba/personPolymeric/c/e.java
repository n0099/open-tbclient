package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes3.dex */
public class e extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId fWG = BdUniqueId.gen();
    public String des;
    public String fWB;
    public String iconUrl;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return fWG;
    }
}
