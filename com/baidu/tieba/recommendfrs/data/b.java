package com.baidu.tieba.recommendfrs.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.bc;
/* loaded from: classes.dex */
public class b extends c {
    public static final BdUniqueId dWF = BdUniqueId.gen();

    @Override // com.baidu.tieba.card.a.n, com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return dWF;
    }

    public b() {
        setStType(bc.Ls());
        setYuelaouLocate("ptrcard#");
    }
}
