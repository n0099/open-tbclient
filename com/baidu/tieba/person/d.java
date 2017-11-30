package com.baidu.tieba.person;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class d implements com.baidu.adp.widget.ListView.f {
    public static final BdUniqueId fqs = BdUniqueId.gen();
    public int aHF;
    public int flp;
    public int flq;

    public d() {
    }

    public d(int i, int i2) {
        this.flp = i;
        this.flq = i2;
    }

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return fqs;
    }
}
