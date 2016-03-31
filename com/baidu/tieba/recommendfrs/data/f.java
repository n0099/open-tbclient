package com.baidu.tieba.recommendfrs.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.bc;
/* loaded from: classes.dex */
public class f extends c {
    public static final BdUniqueId dWH = BdUniqueId.gen();

    @Override // com.baidu.tieba.card.a.n, com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return dWH;
    }

    public f() {
        setStType(bc.Ls());
        setYuelaouLocate("percard#");
    }
}
