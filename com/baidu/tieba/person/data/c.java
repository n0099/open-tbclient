package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.i;
/* loaded from: classes.dex */
public class c implements i {
    public static final BdUniqueId gim = BdUniqueId.gen();
    private int gin = 0;

    public int biB() {
        return this.gin;
    }

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return gim;
    }
}
