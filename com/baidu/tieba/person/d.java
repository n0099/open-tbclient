package com.baidu.tieba.person;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
/* loaded from: classes.dex */
public class d implements m {
    public static final BdUniqueId ijW = BdUniqueId.gen();
    public int backgroundId;
    public int ign;
    public int igo;

    public d() {
    }

    public d(int i, int i2) {
        this.ign = i;
        this.igo = i2;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return ijW;
    }
}
