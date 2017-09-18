package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class e extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId flx = BdUniqueId.gen();
    public String deN;
    public String des;
    public String iconUrl;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return flx;
    }
}
