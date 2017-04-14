package com.baidu.tieba.personCenter.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
/* loaded from: classes.dex */
public class b implements v {
    public static final BdUniqueId eAR = BdUniqueId.gen();
    public int eAS;
    public int ewe;
    public int ewf;

    public b() {
    }

    public b(int i, int i2) {
        this.ewe = i;
        this.ewf = i2;
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return eAR;
    }
}
