package com.baidu.tieba.person;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
/* loaded from: classes.dex */
public class d implements m {
    public static final BdUniqueId jbb = BdUniqueId.gen();
    public int backgroundId;
    public int iXx;
    public int iXy;

    public d() {
    }

    public d(int i, int i2) {
        this.iXx = i;
        this.iXy = i2;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return jbb;
    }
}
