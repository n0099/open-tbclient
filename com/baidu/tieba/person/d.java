package com.baidu.tieba.person;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.o;
/* loaded from: classes.dex */
public class d implements o {
    public static final BdUniqueId kjx = BdUniqueId.gen();
    public int backgroundId;
    public int kgA;
    public int kgz;

    public d() {
    }

    public d(int i, int i2) {
        this.kgz = i;
        this.kgA = i2;
    }

    @Override // com.baidu.adp.widget.ListView.o
    public BdUniqueId getType() {
        return kjx;
    }
}
