package com.baidu.tieba.person;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
/* loaded from: classes.dex */
public class d implements m {
    public static final BdUniqueId ilm = BdUniqueId.gen();
    public int cyH;
    public int ihD;
    public int ihE;

    public d() {
    }

    public d(int i, int i2) {
        this.ihD = i;
        this.ihE = i2;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return ilm;
    }
}
