package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.n;
/* loaded from: classes2.dex */
public class c implements n {
    public static final BdUniqueId msI = BdUniqueId.gen();
    private int msJ = 0;

    public int dww() {
        return this.msJ;
    }

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return msI;
    }
}
