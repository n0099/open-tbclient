package com.baidu.tieba.person;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.h;
/* loaded from: classes.dex */
public class d implements h {
    public static final BdUniqueId fCm = BdUniqueId.gen();
    public int aIp;
    public int fyE;
    public int fyF;

    public d() {
    }

    public d(int i, int i2) {
        this.fyE = i;
        this.fyF = i2;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return fCm;
    }
}
