package com.baidu.tieba.person;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.h;
/* loaded from: classes.dex */
public class d implements h {
    public static final BdUniqueId fSS = BdUniqueId.gen();
    public int aRL;
    public int fPj;
    public int fPk;

    public d() {
    }

    public d(int i, int i2) {
        this.fPj = i;
        this.fPk = i2;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return fSS;
    }
}
