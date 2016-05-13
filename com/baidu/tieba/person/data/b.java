package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
/* loaded from: classes.dex */
public class b implements v {
    public static final BdUniqueId dzh = BdUniqueId.gen();
    private int dzi = 0;

    public int aCh() {
        return this.dzi;
    }

    public void mu(int i) {
        this.dzi = i;
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return dzh;
    }
}
