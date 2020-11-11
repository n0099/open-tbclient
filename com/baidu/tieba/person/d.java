package com.baidu.tieba.person;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
/* loaded from: classes.dex */
public class d implements q {
    public static final BdUniqueId lTS = BdUniqueId.gen();
    public int backgroundId;
    public int lQU;
    public int lQV;

    public d() {
    }

    public d(int i, int i2) {
        this.lQU = i;
        this.lQV = i2;
    }

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return lTS;
    }
}
