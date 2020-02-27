package com.baidu.tieba.person;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
/* loaded from: classes.dex */
public class d implements m {
    public static final BdUniqueId jfF = BdUniqueId.gen();
    public int backgroundId;
    public int jcL;
    public int jcM;

    public d() {
    }

    public d(int i, int i2) {
        this.jcL = i;
        this.jcM = i2;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return jfF;
    }
}
