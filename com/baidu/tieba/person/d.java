package com.baidu.tieba.person;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class d implements com.baidu.adp.widget.ListView.f {
    public static final BdUniqueId fhv = BdUniqueId.gen();
    public int aHd;
    public int fep;
    public int feq;

    public d() {
    }

    public d(int i, int i2) {
        this.fep = i;
        this.feq = i2;
    }

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return fhv;
    }
}
