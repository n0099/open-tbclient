package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.i;
/* loaded from: classes.dex */
public class c implements i {
    public static final BdUniqueId geJ = BdUniqueId.gen();
    private int geK = 0;

    public int bhp() {
        return this.geK;
    }

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return geJ;
    }
}
