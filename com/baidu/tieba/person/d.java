package com.baidu.tieba.person;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.i;
/* loaded from: classes.dex */
public class d implements i {
    public static final BdUniqueId ggg = BdUniqueId.gen();
    public int bvS;
    public int gbi;
    public int gbj;

    public d() {
    }

    public d(int i, int i2) {
        this.gbi = i;
        this.gbj = i2;
    }

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return ggg;
    }
}
