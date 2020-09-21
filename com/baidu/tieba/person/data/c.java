package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
/* loaded from: classes21.dex */
public class c implements q {
    public static final BdUniqueId lmC = BdUniqueId.gen();
    private int lmD = 0;

    public int djW() {
        return this.lmD;
    }

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return lmC;
    }
}
