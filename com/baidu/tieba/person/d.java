package com.baidu.tieba.person;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.h;
/* loaded from: classes.dex */
public class d implements h {
    public static final BdUniqueId fSP = BdUniqueId.gen();
    public int aRO;
    public int fPh;
    public int fPi;

    public d() {
    }

    public d(int i, int i2) {
        this.fPh = i;
        this.fPi = i2;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return fSP;
    }
}
