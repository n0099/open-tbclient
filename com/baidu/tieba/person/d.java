package com.baidu.tieba.person;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
/* loaded from: classes.dex */
public class d implements m {
    public static final BdUniqueId ijf = BdUniqueId.gen();
    public int backgroundId;
    public int ifw;
    public int ifx;

    public d() {
    }

    public d(int i, int i2) {
        this.ifw = i;
        this.ifx = i2;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return ijf;
    }
}
