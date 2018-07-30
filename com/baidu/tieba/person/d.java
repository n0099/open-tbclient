package com.baidu.tieba.person;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.h;
/* loaded from: classes.dex */
public class d implements h {
    public static final BdUniqueId fTa = BdUniqueId.gen();
    public int aRO;
    public int fPr;
    public int fPs;

    public d() {
    }

    public d(int i, int i2) {
        this.fPr = i;
        this.fPs = i2;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return fTa;
    }
}
