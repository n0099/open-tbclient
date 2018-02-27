package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.i;
/* loaded from: classes.dex */
public class c implements i {
    public static final BdUniqueId gia = BdUniqueId.gen();
    private int gib = 0;

    public int biA() {
        return this.gib;
    }

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return gia;
    }
}
