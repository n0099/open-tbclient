package com.baidu.tieba.recommendfrs.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.x;
/* loaded from: classes.dex */
public class e extends b {
    public static final BdUniqueId dpe = BdUniqueId.gen();

    @Override // com.baidu.tieba.card.a.j, com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return dpe;
    }

    public e() {
        setStType(x.In());
        setYuelaouLocate("percard#");
    }
}
