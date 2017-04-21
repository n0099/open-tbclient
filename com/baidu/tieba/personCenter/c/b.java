package com.baidu.tieba.personCenter.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
/* loaded from: classes.dex */
public class b implements v {
    public static final BdUniqueId eDh = BdUniqueId.gen();
    public int eDi;
    public int eyw;
    public int eyx;

    public b() {
    }

    public b(int i, int i2) {
        this.eyw = i;
        this.eyx = i2;
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return eDh;
    }
}
