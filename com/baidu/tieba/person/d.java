package com.baidu.tieba.person;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
/* loaded from: classes.dex */
public class d implements m {
    public static final BdUniqueId ibP = BdUniqueId.gen();
    public int cwo;
    public int hYi;
    public int hYj;

    public d() {
    }

    public d(int i, int i2) {
        this.hYi = i;
        this.hYj = i2;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return ibP;
    }
}
