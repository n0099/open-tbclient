package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
/* loaded from: classes.dex */
public class a implements v {
    public static final BdUniqueId exU = BdUniqueId.gen();
    private int exV = 0;

    public int aOE() {
        return this.exV;
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return exU;
    }
}
