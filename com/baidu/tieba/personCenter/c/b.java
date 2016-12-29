package com.baidu.tieba.personCenter.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
/* loaded from: classes.dex */
public class b implements v {
    public static final BdUniqueId epy = BdUniqueId.gen();
    public int ekH;
    public int ekI;
    public int epz;

    public b() {
    }

    public b(int i, int i2) {
        this.ekH = i;
        this.ekI = i2;
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return epy;
    }
}
