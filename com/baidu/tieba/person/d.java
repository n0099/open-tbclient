package com.baidu.tieba.person;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
/* loaded from: classes.dex */
public class d implements m {
    public static final BdUniqueId ibS = BdUniqueId.gen();
    public int cwo;
    public int hYl;
    public int hYm;

    public d() {
    }

    public d(int i, int i2) {
        this.hYl = i;
        this.hYm = i2;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return ibS;
    }
}
