package com.baidu.tieba.person;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId fcz = BdUniqueId.gen();
    public long fcA;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return fcz;
    }
}
