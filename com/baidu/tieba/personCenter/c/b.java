package com.baidu.tieba.personCenter.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
/* loaded from: classes.dex */
public class b implements v {
    public static final BdUniqueId eDy = BdUniqueId.gen();
    public int eDz;
    public int eyb;
    public int eyc;

    public b() {
    }

    public b(int i, int i2) {
        this.eyb = i;
        this.eyc = i2;
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return eDy;
    }
}
