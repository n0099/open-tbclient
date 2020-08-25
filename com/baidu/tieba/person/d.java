package com.baidu.tieba.person;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
/* loaded from: classes2.dex */
public class d implements q {
    public static final BdUniqueId ldj = BdUniqueId.gen();
    public int backgroundId;
    public int lak;
    public int lal;

    public d() {
    }

    public d(int i, int i2) {
        this.lak = i;
        this.lal = i2;
    }

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return ldj;
    }
}
