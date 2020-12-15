package com.baidu.tieba.person;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
/* loaded from: classes.dex */
public class d implements q {
    public static final BdUniqueId mir = BdUniqueId.gen();
    public int backgroundId;
    public int mfr;
    public int mfs;

    public d() {
    }

    public d(int i, int i2) {
        this.mfr = i;
        this.mfs = i2;
    }

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return mir;
    }
}
