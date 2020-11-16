package com.baidu.tieba.person;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
/* loaded from: classes.dex */
public class d implements q {
    public static final BdUniqueId lUi = BdUniqueId.gen();
    public int backgroundId;
    public int lRk;
    public int lRl;

    public d() {
    }

    public d(int i, int i2) {
        this.lRk = i;
        this.lRl = i2;
    }

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return lUi;
    }
}
