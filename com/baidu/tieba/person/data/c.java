package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
/* loaded from: classes22.dex */
public class c implements q {
    public static final BdUniqueId miM = BdUniqueId.gen();
    private int miN = 0;

    public int dyh() {
        return this.miN;
    }

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return miM;
    }
}
