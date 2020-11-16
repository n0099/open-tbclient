package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
/* loaded from: classes21.dex */
public class c implements q {
    public static final BdUniqueId lUF = BdUniqueId.gen();
    private int lUG = 0;

    public int dsP() {
        return this.lUG;
    }

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return lUF;
    }
}
