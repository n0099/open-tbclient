package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes3.dex */
public class e extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId grp = BdUniqueId.gen();
    public String des;
    public String grk;
    public String iconUrl;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return grp;
    }
}
