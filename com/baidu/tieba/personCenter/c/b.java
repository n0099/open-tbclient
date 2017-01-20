package com.baidu.tieba.personCenter.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
/* loaded from: classes.dex */
public class b implements v {
    public static final BdUniqueId ezv = BdUniqueId.gen();
    public int euC;
    public int euD;
    public int ezw;

    public b() {
    }

    public b(int i, int i2) {
        this.euC = i;
        this.euD = i2;
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return ezv;
    }
}
