package com.baidu.tieba.person;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
/* loaded from: classes.dex */
public class d implements m {
    public static final BdUniqueId iil = BdUniqueId.gen();
    public int cxE;
    public int ieC;
    public int ieD;

    public d() {
    }

    public d(int i, int i2) {
        this.ieC = i;
        this.ieD = i2;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return iil;
    }
}
