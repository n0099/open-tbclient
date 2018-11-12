package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.h;
/* loaded from: classes5.dex */
public class c implements h {
    public static final BdUniqueId gjH = BdUniqueId.gen();
    private int gjI = 0;

    public int bmD() {
        return this.gjI;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return gjH;
    }
}
