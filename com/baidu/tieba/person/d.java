package com.baidu.tieba.person;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class d implements com.baidu.adp.widget.ListView.f {
    public static final BdUniqueId eYX = BdUniqueId.gen();
    public int aGy;
    public int eVT;
    public int eVU;

    public d() {
    }

    public d(int i, int i2) {
        this.eVT = i;
        this.eVU = i2;
    }

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return eYX;
    }
}
