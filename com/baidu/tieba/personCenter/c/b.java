package com.baidu.tieba.personCenter.c;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class b extends com.baidu.tieba.card.data.b implements com.baidu.adp.widget.ListView.f {
    public static BdUniqueId fas = BdUniqueId.gen();

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return fas;
    }
}
