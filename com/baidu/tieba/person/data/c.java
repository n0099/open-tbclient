package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
/* loaded from: classes16.dex */
public class c implements q {
    public static final BdUniqueId ldE = BdUniqueId.gen();
    private int ldF = 0;

    public int dgs() {
        return this.ldF;
    }

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return ldE;
    }
}
