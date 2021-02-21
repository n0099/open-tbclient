package com.baidu.tieba.person;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.n;
/* loaded from: classes.dex */
public class d implements n {
    public static final BdUniqueId msl = BdUniqueId.gen();
    public int backgroundId;
    public int mpp;
    public int mpq;

    public d() {
    }

    public d(int i, int i2) {
        this.mpp = i;
        this.mpq = i2;
    }

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return msl;
    }
}
