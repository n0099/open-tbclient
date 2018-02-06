package com.baidu.tieba.person;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.i;
/* loaded from: classes.dex */
public class d implements i {
    public static final BdUniqueId ghO = BdUniqueId.gen();
    public int byc;
    public int gem;
    public int gen;

    public d() {
    }

    public d(int i, int i2) {
        this.gem = i;
        this.gen = i2;
    }

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return ghO;
    }
}
