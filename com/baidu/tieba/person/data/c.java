package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
/* loaded from: classes22.dex */
public class c implements q {
    public static final BdUniqueId lOr = BdUniqueId.gen();
    private int lOs = 0;

    public int dqN() {
        return this.lOs;
    }

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return lOr;
    }
}
