package com.baidu.tieba.person;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
/* loaded from: classes.dex */
public class d implements m {
    public static final BdUniqueId jeE = BdUniqueId.gen();
    public int backgroundId;
    public int jba;
    public int jbb;

    public d() {
    }

    public d(int i, int i2) {
        this.jba = i;
        this.jbb = i2;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return jeE;
    }
}
