package com.baidu.tieba.person;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
/* loaded from: classes.dex */
public class d implements m {
    public static final BdUniqueId hKi = BdUniqueId.gen();
    public int coe;
    public int hGA;
    public int hGB;

    public d() {
    }

    public d(int i, int i2) {
        this.hGA = i;
        this.hGB = i2;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return hKi;
    }
}
