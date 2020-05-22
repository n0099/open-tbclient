package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.o;
/* loaded from: classes9.dex */
public class c implements o {
    public static final BdUniqueId kjS = BdUniqueId.gen();
    private int kjT = 0;

    public int cMX() {
        return this.kjT;
    }

    @Override // com.baidu.adp.widget.ListView.o
    public BdUniqueId getType() {
        return kjS;
    }
}
