package com.baidu.tieba.person;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
/* loaded from: classes.dex */
public class d implements m {
    public static final BdUniqueId jRA = BdUniqueId.gen();
    public int backgroundId;
    public int jOD;
    public int jOE;

    public d() {
    }

    public d(int i, int i2) {
        this.jOD = i;
        this.jOE = i2;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return jRA;
    }
}
