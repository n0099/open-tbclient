package com.baidu.tieba.person;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.h;
/* loaded from: classes.dex */
public class d implements h {
    public static final BdUniqueId gpX = BdUniqueId.gen();
    public int bdL;
    public int gmo;
    public int gmp;

    public d() {
    }

    public d(int i, int i2) {
        this.gmo = i;
        this.gmp = i2;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return gpX;
    }
}
