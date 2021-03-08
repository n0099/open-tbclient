package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.n;
/* loaded from: classes2.dex */
public class c implements n {
    public static final BdUniqueId muK = BdUniqueId.gen();
    private int muL = 0;

    public int dwF() {
        return this.muL;
    }

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return muK;
    }
}
