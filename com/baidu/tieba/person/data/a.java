package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
/* loaded from: classes.dex */
public class a implements v {
    public static final BdUniqueId eQB = BdUniqueId.gen();
    private int eQC = 0;

    public int aTV() {
        return this.eQC;
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return eQB;
    }
}
