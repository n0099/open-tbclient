package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
/* loaded from: classes9.dex */
public class c implements q {
    public static final BdUniqueId kEK = BdUniqueId.gen();
    private int kEL = 0;

    public int cRE() {
        return this.kEL;
    }

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return kEK;
    }
}
