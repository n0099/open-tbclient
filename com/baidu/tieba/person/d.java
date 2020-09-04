package com.baidu.tieba.person;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
/* loaded from: classes.dex */
public class d implements q {
    public static final BdUniqueId ldq = BdUniqueId.gen();
    public int backgroundId;
    public int lar;
    public int las;

    public d() {
    }

    public d(int i, int i2) {
        this.lar = i;
        this.las = i2;
    }

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return ldq;
    }
}
