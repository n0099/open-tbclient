package com.baidu.tieba.person;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
/* loaded from: classes.dex */
public class d implements m {
    public static final BdUniqueId hJQ = BdUniqueId.gen();
    public int coh;
    public int hGi;
    public int hGj;

    public d() {
    }

    public d(int i, int i2) {
        this.hGi = i;
        this.hGj = i2;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return hJQ;
    }
}
