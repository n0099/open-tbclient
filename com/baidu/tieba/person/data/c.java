package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.n;
/* loaded from: classes2.dex */
public class c implements n {
    public static final BdUniqueId mnV = BdUniqueId.gen();
    private int mnW = 0;

    public int dxY() {
        return this.mnW;
    }

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return mnV;
    }
}
