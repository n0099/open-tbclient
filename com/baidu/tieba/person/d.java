package com.baidu.tieba.person;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
/* loaded from: classes.dex */
public class d implements m {
    public static final BdUniqueId jeJ = BdUniqueId.gen();
    public int backgroundId;
    public int jbf;
    public int jbg;

    public d() {
    }

    public d(int i, int i2) {
        this.jbf = i;
        this.jbg = i2;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return jeJ;
    }
}
