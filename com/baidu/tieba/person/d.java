package com.baidu.tieba.person;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.n;
/* loaded from: classes.dex */
public class d implements n {
    public static final BdUniqueId mnz = BdUniqueId.gen();
    public int backgroundId;
    public int mkE;
    public int mkF;

    public d() {
    }

    public d(int i, int i2) {
        this.mkE = i;
        this.mkF = i2;
    }

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return mnz;
    }
}
