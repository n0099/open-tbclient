package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
/* loaded from: classes22.dex */
public class c implements q {
    public static final BdUniqueId lUn = BdUniqueId.gen();
    private int lUo = 0;

    public int dtp() {
        return this.lUo;
    }

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return lUn;
    }
}
