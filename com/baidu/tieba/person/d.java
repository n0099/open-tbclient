package com.baidu.tieba.person;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.h;
/* loaded from: classes.dex */
public class d implements h {
    public static final BdUniqueId ghJ = BdUniqueId.gen();
    public int aZA;
    public int gdZ;
    public int gea;

    public d() {
    }

    public d(int i, int i2) {
        this.gdZ = i;
        this.gea = i2;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return ghJ;
    }
}
