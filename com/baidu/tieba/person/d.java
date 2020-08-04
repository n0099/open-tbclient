package com.baidu.tieba.person;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
/* loaded from: classes.dex */
public class d implements q {
    public static final BdUniqueId kNt = BdUniqueId.gen();
    public int backgroundId;
    public int kKw;
    public int kKx;

    public d() {
    }

    public d(int i, int i2) {
        this.kKw = i;
        this.kKx = i2;
    }

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return kNt;
    }
}
