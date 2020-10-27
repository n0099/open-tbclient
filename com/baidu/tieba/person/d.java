package com.baidu.tieba.person;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
/* loaded from: classes.dex */
public class d implements q {
    public static final BdUniqueId lNW = BdUniqueId.gen();
    public int backgroundId;
    public int lKY;
    public int lKZ;

    public d() {
    }

    public d(int i, int i2) {
        this.lKY = i;
        this.lKZ = i2;
    }

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return lNW;
    }
}
