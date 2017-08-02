package com.baidu.tieba.person;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class d extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId bbD = BdUniqueId.gen();
    public long audienceCount;
    public String fcB;
    public String liveCover;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return bbD;
    }
}
