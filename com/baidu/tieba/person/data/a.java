package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
/* loaded from: classes.dex */
public class a implements v {
    public static final BdUniqueId eKy = BdUniqueId.gen();
    private int eKz = 0;

    public int aUK() {
        return this.eKz;
    }

    public void pf(int i) {
        this.eKz = i;
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return eKy;
    }
}
