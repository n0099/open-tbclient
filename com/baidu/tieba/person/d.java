package com.baidu.tieba.person;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.n;
/* loaded from: classes.dex */
public class d implements n {
    public static final BdUniqueId mun = BdUniqueId.gen();
    public int backgroundId;
    public int mrr;
    public int mrs;

    public d() {
    }

    public d(int i, int i2) {
        this.mrr = i;
        this.mrs = i2;
    }

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return mun;
    }
}
