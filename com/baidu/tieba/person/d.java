package com.baidu.tieba.person;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
/* loaded from: classes.dex */
public class d implements m {
    public static final BdUniqueId ibT = BdUniqueId.gen();
    public int cwp;
    public int hYm;
    public int hYn;

    public d() {
    }

    public d(int i, int i2) {
        this.hYm = i;
        this.hYn = i2;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return ibT;
    }
}
