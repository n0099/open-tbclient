package com.baidu.tieba.person;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.h;
/* loaded from: classes.dex */
public class d implements h {
    public static final BdUniqueId ghK = BdUniqueId.gen();
    public int aZA;
    public int gea;
    public int geb;

    public d() {
    }

    public d(int i, int i2) {
        this.gea = i;
        this.geb = i2;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return ghK;
    }
}
