package com.baidu.tieba.recommendfrs.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.au;
/* loaded from: classes.dex */
public class b extends c {
    public static final BdUniqueId dZP = BdUniqueId.gen();

    @Override // com.baidu.tieba.card.a.i, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return dZP;
    }

    public b() {
        setStType(au.Kb());
        setYuelaouLocate("ptrcard#");
    }
}
