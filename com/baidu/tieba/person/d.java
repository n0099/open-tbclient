package com.baidu.tieba.person;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.i;
/* loaded from: classes.dex */
public class d implements i {
    public static final BdUniqueId gfN = BdUniqueId.gen();
    public int bvJ;
    public int gaN;
    public int gaO;

    public d() {
    }

    public d(int i, int i2) {
        this.gaN = i;
        this.gaO = i2;
    }

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return gfN;
    }
}
