package com.baidu.tieba.person;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
/* loaded from: classes.dex */
public class d implements q {
    public static final BdUniqueId kNr = BdUniqueId.gen();
    public int backgroundId;
    public int kKu;
    public int kKv;

    public d() {
    }

    public d(int i, int i2) {
        this.kKu = i;
        this.kKv = i2;
    }

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return kNr;
    }
}
