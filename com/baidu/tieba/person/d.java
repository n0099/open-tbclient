package com.baidu.tieba.person;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
/* loaded from: classes.dex */
public class d implements m {
    public static final BdUniqueId hKd = BdUniqueId.gen();
    public int coe;
    public int hGv;
    public int hGw;

    public d() {
    }

    public d(int i, int i2) {
        this.hGv = i;
        this.hGw = i2;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return hKd;
    }
}
