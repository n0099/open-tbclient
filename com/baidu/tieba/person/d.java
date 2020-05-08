package com.baidu.tieba.person;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
/* loaded from: classes.dex */
public class d implements m {
    public static final BdUniqueId jRE = BdUniqueId.gen();
    public int backgroundId;
    public int jOH;
    public int jOI;

    public d() {
    }

    public d(int i, int i2) {
        this.jOH = i;
        this.jOI = i2;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return jRE;
    }
}
