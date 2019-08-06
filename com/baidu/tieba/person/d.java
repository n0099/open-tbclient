package com.baidu.tieba.person;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
/* loaded from: classes.dex */
public class d implements m {
    public static final BdUniqueId ijn = BdUniqueId.gen();
    public int cxL;
    public int ifE;
    public int ifF;

    public d() {
    }

    public d(int i, int i2) {
        this.ifE = i;
        this.ifF = i2;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return ijn;
    }
}
