package com.baidu.tieba.person;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class d implements com.baidu.adp.widget.ListView.f {
    public static final BdUniqueId frv = BdUniqueId.gen();
    public int aHM;
    public int fms;
    public int fmt;

    public d() {
    }

    public d(int i, int i2) {
        this.fms = i;
        this.fmt = i2;
    }

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return frv;
    }
}
