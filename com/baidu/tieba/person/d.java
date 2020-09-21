package com.baidu.tieba.person;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
/* loaded from: classes.dex */
public class d implements q {
    public static final BdUniqueId lmh = BdUniqueId.gen();
    public int backgroundId;
    public int ljj;
    public int ljk;

    public d() {
    }

    public d(int i, int i2) {
        this.ljj = i;
        this.ljk = i2;
    }

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return lmh;
    }
}
