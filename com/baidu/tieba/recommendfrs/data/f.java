package com.baidu.tieba.recommendfrs.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.ae;
/* loaded from: classes.dex */
public class f extends c {
    public static final BdUniqueId dEK = BdUniqueId.gen();

    @Override // com.baidu.tieba.card.a.m, com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return dEK;
    }

    public f() {
        setStType(ae.JV());
        setYuelaouLocate("percard#");
    }
}
