package com.baidu.tieba.person;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.n;
/* loaded from: classes.dex */
public class d implements n {
    public static final BdUniqueId mrV = BdUniqueId.gen();
    public int backgroundId;
    public int mpa;
    public int mpb;

    public d() {
    }

    public d(int i, int i2) {
        this.mpa = i;
        this.mpb = i2;
    }

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return mrV;
    }
}
