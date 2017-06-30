package com.baidu.tieba.person;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class d extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId baj = BdUniqueId.gen();
    public long audienceCount;
    public String eQa;
    public String liveCover;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return baj;
    }
}
