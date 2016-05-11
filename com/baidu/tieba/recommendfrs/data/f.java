package com.baidu.tieba.recommendfrs.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.au;
/* loaded from: classes.dex */
public class f extends c {
    public static final BdUniqueId dZR = BdUniqueId.gen();

    @Override // com.baidu.tieba.card.a.i, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return dZR;
    }

    public f() {
        setStType(au.Kb());
        setYuelaouLocate("percard#");
    }
}
