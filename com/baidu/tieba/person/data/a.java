package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
/* loaded from: classes.dex */
public class a implements v {
    public static final BdUniqueId eBW = BdUniqueId.gen();
    private int eBX = 0;

    public int aSf() {
        return this.eBX;
    }

    public void oI(int i) {
        this.eBX = i;
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return eBW;
    }
}
