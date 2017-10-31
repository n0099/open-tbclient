package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class e extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId fpg = BdUniqueId.gen();
    public String des;
    public String fpb;
    public String iconUrl;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return fpg;
    }
}
