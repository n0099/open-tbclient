package com.baidu.tieba.recommendfrs.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.ae;
/* loaded from: classes.dex */
public class b extends c {
    public static final BdUniqueId dEI = BdUniqueId.gen();

    @Override // com.baidu.tieba.card.a.m, com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return dEI;
    }

    public b() {
        setStType(ae.JV());
        setYuelaouLocate("ptrcard#");
    }
}
