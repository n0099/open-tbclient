package com.baidu.tieba.person;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
/* loaded from: classes.dex */
public class h implements v {
    public static final BdUniqueId eQg = BdUniqueId.gen();
    public int eMQ;
    public int eMR;
    public int eQh;

    public h() {
    }

    public h(int i, int i2) {
        this.eMQ = i;
        this.eMR = i2;
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return eQg;
    }
}
