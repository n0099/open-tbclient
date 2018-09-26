package com.baidu.tieba.person;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.h;
/* loaded from: classes.dex */
public class d implements h {
    public static final BdUniqueId gai = BdUniqueId.gen();
    public int aVb;
    public int fWA;
    public int fWz;

    public d() {
    }

    public d(int i, int i2) {
        this.fWz = i;
        this.fWA = i2;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return gai;
    }
}
