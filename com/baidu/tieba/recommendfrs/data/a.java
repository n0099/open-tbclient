package com.baidu.tieba.recommendfrs.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.x;
/* loaded from: classes.dex */
public class a extends b {
    public static final BdUniqueId dpc = BdUniqueId.gen();

    @Override // com.baidu.tieba.card.a.j, com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return dpc;
    }

    public a() {
        setStType(x.In());
        setYuelaouLocate("ptrcard#");
    }
}
