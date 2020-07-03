package com.baidu.tieba.person;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
/* loaded from: classes.dex */
public class d implements q {
    public static final BdUniqueId kEp = BdUniqueId.gen();
    public int backgroundId;
    public int kBs;
    public int kBt;

    public d() {
    }

    public d(int i, int i2) {
        this.kBs = i;
        this.kBt = i2;
    }

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return kEp;
    }
}
