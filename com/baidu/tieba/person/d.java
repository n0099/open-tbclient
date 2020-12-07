package com.baidu.tieba.person;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
/* loaded from: classes.dex */
public class d implements q {
    public static final BdUniqueId mip = BdUniqueId.gen();
    public int backgroundId;
    public int mfp;
    public int mfq;

    public d() {
    }

    public d(int i, int i2) {
        this.mfp = i;
        this.mfq = i2;
    }

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return mip;
    }
}
