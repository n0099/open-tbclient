package com.baidu.tieba.person;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.i;
/* loaded from: classes.dex */
public class d implements i {
    public static final BdUniqueId gel = BdUniqueId.gen();
    public int bvA;
    public int fZm;
    public int fZn;

    public d() {
    }

    public d(int i, int i2) {
        this.fZm = i;
        this.fZn = i2;
    }

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return gel;
    }
}
