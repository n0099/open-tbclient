package com.baidu.tieba.personCenter.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
/* loaded from: classes.dex */
public class b implements v {
    public static final BdUniqueId eMa = BdUniqueId.gen();
    public int eGR;
    public int eGS;
    public int eMb;

    public b() {
    }

    public b(int i, int i2) {
        this.eGR = i;
        this.eGS = i2;
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return eMa;
    }
}
