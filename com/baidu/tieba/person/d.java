package com.baidu.tieba.person;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.h;
/* loaded from: classes.dex */
public class d implements h {
    public static final BdUniqueId gtT = BdUniqueId.gen();
    public int beB;
    public int gqk;
    public int gql;

    public d() {
    }

    public d(int i, int i2) {
        this.gqk = i;
        this.gql = i2;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return gtT;
    }
}
