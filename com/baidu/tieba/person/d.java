package com.baidu.tieba.person;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
/* loaded from: classes.dex */
public class d implements m {
    public static final BdUniqueId hKj = BdUniqueId.gen();
    public int coe;
    public int hGB;
    public int hGC;

    public d() {
    }

    public d(int i, int i2) {
        this.hGB = i;
        this.hGC = i2;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return hKj;
    }
}
