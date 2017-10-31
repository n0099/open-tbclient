package com.baidu.tieba.person;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class d implements com.baidu.adp.widget.ListView.f {
    public static final BdUniqueId fgZ = BdUniqueId.gen();
    public int aGV;
    public int fdT;
    public int fdU;

    public d() {
    }

    public d(int i, int i2) {
        this.fdT = i;
        this.fdU = i2;
    }

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return fgZ;
    }
}
