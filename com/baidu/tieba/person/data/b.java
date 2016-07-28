package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
/* loaded from: classes.dex */
public class b implements v {
    public static final BdUniqueId erK = BdUniqueId.gen();
    private int erL = 0;

    public int aND() {
        return this.erL;
    }

    public void og(int i) {
        this.erL = i;
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return erK;
    }
}
