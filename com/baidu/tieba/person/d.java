package com.baidu.tieba.person;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class d implements com.baidu.adp.widget.ListView.f {
    public static final BdUniqueId frp = BdUniqueId.gen();
    public int aHJ;
    public int fmn;
    public int fmo;

    public d() {
    }

    public d(int i, int i2) {
        this.fmn = i;
        this.fmo = i2;
    }

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return frp;
    }
}
