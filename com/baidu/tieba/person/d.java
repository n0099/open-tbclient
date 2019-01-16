package com.baidu.tieba.person;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.h;
/* loaded from: classes.dex */
public class d implements h {
    public static final BdUniqueId gtS = BdUniqueId.gen();
    public int beA;
    public int gqj;
    public int gqk;

    public d() {
    }

    public d(int i, int i2) {
        this.gqj = i;
        this.gqk = i2;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return gtS;
    }
}
